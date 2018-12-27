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
    private g gPs;
    private d gPt;

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
        this.gPs = new g();
        a(this.gPs, z);
        this.gPs.bvA().setUrl(str);
        this.gPt = new d(this.gPs);
        this.gPt.e(i, i3, i4);
        return this.gPs.bvB();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gPs = new g();
        a(this.gPs, z);
        this.gPs.bvA().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gPs.bvA().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gPs.bvA().y(next.getName(), next.getValue());
            }
        }
        this.gPt = new d(this.gPs);
        this.gPt.g(i, i2, -1);
        return this.gPs.bvB();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gPs = new g();
        b(this.gPs);
        this.gPs.bvA().setUrl(str);
        this.gPt = new d(this.gPs);
        return this.gPt.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gPt != null) {
            this.gPt.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gPt != null) {
            return this.gPt.ji();
        }
        return false;
    }

    public void jj() {
        if (this.gPt != null) {
            this.gPt.jj();
        }
    }

    public g bvz() {
        return this.gPs;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Di)) {
                gVar.bvA().y(SM.COOKIE, Di);
            } else {
                gVar.bvA().y(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Dk)) {
                gVar.bvA().y("client_user_token", Dk);
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.bvA().y(HTTP.USER_AGENT, Dj);
            }
            if (z) {
                gVar.bvA().y("Accept-Encoding", "gzip");
            } else {
                gVar.bvA().y("Accept-Encoding", "");
            }
            if (Dl) {
                gVar.bvA().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bvA().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bvA().y("client_logid", String.valueOf(this.Dr));
            if (!TextUtils.isEmpty(Dm)) {
                gVar.bvA().y("cuid", Dm);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
