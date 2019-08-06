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
    private g iHT;
    private d iHU;

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
        this.iHT = new g();
        a(this.iHT, z);
        this.iHT.cil().setUrl(str);
        this.iHU = new d(this.iHT);
        this.iHU.d(i, i3, i4);
        return this.iHT.cim();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iHT = new g();
        a(this.iHT, z);
        this.iHT.cil().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iHT.cil().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iHT.cil().q(next.getName(), next.getValue());
            }
        }
        this.iHU = new d(this.iHT);
        this.iHU.f(i, i2, -1);
        return this.iHT.cim();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iHT = new g();
        b(this.iHT);
        this.iHT.cil().setUrl(str);
        this.iHU = new d(this.iHT);
        return this.iHU.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iHU != null) {
            this.iHU.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iHU != null) {
            return this.iHU.im();
        }
        return false;
    }

    public void in() {
        if (this.iHU != null) {
            this.iHU.in();
        }
    }

    public g cik() {
        return this.iHT;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(AW)) {
                gVar.cil().q(SM.COOKIE, AW);
            } else {
                gVar.cil().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(AY)) {
                gVar.cil().q("client_user_token", AY);
            }
            if (!TextUtils.isEmpty(AX)) {
                gVar.cil().q(HTTP.USER_AGENT, AX);
            }
            if (z) {
                gVar.cil().q("Accept-Encoding", "gzip");
            } else {
                gVar.cil().q("Accept-Encoding", "");
            }
            if (AZ) {
                gVar.cil().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.cil().q(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.cil().q("client_logid", String.valueOf(this.Bf));
            if (!TextUtils.isEmpty(Ba)) {
                gVar.cil().q("cuid", Ba);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
