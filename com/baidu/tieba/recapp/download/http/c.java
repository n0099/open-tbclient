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
    private static String Cu;
    private static String Cv;
    private static String Cw;
    private static boolean Cx;
    private static String Cy;
    private long CD;
    private g gwI;
    private d gwJ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.CD = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aR(String str) {
        Cu = str;
    }

    public static void setUserAgent(String str) {
        Cv = str;
    }

    public static void setUid(String str) {
        Cw = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gwI = new g();
        a(this.gwI, z);
        this.gwI.bql().setUrl(str);
        this.gwJ = new d(this.gwI);
        this.gwJ.e(i, i3, i4);
        return this.gwI.bqm();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.gwI = new g();
        a(this.gwI, z);
        this.gwI.bql().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.gwI.bql().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.gwI.bql().x(next.getName(), next.getValue());
            }
        }
        this.gwJ = new d(this.gwI);
        this.gwJ.g(i, i2, -1);
        return this.gwI.bqm();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.gwI = new g();
        b(this.gwI);
        this.gwI.bql().setUrl(str);
        this.gwJ = new d(this.gwI);
        return this.gwJ.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.gwJ != null) {
            this.gwJ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.gwJ != null) {
            return this.gwJ.iV();
        }
        return false;
    }

    public void iW() {
        if (this.gwJ != null) {
            this.gwJ.iW();
        }
    }

    public g bqk() {
        return this.gwI;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Cu)) {
                gVar.bql().x(SM.COOKIE, Cu);
            } else {
                gVar.bql().x(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(Cw)) {
                gVar.bql().x("client_user_token", Cw);
            }
            if (!TextUtils.isEmpty(Cv)) {
                gVar.bql().x(HTTP.USER_AGENT, Cv);
            }
            if (z) {
                gVar.bql().x("Accept-Encoding", "gzip");
            } else {
                gVar.bql().x("Accept-Encoding", "");
            }
            if (Cx) {
                gVar.bql().x(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.bql().x(HTTP.CONN_DIRECTIVE, IntentConfig.CLOSE);
            }
            gVar.bql().x("client_logid", String.valueOf(this.CD));
            if (!TextUtils.isEmpty(Cy)) {
                gVar.bql().x("cuid", Cy);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
