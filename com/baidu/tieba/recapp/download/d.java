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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.t;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.download.http.BdHttpCancelException;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes7.dex */
public class d implements t {
    private static int fbA = 2097152;
    private final com.baidu.tbadk.core.util.b.a fbv;
    private com.baidu.tieba.recapp.download.http.c mUH = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.b.a aVar) {
        this.fbv = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bQ((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eIJ : cookie);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.fbv.btd().bth().mPostData != null) {
            this.fbv.btd().bth().mPostData.clear();
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

    @Override // com.baidu.tbadk.core.util.t
    public ArrayList<BasicNameValuePair> getPostData() {
        return this.fbv.btd().bth().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.fbv.btd().bth().mPostData == null) {
                this.fbv.btd().bth().mPostData = new ArrayList<>();
            }
            int c = c(this.fbv.btd().bth().mPostData, basicNameValuePair.getName());
            int size = this.fbv.btd().bth().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.fbv.btd().bth().mPostData.get(c).getName())) {
                    this.fbv.btd().bth().mPostData.set(c, basicNameValuePair);
                } else {
                    this.fbv.btd().bth().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.fbv.btd().bth().mPostData.add(c, basicNameValuePair);
            }
        }
    }

    private int c(ArrayList<BasicNameValuePair> arrayList, String str) {
        if (arrayList == null || str == null) {
            return -1;
        }
        int size = arrayList.size();
        int i = 0;
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

    @Override // com.baidu.tbadk.core.util.t
    public void addPostData(String str, byte[] bArr) {
        if (this.fbv.btd().bth().mFileData == null) {
            this.fbv.btd().bth().mFileData = new HashMap<>();
        }
        this.fbv.btd().bth().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.t
    public void cancelNetConnect() {
        this.mUH.cancel();
    }

    @Override // com.baidu.tbadk.core.util.t
    public void setCancel() {
        if (this.mUH != null) {
            this.mUH.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bsx() {
        if (this.fbv != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.fbv.btd().bth().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.fbv.btd().bth().mSeqId));
            }
            if (!TextUtils.isEmpty(this.fbv.btd().bth().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.fbv.btd().bth().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void Bh(String str) {
        this.fbv.bte().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.fbv.bte().mServerErrorCode = errorData.getError_code();
                if (this.fbv.bte().mServerErrorCode == -1) {
                    this.fbv.bte().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.fbv.bte().mServerErrorCode != 0) {
                    this.fbv.bte().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.fbv.bte().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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

    @Override // com.baidu.tbadk.core.util.t
    public String postNetData() {
        String str;
        BdHttpCancelException e;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.fbv.btd().bth().mPostData == null || i2 >= this.fbv.btd().bth().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.fbv.btd().bth().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.fbv.btd().bth().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mUH.isCanceled()) {
                return null;
            }
            if (this.mUH.b(this.fbv.btd().bth().mUrl, this.fbv.btd().bth().mPostData, this.fbv.btd().bth().mRequestGzip, 5, -1, bsx()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dDR = this.mUH.dDR();
            if (dDR == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dDT = dDR.dDT();
            if (dDR == null || dDR.lW() == null || dDR.lW().size() > 0) {
            }
            this.fbv.bte().mNetErrorCode = dDT.responseCode;
            this.fbv.bte().mHeader = dDT.Oe;
            if (this.fbv.bte().mNetErrorCode != 200) {
                if (this.fbv.btf().fdp != null && !TextUtils.isEmpty(this.fbv.btf().fdp.exception)) {
                    this.fbv.bte().mException = this.fbv.btf().fdp.exception;
                } else {
                    this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry);
                }
                TiebaStatic.net(this.fbv);
                return null;
            } else if (this.mUH.isCanceled()) {
                return null;
            } else {
                str = new String(dDT.retBytes, StandardCharsets.UTF_8);
                try {
                    if (this.fbv.btd().bth().mIsBaiduServer && this.fbv.btd().bth().mIsJson) {
                        Bh(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.fbv.btf().fdp.downloadSize;
                    aVar.mTime = this.fbv.btf().fdp.Nw;
                    aVar.mTimesNum = this.fbv.btf().fdp.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.fbv.btf().fdp.retry);
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.fbv.bte().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.fbv.bte().mNetErrorCode = -12;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.fbv.bte().mNetErrorCode = -13;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.fbv.bte().mNetErrorCode = -10;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.fbv.bte().mNetErrorCode = -15;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.fbv.bte().mNetErrorCode = -10;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                }
            }
        } catch (BdHttpCancelException e7) {
            e = e7;
            str2 = null;
        } catch (OutOfMemoryError e8) {
            e = e8;
            str = null;
        } catch (SocketException e9) {
            e = e9;
            str = null;
        } catch (SocketTimeoutException e10) {
            e = e10;
            str = null;
        } catch (Exception e11) {
            e = e11;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x05a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0167  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0388 -> B:94:0x0389). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] getNetData() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.fbv.btd().bth().mPostData != null && this.fbv.btd().bth().mPostData.size() > 0 && !this.fbv.btd().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.fbv.btd().bth().mUrl);
                if (this.fbv.btd().bth().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.fbv.btd().bth().mUrl.endsWith("?") && !this.fbv.btd().bth().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.fbv.btd().bth().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.fbv.btd().bth().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(au.getUrlEncode(this.fbv.btd().bth().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.fbv.btd().bth().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.fbv.btd().bth().mRequestGzip || this.fbv.btd().bth().mIsBDImage) && !this.fbv.btd().mIsFromCDN) {
                z = false;
            }
        } catch (BdHttpCancelException e) {
            bdHttpCancelException = e;
            iVar = null;
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
        if (this.mUH.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mUH.b(str, z, 5, 100, -1, -1, bsx());
        com.baidu.tieba.recapp.download.http.g dDR = this.mUH.dDR();
        if (dDR == null) {
            return null;
        }
        iVar = dDR.dDT();
        if (dDR != null) {
            try {
                if (dDR.lW() == null || dDR.lW().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.fbv.bte().mNetErrorCode = -14;
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fbv);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -12;
                TiebaStatic.net(this.fbv);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -13;
                TiebaStatic.net(this.fbv);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp != null ? this.fbv.btf().fdp.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fbv.bte().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fbv);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.fbv.bte().mNetErrorCode = iVar.responseCode;
        if (this.fbv.bte().mNetErrorCode != 200) {
            this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.fbv.btf().fdp != null && !TextUtils.isEmpty(this.fbv.btf().fdp.exception)) {
                this.fbv.bte().mException = this.fbv.btf().fdp.exception;
            } else {
                this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry);
            }
            TiebaStatic.net(this.fbv);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > fbA) {
                    this.fbv.bte().mNetErrorCode = -11;
                    TiebaStatic.net(this.fbv);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bCS().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.fbv.btd().bth().mUrl + "], size:" + i2);
                            this.fbv.bte().mNetErrorCode = -16;
                            TiebaStatic.net(this.fbv);
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
        aVar.mSize = this.fbv.btf().fdp.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.fbv.btf().fdp.retry;
        aVar.mMethod = 2;
        ad.a(aVar);
        ad.mErrorNums.set(this.fbv.btf().fdp.retry);
        TiebaStatic.net(this.fbv);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.t
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.fbv.bte().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.fbv.btd().bth().charSet = TextUtils.isEmpty(this.fbv.btd().bth().charSet) ? "UTF-8" : this.fbv.btd().bth().charSet;
            str = new String(netData, 0, netData.length, this.fbv.btd().bth().charSet);
            try {
                Bh(str);
                return str;
            } catch (Exception e) {
                e = e;
                BdLog.e(e.getMessage());
                return str;
            } catch (OutOfMemoryError e2) {
                e = e2;
                BdLog.e(e.getMessage());
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
        } catch (OutOfMemoryError e4) {
            e = e4;
            str = null;
        }
    }

    @Override // com.baidu.tbadk.core.util.t
    public String postMultiNetData() {
        String str;
        BdHttpCancelException e;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.fbv.btd().bth().mPostData == null || i2 >= this.fbv.btd().bth().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.fbv.btd().bth().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.fbv.btd().bth().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mUH.isCanceled()) {
                return null;
            }
            if (this.mUH.b(this.fbv.btd().bth().mUrl, this.fbv.btd().bth().mPostData, this.fbv.btd().bth().mRequestGzip, 5, -1, bsx()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dDR = this.mUH.dDR();
            if (dDR == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dDT = dDR.dDT();
            if (dDR == null || dDR.lW() == null || dDR.lW().size() > 0) {
            }
            this.fbv.bte().mNetErrorCode = dDT.responseCode;
            this.fbv.bte().mHeader = dDT.Oe;
            if (this.fbv.bte().mNetErrorCode != 200) {
                if (this.fbv.btf().fdp != null && !TextUtils.isEmpty(this.fbv.btf().fdp.exception)) {
                    this.fbv.bte().mException = this.fbv.btf().fdp.exception;
                } else {
                    this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry);
                }
                TiebaStatic.net(this.fbv);
                return null;
            } else if (this.mUH.isCanceled()) {
                return null;
            } else {
                str = new String(dDT.retBytes, StandardCharsets.UTF_8);
                try {
                    if (this.fbv.btd().bth().mIsBaiduServer && this.fbv.btd().bth().mIsJson) {
                        Bh(str);
                    }
                    ad.a aVar = new ad.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.fbv.btf().fdp.downloadSize;
                    aVar.mTime = this.fbv.btf().fdp.Nw;
                    aVar.mTimesNum = this.fbv.btf().fdp.retry;
                    aVar.mMethod = 1;
                    ad.a(aVar);
                    ad.mErrorNums.set(this.fbv.btf().fdp.retry);
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.fbv.bte().mException = this.fbv.bte().mNetErrorCode + "|retryCount:" + (this.fbv.btf().fdp == null ? -1 : this.fbv.btf().fdp.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.fbv.bte().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.fbv.bte().mNetErrorCode = -12;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.fbv.bte().mNetErrorCode = -13;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.fbv.bte().mNetErrorCode = -10;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.fbv.bte().mNetErrorCode = -15;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.fbv.bte().mNetErrorCode = -10;
                    this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.fbv);
                    return str;
                }
            }
        } catch (BdHttpCancelException e7) {
            e = e7;
            str2 = null;
        } catch (OutOfMemoryError e8) {
            e = e8;
            str = null;
        } catch (SocketException e9) {
            e = e9;
            str = null;
        } catch (SocketTimeoutException e10) {
            e = e10;
            str = null;
        } catch (Exception e11) {
            e = e11;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [795=5] */
    @Override // com.baidu.tbadk.core.util.t
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.mUH.isCanceled()) {
                return false;
            }
            return this.mUH.a(this.fbv.btd().bth().mUrl, (z ? new File(str) : com.baidu.tieba.recapp.b.createFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bsx(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int fbC = 0;
                int fbD = 0;
                int fbE = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.fbC = i5 / 50;
                    }
                    this.fbD += i4 - this.fbE;
                    this.fbE = i4;
                    if (handler != null) {
                        if (this.fbD > this.fbC || i4 == i5) {
                            this.fbD = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.fbv.bte().mNetErrorCode = -10;
            this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.fbv.bte().mNetErrorCode = -15;
            this.fbv.bte().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.fbv);
        }
    }
}
