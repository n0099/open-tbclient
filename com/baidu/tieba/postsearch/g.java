package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class g {
    private PostSearchActivity lgS;
    private a lhH;
    private c lhI;
    private f lhJ;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.lgS = postSearchActivity;
    }

    public void initView() {
        this.lgS.setContentView(R.layout.post_search_activity);
        this.mRootView = this.lgS.findViewById(R.id.search_rootview);
        this.lhH = new a(this.lgS, this.mRootView);
        this.lhI = new c(this.lgS, this.mRootView);
        this.lhJ = new f(this.lgS, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lhJ != null) {
            this.lhJ.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aT(ArrayList<String> arrayList) {
        this.lhJ.setVisibility(false);
        this.lhI.aT(arrayList);
    }

    public void Dx(int i) {
        this.lhH.ckj();
        hideSoftKeyPad();
        this.lhH.dan();
        this.lhJ.setVisibility(true);
        this.lhJ.Dx(i);
    }

    public void LT(String str) {
        this.lhH.LT(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lhJ.a(i, bVar, z);
    }

    public boolean dar() {
        return this.lhI.daz();
    }

    public void showLoadingView() {
        this.lhI.showLoadingView();
    }

    public void hideLoadingView() {
        this.lhI.hideLoadingView();
    }

    public void day() {
        this.lhI.day();
    }

    public void hideSoftKeyPad() {
        this.lhH.hideSoftKeyPad();
    }

    public void daK() {
        this.lhI.dax();
    }

    public int getCurrentTabType() {
        return this.lhJ.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lhH.onChangeSkinType(i);
        this.lhI.onChangeSkinType(i);
        this.lhJ.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.lgS.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lhH != null) {
            this.lhH.onDestroy();
        }
    }
}
