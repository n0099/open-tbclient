package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.s;
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
/* loaded from: classes20.dex */
public class d implements s {
    private static int eal = 2097152;
    private final com.baidu.tbadk.core.util.a.a eag;
    private com.baidu.tieba.recapp.download.http.c lmx = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.eag = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bI((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.dIZ : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eag.baW().bba().mPostData != null) {
            this.eag.baW().bba().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.s
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.eag.baW().bba().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eag.baW().bba().mPostData == null) {
                this.eag.baW().bba().mPostData = new ArrayList<>();
            }
            int c = c(this.eag.baW().bba().mPostData, basicNameValuePair.getName());
            int size = this.eag.baW().bba().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eag.baW().bba().mPostData.get(c).getName())) {
                    this.eag.baW().bba().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eag.baW().bba().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eag.baW().bba().mPostData.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
        int i = 0;
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
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

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, byte[] bArr) {
        if (this.eag.baW().bba().mFileData == null) {
            this.eag.baW().bba().mFileData = new HashMap<>();
        }
        this.eag.baW().bba().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.lmx.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.lmx != null) {
            this.lmx.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bay() {
        if (this.eag != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eag.baW().bba().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eag.baW().bba().mSeqId));
            }
            if (!TextUtils.isEmpty(this.eag.baW().bba().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eag.baW().bba().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void xM(String str) {
        this.eag.baX().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eag.baX().mServerErrorCode = errorData.getError_code();
                if (this.eag.baX().mServerErrorCode == -1) {
                    this.eag.baX().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eag.baX().mServerErrorCode != 0) {
                    this.eag.baX().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eag.baX().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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

    @Override // com.baidu.tbadk.core.util.s
    public String postNetData() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.eag.baW().bba().mPostData == null || i2 >= this.eag.baW().bba().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eag.baW().bba().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eag.baW().bba().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.lmx.isCanceled()) {
                return null;
            }
            if (this.lmx.b(this.eag.baW().bba().mUrl, this.eag.baW().bba().mPostData, this.eag.baW().bba().mRequestGzip, 5, -1, bay()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dco = this.lmx.dco();
            if (dco == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dcq = dco.dcq();
            if (dco == null || dco.kV() == null || dco.kV().size() > 0) {
            }
            this.eag.baX().mNetErrorCode = dcq.responseCode;
            this.eag.baX().mHeader = dcq.Lf;
            if (this.eag.baX().mNetErrorCode != 200) {
                if (this.eag.baY().ebN != null && !TextUtils.isEmpty(this.eag.baY().ebN.exception)) {
                    this.eag.baX().mException = this.eag.baY().ebN.exception;
                } else {
                    this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry);
                }
                TiebaStatic.net(this.eag);
                return null;
            } else if (this.lmx.isCanceled()) {
                return null;
            } else {
                str = new String(dcq.retBytes, "utf-8");
                try {
                    if (this.eag.baW().bba().mIsBaiduServer && this.eag.baW().bba().mIsJson) {
                        xM(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eag.baY().ebN.downloadSize;
                    aVar.mTime = this.eag.baY().ebN.KE;
                    aVar.mTimesNum = this.eag.baY().ebN.retry;
                    aVar.mMethod = 1;
                    ac.a(aVar);
                    ac.mErrorNums.set(this.eag.baY().ebN.retry);
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eag.baX().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eag.baX().mNetErrorCode = -15;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eag.baX().mNetErrorCode = -12;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eag.baX().mNetErrorCode = -13;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eag.baX().mNetErrorCode = -10;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eag.baX().mNetErrorCode = -10;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x05bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0396 -> B:94:0x0397). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.eag.baW().bba().mPostData != null && this.eag.baW().bba().mPostData.size() > 0 && !this.eag.baW().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eag.baW().bba().mUrl);
                if (this.eag.baW().bba().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eag.baW().bba().mUrl.endsWith("?") && !this.eag.baW().bba().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eag.baW().bba().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eag.baW().bba().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(as.getUrlEncode(this.eag.baW().bba().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eag.baW().bba().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eag.baW().bba().mRequestGzip || this.eag.baW().bba().mIsBDImage) && !this.eag.baW().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            iVar2 = null;
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
        if (this.lmx.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.lmx.b(str, z, 5, 100, -1, -1, bay());
        com.baidu.tieba.recapp.download.http.g dco = this.lmx.dco();
        if (dco == null) {
            return null;
        }
        iVar = dco.dcq();
        if (dco != null) {
            try {
                if (dco.kV() == null || dco.kV().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eag.baX().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -12;
                TiebaStatic.net(this.eag);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -13;
                TiebaStatic.net(this.eag);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eag);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN != null ? this.eag.baY().ebN.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eag.baX().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eag);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.eag.baX().mNetErrorCode = iVar.responseCode;
        if (this.eag.baX().mNetErrorCode != 200) {
            this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eag.baY().ebN != null && !TextUtils.isEmpty(this.eag.baY().ebN.exception)) {
                this.eag.baX().mException = this.eag.baY().ebN.exception;
            } else {
                this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry);
            }
            TiebaStatic.net(this.eag);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eal) {
                    this.eag.baX().mNetErrorCode = -11;
                    TiebaStatic.net(this.eag);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bkk().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eag.baW().bba().mUrl + "], size:" + i2);
                            this.eag.baX().mNetErrorCode = -16;
                            TiebaStatic.net(this.eag);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ac.a aVar = new ac.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.eag.baY().ebN.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eag.baY().ebN.retry;
        aVar.mMethod = 2;
        ac.a(aVar);
        ac.mErrorNums.set(this.eag.baY().ebN.retry);
        TiebaStatic.net(this.eag);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eag.baX().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eag.baW().bba().charSet = TextUtils.isEmpty(this.eag.baW().bba().charSet) ? "UTF-8" : this.eag.baW().bba().charSet;
            str = new String(netData, 0, netData.length, this.eag.baW().bba().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            xM(str);
            return str;
        } catch (Exception e5) {
            e2 = e5;
            BdLog.e(e2.getMessage());
            return str;
        } catch (OutOfMemoryError e6) {
            e = e6;
            BdLog.e(e.getMessage());
            return str;
        }
    }

    @Override // com.baidu.tbadk.core.util.s
    public String postMultiNetData() {
        Throwable th;
        String str;
        Exception e;
        SocketTimeoutException e2;
        SocketException e3;
        OutOfMemoryError e4;
        BdHttpCancelException bdHttpCancelException;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.eag.baW().bba().mPostData == null || i2 >= this.eag.baW().bba().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eag.baW().bba().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eag.baW().bba().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.lmx.isCanceled()) {
                return null;
            }
            if (this.lmx.b(this.eag.baW().bba().mUrl, this.eag.baW().bba().mPostData, this.eag.baW().bba().mRequestGzip, 5, -1, bay()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dco = this.lmx.dco();
            if (dco == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dcq = dco.dcq();
            if (dco == null || dco.kV() == null || dco.kV().size() > 0) {
            }
            this.eag.baX().mNetErrorCode = dcq.responseCode;
            this.eag.baX().mHeader = dcq.Lf;
            if (this.eag.baX().mNetErrorCode != 200) {
                if (this.eag.baY().ebN != null && !TextUtils.isEmpty(this.eag.baY().ebN.exception)) {
                    this.eag.baX().mException = this.eag.baY().ebN.exception;
                } else {
                    this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry);
                }
                TiebaStatic.net(this.eag);
                return null;
            } else if (this.lmx.isCanceled()) {
                return null;
            } else {
                str = new String(dcq.retBytes, "utf-8");
                try {
                    if (this.eag.baW().bba().mIsBaiduServer && this.eag.baW().bba().mIsJson) {
                        xM(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eag.baY().ebN.downloadSize;
                    aVar.mTime = this.eag.baY().ebN.KE;
                    aVar.mTimesNum = this.eag.baY().ebN.retry;
                    aVar.mMethod = 1;
                    ac.a(aVar);
                    ac.mErrorNums.set(this.eag.baY().ebN.retry);
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eag.baX().mException = String.valueOf(this.eag.baX().mNetErrorCode) + "|retryCount:" + (this.eag.baY().ebN == null ? -1 : this.eag.baY().ebN.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eag.baX().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eag.baX().mNetErrorCode = -15;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eag.baX().mNetErrorCode = -12;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eag.baX().mNetErrorCode = -13;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eag.baX().mNetErrorCode = -10;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eag.baX().mNetErrorCode = -10;
                    this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eag);
                    return str;
                }
            }
        } catch (BdHttpCancelException e10) {
            bdHttpCancelException = e10;
            str2 = null;
        } catch (OutOfMemoryError e11) {
            e4 = e11;
            str = null;
        } catch (SocketException e12) {
            e3 = e12;
            str = null;
        } catch (SocketTimeoutException e13) {
            e2 = e13;
            str = null;
        } catch (Exception e14) {
            e = e14;
            str = null;
        } catch (Throwable th3) {
            th = th3;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [805=5] */
    @Override // com.baidu.tbadk.core.util.s
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.lmx.isCanceled()) {
                return false;
            }
            return this.lmx.a(this.eag.baW().bba().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bay(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int ean = 0;
                int eao = 0;
                int eap = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.ean = i5 / 50;
                    }
                    this.eao += i4 - this.eap;
                    this.eap = i4;
                    if (handler != null) {
                        if (this.eao > this.ean || i4 == i5) {
                            this.eao = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.eag.baX().mNetErrorCode = -10;
            this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.eag.baX().mNetErrorCode = -15;
            this.eag.baX().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.eag);
        }
    }
}
