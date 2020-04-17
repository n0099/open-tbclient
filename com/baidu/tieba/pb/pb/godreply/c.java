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
    private boolean jpH;
    private boolean jpI;
    private final a jpJ;
    private final com.baidu.tieba.f.b jpK;
    private a.InterfaceC0536a jpL = new a.InterfaceC0536a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void y(int i, int i2) {
            if (c.this.jpJ.isActive() && !c.this.cwF() && !c.this.cwG()) {
                c.this.qJ(true);
                c.this.setFullscreen(true);
                c.this.jpJ.cwB().w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qJ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void z(int i, int i2) {
            if (c.this.jpJ.isActive() && !c.this.cwF() && c.this.jpJ.cwB().cwL() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.jpJ.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qJ(false);
                    }
                });
                c.this.qJ(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0536a
        public void A(int i, int i2) {
        }
    };
    private View.OnTouchListener jpM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.jpK.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.jpJ = aVar;
        this.jpK = new com.baidu.tieba.f.b(aVar.jpl.getPageContext().getPageActivity());
        this.jpK.a(this.jpL);
    }

    public void initialize() {
        d cwB = this.jpJ.cwB();
        if (cwB.cwI()) {
            cwB.getListView().setOnTouchListener(this.jpM);
        }
    }

    public boolean cwF() {
        return this.jpH;
    }

    public void qJ(boolean z) {
        this.jpH = z;
    }

    public boolean cwG() {
        return this.jpI;
    }

    public void setFullscreen(boolean z) {
        this.jpI = z;
    }
}
