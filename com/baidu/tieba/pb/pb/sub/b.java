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
    private static final int ehU = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds160);
    private static final int ehV = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds20);
    private BaseActivity aSs;
    private com.baidu.tieba.d.c bBN;
    private com.baidu.tieba.pb.pb.sub.a ehT;
    private a ehW;
    private boolean ehX = false;
    private View.OnTouchListener ehY;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void aMP();

        void aMQ();

        boolean aMR();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.aSs = baseActivity;
        this.bBN = new com.baidu.tieba.d.c(this.aSs.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.ehY = new c(this);
        view.setOnTouchListener(new d(this));
        this.bBN.a(new e(this));
    }

    public void aX(View view) {
        if (view != null) {
            view.setOnTouchListener(this.ehY);
        }
    }

    public void aMM() {
        if (this.ehX && this.mNavigationBar != null && this.ehT != null && this.ehT.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.aSs.setExcludeHeight(0);
            if (this.ehW != null) {
                this.ehW.aMP();
            }
            this.ehT.aMK();
        }
    }

    public void aMN() {
        ViewGroup viewGroup;
        if (!this.ehX && (viewGroup = (ViewGroup) this.aSs.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.ehT = new com.baidu.tieba.pb.pb.sub.a(this.aSs.getPageContext().getPageActivity());
            this.ehT.setBackgroundResource(r.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.ehT, 0, new LinearLayout.LayoutParams(-1, ehU));
            this.ehT.setVisibility(0);
            this.ehT.setOnClickListener(new f(this));
            this.ehT.setScrollCallBack(new g(this));
            this.aSs.setExcludeHeight(ehU);
            this.ehX = true;
        }
    }

    public void a(a aVar) {
        this.ehW = aVar;
    }

    public boolean aMO() {
        return this.ehX;
    }

    public void nR(int i) {
        if (this.ehT != null) {
            com.baidu.tbadk.core.util.ar.k(this.ehT, i);
        }
    }
}
