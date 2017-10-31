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
    private boolean eJn;
    private boolean eJo;
    private final a eJp;
    private final com.baidu.tieba.e.b eJq;
    private a.InterfaceC0081a eJr = new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ag(int i, int i2) {
            if (c.this.eJp.isActive() && !c.this.aQU() && c.this.eJp.aQQ().aRa() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.eJp.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.iD(false);
                    }
                });
                c.this.iD(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ah(int i, int i2) {
            if (c.this.eJp.isActive() && !c.this.aQU() && !c.this.aQV()) {
                c.this.iD(true);
                c.this.setFullscreen(true);
                c.this.eJp.aQQ().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.iD(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0081a
        public void ai(int i, int i2) {
        }
    };
    private View.OnTouchListener eJs = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.eJq.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.eJp = aVar;
        this.eJq = new com.baidu.tieba.e.b(aVar.eIS.getPageContext().getPageActivity());
        this.eJq.a(this.eJr);
    }

    public void wA() {
        d aQQ = this.eJp.aQQ();
        if (aQQ.aQX()) {
            aQQ.getListView().setOnTouchListener(this.eJs);
        }
    }

    public boolean aQU() {
        return this.eJn;
    }

    public void iD(boolean z) {
        this.eJn = z;
    }

    public boolean aQV() {
        return this.eJo;
    }

    public void setFullscreen(boolean z) {
        this.eJo = z;
    }
}
