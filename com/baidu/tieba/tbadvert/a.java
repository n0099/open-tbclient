package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes26.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a naZ;
    private b nba;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0855a nbc = new a.InterfaceC0855a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0855a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nbb.dLC();
            } else if (a.this.nba != null) {
                a.this.nba.ack();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nbb.dLD();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nbb.dLD();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0855a
        public void dLw() {
            if (a.this.isActive && a.this.nba != null) {
                a.this.nba.ack();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0855a
        public void aQ(Object obj) {
            com.baidu.tieba.tbadvert.a.b dLB;
            if (a.this.isActive && (dLB = a.this.nbb.dLB()) != null) {
                aq b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dIX().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.naZ.f(obj, ((int) dLB.showTime) / 1000);
                if (a.this.nba != null) {
                    a.this.nba.g(String.valueOf(dLB.id), dLB.bku(), dLB.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0856a nbd = new a.InterfaceC0856a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0856a
        public void dLx() {
            com.baidu.tieba.tbadvert.a.b dLB = a.this.nbb.dLB();
            if (dLB != null) {
                if (a.this.nba != null) {
                    a.this.nba.ay(String.valueOf(dLB.id), dLB.bku());
                }
                if (!TextUtils.isEmpty(dLB.linkUrl)) {
                    if (!a.this.Ti(dLB.linkUrl)) {
                        be.brr().a((TbPageContext) i.I(a.this.mContext), new String[]{dLB.linkUrl}, true);
                        return;
                    }
                    final String str = dLB.linkUrl;
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.brr().a((TbPageContext) i.I(com.baidu.adp.base.a.lg().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0856a
        public void dLy() {
            if (a.this.nba != null) {
                a.this.nba.biL();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nbb = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nbb.a(this.nbc);
        this.naZ = new com.baidu.tieba.tbadvert.view.a(context, this.nbd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ti(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.m.a.a.checkPermissionGranted(com.baidu.adp.base.a.lg().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.naZ.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nba = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bDa() {
        this.nbb.dLA();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
