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
    private g iia;
    private d iib;

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
        this.iia = new g();
        a(this.iia, z);
        this.iia.bWW().setUrl(str);
        this.iib = new d(this.iia);
        this.iib.e(i, i3, i4);
        return this.iia.bWX();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iia = new g();
        a(this.iia, z);
        this.iia.bWW().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iia.bWW().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iia.bWW().y(next.getName(), next.getValue());
            }
        }
        this.iib = new d(this.iia);
        this.iib.g(i, i2, -1);
        return this.iia.bWX();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iia = new g();
        b(this.iia);
        this.iia.bWW().setUrl(str);
        this.iib = new d(this.iia);
        return this.iib.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iib != null) {
            this.iib.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iib != null) {
            return this.iib.jk();
        }
        return false;
    }

    public void jl() {
        if (this.iib != null) {
            this.iib.jl();
        }
    }

    public g bWV() {
        return this.iia;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Dh)) {
                gVar.bWW().y("Cookie", Dh);
            } else {
                gVar.bWW().y("Cookie", "");
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.bWW().y("client_user_token", Dj);
            }
            if (!TextUtils.isEmpty(Di)) {
                gVar.bWW().y("User-Agent", Di);
            }
            if (z) {
                gVar.bWW().y("Accept-Encoding", "gzip");
            } else {
                gVar.bWW().y("Accept-Encoding", "");
            }
            if (Dk) {
                gVar.bWW().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bWW().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bWW().y("client_logid", String.valueOf(this.Dq));
            if (!TextUtils.isEmpty(Dl)) {
                gVar.bWW().y("cuid", Dl);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
