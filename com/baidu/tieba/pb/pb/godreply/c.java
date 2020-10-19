package com.baidu.tieba.pb.pb.godreply;

import android.view.MotionEvent;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
/* loaded from: classes22.dex */
public class c {
    private static final int TOUCH_SLOP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds20);
    private boolean kWX;
    private boolean kWY;
    private final a kWZ;
    private final com.baidu.tieba.f.b kXa;
    private a.InterfaceC0689a kXb = new a.InterfaceC0689a() { // from class: com.baidu.tieba.pb.pb.godreply.c.1
        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void H(int i, int i2) {
            if (c.this.kWZ.isActive() && !c.this.ddS() && !c.this.ddT()) {
                c.this.tw(true);
                c.this.setFullscreen(true);
                c.this.kWZ.ddO().u(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tw(false);
                    }
                });
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void I(int i, int i2) {
            if (c.this.kWZ.isActive() && !c.this.ddS() && c.this.kWZ.ddO().ddY() && Math.abs(i2) > c.TOUCH_SLOP) {
                c.this.kWZ.t(new Runnable() { // from class: com.baidu.tieba.pb.pb.godreply.c.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.tw(false);
                    }
                });
                c.this.tw(true);
                c.this.setFullscreen(false);
            }
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void cc(int i, int i2) {
        }

        @Override // com.baidu.tieba.f.a.InterfaceC0689a
        public void J(int i, int i2) {
        }
    };
    private View.OnTouchListener kXc = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.godreply.c.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c.this.kXa.onTouchEvent(motionEvent);
            return false;
        }
    };

    public c(a aVar) {
        this.kWZ = aVar;
        this.kXa = new com.baidu.tieba.f.b(aVar.kWB.getPageContext().getPageActivity());
        this.kXa.a(this.kXb);
    }

    public void initialize() {
        d ddO = this.kWZ.ddO();
        if (ddO.ddV()) {
            ddO.getListView().setOnTouchListener(this.kXc);
        }
    }

    public boolean ddS() {
        return this.kWX;
    }

    public void tw(boolean z) {
        this.kWX = z;
    }

    public boolean ddT() {
        return this.kWY;
    }

    public void setFullscreen(boolean z) {
        this.kWY = z;
    }
}
