package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes8.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nBg;
    private b nBh;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0875a nBj = new a.InterfaceC0875a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0875a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nBi.dPz();
            } else if (a.this.nBh != null) {
                a.this.nBh.bER();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nBi.dPA();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nBi.dPA();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0875a
        public void dPt() {
            if (a.this.isActive && a.this.nBh != null) {
                a.this.nBh.bER();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0875a
        public void aS(Object obj) {
            com.baidu.tieba.tbadvert.a.b dPy;
            if (a.this.isActive && (dPy = a.this.nBi.dPy()) != null) {
                ar b2 = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (com.baidu.adp.base.j.K(a.this.mContext) != null) {
                    c.dMr().b(com.baidu.adp.base.j.K(a.this.mContext).getUniqueId(), b2);
                }
                a.this.nBg.e(obj, ((int) dPy.showTime) / 1000);
                if (a.this.nBh != null) {
                    a.this.nBh.g(String.valueOf(dPy.id), dPy.isVideoAd(), dPy.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0876a nBk = new a.InterfaceC0876a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0876a
        public void dPu() {
            com.baidu.tieba.tbadvert.a.b dPy = a.this.nBi.dPy();
            if (dPy != null) {
                if (a.this.nBh != null) {
                    a.this.nBh.ay(String.valueOf(dPy.id), dPy.isVideoAd());
                }
                if (!TextUtils.isEmpty(dPy.linkUrl)) {
                    if (!a.this.TK(dPy.linkUrl)) {
                        bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(a.this.mContext), new String[]{dPy.linkUrl}, true);
                        return;
                    }
                    final String str = dPy.linkUrl;
                    e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(com.baidu.adp.base.b.kB().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0876a
        public void dPv() {
            if (a.this.nBh != null) {
                a.this.nBh.onAdDismiss();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nBi = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nBi.a(this.nBj);
        this.nBg = new com.baidu.tieba.tbadvert.view.a(context, this.nBk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TK(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.l.a.a.checkPermissionGranted(com.baidu.adp.base.b.kB().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nBg.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nBh = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bEQ() {
        this.nBi.dPx();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
