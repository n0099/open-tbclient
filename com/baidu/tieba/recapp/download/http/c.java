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
    private g ihI;
    private d ihJ;

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
        this.ihI = new g();
        a(this.ihI, z);
        this.ihI.bWV().setUrl(str);
        this.ihJ = new d(this.ihI);
        this.ihJ.e(i, i3, i4);
        return this.ihI.bWW();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ihI = new g();
        a(this.ihI, z);
        this.ihI.bWV().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ihI.bWV().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ihI.bWV().y(next.getName(), next.getValue());
            }
        }
        this.ihJ = new d(this.ihI);
        this.ihJ.g(i, i2, -1);
        return this.ihI.bWW();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.ihI = new g();
        b(this.ihI);
        this.ihI.bWV().setUrl(str);
        this.ihJ = new d(this.ihI);
        return this.ihJ.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.ihJ != null) {
            this.ihJ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ihJ != null) {
            return this.ihJ.jk();
        }
        return false;
    }

    public void jl() {
        if (this.ihJ != null) {
            this.ihJ.jl();
        }
    }

    public g bWU() {
        return this.ihI;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Dh)) {
                gVar.bWV().y("Cookie", Dh);
            } else {
                gVar.bWV().y("Cookie", "");
            }
            if (!TextUtils.isEmpty(Dj)) {
                gVar.bWV().y("client_user_token", Dj);
            }
            if (!TextUtils.isEmpty(Di)) {
                gVar.bWV().y("User-Agent", Di);
            }
            if (z) {
                gVar.bWV().y("Accept-Encoding", "gzip");
            } else {
                gVar.bWV().y("Accept-Encoding", "");
            }
            if (Dk) {
                gVar.bWV().y(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bWV().y(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.bWV().y("client_logid", String.valueOf(this.Dq));
            if (!TextUtils.isEmpty(Dl)) {
                gVar.bWV().y("cuid", Dl);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
