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
/* loaded from: classes10.dex */
public class d implements q {
    private static int cVe = 2097152;
    private final com.baidu.tbadk.core.util.a.a cUZ;
    private com.baidu.tieba.recapp.download.http.c jCm = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.cUZ = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.au((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.cGi : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cUZ.aEb().aEe().mPostData != null) {
            this.cUZ.aEb().aEe().mPostData.clear();
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
        return this.cUZ.aEb().aEe().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cUZ.aEb().aEe().mPostData == null) {
                this.cUZ.aEb().aEe().mPostData = new ArrayList<>();
            }
            int d = d(this.cUZ.aEb().aEe().mPostData, basicNameValuePair.getName());
            int size = this.cUZ.aEb().aEe().mPostData.size();
            if (d >= 0 && d < size) {
                if (basicNameValuePair.getName().equals(this.cUZ.aEb().aEe().mPostData.get(d).getName())) {
                    this.cUZ.aEb().aEe().mPostData.set(d, basicNameValuePair);
                } else {
                    this.cUZ.aEb().aEe().mPostData.add(d, basicNameValuePair);
                }
            } else if (d == size) {
                this.cUZ.aEb().aEe().mPostData.add(d, basicNameValuePair);
            }
        }
    }

    private int d(ArrayList<BasicNameValuePair> arrayList, String str) {
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
        if (this.cUZ.aEb().aEe().mFileData == null) {
            this.cUZ.aEb().aEe().mFileData = new HashMap<>();
        }
        this.cUZ.aEb().aEe().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.jCm.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.jCm != null) {
            this.jCm.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> aDE() {
        if (this.cUZ != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cUZ.aEb().aEe().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cUZ.aEb().aEe().mSeqId));
            }
            if (!TextUtils.isEmpty(this.cUZ.aEb().aEe().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cUZ.aEb().aEe().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void sZ(String str) {
        this.cUZ.aEc().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cUZ.aEc().mServerErrorCode = errorData.getError_code();
                if (this.cUZ.aEc().mServerErrorCode == -1) {
                    this.cUZ.aEc().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cUZ.aEc().mServerErrorCode != 0) {
                    this.cUZ.aEc().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cUZ.aEc().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.cUZ.aEb().aEe().mPostData == null || i2 >= this.cUZ.aEb().aEe().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cUZ.aEb().aEe().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cUZ.aEb().aEe().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.jCm.isCanceled()) {
                return null;
            }
            if (this.jCm.b(this.cUZ.aEb().aEe().mUrl, this.cUZ.aEb().aEe().mPostData, this.cUZ.aEb().aEe().mRequestGzip, 5, -1, aDE()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cAc = this.jCm.cAc();
            if (cAc == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cAe = cAc.cAe();
            if (cAc == null || cAc.ga() == null || cAc.ga().size() > 0) {
            }
            this.cUZ.aEc().mNetErrorCode = cAe.responseCode;
            this.cUZ.aEc().mHeader = cAe.rp;
            if (this.cUZ.aEc().mNetErrorCode != 200) {
                if (this.cUZ.aEd().cWz != null && !TextUtils.isEmpty(this.cUZ.aEd().cWz.exception)) {
                    this.cUZ.aEc().mException = this.cUZ.aEd().cWz.exception;
                } else {
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry);
                }
                TiebaStatic.net(this.cUZ);
                return null;
            } else if (this.jCm.isCanceled()) {
                return null;
            } else {
                str = new String(cAe.retBytes, "utf-8");
                try {
                    if (this.cUZ.aEb().aEe().mIsBaiduServer && this.cUZ.aEb().aEe().mIsJson) {
                        sZ(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cUZ.aEd().cWz.downloadSize;
                    aVar.mTime = this.cUZ.aEd().cWz.qP;
                    aVar.mTimesNum = this.cUZ.aEd().cWz.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cUZ.aEd().cWz.retry);
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cUZ.aEc().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cUZ.aEc().mNetErrorCode = -12;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cUZ.aEc().mNetErrorCode = -13;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cUZ.aEc().mNetErrorCode = -15;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cUZ);
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
            if (this.cUZ.aEb().aEe().mPostData != null && this.cUZ.aEb().aEe().mPostData.size() > 0 && !this.cUZ.aEb().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cUZ.aEb().aEe().mUrl);
                if (this.cUZ.aEb().aEe().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cUZ.aEb().aEe().mUrl.endsWith("?") && !this.cUZ.aEb().aEe().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.cUZ.aEb().aEe().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.cUZ.aEb().aEe().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.cUZ.aEb().aEe().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cUZ.aEb().aEe().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cUZ.aEb().aEe().mRequestGzip || this.cUZ.aEb().aEe().mIsBDImage) && !this.cUZ.aEb().mIsFromCDN) {
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
        if (this.jCm.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.jCm.b(str, z, 5, 100, -1, -1, aDE());
        com.baidu.tieba.recapp.download.http.g cAc = this.jCm.cAc();
        if (cAc == null) {
            return null;
        }
        iVar = cAc.cAe();
        if (cAc != null) {
            try {
                if (cAc.ga() == null || cAc.ga().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cUZ.aEc().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cUZ);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cUZ);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -12;
                TiebaStatic.net(this.cUZ);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz != null ? this.cUZ.aEd().cWz.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cUZ.aEc().mNetErrorCode = -13;
                TiebaStatic.net(this.cUZ);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.cUZ.aEc().mNetErrorCode = iVar.responseCode;
        if (this.cUZ.aEc().mNetErrorCode != 200) {
            this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cUZ.aEd().cWz != null && !TextUtils.isEmpty(this.cUZ.aEd().cWz.exception)) {
                this.cUZ.aEc().mException = this.cUZ.aEd().cWz.exception;
            } else {
                this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry);
            }
            TiebaStatic.net(this.cUZ);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > cVe) {
                    this.cUZ.aEc().mNetErrorCode = -11;
                    TiebaStatic.net(this.cUZ);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aMZ().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cUZ.aEb().aEe().mUrl + "], size:" + i2);
                            this.cUZ.aEc().mNetErrorCode = -16;
                            TiebaStatic.net(this.cUZ);
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
        aVar.mSize = this.cUZ.aEd().cWz.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cUZ.aEd().cWz.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cUZ.aEd().cWz.retry);
        TiebaStatic.net(this.cUZ);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cUZ.aEc().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cUZ.aEb().aEe().charSet = TextUtils.isEmpty(this.cUZ.aEb().aEe().charSet) ? "UTF-8" : this.cUZ.aEb().aEe().charSet;
            str = new String(netData, 0, netData.length, this.cUZ.aEb().aEe().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            sZ(str);
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
            if (this.cUZ.aEb().aEe().mPostData == null || i2 >= this.cUZ.aEb().aEe().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cUZ.aEb().aEe().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cUZ.aEb().aEe().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.jCm.isCanceled()) {
                return null;
            }
            if (this.jCm.b(this.cUZ.aEb().aEe().mUrl, this.cUZ.aEb().aEe().mPostData, this.cUZ.aEb().aEe().mRequestGzip, 5, -1, aDE()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cAc = this.jCm.cAc();
            if (cAc == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cAe = cAc.cAe();
            if (cAc == null || cAc.ga() == null || cAc.ga().size() > 0) {
            }
            this.cUZ.aEc().mNetErrorCode = cAe.responseCode;
            this.cUZ.aEc().mHeader = cAe.rp;
            if (this.cUZ.aEc().mNetErrorCode != 200) {
                if (this.cUZ.aEd().cWz != null && !TextUtils.isEmpty(this.cUZ.aEd().cWz.exception)) {
                    this.cUZ.aEc().mException = this.cUZ.aEd().cWz.exception;
                } else {
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry);
                }
                TiebaStatic.net(this.cUZ);
                return null;
            } else if (this.jCm.isCanceled()) {
                return null;
            } else {
                str = new String(cAe.retBytes, "utf-8");
                try {
                    if (this.cUZ.aEb().aEe().mIsBaiduServer && this.cUZ.aEb().aEe().mIsJson) {
                        sZ(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cUZ.aEd().cWz.downloadSize;
                    aVar.mTime = this.cUZ.aEd().cWz.qP;
                    aVar.mTimesNum = this.cUZ.aEd().cWz.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cUZ.aEd().cWz.retry);
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cUZ.aEc().mException = String.valueOf(this.cUZ.aEc().mNetErrorCode) + "|retryCount:" + (this.cUZ.aEd().cWz == null ? -1 : this.cUZ.aEd().cWz.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cUZ.aEc().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cUZ.aEc().mNetErrorCode = -12;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cUZ.aEc().mNetErrorCode = -13;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cUZ.aEc().mNetErrorCode = -15;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cUZ);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cUZ.aEc().mNetErrorCode = -10;
                    this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cUZ);
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
            if (this.jCm.isCanceled()) {
                return false;
            }
            return this.jCm.a(this.cUZ.aEb().aEe().mUrl, (z ? new File(str) : m.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, aDE(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int cVg = 0;
                int cVh = 0;
                int cVi = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void j(int i4, int i5) {
                    if (i5 > 0) {
                        this.cVg = i5 / 50;
                    }
                    this.cVh += i4 - this.cVi;
                    this.cVi = i4;
                    if (handler != null) {
                        if (this.cVh > this.cVg || i4 == i5) {
                            this.cVh = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.cUZ.aEc().mNetErrorCode = -10;
            this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.cUZ.aEc().mNetErrorCode = -15;
            this.cUZ.aEc().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.cUZ);
        }
    }
}
