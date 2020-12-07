package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.s.b;
import com.baidu.tieba.t.c;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes26.dex */
public class a implements com.baidu.tbadk.s.a {
    private Context mContext;
    private final com.baidu.tieba.tbadvert.view.a nqd;
    private b nqe;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0872a nqg = new a.InterfaceC0872a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nqf.dQT();
            } else if (a.this.nqe != null) {
                a.this.nqe.aeJ();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nqf.dQU();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nqf.dQU();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void dQN() {
            if (a.this.isActive && a.this.nqe != null) {
                a.this.nqe.aeJ();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void aR(Object obj) {
            com.baidu.tieba.tbadvert.a.b dQS;
            if (a.this.isActive && (dQS = a.this.nqf.dQS()) != null) {
                ar b = com.baidu.tieba.t.a.b("a064", "common_fill", true, 1);
                if (i.J(a.this.mContext) != null) {
                    c.dOe().b(i.J(a.this.mContext).getUniqueId(), b);
                }
                a.this.nqd.f(obj, ((int) dQS.showTime) / 1000);
                if (a.this.nqe != null) {
                    a.this.nqe.g(String.valueOf(dQS.id), dQS.bmG(), dQS.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0873a nqh = new a.InterfaceC0873a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0873a
        public void dQO() {
            com.baidu.tieba.tbadvert.a.b dQS = a.this.nqf.dQS();
            if (dQS != null) {
                if (a.this.nqe != null) {
                    a.this.nqe.az(String.valueOf(dQS.id), dQS.bmG());
                }
                if (!TextUtils.isEmpty(dQS.linkUrl)) {
                    if (!a.this.Ui(dQS.linkUrl)) {
                        bf.bua().a((TbPageContext) i.J(a.this.mContext), new String[]{dQS.linkUrl}, true);
                        return;
                    }
                    final String str = dQS.linkUrl;
                    e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            bf.bua().a((TbPageContext) i.J(com.baidu.adp.base.a.lg().currentActivity()), new String[]{str}, true);
                        }
                    }, 500L);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0873a
        public void dQP() {
            if (a.this.nqe != null) {
                a.this.nqe.blp();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nqf = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nqf.a(this.nqg);
        this.nqd = new com.baidu.tieba.tbadvert.view.a(context, this.nqh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ui(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return (str.contains("/swan/") || str.contains("/swangame/")) && !com.baidu.n.a.a.checkPermissionGranted(com.baidu.adp.base.a.lg().currentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.baidu.tbadk.s.a
    public View getView() {
        return this.nqd.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nqe = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bFU() {
        this.nqf.dQR();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
