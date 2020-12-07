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
    private boolean lDv;
    private boolean lDw;
    private final a lDx;
    private final com.baidu.tieba.g.b lDy;
    private a.InterfaceC0756a lDz = new a.InterfaceC0756a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void G(int i, int i2) {
            if (c.this.lDx.isActive() && !c.this.dom() && !c.this.don()) {
                c.this.uB(true);
                c.this.setFullscreen(true);
                c.this.lDx.doi().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uB(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.g.a.InterfaceC0756a
        public void H(int i, int i2) {
            if (c.this.lDx.isActive() && !c.this.dom() && c.this.lDx.doi().dos() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lDx.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener lDA = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lDy.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lDx = aVar;
        this.lDy = new com.baidu.tieba.g.b(aVar.lCZ.getPageContext().getPageActivity());
        this.lDy.a(this.lDz);
    }

    public void initialize() {
        d doi = this.lDx.doi();
        if (doi.dop()) {
            doi.getListView().setOnTouchListener(this.lDA);
        }
    }

    public boolean dom() {
        return this.lDv;
    }

    public void uB(boolean z) {
        this.lDv = z;
    }

    public boolean don() {
        return this.lDw;
    }

    public void setFullscreen(boolean z) {
        this.lDw = z;
    }
}
