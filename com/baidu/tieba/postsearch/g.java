package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class g {
    private PostSearchActivity lgU;
    private a lhJ;
    private c lhK;
    private f lhL;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.lgU = postSearchActivity;
    }

    public void initView() {
        this.lgU.setContentView(R.layout.post_search_activity);
        this.mRootView = this.lgU.findViewById(R.id.search_rootview);
        this.lhJ = new a(this.lgU, this.mRootView);
        this.lhK = new c(this.lgU, this.mRootView);
        this.lhL = new f(this.lgU, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lhL != null) {
            this.lhL.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aT(ArrayList<String> arrayList) {
        this.lhL.setVisibility(false);
        this.lhK.aT(arrayList);
    }

    public void Dx(int i) {
        this.lhJ.ckj();
        hideSoftKeyPad();
        this.lhJ.dan();
        this.lhL.setVisibility(true);
        this.lhL.Dx(i);
    }

    public void LT(String str) {
        this.lhJ.LT(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lhL.a(i, bVar, z);
    }

    public boolean dar() {
        return this.lhK.daz();
    }

    public void showLoadingView() {
        this.lhK.showLoadingView();
    }

    public void hideLoadingView() {
        this.lhK.hideLoadingView();
    }

    public void day() {
        this.lhK.day();
    }

    public void hideSoftKeyPad() {
        this.lhJ.hideSoftKeyPad();
    }

    public void daK() {
        this.lhK.dax();
    }

    public int getCurrentTabType() {
        return this.lhL.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lhJ.onChangeSkinType(i);
        this.lhK.onChangeSkinType(i);
        this.lhL.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.lgU.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lhJ != null) {
            this.lhJ.onDestroy();
        }
    }
}
