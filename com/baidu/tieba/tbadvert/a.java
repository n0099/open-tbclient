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
/* loaded from: classes7.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nrx;
    private b nry;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0872a nrA = new a.InterfaceC0872a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nrz.dNo();
            } else if (a.this.nry != null) {
                a.this.nry.acM();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nrz.dNp();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nrz.dNp();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void dNi() {
            if (a.this.isActive && a.this.nry != null) {
                a.this.nry.acM();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void aS(Object obj) {
            com.baidu.tieba.tbadvert.a.b dNn;
            if (a.this.isActive && (dNn = a.this.nrz.dNn()) != null) {
                aq b2 = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (com.baidu.adp.base.j.K(a.this.mContext) != null) {
                    c.dKg().b(com.baidu.adp.base.j.K(a.this.mContext).getUniqueId(), b2);
                }
                a.this.nrx.e(obj, ((int) dNn.showTime) / 1000);
                if (a.this.nry != null) {
                    a.this.nry.g(String.valueOf(dNn.id), dNn.isVideoAd(), dNn.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0873a nrB = new a.InterfaceC0873a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0873a
        public void dNj() {
            com.baidu.tieba.tbadvert.a.b dNn = a.this.nrz.dNn();
            if (dNn != null) {
                if (a.this.nry != null) {
                    a.this.nry.az(String.valueOf(dNn.id), dNn.isVideoAd());
                }
                if (!TextUtils.isEmpty(dNn.linkUrl)) {
                    if (!a.this.SN(dNn.linkUrl)) {
                        be.bsB().a((TbPageContext) com.baidu.adp.base.j.K(a.this.mContext), new String[]{dNn.linkUrl}, true);
                        return;
                    }
                    final String str = dNn.linkUrl;
                    e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.bsB().a((TbPageContext) com.baidu.adp.base.j.K(com.baidu.adp.base.b.kC().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0873a
        public void dNk() {
            if (a.this.nry != null) {
                a.this.nry.onAdDismiss();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nrz = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nrz.a(this.nrA);
        this.nrx = new com.baidu.tieba.tbadvert.view.a(context, this.nrB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.l.a.a.checkPermissionGranted(com.baidu.adp.base.b.kC().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nrx.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nry = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bEy() {
        this.nrz.dNm();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
