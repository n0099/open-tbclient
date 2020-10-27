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
    private g moq;
    private d mor;

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
        this.moq = new g();
        a(this.moq, z);
        this.moq.dyb().setUrl(str);
        this.mor = new d(this.moq);
        this.mor.d(i, i3, i4);
        return this.moq.dyc();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.moq = new g();
        a(this.moq, z);
        this.moq.dyb().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.moq.dyb().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.moq.dyb().u(next.getName(), next.getValue());
            }
        }
        this.mor = new d(this.moq);
        this.mor.f(i, i2, -1);
        return this.moq.dyc();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.moq = new g();
        b(this.moq);
        this.moq.dyb().setUrl(str);
        this.mor = new d(this.moq);
        return this.mor.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mor != null) {
            this.mor.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mor != null) {
            return this.mor.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mor != null) {
            this.mor.setCancel();
        }
    }

    public g dya() {
        return this.moq;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MF)) {
                gVar.dyb().u(SM.COOKIE, MF);
            } else {
                gVar.dyb().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dyb().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MG)) {
                gVar.dyb().u("User-Agent", MG);
            }
            if (z) {
                gVar.dyb().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dyb().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MH) {
                gVar.dyb().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dyb().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dyb().u("client_logid", String.valueOf(this.MQ));
            if (!TextUtils.isEmpty(MI)) {
                gVar.dyb().u("cuid", MI);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
