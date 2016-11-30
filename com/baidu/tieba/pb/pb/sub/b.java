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
    private static final int eDU = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds160);
    private static final int eDV = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst(), r.e.ds20);
    private BaseActivity aTb;
    private com.baidu.tieba.d.c bVF;
    private com.baidu.tieba.pb.pb.sub.a eDT;
    private a eDW;
    private boolean eDX = false;
    private View.OnTouchListener eDY;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void aSY();

        void aSZ();

        boolean aTa();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.aTb = baseActivity;
        this.bVF = new com.baidu.tieba.d.c(this.aTb.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eDY = new c(this);
        view.setOnTouchListener(new d(this));
        this.bVF.a(new e(this));
    }

    public void aY(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eDY);
        }
    }

    public void aSV() {
        if (this.eDX && this.mNavigationBar != null && this.eDT != null && this.eDT.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.aTb.setExcludeHeight(0);
            if (this.eDW != null) {
                this.eDW.aSY();
            }
            this.eDT.aST();
        }
    }

    public void aSW() {
        ViewGroup viewGroup;
        if (!this.eDX && (viewGroup = (ViewGroup) this.aTb.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eDT = new com.baidu.tieba.pb.pb.sub.a(this.aTb.getPageContext().getPageActivity());
            this.eDT.setBackgroundResource(r.d.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eDT, 0, new LinearLayout.LayoutParams(-1, eDU));
            this.eDT.setVisibility(0);
            this.eDT.setOnClickListener(new f(this));
            this.eDT.setScrollCallBack(new g(this));
            this.aTb.setExcludeHeight(eDU);
            this.eDX = true;
        }
    }

    public void a(a aVar) {
        this.eDW = aVar;
    }

    public boolean aSX() {
        return this.eDX;
    }

    public void oP(int i) {
        if (this.eDT != null) {
            com.baidu.tbadk.core.util.at.k(this.eDT, i);
        }
    }
}
