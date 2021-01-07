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
import com.baidu.tbadk.core.util.ac;
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
/* loaded from: classes8.dex */
public class d implements s {
    private static int fcv = 2097152;
    private final com.baidu.tbadk.core.util.b.a fcq;
    private com.baidu.tieba.recapp.download.http.c mNE = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.b.a aVar) {
        this.fcq = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bM((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eJN : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.fcq.bwA().bwE().mPostData != null) {
            this.fcq.bwA().bwE().mPostData.clear();
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
        return this.fcq.bwA().bwE().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.fcq.bwA().bwE().mPostData == null) {
                this.fcq.bwA().bwE().mPostData = new ArrayList<>();
            }
            int c = c(this.fcq.bwA().bwE().mPostData, basicNameValuePair.getName());
            int size = this.fcq.bwA().bwE().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.fcq.bwA().bwE().mPostData.get(c).getName())) {
                    this.fcq.bwA().bwE().mPostData.set(c, basicNameValuePair);
                } else {
                    this.fcq.bwA().bwE().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.fcq.bwA().bwE().mPostData.add(c, basicNameValuePair);
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

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, byte[] bArr) {
        if (this.fcq.bwA().bwE().mFileData == null) {
            this.fcq.bwA().bwE().mFileData = new HashMap<>();
        }
        this.fcq.bwA().bwE().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.mNE.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.mNE != null) {
            this.mNE.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bvU() {
        if (this.fcq != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.fcq.bwA().bwE().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.fcq.bwA().bwE().mSeqId));
            }
            if (!TextUtils.isEmpty(this.fcq.bwA().bwE().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.fcq.bwA().bwE().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void BU(String str) {
        this.fcq.bwB().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.fcq.bwB().mServerErrorCode = errorData.getError_code();
                if (this.fcq.bwB().mServerErrorCode == -1) {
                    this.fcq.bwB().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.fcq.bwB().mServerErrorCode != 0) {
                    this.fcq.bwB().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.fcq.bwB().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
        String str;
        BdHttpCancelException e;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.fcq.bwA().bwE().mPostData == null || i2 >= this.fcq.bwA().bwE().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.fcq.bwA().bwE().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.fcq.bwA().bwE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mNE.isCanceled()) {
                return null;
            }
            if (this.mNE.b(this.fcq.bwA().bwE().mUrl, this.fcq.bwA().bwE().mPostData, this.fcq.bwA().bwE().mRequestGzip, 5, -1, bvU()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dFk = this.mNE.dFk();
            if (dFk == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dFm = dFk.dFm();
            if (dFk == null || dFk.lX() == null || dFk.lX().size() > 0) {
            }
            this.fcq.bwB().mNetErrorCode = dFm.responseCode;
            this.fcq.bwB().mHeader = dFm.MI;
            if (this.fcq.bwB().mNetErrorCode != 200) {
                if (this.fcq.bwC().fej != null && !TextUtils.isEmpty(this.fcq.bwC().fej.exception)) {
                    this.fcq.bwB().mException = this.fcq.bwC().fej.exception;
                } else {
                    this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej == null ? -1 : this.fcq.bwC().fej.retry);
                }
                TiebaStatic.net(this.fcq);
                return null;
            } else if (this.mNE.isCanceled()) {
                return null;
            } else {
                str = new String(dFm.retBytes, "utf-8");
                try {
                    if (this.fcq.bwA().bwE().mIsBaiduServer && this.fcq.bwA().bwE().mIsJson) {
                        BU(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.fcq.bwC().fej.downloadSize;
                    aVar.mTime = this.fcq.bwC().fej.Mf;
                    aVar.mTimesNum = this.fcq.bwC().fej.retry;
                    aVar.mMethod = 1;
                    ac.a(aVar);
                    ac.mErrorNums.set(this.fcq.bwC().fej.retry);
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej == null ? -1 : this.fcq.bwC().fej.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.fcq.bwB().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.fcq.bwB().mNetErrorCode = -12;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.fcq.bwB().mNetErrorCode = -13;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.fcq.bwB().mNetErrorCode = -10;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.fcq.bwB().mNetErrorCode = -15;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.fcq.bwB().mNetErrorCode = -10;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                }
            }
        } catch (BdHttpCancelException e7) {
            e = e7;
            str2 = null;
        } catch (SocketException e8) {
            e = e8;
            str = null;
        } catch (SocketTimeoutException e9) {
            e = e9;
            str = null;
        } catch (Exception e10) {
            e = e10;
            str = null;
        } catch (OutOfMemoryError e11) {
            e = e11;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0394 -> B:94:0x0395). Please submit an issue!!! */
    @Override // com.baidu.tbadk.core.util.s
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
            if (this.fcq.bwA().bwE().mPostData != null && this.fcq.bwA().bwE().mPostData.size() > 0 && !this.fcq.bwA().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.fcq.bwA().bwE().mUrl);
                if (this.fcq.bwA().bwE().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.fcq.bwA().bwE().mUrl.endsWith("?") && !this.fcq.bwA().bwE().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.fcq.bwA().bwE().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.fcq.bwA().bwE().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(at.getUrlEncode(this.fcq.bwA().bwE().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.fcq.bwA().bwE().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.fcq.bwA().bwE().mRequestGzip || this.fcq.bwA().bwE().mIsBDImage) && !this.fcq.bwA().mIsFromCDN) {
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
        if (this.mNE.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mNE.b(str, z, 5, 100, -1, -1, bvU());
        com.baidu.tieba.recapp.download.http.g dFk = this.mNE.dFk();
        if (dFk == null) {
            return null;
        }
        iVar = dFk.dFm();
        if (dFk != null) {
            try {
                if (dFk.lX() == null || dFk.lX().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej == null ? -1 : this.fcq.bwC().fej.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.fcq.bwB().mNetErrorCode = -14;
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej != null ? this.fcq.bwC().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwB().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fcq);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej != null ? this.fcq.bwC().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwB().mNetErrorCode = -12;
                TiebaStatic.net(this.fcq);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej != null ? this.fcq.bwC().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwB().mNetErrorCode = -13;
                TiebaStatic.net(this.fcq);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej != null ? this.fcq.bwC().fej.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.fcq.bwB().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.fcq);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.fcq.bwB().mNetErrorCode = iVar.responseCode;
        if (this.fcq.bwB().mNetErrorCode != 200) {
            this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.fcq.bwC().fej != null && !TextUtils.isEmpty(this.fcq.bwC().fej.exception)) {
                this.fcq.bwB().mException = this.fcq.bwC().fej.exception;
            } else {
                this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej == null ? -1 : this.fcq.bwC().fej.retry);
            }
            TiebaStatic.net(this.fcq);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > fcv) {
                    this.fcq.bwB().mNetErrorCode = -11;
                    TiebaStatic.net(this.fcq);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bGq().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.fcq.bwA().bwE().mUrl + "], size:" + i2);
                            this.fcq.bwB().mNetErrorCode = -16;
                            TiebaStatic.net(this.fcq);
                            bArr = null;
                        }
                    }
                }
            } catch (Throwable th) {
            }
            return bArr;
        }
        ac.a aVar = new ac.a();
        aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
        aVar.mSize = this.fcq.bwC().fej.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.fcq.bwC().fej.retry;
        aVar.mMethod = 2;
        ac.a(aVar);
        ac.mErrorNums.set(this.fcq.bwC().fej.retry);
        TiebaStatic.net(this.fcq);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.fcq.bwB().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.fcq.bwA().bwE().charSet = TextUtils.isEmpty(this.fcq.bwA().bwE().charSet) ? "UTF-8" : this.fcq.bwA().bwE().charSet;
            str = new String(netData, 0, netData.length, this.fcq.bwA().bwE().charSet);
            try {
                BU(str);
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

    @Override // com.baidu.tbadk.core.util.s
    public String postMultiNetData() {
        String str;
        BdHttpCancelException e;
        String str2;
        StringBuilder sb = new StringBuilder(1024);
        int i = 0;
        while (true) {
            int i2 = i;
            if (this.fcq.bwA().bwE().mPostData == null || i2 >= this.fcq.bwA().bwE().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.fcq.bwA().bwE().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.fcq.bwA().bwE().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mNE.isCanceled()) {
                return null;
            }
            if (this.mNE.b(this.fcq.bwA().bwE().mUrl, this.fcq.bwA().bwE().mPostData, this.fcq.bwA().bwE().mRequestGzip, 5, -1, bvU()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dFk = this.mNE.dFk();
            if (dFk == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dFm = dFk.dFm();
            if (dFk == null || dFk.lX() == null || dFk.lX().size() > 0) {
            }
            this.fcq.bwB().mNetErrorCode = dFm.responseCode;
            this.fcq.bwB().mHeader = dFm.MI;
            if (this.fcq.bwB().mNetErrorCode != 200) {
                if (this.fcq.bwC().fej != null && !TextUtils.isEmpty(this.fcq.bwC().fej.exception)) {
                    this.fcq.bwB().mException = this.fcq.bwC().fej.exception;
                } else {
                    this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej == null ? -1 : this.fcq.bwC().fej.retry);
                }
                TiebaStatic.net(this.fcq);
                return null;
            } else if (this.mNE.isCanceled()) {
                return null;
            } else {
                str = new String(dFm.retBytes, "utf-8");
                try {
                    if (this.fcq.bwA().bwE().mIsBaiduServer && this.fcq.bwA().bwE().mIsJson) {
                        BU(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.fcq.bwC().fej.downloadSize;
                    aVar.mTime = this.fcq.bwC().fej.Mf;
                    aVar.mTimesNum = this.fcq.bwC().fej.retry;
                    aVar.mMethod = 1;
                    ac.a(aVar);
                    ac.mErrorNums.set(this.fcq.bwC().fej.retry);
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.fcq.bwB().mException = String.valueOf(this.fcq.bwB().mNetErrorCode) + "|retryCount:" + (this.fcq.bwC().fej == null ? -1 : this.fcq.bwC().fej.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.fcq.bwB().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.fcq.bwB().mNetErrorCode = -12;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.fcq.bwB().mNetErrorCode = -13;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.fcq.bwB().mNetErrorCode = -10;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.fcq.bwB().mNetErrorCode = -15;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.fcq.bwB().mNetErrorCode = -10;
                    this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.fcq);
                    return str;
                }
            }
        } catch (BdHttpCancelException e7) {
            e = e7;
            str2 = null;
        } catch (SocketException e8) {
            e = e8;
            str = null;
        } catch (SocketTimeoutException e9) {
            e = e9;
            str = null;
        } catch (Exception e10) {
            e = e10;
            str = null;
        } catch (OutOfMemoryError e11) {
            e = e11;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [805=5] */
    @Override // com.baidu.tbadk.core.util.s
    public boolean downloadFile(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.mNE.isCanceled()) {
                return false;
            }
            return this.mNE.a(this.fcq.bwA().bwE().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bvU(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int fcx = 0;
                int fcy = 0;
                int fcz = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.fcx = i5 / 50;
                    }
                    this.fcy += i4 - this.fcz;
                    this.fcz = i4;
                    if (handler != null) {
                        if (this.fcy > this.fcx || i4 == i5) {
                            this.fcy = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.fcq.bwB().mNetErrorCode = -10;
            this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.fcq.bwB().mNetErrorCode = -15;
            this.fcq.bwB().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.fcq);
        }
    }
}
