package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean hlZ;
    private boolean hma;
    private final a hmb;
    private final com.baidu.tieba.f.b hmc;
    private a.InterfaceC0243a hmd = new a.InterfaceC0243a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
            if (c.this.hmb.isActive() && !c.this.bJd() && c.this.hmb.bIZ().bJi() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hmb.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nf(false);
                    }
                });
                c.this.nf(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aS(int i, int i2) {
            if (c.this.hmb.isActive() && !c.this.bJd() && !c.this.isFullscreen()) {
                c.this.nf(true);
                c.this.setFullscreen(true);
                c.this.hmb.bIZ().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nf(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aT(int i, int i2) {
        }
    };
    private View.OnTouchListener hme = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hmc.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hmb = aVar;
        this.hmc = new com.baidu.tieba.f.b(aVar.hlD.getPageContext().getPageActivity());
        this.hmc.a(this.hmd);
    }

    public void initialize() {
        d bIZ = this.hmb.bIZ();
        if (bIZ.bJf()) {
            bIZ.getListView().setOnTouchListener(this.hme);
        }
    }

    public boolean bJd() {
        return this.hlZ;
    }

    public void nf(boolean z) {
        this.hlZ = z;
    }

    public boolean isFullscreen() {
        return this.hma;
    }

    public void setFullscreen(boolean z) {
        this.hma = z;
    }
}
