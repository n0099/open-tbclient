package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity kZB;
    private a lar;
    private c las;
    private f lau;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.kZB = postSearchActivity;
    }

    public void initView() {
        this.kZB.setContentView(R.layout.post_search_activity);
        this.mRootView = this.kZB.findViewById(R.id.search_rootview);
        this.lar = new a(this.kZB, this.mRootView);
        this.las = new c(this.kZB, this.mRootView);
        this.lau = new f(this.kZB, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lau != null) {
            this.lau.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aS(ArrayList<String> arrayList) {
        this.lau.setVisibility(false);
        this.las.aS(arrayList);
    }

    public void Db(int i) {
        this.lar.cgK();
        hideSoftKeyPad();
        this.lar.cXg();
        this.lau.setVisibility(true);
        this.lau.Db(i);
    }

    public void Ll(String str) {
        this.lar.Ll(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lau.a(i, bVar, z);
    }

    public boolean cXk() {
        return this.las.cXs();
    }

    public void showLoadingView() {
        this.las.showLoadingView();
    }

    public void hideLoadingView() {
        this.las.hideLoadingView();
    }

    public void cXr() {
        this.las.cXr();
    }

    public void hideSoftKeyPad() {
        this.lar.hideSoftKeyPad();
    }

    public void cXD() {
        this.las.cXq();
    }

    public int getCurrentTabType() {
        return this.lau.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lar.onChangeSkinType(i);
        this.las.onChangeSkinType(i);
        this.lau.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.kZB.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lar != null) {
            this.lar.onDestroy();
        }
    }
}
