package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
/* loaded from: classes2.dex */
public class c {
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean fuk;
    private boolean ful;
    private final a fum;
    private final com.baidu.tieba.f.b fun;
    private a.InterfaceC0147a fuo = new a.InterfaceC0147a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void W(int i, int i2) {
            if (c.this.fum.isActive() && !c.this.bcc() && c.this.fum.bbY().bch() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fum.h(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jK(false);
                    }
                });
                c.this.jK(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void X(int i, int i2) {
            if (c.this.fum.isActive() && !c.this.bcc() && !c.this.isFullscreen()) {
                c.this.jK(true);
                c.this.setFullscreen(true);
                c.this.fum.bbY().i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jK(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0147a
        public void Y(int i, int i2) {
        }
    };
    private View.OnTouchListener fup = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fun.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fum = aVar;
        this.fun = new com.baidu.tieba.f.b(aVar.ftO.getPageContext().getPageActivity());
        this.fun.a(this.fuo);
    }

    public void initialize() {
        d bbY = this.fum.bbY();
        if (bbY.bce()) {
            bbY.getListView().setOnTouchListener(this.fup);
        }
    }

    public boolean bcc() {
        return this.fuk;
    }

    public void jK(boolean z) {
        this.fuk = z;
    }

    public boolean isFullscreen() {
        return this.ful;
    }

    public void setFullscreen(boolean z) {
        this.ful = z;
    }
}
