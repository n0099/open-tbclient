package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.s.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes20.dex */
public class a implements com.baidu.tbadk.s.a {
    private final com.baidu.tieba.tbadvert.view.a lRk;
    private b lRl;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0758a lRn = new a.InterfaceC0758a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.lRm.dmM();
            } else if (a.this.lRl != null) {
                a.this.lRl.Pp();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.lRm.dmN();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.lRm.dmN();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void dmG() {
            if (a.this.isActive && a.this.lRl != null) {
                a.this.lRl.Pp();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void aI(Object obj) {
            com.baidu.tieba.tbadvert.a.b dmL;
            if (a.this.isActive && (dmL = a.this.lRm.dmL()) != null) {
                ap b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.G(a.this.mContext) != null) {
                    c.dkh().b(i.G(a.this.mContext).getUniqueId(), b);
                }
                a.this.lRk.f(obj, ((int) dmL.showTime) / 1000);
                if (a.this.lRl != null) {
                    a.this.lRl.g(String.valueOf(dmL.id), dmL.btf(), dmL.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0759a lRo = new a.InterfaceC0759a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0759a
        public void dmH() {
            com.baidu.tieba.tbadvert.a.b dmL = a.this.lRm.dmL();
            if (dmL != null) {
                if (a.this.lRl != null) {
                    a.this.lRl.ao(String.valueOf(dmL.id), dmL.btf());
                }
                if (!TextUtils.isEmpty(dmL.linkUrl)) {
                    if (!a.this.Og(dmL.linkUrl)) {
                        bd.baV().a((TbPageContext) i.G(a.this.mContext), new String[]{dmL.linkUrl}, true);
                        return;
                    }
                    final String str = dmL.linkUrl;
                    e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bd.baV().a((TbPageContext) i.G(com.baidu.adp.base.a.jC().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0759a
        public void dmI() {
            if (a.this.lRl != null) {
                a.this.lRl.aSz();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a lRm = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.lRm.a(this.lRn);
        this.lRk = new com.baidu.tieba.tbadvert.view.a(context, this.lRo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Og(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.i.a.a.checkPermissionGranted(com.baidu.adp.base.a.jC().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.lRk.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.lRl = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bmg() {
        this.lRm.dmK();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
