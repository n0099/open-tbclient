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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes25.dex */
public class d implements s {
    private static int eLH = 2097152;
    private final com.baidu.tbadk.core.util.a.a eLC;
    private com.baidu.tieba.recapp.download.http.c mui = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.eLC = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bP((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eti : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eLC.bqH().bqL().mPostData != null) {
            this.eLC.bqH().bqL().mPostData.clear();
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
        return this.eLC.bqH().bqL().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eLC.bqH().bqL().mPostData == null) {
                this.eLC.bqH().bqL().mPostData = new ArrayList<>();
            }
            int c = c(this.eLC.bqH().bqL().mPostData, basicNameValuePair.getName());
            int size = this.eLC.bqH().bqL().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eLC.bqH().bqL().mPostData.get(c).getName())) {
                    this.eLC.bqH().bqL().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eLC.bqH().bqL().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eLC.bqH().bqL().mPostData.add(c, basicNameValuePair);
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
        if (this.eLC.bqH().bqL().mFileData == null) {
            this.eLC.bqH().bqL().mFileData = new HashMap<>();
        }
        this.eLC.bqH().bqL().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.mui.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.mui != null) {
            this.mui.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bqd() {
        if (this.eLC != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eLC.bqH().bqL().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eLC.bqH().bqL().mSeqId));
            }
            if (!TextUtils.isEmpty(this.eLC.bqH().bqL().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eLC.bqH().bqL().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void Bp(String str) {
        this.eLC.bqI().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eLC.bqI().mServerErrorCode = errorData.getError_code();
                if (this.eLC.bqI().mServerErrorCode == -1) {
                    this.eLC.bqI().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eLC.bqI().mServerErrorCode != 0) {
                    this.eLC.bqI().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eLC.bqI().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.eLC.bqH().bqL().mPostData == null || i2 >= this.eLC.bqH().bqL().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eLC.bqH().bqL().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eLC.bqH().bqL().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mui.isCanceled()) {
                return null;
            }
            if (this.mui.b(this.eLC.bqH().bqL().mUrl, this.eLC.bqH().bqL().mPostData, this.eLC.bqH().bqL().mRequestGzip, 5, -1, bqd()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dAc = this.mui.dAc();
            if (dAc == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dAe = dAc.dAe();
            if (dAc == null || dAc.mz() == null || dAc.mz().size() > 0) {
            }
            this.eLC.bqI().mNetErrorCode = dAe.responseCode;
            this.eLC.bqI().mHeader = dAe.Mp;
            if (this.eLC.bqI().mNetErrorCode != 200) {
                if (this.eLC.bqJ().eNu != null && !TextUtils.isEmpty(this.eLC.bqJ().eNu.exception)) {
                    this.eLC.bqI().mException = this.eLC.bqJ().eNu.exception;
                } else {
                    this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry);
                }
                TiebaStatic.net(this.eLC);
                return null;
            } else if (this.mui.isCanceled()) {
                return null;
            } else {
                str = new String(dAe.retBytes, "utf-8");
                try {
                    if (this.eLC.bqH().bqL().mIsBaiduServer && this.eLC.bqH().bqL().mIsJson) {
                        Bp(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eLC.bqJ().eNu.downloadSize;
                    aVar.mTime = this.eLC.bqJ().eNu.LK;
                    aVar.mTimesNum = this.eLC.bqJ().eNu.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eLC.bqJ().eNu.retry);
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eLC.bqI().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eLC.bqI().mNetErrorCode = -15;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eLC.bqI().mNetErrorCode = -12;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eLC.bqI().mNetErrorCode = -13;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eLC.bqI().mNetErrorCode = -10;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eLC.bqI().mNetErrorCode = -10;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eLC);
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
            if (this.eLC.bqH().bqL().mPostData != null && this.eLC.bqH().bqL().mPostData.size() > 0 && !this.eLC.bqH().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eLC.bqH().bqL().mUrl);
                if (this.eLC.bqH().bqL().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eLC.bqH().bqL().mUrl.endsWith("?") && !this.eLC.bqH().bqL().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eLC.bqH().bqL().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eLC.bqH().bqL().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(au.getUrlEncode(this.eLC.bqH().bqL().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eLC.bqH().bqL().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eLC.bqH().bqL().mRequestGzip || this.eLC.bqH().bqL().mIsBDImage) && !this.eLC.bqH().mIsFromCDN) {
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
        if (this.mui.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mui.b(str, z, 5, 100, -1, -1, bqd());
        com.baidu.tieba.recapp.download.http.g dAc = this.mui.dAc();
        if (dAc == null) {
            return null;
        }
        iVar = dAc.dAe();
        if (dAc != null) {
            try {
                if (dAc.mz() == null || dAc.mz().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eLC.bqI().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -12;
                TiebaStatic.net(this.eLC);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -13;
                TiebaStatic.net(this.eLC);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eLC);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu != null ? this.eLC.bqJ().eNu.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eLC.bqI().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eLC);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.eLC.bqI().mNetErrorCode = iVar.responseCode;
        if (this.eLC.bqI().mNetErrorCode != 200) {
            this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eLC.bqJ().eNu != null && !TextUtils.isEmpty(this.eLC.bqJ().eNu.exception)) {
                this.eLC.bqI().mException = this.eLC.bqJ().eNu.exception;
            } else {
                this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry);
            }
            TiebaStatic.net(this.eLC);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eLH) {
                    this.eLC.bqI().mNetErrorCode = -11;
                    TiebaStatic.net(this.eLC);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bAt().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eLC.bqH().bqL().mUrl + "], size:" + i2);
                            this.eLC.bqI().mNetErrorCode = -16;
                            TiebaStatic.net(this.eLC);
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
        aVar.mSize = this.eLC.bqJ().eNu.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eLC.bqJ().eNu.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eLC.bqJ().eNu.retry);
        TiebaStatic.net(this.eLC);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eLC.bqI().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eLC.bqH().bqL().charSet = TextUtils.isEmpty(this.eLC.bqH().bqL().charSet) ? "UTF-8" : this.eLC.bqH().bqL().charSet;
            str = new String(netData, 0, netData.length, this.eLC.bqH().bqL().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            Bp(str);
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
            if (this.eLC.bqH().bqL().mPostData == null || i2 >= this.eLC.bqH().bqL().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eLC.bqH().bqL().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eLC.bqH().bqL().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mui.isCanceled()) {
                return null;
            }
            if (this.mui.b(this.eLC.bqH().bqL().mUrl, this.eLC.bqH().bqL().mPostData, this.eLC.bqH().bqL().mRequestGzip, 5, -1, bqd()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dAc = this.mui.dAc();
            if (dAc == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dAe = dAc.dAe();
            if (dAc == null || dAc.mz() == null || dAc.mz().size() > 0) {
            }
            this.eLC.bqI().mNetErrorCode = dAe.responseCode;
            this.eLC.bqI().mHeader = dAe.Mp;
            if (this.eLC.bqI().mNetErrorCode != 200) {
                if (this.eLC.bqJ().eNu != null && !TextUtils.isEmpty(this.eLC.bqJ().eNu.exception)) {
                    this.eLC.bqI().mException = this.eLC.bqJ().eNu.exception;
                } else {
                    this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry);
                }
                TiebaStatic.net(this.eLC);
                return null;
            } else if (this.mui.isCanceled()) {
                return null;
            } else {
                str = new String(dAe.retBytes, "utf-8");
                try {
                    if (this.eLC.bqH().bqL().mIsBaiduServer && this.eLC.bqH().bqL().mIsJson) {
                        Bp(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eLC.bqJ().eNu.downloadSize;
                    aVar.mTime = this.eLC.bqJ().eNu.LK;
                    aVar.mTimesNum = this.eLC.bqJ().eNu.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eLC.bqJ().eNu.retry);
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eLC.bqI().mException = String.valueOf(this.eLC.bqI().mNetErrorCode) + "|retryCount:" + (this.eLC.bqJ().eNu == null ? -1 : this.eLC.bqJ().eNu.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eLC.bqI().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eLC.bqI().mNetErrorCode = -15;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eLC.bqI().mNetErrorCode = -12;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eLC.bqI().mNetErrorCode = -13;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eLC.bqI().mNetErrorCode = -10;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eLC);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eLC.bqI().mNetErrorCode = -10;
                    this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eLC);
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
            if (this.mui.isCanceled()) {
                return false;
            }
            return this.mui.a(this.eLC.bqH().bqL().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bqd(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int eLJ = 0;
                int eLK = 0;
                int eLL = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.eLJ = i5 / 50;
                    }
                    this.eLK += i4 - this.eLL;
                    this.eLL = i4;
                    if (handler != null) {
                        if (this.eLK > this.eLJ || i4 == i5) {
                            this.eLK = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.eLC.bqI().mNetErrorCode = -10;
            this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.eLC.bqI().mNetErrorCode = -15;
            this.eLC.bqI().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.eLC);
        }
    }
}
