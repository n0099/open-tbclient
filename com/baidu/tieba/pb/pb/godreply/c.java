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
    private boolean hlY;
    private boolean hlZ;
    private final a hma;
    private final com.baidu.tieba.f.b hmb;
    private a.InterfaceC0243a hmc = new a.InterfaceC0243a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0243a
        public void aR(int i, int i2) {
            if (c.this.hma.isActive() && !c.this.bJc() && c.this.hma.bIY().bJh() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hma.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
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
            if (c.this.hma.isActive() && !c.this.bJc() && !c.this.isFullscreen()) {
                c.this.nf(true);
                c.this.setFullscreen(true);
                c.this.hma.bIY().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener hmd = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hmb.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hma = aVar;
        this.hmb = new com.baidu.tieba.f.b(aVar.hlC.getPageContext().getPageActivity());
        this.hmb.a(this.hmc);
    }

    public void initialize() {
        d bIY = this.hma.bIY();
        if (bIY.bJe()) {
            bIY.getListView().setOnTouchListener(this.hmd);
        }
    }

    public boolean bJc() {
        return this.hlY;
    }

    public void nf(boolean z) {
        this.hlY = z;
    }

    public boolean isFullscreen() {
        return this.hlZ;
    }

    public void setFullscreen(boolean z) {
        this.hlZ = z;
    }
}
