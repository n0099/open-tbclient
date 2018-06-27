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
    private static String Ae;
    private static String Af;
    private static String Ag;
    private static boolean Ah;
    private static String Ai;
    private long An;
    private g god;
    private d goe;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.An = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void setUserAgent(String str) {
        Af = str;
    }

    public static void setUid(String str) {
        Ag = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.god = new g();
        a(this.god, z);
        this.god.boZ().setUrl(str);
        this.goe = new d(this.god);
        this.goe.d(i, i3, i4);
        return this.god.bpa();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.god = new g();
        a(this.god, z);
        this.god.boZ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.god.boZ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.god.boZ().q(next.getName(), next.getValue());
            }
        }
        this.goe = new d(this.god);
        this.goe.f(i, i2, -1);
        return this.god.bpa();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.god = new g();
        b(this.god);
        this.god.boZ().setUrl(str);
        this.goe = new d(this.god);
        return this.goe.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.goe != null) {
            this.goe.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.goe != null) {
            return this.goe.isCancel();
        }
        return false;
    }

    public void hP() {
        if (this.goe != null) {
            this.goe.hP();
        }
    }

    public g boY() {
        return this.god;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Ae)) {
                gVar.boZ().q(SM.COOKIE, Ae);
            } else {
                gVar.boZ().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Ag)) {
                gVar.boZ().q("client_user_token", Ag);
            }
            if (!TextUtils.isEmpty(Af)) {
                gVar.boZ().q(HTTP.USER_AGENT, Af);
            }
            if (z) {
                gVar.boZ().q("Accept-Encoding", "gzip");
            } else {
                gVar.boZ().q("Accept-Encoding", "");
            }
            if (Ah) {
                gVar.boZ().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.boZ().q(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            gVar.boZ().q("client_logid", String.valueOf(this.An));
            if (!TextUtils.isEmpty(Ai)) {
                gVar.boZ().q("cuid", Ai);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
