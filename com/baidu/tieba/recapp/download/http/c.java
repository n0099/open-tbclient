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
/* loaded from: classes7.dex */
public class c {
    private static String Ou;
    private static String Ov;
    private static boolean Ow;
    private static String Ox;
    private static String sUid;
    private long OD;
    private g mVk;
    private d mVl;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.OD = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bQ(String str) {
        Ou = str;
    }

    public static void setUserAgent(String str) {
        Ov = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mVk = new g();
        a(this.mVk, z);
        this.mVk.dDS().setUrl(str);
        this.mVl = new d(this.mVk);
        this.mVl.d(i, i3, i4);
        return this.mVk.dDT();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mVk = new g();
        a(this.mVk, z);
        this.mVk.dDS().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mVk.dDS().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mVk.dDS().s(next.getName(), next.getValue());
            }
        }
        this.mVl = new d(this.mVk);
        this.mVl.f(i, i2, -1);
        return this.mVk.dDT();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mVk = new g();
        b(this.mVk);
        this.mVk.dDS().setUrl(str);
        this.mVl = new d(this.mVk);
        return this.mVl.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mVl != null) {
            this.mVl.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mVl != null) {
            return this.mVl.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mVl != null) {
            this.mVl.setCancel();
        }
    }

    public g dDR() {
        return this.mVk;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Ou)) {
                gVar.dDS().s(SM.COOKIE, Ou);
            } else {
                gVar.dDS().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dDS().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Ov)) {
                gVar.dDS().s("User-Agent", Ov);
            }
            if (z) {
                gVar.dDS().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dDS().s(Headers.ACCEPT_ENCODING, "");
            }
            if (Ow) {
                gVar.dDS().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dDS().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dDS().s("client_logid", String.valueOf(this.OD));
            if (!TextUtils.isEmpty(Ox)) {
                gVar.dDS().s("cuid", Ox);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
