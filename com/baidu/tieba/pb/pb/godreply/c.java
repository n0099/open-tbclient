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
    private boolean fdN;
    private boolean fdO;
    private final a fdP;
    private final com.baidu.tieba.f.b fdQ;
    private a.InterfaceC0131a fdR = new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (c.this.fdP.isActive() && !c.this.aWz() && c.this.fdP.aWv().aWE() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fdP.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
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
            if (c.this.fdP.isActive() && !c.this.aWz() && !c.this.isFullscreen()) {
                c.this.jt(true);
                c.this.setFullscreen(true);
                c.this.fdP.aWv().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener fdS = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            c.this.fdQ.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fdP = aVar;
        this.fdQ = new com.baidu.tieba.f.b(aVar.fdr.getPageContext().getPageActivity());
        this.fdQ.a(this.fdR);
    }

    public void initialize() {
        d aWv = this.fdP.aWv();
        if (aWv.aWB()) {
            aWv.getListView().setOnTouchListener(this.fdS);
        }
    }

    public boolean aWz() {
        return this.fdN;
    }

    public void jt(boolean z) {
        this.fdN = z;
    }

    public boolean isFullscreen() {
        return this.fdO;
    }

    public void setFullscreen(boolean z) {
        this.fdO = z;
    }
}
