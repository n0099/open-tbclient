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
    private BaseActivity bnc;
    private com.baidu.tieba.e.b csZ;
    private com.baidu.tieba.pb.pb.sub.a eWm;
    private a eWo;
    private boolean eWp = false;
    private View.OnTouchListener eWq;
    private NavigationBar mNavigationBar;
    private static final int eWn = k.f(TbadkCoreApplication.getInst(), d.f.ds160);
    private static final int TOUCH_SLOP = k.f(TbadkCoreApplication.getInst(), d.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aUQ();

        void aUR();

        boolean aUS();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bnc = baseActivity;
        this.csZ = new com.baidu.tieba.e.b(this.bnc.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eWq = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.csZ.onTouchEvent(motionEvent);
                return true;
            }
        };
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.pb.pb.sub.b.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                b.this.csZ.onTouchEvent(motionEvent);
                return false;
            }
        });
        this.csZ.a(new a.InterfaceC0081a() { // from class: com.baidu.tieba.pb.pb.sub.b.3
            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void ak(int i, int i2) {
                if (b.this.eWo != null && b.this.eWo.aUS() && Math.abs(i2) > b.TOUCH_SLOP) {
                    if (b.this.eWm != null) {
                        b.this.eWm.setBackgroundResource(d.e.transparent);
                    }
                    b.this.bnc.finish();
                }
            }

            @Override // com.baidu.tieba.e.a.InterfaceC0081a
            public void al(int i, int i2) {
                b.this.aUN();
            }
        });
    }

    public void bo(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eWq);
        }
    }

    public void aUN() {
        if (this.eWp && this.mNavigationBar != null && this.eWm != null && this.eWm.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bnc.setExcludeHeight(0);
            if (this.eWo != null) {
                this.eWo.aUQ();
            }
            this.eWm.aUL();
        }
    }

    public void aUO() {
        ViewGroup viewGroup;
        if (!this.eWp && (viewGroup = (ViewGroup) this.bnc.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eWm = new com.baidu.tieba.pb.pb.sub.a(this.bnc.getPageContext().getPageActivity());
            this.eWm.setBackgroundResource(d.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eWm, 0, new LinearLayout.LayoutParams(-1, eWn));
            this.eWm.setVisibility(0);
            this.eWm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.b.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.this.bnc.finish();
                }
            });
            this.eWm.setScrollCallBack(new a.InterfaceC0113a() { // from class: com.baidu.tieba.pb.pb.sub.b.5
                @Override // com.baidu.tieba.pb.pb.sub.a.InterfaceC0113a
                public void aUM() {
                    if (b.this.eWm != null) {
                        b.this.eWm.setVisibility(8);
                    }
                    b.this.eWp = false;
                    if (b.this.eWo != null) {
                        b.this.eWo.aUR();
                    }
                }
            });
            this.bnc.setExcludeHeight(eWn);
            this.eWp = true;
        }
    }

    public void a(a aVar) {
        this.eWo = aVar;
    }

    public boolean aUP() {
        return this.eWp;
    }

    public void pN(int i) {
        if (this.eWm != null) {
            aj.j(this.eWm, i);
        }
    }
}
