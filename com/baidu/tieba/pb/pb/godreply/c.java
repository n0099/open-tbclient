package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes9.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean jGu;
    private boolean jGv;
    private final a jGw;
    private final com.baidu.tieba.f.b jGx;
    private a.InterfaceC0607a jGy = new a.InterfaceC0607a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void B(int i, int i2) {
            if (c.this.jGw.isActive() && !c.this.cDA() && !c.this.cDB()) {
                c.this.rh(true);
                c.this.setFullscreen(true);
                c.this.jGw.cDw().y(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void C(int i, int i2) {
            if (c.this.jGw.isActive() && !c.this.cDA() && c.this.jGw.cDw().cDG() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.jGw.x(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh(false);
                    }
                });
                c.this.rh(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void bK(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0607a
        public void D(int i, int i2) {
        }
    };
    private View.OnTouchListener jGz = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.jGx.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.jGw = aVar;
        this.jGx = new com.baidu.tieba.f.b(aVar.jFY.getPageContext().getPageActivity());
        this.jGx.a(this.jGy);
    }

    public void initialize() {
        d cDw = this.jGw.cDw();
        if (cDw.cDD()) {
            cDw.getListView().setOnTouchListener(this.jGz);
        }
    }

    public boolean cDA() {
        return this.jGu;
    }

    public void rh(boolean z) {
        this.jGu = z;
    }

    public boolean cDB() {
        return this.jGv;
    }

    public void setFullscreen(boolean z) {
        this.jGv = z;
    }
}
