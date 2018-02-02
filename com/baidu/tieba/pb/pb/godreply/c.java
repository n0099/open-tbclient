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
    private boolean fGJ;
    private boolean fGK;
    private final a fGL;
    private final com.baidu.tieba.e.b fGM;
    private a.InterfaceC0109a fGN = new a.InterfaceC0109a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aY(int i, int i2) {
            if (c.this.fGL.isActive() && !c.this.aZV() && c.this.fGL.aZR().baa() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fGL.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jJ(false);
                    }
                });
                c.this.jJ(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void aZ(int i, int i2) {
            if (c.this.fGL.isActive() && !c.this.aZV() && !c.this.isFullscreen()) {
                c.this.jJ(true);
                c.this.setFullscreen(true);
                c.this.fGL.aZR().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jJ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0109a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener fGO = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fGM.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fGL = aVar;
        this.fGM = new com.baidu.tieba.e.b(aVar.fGo.getPageContext().getPageActivity());
        this.fGM.a(this.fGN);
    }

    public void DS() {
        d aZR = this.fGL.aZR();
        if (aZR.aZX()) {
            aZR.getListView().setOnTouchListener(this.fGO);
        }
    }

    public boolean aZV() {
        return this.fGJ;
    }

    public void jJ(boolean z) {
        this.fGJ = z;
    }

    public boolean isFullscreen() {
        return this.fGK;
    }

    public void setFullscreen(boolean z) {
        this.fGK = z;
    }
}
