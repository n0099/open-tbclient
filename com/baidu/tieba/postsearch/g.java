package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gKP;
    private a gLG;
    private c gLH;
    private f gLI;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gKP = postSearchActivity;
    }

    public void initView() {
        this.gKP.setContentView(e.h.post_search_activity);
        this.mRootView = this.gKP.findViewById(e.g.search_rootview);
        this.gLG = new a(this.gKP, this.mRootView);
        this.gLH = new c(this.gKP, this.mRootView);
        this.gLI = new f(this.gKP, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gLI != null) {
            this.gLI.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void at(ArrayList<String> arrayList) {
        this.gLI.setVisibility(false);
        this.gLH.at(arrayList);
    }

    public void tR(int i) {
        this.gLG.aJl();
        bul();
        this.gLG.bum();
        this.gLI.setVisibility(true);
        this.gLI.tR(i);
    }

    public void uz(String str) {
        this.gLG.uz(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gLI.a(i, bVar, z);
    }

    public boolean buq() {
        return this.gLH.buy();
    }

    public void showLoadingView() {
        this.gLH.showLoadingView();
    }

    public void hideLoadingView() {
        this.gLH.hideLoadingView();
    }

    public void bux() {
        this.gLH.bux();
    }

    public void bul() {
        this.gLG.bul();
    }

    public void buJ() {
        this.gLH.buw();
    }

    public int getCurrentTabType() {
        return this.gLI.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gLG.onChangeSkinType(i);
        this.gLH.onChangeSkinType(i);
        this.gLI.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gKP.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gLG != null) {
            this.gLG.onDestroy();
        }
    }
}
