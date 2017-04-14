package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private static final int esx = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds160);
    private static final int esy = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
    private com.baidu.tieba.e.c bQe;
    private BaseActivity bcy;
    private boolean esA = false;
    private View.OnTouchListener esB;
    private com.baidu.tieba.pb.pb.sub.a esw;
    private a esz;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void aOk();

        void aOl();

        boolean aOm();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bcy = baseActivity;
        this.bQe = new com.baidu.tieba.e.c(this.bcy.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.esB = new c(this);
        view.setOnTouchListener(new d(this));
        this.bQe.a(new e(this));
    }

    public void bb(View view) {
        if (view != null) {
            view.setOnTouchListener(this.esB);
        }
    }

    public void aOh() {
        if (this.esA && this.mNavigationBar != null && this.esw != null && this.esw.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcy.setExcludeHeight(0);
            if (this.esz != null) {
                this.esz.aOk();
            }
            this.esw.aOf();
        }
    }

    public void aOi() {
        ViewGroup viewGroup;
        if (!this.esA && (viewGroup = (ViewGroup) this.bcy.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.esw = new com.baidu.tieba.pb.pb.sub.a(this.bcy.getPageContext().getPageActivity());
            this.esw.setBackgroundResource(w.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.esw, 0, new LinearLayout.LayoutParams(-1, esx));
            this.esw.setVisibility(0);
            this.esw.setOnClickListener(new f(this));
            this.esw.setScrollCallBack(new g(this));
            this.bcy.setExcludeHeight(esx);
            this.esA = true;
        }
    }

    public void a(a aVar) {
        this.esz = aVar;
    }

    public boolean aOj() {
        return this.esA;
    }

    public void ow(int i) {
        if (this.esw != null) {
            com.baidu.tbadk.core.util.aq.j(this.esw, i);
        }
    }
}
