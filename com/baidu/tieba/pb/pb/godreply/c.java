package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes4.dex */
public class c {
    private static final int TOUCH_SLOP = l.g(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean hMp;
    private boolean hMq;
    private final a hMr;
    private final com.baidu.tieba.f.b hMs;
    private a.InterfaceC0316a hMt = new a.InterfaceC0316a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aY(int i, int i2) {
            if (c.this.hMr.isActive() && !c.this.bUG() && c.this.hMr.bUC().bUM() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.hMr.q(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.on(false);
                    }
                });
                c.this.on(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void aZ(int i, int i2) {
            if (c.this.hMr.isActive() && !c.this.bUG() && !c.this.bUH()) {
                c.this.on(true);
                c.this.setFullscreen(true);
                c.this.hMr.bUC().r(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.on(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0316a
        public void ba(int i, int i2) {
        }
    };
    private View.OnTouchListener hMu = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.hMs.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.hMr = aVar;
        this.hMs = new com.baidu.tieba.f.b(aVar.hLT.getPageContext().getPageActivity());
        this.hMs.a(this.hMt);
    }

    public void initialize() {
        d bUC = this.hMr.bUC();
        if (bUC.bUJ()) {
            bUC.getListView().setOnTouchListener(this.hMu);
        }
    }

    public boolean bUG() {
        return this.hMp;
    }

    public void on(boolean z) {
        this.hMp = z;
    }

    public boolean bUH() {
        return this.hMq;
    }

    public void setFullscreen(boolean z) {
        this.hMq = z;
    }
}
