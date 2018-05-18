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
    private static String ub;
    private static String uc;
    private static String ud;
    private static boolean ue;
    private static String uf;
    private g fYU;
    private d fYV;
    private long ui;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.ui = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        uc = str;
    }

    public static void setUid(String str) {
        ud = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.fYU = new g();
        a(this.fYU, z);
        this.fYU.bjz().setUrl(str);
        this.fYV = new d(this.fYU);
        this.fYV.d(i, i3, i4);
        return this.fYU.bjA();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.fYU = new g();
        a(this.fYU, z);
        this.fYU.bjz().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.fYU.bjz().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.fYU.bjz().o(next.getName(), next.getValue());
            }
        }
        this.fYV = new d(this.fYU);
        this.fYV.f(i, i2, -1);
        return this.fYU.bjA();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.fYU = new g();
        b(this.fYU);
        this.fYU.bjz().setUrl(str);
        this.fYV = new d(this.fYU);
        return this.fYV.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.fYV != null) {
            this.fYV.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.fYV != null) {
            return this.fYV.isCancel();
        }
        return false;
    }

    public void eY() {
        if (this.fYV != null) {
            this.fYV.eY();
        }
    }

    public g bjy() {
        return this.fYU;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(ub)) {
                gVar.bjz().o(SM.COOKIE, ub);
            } else {
                gVar.bjz().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ud)) {
                gVar.bjz().o("client_user_token", ud);
            }
            if (!TextUtils.isEmpty(uc)) {
                gVar.bjz().o(HTTP.USER_AGENT, uc);
            }
            if (z) {
                gVar.bjz().o("Accept-Encoding", "gzip");
            } else {
                gVar.bjz().o("Accept-Encoding", "");
            }
            if (ue) {
                gVar.bjz().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bjz().o(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bjz().o("client_logid", String.valueOf(this.ui));
            if (!TextUtils.isEmpty(uf)) {
                gVar.bjz().o("cuid", uf);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
