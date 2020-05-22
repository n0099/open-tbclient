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
    private final com.baidu.tieba.tbadvert.view.a lpc;
    private b lpd;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0731a lpf = new a.InterfaceC0731a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0731a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.lpe.dfd();
            } else if (a.this.lpd != null) {
                a.this.lpd.NU();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.lpe.dfe();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.lpe.dfe();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0731a
        public void deX() {
            if (a.this.isActive && a.this.lpd != null) {
                a.this.lpd.NU();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0731a
        public void aH(Object obj) {
            com.baidu.tieba.tbadvert.a.b dfc;
            if (a.this.isActive && (dfc = a.this.lpe.dfc()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.G(a.this.mContext) != null) {
                    c.dct().b(i.G(a.this.mContext).getUniqueId(), b);
                }
                a.this.lpc.f(obj, ((int) dfc.showTime) / 1000);
                if (a.this.lpd != null) {
                    a.this.lpd.g(String.valueOf(dfc.id), dfc.bnA(), dfc.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0732a lpg = new a.InterfaceC0732a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0732a
        public void deY() {
            com.baidu.tieba.tbadvert.a.b dfc = a.this.lpe.dfc();
            if (dfc != null) {
                if (a.this.lpd != null) {
                    a.this.lpd.an(String.valueOf(dfc.id), dfc.bnA());
                }
                if (!TextUtils.isEmpty(dfc.linkUrl)) {
                    if (!a.this.MV(dfc.linkUrl)) {
                        ba.aUZ().a((TbPageContext) i.G(a.this.mContext), new String[]{dfc.linkUrl}, true);
                        return;
                    }
                    final String str = dfc.linkUrl;
                    e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aUZ().a((TbPageContext) i.G(com.baidu.adp.base.a.jm().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0732a
        public void deZ() {
            if (a.this.lpd != null) {
                a.this.lpd.aNb();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a lpe = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.lpe.a(this.lpf);
        this.lpc = new com.baidu.tieba.tbadvert.view.a(context, this.lpg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MV(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.h.a.a.checkPermissionGranted(com.baidu.adp.base.a.jm().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.lpc.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.lpd = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void bgg() {
        this.lpe.dfb();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
