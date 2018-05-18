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
    private boolean feU;
    private boolean feV;
    private final a feW;
    private final com.baidu.tieba.f.b feX;
    private a.InterfaceC0131a feY = new a.InterfaceC0131a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void W(int i, int i2) {
            if (c.this.feW.isActive() && !c.this.aWz() && c.this.feW.aWv().aWE() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.feW.i(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ju(false);
                    }
                });
                c.this.ju(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void X(int i, int i2) {
            if (c.this.feW.isActive() && !c.this.aWz() && !c.this.isFullscreen()) {
                c.this.ju(true);
                c.this.setFullscreen(true);
                c.this.feW.aWv().j(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ju(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0131a
        public void Y(int i, int i2) {
        }
    };
    private View.OnTouchListener feZ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            c.this.feX.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.feW = aVar;
        this.feX = new com.baidu.tieba.f.b(aVar.fey.getPageContext().getPageActivity());
        this.feX.a(this.feY);
    }

    public void initialize() {
        d aWv = this.feW.aWv();
        if (aWv.aWB()) {
            aWv.getListView().setOnTouchListener(this.feZ);
        }
    }

    public boolean aWz() {
        return this.feU;
    }

    public void ju(boolean z) {
        this.feU = z;
    }

    public boolean isFullscreen() {
        return this.feV;
    }

    public void setFullscreen(boolean z) {
        this.feV = z;
    }
}
