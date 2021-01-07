package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean lIC;
    private boolean lID;
    private final a lIE;
    private final com.baidu.tieba.f.b lIF;
    private a.InterfaceC0727a lIG = new a.InterfaceC0727a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            if (c.this.lIE.isActive() && !c.this.dnY() && !c.this.dnZ()) {
                c.this.uC(true);
                c.this.setFullscreen(true);
                c.this.lIE.dnU().t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uC(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            if (c.this.lIE.isActive() && !c.this.dnY() && c.this.lIE.dnU().doe() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lIE.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uC(false);
                    }
                });
                c.this.uC(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void cj(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void I(int i, int i2) {
        }
    };
    private View.OnTouchListener lIH = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lIF.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lIE = aVar;
        this.lIF = new com.baidu.tieba.f.b(aVar.lIg.getPageContext().getPageActivity());
        this.lIF.a(this.lIG);
    }

    public void initialize() {
        d dnU = this.lIE.dnU();
        if (dnU.dob()) {
            dnU.getListView().setOnTouchListener(this.lIH);
        }
    }

    public boolean dnY() {
        return this.lIC;
    }

    public void uC(boolean z) {
        this.lIC = z;
    }

    public boolean dnZ() {
        return this.lID;
    }

    public void setFullscreen(boolean z) {
        this.lID = z;
    }
}
