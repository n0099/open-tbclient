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
/* loaded from: classes13.dex */
public class c {
    private static String KH;
    private static String KI;
    private static boolean KJ;
    private static String KK;
    private static String sUid;
    private long KP;
    private g ksD;
    private d ksE;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.KP = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bJ(String str) {
        KH = str;
    }

    public static void setUserAgent(String str) {
        KI = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ksD = new g();
        a(this.ksD, z);
        this.ksD.cND().setUrl(str);
        this.ksE = new d(this.ksD);
        this.ksE.d(i, i3, i4);
        return this.ksD.cNE();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ksD = new g();
        a(this.ksD, z);
        this.ksD.cND().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ksD.cND().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ksD.cND().s(next.getName(), next.getValue());
            }
        }
        this.ksE = new d(this.ksD);
        this.ksE.f(i, i2, -1);
        return this.ksD.cNE();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.ksD = new g();
        b(this.ksD);
        this.ksD.cND().setUrl(str);
        this.ksE = new d(this.ksD);
        return this.ksE.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.ksE != null) {
            this.ksE.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ksE != null) {
            return this.ksE.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.ksE != null) {
            this.ksE.setCancel();
        }
    }

    public g cNC() {
        return this.ksD;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(KH)) {
                gVar.cND().s(SM.COOKIE, KH);
            } else {
                gVar.cND().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cND().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KI)) {
                gVar.cND().s("User-Agent", KI);
            }
            if (z) {
                gVar.cND().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cND().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KJ) {
                gVar.cND().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cND().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cND().s("client_logid", String.valueOf(this.KP));
            if (!TextUtils.isEmpty(KK)) {
                gVar.cND().s("cuid", KK);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
