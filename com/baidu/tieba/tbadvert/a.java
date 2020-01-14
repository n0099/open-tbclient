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
import com.baidu.tieba.r.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes11.dex */
public class a implements com.baidu.tbadk.r.a {
    private final com.baidu.tieba.tbadvert.view.a kjy;
    private b kjz;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0607a kjB = new a.InterfaceC0607a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kjA.cLc();
            } else if (a.this.kjz != null) {
                a.this.kjz.aPs();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kjA.cLd();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kjA.cLd();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void cKW() {
            if (a.this.isActive && a.this.kjz != null) {
                a.this.kjz.aPs();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void az(Object obj) {
            com.baidu.tieba.tbadvert.a.b cLb;
            if (a.this.isActive && (cLb = a.this.kjA.cLb()) != null) {
                an b = com.baidu.tieba.r.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cIu().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kjy.e(obj, ((int) cLb.showTime) / 1000);
                if (a.this.kjz != null) {
                    a.this.kjz.g(String.valueOf(cLb.id), cLb.aWR(), cLb.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0608a kjC = new a.InterfaceC0608a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0608a
        public void cKX() {
            com.baidu.tieba.tbadvert.a.b cLb = a.this.kjA.cLb();
            if (cLb != null) {
                if (a.this.kjz != null) {
                    a.this.kjz.V(String.valueOf(cLb.id), cLb.aWR());
                }
                if (!TextUtils.isEmpty(cLb.linkUrl)) {
                    if (!a.this.Ji(cLb.linkUrl)) {
                        ba.aEt().a((TbPageContext) i.ab(a.this.mContext), new String[]{cLb.linkUrl}, true);
                        return;
                    }
                    final String str = cLb.linkUrl;
                    e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aEt().a((TbPageContext) i.ab(com.baidu.adp.base.a.eG().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0608a
        public void cKY() {
            if (a.this.kjz != null) {
                a.this.kjz.awM();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kjA = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kjA.a(this.kjB);
        this.kjy = new com.baidu.tieba.tbadvert.view.a(context, this.kjC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ji(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.k.a.a.checkPermissionGranted(com.baidu.adp.base.a.eG().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.kjy.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kjz = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aPr() {
        this.kjA.cLa();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
