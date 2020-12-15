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
/* loaded from: classes26.dex */
public class d implements s {
    private static int eST = 2097152;
    private final com.baidu.tbadk.core.util.a.a eSO;
    private com.baidu.tieba.recapp.download.http.c mIv = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.eSO = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bS((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eAk : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eSO.bue().bui().mPostData != null) {
            this.eSO.bue().bui().mPostData.clear();
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
        return this.eSO.bue().bui().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eSO.bue().bui().mPostData == null) {
                this.eSO.bue().bui().mPostData = new ArrayList<>();
            }
            int c = c(this.eSO.bue().bui().mPostData, basicNameValuePair.getName());
            int size = this.eSO.bue().bui().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eSO.bue().bui().mPostData.get(c).getName())) {
                    this.eSO.bue().bui().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eSO.bue().bui().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eSO.bue().bui().mPostData.add(c, basicNameValuePair);
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
        if (this.eSO.bue().bui().mFileData == null) {
            this.eSO.bue().bui().mFileData = new HashMap<>();
        }
        this.eSO.bue().bui().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.mIv.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.mIv != null) {
            this.mIv.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bty() {
        if (this.eSO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eSO.bue().bui().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eSO.bue().bui().mSeqId));
            }
            if (!TextUtils.isEmpty(this.eSO.bue().bui().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eSO.bue().bui().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void BW(String str) {
        this.eSO.buf().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eSO.buf().mServerErrorCode = errorData.getError_code();
                if (this.eSO.buf().mServerErrorCode == -1) {
                    this.eSO.buf().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eSO.buf().mServerErrorCode != 0) {
                    this.eSO.buf().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eSO.buf().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.eSO.bue().bui().mPostData == null || i2 >= this.eSO.bue().bui().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eSO.bue().bui().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eSO.bue().bui().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mIv.isCanceled()) {
                return null;
            }
            if (this.mIv.b(this.eSO.bue().bui().mUrl, this.eSO.bue().bui().mPostData, this.eSO.bue().bui().mRequestGzip, 5, -1, bty()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dFu = this.mIv.dFu();
            if (dFu == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dFw = dFu.dFw();
            if (dFu == null || dFu.mz() == null || dFu.mz().size() > 0) {
            }
            this.eSO.buf().mNetErrorCode = dFw.responseCode;
            this.eSO.buf().mHeader = dFw.Nk;
            if (this.eSO.buf().mNetErrorCode != 200) {
                if (this.eSO.bug().eUJ != null && !TextUtils.isEmpty(this.eSO.bug().eUJ.exception)) {
                    this.eSO.buf().mException = this.eSO.bug().eUJ.exception;
                } else {
                    this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ == null ? -1 : this.eSO.bug().eUJ.retry);
                }
                TiebaStatic.net(this.eSO);
                return null;
            } else if (this.mIv.isCanceled()) {
                return null;
            } else {
                str = new String(dFw.retBytes, "utf-8");
                try {
                    if (this.eSO.bue().bui().mIsBaiduServer && this.eSO.bue().bui().mIsJson) {
                        BW(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eSO.bug().eUJ.downloadSize;
                    aVar.mTime = this.eSO.bug().eUJ.MG;
                    aVar.mTimesNum = this.eSO.bug().eUJ.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eSO.bug().eUJ.retry);
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ == null ? -1 : this.eSO.bug().eUJ.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eSO.buf().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eSO.buf().mNetErrorCode = -15;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eSO.buf().mNetErrorCode = -12;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eSO.buf().mNetErrorCode = -13;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eSO.buf().mNetErrorCode = -10;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eSO.buf().mNetErrorCode = -10;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eSO);
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
            if (this.eSO.bue().bui().mPostData != null && this.eSO.bue().bui().mPostData.size() > 0 && !this.eSO.bue().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eSO.bue().bui().mUrl);
                if (this.eSO.bue().bui().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eSO.bue().bui().mUrl.endsWith("?") && !this.eSO.bue().bui().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eSO.bue().bui().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eSO.bue().bui().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(au.getUrlEncode(this.eSO.bue().bui().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eSO.bue().bui().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eSO.bue().bui().mRequestGzip || this.eSO.bue().bui().mIsBDImage) && !this.eSO.bue().mIsFromCDN) {
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
        if (this.mIv.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mIv.b(str, z, 5, 100, -1, -1, bty());
        com.baidu.tieba.recapp.download.http.g dFu = this.mIv.dFu();
        if (dFu == null) {
            return null;
        }
        iVar = dFu.dFw();
        if (dFu != null) {
            try {
                if (dFu.mz() == null || dFu.mz().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ == null ? -1 : this.eSO.bug().eUJ.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eSO.buf().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ != null ? this.eSO.bug().eUJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eSO.buf().mNetErrorCode = -12;
                TiebaStatic.net(this.eSO);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ != null ? this.eSO.bug().eUJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eSO.buf().mNetErrorCode = -13;
                TiebaStatic.net(this.eSO);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ != null ? this.eSO.bug().eUJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eSO.buf().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eSO);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ != null ? this.eSO.bug().eUJ.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eSO.buf().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eSO);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.eSO.buf().mNetErrorCode = iVar.responseCode;
        if (this.eSO.buf().mNetErrorCode != 200) {
            this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eSO.bug().eUJ != null && !TextUtils.isEmpty(this.eSO.bug().eUJ.exception)) {
                this.eSO.buf().mException = this.eSO.bug().eUJ.exception;
            } else {
                this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ == null ? -1 : this.eSO.bug().eUJ.retry);
            }
            TiebaStatic.net(this.eSO);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eST) {
                    this.eSO.buf().mNetErrorCode = -11;
                    TiebaStatic.net(this.eSO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bDV().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eSO.bue().bui().mUrl + "], size:" + i2);
                            this.eSO.buf().mNetErrorCode = -16;
                            TiebaStatic.net(this.eSO);
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
        aVar.mSize = this.eSO.bug().eUJ.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eSO.bug().eUJ.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eSO.bug().eUJ.retry);
        TiebaStatic.net(this.eSO);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eSO.buf().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eSO.bue().bui().charSet = TextUtils.isEmpty(this.eSO.bue().bui().charSet) ? "UTF-8" : this.eSO.bue().bui().charSet;
            str = new String(netData, 0, netData.length, this.eSO.bue().bui().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            BW(str);
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
            if (this.eSO.bue().bui().mPostData == null || i2 >= this.eSO.bue().bui().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eSO.bue().bui().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eSO.bue().bui().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mIv.isCanceled()) {
                return null;
            }
            if (this.mIv.b(this.eSO.bue().bui().mUrl, this.eSO.bue().bui().mPostData, this.eSO.bue().bui().mRequestGzip, 5, -1, bty()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dFu = this.mIv.dFu();
            if (dFu == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dFw = dFu.dFw();
            if (dFu == null || dFu.mz() == null || dFu.mz().size() > 0) {
            }
            this.eSO.buf().mNetErrorCode = dFw.responseCode;
            this.eSO.buf().mHeader = dFw.Nk;
            if (this.eSO.buf().mNetErrorCode != 200) {
                if (this.eSO.bug().eUJ != null && !TextUtils.isEmpty(this.eSO.bug().eUJ.exception)) {
                    this.eSO.buf().mException = this.eSO.bug().eUJ.exception;
                } else {
                    this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ == null ? -1 : this.eSO.bug().eUJ.retry);
                }
                TiebaStatic.net(this.eSO);
                return null;
            } else if (this.mIv.isCanceled()) {
                return null;
            } else {
                str = new String(dFw.retBytes, "utf-8");
                try {
                    if (this.eSO.bue().bui().mIsBaiduServer && this.eSO.bue().bui().mIsJson) {
                        BW(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eSO.bug().eUJ.downloadSize;
                    aVar.mTime = this.eSO.bug().eUJ.MG;
                    aVar.mTimesNum = this.eSO.bug().eUJ.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eSO.bug().eUJ.retry);
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eSO.buf().mException = String.valueOf(this.eSO.buf().mNetErrorCode) + "|retryCount:" + (this.eSO.bug().eUJ == null ? -1 : this.eSO.bug().eUJ.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eSO.buf().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eSO.buf().mNetErrorCode = -15;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eSO.buf().mNetErrorCode = -12;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eSO.buf().mNetErrorCode = -13;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eSO.buf().mNetErrorCode = -10;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eSO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eSO.buf().mNetErrorCode = -10;
                    this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eSO);
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
            if (this.mIv.isCanceled()) {
                return false;
            }
            return this.mIv.a(this.eSO.bue().bui().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bty(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int eSV = 0;
                int eSW = 0;
                int eSX = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.eSV = i5 / 50;
                    }
                    this.eSW += i4 - this.eSX;
                    this.eSX = i4;
                    if (handler != null) {
                        if (this.eSW > this.eSV || i4 == i5) {
                            this.eSW = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.eSO.buf().mNetErrorCode = -10;
            this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.eSO.buf().mNetErrorCode = -15;
            this.eSO.buf().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.eSO);
        }
    }
}
