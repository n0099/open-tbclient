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
    private boolean fGo;
    private boolean fGp;
    private final a fGq;
    private final com.baidu.tieba.e.b fGr;
    private a.InterfaceC0108a fGs = new a.InterfaceC0108a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aY(int i, int i2) {
            if (c.this.fGq.isActive() && !c.this.aZQ() && c.this.fGq.aZM().aZV() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fGq.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jG(false);
                    }
                });
                c.this.jG(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void aZ(int i, int i2) {
            if (c.this.fGq.isActive() && !c.this.aZQ() && !c.this.isFullscreen()) {
                c.this.jG(true);
                c.this.setFullscreen(true);
                c.this.fGq.aZM().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jG(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0108a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener fGt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fGr.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fGq = aVar;
        this.fGr = new com.baidu.tieba.e.b(aVar.fFT.getPageContext().getPageActivity());
        this.fGr.a(this.fGs);
    }

    public void DQ() {
        d aZM = this.fGq.aZM();
        if (aZM.aZS()) {
            aZM.getListView().setOnTouchListener(this.fGt);
        }
    }

    public boolean aZQ() {
        return this.fGo;
    }

    public void jG(boolean z) {
        this.fGo = z;
    }

    public boolean isFullscreen() {
        return this.fGp;
    }

    public void setFullscreen(boolean z) {
        this.fGp = z;
    }
}
