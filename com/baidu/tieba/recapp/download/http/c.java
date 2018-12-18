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
    private static String Di;
    private static String Dj;
    private static String Dk;
    private static boolean Dl;
    private static String Dm;
    private long Dr;
    private g gMA;
    private d gMB;

    public void init() {
        System.setProperty("http.keepAlive", ABTestConstants.PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE);
        this.Dr = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        Di = str;
    }

    public static void setUserAgent(String str) {
        Dj = str;
    }

    public static void setUid(String str) {
        Dk = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gMA = new g();
        a(this.gMA, z);
        this.gMA.buO().setUrl(str);
        this.gMB = new d(this.gMA);
        this.gMB.e(i, i3, i4);
        return this.gMA.buP();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gMA = new g();
        a(this.gMA, z);
        this.gMA.buO().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gMA.buO().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gMA.buO().y(next.getName(), next.getValue());
            }
        }
        this.gMB = new d(this.gMA);
        this.gMB.g(i, i2, -1);
        return this.gMA.buP();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gMA = new g();
        b(this.gMA);
        this.gMA.buO().setUrl(str);
        this.gMB = new d(this.gMA);
        return this.gMB.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gMB != null) {
            this.gMB.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gMB != null) {
            return this.gMB.ji();
        }
        return false;
    }

    public void jj() {
        if (this.gMB != null) {
            this.gMB.jj();
        }
    }

    public g buN() {
        return this.gMA;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Di)) {
                gVar.buO().y(SM.COOKIE, Di);
            } else {
                gVar.buO().y(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Dk)) {
                gVar.buO().y("client_user_token", Dk);
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.buO().y(HTTP.USER_AGENT, Dj);
            }
            if (z) {
                gVar.buO().y("Accept-Encoding", "gzip");
            } else {
                gVar.buO().y("Accept-Encoding", "");
            }
            if (Dl) {
                gVar.buO().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.buO().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.buO().y("client_logid", String.valueOf(this.Dr));
            if (!TextUtils.isEmpty(Dm)) {
                gVar.buO().y("cuid", Dm);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
