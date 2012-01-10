package com.baidu.tieba.util;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
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
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class NetWorkCore {
    private static final int BUFFERSIZE = 1024;
    private static final int CONNECTTIMEOUT = 7000;
    private static final int GETDATATIMEOUT = 7000;
    private static final int MAX_RETRY_COUNT = 2;
    public static final String NET_TYPE_NET = "1";
    public static final String NET_TYPE_WAP = "2";
    public static final String NET_TYPE_WIFI = "3";
    private static final int POSTDATATIMEOUT = 10000;
    private HttpURLConnection mConn;
    private Context mContext;
    private String mErrorString;
    private HashMap<String, byte[]> mFileData;
    private boolean mIsBDImage;
    private volatile boolean mIsInterrupte;
    private boolean mIsLimited;
    private int mNetErrorCode;
    private ArrayList<BasicNameValuePair> mPostData;
    private boolean mRequestGzip;
    private int mRetryConnt;
    private int mServerErrorCode;
    private String mUrl;
    private int mWapRetryConnt;
    private static String end = "\r\n";
    private static String twoHypens = "--";
    private static String boundary = "--------7da3d81520810*";
    private static int MAX_DATA_LENG = 2097152;
    private static Handler mHandler = null;
    private static volatile String mProxyUser = null;
    private static volatile boolean mHaveInitProxyUser = false;
    private static Pattern mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.172$", 8);

    /* loaded from: classes.dex */
    public enum NetworkState {
        UNAVAIL,
        WIFI,
        MOBILE
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
        this.mWapRetryConnt = 0;
        this.mIsInterrupte = false;
        this.mIsBDImage = false;
        this.mFileData = null;
        this.mIsLimited = false;
        this.mRetryConnt = 0;
        initPorxyUser();
    }

    public String getNetType() {
        try {
            ConnectivityManager cwjManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            NetworkInfo networkinfo = cwjManager.getActiveNetworkInfo();
            boolean netSataus = networkinfo.isAvailable();
            if (netSataus) {
                if (networkinfo.getTypeName().equalsIgnoreCase("WIFI")) {
                    return NET_TYPE_WIFI;
                }
                String proxyHost = Proxy.getDefaultHost();
                if (proxyHost != null) {
                    if (proxyHost.length() > 0) {
                        return NET_TYPE_WAP;
                    }
                }
                return NET_TYPE_NET;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static void initPorxyUser() {
        synchronized (NetWorkCore.class) {
            if (!mHaveInitProxyUser) {
                mHaveInitProxyUser = true;
                try {
                    Uri uri = Uri.parse("content://telephony/carriers/preferapn");
                    Cursor apn = TiebaApplication.app.getContentResolver().query(uri, null, null, null, null);
                    if (apn != null && apn.moveToNext()) {
                        String name = apn.getString(apn.getColumnIndex("user"));
                        String pwd = apn.getString(apn.getColumnIndex("password"));
                        apn.close();
                        String login = name + ":" + pwd;
                        String encodedLogin = StringHelper.base64Encode(login.getBytes());
                        mProxyUser = "Basic " + encodedLogin;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static void initNetWorkCore() {
        mHandler = new Handler() { // from class: com.baidu.tieba.util.NetWorkCore.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                try {
                    NetWorkCore network = (NetWorkCore) msg.obj;
                    if (network != null) {
                        network.cancelNetConnect();
                    }
                } catch (Exception e) {
                }
            }
        };
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
            } else {
                ret = NetworkState.MOBILE;
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

    public void setErrorCode(int code) {
        this.mServerErrorCode = code;
    }

    public void cancelNetConnect() {
        this.mIsInterrupte = true;
        try {
            if (this.mConn != null) {
                this.mConn.disconnect();
            }
        } catch (Exception e) {
        }
    }

    private HttpURLConnection getConnect(URL url) {
        String proxyHost;
        HttpURLConnection conn = null;
        NetworkState state = getNetworkState(this.mContext);
        this.mIsLimited = false;
        try {
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "getConnect", "error = " + ex.getMessage());
        }
        if (state == NetworkState.UNAVAIL) {
            return null;
        }
        if (state == NetworkState.MOBILE && (proxyHost = Proxy.getDefaultHost()) != null && proxyHost.length() > 0) {
            if (isCMCCServer(proxyHost)) {
                this.mIsLimited = true;
                StringBuffer new_address = new StringBuffer(80);
                new_address.append("http://");
                new_address.append(Proxy.getDefaultHost());
                String file = url.getFile();
                if (file != null && file.startsWith("?")) {
                    new_address.append("/");
                }
                new_address.append(file);
                URL new_url = new URL(new_address.toString());
                conn = (HttpURLConnection) new_url.openConnection();
                conn.setRequestProperty("X-Online-Host", url.getHost());
            } else {
                java.net.Proxy p = new java.net.Proxy(Proxy.Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
                conn = (HttpURLConnection) url.openConnection(p);
                if (mProxyUser != null) {
                    conn.setRequestProperty("Proxy-Authorization", mProxyUser);
                }
            }
        }
        if (conn == null) {
            conn = (HttpURLConnection) url.openConnection();
        }
        return conn;
    }

    private boolean isCMCCServer(String ip) {
        Matcher m = mPattern.matcher(ip);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [489=8, 491=7, 492=7, 496=7, 497=7, 499=9] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        Exception ex;
        URL url;
        byte[] output = null;
        InputStream in = null;
        boolean is_net_error = false;
        try {
            try {
                if (this.mPostData == null || this.mPostData.size() <= 0) {
                    URL url2 = new URL(this.mUrl);
                    url = url2;
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
                    URL url3 = new URL(buffer.toString());
                    url = url3;
                }
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketException e) {
        } catch (SocketTimeoutException e2) {
        } catch (Exception e3) {
            ex = e3;
        }
        if (this.mConn == null) {
            throw new SocketException();
        }
        this.mConn.setConnectTimeout(7000);
        this.mConn.setReadTimeout(7000);
        if (this.mRequestGzip && !this.mIsBDImage) {
            this.mConn.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (this.mIsInterrupte) {
            this.mWapRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                    return null;
                }
                return null;
            } catch (Exception e5) {
                return null;
            }
        }
        long time = new Date().getTime();
        this.mConn.connect();
        this.mNetErrorCode = this.mConn.getResponseCode();
        if (this.mNetErrorCode != 200) {
            throw new SocketException();
        }
        if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mWapRetryConnt < 1) {
            this.mConn.disconnect();
            this.mWapRetryConnt++;
            this.mNetErrorCode = 0;
            byte[] netData = getNetData();
            this.mWapRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e6) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                    return netData;
                }
                return netData;
            } catch (Exception e7) {
                return netData;
            }
        }
        this.mWapRetryConnt = 0;
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
            TiebaLog.i(getClass().getName(), "getNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
            if (size < MAX_DATA_LENG) {
                output = outputstream.toByteArray();
                TiebaLog.i(getClass().getName(), "getNetData", "data.zise = " + String.valueOf(size));
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
            this.mWapRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e8) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e9) {
            }
        } catch (SocketException e10) {
            this.mNetErrorCode = 0;
            is_net_error = true;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            this.mWapRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e11) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e12) {
            }
            if (this.mIsInterrupte) {
            }
            return output;
        } catch (SocketTimeoutException e13) {
            this.mNetErrorCode = 0;
            is_net_error = true;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            this.mWapRetryConnt = 0;
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e14) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e15) {
            }
            if (this.mIsInterrupte) {
            }
            return output;
        } catch (Exception e16) {
            ex = e16;
            this.mNetErrorCode = 0;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            TiebaLog.e(getClass().getName(), "getNetData", "error = " + ex.getMessage());
            this.mWapRetryConnt = 0;
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
            if (this.mIsInterrupte) {
            }
            return output;
        } catch (Throwable th2) {
            th = th2;
            this.mWapRetryConnt = 0;
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
            throw th;
        }
        if (this.mIsInterrupte && is_net_error && this.mRetryConnt < 2) {
            this.mRetryConnt++;
            return getNetData();
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
        String retData;
        byte[] data = getNetData();
        String retData2 = null;
        if (this.mNetErrorCode != 200) {
            return null;
        }
        try {
            String charset = getCharset();
            retData = new String(data, 0, data.length, charset);
        } catch (Exception e) {
            ex = e;
        }
        try {
            parseServerCode(retData);
            return retData;
        } catch (Exception e2) {
            ex = e2;
            retData2 = retData;
            TiebaLog.e(getClass().getName(), "getNetString", "error = " + ex.getMessage());
            return retData2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [714=8, 715=8, 719=8, 720=8, 722=5, 723=8] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0226  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String postNetData() {
        Exception ex;
        SocketTimeoutException ex2;
        SocketException ex3;
        int num;
        InputStream in = null;
        String retData = null;
        boolean is_net_error = false;
        try {
            try {
                URL url = new URL(this.mUrl);
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketException e) {
            ex3 = e;
        } catch (SocketTimeoutException e2) {
            ex2 = e2;
        } catch (Exception e3) {
            ex = e3;
        }
        if (this.mConn == null) {
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e5) {
            }
            this.mWapRetryConnt = 0;
            return null;
        }
        this.mConn.setConnectTimeout(7000);
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
                } catch (Exception e6) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e7) {
            }
            this.mWapRetryConnt = 0;
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
        if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mWapRetryConnt < 1) {
            this.mConn.disconnect();
            this.mWapRetryConnt++;
            this.mNetErrorCode = 0;
            String postNetData = postNetData();
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e8) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e9) {
            }
            this.mWapRetryConnt = 0;
            return postNetData;
        }
        this.mWapRetryConnt = 0;
        String encodeing = this.mConn.getContentEncoding();
        in = this.mConn.getInputStream();
        byte[] buf = new byte[BUFFERSIZE];
        ByteArrayOutputStream outputstream = new ByteArrayOutputStream(BUFFERSIZE);
        while (!this.mIsInterrupte && (num = in.read(buf)) != -1) {
            try {
                outputstream.write(buf, 0, num);
            } catch (SocketException e10) {
                ex3 = e10;
            } catch (SocketTimeoutException e11) {
                ex2 = e11;
            } catch (Exception e12) {
                ex = e12;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        in.close();
        this.mConn.disconnect();
        TiebaLog.i(getClass().getName(), "postNetData", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
        byte[] output = outputstream.toByteArray();
        TiebaLog.i(getClass().getName(), "postNetData", "Get data.zise = " + String.valueOf(output.length));
        if (encodeing != null && encodeing.contains("gzip")) {
            ByteArrayInputStream tmpInput = new ByteArrayInputStream(output);
            ByteArrayOutputStream tmpOutput = new ByteArrayOutputStream(BUFFERSIZE);
            GzipHelper.decompress(tmpInput, tmpOutput);
            output = tmpOutput.toByteArray();
            TiebaLog.i(getClass().getName(), "postNetData", "After ungzip data.zise = " + String.valueOf(output.length));
        }
        if (this.mNetErrorCode == 200) {
            String charset = getCharset();
            String retData2 = new String(output, 0, output.length, charset);
            try {
                parseServerCode(retData2);
                retData = retData2;
            } catch (SocketException e13) {
                ex3 = e13;
                retData = retData2;
                this.mNetErrorCode = 0;
                is_net_error = true;
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaLog.e(getClass().getName(), "postNetData", "SocketException " + ex3.getMessage());
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e14) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e15) {
                }
                this.mWapRetryConnt = 0;
                if (this.mIsInterrupte) {
                }
                return retData;
            } catch (SocketTimeoutException e16) {
                ex2 = e16;
                retData = retData2;
                this.mNetErrorCode = 0;
                is_net_error = true;
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaLog.e(getClass().getName(), "postNetData", "SocketTimeoutException " + ex2.getMessage());
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
                this.mWapRetryConnt = 0;
                if (this.mIsInterrupte) {
                }
                return retData;
            } catch (Exception e19) {
                ex = e19;
                retData = retData2;
                this.mNetErrorCode = 0;
                this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                TiebaLog.e(getClass().getName(), "postNetData", ex.getMessage());
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e20) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e21) {
                }
                this.mWapRetryConnt = 0;
                if (this.mIsInterrupte) {
                }
                return retData;
            } catch (Throwable th3) {
                th = th3;
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e22) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e23) {
                }
                this.mWapRetryConnt = 0;
                throw th;
            }
        }
        if (in != null) {
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
        this.mWapRetryConnt = 0;
        if (this.mIsInterrupte && is_net_error && this.mRetryConnt < 2) {
            this.mRetryConnt++;
            return postNetData();
        }
        return retData;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [876=8, 877=8, 879=8, 881=8, 882=8, 886=8, 887=8, 889=8, 890=8, 891=8, 893=4, 894=4] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x026a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String postMultiNetData() {
        Exception ex;
        int num;
        String postMultiNetData;
        InputStream in = null;
        String retData = null;
        boolean is_net_error = false;
        DataOutputStream ds = null;
        try {
            try {
                URL url = new URL(this.mUrl);
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (SocketException e) {
        } catch (SocketTimeoutException e2) {
        } catch (Exception e3) {
            ex = e3;
        }
        if (this.mConn == null) {
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            postMultiNetData = null;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e4) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e5) {
            }
            if (0 != 0) {
                try {
                    ds.close();
                } catch (Exception e6) {
                }
            }
            if (mHandler != null) {
                mHandler.removeMessages(0, this);
            }
        } else {
            this.mConn.setConnectTimeout(7000);
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
                postMultiNetData = null;
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
                if (0 != 0) {
                    try {
                        ds.close();
                    } catch (Exception e9) {
                    }
                }
                if (mHandler != null) {
                    mHandler.removeMessages(0, this);
                }
            } else {
                long time = new Date().getTime();
                this.mConn.connect();
                DataOutputStream ds2 = new DataOutputStream(this.mConn.getOutputStream());
                for (int i = 0; this.mPostData != null && i < this.mPostData.size() && !this.mIsInterrupte; i++) {
                    try {
                        BasicNameValuePair kv = this.mPostData.get(i);
                        if (kv != null) {
                            String k = kv.getName();
                            String v = kv.getValue();
                            ds2.writeBytes(twoHypens + boundary + end);
                            byte[] vbuffer = v.getBytes("UTF-8");
                            ds2.writeBytes("Content-Disposition: form-data; name=\"" + k + "\"" + end);
                            ds2.writeBytes(end);
                            ds2.write(vbuffer);
                            ds2.writeBytes(end);
                        }
                    } catch (SocketException e10) {
                        ds = ds2;
                    } catch (SocketTimeoutException e11) {
                        ds = ds2;
                    } catch (Exception e12) {
                        ex = e12;
                        ds = ds2;
                    } catch (Throwable th2) {
                        th = th2;
                        ds = ds2;
                    }
                }
                if (this.mFileData != null) {
                    for (Map.Entry<String, byte[]> entry : this.mFileData.entrySet()) {
                        String k2 = entry.getKey();
                        byte[] v2 = entry.getValue();
                        if (this.mIsInterrupte) {
                            break;
                        } else if (v2 != null) {
                            ds2.writeBytes(twoHypens + boundary + end);
                            ds2.writeBytes("Content-Disposition: form-data; name=\"" + k2 + "\"; filename=\"file\"" + end);
                            ds2.writeBytes(end);
                            ds2.write(v2);
                            ds2.writeBytes(end);
                        }
                    }
                }
                ds2.writeBytes(twoHypens + boundary + twoHypens + end);
                ds2.flush();
                TiebaLog.i("NetWork", "postMultiNetData", "Post data.zise = " + String.valueOf(ds2.size()));
                ds2.close();
                if (mHandler != null) {
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(0, this), 30000L);
                }
                this.mNetErrorCode = this.mConn.getResponseCode();
                if (mHandler != null) {
                    mHandler.removeMessages(0, this);
                }
                if (this.mNetErrorCode != 200) {
                    throw new SocketException();
                }
                if (!this.mConn.getContentType().contains("text/vnd.wap.wml") || this.mWapRetryConnt >= 1) {
                    this.mWapRetryConnt = 0;
                    String encodeing = this.mConn.getContentEncoding();
                    in = this.mConn.getInputStream();
                    byte[] buf = new byte[BUFFERSIZE];
                    ByteArrayOutputStream outputstream = new ByteArrayOutputStream(BUFFERSIZE);
                    while (!this.mIsInterrupte && (num = in.read(buf)) != -1) {
                        try {
                            outputstream.write(buf, 0, num);
                        } catch (SocketException e13) {
                            ds = ds2;
                        } catch (SocketTimeoutException e14) {
                            ds = ds2;
                        } catch (Exception e15) {
                            ex = e15;
                            ds = ds2;
                        } catch (Throwable th3) {
                            th = th3;
                            ds = ds2;
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
                        } catch (SocketException e16) {
                            ds = ds2;
                            retData = retData2;
                            is_net_error = true;
                            this.mNetErrorCode = 0;
                            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
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
                            if (ds != null) {
                                try {
                                    ds.close();
                                } catch (Exception e19) {
                                }
                            }
                            if (mHandler != null) {
                                mHandler.removeMessages(0, this);
                            }
                            this.mWapRetryConnt = 0;
                            if (this.mIsInterrupte) {
                            }
                            return retData;
                        } catch (SocketTimeoutException e20) {
                            ds = ds2;
                            retData = retData2;
                            this.mNetErrorCode = 0;
                            is_net_error = true;
                            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                            if (in != null) {
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
                            if (ds != null) {
                                try {
                                    ds.close();
                                } catch (Exception e23) {
                                }
                            }
                            if (mHandler != null) {
                                mHandler.removeMessages(0, this);
                            }
                            this.mWapRetryConnt = 0;
                            if (this.mIsInterrupte) {
                            }
                            return retData;
                        } catch (Exception e24) {
                            ex = e24;
                            ds = ds2;
                            retData = retData2;
                            this.mNetErrorCode = 0;
                            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
                            TiebaLog.e("NetWork", "postMultiNetData", "error = " + ex.getMessage());
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (Exception e25) {
                                }
                            }
                            try {
                                if (this.mConn != null) {
                                    this.mConn.disconnect();
                                }
                            } catch (Exception e26) {
                            }
                            if (ds != null) {
                                try {
                                    ds.close();
                                } catch (Exception e27) {
                                }
                            }
                            if (mHandler != null) {
                                mHandler.removeMessages(0, this);
                            }
                            this.mWapRetryConnt = 0;
                            if (this.mIsInterrupte) {
                            }
                            return retData;
                        } catch (Throwable th4) {
                            th = th4;
                            ds = ds2;
                            if (in != null) {
                                try {
                                    in.close();
                                } catch (Exception e28) {
                                }
                            }
                            try {
                                if (this.mConn != null) {
                                    this.mConn.disconnect();
                                }
                            } catch (Exception e29) {
                            }
                            if (ds != null) {
                                try {
                                    ds.close();
                                } catch (Exception e30) {
                                }
                            }
                            if (mHandler != null) {
                                mHandler.removeMessages(0, this);
                            }
                            this.mWapRetryConnt = 0;
                            throw th;
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception e31) {
                        }
                    }
                    try {
                        if (this.mConn != null) {
                            this.mConn.disconnect();
                        }
                    } catch (Exception e32) {
                    }
                    if (ds2 != null) {
                        try {
                            ds2.close();
                        } catch (Exception e33) {
                        }
                    }
                    if (mHandler != null) {
                        mHandler.removeMessages(0, this);
                    }
                    this.mWapRetryConnt = 0;
                    if (this.mIsInterrupte && is_net_error && this.mRetryConnt < 2) {
                        this.mRetryConnt++;
                        return postMultiNetData();
                    }
                    return retData;
                }
                this.mConn.disconnect();
                this.mWapRetryConnt++;
                this.mNetErrorCode = 0;
                postMultiNetData = postMultiNetData();
                if (0 != 0) {
                    try {
                        in.close();
                    } catch (Exception e34) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e35) {
                }
                if (ds2 != null) {
                    try {
                        ds2.close();
                    } catch (Exception e36) {
                    }
                }
                if (mHandler != null) {
                    mHandler.removeMessages(0, this);
                }
            }
        }
        this.mWapRetryConnt = 0;
        return postMultiNetData;
    }

    public boolean isFileSegSuccess() {
        return this.mNetErrorCode == 200 || this.mNetErrorCode == 206;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1030=8, 1032=7, 1033=7, 1035=4, 1037=7, 1038=7, 1042=7, 1043=7, 1045=11] */
    public Boolean downloadFile(String name, Handler handler) {
        Exception ex;
        String length;
        InputStream in = null;
        FileOutputStream fileStream = null;
        try {
            try {
                URL url = new URL(this.mUrl);
                this.mConn = getConnect(url);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
        } catch (Exception e2) {
            ex = e2;
        }
        if (this.mConn == null) {
            throw new SocketException();
        }
        this.mConn.setConnectTimeout(7000);
        this.mConn.setReadTimeout(7000);
        this.mConn.setInstanceFollowRedirects(false);
        if (this.mIsInterrupte) {
            this.mWapRetryConnt = 0;
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
            if (0 != 0) {
                try {
                    fileStream.close();
                    return false;
                } catch (Exception e5) {
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
            try {
                if (this.mIsLimited) {
                    this.mConn.addRequestProperty("Range", "bytes=" + String.valueOf(file_length) + "-" + String.valueOf(200000 + file_length));
                } else {
                    this.mConn.addRequestProperty("Range", "bytes=" + String.valueOf(file_length) + "-");
                }
                this.mConn.connect();
                this.mNetErrorCode = this.mConn.getResponseCode();
            } catch (Throwable th2) {
                th = th2;
                fileStream = fileStream2;
                this.mWapRetryConnt = 0;
                if (0 != 0) {
                    try {
                        in.close();
                    } catch (Exception e6) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e7) {
                }
                if (fileStream != null) {
                    try {
                        fileStream.close();
                    } catch (Exception e8) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileStream = fileStream2;
            this.mNetErrorCode = -2;
            this.mErrorString = this.mContext.getResources().getString(R.string.FileWriteError);
            this.mWapRetryConnt = 0;
            if (0 != 0) {
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
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e12) {
                }
            }
            return ret;
        } catch (Exception e13) {
            ex = e13;
            fileStream = fileStream2;
            this.mNetErrorCode = 0;
            this.mErrorString = this.mContext.getResources().getString(R.string.neterror);
            TiebaLog.e("NetWork", "downloadFile", "error = " + ex.getMessage());
            this.mWapRetryConnt = 0;
            if (0 != 0) {
                try {
                    in.close();
                } catch (Exception e14) {
                }
            }
            try {
                if (this.mConn != null) {
                    this.mConn.disconnect();
                }
            } catch (Exception e15) {
            }
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (Exception e16) {
                }
            }
            return ret;
        }
        if (isFileSegSuccess()) {
            if (this.mConn.getContentType().contains("text/vnd.wap.wml") && this.mWapRetryConnt < 1) {
                this.mConn.disconnect();
                this.mWapRetryConnt++;
                this.mNetErrorCode = 0;
                Boolean downloadFile = downloadFile(name, handler);
                this.mWapRetryConnt = 0;
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
                if (fileStream2 != null) {
                    try {
                        fileStream2.close();
                    } catch (Exception e19) {
                    }
                }
                return downloadFile;
            }
            this.mWapRetryConnt = 0;
            int contentLen = 0;
            String range = this.mConn.getHeaderField("Content-Range");
            if (range != null) {
                int index = range.indexOf("/");
                if (index != -1) {
                    contentLen = Integer.valueOf(range.substring(index + 1)).intValue();
                }
            }
            if (contentLen == 0 && this.mNetErrorCode == 200 && (length = this.mConn.getHeaderField("Content-Length")) != null) {
                contentLen = Integer.valueOf(length).intValue();
            }
            if (file_length >= contentLen) {
                this.mWapRetryConnt = 0;
                if (0 != 0) {
                    try {
                        in.close();
                    } catch (Exception e20) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e21) {
                }
                if (fileStream2 != null) {
                    try {
                        fileStream2.close();
                    } catch (Exception e22) {
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
                if (num != -1) {
                    try {
                        fileStream2.write(buf, 0, num);
                        datalenth += num;
                        notify_tmp += num;
                        if (handler != null && (notify_tmp > notify_num || datalenth == contentLen)) {
                            notify_tmp = 0;
                            handler.sendMessage(handler.obtainMessage(Config.NET_MSG_GETLENTH, (int) (datalenth + file_length), contentLen));
                        }
                    } catch (Exception e23) {
                        throw new FileNotFoundException();
                    }
                }
            }
            try {
                fileStream2.flush();
                TiebaLog.i("NetWork", "downloadFile", "time = " + String.valueOf(new Date().getTime() - time) + "ms");
                if (contentLen != -1) {
                    TiebaLog.i("NetWork", "downloadFile", "data.zise = " + String.valueOf(contentLen));
                }
                ret = ((long) datalenth) + file_length >= ((long) contentLen);
                this.mWapRetryConnt = 0;
                if (in2 != null) {
                    try {
                        in2.close();
                    } catch (Exception e24) {
                    }
                }
                try {
                    if (this.mConn != null) {
                        this.mConn.disconnect();
                    }
                } catch (Exception e25) {
                }
                if (fileStream2 != null) {
                    try {
                        fileStream2.close();
                    } catch (Exception e26) {
                    }
                }
                return ret;
            } catch (Exception e27) {
                throw new FileNotFoundException();
            }
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
        if (data != null && data.getName() != null) {
            if (this.mPostData == null) {
                this.mPostData = new ArrayList<>();
            }
            int index = getAddPostIndex(this.mPostData, data.getName());
            int size = this.mPostData.size();
            if (index >= 0 && index < size) {
                BasicNameValuePair tmp = this.mPostData.get(index);
                if (data.getName().equals(tmp.getName())) {
                    this.mPostData.set(index, data);
                } else {
                    this.mPostData.add(index, data);
                }
            } else if (index == size) {
                this.mPostData.add(index, data);
            }
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
            if (key.compareTo(data.get(i).getName()) <= 0) {
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
