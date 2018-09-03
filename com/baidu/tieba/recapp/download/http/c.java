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
    private static String Ab;
    private static boolean Ac;
    private static String Ae;
    private static String zZ;
    private long Aj;
    private g gpq;
    private d gpr;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Aj = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        Aa = str;
    }

    public static void setUid(String str) {
        Ab = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gpq = new g();
        a(this.gpq, z);
        this.gpq.bnE().setUrl(str);
        this.gpr = new d(this.gpq);
        this.gpr.d(i, i3, i4);
        return this.gpq.bnF();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gpq = new g();
        a(this.gpq, z);
        this.gpq.bnE().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gpq.bnE().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gpq.bnE().p(next.getName(), next.getValue());
            }
        }
        this.gpr = new d(this.gpq);
        this.gpr.f(i, i2, -1);
        return this.gpq.bnF();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gpq = new g();
        b(this.gpq);
        this.gpq.bnE().setUrl(str);
        this.gpr = new d(this.gpq);
        return this.gpr.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gpr != null) {
            this.gpr.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gpr != null) {
            return this.gpr.hP();
        }
        return false;
    }

    public void hQ() {
        if (this.gpr != null) {
            this.gpr.hQ();
        }
    }

    public g bnD() {
        return this.gpq;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(zZ)) {
                gVar.bnE().p(SM.COOKIE, zZ);
            } else {
                gVar.bnE().p(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Ab)) {
                gVar.bnE().p("client_user_token", Ab);
            }
            if (!TextUtils.isEmpty(Aa)) {
                gVar.bnE().p(HTTP.USER_AGENT, Aa);
            }
            if (z) {
                gVar.bnE().p("Accept-Encoding", "gzip");
            } else {
                gVar.bnE().p("Accept-Encoding", "");
            }
            if (Ac) {
                gVar.bnE().p(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bnE().p(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            gVar.bnE().p("client_logid", String.valueOf(this.Aj));
            if (!TextUtils.isEmpty(Ae)) {
                gVar.bnE().p("cuid", Ae);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
