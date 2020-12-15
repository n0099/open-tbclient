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
    private final com.baidu.tieba.tbadvert.view.a nqf;
    private b nqg;
    private final Handler mHandler = new Handler();
    private boolean isActive = true;
    private a.InterfaceC0872a nqi = new a.InterfaceC0872a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.isNetWorkAvailable()) {
                a.this.nqh.dQU();
            } else if (a.this.nqg != null) {
                a.this.nqg.aeJ();
            }
            if (a.this.isActive) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.isNetWorkAvailable() && j.isWifiNet()) {
                            a.this.nqh.dQV();
                        }
                    }
                }, 800L);
            } else if (j.isNetWorkAvailable() && j.isWifiNet()) {
                a.this.nqh.dQV();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void dQO() {
            if (a.this.isActive && a.this.nqg != null) {
                a.this.nqg.aeJ();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0872a
        public void aR(Object obj) {
            com.baidu.tieba.tbadvert.a.b dQT;
            if (a.this.isActive && (dQT = a.this.nqh.dQT()) != null) {
                ar b = com.baidu.tieba.t.a.b("a064", "common_fill", true, 1);
                if (i.J(a.this.mContext) != null) {
                    c.dOf().b(i.J(a.this.mContext).getUniqueId(), b);
                }
                a.this.nqf.f(obj, ((int) dQT.showTime) / 1000);
                if (a.this.nqg != null) {
                    a.this.nqg.g(String.valueOf(dQT.id), dQT.bmG(), dQT.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0873a nqj = new a.InterfaceC0873a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0873a
        public void dQP() {
            com.baidu.tieba.tbadvert.a.b dQT = a.this.nqh.dQT();
            if (dQT != null) {
                if (a.this.nqg != null) {
                    a.this.nqg.az(String.valueOf(dQT.id), dQT.bmG());
                }
                if (!TextUtils.isEmpty(dQT.linkUrl)) {
                    if (!a.this.Ui(dQT.linkUrl)) {
                        bf.bua().a((TbPageContext) i.J(a.this.mContext), new String[]{dQT.linkUrl}, true);
                        return;
                    }
                    final String str = dQT.linkUrl;
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
        public void dQQ() {
            if (a.this.nqg != null) {
                a.this.nqg.blp();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a nqh = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.nqh.a(this.nqi);
        this.nqf = new com.baidu.tieba.tbadvert.view.a(context, this.nqj);
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
        return this.nqf.getView();
    }

    @Override // com.baidu.tbadk.s.a
    public void a(b bVar) {
        this.nqg = bVar;
    }

    @Override // com.baidu.tbadk.s.a
    public void bFU() {
        this.nqh.dQS();
    }

    @Override // com.baidu.tbadk.s.a
    public void release() {
        this.isActive = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
