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
    private BaseActivity bhX;
    private com.baidu.tieba.e.c cfe;
    private com.baidu.tieba.pb.pb.sub.a eHe;
    private a eHg;
    private boolean eHh = false;
    private View.OnTouchListener eHi;
    private NavigationBar mNavigationBar;
    private static final int eHf = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds160);
    private static final int TOUCH_SLOP = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aRJ();

        void aRK();

        boolean aRL();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bhX = baseActivity;
        this.cfe = new com.baidu.tieba.e.c(this.bhX.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eHi = new c(this);
        view.setOnTouchListener(new d(this));
        this.cfe.a(new e(this));
    }

    public void bb(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eHi);
        }
    }

    public void aRG() {
        if (this.eHh && this.mNavigationBar != null && this.eHe != null && this.eHe.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bhX.setExcludeHeight(0);
            if (this.eHg != null) {
                this.eHg.aRJ();
            }
            this.eHe.aRE();
        }
    }

    public void aRH() {
        ViewGroup viewGroup;
        if (!this.eHh && (viewGroup = (ViewGroup) this.bhX.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eHe = new com.baidu.tieba.pb.pb.sub.a(this.bhX.getPageContext().getPageActivity());
            this.eHe.setBackgroundResource(w.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eHe, 0, new LinearLayout.LayoutParams(-1, eHf));
            this.eHe.setVisibility(0);
            this.eHe.setOnClickListener(new f(this));
            this.eHe.setScrollCallBack(new g(this));
            this.bhX.setExcludeHeight(eHf);
            this.eHh = true;
        }
    }

    public void a(a aVar) {
        this.eHg = aVar;
    }

    public boolean aRI() {
        return this.eHh;
    }

    public void pj(int i) {
        if (this.eHe != null) {
            com.baidu.tbadk.core.util.as.j(this.eHe, i);
        }
    }
}
