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
    private boolean jpL;
    private boolean jpM;
    private final a jpN;
    private final com.baidu.tieba.f.b jpO;
    private a.InterfaceC0557a jpP = new a.InterfaceC0557a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void y(int i, int i2) {
            if (c.this.jpN.isActive() && !c.this.cwC() && !c.this.cwD()) {
                c.this.qJ(true);
                c.this.setFullscreen(true);
                c.this.jpN.cwy().w(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qJ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void z(int i, int i2) {
            if (c.this.jpN.isActive() && !c.this.cwC() && c.this.jpN.cwy().cwI() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.jpN.v(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.qJ(false);
                    }
                });
                c.this.qJ(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void bG(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0557a
        public void A(int i, int i2) {
        }
    };
    private View.OnTouchListener jpQ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.jpO.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.jpN = aVar;
        this.jpO = new com.baidu.tieba.f.b(aVar.jpp.getPageContext().getPageActivity());
        this.jpO.a(this.jpP);
    }

    public void initialize() {
        d cwy = this.jpN.cwy();
        if (cwy.cwF()) {
            cwy.getListView().setOnTouchListener(this.jpQ);
        }
    }

    public boolean cwC() {
        return this.jpL;
    }

    public void qJ(boolean z) {
        this.jpL = z;
    }

    public boolean cwD() {
        return this.jpM;
    }

    public void setFullscreen(boolean z) {
        this.jpM = z;
    }
}
