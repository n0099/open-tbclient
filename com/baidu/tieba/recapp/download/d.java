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
    private static int dNc = 2097152;
    private final com.baidu.tbadk.core.util.a.a dMX;
    private com.baidu.tieba.recapp.download.http.c kKg = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.dMX = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bJ((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.dxW : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.dMX.aVa().aVe().mPostData != null) {
            this.dMX.aVa().aVe().mPostData.clear();
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
        return this.dMX.aVa().aVe().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.dMX.aVa().aVe().mPostData == null) {
                this.dMX.aVa().aVe().mPostData = new ArrayList<>();
            }
            int c = c(this.dMX.aVa().aVe().mPostData, basicNameValuePair.getName());
            int size = this.dMX.aVa().aVe().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.dMX.aVa().aVe().mPostData.get(c).getName())) {
                    this.dMX.aVa().aVe().mPostData.set(c, basicNameValuePair);
                } else {
                    this.dMX.aVa().aVe().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.dMX.aVa().aVe().mPostData.add(c, basicNameValuePair);
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
        if (this.dMX.aVa().aVe().mFileData == null) {
            this.dMX.aVa().aVe().mFileData = new HashMap<>();
        }
        this.dMX.aVa().aVe().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.kKg.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.kKg != null) {
            this.kKg.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> aUD() {
        if (this.dMX != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.dMX.aVa().aVe().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dMX.aVa().aVe().mSeqId));
            }
            if (!TextUtils.isEmpty(this.dMX.aVa().aVe().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.dMX.aVa().aVe().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void wo(String str) {
        this.dMX.aVb().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.dMX.aVb().mServerErrorCode = errorData.getError_code();
                if (this.dMX.aVb().mServerErrorCode == -1) {
                    this.dMX.aVb().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.dMX.aVb().mServerErrorCode != 0) {
                    this.dMX.aVb().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.dMX.aVb().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.dMX.aVa().aVe().mPostData == null || i2 >= this.dMX.aVa().aVe().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dMX.aVa().aVe().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.dMX.aVa().aVe().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.kKg.isCanceled()) {
                return null;
            }
            if (this.kKg.b(this.dMX.aVa().aVe().mUrl, this.dMX.aVa().aVe().mPostData, this.dMX.aVa().aVe().mRequestGzip, 5, -1, aUD()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cUA = this.kKg.cUA();
            if (cUA == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cUC = cUA.cUC();
            if (cUA == null || cUA.kF() == null || cUA.kF().size() > 0) {
            }
            this.dMX.aVb().mNetErrorCode = cUC.responseCode;
            this.dMX.aVb().mHeader = cUC.KF;
            if (this.dMX.aVb().mNetErrorCode != 200) {
                if (this.dMX.aVc().dOA != null && !TextUtils.isEmpty(this.dMX.aVc().dOA.exception)) {
                    this.dMX.aVb().mException = this.dMX.aVc().dOA.exception;
                } else {
                    this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA == null ? -1 : this.dMX.aVc().dOA.retry);
                }
                TiebaStatic.net(this.dMX);
                return null;
            } else if (this.kKg.isCanceled()) {
                return null;
            } else {
                str = new String(cUC.retBytes, "utf-8");
                try {
                    if (this.dMX.aVa().aVe().mIsBaiduServer && this.dMX.aVa().aVe().mIsJson) {
                        wo(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.dMX.aVc().dOA.downloadSize;
                    aVar.mTime = this.dMX.aVc().dOA.Kd;
                    aVar.mTimesNum = this.dMX.aVc().dOA.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.dMX.aVc().dOA.retry);
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA == null ? -1 : this.dMX.aVc().dOA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.dMX.aVb().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.dMX.aVb().mNetErrorCode = -12;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.dMX.aVb().mNetErrorCode = -13;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.dMX.aVb().mNetErrorCode = -10;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.dMX.aVb().mNetErrorCode = -15;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.dMX.aVb().mNetErrorCode = -10;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.dMX);
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
            if (this.dMX.aVa().aVe().mPostData != null && this.dMX.aVa().aVe().mPostData.size() > 0 && !this.dMX.aVa().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.dMX.aVa().aVe().mUrl);
                if (this.dMX.aVa().aVe().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.dMX.aVa().aVe().mUrl.endsWith("?") && !this.dMX.aVa().aVe().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.dMX.aVa().aVe().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.dMX.aVa().aVe().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.dMX.aVa().aVe().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.dMX.aVa().aVe().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.dMX.aVa().aVe().mRequestGzip || this.dMX.aVa().aVe().mIsBDImage) && !this.dMX.aVa().mIsFromCDN) {
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
        if (this.kKg.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.kKg.b(str, z, 5, 100, -1, -1, aUD());
        com.baidu.tieba.recapp.download.http.g cUA = this.kKg.cUA();
        if (cUA == null) {
            return null;
        }
        iVar = cUA.cUC();
        if (cUA != null) {
            try {
                if (cUA.kF() == null || cUA.kF().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA == null ? -1 : this.dMX.aVc().dOA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dMX.aVb().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA != null ? this.dMX.aVc().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVb().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dMX);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA != null ? this.dMX.aVc().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVb().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dMX);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA != null ? this.dMX.aVc().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVb().mNetErrorCode = -12;
                TiebaStatic.net(this.dMX);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA != null ? this.dMX.aVc().dOA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dMX.aVb().mNetErrorCode = -13;
                TiebaStatic.net(this.dMX);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.dMX.aVb().mNetErrorCode = iVar.responseCode;
        if (this.dMX.aVb().mNetErrorCode != 200) {
            this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.dMX.aVc().dOA != null && !TextUtils.isEmpty(this.dMX.aVc().dOA.exception)) {
                this.dMX.aVb().mException = this.dMX.aVc().dOA.exception;
            } else {
                this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA == null ? -1 : this.dMX.aVc().dOA.retry);
            }
            TiebaStatic.net(this.dMX);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > dNc) {
                    this.dMX.aVb().mNetErrorCode = -11;
                    TiebaStatic.net(this.dMX);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bet().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.dMX.aVa().aVe().mUrl + "], size:" + i2);
                            this.dMX.aVb().mNetErrorCode = -16;
                            TiebaStatic.net(this.dMX);
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
        aVar.mSize = this.dMX.aVc().dOA.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.dMX.aVc().dOA.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.dMX.aVc().dOA.retry);
        TiebaStatic.net(this.dMX);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.dMX.aVb().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.dMX.aVa().aVe().charSet = TextUtils.isEmpty(this.dMX.aVa().aVe().charSet) ? "UTF-8" : this.dMX.aVa().aVe().charSet;
            str = new String(netData, 0, netData.length, this.dMX.aVa().aVe().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            wo(str);
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
            if (this.dMX.aVa().aVe().mPostData == null || i2 >= this.dMX.aVa().aVe().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dMX.aVa().aVe().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.dMX.aVa().aVe().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.kKg.isCanceled()) {
                return null;
            }
            if (this.kKg.b(this.dMX.aVa().aVe().mUrl, this.dMX.aVa().aVe().mPostData, this.dMX.aVa().aVe().mRequestGzip, 5, -1, aUD()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cUA = this.kKg.cUA();
            if (cUA == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cUC = cUA.cUC();
            if (cUA == null || cUA.kF() == null || cUA.kF().size() > 0) {
            }
            this.dMX.aVb().mNetErrorCode = cUC.responseCode;
            this.dMX.aVb().mHeader = cUC.KF;
            if (this.dMX.aVb().mNetErrorCode != 200) {
                if (this.dMX.aVc().dOA != null && !TextUtils.isEmpty(this.dMX.aVc().dOA.exception)) {
                    this.dMX.aVb().mException = this.dMX.aVc().dOA.exception;
                } else {
                    this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA == null ? -1 : this.dMX.aVc().dOA.retry);
                }
                TiebaStatic.net(this.dMX);
                return null;
            } else if (this.kKg.isCanceled()) {
                return null;
            } else {
                str = new String(cUC.retBytes, "utf-8");
                try {
                    if (this.dMX.aVa().aVe().mIsBaiduServer && this.dMX.aVa().aVe().mIsJson) {
                        wo(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.dMX.aVc().dOA.downloadSize;
                    aVar.mTime = this.dMX.aVc().dOA.Kd;
                    aVar.mTimesNum = this.dMX.aVc().dOA.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.dMX.aVc().dOA.retry);
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.dMX.aVb().mException = String.valueOf(this.dMX.aVb().mNetErrorCode) + "|retryCount:" + (this.dMX.aVc().dOA == null ? -1 : this.dMX.aVc().dOA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.dMX.aVb().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.dMX.aVb().mNetErrorCode = -12;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.dMX.aVb().mNetErrorCode = -13;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.dMX.aVb().mNetErrorCode = -10;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.dMX.aVb().mNetErrorCode = -15;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.dMX);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.dMX.aVb().mNetErrorCode = -10;
                    this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.dMX);
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
            if (this.kKg.isCanceled()) {
                return false;
            }
            return this.kKg.a(this.dMX.aVa().aVe().mUrl, (z ? new File(str) : m.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, aUD(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int dNe = 0;
                int dNf = 0;
                int dNg = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.dNe = i5 / 50;
                    }
                    this.dNf += i4 - this.dNg;
                    this.dNg = i4;
                    if (handler != null) {
                        if (this.dNf > this.dNe || i4 == i5) {
                            this.dNf = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.dMX.aVb().mNetErrorCode = -10;
            this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.dMX.aVb().mNetErrorCode = -15;
            this.dMX.aVb().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.dMX);
        }
    }
}
