package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes6.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);
    private boolean fRX;
    private boolean fRY;
    private final a fRZ;
    private final com.baidu.tieba.f.b fSa;
    private a.InterfaceC0214a fSb = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void aq(int i, int i2) {
            if (c.this.fRZ.isActive() && !c.this.bhp() && c.this.fRZ.bhl().bhu() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fRZ.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kC(false);
                    }
                });
                c.this.kC(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (c.this.fRZ.isActive() && !c.this.bhp() && !c.this.isFullscreen()) {
                c.this.kC(true);
                c.this.setFullscreen(true);
                c.this.fRZ.bhl().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kC(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
        }
    };
    private View.OnTouchListener fSc = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fSa.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fRZ = aVar;
        this.fSa = new com.baidu.tieba.f.b(aVar.fRB.getPageContext().getPageActivity());
        this.fSa.a(this.fSb);
    }

    public void initialize() {
        d bhl = this.fRZ.bhl();
        if (bhl.bhr()) {
            bhl.getListView().setOnTouchListener(this.fSc);
        }
    }

    public boolean bhp() {
        return this.fRX;
    }

    public void kC(boolean z) {
        this.fRX = z;
    }

    public boolean isFullscreen() {
        return this.fRY;
    }

    public void setFullscreen(boolean z) {
        this.fRY = z;
    }
}
