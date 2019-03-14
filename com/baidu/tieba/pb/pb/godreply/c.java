package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), d.e.ds20);
    private boolean hlU;
    private boolean hlV;
    private final a hlW;
    private final com.baidu.tieba.f.b hlX;
    private a.InterfaceC0284a hlY = new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (c.this.hlW.isActive() && !c.this.bJc() && c.this.hlW.bIY().bJh() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hlW.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nf(false);
                    }
                });
                c.this.nf(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aS(int i, int i2) {
            if (c.this.hlW.isActive() && !c.this.bJc() && !c.this.isFullscreen()) {
                c.this.nf(true);
                c.this.setFullscreen(true);
                c.this.hlW.bIY().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nf(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aT(int i, int i2) {
        }
    };
    private View.OnTouchListener hlZ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hlX.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hlW = aVar;
        this.hlX = new com.baidu.tieba.f.b(aVar.hly.getPageContext().getPageActivity());
        this.hlX.a(this.hlY);
    }

    public void initialize() {
        d bIY = this.hlW.bIY();
        if (bIY.bJe()) {
            bIY.getListView().setOnTouchListener(this.hlZ);
        }
    }

    public boolean bJc() {
        return this.hlU;
    }

    public void nf(boolean z) {
        this.hlU = z;
    }

    public boolean isFullscreen() {
        return this.hlV;
    }

    public void setFullscreen(boolean z) {
        this.hlV = z;
    }
}
