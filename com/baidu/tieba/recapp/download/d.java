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
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class d implements q {
    private static int cjl = 2097152;
    private final com.baidu.tbadk.core.util.a.a cjg;
    private com.baidu.tieba.recapp.download.http.c iIL = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.cjg = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.ai((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bUC : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cjg.amR().amU().mPostData != null) {
            this.cjg.amR().amU().mPostData.clear();
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
        return this.cjg.amR().amU().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cjg.amR().amU().mPostData == null) {
                this.cjg.amR().amU().mPostData = new ArrayList<>();
            }
            int b = b(this.cjg.amR().amU().mPostData, basicNameValuePair.getName());
            int size = this.cjg.amR().amU().mPostData.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.cjg.amR().amU().mPostData.get(b).getName())) {
                    this.cjg.amR().amU().mPostData.set(b, basicNameValuePair);
                } else {
                    this.cjg.amR().amU().mPostData.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.cjg.amR().amU().mPostData.add(b, basicNameValuePair);
            }
        }
    }

    private int b(ArrayList<BasicNameValuePair> arrayList, String str) {
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
        if (this.cjg.amR().amU().mFileData == null) {
            this.cjg.amR().amU().mFileData = new HashMap<>();
        }
        this.cjg.amR().amU().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.iIL.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.iIL != null) {
            this.iIL.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> amu() {
        if (this.cjg != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cjg.amR().amU().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cjg.amR().amU().mSeqId));
            }
            if (!TextUtils.isEmpty(this.cjg.amR().amU().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cjg.amR().amU().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nO(String str) {
        this.cjg.amS().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cjg.amS().mServerErrorCode = errorData.getError_code();
                if (this.cjg.amS().mServerErrorCode == -1) {
                    this.cjg.amS().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cjg.amS().mServerErrorCode != 0) {
                    this.cjg.amS().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cjg.amS().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.cjg.amR().amU().mPostData == null || i2 >= this.cjg.amR().amU().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cjg.amR().amU().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cjg.amR().amU().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iIL.isCanceled()) {
                return null;
            }
            if (this.iIL.b(this.cjg.amR().amU().mUrl, this.cjg.amR().amU().mPostData, this.cjg.amR().amU().mRequestGzip, 5, -1, amu()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cga = this.iIL.cga();
            if (cga == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cgc = cga.cgc();
            if (cga == null || cga.fL() == null || cga.fL().size() > 0) {
            }
            this.cjg.amS().mNetErrorCode = cgc.responseCode;
            this.cjg.amS().mHeader = cgc.pA;
            if (this.cjg.amS().mNetErrorCode != 200) {
                if (this.cjg.amT().ckF != null && !TextUtils.isEmpty(this.cjg.amT().ckF.exception)) {
                    this.cjg.amS().mException = this.cjg.amT().ckF.exception;
                } else {
                    this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF == null ? -1 : this.cjg.amT().ckF.oV);
                }
                TiebaStatic.net(this.cjg);
                return null;
            } else if (this.iIL.isCanceled()) {
                return null;
            } else {
                str = new String(cgc.retBytes, "utf-8");
                try {
                    if (this.cjg.amR().amU().mIsBaiduServer && this.cjg.amR().amU().mIsJson) {
                        nO(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cjg.amT().ckF.downloadSize;
                    aVar.mTime = this.cjg.amT().ckF.oW;
                    aVar.mTimesNum = this.cjg.amT().ckF.oV;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cjg.amT().ckF.oV);
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF == null ? -1 : this.cjg.amT().ckF.oV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cjg.amS().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cjg.amS().mNetErrorCode = -12;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cjg.amS().mNetErrorCode = -13;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cjg.amS().mNetErrorCode = -10;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cjg.amS().mNetErrorCode = -15;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cjg.amS().mNetErrorCode = -10;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cjg);
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
            if (this.cjg.amR().amU().mPostData != null && this.cjg.amR().amU().mPostData.size() > 0 && !this.cjg.amR().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cjg.amR().amU().mUrl);
                if (this.cjg.amR().amU().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cjg.amR().amU().mUrl.endsWith("?") && !this.cjg.amR().amU().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.cjg.amR().amU().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.cjg.amR().amU().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(aq.getUrlEncode(this.cjg.amR().amU().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cjg.amR().amU().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cjg.amR().amU().mRequestGzip || this.cjg.amR().amU().mIsBDImage) && !this.cjg.amR().mIsFromCDN) {
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
        if (this.iIL.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.iIL.b(str, z, 5, 100, -1, -1, amu());
        com.baidu.tieba.recapp.download.http.g cga = this.iIL.cga();
        if (cga == null) {
            return null;
        }
        iVar = cga.cgc();
        if (cga != null) {
            try {
                if (cga.fL() == null || cga.fL().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF == null ? -1 : this.cjg.amT().ckF.oV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cjg.amS().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF != null ? this.cjg.amT().ckF.oV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cjg.amS().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cjg);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF != null ? this.cjg.amT().ckF.oV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cjg.amS().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cjg);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF != null ? this.cjg.amT().ckF.oV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cjg.amS().mNetErrorCode = -12;
                TiebaStatic.net(this.cjg);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF != null ? this.cjg.amT().ckF.oV : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cjg.amS().mNetErrorCode = -13;
                TiebaStatic.net(this.cjg);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.cjg.amS().mNetErrorCode = iVar.responseCode;
        if (this.cjg.amS().mNetErrorCode != 200) {
            this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cjg.amT().ckF != null && !TextUtils.isEmpty(this.cjg.amT().ckF.exception)) {
                this.cjg.amS().mException = this.cjg.amT().ckF.exception;
            } else {
                this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF == null ? -1 : this.cjg.amT().ckF.oV);
            }
            TiebaStatic.net(this.cjg);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > cjl) {
                    this.cjg.amS().mNetErrorCode = -11;
                    TiebaStatic.net(this.cjg);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.avu().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cjg.amR().amU().mUrl + "], size:" + i2);
                            this.cjg.amS().mNetErrorCode = -16;
                            TiebaStatic.net(this.cjg);
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
        aVar.mSize = this.cjg.amT().ckF.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cjg.amT().ckF.oV;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cjg.amT().ckF.oV);
        TiebaStatic.net(this.cjg);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cjg.amS().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cjg.amR().amU().charSet = TextUtils.isEmpty(this.cjg.amR().amU().charSet) ? HTTP.UTF_8 : this.cjg.amR().amU().charSet;
            str = new String(netData, 0, netData.length, this.cjg.amR().amU().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nO(str);
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
            if (this.cjg.amR().amU().mPostData == null || i2 >= this.cjg.amR().amU().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cjg.amR().amU().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cjg.amR().amU().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iIL.isCanceled()) {
                return null;
            }
            if (this.iIL.b(this.cjg.amR().amU().mUrl, this.cjg.amR().amU().mPostData, this.cjg.amR().amU().mRequestGzip, 5, -1, amu()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cga = this.iIL.cga();
            if (cga == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cgc = cga.cgc();
            if (cga == null || cga.fL() == null || cga.fL().size() > 0) {
            }
            this.cjg.amS().mNetErrorCode = cgc.responseCode;
            this.cjg.amS().mHeader = cgc.pA;
            if (this.cjg.amS().mNetErrorCode != 200) {
                if (this.cjg.amT().ckF != null && !TextUtils.isEmpty(this.cjg.amT().ckF.exception)) {
                    this.cjg.amS().mException = this.cjg.amT().ckF.exception;
                } else {
                    this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF == null ? -1 : this.cjg.amT().ckF.oV);
                }
                TiebaStatic.net(this.cjg);
                return null;
            } else if (this.iIL.isCanceled()) {
                return null;
            } else {
                str = new String(cgc.retBytes, "utf-8");
                try {
                    if (this.cjg.amR().amU().mIsBaiduServer && this.cjg.amR().amU().mIsJson) {
                        nO(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cjg.amT().ckF.downloadSize;
                    aVar.mTime = this.cjg.amT().ckF.oW;
                    aVar.mTimesNum = this.cjg.amT().ckF.oV;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cjg.amT().ckF.oV);
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cjg.amS().mException = String.valueOf(this.cjg.amS().mNetErrorCode) + "|retryCount:" + (this.cjg.amT().ckF == null ? -1 : this.cjg.amT().ckF.oV) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cjg.amS().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cjg.amS().mNetErrorCode = -12;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cjg.amS().mNetErrorCode = -13;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cjg.amS().mNetErrorCode = -10;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cjg.amS().mNetErrorCode = -15;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cjg);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cjg.amS().mNetErrorCode = -10;
                    this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cjg);
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
            if (this.iIL.isCanceled()) {
                return false;
            }
            return this.iIL.a(this.cjg.amR().amU().mUrl, (z ? new File(str) : m.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, amu(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int cjn = 0;
                int cjo = 0;
                int cjp = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void j(int i4, int i5) {
                    if (i5 > 0) {
                        this.cjn = i5 / 50;
                    }
                    this.cjo += i4 - this.cjp;
                    this.cjp = i4;
                    if (handler != null) {
                        if (this.cjo > this.cjn || i4 == i5) {
                            this.cjo = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.cjg.amS().mNetErrorCode = -10;
            this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.cjg.amS().mNetErrorCode = -15;
            this.cjg.amS().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.cjg);
        }
    }
}
