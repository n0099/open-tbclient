package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes.dex */
public class c {
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean eJH;
    private boolean eJI;
    private final a eJJ;
    private final com.baidu.tieba.e.b eJK;
    private a.InterfaceC0081a eJL = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            if (c.this.eJJ.isActive() && !c.this.aRc() && c.this.eJJ.aQY().aRi() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.eJJ.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.iJ(false);
                    }
                });
                c.this.iJ(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            if (c.this.eJJ.isActive() && !c.this.aRc() && !c.this.aRd()) {
                c.this.iJ(true);
                c.this.setFullscreen(true);
                c.this.eJJ.aQY().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.iJ(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }
    };
    private View.OnTouchListener eJM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.eJK.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.eJJ = aVar;
        this.eJK = new com.baidu.tieba.e.b(aVar.eJm.getPageContext().getPageActivity());
        this.eJK.a(this.eJL);
    }

    public void wA() {
        d aQY = this.eJJ.aQY();
        if (aQY.aRf()) {
            aQY.getListView().setOnTouchListener(this.eJM);
        }
    }

    public boolean aRc() {
        return this.eJH;
    }

    public void iJ(boolean z) {
        this.eJH = z;
    }

    public boolean aRd() {
        return this.eJI;
    }

    public void setFullscreen(boolean z) {
        this.eJI = z;
    }
}
