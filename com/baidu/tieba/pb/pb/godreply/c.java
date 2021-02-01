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
    private boolean lMM;
    private boolean lMN;
    private final a lMO;
    private final com.baidu.tieba.f.b lMP;
    private a.InterfaceC0710a lMQ = new a.InterfaceC0710a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void G(int i, int i2) {
            if (c.this.lMO.isActive() && !c.this.dms() && !c.this.dmt()) {
                c.this.uM(true);
                c.this.setFullscreen(true);
                c.this.lMO.dmo().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uM(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void H(int i, int i2) {
            if (c.this.lMO.isActive() && !c.this.dms() && c.this.lMO.dmo().dmy() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.lMO.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.uM(false);
                    }
                });
                c.this.uM(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void cg(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0710a
        public void I(int i, int i2) {
        }
    };
    private View.OnTouchListener lMR = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.lMP.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.lMO = aVar;
        this.lMP = new com.baidu.tieba.f.b(aVar.lMq.getPageContext().getPageActivity());
        this.lMP.a(this.lMQ);
    }

    public void initialize() {
        d dmo = this.lMO.dmo();
        if (dmo.dmv()) {
            dmo.getListView().setOnTouchListener(this.lMR);
        }
    }

    public boolean dms() {
        return this.lMM;
    }

    public void uM(boolean z) {
        this.lMM = z;
    }

    public boolean dmt() {
        return this.lMN;
    }

    public void setFullscreen(boolean z) {
        this.lMN = z;
    }
}
