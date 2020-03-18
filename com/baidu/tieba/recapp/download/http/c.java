package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes13.dex */
public class c {
    private static String rJ;
    private static String rK;
    private static boolean rL;
    private static String rM;
    private static String sUid;
    private g jIR;
    private d jIS;
    private long rR;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.rR = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void au(String str) {
        rJ = str;
    }

    public static void setUserAgent(String str) {
        rK = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jIR = new g();
        a(this.jIR, z);
        this.jIR.cDf().setUrl(str);
        this.jIS = new d(this.jIR);
        this.jIS.c(i, i3, i4);
        return this.jIR.cDg();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jIR = new g();
        a(this.jIR, z);
        this.jIR.cDf().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.jIR.cDf().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.jIR.cDf().n(next.getName(), next.getValue());
            }
        }
        this.jIS = new d(this.jIR);
        this.jIS.e(i, i2, -1);
        return this.jIR.cDg();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.jIR = new g();
        b(this.jIR);
        this.jIR.cDf().setUrl(str);
        this.jIS = new d(this.jIR);
        return this.jIS.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.jIS != null) {
            this.jIS.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.jIS != null) {
            return this.jIS.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.jIS != null) {
            this.jIS.setCancel();
        }
    }

    public g cDe() {
        return this.jIR;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(rJ)) {
                gVar.cDf().n(SM.COOKIE, rJ);
            } else {
                gVar.cDf().n(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cDf().n("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rK)) {
                gVar.cDf().n("User-Agent", rK);
            }
            if (z) {
                gVar.cDf().n(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cDf().n(Headers.ACCEPT_ENCODING, "");
            }
            if (rL) {
                gVar.cDf().n(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cDf().n(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cDf().n("client_logid", String.valueOf(this.rR));
            if (!TextUtils.isEmpty(rM)) {
                gVar.cDf().n("cuid", rM);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
