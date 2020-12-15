package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.g.a;
/* loaded from: classes22.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private final com.baidu.tieba.g.b lDA;
    private a.InterfaceC0756a lDB = new a.InterfaceC0756a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            if (c.this.lDz.isActive() && !c.this.don() && !c.this.doo()) {
                c.this.uB(true);
                c.this.setFullscreen(true);
                c.this.lDz.doj().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uB(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            if (c.this.lDz.isActive() && !c.this.don() && c.this.lDz.doj().dot() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lDz.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uB(false);
                    }
                });
                c.this.uB(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void ck(int i, int i2) {
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void I(int i, int i2) {
        }
    };
    private View.OnTouchListener lDC = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lDA.onTouchEvent(motionEvent);
            return false;
        }
    };
    private boolean lDx;
    private boolean lDy;
    private final a lDz;

    public c(a aVar) {
        this.lDz = aVar;
        this.lDA = new com.baidu.tieba.g.b(aVar.lDb.getPageContext().getPageActivity());
        this.lDA.a(this.lDB);
    }

    public void initialize() {
        d doj = this.lDz.doj();
        if (doj.doq()) {
            doj.getListView().setOnTouchListener(this.lDC);
        }
    }

    public boolean don() {
        return this.lDx;
    }

    public void uB(boolean z) {
        this.lDx = z;
    }

    public boolean doo() {
        return this.lDy;
    }

    public void setFullscreen(boolean z) {
        this.lDy = z;
    }
}
