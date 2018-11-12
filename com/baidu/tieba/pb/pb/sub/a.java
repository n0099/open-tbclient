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
    private BaseActivity bxI;
    private com.baidu.tieba.f.b crR;
    private boolean dPV = false;
    private View.OnTouchListener dPW;
    private BlankView gaK;
    private InterfaceC0279a gaL;
    private NavigationBar mNavigationBar;
    private static final int dPT = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0279a {
        void aDl();

        void aDm();

        boolean aDn();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bxI = baseActivity;
        this.crR = new com.baidu.tieba.f.b(this.bxI.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dPW = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.crR.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.crR.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.crR.a(new a.InterfaceC0204a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void ap(int i, int i2) {
                if (a.this.gaL != null && a.this.gaL.aDn() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.gaK != null) {
                        a.this.gaK.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bxI.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void aq(int i, int i2) {
                a.this.aDo();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0204a
            public void ar(int i, int i2) {
            }
        });
    }

    public void bF(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dPW);
        }
    }

    public void aDo() {
        if (this.dPV && this.mNavigationBar != null && this.gaK != null && this.gaK.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bxI.setExcludeHeight(0);
            if (this.gaL != null) {
                this.gaL.aDl();
            }
            this.gaK.aDv();
        }
    }

    public void aDp() {
        ViewGroup viewGroup;
        if (!this.dPV && (viewGroup = (ViewGroup) this.bxI.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.gaK = new BlankView(this.bxI.getPageContext().getPageActivity());
            this.gaK.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.gaK, 0, new LinearLayout.LayoutParams(-1, dPT));
            this.gaK.setVisibility(0);
            this.gaK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bxI.finish();
                }
            });
            this.gaK.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aDr() {
                    if (a.this.gaK != null) {
                        a.this.gaK.setVisibility(8);
                    }
                    a.this.dPV = false;
                    if (a.this.gaL != null) {
                        a.this.gaL.aDm();
                    }
                }
            });
            this.bxI.setExcludeHeight(dPT);
            this.dPV = true;
        }
    }

    public void a(InterfaceC0279a interfaceC0279a) {
        this.gaL = interfaceC0279a;
    }

    public boolean aDq() {
        return this.dPV;
    }

    public void my(int i) {
        if (this.gaK != null) {
            al.i(this.gaK, i);
        }
    }
}
