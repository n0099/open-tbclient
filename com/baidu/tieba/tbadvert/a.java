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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.u.b;
import com.baidu.tieba.q.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.u.a {
    private final com.baidu.tieba.tbadvert.view.a jkd;
    private b jke;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hJV = true;
    private a.InterfaceC0417a jkg = new a.InterfaceC0417a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0417a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kc()) {
                a.this.jkf.crk();
            } else if (a.this.jke != null) {
                a.this.jke.avX();
            }
            if (a.this.hJV) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kc() && j.kd()) {
                            a.this.jkf.crl();
                        }
                    }
                }, 800L);
            } else if (j.kc() && j.kd()) {
                a.this.jkf.crl();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0417a
        public void cre() {
            if (a.this.hJV && a.this.jke != null) {
                a.this.jke.avX();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0417a
        public void ay(Object obj) {
            com.baidu.tieba.tbadvert.a.b crj;
            if (a.this.hJV && (crj = a.this.jkf.crj()) != null) {
                an b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.coG().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jkd.f(obj, ((int) crj.showTime) / 1000);
                if (a.this.jke != null) {
                    a.this.jke.g(String.valueOf(crj.id), crj.aDT(), crj.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0418a jkh = new a.InterfaceC0418a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0418a
        public void crf() {
            com.baidu.tieba.tbadvert.a.b crj = a.this.jkf.crj();
            if (crj != null) {
                if (a.this.jke != null) {
                    a.this.jke.U(String.valueOf(crj.id), crj.aDT());
                }
                if (!TextUtils.isEmpty(crj.linkUrl)) {
                    if (!a.this.Ff(crj.linkUrl)) {
                        bb.ajE().a((TbPageContext) i.ab(a.this.mContext), new String[]{crj.linkUrl}, true);
                        return;
                    }
                    final String str = crj.linkUrl;
                    e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bb.ajE().a((TbPageContext) i.ab(com.baidu.adp.base.a.eT().eU()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0418a
        public void crg() {
            if (a.this.jke != null) {
                a.this.jke.aaT();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jkf = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jkf.a(this.jkg);
        this.jkd = new com.baidu.tieba.tbadvert.view.a(context, this.jkh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ff(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.e.a.a.N(com.baidu.adp.base.a.eT().eU(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jkd.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jke = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void avW() {
        this.jkf.cri();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.hJV = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
