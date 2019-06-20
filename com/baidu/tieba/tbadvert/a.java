package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.u.b;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.u.a {
    private final com.baidu.tieba.tbadvert.view.a jcE;
    private b jcF;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hCP = true;
    private a.InterfaceC0412a jcH = new a.InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.jS()) {
                a.this.jcG.cnV();
            } else if (a.this.jcF != null) {
                a.this.jcF.auM();
            }
            if (a.this.hCP) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.jS() && j.jT()) {
                            a.this.jcG.cnW();
                        }
                    }
                }, 800L);
            } else if (j.jS() && j.jT()) {
                a.this.jcG.cnW();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void cnP() {
            if (a.this.hCP && a.this.jcF != null) {
                a.this.jcF.auM();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void ay(Object obj) {
            com.baidu.tieba.tbadvert.a.b cnU;
            if (a.this.hCP && (cnU = a.this.jcG.cnU()) != null) {
                am b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.clw().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jcE.f(obj, ((int) cnU.showTime) / 1000);
                if (a.this.jcF != null) {
                    a.this.jcF.S(String.valueOf(cnU.id), cnU.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0413a jcI = new a.InterfaceC0413a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0413a
        public void cnQ() {
            com.baidu.tieba.tbadvert.a.b cnU = a.this.jcG.cnU();
            if (cnU != null) {
                if (a.this.jcF != null) {
                    a.this.jcF.qI(String.valueOf(cnU.id));
                }
                if (!TextUtils.isEmpty(cnU.linkUrl)) {
                    ba.aiz().a((TbPageContext) i.ab(a.this.mContext), new String[]{cnU.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0413a
        public void cnR() {
            if (a.this.jcF != null) {
                a.this.jcF.ZU();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jcG = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jcG.a(this.jcH);
        this.jcE = new com.baidu.tieba.tbadvert.view.a(context, this.jcI);
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jcE.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jcF = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void auL() {
        this.jcG.cnT();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.hCP = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
