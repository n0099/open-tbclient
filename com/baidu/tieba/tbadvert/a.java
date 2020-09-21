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
/* loaded from: classes25.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a msL;
    private b msM;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0807a msO = new a.InterfaceC0807a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0807a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.msN.dCg();
            } else if (a.this.msM != null) {
                a.this.msM.VU();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.msN.dCh();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.msN.dCh();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0807a
        public void dCa() {
            if (a.this.isActive && a.this.msM != null) {
                a.this.msM.VU();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0807a
        public void aM(Object obj) {
            com.baidu.tieba.tbadvert.a.b dCf;
            if (a.this.isActive && (dCf = a.this.msN.dCf()) != null) {
                aq b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dzC().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.msL.f(obj, ((int) dCf.showTime) / 1000);
                if (a.this.msM != null) {
                    a.this.msM.g(String.valueOf(dCf.id), dCf.bds(), dCf.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0808a msP = new a.InterfaceC0808a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0808a
        public void dCb() {
            com.baidu.tieba.tbadvert.a.b dCf = a.this.msN.dCf();
            if (dCf != null) {
                if (a.this.msM != null) {
                    a.this.msM.as(String.valueOf(dCf.id), dCf.bds());
                }
                if (!TextUtils.isEmpty(dCf.linkUrl)) {
                    if (!a.this.RE(dCf.linkUrl)) {
                        be.bkp().a((TbPageContext) i.I(a.this.mContext), new String[]{dCf.linkUrl}, true);
                        return;
                    }
                    final String str = dCf.linkUrl;
                    e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.bkp().a((TbPageContext) i.I(com.baidu.adp.base.a.lf().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0808a
        public void dCc() {
            if (a.this.msM != null) {
                a.this.msM.bbK();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a msN = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.msN.a(this.msO);
        this.msL = new com.baidu.tieba.tbadvert.view.a(context, this.msP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean RE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.m.a.a.checkPermissionGranted(com.baidu.adp.base.a.lf().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.msL.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.msM = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bvY() {
        this.msN.dCe();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
