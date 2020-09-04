package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes16.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean kzp;
    private boolean kzq;
    private final a kzr;
    private final com.baidu.tieba.f.b kzs;
    private a.InterfaceC0674a kzt = new a.InterfaceC0674a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void H(int i, int i2) {
            if (c.this.kzr.isActive() && !c.this.cWG() && !c.this.cWH()) {
                c.this.sI(true);
                c.this.setFullscreen(true);
                c.this.kzr.cWC().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sI(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void I(int i, int i2) {
            if (c.this.kzr.isActive() && !c.this.cWG() && c.this.kzr.cWC().cWM() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kzr.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.sI(false);
                    }
                });
                c.this.sI(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void bZ(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0674a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener kzu = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kzs.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kzr = aVar;
        this.kzs = new com.baidu.tieba.f.b(aVar.kyT.getPageContext().getPageActivity());
        this.kzs.a(this.kzt);
    }

    public void initialize() {
        d cWC = this.kzr.cWC();
        if (cWC.cWJ()) {
            cWC.getListView().setOnTouchListener(this.kzu);
        }
    }

    public boolean cWG() {
        return this.kzp;
    }

    public void sI(boolean z) {
        this.kzp = z;
    }

    public boolean cWH() {
        return this.kzq;
    }

    public void setFullscreen(boolean z) {
        this.kzq = z;
    }
}
