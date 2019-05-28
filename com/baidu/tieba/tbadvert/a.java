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
    private final com.baidu.tieba.tbadvert.view.a jcA;
    private b jcB;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hCO = true;
    private a.InterfaceC0412a jcD = new a.InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.jS()) {
                a.this.jcC.cnU();
            } else if (a.this.jcB != null) {
                a.this.jcB.auM();
            }
            if (a.this.hCO) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.jS() && j.jT()) {
                            a.this.jcC.cnV();
                        }
                    }
                }, 800L);
            } else if (j.jS() && j.jT()) {
                a.this.jcC.cnV();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void cnO() {
            if (a.this.hCO && a.this.jcB != null) {
                a.this.jcB.auM();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void ay(Object obj) {
            com.baidu.tieba.tbadvert.a.b cnT;
            if (a.this.hCO && (cnT = a.this.jcC.cnT()) != null) {
                am b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.clv().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jcA.f(obj, ((int) cnT.showTime) / 1000);
                if (a.this.jcB != null) {
                    a.this.jcB.S(String.valueOf(cnT.id), cnT.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0413a jcE = new a.InterfaceC0413a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0413a
        public void cnP() {
            com.baidu.tieba.tbadvert.a.b cnT = a.this.jcC.cnT();
            if (cnT != null) {
                if (a.this.jcB != null) {
                    a.this.jcB.qJ(String.valueOf(cnT.id));
                }
                if (!TextUtils.isEmpty(cnT.linkUrl)) {
                    ba.aiz().a((TbPageContext) i.ab(a.this.mContext), new String[]{cnT.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0413a
        public void cnQ() {
            if (a.this.jcB != null) {
                a.this.jcB.ZU();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jcC = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jcC.a(this.jcD);
        this.jcA = new com.baidu.tieba.tbadvert.view.a(context, this.jcE);
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jcA.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jcB = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void auL() {
        this.jcC.cnS();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.hCO = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
