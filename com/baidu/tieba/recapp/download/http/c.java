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
    private g gFK;
    private d gFL;

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
        this.gFK = new g();
        a(this.gFK, z);
        this.gFK.bsW().setUrl(str);
        this.gFL = new d(this.gFK);
        this.gFL.e(i, i3, i4);
        return this.gFK.bsX();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gFK = new g();
        a(this.gFK, z);
        this.gFK.bsW().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gFK.bsW().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gFK.bsW().y(next.getName(), next.getValue());
            }
        }
        this.gFL = new d(this.gFK);
        this.gFL.g(i, i2, -1);
        return this.gFK.bsX();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gFK = new g();
        b(this.gFK);
        this.gFK.bsW().setUrl(str);
        this.gFL = new d(this.gFK);
        return this.gFL.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gFL != null) {
            this.gFL.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gFL != null) {
            return this.gFL.ji();
        }
        return false;
    }

    public void jj() {
        if (this.gFL != null) {
            this.gFL.jj();
        }
    }

    public g bsV() {
        return this.gFK;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Di)) {
                gVar.bsW().y(SM.COOKIE, Di);
            } else {
                gVar.bsW().y(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Dk)) {
                gVar.bsW().y("client_user_token", Dk);
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.bsW().y(HTTP.USER_AGENT, Dj);
            }
            if (z) {
                gVar.bsW().y("Accept-Encoding", "gzip");
            } else {
                gVar.bsW().y("Accept-Encoding", "");
            }
            if (Dl) {
                gVar.bsW().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bsW().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bsW().y("client_logid", String.valueOf(this.Dr));
            if (!TextUtils.isEmpty(Dm)) {
                gVar.bsW().y("cuid", Dm);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
