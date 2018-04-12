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
    private boolean fdQ;
    private boolean fdR;
    private final a fdS;
    private final com.baidu.tieba.f.b fdT;
    private a.InterfaceC0131a fdU = new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (c.this.fdS.isActive() && !c.this.aWz() && c.this.fdS.aWv().aWE() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fdS.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jt(false);
                    }
                });
                c.this.jt(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            if (c.this.fdS.isActive() && !c.this.aWz() && !c.this.isFullscreen()) {
                c.this.jt(true);
                c.this.setFullscreen(true);
                c.this.fdS.aWv().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jt(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }
    };
    private View.OnTouchListener fdV = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            c.this.fdT.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fdS = aVar;
        this.fdT = new com.baidu.tieba.f.b(aVar.fdu.getPageContext().getPageActivity());
        this.fdT.a(this.fdU);
    }

    public void initialize() {
        d aWv = this.fdS.aWv();
        if (aWv.aWB()) {
            aWv.getListView().setOnTouchListener(this.fdV);
        }
    }

    public boolean aWz() {
        return this.fdQ;
    }

    public void jt(boolean z) {
        this.fdQ = z;
    }

    public boolean isFullscreen() {
        return this.fdR;
    }

    public void setFullscreen(boolean z) {
        this.fdR = z;
    }
}
