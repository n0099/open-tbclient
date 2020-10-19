package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class g {
    private PostSearchActivity lVD;
    private a lWs;
    private c lWt;
    private f lWu;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.lVD = postSearchActivity;
    }

    public void initView() {
        this.lVD.setContentView(R.layout.post_search_activity);
        this.mRootView = this.lVD.findViewById(R.id.search_rootview);
        this.lWs = new a(this.lVD, this.mRootView);
        this.lWt = new c(this.lVD, this.mRootView);
        this.lWu = new f(this.lVD, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lWu != null) {
            this.lWu.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bb(ArrayList<String> arrayList) {
        this.lWu.setVisibility(false);
        this.lWt.bb(arrayList);
    }

    public void GZ(int i) {
        this.lWs.cBE();
        hideSoftKeyPad();
        this.lWs.dsM();
        this.lWu.setVisibility(true);
        this.lWu.GZ(i);
    }

    public void Qd(String str) {
        this.lWs.Qd(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lWu.a(i, bVar, z);
    }

    public boolean dsQ() {
        return this.lWt.dsY();
    }

    public void showLoadingView() {
        this.lWt.showLoadingView();
    }

    public void hideLoadingView() {
        this.lWt.hideLoadingView();
    }

    public void dsX() {
        this.lWt.dsX();
    }

    public void hideSoftKeyPad() {
        this.lWs.hideSoftKeyPad();
    }

    public void dtj() {
        this.lWt.dsW();
    }

    public int getCurrentTabType() {
        return this.lWu.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lWs.onChangeSkinType(i);
        this.lWt.onChangeSkinType(i);
        this.lWu.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.lVD.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lWs != null) {
            this.lWs.onDestroy();
        }
    }
}
