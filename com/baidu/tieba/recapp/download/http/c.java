package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.webkit.internal.ABTestConstants;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    private static String De;
    private static String Df;
    private static String Dg;
    private static boolean Dh;
    private static String Di;
    private long Dn;
    private g gEj;
    private d gEk;

    public void init() {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        this.Dn = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        De = str;
    }

    public static void setUserAgent(String str) {
        Df = str;
    }

    public static void setUid(String str) {
        Dg = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gEj = new g();
        a(this.gEj, z);
        this.gEj.btA().setUrl(str);
        this.gEk = new d(this.gEj);
        this.gEk.e(i, i3, i4);
        return this.gEj.btB();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gEj = new g();
        a(this.gEj, z);
        this.gEj.btA().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gEj.btA().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gEj.btA().y(next.getName(), next.getValue());
            }
        }
        this.gEk = new d(this.gEj);
        this.gEk.g(i, i2, -1);
        return this.gEj.btB();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gEj = new g();
        b(this.gEj);
        this.gEj.btA().setUrl(str);
        this.gEk = new d(this.gEj);
        return this.gEk.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gEk != null) {
            this.gEk.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gEk != null) {
            return this.gEk.jk();
        }
        return false;
    }

    public void jl() {
        if (this.gEk != null) {
            this.gEk.jl();
        }
    }

    public g btz() {
        return this.gEj;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(De)) {
                gVar.btA().y(SM.COOKIE, De);
            } else {
                gVar.btA().y(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Dg)) {
                gVar.btA().y("client_user_token", Dg);
            }
            if (!TextUtils.isEmpty(Df)) {
                gVar.btA().y(HTTP.USER_AGENT, Df);
            }
            if (z) {
                gVar.btA().y("Accept-Encoding", "gzip");
            } else {
                gVar.btA().y("Accept-Encoding", "");
            }
            if (Dh) {
                gVar.btA().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.btA().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.btA().y("client_logid", String.valueOf(this.Dn));
            if (!TextUtils.isEmpty(Di)) {
                gVar.btA().y("cuid", Di);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
