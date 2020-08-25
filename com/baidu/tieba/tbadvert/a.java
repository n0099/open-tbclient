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
    private final com.baidu.tieba.tbadvert.view.a miX;
    private b miY;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0810a mja = new a.InterfaceC0810a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.miZ.dyi();
            } else if (a.this.miY != null) {
                a.this.miY.Vl();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.miZ.dyj();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.miZ.dyj();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void dyc() {
            if (a.this.isActive && a.this.miY != null) {
                a.this.miY.Vl();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0810a
        public void aK(Object obj) {
            com.baidu.tieba.tbadvert.a.b dyh;
            if (a.this.isActive && (dyh = a.this.miZ.dyh()) != null) {
                aq b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.I(a.this.mContext) != null) {
                    c.dvE().b(i.I(a.this.mContext).getUniqueId(), b);
                }
                a.this.miX.f(obj, ((int) dyh.showTime) / 1000);
                if (a.this.miY != null) {
                    a.this.miY.g(String.valueOf(dyh.id), dyh.bcy(), dyh.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0811a mjb = new a.InterfaceC0811a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0811a
        public void dyd() {
            com.baidu.tieba.tbadvert.a.b dyh = a.this.miZ.dyh();
            if (dyh != null) {
                if (a.this.miY != null) {
                    a.this.miY.as(String.valueOf(dyh.id), dyh.bcy());
                }
                if (!TextUtils.isEmpty(dyh.linkUrl)) {
                    if (!a.this.Re(dyh.linkUrl)) {
                        be.bju().a((TbPageContext) i.I(a.this.mContext), new String[]{dyh.linkUrl}, true);
                        return;
                    }
                    final String str = dyh.linkUrl;
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
        public void dye() {
            if (a.this.miY != null) {
                a.this.miY.baQ();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a miZ = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.miZ.a(this.mja);
        this.miX = new com.baidu.tieba.tbadvert.view.a(context, this.mjb);
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
        return this.miX.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.miY = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void buT() {
        this.miZ.dyg();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
