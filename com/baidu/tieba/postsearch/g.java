package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class g {
    private PostSearchActivity lxy;
    private a lyn;
    private c lyp;
    private f lyq;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.lxy = postSearchActivity;
    }

    public void initView() {
        this.lxy.setContentView(R.layout.post_search_activity);
        this.mRootView = this.lxy.findViewById(R.id.search_rootview);
        this.lyn = new a(this.lxy, this.mRootView);
        this.lyp = new c(this.lxy, this.mRootView);
        this.lyq = new f(this.lxy, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lyq != null) {
            this.lyq.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aZ(ArrayList<String> arrayList) {
        this.lyq.setVisibility(false);
        this.lyp.aZ(arrayList);
    }

    public void FS(int i) {
        this.lyn.cuO();
        hideSoftKeyPad();
        this.lyn.dlu();
        this.lyq.setVisibility(true);
        this.lyq.FS(i);
    }

    public void ON(String str) {
        this.lyn.ON(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lyq.a(i, bVar, z);
    }

    public boolean dly() {
        return this.lyp.dlG();
    }

    public void showLoadingView() {
        this.lyp.showLoadingView();
    }

    public void hideLoadingView() {
        this.lyp.hideLoadingView();
    }

    public void dlF() {
        this.lyp.dlF();
    }

    public void hideSoftKeyPad() {
        this.lyn.hideSoftKeyPad();
    }

    public void dlR() {
        this.lyp.dlE();
    }

    public int getCurrentTabType() {
        return this.lyq.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lyn.onChangeSkinType(i);
        this.lyp.onChangeSkinType(i);
        this.lyq.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.lxy.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lyn != null) {
            this.lyn.onDestroy();
        }
    }
}
