package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gfi;
    private a gga;
    private c ggb;
    private f ggc;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gfi = postSearchActivity;
    }

    public void initView() {
        this.gfi.setContentView(d.i.post_search_activity);
        this.mRootView = this.gfi.findViewById(d.g.search_rootview);
        this.gga = new a(this.gfi, this.mRootView);
        this.ggb = new c(this.gfi, this.mRootView);
        this.ggc = new f(this.gfi, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.ggc != null) {
            this.ggc.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void as(ArrayList<String> arrayList) {
        this.ggc.eR(false);
        this.ggb.as(arrayList);
    }

    public void rN(int i) {
        this.gga.azY();
        bmN();
        this.gga.bmO();
        this.ggc.eR(true);
        this.ggc.rN(i);
    }

    public void sw(String str) {
        this.gga.sw(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.ggc.a(i, bVar, z);
    }

    public boolean bmS() {
        return this.ggb.bna();
    }

    public void showLoadingView() {
        this.ggb.showLoadingView();
    }

    public void hideLoadingView() {
        this.ggb.hideLoadingView();
    }

    public void bmZ() {
        this.ggb.bmZ();
    }

    public void bmN() {
        this.gga.bmN();
    }

    public void bnl() {
        this.ggb.bmY();
    }

    public int getCurrentTabType() {
        return this.ggc.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gga.onChangeSkinType(i);
        this.ggb.onChangeSkinType(i);
        this.ggc.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.gfi.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gga != null) {
            this.gga.onDestroy();
        }
    }
}
