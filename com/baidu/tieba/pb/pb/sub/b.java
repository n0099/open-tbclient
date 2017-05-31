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
    private BaseActivity bfa;
    private com.baidu.tieba.e.c bwH;
    private com.baidu.tieba.pb.pb.sub.a exG;
    private a exI;
    private boolean exJ = false;
    private View.OnTouchListener exK;
    private NavigationBar mNavigationBar;
    private static final int exH = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds160);
    private static final int TOUCH_SLOP = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aNJ();

        void aNK();

        boolean aNL();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bfa = baseActivity;
        this.bwH = new com.baidu.tieba.e.c(this.bfa.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.exK = new c(this);
        view.setOnTouchListener(new d(this));
        this.bwH.a(new e(this));
    }

    public void aY(View view) {
        if (view != null) {
            view.setOnTouchListener(this.exK);
        }
    }

    public void aNG() {
        if (this.exJ && this.mNavigationBar != null && this.exG != null && this.exG.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bfa.setExcludeHeight(0);
            if (this.exI != null) {
                this.exI.aNJ();
            }
            this.exG.aNE();
        }
    }

    public void aNH() {
        ViewGroup viewGroup;
        if (!this.exJ && (viewGroup = (ViewGroup) this.bfa.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.exG = new com.baidu.tieba.pb.pb.sub.a(this.bfa.getPageContext().getPageActivity());
            this.exG.setBackgroundResource(w.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.exG, 0, new LinearLayout.LayoutParams(-1, exH));
            this.exG.setVisibility(0);
            this.exG.setOnClickListener(new f(this));
            this.exG.setScrollCallBack(new g(this));
            this.bfa.setExcludeHeight(exH);
            this.exJ = true;
        }
    }

    public void a(a aVar) {
        this.exI = aVar;
    }

    public boolean aNI() {
        return this.exJ;
    }

    public void oQ(int i) {
        if (this.exG != null) {
            com.baidu.tbadk.core.util.aq.j(this.exG, i);
        }
    }
}
