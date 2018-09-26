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
/* loaded from: classes2.dex */
public class a {
    private com.baidu.tieba.f.b bPP;
    private BaseActivity bsQ;
    private boolean dGT = false;
    private View.OnTouchListener dGU;
    private BlankView fRN;
    private InterfaceC0218a fRO;
    private NavigationBar mNavigationBar;
    private static final int dGR = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0218a {
        void aAx();

        void aAy();

        boolean aAz();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bsQ = baseActivity;
        this.bPP = new com.baidu.tieba.f.b(this.bsQ.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dGU = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bPP.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.bPP.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.bPP.a(new a.InterfaceC0145a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ac(int i, int i2) {
                if (a.this.fRO != null && a.this.fRO.aAz() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.fRN != null) {
                        a.this.fRN.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bsQ.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ad(int i, int i2) {
                a.this.aAA();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0145a
            public void ae(int i, int i2) {
            }
        });
    }

    public void bD(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dGU);
        }
    }

    public void aAA() {
        if (this.dGT && this.mNavigationBar != null && this.fRN != null && this.fRN.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bsQ.setExcludeHeight(0);
            if (this.fRO != null) {
                this.fRO.aAx();
            }
            this.fRN.aAH();
        }
    }

    public void aAB() {
        ViewGroup viewGroup;
        if (!this.dGT && (viewGroup = (ViewGroup) this.bsQ.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.fRN = new BlankView(this.bsQ.getPageContext().getPageActivity());
            this.fRN.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.fRN, 0, new LinearLayout.LayoutParams(-1, dGR));
            this.fRN.setVisibility(0);
            this.fRN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bsQ.finish();
                }
            });
            this.fRN.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aAD() {
                    if (a.this.fRN != null) {
                        a.this.fRN.setVisibility(8);
                    }
                    a.this.dGT = false;
                    if (a.this.fRO != null) {
                        a.this.fRO.aAy();
                    }
                }
            });
            this.bsQ.setExcludeHeight(dGR);
            this.dGT = true;
        }
    }

    public void a(InterfaceC0218a interfaceC0218a) {
        this.fRO = interfaceC0218a;
    }

    public boolean aAC() {
        return this.dGT;
    }

    public void lJ(int i) {
        if (this.fRN != null) {
            al.i(this.fRN, i);
        }
    }
}
