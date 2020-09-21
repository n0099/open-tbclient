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
/* loaded from: classes25.dex */
public class d implements s {
    private static int emm = 2097152;
    private final com.baidu.tbadk.core.util.a.a emh;
    private com.baidu.tieba.recapp.download.http.c lMf = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.emh = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bP((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.dUu : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.emh.bkq().bku().mPostData != null) {
            this.emh.bkq().bku().mPostData.clear();
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
        return this.emh.bkq().bku().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.emh.bkq().bku().mPostData == null) {
                this.emh.bkq().bku().mPostData = new ArrayList<>();
            }
            int c = c(this.emh.bkq().bku().mPostData, basicNameValuePair.getName());
            int size = this.emh.bkq().bku().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.emh.bkq().bku().mPostData.get(c).getName())) {
                    this.emh.bkq().bku().mPostData.set(c, basicNameValuePair);
                } else {
                    this.emh.bkq().bku().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.emh.bkq().bku().mPostData.add(c, basicNameValuePair);
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
        if (this.emh.bkq().bku().mFileData == null) {
            this.emh.bkq().bku().mFileData = new HashMap<>();
        }
        this.emh.bkq().bku().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.lMf.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.lMf != null) {
            this.lMf.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bjO() {
        if (this.emh != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.emh.bkq().bku().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.emh.bkq().bku().mSeqId));
            }
            if (!TextUtils.isEmpty(this.emh.bkq().bku().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.emh.bkq().bku().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void Ax(String str) {
        this.emh.bkr().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.emh.bkr().mServerErrorCode = errorData.getError_code();
                if (this.emh.bkr().mServerErrorCode == -1) {
                    this.emh.bkr().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.emh.bkr().mServerErrorCode != 0) {
                    this.emh.bkr().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.emh.bkr().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.emh.bkq().bku().mPostData == null || i2 >= this.emh.bkq().bku().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.emh.bkq().bku().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.emh.bkq().bku().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.lMf.isCanceled()) {
                return null;
            }
            if (this.lMf.b(this.emh.bkq().bku().mUrl, this.emh.bkq().bku().mPostData, this.emh.bkq().bku().mRequestGzip, 5, -1, bjO()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dri = this.lMf.dri();
            if (dri == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i drk = dri.drk();
            if (dri == null || dri.my() == null || dri.my().size() > 0) {
            }
            this.emh.bkr().mNetErrorCode = drk.responseCode;
            this.emh.bkr().mHeader = drk.LY;
            if (this.emh.bkr().mNetErrorCode != 200) {
                if (this.emh.bks().enS != null && !TextUtils.isEmpty(this.emh.bks().enS.exception)) {
                    this.emh.bkr().mException = this.emh.bks().enS.exception;
                } else {
                    this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry);
                }
                TiebaStatic.net(this.emh);
                return null;
            } else if (this.lMf.isCanceled()) {
                return null;
            } else {
                str = new String(drk.retBytes, "utf-8");
                try {
                    if (this.emh.bkq().bku().mIsBaiduServer && this.emh.bkq().bku().mIsJson) {
                        Ax(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.emh.bks().enS.downloadSize;
                    aVar.mTime = this.emh.bks().enS.Lr;
                    aVar.mTimesNum = this.emh.bks().enS.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.emh.bks().enS.retry);
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.emh.bkr().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.emh.bkr().mNetErrorCode = -15;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.emh.bkr().mNetErrorCode = -12;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.emh.bkr().mNetErrorCode = -13;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.emh.bkr().mNetErrorCode = -10;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.emh.bkr().mNetErrorCode = -10;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.emh);
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
            if (this.emh.bkq().bku().mPostData != null && this.emh.bkq().bku().mPostData.size() > 0 && !this.emh.bkq().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.emh.bkq().bku().mUrl);
                if (this.emh.bkq().bku().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.emh.bkq().bku().mUrl.endsWith("?") && !this.emh.bkq().bku().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.emh.bkq().bku().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.emh.bkq().bku().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(at.getUrlEncode(this.emh.bkq().bku().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.emh.bkq().bku().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.emh.bkq().bku().mRequestGzip || this.emh.bkq().bku().mIsBDImage) && !this.emh.bkq().mIsFromCDN) {
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
        if (this.lMf.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.lMf.b(str, z, 5, 100, -1, -1, bjO());
        com.baidu.tieba.recapp.download.http.g dri = this.lMf.dri();
        if (dri == null) {
            return null;
        }
        iVar = dri.drk();
        if (dri != null) {
            try {
                if (dri.my() == null || dri.my().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.emh.bkr().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e7) {
                e = e7;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -12;
                TiebaStatic.net(this.emh);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e8) {
                e = e8;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -13;
                TiebaStatic.net(this.emh);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e9) {
                e = e9;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.emh);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e10) {
                e = e10;
                this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS != null ? this.emh.bks().enS.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.emh.bkr().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.emh);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.emh.bkr().mNetErrorCode = iVar.responseCode;
        if (this.emh.bkr().mNetErrorCode != 200) {
            this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.emh.bks().enS != null && !TextUtils.isEmpty(this.emh.bks().enS.exception)) {
                this.emh.bkr().mException = this.emh.bks().enS.exception;
            } else {
                this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry);
            }
            TiebaStatic.net(this.emh);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > emm) {
                    this.emh.bkr().mNetErrorCode = -11;
                    TiebaStatic.net(this.emh);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bub().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.emh.bkq().bku().mUrl + "], size:" + i2);
                            this.emh.bkr().mNetErrorCode = -16;
                            TiebaStatic.net(this.emh);
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
        aVar.mSize = this.emh.bks().enS.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.emh.bks().enS.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.emh.bks().enS.retry);
        TiebaStatic.net(this.emh);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.emh.bkr().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.emh.bkq().bku().charSet = TextUtils.isEmpty(this.emh.bkq().bku().charSet) ? "UTF-8" : this.emh.bkq().bku().charSet;
            str = new String(netData, 0, netData.length, this.emh.bkq().bku().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            Ax(str);
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
            if (this.emh.bkq().bku().mPostData == null || i2 >= this.emh.bkq().bku().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.emh.bkq().bku().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.emh.bkq().bku().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.lMf.isCanceled()) {
                return null;
            }
            if (this.lMf.b(this.emh.bkq().bku().mUrl, this.emh.bkq().bku().mPostData, this.emh.bkq().bku().mRequestGzip, 5, -1, bjO()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dri = this.lMf.dri();
            if (dri == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i drk = dri.drk();
            if (dri == null || dri.my() == null || dri.my().size() > 0) {
            }
            this.emh.bkr().mNetErrorCode = drk.responseCode;
            this.emh.bkr().mHeader = drk.LY;
            if (this.emh.bkr().mNetErrorCode != 200) {
                if (this.emh.bks().enS != null && !TextUtils.isEmpty(this.emh.bks().enS.exception)) {
                    this.emh.bkr().mException = this.emh.bks().enS.exception;
                } else {
                    this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry);
                }
                TiebaStatic.net(this.emh);
                return null;
            } else if (this.lMf.isCanceled()) {
                return null;
            } else {
                str = new String(drk.retBytes, "utf-8");
                try {
                    if (this.emh.bkq().bku().mIsBaiduServer && this.emh.bkq().bku().mIsJson) {
                        Ax(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.emh.bks().enS.downloadSize;
                    aVar.mTime = this.emh.bks().enS.Lr;
                    aVar.mTimesNum = this.emh.bks().enS.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.emh.bks().enS.retry);
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.emh.bkr().mException = String.valueOf(this.emh.bkr().mNetErrorCode) + "|retryCount:" + (this.emh.bks().enS == null ? -1 : this.emh.bks().enS.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.emh.bkr().mNetErrorCode = -14;
                    return str2;
                } catch (OutOfMemoryError e6) {
                    e4 = e6;
                    this.emh.bkr().mNetErrorCode = -15;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (SocketException e7) {
                    e3 = e7;
                    this.emh.bkr().mNetErrorCode = -12;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (SocketTimeoutException e8) {
                    e2 = e8;
                    this.emh.bkr().mNetErrorCode = -13;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (Exception e9) {
                    e = e9;
                    this.emh.bkr().mNetErrorCode = -10;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.emh);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.emh.bkr().mNetErrorCode = -10;
                    this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.emh);
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
            if (this.lMf.isCanceled()) {
                return false;
            }
            return this.lMf.a(this.emh.bkq().bku().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bjO(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int emo = 0;
                int emp = 0;
                int emq = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.emo = i5 / 50;
                    }
                    this.emp += i4 - this.emq;
                    this.emq = i4;
                    if (handler != null) {
                        if (this.emp > this.emo || i4 == i5) {
                            this.emp = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.emh.bkr().mNetErrorCode = -10;
            this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.emh.bkr().mNetErrorCode = -15;
            this.emh.bkr().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.emh);
        }
    }
}
