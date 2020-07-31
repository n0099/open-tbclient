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
/* loaded from: classes20.dex */
public class c {
    private static String Lu;
    private static String Lv;
    private static boolean Lw;
    private static String Lx;
    private static String sUid;
    private long LD;
    private g lmS;
    private d lmT;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.LD = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bI(String str) {
        Lu = str;
    }

    public static void setUserAgent(String str) {
        Lv = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lmS = new g();
        a(this.lmS, z);
        this.lmS.dcp().setUrl(str);
        this.lmT = new d(this.lmS);
        this.lmT.d(i, i3, i4);
        return this.lmS.dcq();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.lmS = new g();
        a(this.lmS, z);
        this.lmS.dcp().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.lmS.dcp().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.lmS.dcp().s(next.getName(), next.getValue());
            }
        }
        this.lmT = new d(this.lmS);
        this.lmT.f(i, i2, -1);
        return this.lmS.dcq();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.lmS = new g();
        b(this.lmS);
        this.lmS.dcp().setUrl(str);
        this.lmT = new d(this.lmS);
        return this.lmT.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.lmT != null) {
            this.lmT.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.lmT != null) {
            return this.lmT.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.lmT != null) {
            this.lmT.setCancel();
        }
    }

    public g dco() {
        return this.lmS;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Lu)) {
                gVar.dcp().s(SM.COOKIE, Lu);
            } else {
                gVar.dcp().s(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dcp().s("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(Lv)) {
                gVar.dcp().s("User-Agent", Lv);
            }
            if (z) {
                gVar.dcp().s(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dcp().s(Headers.ACCEPT_ENCODING, "");
            }
            if (Lw) {
                gVar.dcp().s(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dcp().s(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dcp().s("client_logid", String.valueOf(this.LD));
            if (!TextUtils.isEmpty(Lx)) {
                gVar.dcp().s("cuid", Lx);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
