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
/* loaded from: classes8.dex */
public class c {
    private static String MZ;
    private static String Na;
    private static boolean Nb;
    private static String Nc;
    private static String sUid;
    private long Ni;
    private g mNZ;
    private d mOa;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ni = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bM(String str) {
        MZ = str;
    }

    public static void setUserAgent(String str) {
        Na = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mNZ = new g();
        a(this.mNZ, z);
        this.mNZ.dFk().setUrl(str);
        this.mOa = new d(this.mNZ);
        this.mOa.d(i, i3, i4);
        return this.mNZ.dFl();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mNZ = new g();
        a(this.mNZ, z);
        this.mNZ.dFk().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mNZ.dFk().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mNZ.dFk().u(next.getName(), next.getValue());
            }
        }
        this.mOa = new d(this.mNZ);
        this.mOa.f(i, i2, -1);
        return this.mNZ.dFl();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mNZ = new g();
        b(this.mNZ);
        this.mNZ.dFk().setUrl(str);
        this.mOa = new d(this.mNZ);
        return this.mOa.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mOa != null) {
            this.mOa.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mOa != null) {
            return this.mOa.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mOa != null) {
            this.mOa.setCancel();
        }
    }

    public g dFj() {
        return this.mNZ;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MZ)) {
                gVar.dFk().u(SM.COOKIE, MZ);
            } else {
                gVar.dFk().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dFk().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Na)) {
                gVar.dFk().u("User-Agent", Na);
            }
            if (z) {
                gVar.dFk().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dFk().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Nb) {
                gVar.dFk().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dFk().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dFk().u("client_logid", String.valueOf(this.Ni));
            if (!TextUtils.isEmpty(Nc)) {
                gVar.dFk().u("cuid", Nc);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
