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
/* loaded from: classes11.dex */
public class c {
    private static String rI;
    private static String rJ;
    private static boolean rK;
    private static String rL;
    private static String sUid;
    private g jGn;
    private d jGo;
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
        this.jGn = new g();
        a(this.jGn, z);
        this.jGn.cBm().setUrl(str);
        this.jGo = new d(this.jGn);
        this.jGo.c(i, i3, i4);
        return this.jGn.cBn();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jGn = new g();
        a(this.jGn, z);
        this.jGn.cBm().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.jGn.cBm().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.jGn.cBm().l(next.getName(), next.getValue());
            }
        }
        this.jGo = new d(this.jGn);
        this.jGo.e(i, i2, -1);
        return this.jGn.cBn();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.jGn = new g();
        b(this.jGn);
        this.jGn.cBm().setUrl(str);
        this.jGo = new d(this.jGn);
        return this.jGo.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.jGo != null) {
            this.jGo.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.jGo != null) {
            return this.jGo.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.jGo != null) {
            this.jGo.setCancel();
        }
    }

    public g cBl() {
        return this.jGn;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(rI)) {
                gVar.cBm().l(SM.COOKIE, rI);
            } else {
                gVar.cBm().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cBm().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rJ)) {
                gVar.cBm().l("User-Agent", rJ);
            }
            if (z) {
                gVar.cBm().l(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cBm().l(Headers.ACCEPT_ENCODING, "");
            }
            if (rK) {
                gVar.cBm().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cBm().l(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cBm().l("client_logid", String.valueOf(this.rQ));
            if (!TextUtils.isEmpty(rL)) {
                gVar.cBm().l("cuid", rL);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
