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
    private g iAu;
    private d iAv;

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
        this.iAu = new g();
        a(this.iAu, z);
        this.iAu.ceZ().setUrl(str);
        this.iAv = new d(this.iAu);
        this.iAv.d(i, i3, i4);
        return this.iAu.cfa();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iAu = new g();
        a(this.iAu, z);
        this.iAu.ceZ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iAu.ceZ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iAu.ceZ().q(next.getName(), next.getValue());
            }
        }
        this.iAv = new d(this.iAu);
        this.iAv.f(i, i2, -1);
        return this.iAu.cfa();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iAu = new g();
        b(this.iAu);
        this.iAu.ceZ().setUrl(str);
        this.iAv = new d(this.iAu);
        return this.iAv.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iAv != null) {
            this.iAv.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iAv != null) {
            return this.iAv.ic();
        }
        return false;
    }

    public void ie() {
        if (this.iAv != null) {
            this.iAv.ie();
        }
    }

    public g ceY() {
        return this.iAu;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(AQ)) {
                gVar.ceZ().q("Cookie", AQ);
            } else {
                gVar.ceZ().q("Cookie", "");
            }
            if (!TextUtils.isEmpty(AT)) {
                gVar.ceZ().q("client_user_token", AT);
            }
            if (!TextUtils.isEmpty(AR)) {
                gVar.ceZ().q("User-Agent", AR);
            }
            if (z) {
                gVar.ceZ().q("Accept-Encoding", "gzip");
            } else {
                gVar.ceZ().q("Accept-Encoding", "");
            }
            if (AU) {
                gVar.ceZ().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.ceZ().q(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.ceZ().q("client_logid", String.valueOf(this.Ba));
            if (!TextUtils.isEmpty(AV)) {
                gVar.ceZ().q("cuid", AV);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
