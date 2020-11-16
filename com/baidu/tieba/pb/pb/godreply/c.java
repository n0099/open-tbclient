package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.g.a;
/* loaded from: classes21.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean lpM;
    private boolean lpN;
    private final a lpO;
    private final com.baidu.tieba.g.b lpP;
    private a.InterfaceC0740a lpQ = new a.InterfaceC0740a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void H(int i, int i2) {
            if (c.this.lpO.isActive() && !c.this.diX() && !c.this.diY()) {
                c.this.tZ(true);
                c.this.setFullscreen(true);
                c.this.lpO.diT().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tZ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void I(int i, int i2) {
            if (c.this.lpO.isActive() && !c.this.diX() && c.this.lpO.diT().djd() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lpO.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tZ(false);
                    }
                });
                c.this.tZ(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0740a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener lpR = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lpP.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lpO = aVar;
        this.lpP = new com.baidu.tieba.g.b(aVar.lpq.getPageContext().getPageActivity());
        this.lpP.a(this.lpQ);
    }

    public void initialize() {
        d diT = this.lpO.diT();
        if (diT.dja()) {
            diT.getListView().setOnTouchListener(this.lpR);
        }
    }

    public boolean diX() {
        return this.lpM;
    }

    public void tZ(boolean z) {
        this.lpM = z;
    }

    public boolean diY() {
        return this.lpN;
    }

    public void setFullscreen(boolean z) {
        this.lpN = z;
    }
}
