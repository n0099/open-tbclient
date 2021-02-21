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
/* loaded from: classes8.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nBG;
    private b nBH;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0877a nBJ = new a.InterfaceC0877a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0877a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nBI.dPH();
            } else if (a.this.nBH != null) {
                a.this.nBH.bER();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nBI.dPI();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nBI.dPI();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0877a
        public void dPB() {
            if (a.this.isActive && a.this.nBH != null) {
                a.this.nBH.bER();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0877a
        public void aS(Object obj) {
            com.baidu.tieba.tbadvert.a.b dPG;
            if (a.this.isActive && (dPG = a.this.nBI.dPG()) != null) {
                ar b2 = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (com.baidu.adp.base.j.K(a.this.mContext) != null) {
                    c.dMz().b(com.baidu.adp.base.j.K(a.this.mContext).getUniqueId(), b2);
                }
                a.this.nBG.e(obj, ((int) dPG.showTime) / 1000);
                if (a.this.nBH != null) {
                    a.this.nBH.g(String.valueOf(dPG.id), dPG.isVideoAd(), dPG.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0878a nBK = new a.InterfaceC0878a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0878a
        public void dPC() {
            com.baidu.tieba.tbadvert.a.b dPG = a.this.nBI.dPG();
            if (dPG != null) {
                if (a.this.nBH != null) {
                    a.this.nBH.ay(String.valueOf(dPG.id), dPG.isVideoAd());
                }
                if (!TextUtils.isEmpty(dPG.linkUrl)) {
                    if (!a.this.TW(dPG.linkUrl)) {
                        bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(a.this.mContext), new String[]{dPG.linkUrl}, true);
                        return;
                    }
                    final String str = dPG.linkUrl;
                    e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bf.bsV().a((TbPageContext) com.baidu.adp.base.j.K(com.baidu.adp.base.b.kB().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0878a
        public void dPD() {
            if (a.this.nBH != null) {
                a.this.nBH.onAdDismiss();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nBI = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nBI.a(this.nBJ);
        this.nBG = new com.baidu.tieba.tbadvert.view.a(context, this.nBK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean TW(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.l.a.a.checkPermissionGranted(com.baidu.adp.base.b.kB().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nBG.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nBH = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bEQ() {
        this.nBI.dPF();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
