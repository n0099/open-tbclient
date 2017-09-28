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
    private BaseActivity boM;
    private com.baidu.tieba.e.b ctE;
    private com.baidu.tieba.pb.pb.sub.a eQv;
    private a eQx;
    private boolean eQy = false;
    private View.OnTouchListener eQz;
    private NavigationBar mNavigationBar;
    private static final int eQw = l.f(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = l.f(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aSZ();

        void aTa();

        boolean aTb();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.boM = baseActivity;
        this.ctE = new com.baidu.tieba.e.b(this.boM.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eQz = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ctE.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.ctE.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.ctE.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ao(int i, int i2) {
                if (b.this.eQx != null && b.this.eQx.aTb() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eQv != null) {
                        b.this.eQv.setBackgroundResource(d.e.transparent);
                    }
                    b.this.boM.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ap(int i, int i2) {
                b.this.aSW();
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void aq(int i, int i2) {
            }
        });
    }

    public void bm(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eQz);
        }
    }

    public void aSW() {
        if (this.eQy && this.mNavigationBar != null && this.eQv != null && this.eQv.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.boM.setExcludeHeight(0);
            if (this.eQx != null) {
                this.eQx.aSZ();
            }
            this.eQv.aSU();
        }
    }

    public void aSX() {
        ViewGroup viewGroup;
        if (!this.eQy && (viewGroup = (ViewGroup) this.boM.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eQv = new com.baidu.tieba.pb.pb.sub.a(this.boM.getPageContext().getPageActivity());
            this.eQv.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eQv, 0, new LinearLayout.LayoutParams(-1, eQw));
            this.eQv.setVisibility(0);
            this.eQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.boM.finish();
                }
            });
            this.eQv.setScrollCallBack(new a.InterfaceC0115a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0115a
                public void aSV() {
                    if (b.this.eQv != null) {
                        b.this.eQv.setVisibility(8);
                    }
                    b.this.eQy = false;
                    if (b.this.eQx != null) {
                        b.this.eQx.aTa();
                    }
                }
            });
            this.boM.setExcludeHeight(eQw);
            this.eQy = true;
        }
    }

    public void a(a aVar) {
        this.eQx = aVar;
    }

    public boolean aSY() {
        return this.eQy;
    }

    public void pI(int i) {
        if (this.eQv != null) {
            aj.j(this.eQv, i);
        }
    }
}
