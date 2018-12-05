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
    private BaseActivity bBf;
    private com.baidu.tieba.f.b cvK;
    private boolean dWx = false;
    private View.OnTouchListener dWy;
    private BlankView ghB;
    private InterfaceC0290a ghC;
    private NavigationBar mNavigationBar;
    private static final int dWv = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private static final int TOUCH_SLOP = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds20);

    /* renamed from: com.baidu.tieba.pb.pb.sub.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0290a {
        void aEX();

        void aEY();

        boolean aEZ();
    }

    public a(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bBf = baseActivity;
        this.cvK = new com.baidu.tieba.f.b(this.bBf.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.dWy = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cvK.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.cvK.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.cvK.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void aq(int i, int i2) {
                if (a.this.ghC != null && a.this.ghC.aEZ() && Math.abs(i2) > a.TOUCH_SLOP) {
                    if (a.this.ghB != null) {
                        a.this.ghB.setBackgroundResource(e.d.transparent);
                    }
                    a.this.bBf.finish();
                }
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
                a.this.aFa();
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
            }
        });
    }

    public void bF(View view) {
        if (view != null) {
            view.setOnTouchListener(this.dWy);
        }
    }

    public void aFa() {
        if (this.dWx && this.mNavigationBar != null && this.ghB != null && this.ghB.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bBf.setExcludeHeight(0);
            if (this.ghC != null) {
                this.ghC.aEX();
            }
            this.ghB.aFh();
        }
    }

    public void aFb() {
        ViewGroup viewGroup;
        if (!this.dWx && (viewGroup = (ViewGroup) this.bBf.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.ghB = new BlankView(this.bBf.getPageContext().getPageActivity());
            this.ghB.setBackgroundResource(e.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.ghB, 0, new LinearLayout.LayoutParams(-1, dWv));
            this.ghB.setVisibility(0);
            this.ghB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bBf.finish();
                }
            });
            this.ghB.setScrollCallBack(new BlankView.a() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // com.baidu.tieba.pb.pb.sub.BlankView.a
                public void aFd() {
                    if (a.this.ghB != null) {
                        a.this.ghB.setVisibility(8);
                    }
                    a.this.dWx = false;
                    if (a.this.ghC != null) {
                        a.this.ghC.aEY();
                    }
                }
            });
            this.bBf.setExcludeHeight(dWv);
            this.dWx = true;
        }
    }

    public void a(InterfaceC0290a interfaceC0290a) {
        this.ghC = interfaceC0290a;
    }

    public boolean aFc() {
        return this.dWx;
    }

    public void mO(int i) {
        if (this.ghB != null) {
            al.i(this.ghB, i);
        }
    }
}
