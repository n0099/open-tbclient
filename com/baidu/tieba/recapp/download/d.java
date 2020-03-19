package com.baidu.tieba.recapp.download;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.q;
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
public class d implements q {
    private static int cZF = 2097152;
    private final com.baidu.tbadk.core.util.a.a cZA;
    private com.baidu.tieba.recapp.download.http.c jIx = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.cZA = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.au((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.cKL : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cZA.aGL().aGO().mPostData != null) {
            this.cZA.aGL().aGO().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.cZA.aGL().aGO().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cZA.aGL().aGO().mPostData == null) {
                this.cZA.aGL().aGO().mPostData = new ArrayList<>();
            }
            int c = c(this.cZA.aGL().aGO().mPostData, basicNameValuePair.getName());
            int size = this.cZA.aGL().aGO().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.cZA.aGL().aGO().mPostData.get(c).getName())) {
                    this.cZA.aGL().aGO().mPostData.set(c, basicNameValuePair);
                } else {
                    this.cZA.aGL().aGO().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.cZA.aGL().aGO().mPostData.add(c, basicNameValuePair);
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

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, byte[] bArr) {
        if (this.cZA.aGL().aGO().mFileData == null) {
            this.cZA.aGL().aGO().mFileData = new HashMap<>();
        }
        this.cZA.aGL().aGO().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.jIx.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.jIx != null) {
            this.jIx.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> aGn() {
        if (this.cZA != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cZA.aGL().aGO().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cZA.aGL().aGO().mSeqId));
            }
            if (!TextUtils.isEmpty(this.cZA.aGL().aGO().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cZA.aGL().aGO().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void ts(String str) {
        this.cZA.aGM().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cZA.aGM().mServerErrorCode = errorData.getError_code();
                if (this.cZA.aGM().mServerErrorCode == -1) {
                    this.cZA.aGM().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cZA.aGM().mServerErrorCode != 0) {
                    this.cZA.aGM().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cZA.aGM().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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

    @Override // com.baidu.tbadk.core.util.q
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
            if (this.cZA.aGL().aGO().mPostData == null || i2 >= this.cZA.aGL().aGO().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cZA.aGL().aGO().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cZA.aGL().aGO().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.jIx.isCanceled()) {
                return null;
            }
            if (this.jIx.b(this.cZA.aGL().aGO().mUrl, this.cZA.aGL().aGO().mPostData, this.cZA.aGL().aGO().mRequestGzip, 5, -1, aGn()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cDe = this.jIx.cDe();
            if (cDe == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cDg = cDe.cDg();
            if (cDe == null || cDe.fZ() == null || cDe.fZ().size() > 0) {
            }
            this.cZA.aGM().mNetErrorCode = cDg.responseCode;
            this.cZA.aGM().mHeader = cDg.rq;
            if (this.cZA.aGM().mNetErrorCode != 200) {
                if (this.cZA.aGN().dbb != null && !TextUtils.isEmpty(this.cZA.aGN().dbb.exception)) {
                    this.cZA.aGM().mException = this.cZA.aGN().dbb.exception;
                } else {
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry);
                }
                TiebaStatic.net(this.cZA);
                return null;
            } else if (this.jIx.isCanceled()) {
                return null;
            } else {
                str = new String(cDg.retBytes, "utf-8");
                try {
                    if (this.cZA.aGL().aGO().mIsBaiduServer && this.cZA.aGL().aGO().mIsJson) {
                        ts(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cZA.aGN().dbb.downloadSize;
                    aVar.mTime = this.cZA.aGN().dbb.qN;
                    aVar.mTimesNum = this.cZA.aGN().dbb.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cZA.aGN().dbb.retry);
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cZA.aGM().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cZA.aGM().mNetErrorCode = -12;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cZA.aGM().mNetErrorCode = -13;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cZA.aGM().mNetErrorCode = -15;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cZA);
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
    @Override // com.baidu.tbadk.core.util.q
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
            if (this.cZA.aGL().aGO().mPostData != null && this.cZA.aGL().aGO().mPostData.size() > 0 && !this.cZA.aGL().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cZA.aGL().aGO().mUrl);
                if (this.cZA.aGL().aGO().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cZA.aGL().aGO().mUrl.endsWith("?") && !this.cZA.aGL().aGO().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.cZA.aGL().aGO().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.cZA.aGL().aGO().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.cZA.aGL().aGO().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cZA.aGL().aGO().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cZA.aGL().aGO().mRequestGzip || this.cZA.aGL().aGO().mIsBDImage) && !this.cZA.aGL().mIsFromCDN) {
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
        if (this.jIx.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.jIx.b(str, z, 5, 100, -1, -1, aGn());
        com.baidu.tieba.recapp.download.http.g cDe = this.jIx.cDe();
        if (cDe == null) {
            return null;
        }
        iVar = cDe.cDg();
        if (cDe != null) {
            try {
                if (cDe.fZ() == null || cDe.fZ().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cZA.aGM().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cZA);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cZA);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -12;
                TiebaStatic.net(this.cZA);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb != null ? this.cZA.aGN().dbb.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cZA.aGM().mNetErrorCode = -13;
                TiebaStatic.net(this.cZA);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.cZA.aGM().mNetErrorCode = iVar.responseCode;
        if (this.cZA.aGM().mNetErrorCode != 200) {
            this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cZA.aGN().dbb != null && !TextUtils.isEmpty(this.cZA.aGN().dbb.exception)) {
                this.cZA.aGM().mException = this.cZA.aGN().dbb.exception;
            } else {
                this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry);
            }
            TiebaStatic.net(this.cZA);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > cZF) {
                    this.cZA.aGM().mNetErrorCode = -11;
                    TiebaStatic.net(this.cZA);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aPV().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cZA.aGL().aGO().mUrl + "], size:" + i2);
                            this.cZA.aGM().mNetErrorCode = -16;
                            TiebaStatic.net(this.cZA);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        aa.a aVar = new aa.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.cZA.aGN().dbb.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cZA.aGN().dbb.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cZA.aGN().dbb.retry);
        TiebaStatic.net(this.cZA);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cZA.aGM().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cZA.aGL().aGO().charSet = TextUtils.isEmpty(this.cZA.aGL().aGO().charSet) ? "UTF-8" : this.cZA.aGL().aGO().charSet;
            str = new String(netData, 0, netData.length, this.cZA.aGL().aGO().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            ts(str);
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

    @Override // com.baidu.tbadk.core.util.q
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
            if (this.cZA.aGL().aGO().mPostData == null || i2 >= this.cZA.aGL().aGO().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cZA.aGL().aGO().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cZA.aGL().aGO().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.jIx.isCanceled()) {
                return null;
            }
            if (this.jIx.b(this.cZA.aGL().aGO().mUrl, this.cZA.aGL().aGO().mPostData, this.cZA.aGL().aGO().mRequestGzip, 5, -1, aGn()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cDe = this.jIx.cDe();
            if (cDe == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cDg = cDe.cDg();
            if (cDe == null || cDe.fZ() == null || cDe.fZ().size() > 0) {
            }
            this.cZA.aGM().mNetErrorCode = cDg.responseCode;
            this.cZA.aGM().mHeader = cDg.rq;
            if (this.cZA.aGM().mNetErrorCode != 200) {
                if (this.cZA.aGN().dbb != null && !TextUtils.isEmpty(this.cZA.aGN().dbb.exception)) {
                    this.cZA.aGM().mException = this.cZA.aGN().dbb.exception;
                } else {
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry);
                }
                TiebaStatic.net(this.cZA);
                return null;
            } else if (this.jIx.isCanceled()) {
                return null;
            } else {
                str = new String(cDg.retBytes, "utf-8");
                try {
                    if (this.cZA.aGL().aGO().mIsBaiduServer && this.cZA.aGL().aGO().mIsJson) {
                        ts(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cZA.aGN().dbb.downloadSize;
                    aVar.mTime = this.cZA.aGN().dbb.qN;
                    aVar.mTimesNum = this.cZA.aGN().dbb.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cZA.aGN().dbb.retry);
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cZA.aGM().mException = String.valueOf(this.cZA.aGM().mNetErrorCode) + "|retryCount:" + (this.cZA.aGN().dbb == null ? -1 : this.cZA.aGN().dbb.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cZA.aGM().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cZA.aGM().mNetErrorCode = -12;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cZA.aGM().mNetErrorCode = -13;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cZA.aGM().mNetErrorCode = -15;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cZA);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cZA.aGM().mNetErrorCode = -10;
                    this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cZA);
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
    @Override // com.baidu.tbadk.core.util.q
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.jIx.isCanceled()) {
                return false;
            }
            return this.jIx.a(this.cZA.aGL().aGO().mUrl, (z ? new File(str) : m.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, aGn(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int cZH = 0;
                int cZI = 0;
                int cZJ = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void k(int i4, int i5) {
                    if (i5 > 0) {
                        this.cZH = i5 / 50;
                    }
                    this.cZI += i4 - this.cZJ;
                    this.cZJ = i4;
                    if (handler != null) {
                        if (this.cZI > this.cZH || i4 == i5) {
                            this.cZI = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.cZA.aGM().mNetErrorCode = -10;
            this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.cZA.aGM().mNetErrorCode = -15;
            this.cZA.aGM().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.cZA);
        }
    }
}
