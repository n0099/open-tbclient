package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.t.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes25.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nca;
    private b ncb;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0857a ncd = new a.InterfaceC0857a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0857a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.ncc.dLB();
            } else if (a.this.ncb != null) {
                a.this.ncb.abB();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.ncc.dLC();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.ncc.dLC();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0857a
        public void dLv() {
            if (a.this.isActive && a.this.ncb != null) {
                a.this.ncb.abB();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0857a
        public void aR(Object obj) {
            com.baidu.tieba.tbadvert.a.b dLA;
            if (a.this.isActive && (dLA = a.this.ncc.dLA()) != null) {
                ar b = com.baidu.tieba.t.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dIO().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.nca.f(obj, ((int) dLA.showTime) / 1000);
                if (a.this.ncb != null) {
                    a.this.ncb.g(String.valueOf(dLA.id), dLA.bjw(), dLA.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0858a nce = new a.InterfaceC0858a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0858a
        public void dLw() {
            com.baidu.tieba.tbadvert.a.b dLA = a.this.ncc.dLA();
            if (dLA != null) {
                if (a.this.ncb != null) {
                    a.this.ncb.ay(String.valueOf(dLA.id), dLA.bjw());
                }
                if (!TextUtils.isEmpty(dLA.linkUrl)) {
                    if (!a.this.ST(dLA.linkUrl)) {
                        bf.bqF().a((TbPageContext) i.I(a.this.mContext), new String[]{dLA.linkUrl}, true);
                        return;
                    }
                    final String str = dLA.linkUrl;
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bf.bqF().a((TbPageContext) i.I(com.baidu.adp.base.a.lg().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0858a
        public void dLx() {
            if (a.this.ncb != null) {
                a.this.ncb.bif();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a ncc = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.ncc.a(this.ncd);
        this.nca = new com.baidu.tieba.tbadvert.view.a(context, this.nce);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ST(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.m.a.a.checkPermissionGranted(com.baidu.adp.base.a.lg().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nca.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.ncb = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bCt() {
        this.ncc.dLz();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
