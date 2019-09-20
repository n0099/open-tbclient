package com.baidu.tieba.recapp.download.http;

import android.text.TextUtils;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
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
    private g iKp;
    private d iKq;

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
        this.iKp = new g();
        a(this.iKp, z);
        this.iKp.ciZ().setUrl(str);
        this.iKq = new d(this.iKp);
        this.iKq.d(i, i3, i4);
        return this.iKp.cja();
    }

    public i b(String str, List<BasicNameValuePair> list, boolean z, int i, int i2, LinkedList<BasicNameValuePair> linkedList) throws Exception {
        this.iKp = new g();
        a(this.iKp, z);
        this.iKp.ciZ().setUrl(str);
        if (list != null) {
            for (BasicNameValuePair basicNameValuePair : list) {
                this.iKp.ciZ().a(basicNameValuePair);
            }
        }
        if (linkedList != null) {
            Iterator<BasicNameValuePair> it = linkedList.iterator();
            while (it.hasNext()) {
                BasicNameValuePair next = it.next();
                this.iKp.ciZ().q(next.getName(), next.getValue());
            }
        }
        this.iKq = new d(this.iKp);
        this.iKq.f(i, i2, -1);
        return this.iKp.cja();
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2) {
        return a(str, str2, z, i, i2, i3, i4, linkedList, jVar, z2, false);
    }

    public boolean a(String str, String str2, boolean z, int i, int i2, int i3, int i4, LinkedList<BasicNameValuePair> linkedList, j jVar, boolean z2, boolean z3) {
        this.iKp = new g();
        b(this.iKp);
        this.iKp.ciZ().setUrl(str);
        this.iKq = new d(this.iKp);
        return this.iKq.a(str2, jVar, i, i2, i3, i4, z2, z3);
    }

    public c() {
        init();
    }

    public void cancel() {
        if (this.iKq != null) {
            this.iKq.cancel();
        }
    }

    public boolean isCanceled() {
        if (this.iKq != null) {
            return this.iKq.im();
        }
        return false;
    }

    public void in() {
        if (this.iKq != null) {
            this.iKq.in();
        }
    }

    public g ciY() {
        return this.iKp;
    }

    private void a(g gVar, boolean z) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(AW)) {
                gVar.ciZ().q(SM.COOKIE, AW);
            } else {
                gVar.ciZ().q(SM.COOKIE, "");
            }
            if (!TextUtils.isEmpty(AY)) {
                gVar.ciZ().q("client_user_token", AY);
            }
            if (!TextUtils.isEmpty(AX)) {
                gVar.ciZ().q(HTTP.USER_AGENT, AX);
            }
            if (z) {
                gVar.ciZ().q("Accept-Encoding", "gzip");
            } else {
                gVar.ciZ().q("Accept-Encoding", "");
            }
            if (AZ) {
                gVar.ciZ().q(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } else {
                gVar.ciZ().q(HTTP.CONN_DIRECTIVE, "close");
            }
            gVar.ciZ().q("client_logid", String.valueOf(this.Bf));
            if (!TextUtils.isEmpty(Ba)) {
                gVar.ciZ().q(DpStatConstants.KEY_CUID, Ba);
            }
        }
    }

    private void b(g gVar) {
        a(gVar, false);
    }
}
