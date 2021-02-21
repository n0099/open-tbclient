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
    private static String MV;
    private static String MW;
    private static boolean MX;
    private static String MY;
    private static String sUid;
    private long Ne;
    private g mTd;
    private d mTe;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ne = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bM(String str) {
        MV = str;
    }

    public static void setUserAgent(String str) {
        MW = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mTd = new g();
        a(this.mTd, z);
        this.mTd.dDK().setUrl(str);
        this.mTe = new d(this.mTd);
        this.mTe.d(i, i3, i4);
        return this.mTd.dDL();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mTd = new g();
        a(this.mTd, z);
        this.mTd.dDK().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mTd.dDK().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mTd.dDK().s(next.getName(), next.getValue());
            }
        }
        this.mTe = new d(this.mTd);
        this.mTe.f(i, i2, -1);
        return this.mTd.dDL();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mTd = new g();
        b(this.mTd);
        this.mTd.dDK().setUrl(str);
        this.mTe = new d(this.mTd);
        return this.mTe.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mTe != null) {
            this.mTe.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mTe != null) {
            return this.mTe.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mTe != null) {
            this.mTe.setCancel();
        }
    }

    public g dDJ() {
        return this.mTd;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MV)) {
                gVar.dDK().s(SM.COOKIE, MV);
            } else {
                gVar.dDK().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dDK().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MW)) {
                gVar.dDK().s("User-Agent", MW);
            }
            if (z) {
                gVar.dDK().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dDK().s(Headers.ACCEPT_ENCODING, "");
            }
            if (MX) {
                gVar.dDK().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dDK().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dDK().s("client_logid", String.valueOf(this.Ne));
            if (!TextUtils.isEmpty(MY)) {
                gVar.dDK().s("cuid", MY);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
