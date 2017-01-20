package com.baidu.tieba.pb.pb.sub;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class b {
    private static final int ere = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds160);
    private static final int erf = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.f.ds20);
    private BaseActivity aWr;
    private com.baidu.tieba.f.c bJg;
    private com.baidu.tieba.pb.pb.sub.a erd;
    private a erg;
    private boolean erh = false;
    private View.OnTouchListener eri;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void aOK();

        void aOL();

        boolean aOM();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.aWr = baseActivity;
        this.bJg = new com.baidu.tieba.f.c(this.aWr.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eri = new c(this);
        view.setOnTouchListener(new d(this));
        this.bJg.a(new e(this));
    }

    public void be(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eri);
        }
    }

    public void aOH() {
        if (this.erh && this.mNavigationBar != null && this.erd != null && this.erd.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.aWr.setExcludeHeight(0);
            if (this.erg != null) {
                this.erg.aOK();
            }
            this.erd.aOF();
        }
    }

    public void aOI() {
        ViewGroup viewGroup;
        if (!this.erh && (viewGroup = (ViewGroup) this.aWr.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.erd = new com.baidu.tieba.pb.pb.sub.a(this.aWr.getPageContext().getPageActivity());
            this.erd.setBackgroundResource(r.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.erd, 0, new LinearLayout.LayoutParams(-1, ere));
            this.erd.setVisibility(0);
            this.erd.setOnClickListener(new f(this));
            this.erd.setScrollCallBack(new g(this));
            this.aWr.setExcludeHeight(ere);
            this.erh = true;
        }
    }

    public void a(a aVar) {
        this.erg = aVar;
    }

    public boolean aOJ() {
        return this.erh;
    }

    public void oI(int i) {
        if (this.erd != null) {
            com.baidu.tbadk.core.util.ap.j(this.erd, i);
        }
    }
}
