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
    private boolean lID;
    private boolean lIE;
    private final a lIF;
    private final com.baidu.tieba.f.b lIG;
    private a.InterfaceC0727a lIH = new a.InterfaceC0727a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void G(int i, int i2) {
            if (c.this.lIF.isActive() && !c.this.dnX() && !c.this.dnY()) {
                c.this.uC(true);
                c.this.setFullscreen(true);
                c.this.lIF.dnT().t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uC(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0727a
        public void H(int i, int i2) {
            if (c.this.lIF.isActive() && !c.this.dnX() && c.this.lIF.dnT().dod() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lIF.s(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener lII = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lIG.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lIF = aVar;
        this.lIG = new com.baidu.tieba.f.b(aVar.lIh.getPageContext().getPageActivity());
        this.lIG.a(this.lIH);
    }

    public void initialize() {
        d dnT = this.lIF.dnT();
        if (dnT.doa()) {
            dnT.getListView().setOnTouchListener(this.lII);
        }
    }

    public boolean dnX() {
        return this.lID;
    }

    public void uC(boolean z) {
        this.lID = z;
    }

    public boolean dnY() {
        return this.lIE;
    }

    public void setFullscreen(boolean z) {
        this.lIE = z;
    }
}
