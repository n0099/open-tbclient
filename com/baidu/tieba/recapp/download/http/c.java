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
    private g mNY;
    private d mNZ;

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
        this.mNY = new g();
        a(this.mNY, z);
        this.mNY.dFl().setUrl(str);
        this.mNZ = new d(this.mNY);
        this.mNZ.d(i, i3, i4);
        return this.mNY.dFm();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mNY = new g();
        a(this.mNY, z);
        this.mNY.dFl().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mNY.dFl().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mNY.dFl().u(next.getName(), next.getValue());
            }
        }
        this.mNZ = new d(this.mNY);
        this.mNZ.f(i, i2, -1);
        return this.mNY.dFm();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mNY = new g();
        b(this.mNY);
        this.mNY.dFl().setUrl(str);
        this.mNZ = new d(this.mNY);
        return this.mNZ.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mNZ != null) {
            this.mNZ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mNZ != null) {
            return this.mNZ.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mNZ != null) {
            this.mNZ.setCancel();
        }
    }

    public g dFk() {
        return this.mNY;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MZ)) {
                gVar.dFl().u(SM.COOKIE, MZ);
            } else {
                gVar.dFl().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dFl().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Na)) {
                gVar.dFl().u("User-Agent", Na);
            }
            if (z) {
                gVar.dFl().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dFl().u(Headers.ACCEPT_ENCODING, "");
            }
            if (Nb) {
                gVar.dFl().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dFl().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dFl().u("client_logid", String.valueOf(this.Ni));
            if (!TextUtils.isEmpty(Nc)) {
                gVar.dFl().u("cuid", Nc);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
