package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private a gAU;
    private c gAV;
    private f gAW;
    private PostSearchActivity gAd;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gAd = postSearchActivity;
    }

    public void initView() {
        this.gAd.setContentView(e.h.post_search_activity);
        this.mRootView = this.gAd.findViewById(e.g.search_rootview);
        this.gAU = new a(this.gAd, this.mRootView);
        this.gAV = new c(this.gAd, this.mRootView);
        this.gAW = new f(this.gAd, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gAW != null) {
            this.gAW.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void at(ArrayList<String> arrayList) {
        this.gAW.setVisibility(false);
        this.gAV.at(arrayList);
    }

    public void tg(int i) {
        this.gAU.aGm();
        bqY();
        this.gAU.bqZ();
        this.gAW.setVisibility(true);
        this.gAW.tg(i);
    }

    public void tE(String str) {
        this.gAU.tE(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gAW.a(i, bVar, z);
    }

    public boolean brd() {
        return this.gAV.brl();
    }

    public void showLoadingView() {
        this.gAV.showLoadingView();
    }

    public void hideLoadingView() {
        this.gAV.hideLoadingView();
    }

    public void brk() {
        this.gAV.brk();
    }

    public void bqY() {
        this.gAU.bqY();
    }

    public void brw() {
        this.gAV.brj();
    }

    public int getCurrentTabType() {
        return this.gAW.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gAU.onChangeSkinType(i);
        this.gAV.onChangeSkinType(i);
        this.gAW.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gAd.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gAU != null) {
            this.gAU.onDestroy();
        }
    }
}
