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
    private boolean hlI;
    private boolean hlJ;
    private final a hlK;
    private final com.baidu.tieba.f.b hlL;
    private a.InterfaceC0284a hlM = new a.InterfaceC0284a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0284a
        public void aR(int i, int i2) {
            if (c.this.hlK.isActive() && !c.this.bIZ() && c.this.hlK.bIV().bJe() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hlK.n(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
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
            if (c.this.hlK.isActive() && !c.this.bIZ() && !c.this.isFullscreen()) {
                c.this.nf(true);
                c.this.setFullscreen(true);
                c.this.hlK.bIV().o(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
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
    private View.OnTouchListener hlN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hlL.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hlK = aVar;
        this.hlL = new com.baidu.tieba.f.b(aVar.hlm.getPageContext().getPageActivity());
        this.hlL.a(this.hlM);
    }

    public void initialize() {
        d bIV = this.hlK.bIV();
        if (bIV.bJb()) {
            bIV.getListView().setOnTouchListener(this.hlN);
        }
    }

    public boolean bIZ() {
        return this.hlI;
    }

    public void nf(boolean z) {
        this.hlI = z;
    }

    public boolean isFullscreen() {
        return this.hlJ;
    }

    public void setFullscreen(boolean z) {
        this.hlJ = z;
    }
}
