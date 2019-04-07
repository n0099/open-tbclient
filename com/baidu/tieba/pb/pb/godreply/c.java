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
    private boolean hlH;
    private boolean hlI;
    private final a hlJ;
    private final com.baidu.tieba.f.b hlK;
    private a.InterfaceC0284a hlL = new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (c.this.hlJ.isActive() && !c.this.bIZ() && c.this.hlJ.bIV().bJe() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hlJ.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
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
            if (c.this.hlJ.isActive() && !c.this.bIZ() && !c.this.isFullscreen()) {
                c.this.nf(true);
                c.this.setFullscreen(true);
                c.this.hlJ.bIV().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener hlM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hlK.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hlJ = aVar;
        this.hlK = new com.baidu.tieba.f.b(aVar.hll.getPageContext().getPageActivity());
        this.hlK.a(this.hlL);
    }

    public void initialize() {
        d bIV = this.hlJ.bIV();
        if (bIV.bJb()) {
            bIV.getListView().setOnTouchListener(this.hlM);
        }
    }

    public boolean bIZ() {
        return this.hlH;
    }

    public void nf(boolean z) {
        this.hlH = z;
    }

    public boolean isFullscreen() {
        return this.hlI;
    }

    public void setFullscreen(boolean z) {
        this.hlI = z;
    }
}
