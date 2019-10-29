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
    private final com.baidu.tieba.tbadvert.view.a jmu;
    private b jmv;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0523a jmx = new a.InterfaceC0523a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.jmw.cpU();
            } else if (a.this.jmv != null) {
                a.this.jmv.axo();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.jmw.cpV();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.jmw.cpV();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void cpO() {
            if (a.this.isActive && a.this.jmv != null) {
                a.this.jmv.axo();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0523a
        public void at(Object obj) {
            com.baidu.tieba.tbadvert.a.b cpT;
            if (a.this.isActive && (cpT = a.this.jmw.cpT()) != null) {
                an b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cnk().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jmu.e(obj, ((int) cpT.showTime) / 1000);
                if (a.this.jmv != null) {
                    a.this.jmv.g(String.valueOf(cpT.id), cpT.aEH(), cpT.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0524a jmy = new a.InterfaceC0524a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0524a
        public void cpP() {
            com.baidu.tieba.tbadvert.a.b cpT = a.this.jmw.cpT();
            if (cpT != null) {
                if (a.this.jmv != null) {
                    a.this.jmv.R(String.valueOf(cpT.id), cpT.aEH());
                }
                if (!TextUtils.isEmpty(cpT.linkUrl)) {
                    if (!a.this.Ej(cpT.linkUrl)) {
                        ba.amQ().a((TbPageContext) i.ab(a.this.mContext), new String[]{cpT.linkUrl}, true);
                        return;
                    }
                    final String str = cpT.linkUrl;
                    e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.amQ().a((TbPageContext) i.ab(com.baidu.adp.base.a.em().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0524a
        public void cpQ() {
            if (a.this.jmv != null) {
                a.this.jmv.afD();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jmw = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jmw.a(this.jmx);
        this.jmu = new com.baidu.tieba.tbadvert.view.a(context, this.jmy);
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
        return this.jmu.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jmv = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void axn() {
        this.jmw.cpS();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
