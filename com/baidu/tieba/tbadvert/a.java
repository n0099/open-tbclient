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
    private final com.baidu.tieba.tbadvert.view.a kjt;
    private b kju;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0607a kjw = new a.InterfaceC0607a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kjv.cLa();
            } else if (a.this.kju != null) {
                a.this.kju.aPs();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kjv.cLb();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kjv.cLb();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void cKU() {
            if (a.this.isActive && a.this.kju != null) {
                a.this.kju.aPs();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0607a
        public void az(Object obj) {
            com.baidu.tieba.tbadvert.a.b cKZ;
            if (a.this.isActive && (cKZ = a.this.kjv.cKZ()) != null) {
                an b = com.baidu.tieba.r.a.b("a064", "common_fill", true, 1);
                if (i.ab(a.this.mContext) != null) {
                    c.cIs().b(i.ab(a.this.mContext).getUniqueId(), b);
                }
                a.this.kjt.e(obj, ((int) cKZ.showTime) / 1000);
                if (a.this.kju != null) {
                    a.this.kju.g(String.valueOf(cKZ.id), cKZ.aWR(), cKZ.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0608a kjx = new a.InterfaceC0608a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0608a
        public void cKV() {
            com.baidu.tieba.tbadvert.a.b cKZ = a.this.kjv.cKZ();
            if (cKZ != null) {
                if (a.this.kju != null) {
                    a.this.kju.V(String.valueOf(cKZ.id), cKZ.aWR());
                }
                if (!TextUtils.isEmpty(cKZ.linkUrl)) {
                    if (!a.this.Ji(cKZ.linkUrl)) {
                        ba.aEt().a((TbPageContext) i.ab(a.this.mContext), new String[]{cKZ.linkUrl}, true);
                        return;
                    }
                    final String str = cKZ.linkUrl;
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
        public void cKW() {
            if (a.this.kju != null) {
                a.this.kju.awM();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kjv = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kjv.a(this.kjw);
        this.kjt = new com.baidu.tieba.tbadvert.view.a(context, this.kjx);
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
        return this.kjt.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kju = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aPr() {
        this.kjv.cKY();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
