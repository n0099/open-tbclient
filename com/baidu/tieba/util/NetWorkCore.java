package com.baidu.tieba.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.Config;
import com.baidu.tieba.data.ErrorData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCore {
    private static final int BUFFERSIZE = 1024;
    private static final int CONNECTTIMEOUT = 20000;
    private static final int GETDATATIMEOUT = 20000;
    private static final int POSTDATATIMEOUT = 30000;
    private HttpURLConnection mConn;
    private Context mContext;
    private String mErrorString;
    private HashMap<String, byte[]> mFileData;
    private boolean mIsBDImage;
    private volatile boolean mIsInterrupte;
    private int mNetErrorCode;
    private ArrayList<BasicNameValuePair> mPostData;
    private boolean mRequestGzip;
    private int mRetryConnt;
    private int mServerErrorCode;
    private String mUrl;
    private static String end = "\r\n";
    private static String twoHypens = "--";
    private static String boundary = "--------7da3d81520810*";
    private static int MAX_DATA_LENG = 2097152;

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        WAP,
        NET
    }

    private void initNetWork() {
        this.mConn = null;
        this.mUrl = null;
        this.mNetErrorCode = 0;
        this.mServerErrorCode = 0;
        this.mErrorString = null;
        this.mPostData = null;
        this.mContext = null;
        this.mRequestGzip = true;
        this.mRetryConnt = 0;
        this.mIsInterrupte = false;
        this.mIsBDImage = false;
        this.mFileData = null;
    }

    public NetWorkCore() {
        initNetWork();
        this.mContext = TiebaApplication.app;
    }

    public NetWorkCore(String url) {
        initNetWork();
        this.mContext = TiebaApplication.app;
        this.mUrl = url;
    }

    public NetWorkCore(Context context, String url) {
        initNetWork();
        this.mContext = context;
        this.mUrl = url;
    }

    public void setRequestGzip(Boolean requestGzip) {
        this.mRequestGzip = requestGzip.booleanValue();
    }

    public Boolean getRequestGzip() {
        return Boolean.valueOf(this.mRequestGzip);
    }

    public static NetworkState getNetworkState(Context context) {
        NetworkState ret = NetworkState.UNAVAIL;
        try {
            ConnectivityManager cwjManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkinfo = cwjManager.getActiveNetworkInfo();
            boolean netSataus = networkinfo.isAvailable();
            if (!netSataus) {
                ret = NetworkState.UNAVAIL;
            } else if (networkinfo.getTypeName().equalsIgnoreCase("WIFI")) {
                ret = NetworkState.WIFI;
            } else if (networkinfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (networkinfo.getExtraInfo().contains("wap")) {
                    ret = NetworkState.WAP;
                } else {
                    ret = NetworkState.NET;
                }
            } else {
                ret = NetworkState.NET;
            }
        } catch (Exception e) {
        }
        return ret;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isRequestSuccess() {
        return this.mNetErrorCode == 200 && this.mServerErrorCode == 0;
    }

    public boolean isNetSuccess() {
        return this.mNetErrorCode == 200;
    }

    public int getErrorCode() {
        return this.mServerErrorCode;
    }

    public int getNetErrorCode() {
        return this.mNetErrorCode;
    }

    public String getErrorString() {
        return this.mErrorString;
    }

    public void cleanErrorString() {
        this.mErrorString = "";
    }

    public void setErrorString(String err) {
        this.mErrorString = err;
    }

    public void cancelNetConnect() {
        try {
            if (this.mConn != null) {
                this.mConn.disconnect();
            }
        } catch (Exception e) {
        } finally {
            this.mIsInterrupte = true;
        }
    }

    private HttpURLConnection getConnect(URL url) {
        Proxy p = null;
        HttpURLConnection conn = null;
        NetworkState state = getNetworkState(this.mContext);
        if (state == NetworkState.UNAVAIL) {
            return null;
        }
        if (state == NetworkState.WAP) {
            String proxyHost = android.net.Proxy.getDefaultHost();
            if (proxyHost != null) {
                p = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
            }
        }
        try {
            if (p != null) {
                conn = (HttpURLConnection) url.openConnection(p);
            } else {
                conn = (HttpURLConnection) url.openConnection();
            }
        } catch (Exception ex) {
            TiebaLog.e("Network", "getConnect", "error = " + ex.getMessage());
        }
        return conn;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [385=8, 375=7, 377=6, 378=6, 382=6, 383=6] */
    public byte[] getNetData() {
        Exception ex;
        URL url;
        byte[] output = null;
        InputStream in = null;
        try {
            try {
                this.mIsInterrupte = false;
                if (this.mPostData == null || this.mPostData.size() <= 0) {
                    url = new URL(this.mUrl);
                } else {
                    StringBuffer buffer = new StringBuffer(30);
                    buffer.append(this.mUrl);
                    if (this.mUrl.indexOf("?") < 0) {
                        buffer.append("?");
                    } else if (!this.mUrl.endsWith("?") && !this.mUrl.endsWith("&")) {
                        buffer.append("&");
                    }
                    for (int i = 0; i < this.mPostData.size(); i++) {
                        if (i != 0) {
                            buffer.append("&");
                        }
                        buffer.append(this.mPostData.get(i).getName());
                        buffer.append("=");
                        buffer.append(this.mPostData.get(i).getValue());
                    }
                    url = new URL(buffer.toString());
                }
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketException e) {
        } catch (Exception e2) {
            ex = e2;
        }
        if (this.mConn == null) {
            throw new SocketException();
        }
        this.mConn.setConnectTimeout(20000);
        this.mConn.setReadTimeout(20000);
        if (this.mRequestGzip && !this.mIsBDImage) {
            this.mConn.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (this.mIsInterrupte) {
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                    return null;
                }
                return null;
            } catch (Exception e4) {
                return null;
            }
        }
        long time = new Date().getTime();
        this.mConn.connect();
        this.mNetErrorCode = this.mConn.getResponseCode();
        if (this.mNetErrorCode != 200) {
            throw new SocketException();
        }
        if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mRetryConnt < 1) {
            this.mConn.disconnect();
            this.mRetryConnt++;
            byte[] netData = getNetData();
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                    return netData;
                }
                return netData;
            } catch (Exception e6) {
                return netData;
            }
        }
        this.mRetryConnt = 0;
        String encodeing = this.mConn.getContentEncoding();
        in = this.mConn.getInputStream();
        byte[] buf = new byte[BUFFERSIZE];
        ByteArrayOutputStream outputstream = new ByteArrayOutputStream(BUFFERSIZE);
        int size = 0;
        try {
            if (this.mIsBDImage) {
                byte[] b = new byte[23];
                in.read(b, 0, 23);
                String title = new String(b, 0, b.length);
                if (!title.equalsIgnoreCase("app:tiebaclient;type:0;")) {
                    outputstream.write(b, 0, 23);
                    size = 0 + 23;
                }
            }
            while (!this.mIsInterrupte && size < MAX_DATA_LENG) {
                int num = in.read(buf);
                if (num == -1) {
                    break;
                }
                outputstream.write(buf, 0, num);
                size += num;
            }
            TiebaLog.i("Network", "getNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
            if (size < MAX_DATA_LENG) {
                output = outputstream.toByteArray();
                TiebaLog.i("Network", "getNetData", "data.zise = " + String.valueOf(size));
                if (encodeing != null && encodeing.contains("gzip")) {
                    ByteArrayInputStream tmpInput = new ByteArrayInputStream(output);
                    ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream(BUFFERSIZE);
                    GzipHelper.decompress(tmpInput, tmpOutput);
                    output = tmpOutput.toByteArray();
                }
            } else {
                this.mNetErrorCode = -1;
                this.mErrorString = this.mContext.getResources().getString(R.string.data_too_big);
            }
            this.mRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e7) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e8) {
            }
        } catch (SocketException e9) {
            this.mNetErrorCode = 0;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            this.mRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e10) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e11) {
            }
            return output;
        } catch (Exception e12) {
            ex = e12;
            this.mNetErrorCode = 0;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            TiebaLog.e("Network", "getNetData", "error = " + ex.getMessage());
            this.mRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e13) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e14) {
            }
            return output;
        } catch (Throwable th2) {
            th = th2;
            this.mRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e15) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e16) {
            }
            throw th;
        }
        return output;
    }

    private String getCharset() throws Exception {
        int index;
        String type = null;
        if (this.mConn != null) {
            type = this.mConn.getContentType();
        }
        if (type == null || (index = type.indexOf("charset")) == -1) {
            return "utf-8";
        }
        int end2 = type.indexOf(32, index);
        if (end2 == -1) {
            String charset = type.substring(index + 8);
            return charset;
        }
        String charset2 = type.substring(index + 8, end2);
        return charset2;
    }

    public void parseServerCode(String data) {
        this.mServerErrorCode = -1;
        if (data != null) {
            try {
                ErrorData error = new ErrorData();
                error.parserJson(data);
                this.mServerErrorCode = error.getError_code();
                if (this.mServerErrorCode == -1) {
                    this.mErrorString = this.mContext.getString(R.string.error_unkown);
                } else if (this.mServerErrorCode != 0) {
                    this.mErrorString = error.getError_msg();
                }
            } catch (Exception ex) {
                TiebaLog.e("NetWork", "parseServerCode", "error = " + ex.getMessage());
                this.mErrorString = this.mContext.getString(R.string.error_unkown);
            }
        }
    }

    public String getNetString() {
        Exception ex;
        byte[] data = getNetData();
        String retData = null;
        if (this.mNetErrorCode != 200) {
            return null;
        }
        try {
            String charset = getCharset();
            String retData2 = new String(data, 0, data.length, charset);
            try {
                parseServerCode(retData2);
                return retData2;
            } catch (Exception e) {
                ex = e;
                retData = retData2;
                TiebaLog.e("Network", "getNetString", "error = " + ex.getMessage());
                return retData;
            }
        } catch (Exception e2) {
            ex = e2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [589=7, 590=7, 594=7, 595=7, 597=4, 598=7] */
    public String postNetData() {
        Exception ex;
        SocketException ex2;
        int num;
        InputStream in = null;
        String retData = null;
        try {
            try {
                this.mIsInterrupte = false;
                URL url = new URL(this.mUrl);
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketException e) {
            ex2 = e;
        } catch (Exception e2) {
            ex = e2;
        }
        if (this.mConn == null) {
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e4) {
            }
            this.mRetryConnt = 0;
            return null;
        }
        this.mConn.setConnectTimeout(20000);
        this.mConn.setReadTimeout(POSTDATATIMEOUT);
        this.mConn.setDoOutput(true);
        this.mConn.setDoInput(true);
        this.mConn.setRequestMethod("POST");
        this.mConn.setRequestProperty("Charset", "UTF-8");
        this.mConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        if (this.mRequestGzip) {
            this.mConn.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (this.mIsInterrupte) {
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e6) {
            }
            this.mRetryConnt = 0;
            return null;
        }
        long time = new Date().getTime();
        this.mConn.connect();
        DataOutputStream ds = new DataOutputStream(this.mConn.getOutputStream());
        StringBuffer build = new StringBuffer((int) BUFFERSIZE);
        StringBuffer md5_source = new StringBuffer((int) BUFFERSIZE);
        for (int i = 0; this.mPostData != null && i < this.mPostData.size(); i++) {
            BasicNameValuePair kv = this.mPostData.get(i);
            if (kv != null) {
                String k = kv.getName();
                String v = kv.getValue();
                if (i != 0) {
                    build.append("&");
                }
                build.append(k + "=");
                build.append(StringHelper.getUrlEncode(v));
                md5_source.append(k);
                md5_source.append("=");
                md5_source.append(v);
            }
        }
        md5_source.append("tiebaclient!!!");
        String md5 = StringHelper.ToMd5(md5_source.toString());
        if (build.length() > 0) {
            build.append("&");
        }
        build.append("sign=");
        build.append(md5);
        String postdata = build.toString();
        if (!this.mIsInterrupte) {
            ds.writeBytes(postdata);
        }
        ds.flush();
        TiebaLog.i("NetWork", "postNetData", "Post data.zise = " + String.valueOf(ds.size()));
        ds.close();
        this.mNetErrorCode = this.mConn.getResponseCode();
        if (this.mNetErrorCode != 200) {
            throw new SocketException();
        }
        if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mRetryConnt < 1) {
            this.mConn.disconnect();
            this.mRetryConnt++;
            String postNetData = postNetData();
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e7) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e8) {
            }
            this.mRetryConnt = 0;
            return postNetData;
        }
        this.mRetryConnt = 0;
        String encodeing = this.mConn.getContentEncoding();
        in = this.mConn.getInputStream();
        byte[] buf = new byte[BUFFERSIZE];
        ByteArrayOutputStream outputstream = new ByteArrayOutputStream(BUFFERSIZE);
        while (!this.mIsInterrupte && (num = in.read(buf)) != -1) {
            try {
                outputstream.write(buf, 0, num);
            } catch (SocketException e9) {
                ex2 = e9;
            } catch (Exception e10) {
                ex = e10;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        in.close();
        this.mConn.disconnect();
        TiebaLog.i("Network", "postNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
        byte[] output = outputstream.toByteArray();
        TiebaLog.i("Network", "postNetData", "Get data.zise = " + String.valueOf(output.length));
        if (encodeing != null && encodeing.contains("gzip")) {
            ByteArrayInputStream tmpInput = new ByteArrayInputStream(output);
            ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream(BUFFERSIZE);
            GzipHelper.decompress(tmpInput, tmpOutput);
            output = tmpOutput.toByteArray();
            TiebaLog.i("Network", "postNetData", "After ungzip data.zise = " + String.valueOf(output.length));
        }
        if (this.mNetErrorCode == 200) {
            String charset = getCharset();
            String retData2 = new String(output, 0, output.length, charset);
            try {
                parseServerCode(retData2);
                retData = retData2;
            } catch (SocketException e11) {
                ex2 = e11;
                retData = retData2;
                ex2.printStackTrace();
                this.mNetErrorCode = 0;
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e12) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e13) {
                }
                this.mRetryConnt = 0;
                return retData;
            } catch (Exception e14) {
                ex = e14;
                retData = retData2;
                ex.printStackTrace();
                this.mNetErrorCode = 0;
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaLog.e("Network", "postNetData", "url = " + this.mUrl + " error = " + ex.getMessage());
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e15) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e16) {
                }
                this.mRetryConnt = 0;
                return retData;
            } catch (Throwable th3) {
                th = th3;
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e17) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e18) {
                }
                this.mRetryConnt = 0;
                throw th;
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (Exception e19) {
            }
        }
        try {
            if (this.mConn != null) {
                this.mConn.disconnect();
            }
        } catch (Exception e20) {
        }
        this.mRetryConnt = 0;
        return retData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [732=7, 733=7, 737=7, 738=7, 740=4, 741=7] */
    public String postMultiNetData() {
        Exception ex;
        SocketException ex2;
        int num;
        InputStream in = null;
        String retData = null;
        try {
            try {
                this.mIsInterrupte = false;
                URL url = new URL(this.mUrl);
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketException e) {
            ex2 = e;
        } catch (Exception e2) {
            ex = e2;
        }
        if (this.mConn == null) {
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e3) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e4) {
            }
            this.mRetryConnt = 0;
            return null;
        }
        this.mConn.setConnectTimeout(20000);
        this.mConn.setReadTimeout(POSTDATATIMEOUT);
        this.mConn.setDoOutput(true);
        this.mConn.setDoInput(true);
        this.mConn.setRequestMethod("POST");
        this.mConn.setRequestProperty("Charset", "UTF-8");
        this.mConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        if (this.mRequestGzip) {
            this.mConn.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (this.mIsInterrupte) {
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e6) {
            }
            this.mRetryConnt = 0;
            return null;
        }
        long time = new Date().getTime();
        this.mConn.connect();
        DataOutputStream ds = new DataOutputStream(this.mConn.getOutputStream());
        for (int i = 0; this.mPostData != null && i < this.mPostData.size() && !this.mIsInterrupte; i++) {
            BasicNameValuePair kv = this.mPostData.get(i);
            if (kv != null) {
                String k = kv.getName();
                String v = kv.getValue();
                ds.writeBytes(twoHypens + boundary + end);
                byte[] vbuffer = v.getBytes("UTF-8");
                ds.writeBytes("Content-Disposition: form-data; name=\"" + k + "\"" + end);
                ds.writeBytes(end);
                ds.write(vbuffer);
                ds.writeBytes(end);
            }
        }
        if (this.mFileData != null) {
            for (Map.Entry<String, byte[]> entry : this.mFileData.entrySet()) {
                String k2 = entry.getKey();
                byte[] v2 = entry.getValue();
                if (this.mIsInterrupte) {
                    break;
                } else if (v2 != null) {
                    ds.writeBytes(twoHypens + boundary + end);
                    ds.writeBytes("Content-Disposition: form-data; name=\"" + k2 + "\"; filename=\"file\"" + end);
                    ds.writeBytes(end);
                    ds.write(v2);
                    ds.writeBytes(end);
                }
            }
        }
        ds.writeBytes(twoHypens + boundary + twoHypens + end);
        ds.flush();
        TiebaLog.i("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(ds.size()));
        ds.close();
        this.mNetErrorCode = this.mConn.getResponseCode();
        if (this.mNetErrorCode != 200) {
            throw new SocketException();
        }
        if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mRetryConnt < 1) {
            this.mConn.disconnect();
            this.mRetryConnt++;
            String postNetData = postNetData();
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e7) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e8) {
            }
            this.mRetryConnt = 0;
            return postNetData;
        }
        this.mRetryConnt = 0;
        String encodeing = this.mConn.getContentEncoding();
        in = this.mConn.getInputStream();
        byte[] buf = new byte[BUFFERSIZE];
        ByteArrayOutputStream outputstream = new ByteArrayOutputStream(BUFFERSIZE);
        while (!this.mIsInterrupte && (num = in.read(buf)) != -1) {
            try {
                outputstream.write(buf, 0, num);
            } catch (SocketException e9) {
                ex2 = e9;
            } catch (Exception e10) {
                ex = e10;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        in.close();
        this.mConn.disconnect();
        TiebaLog.i("NetWork", "postMultiNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
        byte[] output = outputstream.toByteArray();
        TiebaLog.i("NetWork", "postMultiNetData", "Get data.zise = " + String.valueOf(output.length));
        if (encodeing != null && encodeing.contains("gzip")) {
            ByteArrayInputStream tmpInput = new ByteArrayInputStream(output);
            ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream(BUFFERSIZE);
            GzipHelper.decompress(tmpInput, tmpOutput);
            output = tmpOutput.toByteArray();
        }
        if (this.mNetErrorCode == 200) {
            String charset = getCharset();
            String retData2 = new String(output, 0, output.length, charset);
            try {
                parseServerCode(retData2);
                retData = retData2;
            } catch (SocketException e11) {
                ex2 = e11;
                retData = retData2;
                ex2.printStackTrace();
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e12) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e13) {
                }
                this.mRetryConnt = 0;
                return retData;
            } catch (Exception e14) {
                ex = e14;
                retData = retData2;
                ex.printStackTrace();
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaLog.e("NetWork", "postMultiNetData", "error = " + ex.getMessage());
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e15) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e16) {
                }
                this.mRetryConnt = 0;
                return retData;
            } catch (Throwable th3) {
                th = th3;
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e17) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e18) {
                }
                this.mRetryConnt = 0;
                throw th;
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (Exception e19) {
            }
        }
        try {
            if (this.mConn != null) {
                this.mConn.disconnect();
            }
        } catch (Exception e20) {
        }
        this.mRetryConnt = 0;
        return retData;
    }

    public boolean isFileSegSuccess() {
        return this.mNetErrorCode == 200 || this.mNetErrorCode == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [866=10, 868=9, 869=9, 871=4, 873=9, 874=9, 876=4, 878=9, 879=9, 881=12] */
    public Boolean downloadFile(String name, Handler handler) {
        Exception ex;
        IOException ex2;
        SocketException ex3;
        InputStream in = null;
        FileOutputStream fileStream = null;
        try {
            try {
                this.mIsInterrupte = false;
                URL url = new URL(this.mUrl);
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
        } catch (SocketException e2) {
            ex3 = e2;
        } catch (IOException e3) {
            ex2 = e3;
        } catch (Exception e4) {
            ex = e4;
        }
        if (this.mConn == null) {
            throw new SocketException();
        }
        this.mConn.setConnectTimeout(20000);
        this.mConn.setReadTimeout(20000);
        if (this.mIsInterrupte) {
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e5) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e6) {
            }
            if (0 != 0) {
                try {
                    fileStream.close();
                    return false;
                } catch (Exception e7) {
                    return false;
                }
            }
            return false;
        }
        long time = new Date().getTime();
        File file = FileHelper.CreateFileIfNotFound(name);
        if (file == null) {
            throw new FileNotFoundException();
        }
        long file_length = file.length();
        FileOutputStream fileStream2 = new FileOutputStream(file, true);
        try {
            if (this.mConn.usingProxy()) {
                this.mConn.addRequestProperty("Range", "bytes=" + String.valueOf(file_length) + "-" + String.valueOf(200000 + file_length));
            } else {
                this.mConn.addRequestProperty("Range", "bytes=" + String.valueOf(file_length) + "-");
            }
            this.mConn.connect();
            this.mNetErrorCode = this.mConn.getResponseCode();
        } catch (FileNotFoundException e8) {
            fileStream = fileStream2;
            this.mNetErrorCode = -2;
            this.mErrorString = this.mContext.getResources().getString(R.string.FileWriteError);
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e9) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e10) {
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e11) {
                }
            }
            return ret;
        } catch (SocketException e12) {
            ex3 = e12;
            fileStream = fileStream2;
            this.mNetErrorCode = 0;
            TiebaLog.e("NetWorkCore", "downloadFile", "error = " + ex3.getMessage());
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e13) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e14) {
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e15) {
                }
            }
            return ret;
        } catch (IOException e16) {
            ex2 = e16;
            fileStream = fileStream2;
            this.mNetErrorCode = -2;
            TiebaLog.e("NetWorkCore", "downloadFile", "error = " + ex2.getMessage());
            this.mErrorString = this.mContext.getResources().getString(R.string.FileWriteError);
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e17) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e18) {
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e19) {
                }
            }
            return ret;
        } catch (Exception e20) {
            ex = e20;
            fileStream = fileStream2;
            this.mNetErrorCode = 0;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            TiebaLog.e("NetWork", "downloadFile", "error = " + ex.getMessage());
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e21) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e22) {
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e23) {
                }
            }
            return ret;
        } catch (Throwable th2) {
            th = th2;
            fileStream = fileStream2;
            this.mRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e24) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e25) {
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e26) {
                }
            }
            throw th;
        }
        if (isFileSegSuccess()) {
            if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mRetryConnt < 1) {
                this.mConn.disconnect();
                this.mRetryConnt++;
                Boolean downloadFile = downloadFile(name, handler);
                this.mRetryConnt = 0;
                if (0 != 0) {
                    try {
                        in.close();
                    } catch (Exception e27) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e28) {
                }
                if (fileStream2 != null) {
                    try {
                        fileStream2.close();
                    } catch (Exception e29) {
                    }
                }
                return downloadFile;
            }
            this.mRetryConnt = 0;
            int contentLen = 0;
            String range = this.mConn.getHeaderField("Content-Range");
            if (range != null) {
                int index = range.indexOf("/");
                if (index != -1) {
                    contentLen = Integer.valueOf(range.substring(index + 1)).intValue();
                }
            }
            if (file_length >= contentLen) {
                this.mRetryConnt = 0;
                if (0 != 0) {
                    try {
                        in.close();
                    } catch (Exception e30) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e31) {
                }
                if (fileStream2 != null) {
                    try {
                        fileStream2.close();
                    } catch (Exception e32) {
                    }
                }
                return true;
            }
            InputStream in2 = this.mConn.getInputStream();
            byte[] buf = new byte[BUFFERSIZE];
            int datalenth = 0;
            int notify_num = contentLen > 0 ? contentLen / 50 : 0;
            int notify_tmp = 0;
            if (handler != null && file_length > 0) {
                handler.sendMessage(handler.obtainMessage(Config.NET_MSG_GETLENTH, (int) file_length, contentLen));
            }
            while (!this.mIsInterrupte) {
                int num = in2.read(buf);
                if (num == -1) {
                    break;
                }
                fileStream2.write(buf, 0, num);
                datalenth += num;
                notify_tmp += num;
                if (handler != null && (notify_tmp > notify_num || datalenth == contentLen)) {
                    notify_tmp = 0;
                    handler.sendMessage(handler.obtainMessage(Config.NET_MSG_GETLENTH, (int) (datalenth + file_length), contentLen));
                }
            }
            fileStream2.flush();
            TiebaLog.i("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
            if (contentLen != -1) {
                TiebaLog.i("NetWork", "downloadFile", "data.zise = " + String.valueOf(contentLen));
            }
            ret = ((long) datalenth) + file_length >= ((long) contentLen);
            this.mRetryConnt = 0;
            if (in2 != null) {
                try {
                    in2.close();
                } catch (Exception e33) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e34) {
            }
            if (fileStream2 != null) {
                try {
                    fileStream2.close();
                } catch (Exception e35) {
                }
            }
            return ret;
        }
        throw new SocketException();
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ArrayList<BasicNameValuePair> getPostData() {
        return this.mPostData;
    }

    public void setPostData(ArrayList<BasicNameValuePair> postData) {
        if (this.mPostData != null) {
            this.mPostData.clear();
        }
        for (int i = 0; i < postData.size(); i++) {
            addPostData(postData.get(i));
        }
    }

    public void addPostData(String k, String v) {
        BasicNameValuePair data = new BasicNameValuePair(k, v);
        addPostData(data);
    }

    public void addPostData(String k, byte[] v) {
        if (this.mFileData == null) {
            this.mFileData = new HashMap<>();
        }
        this.mFileData.put(k, v);
    }

    public void addPostData(BasicNameValuePair data) {
        if (this.mPostData == null) {
            this.mPostData = new ArrayList<>();
        }
        int index = getAddPostIndex(this.mPostData, data.getName());
        if (index >= 0 && index <= this.mPostData.size()) {
            this.mPostData.add(index, data);
        }
    }

    private int getAddPostIndex(ArrayList<BasicNameValuePair> data, String key) {
        int index = 0;
        if (data == null && key == null) {
            return -1;
        }
        int size = data.size();
        int i = 0;
        while (i < size) {
            index = i;
            if (key.compareTo(data.get(i).getName()) < 0) {
                break;
            }
            i++;
        }
        if (i >= size) {
            index = size;
        }
        return index;
    }

    public void setIsBDImage(boolean isBDImage) {
        this.mIsBDImage = isBDImage;
    }

    public boolean getIsBDImage() {
        return this.mIsBDImage;
    }
}
