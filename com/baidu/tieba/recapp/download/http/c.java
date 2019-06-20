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
    private static String AP;
    private static String AQ;
    private static String AR;
    private static boolean AT;
    private static String AU;
    private long AZ;
    private g iAx;
    private d iAy;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.AZ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aB(String str) {
        AP = str;
    }

    public static void setUserAgent(String str) {
        AQ = str;
    }

    public static void setUid(String str) {
        AR = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iAx = new g();
        a(this.iAx, z);
        this.iAx.cfc().setUrl(str);
        this.iAy = new d(this.iAx);
        this.iAy.d(i, i3, i4);
        return this.iAx.cfd();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iAx = new g();
        a(this.iAx, z);
        this.iAx.cfc().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iAx.cfc().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iAx.cfc().q(next.getName(), next.getValue());
            }
        }
        this.iAy = new d(this.iAx);
        this.iAy.f(i, i2, -1);
        return this.iAx.cfd();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iAx = new g();
        b(this.iAx);
        this.iAx.cfc().setUrl(str);
        this.iAy = new d(this.iAx);
        return this.iAy.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iAy != null) {
            this.iAy.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iAy != null) {
            return this.iAy.ic();
        }
        return false;
    }

    public void ie() {
        if (this.iAy != null) {
            this.iAy.ie();
        }
    }

    public g cfb() {
        return this.iAx;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(AP)) {
                gVar.cfc().q("Cookie", AP);
            } else {
                gVar.cfc().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(AR)) {
                gVar.cfc().q("client_user_token", AR);
            }
            if (!TextUtils.isEmpty(AQ)) {
                gVar.cfc().q("User-Agent", AQ);
            }
            if (z) {
                gVar.cfc().q("Accept-Encoding", "gzip");
            } else {
                gVar.cfc().q("Accept-Encoding", "");
            }
            if (AT) {
                gVar.cfc().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cfc().q(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cfc().q("client_logid", String.valueOf(this.AZ));
            if (!TextUtils.isEmpty(AU)) {
                gVar.cfc().q("cuid", AU);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
