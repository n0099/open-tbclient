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
    private static String rJ;
    private static String rK;
    private static boolean rL;
    private static String rM;
    private static String sUid;
    private g jHs;
    private d jHt;
    private long rR;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.rR = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void au(String str) {
        rJ = str;
    }

    public static void setUserAgent(String str) {
        rK = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jHs = new g();
        a(this.jHs, z);
        this.jHs.cCL().setUrl(str);
        this.jHt = new d(this.jHs);
        this.jHt.c(i, i3, i4);
        return this.jHs.cCM();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.jHs = new g();
        a(this.jHs, z);
        this.jHs.cCL().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.jHs.cCL().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.jHs.cCL().n(next.getName(), next.getValue());
            }
        }
        this.jHt = new d(this.jHs);
        this.jHt.e(i, i2, -1);
        return this.jHs.cCM();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.jHs = new g();
        b(this.jHs);
        this.jHs.cCL().setUrl(str);
        this.jHt = new d(this.jHs);
        return this.jHt.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.jHt != null) {
            this.jHt.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.jHt != null) {
            return this.jHt.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.jHt != null) {
            this.jHt.setCancel();
        }
    }

    public g cCK() {
        return this.jHs;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(rJ)) {
                gVar.cCL().n(SM.COOKIE, rJ);
            } else {
                gVar.cCL().n(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cCL().n("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(rK)) {
                gVar.cCL().n("User-Agent", rK);
            }
            if (z) {
                gVar.cCL().n(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cCL().n(Headers.ACCEPT_ENCODING, "");
            }
            if (rL) {
                gVar.cCL().n(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cCL().n(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cCL().n("client_logid", String.valueOf(this.rR));
            if (!TextUtils.isEmpty(rM)) {
                gVar.cCL().n("cuid", rM);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
