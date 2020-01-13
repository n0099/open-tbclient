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
    private g jGi;
    private d jGj;
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
        this.jGi = new g();
        a(this.jGi, z);
        this.jGi.cBk().setUrl(str);
        this.jGj = new d(this.jGi);
        this.jGj.c(i, i3, i4);
        return this.jGi.cBl();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jGi = new g();
        a(this.jGi, z);
        this.jGi.cBk().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.jGi.cBk().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.jGi.cBk().l(next.getName(), next.getValue());
            }
        }
        this.jGj = new d(this.jGi);
        this.jGj.e(i, i2, -1);
        return this.jGi.cBl();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.jGi = new g();
        b(this.jGi);
        this.jGi.cBk().setUrl(str);
        this.jGj = new d(this.jGi);
        return this.jGj.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.jGj != null) {
            this.jGj.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.jGj != null) {
            return this.jGj.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.jGj != null) {
            this.jGj.setCancel();
        }
    }

    public g cBj() {
        return this.jGi;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(rI)) {
                gVar.cBk().l(SM.COOKIE, rI);
            } else {
                gVar.cBk().l(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cBk().l("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rJ)) {
                gVar.cBk().l("User-Agent", rJ);
            }
            if (z) {
                gVar.cBk().l(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cBk().l(Headers.ACCEPT_ENCODING, "");
            }
            if (rK) {
                gVar.cBk().l(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cBk().l(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cBk().l("client_logid", String.valueOf(this.rQ));
            if (!TextUtils.isEmpty(rL)) {
                gVar.cBk().l("cuid", rL);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
