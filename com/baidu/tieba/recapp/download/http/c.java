package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    private static String Dh;
    private static String Di;
    private static String Dj;
    private static boolean Dk;
    private static String Dl;
    private long Dq;
    private g iib;
    private d iic;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Dq = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        Dh = str;
    }

    public static void setUserAgent(String str) {
        Di = str;
    }

    public static void setUid(String str) {
        Dj = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iib = new g();
        a(this.iib, z);
        this.iib.bWX().setUrl(str);
        this.iic = new d(this.iib);
        this.iic.e(i, i3, i4);
        return this.iib.bWY();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iib = new g();
        a(this.iib, z);
        this.iib.bWX().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iib.bWX().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iib.bWX().y(next.getName(), next.getValue());
            }
        }
        this.iic = new d(this.iib);
        this.iic.g(i, i2, -1);
        return this.iib.bWY();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iib = new g();
        b(this.iib);
        this.iib.bWX().setUrl(str);
        this.iic = new d(this.iib);
        return this.iic.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iic != null) {
            this.iic.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iic != null) {
            return this.iic.jk();
        }
        return false;
    }

    public void jl() {
        if (this.iic != null) {
            this.iic.jl();
        }
    }

    public g bWW() {
        return this.iib;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Dh)) {
                gVar.bWX().y("Cookie", Dh);
            } else {
                gVar.bWX().y("Cookie", "");
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.bWX().y("client_user_token", Dj);
            }
            if (!TextUtils.isEmpty(Di)) {
                gVar.bWX().y("User-Agent", Di);
            }
            if (z) {
                gVar.bWX().y("Accept-Encoding", "gzip");
            } else {
                gVar.bWX().y("Accept-Encoding", "");
            }
            if (Dk) {
                gVar.bWX().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bWX().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bWX().y("client_logid", String.valueOf(this.Dq));
            if (!TextUtils.isEmpty(Dl)) {
                gVar.bWX().y("cuid", Dl);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
