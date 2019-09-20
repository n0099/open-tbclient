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
    private static int bSQ = 2097152;
    private final com.baidu.tbadk.core.util.a.a bSK;
    private com.baidu.tieba.recapp.download.http.c iJU = new com.baidu.tieba.recapp.download.http.c();
    private Context mContext = TbadkCoreApplication.getInst().getApp();

    public d(com.baidu.tbadk.core.util.a.a aVar) {
        this.bSK = aVar;
        com.baidu.tieba.recapp.download.http.c.setUserAgent("bdtb for Android " + TbConfig.getVersion());
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        String cookie = CookieManager.getInstance().getCookie("*.baidu.com");
        com.baidu.tieba.recapp.download.http.c.aC((TextUtils.isEmpty(cookie) || !cookie.contains("BAIDUID=")) ? com.baidu.tbadk.browser.a.bCh : cookie);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void u(ArrayList<BasicNameValuePair> arrayList) {
        if (this.bSK.ajM().ajP().bVP != null) {
            this.bSK.ajM().ajP().bVP.clear();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                a(arrayList.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.q
    public ArrayList<BasicNameValuePair> ail() {
        return this.bSK.ajM().ajP().bVP;
    }

    @Override // com.baidu.tbadk.core.util.q
    public void o(String str, String str2) {
        a(new BasicNameValuePair(str, str2));
    }

    @Override // com.baidu.tbadk.core.util.q
    public void a(BasicNameValuePair basicNameValuePair) {
        if (basicNameValuePair != null && basicNameValuePair.getName() != null) {
            if (this.bSK.ajM().ajP().bVP == null) {
                this.bSK.ajM().ajP().bVP = new ArrayList<>();
            }
            int b = b(this.bSK.ajM().ajP().bVP, basicNameValuePair.getName());
            int size = this.bSK.ajM().ajP().bVP.size();
            if (b >= 0 && b < size) {
                if (basicNameValuePair.getName().equals(this.bSK.ajM().ajP().bVP.get(b).getName())) {
                    this.bSK.ajM().ajP().bVP.set(b, basicNameValuePair);
                } else {
                    this.bSK.ajM().ajP().bVP.add(b, basicNameValuePair);
                }
            } else if (b == size) {
                this.bSK.ajM().ajP().bVP.add(b, basicNameValuePair);
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
    public void d(String str, byte[] bArr) {
        if (this.bSK.ajM().ajP().bVQ == null) {
            this.bSK.ajM().ajP().bVQ = new HashMap<>();
        }
        this.bSK.ajM().ajP().bVQ.put(str, bArr);
    }

    @Override // com.baidu.tbadk.core.util.q
    public void ik() {
        this.iJU.cancel();
    }

    @Override // com.baidu.tbadk.core.util.q
    public void in() {
        if (this.iJU != null) {
            this.iJU.in();
        }
    }

    private LinkedList<BasicNameValuePair> aiT() {
        if (this.bSK != null) {
            LinkedList<BasicNameValuePair> linkedList = new LinkedList<>();
            if (!TextUtils.isEmpty(this.bSK.ajM().ajP().bVU)) {
                linkedList.add(new BasicNameValuePair("sid", this.bSK.ajM().ajP().bVU));
            }
            if (!TextUtils.isEmpty(this.bSK.ajM().ajP().mNetType)) {
                linkedList.add(new BasicNameValuePair("net", this.bSK.ajM().ajP().mNetType));
                return linkedList;
            }
            return linkedList;
        }
        return null;
    }

    public void nU(String str) {
        this.bSK.ajN().bVr = -1;
        if (str != null) {
            try {
                ErrorData errorData = new ErrorData();
                errorData.parserJson(str);
                this.bSK.ajN().bVr = errorData.getError_code();
                if (this.bSK.ajN().bVr == -1) {
                    this.bSK.ajN().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
                } else if (this.bSK.ajN().bVr != 0) {
                    this.bSK.ajN().mErrorString = errorData.getError_msg();
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                this.bSK.ajN().mErrorString = this.mContext.getString(R.string.error_unkown_try_again);
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
    public String aim() {
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
            if (this.bSK.ajM().ajP().bVP == null || i2 >= this.bSK.ajM().ajP().bVP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSK.ajM().ajP().bVP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSK.ajM().ajP().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bn(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iJU.isCanceled()) {
                return null;
            }
            if (this.iJU.b(this.bSK.ajM().ajP().mUrl, this.bSK.ajM().ajP().bVP, this.bSK.ajM().ajP().bVR, 5, -1, aiT()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g ciY = this.iJU.ciY();
            if (ciY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cja = ciY.cja();
            if (ciY == null || ciY.iw() == null || ciY.iw().size() > 0) {
            }
            this.bSK.ajN().AR = cja.responseCode;
            this.bSK.ajN().mHeader = cja.AT;
            if (this.bSK.ajN().AR != 200) {
                if (this.bSK.ajO().bVt != null && !TextUtils.isEmpty(this.bSK.ajO().bVt.Az)) {
                    this.bSK.ajN().bVs = this.bSK.ajO().bVt.Az;
                } else {
                    this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt == null ? -1 : this.bSK.ajO().bVt.Aw);
                }
                TiebaStatic.net(this.bSK);
                return null;
            } else if (this.iJU.isCanceled()) {
                return null;
            } else {
                str = new String(cja.AU, "utf-8");
                try {
                    if (this.bSK.ajM().ajP().mIsBaiduServer && this.bSK.ajM().ajP().bVS) {
                        nU(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWP = this.bSK.ajO().bVt.Au;
                    aVar.mTime = this.bSK.ajO().bVt.Ax;
                    aVar.bTf = this.bSK.ajO().bVt.Aw;
                    aVar.bTe = 1;
                    aa.a(aVar);
                    aa.bTd.set(this.bSK.ajO().bVt.Aw);
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt == null ? -1 : this.bSK.ajO().bVt.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSK.ajN().AR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bSK.ajN().AR = -12;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bSK.ajN().AR = -13;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bSK.ajN().AR = -10;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bSK.ajN().AR = -15;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSK.ajN().AR = -10;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSK);
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
    public byte[] ain() {
        com.baidu.tieba.recapp.download.http.i iVar;
        BdHttpCancelException bdHttpCancelException;
        com.baidu.tieba.recapp.download.http.i iVar2;
        byte[] bArr;
        String str;
        String str2;
        boolean z = true;
        com.baidu.tieba.recapp.download.http.c.setUid(TbadkCoreApplication.getCurrentAccount());
        try {
            if (this.bSK.ajM().ajP().bVP != null && this.bSK.ajM().ajP().bVP.size() > 0 && !this.bSK.ajM().mIsFromCDN) {
                StringBuilder sb = new StringBuilder(30);
                sb.append(this.bSK.ajM().ajP().mUrl);
                if (this.bSK.ajM().ajP().mUrl.indexOf("?") < 0) {
                    sb.append("?");
                } else if (!this.bSK.ajM().ajP().mUrl.endsWith("?") && !this.bSK.ajM().ajP().mUrl.endsWith("&")) {
                    sb.append("&");
                }
                for (int i = 0; i < this.bSK.ajM().ajP().bVP.size(); i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(this.bSK.ajM().ajP().bVP.get(i).getName());
                    sb.append("=");
                    sb.append(aq.bi(this.bSK.ajM().ajP().bVP.get(i).getValue()));
                }
                str = sb.toString();
            } else {
                str = this.bSK.ajM().ajP().mUrl;
            }
            if (TbConfig.getDebugSwitch()) {
            }
            if ((!this.bSK.ajM().ajP().bVR || this.bSK.ajM().ajP().mIsBDImage) && !this.bSK.ajM().mIsFromCDN) {
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
        if (this.iJU.isCanceled()) {
            throw new BdHttpCancelException();
        }
        long j = new Date().getTime();
        this.iJU.b(str, z, 5, 100, -1, -1, aiT());
        com.baidu.tieba.recapp.download.http.g ciY = this.iJU.ciY();
        if (ciY == null) {
            return null;
        }
        iVar = ciY.cja();
        if (ciY != null) {
            try {
                if (ciY.iw() == null || ciY.iw().size() > 0) {
                }
            } catch (BdHttpCancelException e6) {
                iVar2 = iVar;
                bdHttpCancelException = e6;
                this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt == null ? -1 : this.bSK.ajO().bVt.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                this.bSK.ajN().AR = -14;
                iVar = iVar2;
                if (iVar == null) {
                }
                return bArr;
            } catch (Exception e7) {
                e = e7;
                this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt != null ? this.bSK.ajO().bVt.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSK.ajN().AR = -10;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSK);
                if (iVar == null) {
                }
                return bArr;
            } catch (OutOfMemoryError e8) {
                e = e8;
                this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt != null ? this.bSK.ajO().bVt.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSK.ajN().AR = -15;
                BdLog.e(e.getMessage());
                TiebaStatic.net(this.bSK);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketException e9) {
                e = e9;
                this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt != null ? this.bSK.ajO().bVt.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSK.ajN().AR = -12;
                TiebaStatic.net(this.bSK);
                if (iVar == null) {
                }
                return bArr;
            } catch (SocketTimeoutException e10) {
                e = e10;
                this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt != null ? this.bSK.ajO().bVt.Aw : -1) + "|" + e.getClass() + "|" + e.getMessage();
                this.bSK.ajN().AR = -13;
                TiebaStatic.net(this.bSK);
                if (iVar == null) {
                }
                return bArr;
            }
        }
        if (iVar == null) {
            return null;
        }
        this.bSK.ajN().AR = iVar.responseCode;
        if (this.bSK.ajN().AR != 200) {
            this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
            if (this.bSK.ajO().bVt != null && !TextUtils.isEmpty(this.bSK.ajO().bVt.Az)) {
                this.bSK.ajN().bVs = this.bSK.ajO().bVt.Az;
            } else {
                this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt == null ? -1 : this.bSK.ajO().bVt.Aw);
            }
            TiebaStatic.net(this.bSK);
            return null;
        }
        if (TbadkCoreApplication.getInst().isMainProcess(true) && (str2 = iVar.contentLength) != null) {
            try {
                int parseInt = Integer.parseInt(str2);
                if (parseInt > bSQ) {
                    this.bSK.ajN().AR = -11;
                    TiebaStatic.net(this.bSK);
                    bArr = null;
                } else {
                    int i2 = parseInt * 10;
                    if (i2 > 0) {
                        if (BdLog.isDebugMode()) {
                        }
                        if (!com.baidu.tbadk.imageManager.c.atK().kJ(i2)) {
                            BdLog.d("Image download cacelled. out of memory. url:[" + this.bSK.ajM().ajP().mUrl + "], size:" + i2);
                            this.bSK.ajN().AR = -16;
                            TiebaStatic.net(this.bSK);
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
        aVar.aWP = this.bSK.ajO().bVt.Au;
        aVar.mTime = new Date().getTime() - j;
        aVar.bTf = this.bSK.ajO().bVt.Aw;
        aVar.bTe = 2;
        aa.a(aVar);
        aa.bTd.set(this.bSK.ajO().bVt.Aw);
        TiebaStatic.net(this.bSK);
        bArr = iVar == null ? iVar.AU : null;
        return bArr;
    }

    @Override // com.baidu.tbadk.core.util.q
    public String aio() {
        String str;
        OutOfMemoryError e;
        Exception e2;
        byte[] ain = ain();
        if (ain == null || this.bSK.ajN().AR != 200) {
            return null;
        }
        try {
            this.bSK.ajM().ajP().bVT = TextUtils.isEmpty(this.bSK.ajM().ajP().bVT) ? HTTP.UTF_8 : this.bSK.ajM().ajP().bVT;
            str = new String(ain, 0, ain.length, this.bSK.ajM().ajP().bVT);
        } catch (Exception e3) {
            str = null;
            e2 = e3;
        } catch (OutOfMemoryError e4) {
            str = null;
            e = e4;
        }
        try {
            nU(str);
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
    public String aip() {
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
            if (this.bSK.ajM().ajP().bVP == null || i2 >= this.bSK.ajM().ajP().bVP.size()) {
                break;
            }
            BasicNameValuePair basicNameValuePair = this.bSK.ajM().ajP().bVP.get(i2);
            if (basicNameValuePair != null) {
                String name = basicNameValuePair.getName();
                String value = basicNameValuePair.getValue();
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
            i = i2 + 1;
        }
        if (this.bSK.ajM().ajP().mIsBaiduServer) {
            sb.append("tiebaclient!!!");
            o("sign", s.bn(sb.toString()));
        }
        if (TbConfig.getDebugSwitch()) {
        }
        try {
            if (this.iJU.isCanceled()) {
                return null;
            }
            if (this.iJU.b(this.bSK.ajM().ajP().mUrl, this.bSK.ajM().ajP().bVP, this.bSK.ajM().ajP().bVR, 5, -1, aiT()) == null) {
                throw new BdHttpCancelException();
            }
            com.baidu.tieba.recapp.download.http.g ciY = this.iJU.ciY();
            if (ciY == null) {
                return null;
            }
            com.baidu.tieba.recapp.download.http.i cja = ciY.cja();
            if (ciY == null || ciY.iw() == null || ciY.iw().size() > 0) {
            }
            this.bSK.ajN().AR = cja.responseCode;
            this.bSK.ajN().mHeader = cja.AT;
            if (this.bSK.ajN().AR != 200) {
                if (this.bSK.ajO().bVt != null && !TextUtils.isEmpty(this.bSK.ajO().bVt.Az)) {
                    this.bSK.ajN().bVs = this.bSK.ajO().bVt.Az;
                } else {
                    this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt == null ? -1 : this.bSK.ajO().bVt.Aw);
                }
                TiebaStatic.net(this.bSK);
                return null;
            } else if (this.iJU.isCanceled()) {
                return null;
            } else {
                str = new String(cja.AU, "utf-8");
                try {
                    if (this.bSK.ajM().ajP().mIsBaiduServer && this.bSK.ajM().ajP().bVS) {
                        nU(str);
                    }
                    aa.a aVar = new aa.a();
                    aVar.mMode = getMode(com.baidu.adp.lib.util.j.netType());
                    aVar.aWP = this.bSK.ajO().bVt.Au;
                    aVar.mTime = this.bSK.ajO().bVt.Ax;
                    aVar.bTf = this.bSK.ajO().bVt.Aw;
                    aVar.bTe = 1;
                    aa.a(aVar);
                    aa.bTd.set(this.bSK.ajO().bVt.Aw);
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (BdHttpCancelException e5) {
                    bdHttpCancelException = e5;
                    str2 = str;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    this.bSK.ajN().bVs = String.valueOf(this.bSK.ajN().AR) + "|retryCount:" + (this.bSK.ajO().bVt == null ? -1 : this.bSK.ajO().bVt.Aw) + "|" + bdHttpCancelException.getClass() + "|" + bdHttpCancelException.getMessage();
                    this.bSK.ajN().AR = -14;
                    return str2;
                } catch (SocketException e6) {
                    e3 = e6;
                    this.bSK.ajN().AR = -12;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (SocketTimeoutException e7) {
                    e2 = e7;
                    this.bSK.ajN().AR = -13;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (Exception e8) {
                    e = e8;
                    this.bSK.ajN().AR = -10;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
                    BdLog.e(e.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (OutOfMemoryError e9) {
                    e4 = e9;
                    this.bSK.ajN().AR = -15;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
                    BdLog.e(e4.getMessage());
                    TiebaStatic.net(this.bSK);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    this.bSK.ajN().AR = -10;
                    this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    TiebaStatic.net(this.bSK);
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
    public boolean a(String str, final Handler handler, final int i, int i2, int i3, boolean z) {
        try {
            if (this.iJU.isCanceled()) {
                return false;
            }
            return this.iJU.a(this.bSK.ajM().ajP().mUrl, (z ? new File(str) : m.nt(str)).getAbsolutePath(), false, i2, i3, -1, -1, aiT(), new com.baidu.tieba.recapp.download.http.j() { // from class: com.baidu.tieba.recapp.download.d.1
                int bSS = 0;
                int bST = 0;
                int bSU = 0;

                @Override // com.baidu.tieba.recapp.download.http.j
                public void o(int i4, int i5) {
                    if (i5 > 0) {
                        this.bSS = i5 / 50;
                    }
                    this.bST += i4 - this.bSU;
                    this.bSU = i4;
                    if (handler != null) {
                        if (this.bST > this.bSS || i4 == i5) {
                            this.bST = 0;
                            handler.sendMessage(handler.obtainMessage(i, i4, i5));
                        }
                    }
                }
            }, true);
        } catch (Exception e) {
            this.bSK.ajN().AR = -10;
            this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.neterror) + " detailException:" + e.getMessage();
            BdLog.e(e.getMessage());
            return false;
        } catch (OutOfMemoryError e2) {
            this.bSK.ajN().AR = -15;
            this.bSK.ajN().mErrorString = this.mContext.getResources().getString(R.string.memoryerror);
            BdLog.e(e2.getMessage());
            return false;
        } finally {
            TiebaStatic.net(this.bSK);
        }
    }
}
