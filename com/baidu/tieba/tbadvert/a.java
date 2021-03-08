package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes7.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nDL;
    private b nDM;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0883a nDO = new a.InterfaceC0883a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0883a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nDN.dPQ();
            } else if (a.this.nDM != null) {
                a.this.nDM.bEV();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nDN.dPR();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nDN.dPR();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0883a
        public void dPK() {
            if (a.this.isActive && a.this.nDM != null) {
                a.this.nDM.bEV();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0883a
        public void aU(Object obj) {
            com.baidu.tieba.tbadvert.a.b dPP;
            if (a.this.isActive && (dPP = a.this.nDN.dPP()) != null) {
                ar b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (com.baidu.adp.base.j.J(a.this.mContext) != null) {
                    c.dMH().b(com.baidu.adp.base.j.J(a.this.mContext).getUniqueId(), b);
                }
                a.this.nDL.d(obj, ((int) dPP.showTime) / 1000);
                if (a.this.nDM != null) {
                    a.this.nDM.g(String.valueOf(dPP.id), dPP.isVideoAd(), dPP.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0884a nDP = new a.InterfaceC0884a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0884a
        public void dPL() {
            com.baidu.tieba.tbadvert.a.b dPP = a.this.nDN.dPP();
            if (dPP != null) {
                if (a.this.nDM != null) {
                    a.this.nDM.ay(String.valueOf(dPP.id), dPP.isVideoAd());
                }
                if (!TextUtils.isEmpty(dPP.linkUrl)) {
                    if (!a.this.Ud(dPP.linkUrl)) {
                        bf.bsY().a((TbPageContext) com.baidu.adp.base.j.J(a.this.mContext), new String[]{dPP.linkUrl}, true);
                        return;
                    }
                    final String str = dPP.linkUrl;
                    e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bf.bsY().a((TbPageContext) com.baidu.adp.base.j.J(com.baidu.adp.base.b.kB().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0884a
        public void dPM() {
            if (a.this.nDM != null) {
                a.this.nDM.onAdDismiss();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nDN = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nDN.a(this.nDO);
        this.nDL = new com.baidu.tieba.tbadvert.view.a(context, this.nDP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ud(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.l.a.a.checkPermissionGranted(com.baidu.adp.base.b.kB().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nDL.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nDM = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bEU() {
        this.nDN.dPO();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
