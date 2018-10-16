package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes6.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds20);
    private boolean fJH;
    private boolean fJI;
    private final a fJJ;
    private final com.baidu.tieba.f.b fJK;
    private a.InterfaceC0179a fJL = new a.InterfaceC0179a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void af(int i, int i2) {
            if (c.this.fJJ.isActive() && !c.this.bgc() && c.this.fJJ.bfY().bgh() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fJJ.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ko(false);
                    }
                });
                c.this.ko(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ag(int i, int i2) {
            if (c.this.fJJ.isActive() && !c.this.bgc() && !c.this.isFullscreen()) {
                c.this.ko(true);
                c.this.setFullscreen(true);
                c.this.fJJ.bfY().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ko(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0179a
        public void ah(int i, int i2) {
        }
    };
    private View.OnTouchListener fJM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fJK.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fJJ = aVar;
        this.fJK = new com.baidu.tieba.f.b(aVar.fJl.getPageContext().getPageActivity());
        this.fJK.a(this.fJL);
    }

    public void initialize() {
        d bfY = this.fJJ.bfY();
        if (bfY.bge()) {
            bfY.getListView().setOnTouchListener(this.fJM);
        }
    }

    public boolean bgc() {
        return this.fJH;
    }

    public void ko(boolean z) {
        this.fJH = z;
    }

    public boolean isFullscreen() {
        return this.fJI;
    }

    public void setFullscreen(boolean z) {
        this.fJI = z;
    }
}
