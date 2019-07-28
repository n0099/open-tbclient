package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean hJA;
    private final a hJB;
    private final com.baidu.tieba.f.b hJC;
    private a.InterfaceC0305a hJD = new a.InterfaceC0305a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aY(int i, int i2) {
            if (c.this.hJB.isActive() && !c.this.bTF() && c.this.hJB.bTB().bTL() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hJB.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oj(false);
                    }
                });
                c.this.oj(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void aZ(int i, int i2) {
            if (c.this.hJB.isActive() && !c.this.bTF() && !c.this.bTG()) {
                c.this.oj(true);
                c.this.setFullscreen(true);
                c.this.hJB.bTB().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oj(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0305a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener hJE = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hJC.onTouchEvent(motionEvent);
            return false;
        }
    };
    private boolean hJz;

    public c(a aVar) {
        this.hJB = aVar;
        this.hJC = new com.baidu.tieba.f.b(aVar.hJd.getPageContext().getPageActivity());
        this.hJC.a(this.hJD);
    }

    public void initialize() {
        d bTB = this.hJB.bTB();
        if (bTB.bTI()) {
            bTB.getListView().setOnTouchListener(this.hJE);
        }
    }

    public boolean bTF() {
        return this.hJz;
    }

    public void oj(boolean z) {
        this.hJz = z;
    }

    public boolean bTG() {
        return this.hJA;
    }

    public void setFullscreen(boolean z) {
        this.hJA = z;
    }
}
