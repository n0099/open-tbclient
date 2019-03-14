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
    private final com.baidu.tieba.tbadvert.view.a iJT;
    private b iJU;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hlx = true;
    private a.InterfaceC0393a iJW = new a.InterfaceC0393a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kY()) {
                a.this.iJV.cfS();
            } else if (a.this.iJU != null) {
                a.this.iJU.apL();
            }
            if (a.this.hlx) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kY() && j.kZ()) {
                            a.this.iJV.cfT();
                        }
                    }
                }, 800L);
            } else if (j.kY() && j.kZ()) {
                a.this.iJV.cfT();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void cfM() {
            if (a.this.hlx && a.this.iJU != null) {
                a.this.iJU.apL();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0393a
        public void aA(Object obj) {
            com.baidu.tieba.tbadvert.a.b cfR;
            if (a.this.hlx && (cfR = a.this.iJV.cfR()) != null) {
                a.this.iJT.f(obj, ((int) cfR.showTime) / 1000);
                if (a.this.iJU != null) {
                    a.this.iJU.Q(String.valueOf(cfR.id), cfR.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0394a iJX = new a.InterfaceC0394a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0394a
        public void cfN() {
            com.baidu.tieba.tbadvert.a.b cfR = a.this.iJV.cfR();
            if (cfR != null) {
                if (a.this.iJU != null) {
                    a.this.iJU.pz(String.valueOf(cfR.id));
                }
                if (!TextUtils.isEmpty(cfR.linkUrl)) {
                    ba.adD().a((TbPageContext) i.aK(a.this.mContext), new String[]{cfR.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0394a
        public void cfO() {
            if (a.this.iJU != null) {
                a.this.iJU.Vu();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a iJV = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.iJV.a(this.iJW);
        this.iJT = new com.baidu.tieba.tbadvert.view.a(context, this.iJX);
    }

    @Override // com.baidu.tbadk.t.a
    public View getView() {
        return this.iJT.getView();
    }

    @Override // com.baidu.tbadk.t.a
    public void a(b bVar) {
        this.iJU = bVar;
    }

    @Override // com.baidu.tbadk.t.a
    public void apK() {
        this.iJV.cfQ();
    }

    @Override // com.baidu.tbadk.t.a
    public void release() {
        this.hlx = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
