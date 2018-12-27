package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gJK;
    private a gKB;
    private c gKC;
    private f gKD;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gJK = postSearchActivity;
    }

    public void initView() {
        this.gJK.setContentView(e.h.post_search_activity);
        this.mRootView = this.gJK.findViewById(e.g.search_rootview);
        this.gKB = new a(this.gJK, this.mRootView);
        this.gKC = new c(this.gJK, this.mRootView);
        this.gKD = new f(this.gJK, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gKD != null) {
            this.gKD.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void at(ArrayList<String> arrayList) {
        this.gKD.setVisibility(false);
        this.gKC.at(arrayList);
    }

    public void tN(int i) {
        this.gKB.aIN();
        btC();
        this.gKB.btD();
        this.gKD.setVisibility(true);
        this.gKD.tN(i);
    }

    public void uj(String str) {
        this.gKB.uj(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gKD.a(i, bVar, z);
    }

    public boolean btH() {
        return this.gKC.btP();
    }

    public void showLoadingView() {
        this.gKC.showLoadingView();
    }

    public void hideLoadingView() {
        this.gKC.hideLoadingView();
    }

    public void btO() {
        this.gKC.btO();
    }

    public void btC() {
        this.gKB.btC();
    }

    public void bua() {
        this.gKC.btN();
    }

    public int getCurrentTabType() {
        return this.gKD.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gKB.onChangeSkinType(i);
        this.gKC.onChangeSkinType(i);
        this.gKD.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gJK.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gKB != null) {
            this.gKB.onDestroy();
        }
    }
}
