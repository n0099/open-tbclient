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
    private static int ciu = 2097152;
    private final com.baidu.tbadk.core.util.a.a cip;
    private com.baidu.tieba.recapp.download.http.c iHU = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.cip = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.ai((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bTL : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.cip.amP().amS().mPostData != null) {
            this.cip.amP().amS().mPostData.clear();
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
        return this.cip.amP().amS().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.cip.amP().amS().mPostData == null) {
                this.cip.amP().amS().mPostData = new ArrayList<>();
            }
            int c = c(this.cip.amP().amS().mPostData, basicNameValuePair.getName());
            int size = this.cip.amP().amS().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.cip.amP().amS().mPostData.get(c).getName())) {
                    this.cip.amP().amS().mPostData.set(c, basicNameValuePair);
                } else {
                    this.cip.amP().amS().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.cip.amP().amS().mPostData.add(c, basicNameValuePair);
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
        if (this.cip.amP().amS().mFileData == null) {
            this.cip.amP().amS().mFileData = new HashMap<>();
        }
        this.cip.amP().amS().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.iHU.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.iHU != null) {
            this.iHU.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> ams() {
        if (this.cip != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.cip.amP().amS().mSeqId)) {
                linkedList.add(new BasicNameValuePair("sid", this.cip.amP().amS().mSeqId));
            }
            if (!TextUtils.isEmpty(this.cip.amP().amS().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.cip.amP().amS().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nO(String str) {
        this.cip.amQ().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.cip.amQ().mServerErrorCode = errorData.getError_code();
                if (this.cip.amQ().mServerErrorCode == -1) {
                    this.cip.amQ().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.cip.amQ().mServerErrorCode != 0) {
                    this.cip.amQ().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.cip.amQ().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.cip.amP().amS().mPostData == null || i2 >= this.cip.amP().amS().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cip.amP().amS().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cip.amP().amS().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iHU.isCanceled()) {
                return null;
            }
            if (this.iHU.b(this.cip.amP().amS().mUrl, this.cip.amP().amS().mPostData, this.cip.amP().amS().mRequestGzip, 5, -1, ams()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cfY = this.iHU.cfY();
            if (cfY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cga = cfY.cga();
            if (cfY == null || cfY.fL() == null || cfY.fL().size() > 0) {
            }
            this.cip.amQ().mNetErrorCode = cga.responseCode;
            this.cip.amQ().mHeader = cga.oU;
            if (this.cip.amQ().mNetErrorCode != 200) {
                if (this.cip.amR().cjO != null && !TextUtils.isEmpty(this.cip.amR().cjO.exception)) {
                    this.cip.amQ().mException = this.cip.amR().cjO.exception;
                } else {
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow);
                }
                TiebaStatic.net(this.cip);
                return null;
            } else if (this.iHU.isCanceled()) {
                return null;
            } else {
                str = new String(cga.retBytes, "utf-8");
                try {
                    if (this.cip.amP().amS().mIsBaiduServer && this.cip.amP().amS().mIsJson) {
                        nO(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cip.amR().cjO.downloadSize;
                    aVar.mTime = this.cip.amR().cjO.ox;
                    aVar.mTimesNum = this.cip.amR().cjO.ow;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cip.amR().cjO.ow);
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cip.amQ().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cip.amQ().mNetErrorCode = -12;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cip.amQ().mNetErrorCode = -13;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cip.amQ().mNetErrorCode = -15;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cip);
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
            if (this.cip.amP().amS().mPostData != null && this.cip.amP().amS().mPostData.size() > 0 && !this.cip.amP().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.cip.amP().amS().mUrl);
                if (this.cip.amP().amS().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.cip.amP().amS().mUrl.endsWith("?") && !this.cip.amP().amS().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.cip.amP().amS().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.cip.amP().amS().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(aq.getUrlEncode(this.cip.amP().amS().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.cip.amP().amS().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.cip.amP().amS().mRequestGzip || this.cip.amP().amS().mIsBDImage) && !this.cip.amP().mIsFromCDN) {
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
        if (this.iHU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.iHU.b(str, z, 5, 100, -1, -1, ams());
        com.baidu.tieba.recapp.download.http.g cfY = this.iHU.cfY();
        if (cfY == null) {
            return null;
        }
        iVar = cfY.cga();
        if (cfY != null) {
            try {
                if (cfY.fL() == null || cfY.fL().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.cip.amQ().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cip);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.cip);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -12;
                TiebaStatic.net(this.cip);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO != null ? this.cip.amR().cjO.ow : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.cip.amQ().mNetErrorCode = -13;
                TiebaStatic.net(this.cip);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.cip.amQ().mNetErrorCode = iVar.responseCode;
        if (this.cip.amQ().mNetErrorCode != 200) {
            this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.cip.amR().cjO != null && !TextUtils.isEmpty(this.cip.amR().cjO.exception)) {
                this.cip.amQ().mException = this.cip.amR().cjO.exception;
            } else {
                this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow);
            }
            TiebaStatic.net(this.cip);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > ciu) {
                    this.cip.amQ().mNetErrorCode = -11;
                    TiebaStatic.net(this.cip);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.avs().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.cip.amP().amS().mUrl + "], size:" + i2);
                            this.cip.amQ().mNetErrorCode = -16;
                            TiebaStatic.net(this.cip);
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
        aVar.mSize = this.cip.amR().cjO.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.cip.amR().cjO.ow;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.cip.amR().cjO.ow);
        TiebaStatic.net(this.cip);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.cip.amQ().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.cip.amP().amS().charSet = TextUtils.isEmpty(this.cip.amP().amS().charSet) ? HTTP.UTF_8 : this.cip.amP().amS().charSet;
            str = new String(netData, 0, netData.length, this.cip.amP().amS().charSet);
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
            if (this.cip.amP().amS().mPostData == null || i2 >= this.cip.amP().amS().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.cip.amP().amS().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.cip.amP().amS().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iHU.isCanceled()) {
                return null;
            }
            if (this.iHU.b(this.cip.amP().amS().mUrl, this.cip.amP().amS().mPostData, this.cip.amP().amS().mRequestGzip, 5, -1, ams()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cfY = this.iHU.cfY();
            if (cfY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cga = cfY.cga();
            if (cfY == null || cfY.fL() == null || cfY.fL().size() > 0) {
            }
            this.cip.amQ().mNetErrorCode = cga.responseCode;
            this.cip.amQ().mHeader = cga.oU;
            if (this.cip.amQ().mNetErrorCode != 200) {
                if (this.cip.amR().cjO != null && !TextUtils.isEmpty(this.cip.amR().cjO.exception)) {
                    this.cip.amQ().mException = this.cip.amR().cjO.exception;
                } else {
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow);
                }
                TiebaStatic.net(this.cip);
                return null;
            } else if (this.iHU.isCanceled()) {
                return null;
            } else {
                str = new String(cga.retBytes, "utf-8");
                try {
                    if (this.cip.amP().amS().mIsBaiduServer && this.cip.amP().amS().mIsJson) {
                        nO(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.cip.amR().cjO.downloadSize;
                    aVar.mTime = this.cip.amR().cjO.ox;
                    aVar.mTimesNum = this.cip.amR().cjO.ow;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.cip.amR().cjO.ow);
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.cip.amQ().mException = String.valueOf(this.cip.amQ().mNetErrorCode) + "|retryCount:" + (this.cip.amR().cjO == null ? -1 : this.cip.amR().cjO.ow) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.cip.amQ().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.cip.amQ().mNetErrorCode = -12;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.cip.amQ().mNetErrorCode = -13;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.cip.amQ().mNetErrorCode = -15;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.cip);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.cip.amQ().mNetErrorCode = -10;
                    this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.cip);
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
            if (this.iHU.isCanceled()) {
                return false;
            }
            return this.iHU.a(this.cip.amP().amS().mUrl, (z ? new File(str) : m.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, ams(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int ciw = 0;
                int cix = 0;
                int ciy = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void h(int i4, int i5) {
                    if (i5 > 0) {
                        this.ciw = i5 / 50;
                    }
                    this.cix += i4 - this.ciy;
                    this.ciy = i4;
                    if (handler != null) {
                        if (this.cix > this.ciw || i4 == i5) {
                            this.cix = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.cip.amQ().mNetErrorCode = -10;
            this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.cip.amQ().mNetErrorCode = -15;
            this.cip.amQ().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.cip);
        }
    }
}
