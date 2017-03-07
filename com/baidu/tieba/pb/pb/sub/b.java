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
    private static final int eus = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds160);
    private static final int eut = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst(), w.f.ds20);
    private com.baidu.tieba.e.c bQp;
    private BaseActivity bcF;
    private com.baidu.tieba.pb.pb.sub.a eur;
    private a euu;
    private boolean euv = false;
    private View.OnTouchListener euw;
    private NavigationBar mNavigationBar;

    /* loaded from: classes.dex */
    public interface a {
        void aOb();

        void aOc();

        boolean aOd();
    }

    public b(BaseActivity baseActivity, View view, NavigationBar navigationBar) {
        this.bcF = baseActivity;
        this.bQp = new com.baidu.tieba.e.c(this.bcF.getPageContext().getPageActivity());
        this.mNavigationBar = navigationBar;
        this.mNavigationBar.setStatusBarVisibility(8);
        this.euw = new c(this);
        view.setOnTouchListener(new d(this));
        this.bQp.a(new e(this));
    }

    public void bd(View view) {
        if (view != null) {
            view.setOnTouchListener(this.euw);
        }
    }

    public void aNY() {
        if (this.euv && this.mNavigationBar != null && this.eur != null && this.eur.getVisibility() == 0) {
            this.mNavigationBar.setStatusBarVisibility(0);
            this.bcF.setExcludeHeight(0);
            if (this.euu != null) {
                this.euu.aOb();
            }
            this.eur.aNW();
        }
    }

    public void aNZ() {
        ViewGroup viewGroup;
        if (!this.euv && (viewGroup = (ViewGroup) this.bcF.findViewById(16908290)) != null && (viewGroup.getParent() instanceof LinearLayout)) {
            this.eur = new com.baidu.tieba.pb.pb.sub.a(this.bcF.getPageContext().getPageActivity());
            this.eur.setBackgroundResource(w.e.transparent);
            ((LinearLayout) viewGroup.getParent()).addView(this.eur, 0, new LinearLayout.LayoutParams(-1, eus));
            this.eur.setVisibility(0);
            this.eur.setOnClickListener(new f(this));
            this.eur.setScrollCallBack(new g(this));
            this.bcF.setExcludeHeight(eus);
            this.euv = true;
        }
    }

    public void a(a aVar) {
        this.euu = aVar;
    }

    public boolean aOa() {
        return this.euv;
    }

    public void oy(int i) {
        if (this.eur != null) {
            com.baidu.tbadk.core.util.aq.j(this.eur, i);
        }
    }
}
