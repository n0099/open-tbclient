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
    private static String AQ;
    private static String AR;
    private static String AT;
    private static boolean AU;
    private static String AV;
    private long Ba;
    private g iAw;
    private d iAx;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ba = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aB(String str) {
        AQ = str;
    }

    public static void setUserAgent(String str) {
        AR = str;
    }

    public static void setUid(String str) {
        AT = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iAw = new g();
        a(this.iAw, z);
        this.iAw.cfb().setUrl(str);
        this.iAx = new d(this.iAw);
        this.iAx.d(i, i3, i4);
        return this.iAw.cfc();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iAw = new g();
        a(this.iAw, z);
        this.iAw.cfb().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iAw.cfb().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iAw.cfb().q(next.getName(), next.getValue());
            }
        }
        this.iAx = new d(this.iAw);
        this.iAx.f(i, i2, -1);
        return this.iAw.cfc();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iAw = new g();
        b(this.iAw);
        this.iAw.cfb().setUrl(str);
        this.iAx = new d(this.iAw);
        return this.iAx.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iAx != null) {
            this.iAx.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iAx != null) {
            return this.iAx.ic();
        }
        return false;
    }

    public void ie() {
        if (this.iAx != null) {
            this.iAx.ie();
        }
    }

    public g cfa() {
        return this.iAw;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(AQ)) {
                gVar.cfb().q("Cookie", AQ);
            } else {
                gVar.cfb().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(AT)) {
                gVar.cfb().q("client_user_token", AT);
            }
            if (!TextUtils.isEmpty(AR)) {
                gVar.cfb().q("User-Agent", AR);
            }
            if (z) {
                gVar.cfb().q("Accept-Encoding", "gzip");
            } else {
                gVar.cfb().q("Accept-Encoding", "");
            }
            if (AU) {
                gVar.cfb().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cfb().q(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cfb().q("client_logid", String.valueOf(this.Ba));
            if (!TextUtils.isEmpty(AV)) {
                gVar.cfb().q("cuid", AV);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
