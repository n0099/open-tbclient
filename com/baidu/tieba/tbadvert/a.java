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
    private final com.baidu.tieba.tbadvert.view.a kkw;
    private b kkx;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0615a kkz = new a.InterfaceC0615a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kky.cMz();
            } else if (a.this.kkx != null) {
                a.this.kkx.aRK();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kky.cMA();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kky.cMA();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void cMt() {
            if (a.this.isActive && a.this.kkx != null) {
                a.this.kkx.aRK();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0615a
        public void aB(Object obj) {
            com.baidu.tieba.tbadvert.a.b cMy;
            if (a.this.isActive && (cMy = a.this.kky.cMy()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cKa().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kkw.e(obj, ((int) cMy.showTime) / 1000);
                if (a.this.kkx != null) {
                    a.this.kkx.g(String.valueOf(cMy.id), cMy.aZi(), cMy.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0616a kkA = new a.InterfaceC0616a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0616a
        public void cMu() {
            com.baidu.tieba.tbadvert.a.b cMy = a.this.kky.cMy();
            if (cMy != null) {
                if (a.this.kkx != null) {
                    a.this.kkx.V(String.valueOf(cMy.id), cMy.aZi());
                }
                if (!TextUtils.isEmpty(cMy.linkUrl)) {
                    if (!a.this.Jv(cMy.linkUrl)) {
                        ba.aGG().a((TbPageContext) i.ab(a.this.mContext), new String[]{cMy.linkUrl}, true);
                        return;
                    }
                    final String str = cMy.linkUrl;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aGG().a((TbPageContext) i.ab(com.baidu.adp.base.a.eH().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0616a
        public void cMv() {
            if (a.this.kkx != null) {
                a.this.kkx.azb();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kky = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kky.a(this.kkz);
        this.kkw = new com.baidu.tieba.tbadvert.view.a(context, this.kkA);
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
        return this.kkw.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kkx = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aRJ() {
        this.kky.cMx();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
