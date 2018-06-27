package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.f.b bJn;
    private BaseActivity bmt;
    private boolean dxA = false;
    private View.OnTouchListener dxB;
    private BlankView fKb;
    private InterfaceC0214a fKc;
    private NavigationBar mNavigationBar;
    private static final int dxy = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private static final int TOUCH_SLOP = l.e(TbadkCoreApplication.getInst(), d.e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0214a {
        void axF();

        void axG();

        boolean axH();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bmt = baseActivity;
        this.bJn = new com.baidu.tieba.f.b(this.bmt.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dxB = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bJn.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bJn.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bJn.a(new a.InterfaceC0147a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void W(int i, int i2) {
                if (a.this.fKc != null && a.this.fKc.axH() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fKb != null) {
                        a.this.fKb.setBackgroundResource(d.C0142d.transparent);
                    }
                    a.this.bmt.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void X(int i, int i2) {
                a.this.axI();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0147a
            public void Y(int i, int i2) {
            }
        });
    }

    public void bl(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dxB);
        }
    }

    public void axI() {
        if (this.dxA && this.mNavigationBar != null && this.fKb != null && this.fKb.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bmt.setExcludeHeight(0);
            if (this.fKc != null) {
                this.fKc.axF();
            }
            this.fKb.axP();
        }
    }

    public void axJ() {
        ViewGroup viewGroup;
        if (!this.dxA && (viewGroup = (ViewGroup) this.bmt.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fKb = new BlankView(this.bmt.getPageContext().getPageActivity());
            this.fKb.setBackgroundResource(d.C0142d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fKb, 0, new LinearLayout.LayoutParams(-1, dxy));
            this.fKb.setVisibility(0);
            this.fKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bmt.finish();
                }
            });
            this.fKb.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void axL() {
                    if (a.this.fKb != null) {
                        a.this.fKb.setVisibility(8);
                    }
                    a.this.dxA = false;
                    if (a.this.fKc != null) {
                        a.this.fKc.axG();
                    }
                }
            });
            this.bmt.setExcludeHeight(dxy);
            this.dxA = true;
        }
    }

    public void a(InterfaceC0214a interfaceC0214a) {
        this.fKc = interfaceC0214a;
    }

    public boolean axK() {
        return this.dxA;
    }

    public void kW(int i) {
        if (this.fKb != null) {
            am.i(this.fKb, i);
        }
    }
}
