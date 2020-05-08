package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.r.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes13.dex */
public class a implements com.baidu.tbadk.r.a {
    private final com.baidu.tieba.tbadvert.view.a kWu;
    private b kWv;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0678a kWx = new a.InterfaceC0678a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0678a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kWw.cXO();
            } else if (a.this.kWv != null) {
                a.this.kWv.LH();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kWw.cXP();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kWw.cXP();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0678a
        public void cXI() {
            if (a.this.isActive && a.this.kWv != null) {
                a.this.kWv.LH();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0678a
        public void aE(Object obj) {
            com.baidu.tieba.tbadvert.a.b cXN;
            if (a.this.isActive && (cXN = a.this.kWw.cXN()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.G(a.this.mContext) != null) {
                    c.cVo().b(i.G(a.this.mContext).getUniqueId(), b);
                }
                a.this.kWu.f(obj, ((int) cXN.showTime) / 1000);
                if (a.this.kWv != null) {
                    a.this.kWv.g(String.valueOf(cXN.id), cXN.bhp(), cXN.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0679a kWy = new a.InterfaceC0679a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0679a
        public void cXJ() {
            com.baidu.tieba.tbadvert.a.b cXN = a.this.kWw.cXN();
            if (cXN != null) {
                if (a.this.kWv != null) {
                    a.this.kWv.aa(String.valueOf(cXN.id), cXN.bhp());
                }
                if (!TextUtils.isEmpty(cXN.linkUrl)) {
                    if (!a.this.Li(cXN.linkUrl)) {
                        ba.aOV().a((TbPageContext) i.G(a.this.mContext), new String[]{cXN.linkUrl}, true);
                        return;
                    }
                    final String str = cXN.linkUrl;
                    e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aOV().a((TbPageContext) i.G(com.baidu.adp.base.a.jm().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0679a
        public void cXK() {
            if (a.this.kWv != null) {
                a.this.kWv.aHn();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kWw = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kWw.a(this.kWx);
        this.kWu = new com.baidu.tieba.tbadvert.view.a(context, this.kWy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Li(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.h.a.a.checkPermissionGranted(com.baidu.adp.base.a.jm().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.kWu.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kWv = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aZW() {
        this.kWw.cXM();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
