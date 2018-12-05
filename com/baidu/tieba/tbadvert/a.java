package com.baidu.tieba.tbadvert;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.q.b;
import com.baidu.tieba.tbadvert.b.a;
import com.baidu.tieba.tbadvert.view.a;
/* loaded from: classes3.dex */
public class a implements com.baidu.tbadk.q.a {
    private final com.baidu.tieba.tbadvert.view.a hoW;
    private b hoX;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean fRA = true;
    private a.InterfaceC0320a hoZ = new a.InterfaceC0320a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kV()) {
                a.this.hoY.bER();
            } else if (a.this.hoX != null) {
                a.this.hoX.PG();
            }
            if (a.this.fRA) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kV() && j.kW()) {
                            a.this.hoY.bES();
                        }
                    }
                }, 800L);
            } else if (j.kV() && j.kW()) {
                a.this.hoY.bES();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void bEL() {
            if (a.this.fRA && a.this.hoX != null) {
                a.this.hoX.PG();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0320a
        public void ak(Object obj) {
            com.baidu.tieba.tbadvert.a.b bEQ;
            if (a.this.fRA && (bEQ = a.this.hoY.bEQ()) != null) {
                a.this.hoW.f(obj, ((int) bEQ.showTime) / 1000);
                if (a.this.hoX != null) {
                    a.this.hoX.w(String.valueOf(bEQ.id), bEQ.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0321a hpa = new a.InterfaceC0321a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0321a
        public void bEM() {
            com.baidu.tieba.tbadvert.a.b bEQ = a.this.hoY.bEQ();
            if (bEQ != null) {
                if (a.this.hoX != null) {
                    a.this.hoX.iw(String.valueOf(bEQ.id));
                }
                if (!TextUtils.isEmpty(bEQ.linkUrl)) {
                    ay.Ef().a((TbPageContext) i.aK(a.this.mContext), new String[]{bEQ.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0321a
        public void bEN() {
            if (a.this.hoX != null) {
                a.this.hoX.wH();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a hoY = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.hoY.a(this.hoZ);
        this.hoW = new com.baidu.tieba.tbadvert.view.a(context, this.hpa);
    }

    @Override // com.baidu.tbadk.q.a
    public View getView() {
        return this.hoW.getView();
    }

    @Override // com.baidu.tbadk.q.a
    public void a(b bVar) {
        this.hoX = bVar;
    }

    @Override // com.baidu.tbadk.q.a
    public void PF() {
        this.hoY.bEP();
    }

    @Override // com.baidu.tbadk.q.a
    public void release() {
        this.fRA = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
