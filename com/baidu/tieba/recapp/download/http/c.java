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
    private static String uc;
    private static String ud;
    private static String ue;
    private static boolean uf;
    private static String ug;
    private g fXO;
    private d fXP;
    private long uj;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.uj = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        ud = str;
    }

    public static void setUid(String str) {
        ue = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.fXO = new g();
        a(this.fXO, z);
        this.fXO.bjA().setUrl(str);
        this.fXP = new d(this.fXO);
        this.fXP.d(i, i3, i4);
        return this.fXO.bjB();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.fXO = new g();
        a(this.fXO, z);
        this.fXO.bjA().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.fXO.bjA().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.fXO.bjA().o(next.getName(), next.getValue());
            }
        }
        this.fXP = new d(this.fXO);
        this.fXP.f(i, i2, -1);
        return this.fXO.bjB();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.fXO = new g();
        b(this.fXO);
        this.fXO.bjA().setUrl(str);
        this.fXP = new d(this.fXO);
        return this.fXP.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.fXP != null) {
            this.fXP.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.fXP != null) {
            return this.fXP.isCancel();
        }
        return false;
    }

    public void eY() {
        if (this.fXP != null) {
            this.fXP.eY();
        }
    }

    public g bjz() {
        return this.fXO;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(uc)) {
                gVar.bjA().o(SM.COOKIE, uc);
            } else {
                gVar.bjA().o(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(ue)) {
                gVar.bjA().o("client_user_token", ue);
            }
            if (!TextUtils.isEmpty(ud)) {
                gVar.bjA().o(HTTP.USER_AGENT, ud);
            }
            if (z) {
                gVar.bjA().o("Accept-Encoding", "gzip");
            } else {
                gVar.bjA().o("Accept-Encoding", "");
            }
            if (uf) {
                gVar.bjA().o(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bjA().o(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bjA().o("client_logid", String.valueOf(this.uj));
            if (!TextUtils.isEmpty(ug)) {
                gVar.bjA().o("cuid", ug);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
