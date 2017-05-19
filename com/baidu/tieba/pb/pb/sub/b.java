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
    private com.baidu.tieba.e.c bRf;
    private BaseActivity bdY;
    private View.OnTouchListener eqA;
    private com.baidu.tieba.pb.pb.sub.a eqw;
    private a eqy;
    private boolean eqz = false;
    private NavigationBar mNavigationBar;
    private static final int eqx = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds160);
    private static final int TOUCH_SLOP = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);

    /* loaded from: classes.dex */
    public interface a {
        void aMA();

        void aMB();

        boolean aMC();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bdY = baseActivity;
        this.bRf = new com.baidu.tieba.e.c(this.bdY.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.eqA = new c(this);
        view.setOnTouchListener(new d(this));
        this.bRf.a(new e(this));
    }

    public void aX(View view) {
        if (view != null) {
            view.setOnTouchListener(this.eqA);
        }
    }

    public void aMx() {
        if (this.eqz && this.mNavigationBar != null && this.eqw != null && this.eqw.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bdY.setExcludeHeight(0);
            if (this.eqy != null) {
                this.eqy.aMA();
            }
            this.eqw.aMv();
        }
    }

    public void aMy() {
        ViewGroup viewGroup;
        if (!this.eqz && (viewGroup = (ViewGroup) this.bdY.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eqw = new com.baidu.tieba.pb.pb.sub.a(this.bdY.getPageContext().getPageActivity());
            this.eqw.setBackgroundResource(w.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eqw, 0, new LinearLayout.LayoutParams(-1, eqx));
            this.eqw.setVisibility(0);
            this.eqw.setOnClickListener(new f(this));
            this.eqw.setScrollCallBack(new g(this));
            this.bdY.setExcludeHeight(eqx);
            this.eqz = true;
        }
    }

    public void a(a aVar) {
        this.eqy = aVar;
    }

    public boolean aMz() {
        return this.eqz;
    }

    public void os(int i) {
        if (this.eqw != null) {
            com.baidu.tbadk.core.util.aq.j(this.eqw, i);
        }
    }
}
