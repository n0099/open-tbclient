package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.t;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public class d implements t {
    private static int fab = 2097152;
    private final com.baidu.tbadk.core.util.b.a eZW;
    private com.baidu.tieba.recapp.download.http.c mSh = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.b.a aVar) {
        this.eZW = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bM((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eHi : cookie);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eZW.bta().bte().mPostData != null) {
            this.eZW.bta().bte().mPostData.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                addPostData(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.eZW.bta().bte().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eZW.bta().bte().mPostData == null) {
                this.eZW.bta().bte().mPostData = new ArrayList<>();
            }
            int c = c(this.eZW.bta().bte().mPostData, basicNameValuePair.getName());
            int size = this.eZW.bta().bte().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eZW.bta().bte().mPostData.get(c).getName())) {
                    this.eZW.bta().bte().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eZW.bta().bte().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eZW.bta().bte().mPostData.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            int compareTo = str.compareTo(arrayList.get(i).getName());
            if (compareTo < 0) {
                i2 = i;
                break;
            } else if (compareTo == 0) {
                return -1;
            } else {
                i2 = i;
                i++;
            }
        }
        return i >= size ? size : i2;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(String str, byte[] bArr) {
        if (this.eZW.bta().bte().mFileData == null) {
            this.eZW.bta().bte().mFileData = new HashMap<>();
        }
        this.eZW.bta().bte().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void cancelNetConnect() {
        this.mSh.cancel();
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setCancel() {
        if (this.mSh != null) {
            this.mSh.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bsu() {
        if (this.eZW != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eZW.bta().bte().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eZW.bta().bte().mSeqId));
            }
            if (!TextUtils.isEmpty(this.eZW.bta().bte().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eZW.bta().bte().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void Ba(String str) {
        this.eZW.btb().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eZW.btb().mServerErrorCode = errorData.getError_code();
                if (this.eZW.btb().mServerErrorCode == -1) {
                    this.eZW.btb().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eZW.btb().mServerErrorCode != 0) {
                    this.eZW.btb().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eZW.btb().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
            }
        }
    }

    private int getMode(int i) {
        switch (i) {
            case 1:
            default:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String postNetData() {
        String str;
        BdHttpCancelException e;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.eZW.bta().bte().mPostData == null || i2 >= this.eZW.bta().bte().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eZW.bta().bte().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eZW.bta().bte().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mSh.isCanceled()) {
                return null;
            }
            if (this.mSh.b(this.eZW.bta().bte().mUrl, this.eZW.bta().bte().mPostData, this.eZW.bta().bte().mRequestGzip, 5, -1, bsu()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dDB = this.mSh.dDB();
            if (dDB == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dDD = dDB.dDD();
            if (dDB == null || dDB.lW() == null || dDB.lW().size() > 0) {
            }
            this.eZW.btb().mNetErrorCode = dDD.responseCode;
            this.eZW.btb().mHeader = dDD.ME;
            if (this.eZW.btb().mNetErrorCode != 200) {
                if (this.eZW.btc().fbP != null && !TextUtils.isEmpty(this.eZW.btc().fbP.exception)) {
                    this.eZW.btb().mException = this.eZW.btc().fbP.exception;
                } else {
                    this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry);
                }
                TiebaStatic.net(this.eZW);
                return null;
            } else if (this.mSh.isCanceled()) {
                return null;
            } else {
                str = new String(dDD.retBytes, "utf-8");
                try {
                    if (this.eZW.bta().bte().mIsBaiduServer && this.eZW.bta().bte().mIsJson) {
                        Ba(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eZW.btc().fbP.downloadSize;
                    aVar.mTime = this.eZW.btc().fbP.Mb;
                    aVar.mTimesNum = this.eZW.btc().fbP.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eZW.btc().fbP.retry);
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.eZW.btb().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.eZW.btb().mNetErrorCode = -12;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.eZW.btb().mNetErrorCode = -13;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.eZW.btb().mNetErrorCode = -10;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.eZW.btb().mNetErrorCode = -15;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.eZW.btb().mNetErrorCode = -10;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                }
            }
        } catch (BdHttpCancelException e7) {
            e = e7;
            str2 = null;
        } catch (SocketException e8) {
            e = e8;
            str = null;
        } catch (SocketTimeoutException e9) {
            e = e9;
            str = null;
        } catch (Exception e10) {
            e = e10;
            str = null;
        } catch (OutOfMemoryError e11) {
            e = e11;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0394 -> B:94:0x0395). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.eZW.bta().bte().mPostData != null && this.eZW.bta().bte().mPostData.size() > 0 && !this.eZW.bta().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eZW.bta().bte().mUrl);
                if (this.eZW.bta().bte().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eZW.bta().bte().mUrl.endsWith("?") && !this.eZW.bta().bte().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eZW.bta().bte().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eZW.bta().bte().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(au.getUrlEncode(this.eZW.bta().bte().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eZW.bta().bte().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eZW.bta().bte().mRequestGzip || this.eZW.bta().bte().mIsBDImage) && !this.eZW.bta().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            iVar = null;
        } catch (SocketException e2) {
            e = e2;
            iVar = null;
        } catch (SocketTimeoutException e3) {
            e = e3;
            iVar = null;
        } catch (Exception e4) {
            e = e4;
            iVar = null;
        } catch (OutOfMemoryError e5) {
            e = e5;
            iVar = null;
        }
        if (this.mSh.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mSh.b(str, z, 5, 100, -1, -1, bsu());
        com.baidu.tieba.recapp.download.http.g dDB = this.mSh.dDB();
        if (dDB == null) {
            return null;
        }
        iVar = dDB.dDD();
        if (dDB != null) {
            try {
                if (dDB.lW() == null || dDB.lW().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eZW.btb().mNetErrorCode = -14;
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eZW);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -12;
                TiebaStatic.net(this.eZW);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -13;
                TiebaStatic.net(this.eZW);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP != null ? this.eZW.btc().fbP.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eZW.btb().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eZW);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.eZW.btb().mNetErrorCode = iVar.responseCode;
        if (this.eZW.btb().mNetErrorCode != 200) {
            this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eZW.btc().fbP != null && !TextUtils.isEmpty(this.eZW.btc().fbP.exception)) {
                this.eZW.btb().mException = this.eZW.btc().fbP.exception;
            } else {
                this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry);
            }
            TiebaStatic.net(this.eZW);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > fab) {
                    this.eZW.btb().mNetErrorCode = -11;
                    TiebaStatic.net(this.eZW);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bCP().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eZW.bta().bte().mUrl + "], size:" + i2);
                            this.eZW.btb().mNetErrorCode = -16;
                            TiebaStatic.net(this.eZW);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ad.a aVar = new ad.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.eZW.btc().fbP.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eZW.btc().fbP.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eZW.btc().fbP.retry);
        TiebaStatic.net(this.eZW);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.t
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.eZW.btb().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eZW.bta().bte().charSet = TextUtils.isEmpty(this.eZW.bta().bte().charSet) ? "UTF-8" : this.eZW.bta().bte().charSet;
            str = new String(netData, 0, netData.length, this.eZW.bta().bte().charSet);
            try {
                Ba(str);
                return str;
            } catch (Exception e) {
                e = e;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String postMultiNetData() {
        String str;
        BdHttpCancelException e;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.eZW.bta().bte().mPostData == null || i2 >= this.eZW.bta().bte().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eZW.bta().bte().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eZW.bta().bte().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mSh.isCanceled()) {
                return null;
            }
            if (this.mSh.b(this.eZW.bta().bte().mUrl, this.eZW.bta().bte().mPostData, this.eZW.bta().bte().mRequestGzip, 5, -1, bsu()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dDB = this.mSh.dDB();
            if (dDB == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dDD = dDB.dDD();
            if (dDB == null || dDB.lW() == null || dDB.lW().size() > 0) {
            }
            this.eZW.btb().mNetErrorCode = dDD.responseCode;
            this.eZW.btb().mHeader = dDD.ME;
            if (this.eZW.btb().mNetErrorCode != 200) {
                if (this.eZW.btc().fbP != null && !TextUtils.isEmpty(this.eZW.btc().fbP.exception)) {
                    this.eZW.btb().mException = this.eZW.btc().fbP.exception;
                } else {
                    this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry);
                }
                TiebaStatic.net(this.eZW);
                return null;
            } else if (this.mSh.isCanceled()) {
                return null;
            } else {
                str = new String(dDD.retBytes, "utf-8");
                try {
                    if (this.eZW.bta().bte().mIsBaiduServer && this.eZW.bta().bte().mIsJson) {
                        Ba(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eZW.btc().fbP.downloadSize;
                    aVar.mTime = this.eZW.btc().fbP.Mb;
                    aVar.mTimesNum = this.eZW.btc().fbP.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eZW.btc().fbP.retry);
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eZW.btb().mException = String.valueOf(this.eZW.btb().mNetErrorCode) + "|retryCount:" + (this.eZW.btc().fbP == null ? -1 : this.eZW.btc().fbP.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.eZW.btb().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.eZW.btb().mNetErrorCode = -12;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.eZW.btb().mNetErrorCode = -13;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.eZW.btb().mNetErrorCode = -10;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.eZW.btb().mNetErrorCode = -15;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.eZW.btb().mNetErrorCode = -10;
                    this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eZW);
                    return str;
                }
            }
        } catch (BdHttpCancelException e7) {
            e = e7;
            str2 = null;
        } catch (SocketException e8) {
            e = e8;
            str = null;
        } catch (SocketTimeoutException e9) {
            e = e9;
            str = null;
        } catch (Exception e10) {
            e = e10;
            str = null;
        } catch (OutOfMemoryError e11) {
            e = e11;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [805=5] */
    @Override // com.baidu.tbadk.core.util.t
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.mSh.isCanceled()) {
                return false;
            }
            return this.mSh.a(this.eZW.bta().bte().mUrl, (z ? new File(str) : o.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bsu(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int fad = 0;
                int fae = 0;
                int faf = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.fad = i5 / 50;
                    }
                    this.fae += i4 - this.faf;
                    this.faf = i4;
                    if (handler != null) {
                        if (this.fae > this.fad || i4 == i5) {
                            this.fae = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.eZW.btb().mNetErrorCode = -10;
            this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.eZW.btb().mNetErrorCode = -15;
            this.eZW.btb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.eZW);
        }
    }
}
