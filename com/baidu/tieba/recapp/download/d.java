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
import com.baidu.tbadk.core.util.at;
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
    private static int eGT = 2097152;
    private final com.baidu.tbadk.core.util.a.a eGO;
    private com.baidu.tieba.recapp.download.http.c mnU = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.eGO = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bP((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eoU : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eGO.boT().boX().mPostData != null) {
            this.eGO.boT().boX().mPostData.clear();
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
        return this.eGO.boT().boX().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eGO.boT().boX().mPostData == null) {
                this.eGO.boT().boX().mPostData = new ArrayList<>();
            }
            int c = c(this.eGO.boT().boX().mPostData, basicNameValuePair.getName());
            int size = this.eGO.boT().boX().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eGO.boT().boX().mPostData.get(c).getName())) {
                    this.eGO.boT().boX().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eGO.boT().boX().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eGO.boT().boX().mPostData.add(c, basicNameValuePair);
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
        if (this.eGO.boT().boX().mFileData == null) {
            this.eGO.boT().boX().mFileData = new HashMap<>();
        }
        this.eGO.boT().boX().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.mnU.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.mnU != null) {
            this.mnU.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> boq() {
        if (this.eGO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eGO.boT().boX().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eGO.boT().boX().mSeqId));
            }
            if (!TextUtils.isEmpty(this.eGO.boT().boX().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eGO.boT().boX().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void BC(String str) {
        this.eGO.boU().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eGO.boU().mServerErrorCode = errorData.getError_code();
                if (this.eGO.boU().mServerErrorCode == -1) {
                    this.eGO.boU().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eGO.boU().mServerErrorCode != 0) {
                    this.eGO.boU().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eGO.boU().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.eGO.boT().boX().mPostData == null || i2 >= this.eGO.boT().boX().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eGO.boT().boX().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eGO.boT().boX().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mnU.isCanceled()) {
                return null;
            }
            if (this.mnU.b(this.eGO.boT().boX().mUrl, this.eGO.boT().boX().mPostData, this.eGO.boT().boX().mRequestGzip, 5, -1, boq()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dya = this.mnU.dya();
            if (dya == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dyc = dya.dyc();
            if (dya == null || dya.mz() == null || dya.mz().size() > 0) {
            }
            this.eGO.boU().mNetErrorCode = dyc.responseCode;
            this.eGO.boU().mHeader = dyc.Mp;
            if (this.eGO.boU().mNetErrorCode != 200) {
                if (this.eGO.boV().eIB != null && !TextUtils.isEmpty(this.eGO.boV().eIB.exception)) {
                    this.eGO.boU().mException = this.eGO.boV().eIB.exception;
                } else {
                    this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry);
                }
                TiebaStatic.net(this.eGO);
                return null;
            } else if (this.mnU.isCanceled()) {
                return null;
            } else {
                str = new String(dyc.retBytes, "utf-8");
                try {
                    if (this.eGO.boT().boX().mIsBaiduServer && this.eGO.boT().boX().mIsJson) {
                        BC(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eGO.boV().eIB.downloadSize;
                    aVar.mTime = this.eGO.boV().eIB.LK;
                    aVar.mTimesNum = this.eGO.boV().eIB.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eGO.boV().eIB.retry);
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eGO.boU().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eGO.boU().mNetErrorCode = -15;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eGO.boU().mNetErrorCode = -12;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eGO.boU().mNetErrorCode = -13;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eGO.boU().mNetErrorCode = -10;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eGO.boU().mNetErrorCode = -10;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eGO);
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
            if (this.eGO.boT().boX().mPostData != null && this.eGO.boT().boX().mPostData.size() > 0 && !this.eGO.boT().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eGO.boT().boX().mUrl);
                if (this.eGO.boT().boX().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eGO.boT().boX().mUrl.endsWith("?") && !this.eGO.boT().boX().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eGO.boT().boX().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eGO.boT().boX().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(at.getUrlEncode(this.eGO.boT().boX().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eGO.boT().boX().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eGO.boT().boX().mRequestGzip || this.eGO.boT().boX().mIsBDImage) && !this.eGO.boT().mIsFromCDN) {
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
        if (this.mnU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mnU.b(str, z, 5, 100, -1, -1, boq());
        com.baidu.tieba.recapp.download.http.g dya = this.mnU.dya();
        if (dya == null) {
            return null;
        }
        iVar = dya.dyc();
        if (dya != null) {
            try {
                if (dya.mz() == null || dya.mz().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eGO.boU().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -12;
                TiebaStatic.net(this.eGO);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -13;
                TiebaStatic.net(this.eGO);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eGO);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB != null ? this.eGO.boV().eIB.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eGO.boU().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eGO);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.eGO.boU().mNetErrorCode = iVar.responseCode;
        if (this.eGO.boU().mNetErrorCode != 200) {
            this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eGO.boV().eIB != null && !TextUtils.isEmpty(this.eGO.boV().eIB.exception)) {
                this.eGO.boU().mException = this.eGO.boV().eIB.exception;
            } else {
                this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry);
            }
            TiebaStatic.net(this.eGO);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eGT) {
                    this.eGO.boU().mNetErrorCode = -11;
                    TiebaStatic.net(this.eGO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.byE().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eGO.boT().boX().mUrl + "], size:" + i2);
                            this.eGO.boU().mNetErrorCode = -16;
                            TiebaStatic.net(this.eGO);
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
        aVar.mSize = this.eGO.boV().eIB.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eGO.boV().eIB.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.eGO.boV().eIB.retry);
        TiebaStatic.net(this.eGO);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.eGO.boU().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eGO.boT().boX().charSet = TextUtils.isEmpty(this.eGO.boT().boX().charSet) ? "UTF-8" : this.eGO.boT().boX().charSet;
            str = new String(netData, 0, netData.length, this.eGO.boT().boX().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            BC(str);
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
            if (this.eGO.boT().boX().mPostData == null || i2 >= this.eGO.boT().boX().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eGO.boT().boX().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eGO.boT().boX().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mnU.isCanceled()) {
                return null;
            }
            if (this.mnU.b(this.eGO.boT().boX().mUrl, this.eGO.boT().boX().mPostData, this.eGO.boT().boX().mRequestGzip, 5, -1, boq()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dya = this.mnU.dya();
            if (dya == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dyc = dya.dyc();
            if (dya == null || dya.mz() == null || dya.mz().size() > 0) {
            }
            this.eGO.boU().mNetErrorCode = dyc.responseCode;
            this.eGO.boU().mHeader = dyc.Mp;
            if (this.eGO.boU().mNetErrorCode != 200) {
                if (this.eGO.boV().eIB != null && !TextUtils.isEmpty(this.eGO.boV().eIB.exception)) {
                    this.eGO.boU().mException = this.eGO.boV().eIB.exception;
                } else {
                    this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry);
                }
                TiebaStatic.net(this.eGO);
                return null;
            } else if (this.mnU.isCanceled()) {
                return null;
            } else {
                str = new String(dyc.retBytes, "utf-8");
                try {
                    if (this.eGO.boT().boX().mIsBaiduServer && this.eGO.boT().boX().mIsJson) {
                        BC(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eGO.boV().eIB.downloadSize;
                    aVar.mTime = this.eGO.boV().eIB.LK;
                    aVar.mTimesNum = this.eGO.boV().eIB.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.eGO.boV().eIB.retry);
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eGO.boU().mException = String.valueOf(this.eGO.boU().mNetErrorCode) + "|retryCount:" + (this.eGO.boV().eIB == null ? -1 : this.eGO.boV().eIB.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.eGO.boU().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.eGO.boU().mNetErrorCode = -15;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.eGO.boU().mNetErrorCode = -12;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.eGO.boU().mNetErrorCode = -13;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.eGO.boU().mNetErrorCode = -10;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eGO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.eGO.boU().mNetErrorCode = -10;
                    this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eGO);
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
            if (this.mnU.isCanceled()) {
                return false;
            }
            return this.mnU.a(this.eGO.boT().boX().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, boq(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int eGV = 0;
                int eGW = 0;
                int eGX = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.eGV = i5 / 50;
                    }
                    this.eGW += i4 - this.eGX;
                    this.eGX = i4;
                    if (handler != null) {
                        if (this.eGW > this.eGV || i4 == i5) {
                            this.eGW = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.eGO.boU().mNetErrorCode = -10;
            this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.eGO.boU().mNetErrorCode = -15;
            this.eGO.boU().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.eGO);
        }
    }
}
