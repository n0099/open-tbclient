package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes8.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nwd;
    private b nwe;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0856a nwg = new a.InterfaceC0856a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0856a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nwf.dRf();
            } else if (a.this.nwe != null) {
                a.this.nwe.agF();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nwf.dRg();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nwf.dRg();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0856a
        public void dQZ() {
            if (a.this.isActive && a.this.nwe != null) {
                a.this.nwe.agF();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0856a
        public void aS(Object obj) {
            com.baidu.tieba.tbadvert.a.b dRe;
            if (a.this.isActive && (dRe = a.this.nwf.dRe()) != null) {
                aq b2 = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (com.baidu.adp.base.j.K(a.this.mContext) != null) {
                    c.dNX().b(com.baidu.adp.base.j.K(a.this.mContext).getUniqueId(), b2);
                }
                a.this.nwd.e(obj, ((int) dRe.showTime) / 1000);
                if (a.this.nwe != null) {
                    a.this.nwe.g(String.valueOf(dRe.id), dRe.isVideoAd(), dRe.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0857a nwh = new a.InterfaceC0857a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0857a
        public void dRa() {
            com.baidu.tieba.tbadvert.a.b dRe = a.this.nwf.dRe();
            if (dRe != null) {
                if (a.this.nwe != null) {
                    a.this.nwe.az(String.valueOf(dRe.id), dRe.isVideoAd());
                }
                if (!TextUtils.isEmpty(dRe.linkUrl)) {
                    if (!a.this.TV(dRe.linkUrl)) {
                        be.bwu().a((TbPageContext) com.baidu.adp.base.j.K(a.this.mContext), new String[]{dRe.linkUrl}, true);
                        return;
                    }
                    final String str = dRe.linkUrl;
                    e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.bwu().a((TbPageContext) com.baidu.adp.base.j.K(com.baidu.adp.base.b.kC().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0857a
        public void dRb() {
            if (a.this.nwe != null) {
                a.this.nwe.onAdDismiss();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nwf = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nwf.a(this.nwg);
        this.nwd = new com.baidu.tieba.tbadvert.view.a(context, this.nwh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.n.a.a.checkPermissionGranted(com.baidu.adp.base.b.kC().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nwd.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nwe = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bIp() {
        this.nwf.dRd();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
