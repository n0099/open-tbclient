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
    private final com.baidu.tieba.tbadvert.view.a mIu;
    private b mIv;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0825a mIx = new a.InterfaceC0825a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0825a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.mIw.dFS();
            } else if (a.this.mIv != null) {
                a.this.mIv.XR();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.mIw.dFT();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.mIw.dFT();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0825a
        public void dFM() {
            if (a.this.isActive && a.this.mIv != null) {
                a.this.mIv.XR();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0825a
        public void aP(Object obj) {
            com.baidu.tieba.tbadvert.a.b dFR;
            if (a.this.isActive && (dFR = a.this.mIw.dFR()) != null) {
                aq b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dDn().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.mIu.f(obj, ((int) dFR.showTime) / 1000);
                if (a.this.mIv != null) {
                    a.this.mIv.g(String.valueOf(dFR.id), dFR.bgb(), dFR.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0826a mIy = new a.InterfaceC0826a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0826a
        public void dFN() {
            com.baidu.tieba.tbadvert.a.b dFR = a.this.mIw.dFR();
            if (dFR != null) {
                if (a.this.mIv != null) {
                    a.this.mIv.aw(String.valueOf(dFR.id), dFR.bgb());
                }
                if (!TextUtils.isEmpty(dFR.linkUrl)) {
                    if (!a.this.Ss(dFR.linkUrl)) {
                        be.bmY().a((TbPageContext) i.I(a.this.mContext), new String[]{dFR.linkUrl}, true);
                        return;
                    }
                    final String str = dFR.linkUrl;
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.bmY().a((TbPageContext) i.I(com.baidu.adp.base.a.lg().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0826a
        public void dFO() {
            if (a.this.mIv != null) {
                a.this.mIv.bes();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a mIw = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.mIw.a(this.mIx);
        this.mIu = new com.baidu.tieba.tbadvert.view.a(context, this.mIy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ss(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.m.a.a.checkPermissionGranted(com.baidu.adp.base.a.lg().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.mIu.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.mIv = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void byI() {
        this.mIw.dFQ();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
