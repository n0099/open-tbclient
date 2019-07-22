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
    private static String AW;
    private static String AX;
    private static String AY;
    private static boolean AZ;
    private static String Ba;
    private long Bf;
    private g iGP;
    private d iGQ;

    public void init() {
        System.setProperty("http.keepAlive", "false");
        this.Bf = BdStatisticsManager.getInstance().getClientLogId();
    }

    public static void aC(String str) {
        AW = str;
    }

    public static void setUserAgent(String str) {
        AX = str;
    }

    public static void setUid(String str) {
        AY = str;
    }

    public i b(String str, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iGP = new g();
        a(this.iGP, z);
        this.iGP.chT().setUrl(str);
        this.iGQ = new d(this.iGP);
        this.iGQ.d(i, i3, i4);
        return this.iGP.chU();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iGP = new g();
        a(this.iGP, z);
        this.iGP.chT().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iGP.chT().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iGP.chT().q(next.getName(), next.getValue());
            }
        }
        this.iGQ = new d(this.iGP);
        this.iGQ.f(i, i2, -1);
        return this.iGP.chU();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iGP = new g();
        b(this.iGP);
        this.iGP.chT().setUrl(str);
        this.iGQ = new d(this.iGP);
        return this.iGQ.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iGQ != null) {
            this.iGQ.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iGQ != null) {
            return this.iGQ.im();
        }
        return false;
    }

    public void in() {
        if (this.iGQ != null) {
            this.iGQ.in();
        }
    }

    public g chS() {
        return this.iGP;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(AW)) {
                gVar.chT().q(SM.COOKIE, AW);
            } else {
                gVar.chT().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(AY)) {
                gVar.chT().q("client_user_token", AY);
            }
            if (!TextUtils.isEmpty(AX)) {
                gVar.chT().q(HTTP.USER_AGENT, AX);
            }
            if (z) {
                gVar.chT().q("Accept-Encoding", "gzip");
            } else {
                gVar.chT().q("Accept-Encoding", "");
            }
            if (AZ) {
                gVar.chT().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.chT().q(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.chT().q("client_logid", String.valueOf(this.Bf));
            if (!TextUtils.isEmpty(Ba)) {
                gVar.chT().q("cuid", Ba);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
