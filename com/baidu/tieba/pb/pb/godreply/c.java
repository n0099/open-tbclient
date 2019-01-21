package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
/* loaded from: classes6.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);
    private boolean fVN;
    private boolean fVO;
    private final a fVP;
    private final com.baidu.tieba.f.b fVQ;
    private a.InterfaceC0214a fVR = new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void ar(int i, int i2) {
            if (c.this.fVP.isActive() && !c.this.biF() && c.this.fVP.biB().biK() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.fVP.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kF(false);
                    }
                });
                c.this.kF(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void as(int i, int i2) {
            if (c.this.fVP.isActive() && !c.this.biF() && !c.this.isFullscreen()) {
                c.this.kF(true);
                c.this.setFullscreen(true);
                c.this.fVP.biB().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kF(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0214a
        public void at(int i, int i2) {
        }
    };
    private View.OnTouchListener fVS = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.fVQ.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.fVP = aVar;
        this.fVQ = new com.baidu.tieba.f.b(aVar.fVr.getPageContext().getPageActivity());
        this.fVQ.a(this.fVR);
    }

    public void initialize() {
        d biB = this.fVP.biB();
        if (biB.biH()) {
            biB.getListView().setOnTouchListener(this.fVS);
        }
    }

    public boolean biF() {
        return this.fVN;
    }

    public void kF(boolean z) {
        this.fVN = z;
    }

    public boolean isFullscreen() {
        return this.fVO;
    }

    public void setFullscreen(boolean z) {
        this.fVO = z;
    }
}
