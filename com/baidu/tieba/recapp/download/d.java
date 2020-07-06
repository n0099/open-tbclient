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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.r;
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
/* loaded from: classes13.dex */
public class d implements r {
    private static int dTS = 2097152;
    private final com.baidu.tbadk.core.util.a.a dTN;
    private com.baidu.tieba.recapp.download.http.c lfj = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.dTN = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bK((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.dDc : cookie);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.dTN.aWV().aWZ().mPostData != null) {
            this.dTN.aWV().aWZ().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.r
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.dTN.aWV().aWZ().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.r
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.r
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.dTN.aWV().aWZ().mPostData == null) {
                this.dTN.aWV().aWZ().mPostData = new ArrayList<>();
            }
            int c = c(this.dTN.aWV().aWZ().mPostData, basicNameValuePair.getName());
            int size = this.dTN.aWV().aWZ().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.dTN.aWV().aWZ().mPostData.get(c).getName())) {
                    this.dTN.aWV().aWZ().mPostData.set(c, basicNameValuePair);
                } else {
                    this.dTN.aWV().aWZ().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.dTN.aWV().aWZ().mPostData.add(c, basicNameValuePair);
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

    @Override // com.baidu.tbadk.core.util.r
    public void addPostData(String str, byte[] bArr) {
        if (this.dTN.aWV().aWZ().mFileData == null) {
            this.dTN.aWV().aWZ().mFileData = new HashMap<>();
        }
        this.dTN.aWV().aWZ().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.r
    public void cancelNetConnect() {
        this.lfj.cancel();
    }

    @Override // com.baidu.tbadk.core.util.r
    public void setCancel() {
        if (this.lfj != null) {
            this.lfj.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> aWx() {
        if (this.dTN != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.dTN.aWV().aWZ().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dTN.aWV().aWZ().mSeqId));
            }
            if (!TextUtils.isEmpty(this.dTN.aWV().aWZ().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.dTN.aWV().aWZ().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void wE(String str) {
        this.dTN.aWW().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.dTN.aWW().mServerErrorCode = errorData.getError_code();
                if (this.dTN.aWW().mServerErrorCode == -1) {
                    this.dTN.aWW().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.dTN.aWW().mServerErrorCode != 0) {
                    this.dTN.aWW().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.dTN.aWW().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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

    @Override // com.baidu.tbadk.core.util.r
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
            if (this.dTN.aWV().aWZ().mPostData == null || i2 >= this.dTN.aWV().aWZ().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dTN.aWV().aWZ().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.dTN.aWV().aWZ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.lfj.isCanceled()) {
                return null;
            }
            if (this.lfj.b(this.dTN.aWV().aWZ().mUrl, this.dTN.aWV().aWZ().mPostData, this.dTN.aWV().aWZ().mRequestGzip, 5, -1, aWx()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cZh = this.lfj.cZh();
            if (cZh == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cZj = cZh.cZj();
            if (cZh == null || cZh.kV() == null || cZh.kV().size() > 0) {
            }
            this.dTN.aWW().mNetErrorCode = cZj.responseCode;
            this.dTN.aWW().mHeader = cZj.Lf;
            if (this.dTN.aWW().mNetErrorCode != 200) {
                if (this.dTN.aWX().dVs != null && !TextUtils.isEmpty(this.dTN.aWX().dVs.exception)) {
                    this.dTN.aWW().mException = this.dTN.aWX().dVs.exception;
                } else {
                    this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry);
                }
                TiebaStatic.net(this.dTN);
                return null;
            } else if (this.lfj.isCanceled()) {
                return null;
            } else {
                str = new String(cZj.retBytes, "utf-8");
                try {
                    if (this.dTN.aWV().aWZ().mIsBaiduServer && this.dTN.aWV().aWZ().mIsJson) {
                        wE(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.dTN.aWX().dVs.downloadSize;
                    aVar.mTime = this.dTN.aWX().dVs.KE;
                    aVar.mTimesNum = this.dTN.aWX().dVs.retry;
                    aVar.mMethod = 1;
                    ab.a(aVar);
                    ab.mErrorNums.set(this.dTN.aWX().dVs.retry);
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.dTN.aWW().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.dTN.aWW().mNetErrorCode = -12;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.dTN.aWW().mNetErrorCode = -13;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.dTN.aWW().mNetErrorCode = -10;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.dTN.aWW().mNetErrorCode = -15;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.dTN.aWW().mNetErrorCode = -10;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.dTN);
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

    /* JADX WARN: Removed duplicated region for block: B:118:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0396 -> B:94:0x0397). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.r
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
            if (this.dTN.aWV().aWZ().mPostData != null && this.dTN.aWV().aWZ().mPostData.size() > 0 && !this.dTN.aWV().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.dTN.aWV().aWZ().mUrl);
                if (this.dTN.aWV().aWZ().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.dTN.aWV().aWZ().mUrl.endsWith("?") && !this.dTN.aWV().aWZ().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.dTN.aWV().aWZ().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.dTN.aWV().aWZ().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(ar.getUrlEncode(this.dTN.aWV().aWZ().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.dTN.aWV().aWZ().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.dTN.aWV().aWZ().mRequestGzip || this.dTN.aWV().aWZ().mIsBDImage) && !this.dTN.aWV().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            iVar2 = null;
        } catch (OutOfMemoryError e2) {
            e = e2;
            iVar = null;
        } catch (SocketException e3) {
            e = e3;
            iVar = null;
        } catch (SocketTimeoutException e4) {
            e = e4;
            iVar = null;
        } catch (Exception e5) {
            e = e5;
            iVar = null;
        }
        if (this.lfj.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.lfj.b(str, z, 5, 100, -1, -1, aWx());
        com.baidu.tieba.recapp.download.http.g cZh = this.lfj.cZh();
        if (cZh == null) {
            return null;
        }
        iVar = cZh.cZj();
        if (cZh != null) {
            try {
                if (cZh.kV() == null || cZh.kV().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dTN.aWW().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dTN);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dTN);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -12;
                TiebaStatic.net(this.dTN);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs != null ? this.dTN.aWX().dVs.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dTN.aWW().mNetErrorCode = -13;
                TiebaStatic.net(this.dTN);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.dTN.aWW().mNetErrorCode = iVar.responseCode;
        if (this.dTN.aWW().mNetErrorCode != 200) {
            this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.dTN.aWX().dVs != null && !TextUtils.isEmpty(this.dTN.aWX().dVs.exception)) {
                this.dTN.aWW().mException = this.dTN.aWX().dVs.exception;
            } else {
                this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry);
            }
            TiebaStatic.net(this.dTN);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > dTS) {
                    this.dTN.aWW().mNetErrorCode = -11;
                    TiebaStatic.net(this.dTN);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bgz().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.dTN.aWV().aWZ().mUrl + "], size:" + i2);
                            this.dTN.aWW().mNetErrorCode = -16;
                            TiebaStatic.net(this.dTN);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ab.a aVar = new ab.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.dTN.aWX().dVs.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.dTN.aWX().dVs.retry;
        aVar.mMethod = 2;
        ab.a(aVar);
        ab.mErrorNums.set(this.dTN.aWX().dVs.retry);
        TiebaStatic.net(this.dTN);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.r
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.dTN.aWW().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.dTN.aWV().aWZ().charSet = TextUtils.isEmpty(this.dTN.aWV().aWZ().charSet) ? "UTF-8" : this.dTN.aWV().aWZ().charSet;
            str = new String(netData, 0, netData.length, this.dTN.aWV().aWZ().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            wE(str);
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

    @Override // com.baidu.tbadk.core.util.r
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
            if (this.dTN.aWV().aWZ().mPostData == null || i2 >= this.dTN.aWV().aWZ().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dTN.aWV().aWZ().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.dTN.aWV().aWZ().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.lfj.isCanceled()) {
                return null;
            }
            if (this.lfj.b(this.dTN.aWV().aWZ().mUrl, this.dTN.aWV().aWZ().mPostData, this.dTN.aWV().aWZ().mRequestGzip, 5, -1, aWx()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cZh = this.lfj.cZh();
            if (cZh == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cZj = cZh.cZj();
            if (cZh == null || cZh.kV() == null || cZh.kV().size() > 0) {
            }
            this.dTN.aWW().mNetErrorCode = cZj.responseCode;
            this.dTN.aWW().mHeader = cZj.Lf;
            if (this.dTN.aWW().mNetErrorCode != 200) {
                if (this.dTN.aWX().dVs != null && !TextUtils.isEmpty(this.dTN.aWX().dVs.exception)) {
                    this.dTN.aWW().mException = this.dTN.aWX().dVs.exception;
                } else {
                    this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry);
                }
                TiebaStatic.net(this.dTN);
                return null;
            } else if (this.lfj.isCanceled()) {
                return null;
            } else {
                str = new String(cZj.retBytes, "utf-8");
                try {
                    if (this.dTN.aWV().aWZ().mIsBaiduServer && this.dTN.aWV().aWZ().mIsJson) {
                        wE(str);
                    }
                    ab.a aVar = new ab.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.dTN.aWX().dVs.downloadSize;
                    aVar.mTime = this.dTN.aWX().dVs.KE;
                    aVar.mTimesNum = this.dTN.aWX().dVs.retry;
                    aVar.mMethod = 1;
                    ab.a(aVar);
                    ab.mErrorNums.set(this.dTN.aWX().dVs.retry);
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.dTN.aWW().mException = String.valueOf(this.dTN.aWW().mNetErrorCode) + "|retryCount:" + (this.dTN.aWX().dVs == null ? -1 : this.dTN.aWX().dVs.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.dTN.aWW().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.dTN.aWW().mNetErrorCode = -12;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.dTN.aWW().mNetErrorCode = -13;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.dTN.aWW().mNetErrorCode = -10;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.dTN.aWW().mNetErrorCode = -15;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.dTN);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.dTN.aWW().mNetErrorCode = -10;
                    this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.dTN);
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
    @Override // com.baidu.tbadk.core.util.r
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.lfj.isCanceled()) {
                return false;
            }
            return this.lfj.a(this.dTN.aWV().aWZ().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, aWx(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int dTU = 0;
                int dTV = 0;
                int dTW = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.dTU = i5 / 50;
                    }
                    this.dTV += i4 - this.dTW;
                    this.dTW = i4;
                    if (handler != null) {
                        if (this.dTV > this.dTU || i4 == i5) {
                            this.dTV = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.dTN.aWW().mNetErrorCode = -10;
            this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.dTN.aWW().mNetErrorCode = -15;
            this.dTN.aWW().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.dTN);
        }
    }
}
