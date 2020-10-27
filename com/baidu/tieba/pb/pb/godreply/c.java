package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes22.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private a.InterfaceC0705a ljA = new a.InterfaceC0705a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void H(int i, int i2) {
            if (c.this.ljy.isActive() && !c.this.dgZ() && !c.this.dha()) {
                c.this.tN(true);
                c.this.setFullscreen(true);
                c.this.ljy.dgV().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tN(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void I(int i, int i2) {
            if (c.this.ljy.isActive() && !c.this.dgZ() && c.this.ljy.dgV().dhf() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.ljy.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tN(false);
                    }
                });
                c.this.tN(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void ce(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0705a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener ljB = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.ljz.onTouchEvent(motionEvent);
            return false;
        }
    };
    private boolean ljw;
    private boolean ljx;
    private final a ljy;
    private final com.baidu.tieba.f.b ljz;

    public c(a aVar) {
        this.ljy = aVar;
        this.ljz = new com.baidu.tieba.f.b(aVar.lja.getPageContext().getPageActivity());
        this.ljz.a(this.ljA);
    }

    public void initialize() {
        d dgV = this.ljy.dgV();
        if (dgV.dhc()) {
            dgV.getListView().setOnTouchListener(this.ljB);
        }
    }

    public boolean dgZ() {
        return this.ljw;
    }

    public void tN(boolean z) {
        this.ljw = z;
    }

    public boolean dha() {
        return this.ljx;
    }

    public void setFullscreen(boolean z) {
        this.ljx = z;
    }
}
