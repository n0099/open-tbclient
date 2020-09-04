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
/* loaded from: classes20.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a mjm;
    private b mjn;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0810a mjp = new a.InterfaceC0810a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.mjo.dyn();
            } else if (a.this.mjn != null) {
                a.this.mjn.Vl();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.mjo.dyo();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.mjo.dyo();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void dyh() {
            if (a.this.isActive && a.this.mjn != null) {
                a.this.mjn.Vl();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void aK(Object obj) {
            com.baidu.tieba.tbadvert.a.b dym;
            if (a.this.isActive && (dym = a.this.mjo.dym()) != null) {
                aq b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dvJ().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.mjm.f(obj, ((int) dym.showTime) / 1000);
                if (a.this.mjn != null) {
                    a.this.mjn.g(String.valueOf(dym.id), dym.bcy(), dym.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0811a mjq = new a.InterfaceC0811a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0811a
        public void dyi() {
            com.baidu.tieba.tbadvert.a.b dym = a.this.mjo.dym();
            if (dym != null) {
                if (a.this.mjn != null) {
                    a.this.mjn.as(String.valueOf(dym.id), dym.bcy());
                }
                if (!TextUtils.isEmpty(dym.linkUrl)) {
                    if (!a.this.Re(dym.linkUrl)) {
                        be.bju().a((TbPageContext) i.I(a.this.mContext), new String[]{dym.linkUrl}, true);
                        return;
                    }
                    final String str = dym.linkUrl;
                    e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            be.bju().a((TbPageContext) i.I(com.baidu.adp.base.a.lb().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0811a
        public void dyj() {
            if (a.this.mjn != null) {
                a.this.mjn.baQ();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a mjo = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.mjo.a(this.mjp);
        this.mjm = new com.baidu.tieba.tbadvert.view.a(context, this.mjq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Re(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.m.a.a.checkPermissionGranted(com.baidu.adp.base.a.lb().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.mjm.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.mjn = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void buU() {
        this.mjo.dyl();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
