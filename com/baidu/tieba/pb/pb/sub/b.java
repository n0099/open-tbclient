package com.baidu.tieba.pb.pb.sub;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.e.a;
import com.baidu.tieba.pb.pb.sub.a;
/* loaded from: classes.dex */
public class b {
    private BaseActivity bnd;
    private com.baidu.tieba.e.b csh;
    private com.baidu.tieba.pb.pb.sub.a eVs;
    private a eVu;
    private boolean eVv = false;
    private View.OnTouchListener eVw;
    private NavigationBar mNavigationBar;
    private static final int eVt = k.g(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = k.g(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aUF();

        void aUG();

        boolean aUH();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bnd = baseActivity;
        this.csh = new com.baidu.tieba.e.b(this.bnd.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eVw = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.csh.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.csh.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.csh.a(new a.InterfaceC0082a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0082a
            public void ag(int i, int i2) {
                if (b.this.eVu != null && b.this.eVu.aUH() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eVs != null) {
                        b.this.eVs.setBackgroundResource(d.e.transparent);
                    }
                    b.this.bnd.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0082a
            public void ah(int i, int i2) {
                b.this.aUC();
            }
        });
    }

    public void bo(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eVw);
        }
    }

    public void aUC() {
        if (this.eVv && this.mNavigationBar != null && this.eVs != null && this.eVs.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bnd.setExcludeHeight(0);
            if (this.eVu != null) {
                this.eVu.aUF();
            }
            this.eVs.aUA();
        }
    }

    public void aUD() {
        ViewGroup viewGroup;
        if (!this.eVv && (viewGroup = (ViewGroup) this.bnd.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eVs = new com.baidu.tieba.pb.pb.sub.a(this.bnd.getPageContext().getPageActivity());
            this.eVs.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eVs, 0, new LinearLayout.LayoutParams(-1, eVt));
            this.eVs.setVisibility(0);
            this.eVs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bnd.finish();
                }
            });
            this.eVs.setScrollCallBack(new a.InterfaceC0114a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0114a
                public void aUB() {
                    if (b.this.eVs != null) {
                        b.this.eVs.setVisibility(8);
                    }
                    b.this.eVv = false;
                    if (b.this.eVu != null) {
                        b.this.eVu.aUG();
                    }
                }
            });
            this.bnd.setExcludeHeight(eVt);
            this.eVv = true;
        }
    }

    public void a(a aVar) {
        this.eVu = aVar;
    }

    public boolean aUE() {
        return this.eVv;
    }

    public void pL(int i) {
        if (this.eVs != null) {
            aj.j(this.eVs, i);
        }
    }
}
