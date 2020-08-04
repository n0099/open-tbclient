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
    private final com.baidu.tieba.tbadvert.view.a lRm;
    private b lRn;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0758a lRp = new a.InterfaceC0758a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.lRo.dmN();
            } else if (a.this.lRn != null) {
                a.this.lRn.Pp();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.lRo.dmO();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.lRo.dmO();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void dmH() {
            if (a.this.isActive && a.this.lRn != null) {
                a.this.lRn.Pp();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0758a
        public void aI(Object obj) {
            com.baidu.tieba.tbadvert.a.b dmM;
            if (a.this.isActive && (dmM = a.this.lRo.dmM()) != null) {
                ap b = com.baidu.tieba.s.a.b("a064", "common_fill", true, 1);
                if (i.G(a.this.mContext) != null) {
                    c.dkh().b(i.G(a.this.mContext).getUniqueId(), b);
                }
                a.this.lRm.f(obj, ((int) dmM.showTime) / 1000);
                if (a.this.lRn != null) {
                    a.this.lRn.g(String.valueOf(dmM.id), dmM.btf(), dmM.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0759a lRq = new a.InterfaceC0759a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0759a
        public void dmI() {
            com.baidu.tieba.tbadvert.a.b dmM = a.this.lRo.dmM();
            if (dmM != null) {
                if (a.this.lRn != null) {
                    a.this.lRn.ao(String.valueOf(dmM.id), dmM.btf());
                }
                if (!TextUtils.isEmpty(dmM.linkUrl)) {
                    if (!a.this.Og(dmM.linkUrl)) {
                        bd.baV().a((TbPageContext) i.G(a.this.mContext), new String[]{dmM.linkUrl}, true);
                        return;
                    }
                    final String str = dmM.linkUrl;
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
        public void dmJ() {
            if (a.this.lRn != null) {
                a.this.lRn.aSz();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a lRo = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.lRo.a(this.lRp);
        this.lRm = new com.baidu.tieba.tbadvert.view.a(context, this.lRq);
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
        return this.lRm.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.lRn = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bmg() {
        this.lRo.dmL();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
