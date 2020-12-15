package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class g {
    private PostSearchActivity mCB;
    private a mDr;
    private c mDs;
    private f mDt;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mCB = postSearchActivity;
    }

    public void initView() {
        this.mCB.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mCB.findViewById(R.id.search_rootview);
        this.mDr = new a(this.mCB, this.mRootView);
        this.mDs = new c(this.mCB, this.mRootView);
        this.mDt = new f(this.mCB, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mDt != null) {
            this.mDt.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.mDt.setVisibility(false);
        this.mDs.bh(arrayList);
    }

    public void IU(int i) {
        this.mDr.cMh();
        hideSoftKeyPad();
        this.mDr.dDn();
        this.mDt.setVisibility(true);
        this.mDt.IU(i);
    }

    public void Rw(String str) {
        this.mDr.Rw(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mDt.a(i, bVar, z);
    }

    public boolean dDr() {
        return this.mDs.dDz();
    }

    public void showLoadingView() {
        this.mDs.showLoadingView();
    }

    public void hideLoadingView() {
        this.mDs.hideLoadingView();
    }

    public void dDy() {
        this.mDs.dDy();
    }

    public void hideSoftKeyPad() {
        this.mDr.hideSoftKeyPad();
    }

    public void dDK() {
        this.mDs.dDx();
    }

    public int getCurrentTabType() {
        return this.mDt.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mDr.onChangeSkinType(i);
        this.mDs.onChangeSkinType(i);
        this.mDt.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mCB.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mDr != null) {
            this.mDr.onDestroy();
        }
    }
}
