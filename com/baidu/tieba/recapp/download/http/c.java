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
    private g ihV;
    private d ihW;

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
        this.ihV = new g();
        a(this.ihV, z);
        this.ihV.bWZ().setUrl(str);
        this.ihW = new d(this.ihV);
        this.ihW.e(i, i3, i4);
        return this.ihV.bXa();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ihV = new g();
        a(this.ihV, z);
        this.ihV.bWZ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ihV.bWZ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ihV.bWZ().y(next.getName(), next.getValue());
            }
        }
        this.ihW = new d(this.ihV);
        this.ihW.g(i, i2, -1);
        return this.ihV.bXa();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.ihV = new g();
        b(this.ihV);
        this.ihV.bWZ().setUrl(str);
        this.ihW = new d(this.ihV);
        return this.ihW.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.ihW != null) {
            this.ihW.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ihW != null) {
            return this.ihW.jk();
        }
        return false;
    }

    public void jl() {
        if (this.ihW != null) {
            this.ihW.jl();
        }
    }

    public g bWY() {
        return this.ihV;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Dh)) {
                gVar.bWZ().y("Cookie", Dh);
            } else {
                gVar.bWZ().y("Cookie", "");
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.bWZ().y("client_user_token", Dj);
            }
            if (!TextUtils.isEmpty(Di)) {
                gVar.bWZ().y("User-Agent", Di);
            }
            if (z) {
                gVar.bWZ().y("Accept-Encoding", "gzip");
            } else {
                gVar.bWZ().y("Accept-Encoding", "");
            }
            if (Dk) {
                gVar.bWZ().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bWZ().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bWZ().y("client_logid", String.valueOf(this.Dq));
            if (!TextUtils.isEmpty(Dl)) {
                gVar.bWZ().y("cuid", Dl);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
