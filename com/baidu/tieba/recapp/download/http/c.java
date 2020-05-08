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
    private static String KK;
    private static String KL;
    private static boolean KM;
    private static String KN;
    private static String sUid;
    private long KS;
    private g ksH;
    private d ksI;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.KS = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bJ(String str) {
        KK = str;
    }

    public static void setUserAgent(String str) {
        KL = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ksH = new g();
        a(this.ksH, z);
        this.ksH.cNA().setUrl(str);
        this.ksI = new d(this.ksH);
        this.ksI.d(i, i3, i4);
        return this.ksH.cNB();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.ksH = new g();
        a(this.ksH, z);
        this.ksH.cNA().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.ksH.cNA().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.ksH.cNA().s(next.getName(), next.getValue());
            }
        }
        this.ksI = new d(this.ksH);
        this.ksI.f(i, i2, -1);
        return this.ksH.cNB();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.ksH = new g();
        b(this.ksH);
        this.ksH.cNA().setUrl(str);
        this.ksI = new d(this.ksH);
        return this.ksI.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.ksI != null) {
            this.ksI.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.ksI != null) {
            return this.ksI.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.ksI != null) {
            this.ksI.setCancel();
        }
    }

    public g cNz() {
        return this.ksH;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(KK)) {
                gVar.cNA().s(SM.COOKIE, KK);
            } else {
                gVar.cNA().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cNA().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KL)) {
                gVar.cNA().s("User-Agent", KL);
            }
            if (z) {
                gVar.cNA().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cNA().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KM) {
                gVar.cNA().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cNA().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cNA().s("client_logid", String.valueOf(this.KS));
            if (!TextUtils.isEmpty(KN)) {
                gVar.cNA().s("cuid", KN);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
