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
    private com.baidu.tieba.e.b bHL;
    private BaseActivity byB;
    private boolean cVI = false;
    private View.OnTouchListener cVJ;
    private com.baidu.tieba.pb.pb.sub.a fhi;
    private a fhj;
    private NavigationBar mNavigationBar;
    private static final int cVG = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.e.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aoZ();

        void apa();

        boolean apb();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.byB = baseActivity;
        this.bHL = new com.baidu.tieba.e.b(this.byB.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.cVJ = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bHL.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.bHL.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bHL.a(new a.InterfaceC0097a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0097a
            public void ag(int i, int i2) {
                if (b.this.fhj != null && b.this.fhj.apb() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.fhi != null) {
                        b.this.fhi.setBackgroundResource(d.C0096d.transparent);
                    }
                    b.this.byB.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0097a
            public void ah(int i, int i2) {
                b.this.apc();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0097a
            public void ai(int i, int i2) {
            }
        });
    }

    public void bp(View view) {
        if (view != null) {
            view.setOnTouchListener(this.cVJ);
        }
    }

    public void apc() {
        if (this.cVI && this.mNavigationBar != null && this.fhi != null && this.fhi.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.byB.setExcludeHeight(0);
            if (this.fhj != null) {
                this.fhj.aoZ();
            }
            this.fhi.apj();
        }
    }

    public void apd() {
        ViewGroup viewGroup;
        if (!this.cVI && (viewGroup = (ViewGroup) this.byB.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fhi = new com.baidu.tieba.pb.pb.sub.a(this.byB.getPageContext().getPageActivity());
            this.fhi.setBackgroundResource(d.C0096d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fhi, 0, new LinearLayout.LayoutParams(-1, cVG));
            this.fhi.setVisibility(0);
            this.fhi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.byB.finish();
                }
            });
            this.fhi.setScrollCallBack(new a.InterfaceC0133a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0133a
                public void apf() {
                    if (b.this.fhi != null) {
                        b.this.fhi.setVisibility(8);
                    }
                    b.this.cVI = false;
                    if (b.this.fhj != null) {
                        b.this.fhj.apa();
                    }
                }
            });
            this.byB.setExcludeHeight(cVG);
            this.cVI = true;
        }
    }

    public void a(a aVar) {
        this.fhj = aVar;
    }

    public boolean ape() {
        return this.cVI;
    }

    public void kC(int i) {
        if (this.fhi != null) {
            aj.j(this.fhi, i);
        }
    }
}
