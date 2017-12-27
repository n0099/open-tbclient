package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.s(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean fEO;
    private boolean fEP;
    private final a fEQ;
    private final com.baidu.tieba.e.b fER;
    private a.InterfaceC0109a fES = new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (c.this.fEQ.isActive() && !c.this.aZM() && c.this.fEQ.aZI().aZR() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fEQ.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jD(false);
                    }
                });
                c.this.jD(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (c.this.fEQ.isActive() && !c.this.aZM() && !c.this.isFullscreen()) {
                c.this.jD(true);
                c.this.setFullscreen(true);
                c.this.fEQ.aZI().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jD(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener fET = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fER.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fEQ = aVar;
        this.fER = new com.baidu.tieba.e.b(aVar.fEt.getPageContext().getPageActivity());
        this.fER.a(this.fES);
    }

    public void DZ() {
        d aZI = this.fEQ.aZI();
        if (aZI.aZO()) {
            aZI.getListView().setOnTouchListener(this.fET);
        }
    }

    public boolean aZM() {
        return this.fEO;
    }

    public void jD(boolean z) {
        this.fEO = z;
    }

    public boolean isFullscreen() {
        return this.fEP;
    }

    public void setFullscreen(boolean z) {
        this.fEP = z;
    }
}
