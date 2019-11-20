package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.cookie.SM;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class c {
    private static String oW;
    private static String oX;
    private static boolean oY;
    private static String oZ;
    private static String sUid;
    private g iIp;
    private d iIq;
    private long pg;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.pg = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void ai(String str) {
        oW = str;
    }

    public static void setUserAgent(String str) {
        oX = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iIp = new g();
        a(this.iIp, z);
        this.iIp.cfZ().setUrl(str);
        this.iIq = new d(this.iIp);
        this.iIq.c(i, i3, i4);
        return this.iIp.cga();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iIp = new g();
        a(this.iIp, z);
        this.iIp.cfZ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iIp.cfZ().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iIp.cfZ().l(next.getName(), next.getValue());
            }
        }
        this.iIq = new d(this.iIp);
        this.iIq.e(i, i2, -1);
        return this.iIp.cga();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iIp = new g();
        b(this.iIp);
        this.iIp.cfZ().setUrl(str);
        this.iIq = new d(this.iIp);
        return this.iIq.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iIq != null) {
            this.iIq.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iIq != null) {
            return this.iIq.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.iIq != null) {
            this.iIq.setCancel();
        }
    }

    public g cfY() {
        return this.iIp;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(oW)) {
                gVar.cfZ().l(SM.COOKIE, oW);
            } else {
                gVar.cfZ().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cfZ().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(oX)) {
                gVar.cfZ().l(HTTP.USER_AGENT, oX);
            }
            if (z) {
                gVar.cfZ().l("Accept-Encoding", "gzip");
            } else {
                gVar.cfZ().l("Accept-Encoding", "");
            }
            if (oY) {
                gVar.cfZ().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cfZ().l(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cfZ().l("client_logid", String.valueOf(this.pg));
            if (!TextUtils.isEmpty(oZ)) {
                gVar.cfZ().l("cuid", oZ);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
