package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.t(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean fJV;
    private boolean fJW;
    private final a fJX;
    private final com.baidu.tieba.e.b fJY;
    private a.InterfaceC0143a fJZ = new a.InterfaceC0143a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aY(int i, int i2) {
            if (c.this.fJX.isActive() && !c.this.bbB() && c.this.fJX.bbx().bbG() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fJX.j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jS(false);
                    }
                });
                c.this.jS(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void aZ(int i, int i2) {
            if (c.this.fJX.isActive() && !c.this.bbB() && !c.this.isFullscreen()) {
                c.this.jS(true);
                c.this.setFullscreen(true);
                c.this.fJX.bbx().k(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jS(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.e.a.InterfaceC0143a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener fKa = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fJY.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fJX = aVar;
        this.fJY = new com.baidu.tieba.e.b(aVar.fJA.getPageContext().getPageActivity());
        this.fJY.a(this.fJZ);
    }

    public void El() {
        d bbx = this.fJX.bbx();
        if (bbx.bbD()) {
            bbx.getListView().setOnTouchListener(this.fKa);
        }
    }

    public boolean bbB() {
        return this.fJV;
    }

    public void jS(boolean z) {
        this.fJV = z;
    }

    public boolean isFullscreen() {
        return this.fJW;
    }

    public void setFullscreen(boolean z) {
        this.fJW = z;
    }
}
