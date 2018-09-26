package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private a grS;
    private c grT;
    private f grU;
    private PostSearchActivity grb;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.grb = postSearchActivity;
    }

    public void initView() {
        this.grb.setContentView(e.h.post_search_activity);
        this.mRootView = this.grb.findViewById(e.g.search_rootview);
        this.grS = new a(this.grb, this.mRootView);
        this.grT = new c(this.grb, this.mRootView);
        this.grU = new f(this.grb, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.grU != null) {
            this.grU.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void au(ArrayList<String> arrayList) {
        this.grU.fj(false);
        this.grT.au(arrayList);
    }

    public void sq(int i) {
        this.grS.aDw();
        bon();
        this.grS.boo();
        this.grU.fj(true);
        this.grU.sq(i);
    }

    public void sZ(String str) {
        this.grS.sZ(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.grU.a(i, bVar, z);
    }

    public boolean bos() {
        return this.grT.boA();
    }

    public void showLoadingView() {
        this.grT.showLoadingView();
    }

    public void hideLoadingView() {
        this.grT.hideLoadingView();
    }

    public void boz() {
        this.grT.boz();
    }

    public void bon() {
        this.grS.bon();
    }

    public void boL() {
        this.grT.boy();
    }

    public int getCurrentTabType() {
        return this.grU.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.grS.onChangeSkinType(i);
        this.grT.onChangeSkinType(i);
        this.grU.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.grb.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.grS != null) {
            this.grS.onDestroy();
        }
    }
}
