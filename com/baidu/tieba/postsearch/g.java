package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gKO;
    private a gLF;
    private c gLG;
    private f gLH;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gKO = postSearchActivity;
    }

    public void initView() {
        this.gKO.setContentView(e.h.post_search_activity);
        this.mRootView = this.gKO.findViewById(e.g.search_rootview);
        this.gLF = new a(this.gKO, this.mRootView);
        this.gLG = new c(this.gKO, this.mRootView);
        this.gLH = new f(this.gKO, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gLH != null) {
            this.gLH.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void at(ArrayList<String> arrayList) {
        this.gLH.setVisibility(false);
        this.gLG.at(arrayList);
    }

    public void tR(int i) {
        this.gLF.aJl();
        bul();
        this.gLF.bum();
        this.gLH.setVisibility(true);
        this.gLH.tR(i);
    }

    public void uz(String str) {
        this.gLF.uz(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gLH.a(i, bVar, z);
    }

    public boolean buq() {
        return this.gLG.buy();
    }

    public void showLoadingView() {
        this.gLG.showLoadingView();
    }

    public void hideLoadingView() {
        this.gLG.hideLoadingView();
    }

    public void bux() {
        this.gLG.bux();
    }

    public void bul() {
        this.gLF.bul();
    }

    public void buJ() {
        this.gLG.buw();
    }

    public int getCurrentTabType() {
        return this.gLH.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gLF.onChangeSkinType(i);
        this.gLG.onChangeSkinType(i);
        this.gLH.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gKO.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gLF != null) {
            this.gLF.onDestroy();
        }
    }
}
