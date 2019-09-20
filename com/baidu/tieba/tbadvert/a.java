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
    private b jmA;
    private final com.baidu.tieba.tbadvert.view.a jmz;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hLS = true;
    private a.InterfaceC0428a jmC = new a.InterfaceC0428a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0428a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kc()) {
                a.this.jmB.crY();
            } else if (a.this.jmA != null) {
                a.this.jmA.awj();
            }
            if (a.this.hLS) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kc() && j.kd()) {
                            a.this.jmB.crZ();
                        }
                    }
                }, 800L);
            } else if (j.kc() && j.kd()) {
                a.this.jmB.crZ();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0428a
        public void crS() {
            if (a.this.hLS && a.this.jmA != null) {
                a.this.jmA.awj();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0428a
        public void ay(Object obj) {
            com.baidu.tieba.tbadvert.a.b crX;
            if (a.this.hLS && (crX = a.this.jmB.crX()) != null) {
                an b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cpt().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jmz.f(obj, ((int) crX.showTime) / 1000);
                if (a.this.jmA != null) {
                    a.this.jmA.g(String.valueOf(crX.id), crX.aEx(), crX.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0429a jmD = new a.InterfaceC0429a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0429a
        public void crT() {
            com.baidu.tieba.tbadvert.a.b crX = a.this.jmB.crX();
            if (crX != null) {
                if (a.this.jmA != null) {
                    a.this.jmA.U(String.valueOf(crX.id), crX.aEx());
                }
                if (!TextUtils.isEmpty(crX.linkUrl)) {
                    if (!a.this.FF(crX.linkUrl)) {
                        ba.ajK().a((TbPageContext) i.ab(a.this.mContext), new String[]{crX.linkUrl}, true);
                        return;
                    }
                    final String str = crX.linkUrl;
                    e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.ajK().a((TbPageContext) i.ab(com.baidu.adp.base.a.eT().eU()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0429a
        public void crU() {
            if (a.this.jmA != null) {
                a.this.jmA.aaX();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jmB = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jmB.a(this.jmC);
        this.jmz = new com.baidu.tieba.tbadvert.view.a(context, this.jmD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FF(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.e.a.a.N(com.baidu.adp.base.a.eT().eU(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jmz.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jmA = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void awi() {
        this.jmB.crW();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.hLS = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
