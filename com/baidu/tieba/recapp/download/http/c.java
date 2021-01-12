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
    private static String MX;
    private static String MY;
    private static boolean MZ;
    private static String Na;
    private static String sUid;
    private long Ng;
    private g mJu;
    private d mJv;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Ng = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bM(String str) {
        MX = str;
    }

    public static void setUserAgent(String str) {
        MY = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mJu = new g();
        a(this.mJu, z);
        this.mJu.dBt().setUrl(str);
        this.mJv = new d(this.mJu);
        this.mJv.d(i, i3, i4);
        return this.mJu.dBu();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mJu = new g();
        a(this.mJu, z);
        this.mJu.dBt().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mJu.dBt().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mJu.dBt().u(next.getName(), next.getValue());
            }
        }
        this.mJv = new d(this.mJu);
        this.mJv.f(i, i2, -1);
        return this.mJu.dBu();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mJu = new g();
        b(this.mJu);
        this.mJu.dBt().setUrl(str);
        this.mJv = new d(this.mJu);
        return this.mJv.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mJv != null) {
            this.mJv.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mJv != null) {
            return this.mJv.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mJv != null) {
            this.mJv.setCancel();
        }
    }

    public g dBs() {
        return this.mJu;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(MX)) {
                gVar.dBt().u(SM.COOKIE, MX);
            } else {
                gVar.dBt().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dBt().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(MY)) {
                gVar.dBt().u("User-Agent", MY);
            }
            if (z) {
                gVar.dBt().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dBt().u(Headers.ACCEPT_ENCODING, "");
            }
            if (MZ) {
                gVar.dBt().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dBt().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dBt().u("client_logid", String.valueOf(this.Ng));
            if (!TextUtils.isEmpty(Na)) {
                gVar.dBt().u("cuid", Na);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
