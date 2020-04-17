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
    private static int dyT = 2097152;
    private final com.baidu.tbadk.core.util.a.a dyO;
    private com.baidu.tieba.recapp.download.http.c ksi = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.dyO = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bJ((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.djS : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.dyO.aOZ().aPd().mPostData != null) {
            this.dyO.aOZ().aPd().mPostData.clear();
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
        return this.dyO.aOZ().aPd().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.dyO.aOZ().aPd().mPostData == null) {
                this.dyO.aOZ().aPd().mPostData = new ArrayList<>();
            }
            int c = c(this.dyO.aOZ().aPd().mPostData, basicNameValuePair.getName());
            int size = this.dyO.aOZ().aPd().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.dyO.aOZ().aPd().mPostData.get(c).getName())) {
                    this.dyO.aOZ().aPd().mPostData.set(c, basicNameValuePair);
                } else {
                    this.dyO.aOZ().aPd().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.dyO.aOZ().aPd().mPostData.add(c, basicNameValuePair);
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
        if (this.dyO.aOZ().aPd().mFileData == null) {
            this.dyO.aOZ().aPd().mFileData = new HashMap<>();
        }
        this.dyO.aOZ().aPd().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void cancelNetConnect() {
        this.ksi.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void setCancel() {
        if (this.ksi != null) {
            this.ksi.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> aOB() {
        if (this.dyO != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.dyO.aOZ().aPd().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dyO.aOZ().aPd().mSeqId));
            }
            if (!TextUtils.isEmpty(this.dyO.aOZ().aPd().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.dyO.aOZ().aPd().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void uF(String str) {
        this.dyO.aPa().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.dyO.aPa().mServerErrorCode = errorData.getError_code();
                if (this.dyO.aPa().mServerErrorCode == -1) {
                    this.dyO.aPa().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.dyO.aPa().mServerErrorCode != 0) {
                    this.dyO.aPa().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.dyO.aPa().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.dyO.aOZ().aPd().mPostData == null || i2 >= this.dyO.aOZ().aPd().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dyO.aOZ().aPd().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.dyO.aOZ().aPd().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ksi.isCanceled()) {
                return null;
            }
            if (this.ksi.b(this.dyO.aOZ().aPd().mUrl, this.dyO.aOZ().aPd().mPostData, this.dyO.aOZ().aPd().mRequestGzip, 5, -1, aOB()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cNC = this.ksi.cNC();
            if (cNC == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cNE = cNC.cNE();
            if (cNC == null || cNC.kD() == null || cNC.kD().size() > 0) {
            }
            this.dyO.aPa().mNetErrorCode = cNE.responseCode;
            this.dyO.aPa().mHeader = cNE.Kq;
            if (this.dyO.aPa().mNetErrorCode != 200) {
                if (this.dyO.aPb().dAq != null && !TextUtils.isEmpty(this.dyO.aPb().dAq.exception)) {
                    this.dyO.aPa().mException = this.dyO.aPb().dAq.exception;
                } else {
                    this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry);
                }
                TiebaStatic.net(this.dyO);
                return null;
            } else if (this.ksi.isCanceled()) {
                return null;
            } else {
                str = new String(cNE.retBytes, "utf-8");
                try {
                    if (this.dyO.aOZ().aPd().mIsBaiduServer && this.dyO.aOZ().aPd().mIsJson) {
                        uF(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.dyO.aPb().dAq.downloadSize;
                    aVar.mTime = this.dyO.aPb().dAq.JO;
                    aVar.mTimesNum = this.dyO.aPb().dAq.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.dyO.aPb().dAq.retry);
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.dyO.aPa().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.dyO.aPa().mNetErrorCode = -12;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.dyO.aPa().mNetErrorCode = -13;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.dyO.aPa().mNetErrorCode = -10;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.dyO.aPa().mNetErrorCode = -15;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.dyO.aPa().mNetErrorCode = -10;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.dyO);
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
            if (this.dyO.aOZ().aPd().mPostData != null && this.dyO.aOZ().aPd().mPostData.size() > 0 && !this.dyO.aOZ().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.dyO.aOZ().aPd().mUrl);
                if (this.dyO.aOZ().aPd().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.dyO.aOZ().aPd().mUrl.endsWith("?") && !this.dyO.aOZ().aPd().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.dyO.aOZ().aPd().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.dyO.aOZ().aPd().mPostData.get(i).getName());
                    sb.append(ETAG.EQUAL);
                    sb.append(aq.getUrlEncode(this.dyO.aOZ().aPd().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.dyO.aOZ().aPd().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.dyO.aOZ().aPd().mRequestGzip || this.dyO.aOZ().aPd().mIsBDImage) && !this.dyO.aOZ().mIsFromCDN) {
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
        if (this.ksi.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.ksi.b(str, z, 5, 100, -1, -1, aOB());
        com.baidu.tieba.recapp.download.http.g cNC = this.ksi.cNC();
        if (cNC == null) {
            return null;
        }
        iVar = cNC.cNE();
        if (cNC != null) {
            try {
                if (cNC.kD() == null || cNC.kD().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.dyO.aPa().mNetErrorCode = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dyO);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.dyO);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -12;
                TiebaStatic.net(this.dyO);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq != null ? this.dyO.aPb().dAq.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.dyO.aPa().mNetErrorCode = -13;
                TiebaStatic.net(this.dyO);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.dyO.aPa().mNetErrorCode = iVar.responseCode;
        if (this.dyO.aPa().mNetErrorCode != 200) {
            this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.dyO.aPb().dAq != null && !TextUtils.isEmpty(this.dyO.aPb().dAq.exception)) {
                this.dyO.aPa().mException = this.dyO.aPb().dAq.exception;
            } else {
                this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry);
            }
            TiebaStatic.net(this.dyO);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > dyT) {
                    this.dyO.aPa().mNetErrorCode = -11;
                    TiebaStatic.net(this.dyO);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.aYm().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.dyO.aOZ().aPd().mUrl + "], size:" + i2);
                            this.dyO.aPa().mNetErrorCode = -16;
                            TiebaStatic.net(this.dyO);
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
        aVar.mSize = this.dyO.aPb().dAq.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.dyO.aPb().dAq.retry;
        aVar.mMethod = 2;
        aa.a(aVar);
        aa.mErrorNums.set(this.dyO.aPb().dAq.retry);
        TiebaStatic.net(this.dyO);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String getNetString() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] netData = getNetData();
        if (netData == null || this.dyO.aPa().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.dyO.aOZ().aPd().charSet = TextUtils.isEmpty(this.dyO.aOZ().aPd().charSet) ? "UTF-8" : this.dyO.aOZ().aPd().charSet;
            str = new String(netData, 0, netData.length, this.dyO.aOZ().aPd().charSet);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            uF(str);
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
            if (this.dyO.aOZ().aPd().mPostData == null || i2 >= this.dyO.aOZ().aPd().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.dyO.aOZ().aPd().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append(ETAG.EQUAL);
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.dyO.aOZ().aPd().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.ksi.isCanceled()) {
                return null;
            }
            if (this.ksi.b(this.dyO.aOZ().aPd().mUrl, this.dyO.aOZ().aPd().mPostData, this.dyO.aOZ().aPd().mRequestGzip, 5, -1, aOB()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g cNC = this.ksi.cNC();
            if (cNC == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cNE = cNC.cNE();
            if (cNC == null || cNC.kD() == null || cNC.kD().size() > 0) {
            }
            this.dyO.aPa().mNetErrorCode = cNE.responseCode;
            this.dyO.aPa().mHeader = cNE.Kq;
            if (this.dyO.aPa().mNetErrorCode != 200) {
                if (this.dyO.aPb().dAq != null && !TextUtils.isEmpty(this.dyO.aPb().dAq.exception)) {
                    this.dyO.aPa().mException = this.dyO.aPb().dAq.exception;
                } else {
                    this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry);
                }
                TiebaStatic.net(this.dyO);
                return null;
            } else if (this.ksi.isCanceled()) {
                return null;
            } else {
                str = new String(cNE.retBytes, "utf-8");
                try {
                    if (this.dyO.aOZ().aPd().mIsBaiduServer && this.dyO.aOZ().aPd().mIsJson) {
                        uF(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.dyO.aPb().dAq.downloadSize;
                    aVar.mTime = this.dyO.aPb().dAq.JO;
                    aVar.mTimesNum = this.dyO.aPb().dAq.retry;
                    aVar.mMethod = 1;
                    aa.a(aVar);
                    aa.mErrorNums.set(this.dyO.aPb().dAq.retry);
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.dyO.aPa().mException = String.valueOf(this.dyO.aPa().mNetErrorCode) + "|retryCount:" + (this.dyO.aPb().dAq == null ? -1 : this.dyO.aPb().dAq.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.dyO.aPa().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.dyO.aPa().mNetErrorCode = -12;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.dyO.aPa().mNetErrorCode = -13;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.dyO.aPa().mNetErrorCode = -10;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.dyO.aPa().mNetErrorCode = -15;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.dyO);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.dyO.aPa().mNetErrorCode = -10;
                    this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.dyO);
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
            if (this.ksi.isCanceled()) {
                return false;
            }
            return this.ksi.a(this.dyO.aOZ().aPd().mUrl, (z ? new File(str) : m.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, aOB(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int dyV = 0;
                int dyW = 0;
                int dyX = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.dyV = i5 / 50;
                    }
                    this.dyW += i4 - this.dyX;
                    this.dyX = i4;
                    if (handler != null) {
                        if (this.dyW > this.dyV || i4 == i5) {
                            this.dyW = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.dyO.aPa().mNetErrorCode = -10;
            this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.dyO.aPa().mNetErrorCode = -15;
            this.dyO.aPa().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.dyO);
        }
    }
}
