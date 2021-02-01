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
    private g mSC;
    private d mSD;

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
        this.mSC = new g();
        a(this.mSC, z);
        this.mSC.dDC().setUrl(str);
        this.mSD = new d(this.mSC);
        this.mSD.d(i, i3, i4);
        return this.mSC.dDD();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mSC = new g();
        a(this.mSC, z);
        this.mSC.dDC().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mSC.dDC().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mSC.dDC().s(next.getName(), next.getValue());
            }
        }
        this.mSD = new d(this.mSC);
        this.mSD.f(i, i2, -1);
        return this.mSC.dDD();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mSC = new g();
        b(this.mSC);
        this.mSC.dDC().setUrl(str);
        this.mSD = new d(this.mSC);
        return this.mSD.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mSD != null) {
            this.mSD.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mSD != null) {
            return this.mSD.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mSD != null) {
            this.mSD.setCancel();
        }
    }

    public g dDB() {
        return this.mSC;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MV)) {
                gVar.dDC().s(SM.COOKIE, MV);
            } else {
                gVar.dDC().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dDC().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MW)) {
                gVar.dDC().s("User-Agent", MW);
            }
            if (z) {
                gVar.dDC().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dDC().s(Headers.ACCEPT_ENCODING, "");
            }
            if (MX) {
                gVar.dDC().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dDC().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dDC().s("client_logid", String.valueOf(this.Ne));
            if (!TextUtils.isEmpty(MY)) {
                gVar.dDC().s("cuid", MY);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
