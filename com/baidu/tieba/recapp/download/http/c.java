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
/* loaded from: classes10.dex */
public class c {
    private static String rI;
    private static String rJ;
    private static boolean rK;
    private static String rL;
    private static String sUid;
    private g jCG;
    private d jCH;
    private long rQ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.rQ = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void au(String str) {
        rI = str;
    }

    public static void setUserAgent(String str) {
        rJ = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jCG = new g();
        a(this.jCG, z);
        this.jCG.cAd().setUrl(str);
        this.jCH = new d(this.jCG);
        this.jCH.c(i, i3, i4);
        return this.jCG.cAe();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jCG = new g();
        a(this.jCG, z);
        this.jCG.cAd().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.jCG.cAd().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.jCG.cAd().m(next.getName(), next.getValue());
            }
        }
        this.jCH = new d(this.jCG);
        this.jCH.e(i, i2, -1);
        return this.jCG.cAe();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.jCG = new g();
        b(this.jCG);
        this.jCG.cAd().setUrl(str);
        this.jCH = new d(this.jCG);
        return this.jCH.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.jCH != null) {
            this.jCH.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.jCH != null) {
            return this.jCH.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.jCH != null) {
            this.jCH.setCancel();
        }
    }

    public g cAc() {
        return this.jCG;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(rI)) {
                gVar.cAd().m(SM.COOKIE, rI);
            } else {
                gVar.cAd().m(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cAd().m("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rJ)) {
                gVar.cAd().m("User-Agent", rJ);
            }
            if (z) {
                gVar.cAd().m(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cAd().m(Headers.ACCEPT_ENCODING, "");
            }
            if (rK) {
                gVar.cAd().m(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cAd().m(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cAd().m("client_logid", String.valueOf(this.rQ));
            if (!TextUtils.isEmpty(rL)) {
                gVar.cAd().m("cuid", rL);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
