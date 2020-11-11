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
/* loaded from: classes26.dex */
public class c {
    private static String MF;
    private static String MG;
    private static boolean MH;
    private static String MI;
    private static String sUid;
    private long MQ;
    private g mun;
    private d muo;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.MQ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bP(String str) {
        MF = str;
    }

    public static void setUserAgent(String str) {
        MG = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mun = new g();
        a(this.mun, z);
        this.mun.dAD().setUrl(str);
        this.muo = new d(this.mun);
        this.muo.d(i, i3, i4);
        return this.mun.dAE();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mun = new g();
        a(this.mun, z);
        this.mun.dAD().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mun.dAD().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mun.dAD().u(next.getName(), next.getValue());
            }
        }
        this.muo = new d(this.mun);
        this.muo.f(i, i2, -1);
        return this.mun.dAE();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mun = new g();
        b(this.mun);
        this.mun.dAD().setUrl(str);
        this.muo = new d(this.mun);
        return this.muo.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.muo != null) {
            this.muo.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.muo != null) {
            return this.muo.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.muo != null) {
            this.muo.setCancel();
        }
    }

    public g dAC() {
        return this.mun;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MF)) {
                gVar.dAD().u(SM.COOKIE, MF);
            } else {
                gVar.dAD().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dAD().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MG)) {
                gVar.dAD().u("User-Agent", MG);
            }
            if (z) {
                gVar.dAD().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dAD().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MH) {
                gVar.dAD().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dAD().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dAD().u("client_logid", String.valueOf(this.MQ));
            if (!TextUtils.isEmpty(MI)) {
                gVar.dAD().u("cuid", MI);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
