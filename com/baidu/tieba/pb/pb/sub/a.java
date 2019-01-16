package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.pb.pb.sub.BlankView;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity bBV;
    private com.baidu.tieba.f.b cxA;
    private boolean dZU = false;
    private View.OnTouchListener dZV;
    private BlankView glw;
    private InterfaceC0290a glx;
    private NavigationBar mNavigationBar;
    private static final int dZS = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0290a {
        void aGj();

        void aGk();

        boolean aGl();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBV = baseActivity;
        this.cxA = new com.baidu.tieba.f.b(this.bBV.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dZV = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cxA.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cxA.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cxA.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                if (a.this.glx != null && a.this.glx.aGl() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.glw != null) {
                        a.this.glw.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bBV.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
                a.this.aGm();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void at(int i, int i2) {
            }
        });
    }

    public void bI(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dZV);
        }
    }

    public void aGm() {
        if (this.dZU && this.mNavigationBar != null && this.glw != null && this.glw.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBV.setExcludeHeight(0);
            if (this.glx != null) {
                this.glx.aGj();
            }
            this.glw.aGt();
        }
    }

    public void aGn() {
        ViewGroup viewGroup;
        if (!this.dZU && (viewGroup = (ViewGroup) this.bBV.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.glw = new BlankView(this.bBV.getPageContext().getPageActivity());
            this.glw.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.glw, 0, new LinearLayout.LayoutParams(-1, dZS));
            this.glw.setVisibility(0);
            this.glw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bBV.finish();
                }
            });
            this.glw.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aGp() {
                    if (a.this.glw != null) {
                        a.this.glw.setVisibility(8);
                    }
                    a.this.dZU = false;
                    if (a.this.glx != null) {
                        a.this.glx.aGk();
                    }
                }
            });
            this.bBV.setExcludeHeight(dZS);
            this.dZU = true;
        }
    }

    public void a(InterfaceC0290a interfaceC0290a) {
        this.glx = interfaceC0290a;
    }

    public boolean aGo() {
        return this.dZU;
    }

    public void nc(int i) {
        if (this.glw != null) {
            al.i(this.glw, i);
        }
    }
}
