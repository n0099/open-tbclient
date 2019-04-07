package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.t.b;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.t.a {
    private final com.baidu.tieba.tbadvert.view.a iJE;
    private b iJF;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hlk = true;
    private a.InterfaceC0393a iJH = new a.InterfaceC0393a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kY()) {
                a.this.iJG.cfO();
            } else if (a.this.iJF != null) {
                a.this.iJF.apI();
            }
            if (a.this.hlk) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kY() && j.kZ()) {
                            a.this.iJG.cfP();
                        }
                    }
                }, 800L);
            } else if (j.kY() && j.kZ()) {
                a.this.iJG.cfP();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void cfI() {
            if (a.this.hlk && a.this.iJF != null) {
                a.this.iJF.apI();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void aw(Object obj) {
            com.baidu.tieba.tbadvert.a.b cfN;
            if (a.this.hlk && (cfN = a.this.iJG.cfN()) != null) {
                a.this.iJE.f(obj, ((int) cfN.showTime) / 1000);
                if (a.this.iJF != null) {
                    a.this.iJF.Q(String.valueOf(cfN.id), cfN.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0394a iJI = new a.InterfaceC0394a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0394a
        public void cfJ() {
            com.baidu.tieba.tbadvert.a.b cfN = a.this.iJG.cfN();
            if (cfN != null) {
                if (a.this.iJF != null) {
                    a.this.iJF.pA(String.valueOf(cfN.id));
                }
                if (!TextUtils.isEmpty(cfN.linkUrl)) {
                    ba.adA().a((TbPageContext) i.aK(a.this.mContext), new String[]{cfN.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0394a
        public void cfK() {
            if (a.this.iJF != null) {
                a.this.iJF.Vr();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a iJG = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.iJG.a(this.iJH);
        this.iJE = new com.baidu.tieba.tbadvert.view.a(context, this.iJI);
    }

    @Override // com.baidu.tbadk.t.a
    public View getView() {
        return this.iJE.getView();
    }

    @Override // com.baidu.tbadk.t.a
    public void a(b bVar) {
        this.iJF = bVar;
    }

    @Override // com.baidu.tbadk.t.a
    public void apH() {
        this.iJG.cfM();
    }

    @Override // com.baidu.tbadk.t.a
    public void release() {
        this.hlk = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
