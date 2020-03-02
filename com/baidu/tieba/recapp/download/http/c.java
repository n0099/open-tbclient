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
    private g jHg;
    private d jHh;
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
        this.jHg = new g();
        a(this.jHg, z);
        this.jHg.cCK().setUrl(str);
        this.jHh = new d(this.jHg);
        this.jHh.c(i, i3, i4);
        return this.jHg.cCL();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jHg = new g();
        a(this.jHg, z);
        this.jHg.cCK().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.jHg.cCK().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.jHg.cCK().n(next.getName(), next.getValue());
            }
        }
        this.jHh = new d(this.jHg);
        this.jHh.e(i, i2, -1);
        return this.jHg.cCL();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.jHg = new g();
        b(this.jHg);
        this.jHg.cCK().setUrl(str);
        this.jHh = new d(this.jHg);
        return this.jHh.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.jHh != null) {
            this.jHh.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.jHh != null) {
            return this.jHh.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.jHh != null) {
            this.jHh.setCancel();
        }
    }

    public g cCJ() {
        return this.jHg;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(rJ)) {
                gVar.cCK().n(SM.COOKIE, rJ);
            } else {
                gVar.cCK().n(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cCK().n("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rK)) {
                gVar.cCK().n("User-Agent", rK);
            }
            if (z) {
                gVar.cCK().n(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cCK().n(Headers.ACCEPT_ENCODING, "");
            }
            if (rL) {
                gVar.cCK().n(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cCK().n(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cCK().n("client_logid", String.valueOf(this.rR));
            if (!TextUtils.isEmpty(rM)) {
                gVar.cCK().n("cuid", rM);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
