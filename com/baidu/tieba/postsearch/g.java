package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class g {
    private PostSearchActivity mCz;
    private a mDp;
    private c mDq;
    private f mDr;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mCz = postSearchActivity;
    }

    public void initView() {
        this.mCz.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mCz.findViewById(R.id.search_rootview);
        this.mDp = new a(this.mCz, this.mRootView);
        this.mDq = new c(this.mCz, this.mRootView);
        this.mDr = new f(this.mCz, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mDr != null) {
            this.mDr.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.mDr.setVisibility(false);
        this.mDq.bh(arrayList);
    }

    public void IU(int i) {
        this.mDp.cMg();
        hideSoftKeyPad();
        this.mDp.dDm();
        this.mDr.setVisibility(true);
        this.mDr.IU(i);
    }

    public void Rw(String str) {
        this.mDp.Rw(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mDr.a(i, bVar, z);
    }

    public boolean dDq() {
        return this.mDq.dDy();
    }

    public void showLoadingView() {
        this.mDq.showLoadingView();
    }

    public void hideLoadingView() {
        this.mDq.hideLoadingView();
    }

    public void dDx() {
        this.mDq.dDx();
    }

    public void hideSoftKeyPad() {
        this.mDp.hideSoftKeyPad();
    }

    public void dDJ() {
        this.mDq.dDw();
    }

    public int getCurrentTabType() {
        return this.mDr.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mDp.onChangeSkinType(i);
        this.mDq.onChangeSkinType(i);
        this.mDr.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mCz.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mDp != null) {
            this.mDp.onDestroy();
        }
    }
}
