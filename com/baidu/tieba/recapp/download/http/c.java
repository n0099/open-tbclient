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
    private static String Ag;
    private static String Ah;
    private static String Ai;
    private static boolean Aj;
    private static String Ak;
    private long An;
    private g gkm;
    private d gkn;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.An = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        Ah = str;
    }

    public static void setUid(String str) {
        Ai = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gkm = new g();
        a(this.gkm, z);
        this.gkm.boy().setUrl(str);
        this.gkn = new d(this.gkm);
        this.gkn.d(i, i3, i4);
        return this.gkm.boz();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gkm = new g();
        a(this.gkm, z);
        this.gkm.boy().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gkm.boy().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gkm.boy().q(next.getName(), next.getValue());
            }
        }
        this.gkn = new d(this.gkm);
        this.gkn.f(i, i2, -1);
        return this.gkm.boz();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gkm = new g();
        b(this.gkm);
        this.gkm.boy().setUrl(str);
        this.gkn = new d(this.gkm);
        return this.gkn.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gkn != null) {
            this.gkn.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gkn != null) {
            return this.gkn.isCancel();
        }
        return false;
    }

    public void hP() {
        if (this.gkn != null) {
            this.gkn.hP();
        }
    }

    public g box() {
        return this.gkm;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Ag)) {
                gVar.boy().q(SM.COOKIE, Ag);
            } else {
                gVar.boy().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Ai)) {
                gVar.boy().q("client_user_token", Ai);
            }
            if (!TextUtils.isEmpty(Ah)) {
                gVar.boy().q(HTTP.USER_AGENT, Ah);
            }
            if (z) {
                gVar.boy().q("Accept-Encoding", "gzip");
            } else {
                gVar.boy().q("Accept-Encoding", "");
            }
            if (Aj) {
                gVar.boy().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.boy().q(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            gVar.boy().q("client_logid", String.valueOf(this.An));
            if (!TextUtils.isEmpty(Ak)) {
                gVar.boy().q("cuid", Ak);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
