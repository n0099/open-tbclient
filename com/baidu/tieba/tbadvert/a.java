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
    private final com.baidu.tieba.tbadvert.view.a kku;
    private b kkv;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0615a kkx = new a.InterfaceC0615a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kkw.cMx();
            } else if (a.this.kkv != null) {
                a.this.kkv.aRI();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kkw.cMy();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kkw.cMy();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void cMr() {
            if (a.this.isActive && a.this.kkv != null) {
                a.this.kkv.aRI();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void aB(Object obj) {
            com.baidu.tieba.tbadvert.a.b cMw;
            if (a.this.isActive && (cMw = a.this.kkw.cMw()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cJY().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kku.e(obj, ((int) cMw.showTime) / 1000);
                if (a.this.kkv != null) {
                    a.this.kkv.g(String.valueOf(cMw.id), cMw.aZg(), cMw.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0616a kky = new a.InterfaceC0616a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0616a
        public void cMs() {
            com.baidu.tieba.tbadvert.a.b cMw = a.this.kkw.cMw();
            if (cMw != null) {
                if (a.this.kkv != null) {
                    a.this.kkv.V(String.valueOf(cMw.id), cMw.aZg());
                }
                if (!TextUtils.isEmpty(cMw.linkUrl)) {
                    if (!a.this.Jv(cMw.linkUrl)) {
                        ba.aGE().a((TbPageContext) i.ab(a.this.mContext), new String[]{cMw.linkUrl}, true);
                        return;
                    }
                    final String str = cMw.linkUrl;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aGE().a((TbPageContext) i.ab(com.baidu.adp.base.a.eH().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0616a
        public void cMt() {
            if (a.this.kkv != null) {
                a.this.kkv.ayZ();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kkw = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kkw.a(this.kkx);
        this.kku = new com.baidu.tieba.tbadvert.view.a(context, this.kky);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jv(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.k.a.a.checkPermissionGranted(com.baidu.adp.base.a.eH().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.kku.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kkv = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aRH() {
        this.kkw.cMv();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
