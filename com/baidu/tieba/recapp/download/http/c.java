package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    private static String pC;
    private static String pD;
    private static boolean pE;
    private static String pF;
    private static String sUid;
    private g iJg;
    private d iJh;
    private long pK;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.pK = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        pC = str;
    }

    public static void setUserAgent(String str) {
        pD = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iJg = new g();
        a(this.iJg, z);
        this.iJg.cgb().setUrl(str);
        this.iJh = new d(this.iJg);
        this.iJh.c(i, i3, i4);
        return this.iJg.cgc();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iJg = new g();
        a(this.iJg, z);
        this.iJg.cgb().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iJg.cgb().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iJg.cgb().l(next.getName(), next.getValue());
            }
        }
        this.iJh = new d(this.iJg);
        this.iJh.e(i, i2, -1);
        return this.iJg.cgc();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iJg = new g();
        b(this.iJg);
        this.iJg.cgb().setUrl(str);
        this.iJh = new d(this.iJg);
        return this.iJh.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iJh != null) {
            this.iJh.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iJh != null) {
            return this.iJh.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.iJh != null) {
            this.iJh.setCancel();
        }
    }

    public g cga() {
        return this.iJg;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(pC)) {
                gVar.cgb().l(SM.COOKIE, pC);
            } else {
                gVar.cgb().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cgb().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(pD)) {
                gVar.cgb().l(HTTP.USER_AGENT, pD);
            }
            if (z) {
                gVar.cgb().l("Accept-Encoding", "gzip");
            } else {
                gVar.cgb().l("Accept-Encoding", "");
            }
            if (pE) {
                gVar.cgb().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cgb().l(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cgb().l("client_logid", String.valueOf(this.pK));
            if (!TextUtils.isEmpty(pF)) {
                gVar.cgb().l("cuid", pF);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
