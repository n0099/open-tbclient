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
    private final com.baidu.tieba.tbadvert.view.a kWq;
    private b kWr;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0657a kWt = new a.InterfaceC0657a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0657a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.kWs.cXR();
            } else if (a.this.kWr != null) {
                a.this.kWr.LI();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.kWs.cXS();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.kWs.cXS();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0657a
        public void cXL() {
            if (a.this.isActive && a.this.kWr != null) {
                a.this.kWr.LI();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0657a
        public void aD(Object obj) {
            com.baidu.tieba.tbadvert.a.b cXQ;
            if (a.this.isActive && (cXQ = a.this.kWs.cXQ()) != null) {
                an b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.T(a.this.mContext) != null) {
                    c.cVr().b(i.T(a.this.mContext).getUniqueId(), b);
                }
                a.this.kWq.f(obj, ((int) cXQ.showTime) / 1000);
                if (a.this.kWr != null) {
                    a.this.kWr.g(String.valueOf(cXQ.id), cXQ.bhr(), cXQ.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0658a kWu = new a.InterfaceC0658a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0658a
        public void cXM() {
            com.baidu.tieba.tbadvert.a.b cXQ = a.this.kWs.cXQ();
            if (cXQ != null) {
                if (a.this.kWr != null) {
                    a.this.kWr.aa(String.valueOf(cXQ.id), cXQ.bhr());
                }
                if (!TextUtils.isEmpty(cXQ.linkUrl)) {
                    if (!a.this.Lf(cXQ.linkUrl)) {
                        ba.aOY().a((TbPageContext) i.T(a.this.mContext), new String[]{cXQ.linkUrl}, true);
                        return;
                    }
                    final String str = cXQ.linkUrl;
                    e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ba.aOY().a((TbPageContext) i.T(com.baidu.adp.base.a.jm().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0658a
        public void cXN() {
            if (a.this.kWr != null) {
                a.this.kWr.aHp();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a kWs = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.kWs.a(this.kWt);
        this.kWq = new com.baidu.tieba.tbadvert.view.a(context, this.kWu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Lf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.h.a.a.checkPermissionGranted(com.baidu.adp.base.a.jm().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.r.a
    public View getView() {
        return this.kWq.getView();
    }

    @Override // com.baidu.tbadk.r.a
    public void a(b bVar) {
        this.kWr = bVar;
    }

    @Override // com.baidu.tbadk.r.a
    public void aZY() {
        this.kWs.cXP();
    }

    @Override // com.baidu.tbadk.r.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
