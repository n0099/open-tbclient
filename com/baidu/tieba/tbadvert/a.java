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
    private final com.baidu.tieba.tbadvert.view.a jiW;
    private b jiX;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hJc = true;
    private a.InterfaceC0411a jiZ = new a.InterfaceC0411a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0411a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kc()) {
                a.this.jiY.cqO();
            } else if (a.this.jiX != null) {
                a.this.jiX.avV();
            }
            if (a.this.hJc) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kc() && j.kd()) {
                            a.this.jiY.cqP();
                        }
                    }
                }, 800L);
            } else if (j.kc() && j.kd()) {
                a.this.jiY.cqP();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0411a
        public void cqI() {
            if (a.this.hJc && a.this.jiX != null) {
                a.this.jiX.avV();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0411a
        public void ay(Object obj) {
            com.baidu.tieba.tbadvert.a.b cqN;
            if (a.this.hJc && (cqN = a.this.jiY.cqN()) != null) {
                an b = com.baidu.tieba.q.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.coo().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.jiW.f(obj, ((int) cqN.showTime) / 1000);
                if (a.this.jiX != null) {
                    a.this.jiX.g(String.valueOf(cqN.id), cqN.aDR(), cqN.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0412a jja = new a.InterfaceC0412a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0412a
        public void cqJ() {
            com.baidu.tieba.tbadvert.a.b cqN = a.this.jiY.cqN();
            if (cqN != null) {
                if (a.this.jiX != null) {
                    a.this.jiX.U(String.valueOf(cqN.id), cqN.aDR());
                }
                if (!TextUtils.isEmpty(cqN.linkUrl)) {
                    if (!a.this.Fe(cqN.linkUrl)) {
                        bb.ajC().a((TbPageContext) i.ab(a.this.mContext), new String[]{cqN.linkUrl}, true);
                        return;
                    }
                    final String str = cqN.linkUrl;
                    e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bb.ajC().a((TbPageContext) i.ab(com.baidu.adp.base.a.eT().eU()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0412a
        public void cqK() {
            if (a.this.jiX != null) {
                a.this.jiX.aaT();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a jiY = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.jiY.a(this.jiZ);
        this.jiW = new com.baidu.tieba.tbadvert.view.a(context, this.jja);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Fe(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.e.a.a.N(com.baidu.adp.base.a.eT().eU(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.u.a
    public View getView() {
        return this.jiW.getView();
    }

    @Override // com.baidu.tbadk.u.a
    public void a(b bVar) {
        this.jiX = bVar;
    }

    @Override // com.baidu.tbadk.u.a
    public void avU() {
        this.jiY.cqM();
    }

    @Override // com.baidu.tbadk.u.a
    public void release() {
        this.hJc = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
