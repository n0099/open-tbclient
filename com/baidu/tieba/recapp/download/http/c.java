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
    private g kKB;
    private d kKC;

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
        this.kKB = new g();
        a(this.kKB, z);
        this.kKB.cUB().setUrl(str);
        this.kKC = new d(this.kKB);
        this.kKC.d(i, i3, i4);
        return this.kKB.cUC();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.kKB = new g();
        a(this.kKB, z);
        this.kKB.cUB().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.kKB.cUB().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.kKB.cUB().s(next.getName(), next.getValue());
            }
        }
        this.kKC = new d(this.kKB);
        this.kKC.f(i, i2, -1);
        return this.kKB.cUC();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.kKB = new g();
        b(this.kKB);
        this.kKB.cUB().setUrl(str);
        this.kKC = new d(this.kKB);
        return this.kKC.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.kKC != null) {
            this.kKC.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.kKC != null) {
            return this.kKC.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.kKC != null) {
            this.kKC.setCancel();
        }
    }

    public g cUA() {
        return this.kKB;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(KV)) {
                gVar.cUB().s(SM.COOKIE, KV);
            } else {
                gVar.cUB().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.cUB().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(KW)) {
                gVar.cUB().s("User-Agent", KW);
            }
            if (z) {
                gVar.cUB().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.cUB().s(Headers.ACCEPT_ENCODING, "");
            }
            if (KX) {
                gVar.cUB().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cUB().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cUB().s("client_logid", String.valueOf(this.Le));
            if (!TextUtils.isEmpty(KY)) {
                gVar.cUB().s("cuid", KY);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
