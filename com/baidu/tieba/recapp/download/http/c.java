package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidubce.http.Headers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes20.dex */
public class c {
    private static String Mc;
    private static String Md;
    private static boolean Me;
    private static String Mf;
    private static String sUid;
    private long Ml;
    private g lDG;
    private d lDH;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ml = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bN(String str) {
        Mc = str;
    }

    public static void setUserAgent(String str) {
        Md = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lDG = new g();
        a(this.lDG, z);
        this.lDG.dnA().setUrl(str);
        this.lDH = new d(this.lDG);
        this.lDH.d(i, i3, i4);
        return this.lDG.dnB();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lDG = new g();
        a(this.lDG, z);
        this.lDG.dnA().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.lDG.dnA().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lDG.dnA().u(next.getName(), next.getValue());
            }
        }
        this.lDH = new d(this.lDG);
        this.lDH.f(i, i2, -1);
        return this.lDG.dnB();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.lDG = new g();
        b(this.lDG);
        this.lDG.dnA().setUrl(str);
        this.lDH = new d(this.lDG);
        return this.lDH.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.lDH != null) {
            this.lDH.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.lDH != null) {
            return this.lDH.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.lDH != null) {
            this.lDH.setCancel();
        }
    }

    public g dnz() {
        return this.lDG;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Mc)) {
                gVar.dnA().u(SM.COOKIE, Mc);
            } else {
                gVar.dnA().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dnA().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Md)) {
                gVar.dnA().u("User-Agent", Md);
            }
            if (z) {
                gVar.dnA().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dnA().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Me) {
                gVar.dnA().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dnA().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dnA().u("client_logid", String.valueOf(this.Ml));
            if (!TextUtils.isEmpty(Mf)) {
                gVar.dnA().u("cuid", Mf);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
