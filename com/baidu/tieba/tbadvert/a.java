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
    private final com.baidu.tieba.tbadvert.view.a lql;
    private b lqm;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0732a lqo = new a.InterfaceC0732a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0732a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.lqn.dfs();
            } else if (a.this.lqm != null) {
                a.this.lqm.NU();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.lqn.dft();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.lqn.dft();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0732a
        public void dfm() {
            if (a.this.isActive && a.this.lqm != null) {
                a.this.lqm.NU();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0732a
        public void aH(Object obj) {
            com.baidu.tieba.tbadvert.a.b dfr;
            if (a.this.isActive && (dfr = a.this.lqn.dfr()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.G(a.this.mContext) != null) {
                    c.dcI().b(i.G(a.this.mContext).getUniqueId(), b);
                }
                a.this.lql.f(obj, ((int) dfr.showTime) / 1000);
                if (a.this.lqm != null) {
                    a.this.lqm.g(String.valueOf(dfr.id), dfr.bnC(), dfr.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0733a lqp = new a.InterfaceC0733a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0733a
        public void dfn() {
            com.baidu.tieba.tbadvert.a.b dfr = a.this.lqn.dfr();
            if (dfr != null) {
                if (a.this.lqm != null) {
                    a.this.lqm.an(String.valueOf(dfr.id), dfr.bnC());
                }
                if (!TextUtils.isEmpty(dfr.linkUrl)) {
                    if (!a.this.MW(dfr.linkUrl)) {
                        ba.aVa().a((TbPageContext) i.G(a.this.mContext), new String[]{dfr.linkUrl}, true);
                        return;
                    }
                    final String str = dfr.linkUrl;
                    e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aVa().a((TbPageContext) i.G(com.baidu.adp.base.a.jm().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0733a
        public void dfo() {
            if (a.this.lqm != null) {
                a.this.lqm.aNb();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a lqn = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.lqn.a(this.lqo);
        this.lql = new com.baidu.tieba.tbadvert.view.a(context, this.lqp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.h.a.a.checkPermissionGranted(com.baidu.adp.base.a.jm().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.lql.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.lqm = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void bgh() {
        this.lqn.dfq();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
