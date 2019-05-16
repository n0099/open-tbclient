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
    private final com.baidu.tieba.tbadvert.view.a jcy;
    private b jcz;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hCL = true;
    private a.InterfaceC0412a jcB = new a.InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.jS()) {
                a.this.jcA.cnS();
            } else if (a.this.jcz != null) {
                a.this.jcz.auM();
            }
            if (a.this.hCL) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.jS() && j.jT()) {
                            a.this.jcA.cnT();
                        }
                    }
                }, 800L);
            } else if (j.jS() && j.jT()) {
                a.this.jcA.cnT();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void cnM() {
            if (a.this.hCL && a.this.jcz != null) {
                a.this.jcz.auM();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0412a
        public void ay(Object obj) {
            com.baidu.tieba.tbadvert.a.b cnR;
            if (a.this.hCL && (cnR = a.this.jcA.cnR()) != null) {
                am b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.clt().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jcy.f(obj, ((int) cnR.showTime) / 1000);
                if (a.this.jcz != null) {
                    a.this.jcz.S(String.valueOf(cnR.id), cnR.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0413a jcC = new a.InterfaceC0413a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0413a
        public void cnN() {
            com.baidu.tieba.tbadvert.a.b cnR = a.this.jcA.cnR();
            if (cnR != null) {
                if (a.this.jcz != null) {
                    a.this.jcz.qJ(String.valueOf(cnR.id));
                }
                if (!TextUtils.isEmpty(cnR.linkUrl)) {
                    ba.aiz().a((TbPageContext) i.ab(a.this.mContext), new String[]{cnR.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0413a
        public void cnO() {
            if (a.this.jcz != null) {
                a.this.jcz.ZU();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jcA = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jcA.a(this.jcB);
        this.jcy = new com.baidu.tieba.tbadvert.view.a(context, this.jcC);
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jcy.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jcz = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void auL() {
        this.jcA.cnQ();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.hCL = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
