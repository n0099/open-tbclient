package com.baidu.tieba.postsearch;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private PostSearchActivity mHR;
    private a mIK;
    private c mIL;
    private f mIM;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mHR = postSearchActivity;
    }

    public void initView() {
        this.mHR.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mHR.findViewById(R.id.search_rootview);
        this.mIK = new a(this.mHR, this.mRootView);
        this.mIL = new c(this.mHR, this.mRootView);
        this.mIM = new f(this.mHR, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mIM != null) {
            this.mIM.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.mIM.ix(false);
        this.mIL.bh(arrayList);
    }

    public void IO(int i) {
        this.mIK.cPl();
        hideSoftKeyPad();
        this.mIK.dDd();
        this.mIM.ix(true);
        this.mIM.IO(i);
    }

    public void Rb(String str) {
        this.mIK.Rb(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mIM.a(i, bVar, z);
    }

    public boolean dDh() {
        return this.mIL.dDp();
    }

    public void showLoadingView() {
        this.mIL.showLoadingView();
        this.mIL.hideNoDataView();
    }

    public void hideLoadingView() {
        this.mIL.hideLoadingView();
    }

    public void dDo() {
        this.mIL.dDo();
    }

    public void hideSoftKeyPad() {
        this.mIK.hideSoftKeyPad();
    }

    public void dDA() {
        this.mIL.dDn();
    }

    public int getCurrentTabType() {
        return this.mIM.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mIK.onChangeSkinType(i);
        this.mIL.onChangeSkinType(i);
        this.mIM.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mHR.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mIK != null) {
            this.mIK.onDestroy();
        }
    }
}
