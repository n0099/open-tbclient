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
/* loaded from: classes7.dex */
public class d implements s {
    private static int eXM = 2097152;
    private final com.baidu.tbadk.core.util.b.a eXH;
    private com.baidu.tieba.recapp.download.http.c mJa = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.b.a aVar) {
        this.eXH = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.bM((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.eFc : cookie);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setPostData(ArrayList<BasicNameValuePair> arrayList) {
        if (this.eXH.bsG().bsK().mPostData != null) {
            this.eXH.bsG().bsK().mPostData.clear();
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
        return this.eXH.bsG().bsK().mPostData;
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(String str, String str2) {
        addPostData(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.s
    public void addPostData(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.eXH.bsG().bsK().mPostData == null) {
                this.eXH.bsG().bsK().mPostData = new ArrayList<>();
            }
            int c = c(this.eXH.bsG().bsK().mPostData, basicNameValuePair.getName());
            int size = this.eXH.bsG().bsK().mPostData.size();
            if (c >= 0 && c < size) {
                if (basicNameValuePair.getName().equals(this.eXH.bsG().bsK().mPostData.get(c).getName())) {
                    this.eXH.bsG().bsK().mPostData.set(c, basicNameValuePair);
                } else {
                    this.eXH.bsG().bsK().mPostData.add(c, basicNameValuePair);
                }
            } else if (c == size) {
                this.eXH.bsG().bsK().mPostData.add(c, basicNameValuePair);
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
        if (this.eXH.bsG().bsK().mFileData == null) {
            this.eXH.bsG().bsK().mFileData = new HashMap<>();
        }
        this.eXH.bsG().bsK().mFileData.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.s
    public void cancelNetConnect() {
        this.mJa.cancel();
    }

    @Override // com.baidu.tbadk.core.util.s
    public void setCancel() {
        if (this.mJa != null) {
            this.mJa.setCancel();
        }
    }

    private LinkedList<BasicNameValuePair> bsa() {
        if (this.eXH != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.eXH.bsG().bsK().mSeqId)) {
                linkedList.add(new BasicNameValuePair(UbcStatConstant.KEY_CONTENT_EXT_SID, this.eXH.bsG().bsK().mSeqId));
            }
            if (!TextUtils.isEmpty(this.eXH.bsG().bsK().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.eXH.bsG().bsK().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void AJ(String str) {
        this.eXH.bsH().mServerErrorCode = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.eXH.bsH().mServerErrorCode = errorData.getError_code();
                if (this.eXH.bsH().mServerErrorCode == -1) {
                    this.eXH.bsH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.eXH.bsH().mServerErrorCode != 0) {
                    this.eXH.bsH().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.eXH.bsH().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
            if (this.eXH.bsG().bsK().mPostData == null || i2 >= this.eXH.bsG().bsK().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eXH.bsG().bsK().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eXH.bsG().bsK().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mJa.isCanceled()) {
                return null;
            }
            if (this.mJa.b(this.eXH.bsG().bsK().mUrl, this.eXH.bsG().bsK().mPostData, this.eXH.bsG().bsK().mRequestGzip, 5, -1, bsa()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dBs = this.mJa.dBs();
            if (dBs == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dBu = dBs.dBu();
            if (dBs == null || dBs.lX() == null || dBs.lX().size() > 0) {
            }
            this.eXH.bsH().mNetErrorCode = dBu.responseCode;
            this.eXH.bsH().mHeader = dBu.MG;
            if (this.eXH.bsH().mNetErrorCode != 200) {
                if (this.eXH.bsI().eZA != null && !TextUtils.isEmpty(this.eXH.bsI().eZA.exception)) {
                    this.eXH.bsH().mException = this.eXH.bsI().eZA.exception;
                } else {
                    this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry);
                }
                TiebaStatic.net(this.eXH);
                return null;
            } else if (this.mJa.isCanceled()) {
                return null;
            } else {
                str = new String(dBu.retBytes, "utf-8");
                try {
                    if (this.eXH.bsG().bsK().mIsBaiduServer && this.eXH.bsG().bsK().mIsJson) {
                        AJ(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eXH.bsI().eZA.downloadSize;
                    aVar.mTime = this.eXH.bsI().eZA.Md;
                    aVar.mTimesNum = this.eXH.bsI().eZA.retry;
                    aVar.mMethod = 1;
                    ac.a(aVar);
                    ac.mErrorNums.set(this.eXH.bsI().eZA.retry);
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.eXH.bsH().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.eXH.bsH().mNetErrorCode = -12;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.eXH.bsH().mNetErrorCode = -13;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.eXH.bsH().mNetErrorCode = -10;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.eXH.bsH().mNetErrorCode = -15;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.eXH.bsH().mNetErrorCode = -10;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eXH);
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
            if (this.eXH.bsG().bsK().mPostData != null && this.eXH.bsG().bsK().mPostData.size() > 0 && !this.eXH.bsG().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.eXH.bsG().bsK().mUrl);
                if (this.eXH.bsG().bsK().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.eXH.bsG().bsK().mUrl.endsWith("?") && !this.eXH.bsG().bsK().mUrl.endsWith(ETAG.ITEM_SEPARATOR)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
                for (int i = 0; i < this.eXH.bsG().bsK().mPostData.size(); i++) {
                    if (i != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(this.eXH.bsG().bsK().mPostData.get(i).getName());
                    sb.append("=");
                    sb.append(at.getUrlEncode(this.eXH.bsG().bsK().mPostData.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.eXH.bsG().bsK().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.eXH.bsG().bsK().mRequestGzip || this.eXH.bsG().bsK().mIsBDImage) && !this.eXH.bsG().mIsFromCDN) {
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
        if (this.mJa.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.mJa.b(str, z, 5, 100, -1, -1, bsa());
        com.baidu.tieba.recapp.download.http.g dBs = this.mJa.dBs();
        if (dBs == null) {
            return null;
        }
        iVar = dBs.dBu();
        if (dBs != null) {
            try {
                if (dBs.lX() == null || dBs.lX().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                bdHttpCancelException = e6;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.eXH.bsH().mNetErrorCode = -14;
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e7) {
                e = e7;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eXH);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e8) {
                e = e8;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -12;
                TiebaStatic.net(this.eXH);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e9) {
                e = e9;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -13;
                TiebaStatic.net(this.eXH);
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e10) {
                e = e10;
                this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA != null ? this.eXH.bsI().eZA.retry : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.eXH.bsH().mNetErrorCode = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.eXH);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.eXH.bsH().mNetErrorCode = iVar.responseCode;
        if (this.eXH.bsH().mNetErrorCode != 200) {
            this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.eXH.bsI().eZA != null && !TextUtils.isEmpty(this.eXH.bsI().eZA.exception)) {
                this.eXH.bsH().mException = this.eXH.bsI().eZA.exception;
            } else {
                this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry);
            }
            TiebaStatic.net(this.eXH);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > eXM) {
                    this.eXH.bsH().mNetErrorCode = -11;
                    TiebaStatic.net(this.eXH);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.bCx().freePicCache(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.eXH.bsG().bsK().mUrl + "], size:" + i2);
                            this.eXH.bsH().mNetErrorCode = -16;
                            TiebaStatic.net(this.eXH);
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
        aVar.mSize = this.eXH.bsI().eZA.downloadSize;
        aVar.mTime = new Date().getTime() - j;
        aVar.mTimesNum = this.eXH.bsI().eZA.retry;
        aVar.mMethod = 2;
        ac.a(aVar);
        ac.mErrorNums.set(this.eXH.bsI().eZA.retry);
        TiebaStatic.net(this.eXH);
        bArr = iVar == null ? iVar.retBytes : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.s
    public String getNetString() {
        String str;
        byte[] netData = getNetData();
        if (netData == null || this.eXH.bsH().mNetErrorCode != 200) {
            return null;
        }
        try {
            this.eXH.bsG().bsK().charSet = TextUtils.isEmpty(this.eXH.bsG().bsK().charSet) ? "UTF-8" : this.eXH.bsG().bsK().charSet;
            str = new String(netData, 0, netData.length, this.eXH.bsG().bsK().charSet);
            try {
                AJ(str);
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
            if (this.eXH.bsG().bsK().mPostData == null || i2 >= this.eXH.bsG().bsK().mPostData.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.eXH.bsG().bsK().mPostData.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.eXH.bsG().bsK().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            addPostData("sign", com.baidu.adp.lib.util.s.toMd5(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.mJa.isCanceled()) {
                return null;
            }
            if (this.mJa.b(this.eXH.bsG().bsK().mUrl, this.eXH.bsG().bsK().mPostData, this.eXH.bsG().bsK().mRequestGzip, 5, -1, bsa()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g dBs = this.mJa.dBs();
            if (dBs == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i dBu = dBs.dBu();
            if (dBs == null || dBs.lX() == null || dBs.lX().size() > 0) {
            }
            this.eXH.bsH().mNetErrorCode = dBu.responseCode;
            this.eXH.bsH().mHeader = dBu.MG;
            if (this.eXH.bsH().mNetErrorCode != 200) {
                if (this.eXH.bsI().eZA != null && !TextUtils.isEmpty(this.eXH.bsI().eZA.exception)) {
                    this.eXH.bsH().mException = this.eXH.bsI().eZA.exception;
                } else {
                    this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry);
                }
                TiebaStatic.net(this.eXH);
                return null;
            } else if (this.mJa.isCanceled()) {
                return null;
            } else {
                str = new String(dBu.retBytes, "utf-8");
                try {
                    if (this.eXH.bsG().bsK().mIsBaiduServer && this.eXH.bsG().bsK().mIsJson) {
                        AJ(str);
                    }
                    ac.a aVar = new ac.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.mSize = this.eXH.bsI().eZA.downloadSize;
                    aVar.mTime = this.eXH.bsI().eZA.Md;
                    aVar.mTimesNum = this.eXH.bsI().eZA.retry;
                    aVar.mMethod = 1;
                    ac.a(aVar);
                    ac.mErrorNums.set(this.eXH.bsI().eZA.retry);
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (BdHttpCancelException e2) {
                    e = e2;
                    str2 = str;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.eXH.bsH().mException = String.valueOf(this.eXH.bsH().mNetErrorCode) + "|retryCount:" + (this.eXH.bsI().eZA == null ? -1 : this.eXH.bsI().eZA.retry) + "|" + e.getClass() + "|" + e.getMessage();
                    this.eXH.bsH().mNetErrorCode = -14;
                    return str2;
                } catch (SocketException e3) {
                    e = e3;
                    this.eXH.bsH().mNetErrorCode = -12;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (SocketTimeoutException e4) {
                    e = e4;
                    this.eXH.bsH().mNetErrorCode = -13;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (Exception e5) {
                    e = e5;
                    this.eXH.bsH().mNetErrorCode = -10;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (OutOfMemoryError e6) {
                    e = e6;
                    this.eXH.bsH().mNetErrorCode = -15;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.eXH);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    this.eXH.bsH().mNetErrorCode = -10;
                    this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.eXH);
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
            if (this.mJa.isCanceled()) {
                return false;
            }
            return this.mJa.a(this.eXH.bsG().bsK().mUrl, (z ? new File(str) : n.CreateFileIfNotFound(str)).getAbsolutePath(), false, i2, i3, -1, -1, bsa(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int eXO = 0;
                int eXP = 0;
                int eXQ = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void onProgress(int i4, int i5) {
                    if (i5 > 0) {
                        this.eXO = i5 / 50;
                    }
                    this.eXP += i4 - this.eXQ;
                    this.eXQ = i4;
                    if (handler != null) {
                        if (this.eXP > this.eXO || i4 == i5) {
                            this.eXP = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.eXH.bsH().mNetErrorCode = -10;
            this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.eXH.bsH().mNetErrorCode = -15;
            this.eXH.bsH().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.eXH);
        }
    }
}
