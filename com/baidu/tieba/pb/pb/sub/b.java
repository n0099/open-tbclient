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
    private com.baidu.tieba.e.c bSv;
    private BaseActivity bdG;
    private com.baidu.tieba.pb.pb.sub.a euO;
    private a euQ;
    private boolean euR = false;
    private View.OnTouchListener euS;
    private NavigationBar mNavigationBar;
    private static final int euP = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds160);
    private static final int TOUCH_SLOP = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aPl();

        void aPm();

        boolean aPn();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bdG = baseActivity;
        this.bSv = new com.baidu.tieba.e.c(this.bdG.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.euS = new c(this);
        view.setOnTouchListener(new d(this));
        this.bSv.a(new e(this));
    }

    public void bb(View view) {
        if (view != null) {
            view.setOnTouchListener(this.euS);
        }
    }

    public void aPi() {
        if (this.euR && this.mNavigationBar != null && this.euO != null && this.euO.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bdG.setExcludeHeight(0);
            if (this.euQ != null) {
                this.euQ.aPl();
            }
            this.euO.aPg();
        }
    }

    public void aPj() {
        ViewGroup viewGroup;
        if (!this.euR && (viewGroup = (ViewGroup) this.bdG.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.euO = new com.baidu.tieba.pb.pb.sub.a(this.bdG.getPageContext().getPageActivity());
            this.euO.setBackgroundResource(w.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.euO, 0, new LinearLayout.LayoutParams(-1, euP));
            this.euO.setVisibility(0);
            this.euO.setOnClickListener(new f(this));
            this.euO.setScrollCallBack(new g(this));
            this.bdG.setExcludeHeight(euP);
            this.euR = true;
        }
    }

    public void a(a aVar) {
        this.euQ = aVar;
    }

    public boolean aPk() {
        return this.euR;
    }

    public void oC(int i) {
        if (this.euO != null) {
            com.baidu.tbadk.core.util.aq.j(this.euO, i);
        }
    }
}
