package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.u.b;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.u.a {
    private final com.baidu.tieba.tbadvert.view.a jlC;
    private b jlD;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0523a jlF = new a.InterfaceC0523a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.jlE.cpS();
            } else if (a.this.jlD != null) {
                a.this.jlD.axm();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.jlE.cpT();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.jlE.cpT();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void cpM() {
            if (a.this.isActive && a.this.jlD != null) {
                a.this.jlD.axm();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void at(Object obj) {
            com.baidu.tieba.tbadvert.a.b cpR;
            if (a.this.isActive && (cpR = a.this.jlE.cpR()) != null) {
                an b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cni().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jlC.e(obj, ((int) cpR.showTime) / 1000);
                if (a.this.jlD != null) {
                    a.this.jlD.g(String.valueOf(cpR.id), cpR.aEF(), cpR.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0524a jlG = new a.InterfaceC0524a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0524a
        public void cpN() {
            com.baidu.tieba.tbadvert.a.b cpR = a.this.jlE.cpR();
            if (cpR != null) {
                if (a.this.jlD != null) {
                    a.this.jlD.R(String.valueOf(cpR.id), cpR.aEF());
                }
                if (!TextUtils.isEmpty(cpR.linkUrl)) {
                    if (!a.this.Ej(cpR.linkUrl)) {
                        ba.amO().a((TbPageContext) i.ab(a.this.mContext), new String[]{cpR.linkUrl}, true);
                        return;
                    }
                    final String str = cpR.linkUrl;
                    e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.amO().a((TbPageContext) i.ab(com.baidu.adp.base.a.em().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0524a
        public void cpO() {
            if (a.this.jlD != null) {
                a.this.jlD.afB();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jlE = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jlE.a(this.jlF);
        this.jlC = new com.baidu.tieba.tbadvert.view.a(context, this.jlG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ej(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.e.a.a.L(com.baidu.adp.base.a.em().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jlC.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jlD = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void axl() {
        this.jlE.cpQ();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
