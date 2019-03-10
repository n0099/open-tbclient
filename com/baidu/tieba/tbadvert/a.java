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
    private final com.baidu.tieba.tbadvert.view.a iKb;
    private b iKc;
    private Context mContext;
    private final Handler mHandler = new Handler();
    private boolean hlC = true;
    private a.InterfaceC0312a iKe = new a.InterfaceC0312a() { // from class: com.baidu.tieba.tbadvert.a.1
        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0312a
        public void a(com.baidu.tieba.tbadvert.a.a aVar) {
            if (j.kY()) {
                a.this.iKd.cfQ();
            } else if (a.this.iKc != null) {
                a.this.iKc.apM();
            }
            if (a.this.hlC) {
                a.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.tbadvert.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.kY() && j.kZ()) {
                            a.this.iKd.cfR();
                        }
                    }
                }, 800L);
            } else if (j.kY() && j.kZ()) {
                a.this.iKd.cfR();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0312a
        public void cfK() {
            if (a.this.hlC && a.this.iKc != null) {
                a.this.iKc.apM();
            }
        }

        @Override // com.baidu.tieba.tbadvert.b.a.InterfaceC0312a
        public void aA(Object obj) {
            com.baidu.tieba.tbadvert.a.b cfP;
            if (a.this.hlC && (cfP = a.this.iKd.cfP()) != null) {
                a.this.iKb.f(obj, ((int) cfP.showTime) / 1000);
                if (a.this.iKc != null) {
                    a.this.iKc.Q(String.valueOf(cfP.id), cfP.isFullScreen());
                }
            }
        }
    };
    private a.InterfaceC0313a iKf = new a.InterfaceC0313a() { // from class: com.baidu.tieba.tbadvert.a.2
        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0313a
        public void cfL() {
            com.baidu.tieba.tbadvert.a.b cfP = a.this.iKd.cfP();
            if (cfP != null) {
                if (a.this.iKc != null) {
                    a.this.iKc.pB(String.valueOf(cfP.id));
                }
                if (!TextUtils.isEmpty(cfP.linkUrl)) {
                    ba.adD().a((TbPageContext) i.aK(a.this.mContext), new String[]{cfP.linkUrl}, true);
                }
            }
        }

        @Override // com.baidu.tieba.tbadvert.view.a.InterfaceC0313a
        public void cfM() {
            if (a.this.iKc != null) {
                a.this.iKc.Vu();
            }
        }
    };
    private final com.baidu.tieba.tbadvert.b.a iKd = new com.baidu.tieba.tbadvert.b.a();

    public a(Context context) {
        this.mContext = context;
        this.iKd.a(this.iKe);
        this.iKb = new com.baidu.tieba.tbadvert.view.a(context, this.iKf);
    }

    @Override // com.baidu.tbadk.t.a
    public View getView() {
        return this.iKb.getView();
    }

    @Override // com.baidu.tbadk.t.a
    public void a(b bVar) {
        this.iKc = bVar;
    }

    @Override // com.baidu.tbadk.t.a
    public void apL() {
        this.iKd.cfO();
    }

    @Override // com.baidu.tbadk.t.a
    public void release() {
        this.hlC = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
