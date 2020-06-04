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
    private static String KV;
    private static String KW;
    private static boolean KX;
    private static String KY;
    private static String sUid;
    private long Le;
    private g kLK;
    private d kLL;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Le = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bJ(String str) {
        KV = str;
    }

    public static void setUserAgent(String str) {
        KW = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.kLK = new g();
        a(this.kLK, z);
        this.kLK.cUR().setUrl(str);
        this.kLL = new d(this.kLK);
        this.kLL.d(i, i3, i4);
        return this.kLK.cUS();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.kLK = new g();
        a(this.kLK, z);
        this.kLK.cUR().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.kLK.cUR().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.kLK.cUR().s(next.getName(), next.getValue());
            }
        }
        this.kLL = new d(this.kLK);
        this.kLL.f(i, i2, -1);
        return this.kLK.cUS();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.kLK = new g();
        b(this.kLK);
        this.kLK.cUR().setUrl(str);
        this.kLL = new d(this.kLK);
        return this.kLL.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.kLL != null) {
            this.kLL.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.kLL != null) {
            return this.kLL.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.kLL != null) {
            this.kLL.setCancel();
        }
    }

    public g cUQ() {
        return this.kLK;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(KV)) {
                gVar.cUR().s(SM.COOKIE, KV);
            } else {
                gVar.cUR().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cUR().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KW)) {
                gVar.cUR().s("User-Agent", KW);
            }
            if (z) {
                gVar.cUR().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cUR().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KX) {
                gVar.cUR().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cUR().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cUR().s("client_logid", String.valueOf(this.Le));
            if (!TextUtils.isEmpty(KY)) {
                gVar.cUR().s("cuid", KY);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
