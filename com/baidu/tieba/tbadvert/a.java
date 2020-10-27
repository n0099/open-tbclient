package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes26.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a mVd;
    private b mVe;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0840a mVg = new a.InterfaceC0840a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0840a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.mVf.dJa();
            } else if (a.this.mVe != null) {
                a.this.mVe.ZL();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.mVf.dJb();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.mVf.dJb();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0840a
        public void dIU() {
            if (a.this.isActive && a.this.mVe != null) {
                a.this.mVe.ZL();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0840a
        public void aQ(Object obj) {
            com.baidu.tieba.tbadvert.a.b dIZ;
            if (a.this.isActive && (dIZ = a.this.mVf.dIZ()) != null) {
                aq b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dGv().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.mVd.f(obj, ((int) dIZ.showTime) / 1000);
                if (a.this.mVe != null) {
                    a.this.mVe.g(String.valueOf(dIZ.id), dIZ.bhU(), dIZ.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0841a mVh = new a.InterfaceC0841a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0841a
        public void dIV() {
            com.baidu.tieba.tbadvert.a.b dIZ = a.this.mVf.dIZ();
            if (dIZ != null) {
                if (a.this.mVe != null) {
                    a.this.mVe.ay(String.valueOf(dIZ.id), dIZ.bhU());
                }
                if (!TextUtils.isEmpty(dIZ.linkUrl)) {
                    if (!a.this.SR(dIZ.linkUrl)) {
                        be.boR().a((TbPageContext) i.I(a.this.mContext), new String[]{dIZ.linkUrl}, true);
                        return;
                    }
                    final String str = dIZ.linkUrl;
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.boR().a((TbPageContext) i.I(com.baidu.adp.base.a.lg().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0841a
        public void dIW() {
            if (a.this.mVe != null) {
                a.this.mVe.bgl();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a mVf = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.mVf.a(this.mVg);
        this.mVd = new com.baidu.tieba.tbadvert.view.a(context, this.mVh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean SR(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.m.a.a.checkPermissionGranted(com.baidu.adp.base.a.lg().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.mVd.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.mVe = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bAB() {
        this.mVf.dIY();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
