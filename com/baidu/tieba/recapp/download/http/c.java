package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    private static String Aa;
    private static boolean Ab;
    private static String Ac;
    private static String zY;
    private static String zZ;
    private long Ai;
    private g gpn;
    private d gpo;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ai = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        zZ = str;
    }

    public static void setUid(String str) {
        Aa = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gpn = new g();
        a(this.gpn, z);
        this.gpn.bnD().setUrl(str);
        this.gpo = new d(this.gpn);
        this.gpo.d(i, i3, i4);
        return this.gpn.bnE();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gpn = new g();
        a(this.gpn, z);
        this.gpn.bnD().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gpn.bnD().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gpn.bnD().p(next.getName(), next.getValue());
            }
        }
        this.gpo = new d(this.gpn);
        this.gpo.f(i, i2, -1);
        return this.gpn.bnE();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gpn = new g();
        b(this.gpn);
        this.gpn.bnD().setUrl(str);
        this.gpo = new d(this.gpn);
        return this.gpo.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gpo != null) {
            this.gpo.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gpo != null) {
            return this.gpo.hP();
        }
        return false;
    }

    public void hQ() {
        if (this.gpo != null) {
            this.gpo.hQ();
        }
    }

    public g bnC() {
        return this.gpn;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(zY)) {
                gVar.bnD().p(SM.COOKIE, zY);
            } else {
                gVar.bnD().p(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Aa)) {
                gVar.bnD().p("client_user_token", Aa);
            }
            if (!TextUtils.isEmpty(zZ)) {
                gVar.bnD().p(HTTP.USER_AGENT, zZ);
            }
            if (z) {
                gVar.bnD().p("Accept-Encoding", "gzip");
            } else {
                gVar.bnD().p("Accept-Encoding", "");
            }
            if (Ab) {
                gVar.bnD().p(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bnD().p(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            gVar.bnD().p("client_logid", String.valueOf(this.Ai));
            if (!TextUtils.isEmpty(Ac)) {
                gVar.bnD().p("cuid", Ac);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
