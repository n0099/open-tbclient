package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.a;
/* loaded from: classes.dex */
public class b {
    private com.baidu.tieba.e.b bHH;
    private BaseActivity byz;
    private boolean cVx = false;
    private View.OnTouchListener cVy;
    private com.baidu.tieba.pb.pb.sub.a fgk;
    private a fgl;
    private NavigationBar mNavigationBar;
    private static final int cVv = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aoR();

        void aoS();

        boolean aoT();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.byz = baseActivity;
        this.bHH = new com.baidu.tieba.e.b(this.byz.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.cVy = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bHH.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bHH.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bHH.a(new a.InterfaceC0083a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0083a
            public void af(int i, int i2) {
                if (b.this.fgl != null && b.this.fgl.aoT() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fgk != null) {
                        b.this.fgk.setBackgroundResource(d.C0082d.transparent);
                    }
                    b.this.byz.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0083a
            public void ag(int i, int i2) {
                b.this.aoU();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0083a
            public void ah(int i, int i2) {
            }
        });
    }

    public void bl(View view) {
        if (view != null) {
            view.setOnTouchListener(this.cVy);
        }
    }

    public void aoU() {
        if (this.cVx && this.mNavigationBar != null && this.fgk != null && this.fgk.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.byz.setExcludeHeight(0);
            if (this.fgl != null) {
                this.fgl.aoR();
            }
            this.fgk.apb();
        }
    }

    public void aoV() {
        ViewGroup viewGroup;
        if (!this.cVx && (viewGroup = (ViewGroup) this.byz.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fgk = new com.baidu.tieba.pb.pb.sub.a(this.byz.getPageContext().getPageActivity());
            this.fgk.setBackgroundResource(d.C0082d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fgk, 0, new LinearLayout.LayoutParams(-1, cVv));
            this.fgk.setVisibility(0);
            this.fgk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.byz.finish();
                }
            });
            this.fgk.setScrollCallBack(new a.InterfaceC0118a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0118a
                public void aoX() {
                    if (b.this.fgk != null) {
                        b.this.fgk.setVisibility(8);
                    }
                    b.this.cVx = false;
                    if (b.this.fgl != null) {
                        b.this.fgl.aoS();
                    }
                }
            });
            this.byz.setExcludeHeight(cVv);
            this.cVx = true;
        }
    }

    public void a(a aVar) {
        this.fgl = aVar;
    }

    public boolean aoW() {
        return this.cVx;
    }

    public void kA(int i) {
        if (this.fgk != null) {
            aj.j(this.fgk, i);
        }
    }
}
