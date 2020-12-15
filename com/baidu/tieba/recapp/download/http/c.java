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
/* loaded from: classes26.dex */
public class c {
    private static String NA;
    private static boolean NC;
    private static String ND;
    private static String Nz;
    private static String sUid;
    private long NK;
    private g mIR;
    private d mIS;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.NK = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void bS(String str) {
        Nz = str;
    }

    public static void setUserAgent(String str) {
        NA = str;
    }

    public static void setUid(String str) {
        sUid = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mIR = new g();
        a(this.mIR, z);
        this.mIR.dFv().setUrl(str);
        this.mIS = new d(this.mIR);
        this.mIS.d(i, i3, i4);
        return this.mIR.dFw();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.mIR = new g();
        a(this.mIR, z);
        this.mIR.dFv().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.mIR.dFv().addPostData(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.mIR.dFv().u(next.getName(), next.getValue());
            }
        }
        this.mIS = new d(this.mIR);
        this.mIS.f(i, i2, -1);
        return this.mIR.dFw();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.mIR = new g();
        b(this.mIR);
        this.mIR.dFv().setUrl(str);
        this.mIS = new d(this.mIR);
        return this.mIS.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.mIS != null) {
            this.mIS.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.mIS != null) {
            return this.mIS.isCancel();
        }
        return false;
    }

    public void setCancel() {
        if (this.mIS != null) {
            this.mIS.setCancel();
        }
    }

    public g dFu() {
        return this.mIR;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(Nz)) {
                gVar.dFv().u(SM.COOKIE, Nz);
            } else {
                gVar.dFv().u(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(sUid)) {
                gVar.dFv().u("client_user_token", sUid);
            }
            if (!TextUtils.isEmpty(NA)) {
                gVar.dFv().u("User-Agent", NA);
            }
            if (z) {
                gVar.dFv().u(Headers.ACCEPT_ENCODING, "gzip");
            } else {
                gVar.dFv().u(Headers.ACCEPT_ENCODING, "");
            }
            if (NC) {
                gVar.dFv().u(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.dFv().u(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.dFv().u("client_logid", String.valueOf(this.NK));
            if (!TextUtils.isEmpty(ND)) {
                gVar.dFv().u("cuid", ND);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
