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
    private g lDv;
    private d lDw;

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
        this.lDv = new g();
        a(this.lDv, z);
        this.lDv.dnx().setUrl(str);
        this.lDw = new d(this.lDv);
        this.lDw.d(i, i3, i4);
        return this.lDv.dny();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lDv = new g();
        a(this.lDv, z);
        this.lDv.dnx().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.lDv.dnx().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lDv.dnx().u(next.getName(), next.getValue());
            }
        }
        this.lDw = new d(this.lDv);
        this.lDw.f(i, i2, -1);
        return this.lDv.dny();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.lDv = new g();
        b(this.lDv);
        this.lDv.dnx().setUrl(str);
        this.lDw = new d(this.lDv);
        return this.lDw.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.lDw != null) {
            this.lDw.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.lDw != null) {
            return this.lDw.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.lDw != null) {
            this.lDw.setCancel();
        }
    }

    public g dnw() {
        return this.lDv;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Mc)) {
                gVar.dnx().u(SM.COOKIE, Mc);
            } else {
                gVar.dnx().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dnx().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Md)) {
                gVar.dnx().u("User-Agent", Md);
            }
            if (z) {
                gVar.dnx().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dnx().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Me) {
                gVar.dnx().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dnx().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dnx().u("client_logid", String.valueOf(this.Ml));
            if (!TextUtils.isEmpty(Mf)) {
                gVar.dnx().u("cuid", Mf);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
