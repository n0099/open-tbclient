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
    private final com.baidu.tieba.tbadvert.view.a nwc;
    private b nwd;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0889a nwf = new a.InterfaceC0889a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0889a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nwe.dRg();
            } else if (a.this.nwd != null) {
                a.this.nwd.agG();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nwe.dRh();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nwe.dRh();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0889a
        public void dRa() {
            if (a.this.isActive && a.this.nwd != null) {
                a.this.nwd.agG();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0889a
        public void aS(Object obj) {
            com.baidu.tieba.tbadvert.a.b dRf;
            if (a.this.isActive && (dRf = a.this.nwe.dRf()) != null) {
                aq b2 = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (com.baidu.adp.base.j.K(a.this.mContext) != null) {
                    c.dNY().b(com.baidu.adp.base.j.K(a.this.mContext).getUniqueId(), b2);
                }
                a.this.nwc.e(obj, ((int) dRf.showTime) / 1000);
                if (a.this.nwd != null) {
                    a.this.nwd.g(String.valueOf(dRf.id), dRf.isVideoAd(), dRf.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0890a nwg = new a.InterfaceC0890a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0890a
        public void dRb() {
            com.baidu.tieba.tbadvert.a.b dRf = a.this.nwe.dRf();
            if (dRf != null) {
                if (a.this.nwd != null) {
                    a.this.nwd.az(String.valueOf(dRf.id), dRf.isVideoAd());
                }
                if (!TextUtils.isEmpty(dRf.linkUrl)) {
                    if (!a.this.TU(dRf.linkUrl)) {
                        be.bwv().a((TbPageContext) com.baidu.adp.base.j.K(a.this.mContext), new String[]{dRf.linkUrl}, true);
                        return;
                    }
                    final String str = dRf.linkUrl;
                    e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.bwv().a((TbPageContext) com.baidu.adp.base.j.K(com.baidu.adp.base.b.kC().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0890a
        public void dRc() {
            if (a.this.nwd != null) {
                a.this.nwd.onAdDismiss();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nwe = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nwe.a(this.nwf);
        this.nwc = new com.baidu.tieba.tbadvert.view.a(context, this.nwg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TU(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.n.a.a.checkPermissionGranted(com.baidu.adp.base.b.kC().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nwc.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nwd = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bIq() {
        this.nwe.dRe();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
