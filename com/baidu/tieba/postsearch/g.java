package com.baidu.tieba.postsearch;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class g {
    private PostSearchActivity mDk;
    private a mEb;
    private c mEc;
    private f mEd;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mDk = postSearchActivity;
    }

    public void initView() {
        this.mDk.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mDk.findViewById(R.id.search_rootview);
        this.mEb = new a(this.mDk, this.mRootView);
        this.mEc = new c(this.mDk, this.mRootView);
        this.mEd = new f(this.mDk, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mEd != null) {
            this.mEd.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bc(ArrayList<String> arrayList) {
        this.mEd.it(false);
        this.mEc.bc(arrayList);
    }

    public void Hh(int i) {
        this.mEb.cLt();
        hideSoftKeyPad();
        this.mEb.dzl();
        this.mEd.it(true);
        this.mEd.Hh(i);
    }

    public void PU(String str) {
        this.mEb.PU(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mEd.a(i, bVar, z);
    }

    public boolean dzp() {
        return this.mEc.dzx();
    }

    public void showLoadingView() {
        this.mEc.showLoadingView();
        this.mEc.hideNoDataView();
    }

    public void hideLoadingView() {
        this.mEc.hideLoadingView();
    }

    public void dzw() {
        this.mEc.dzw();
    }

    public void hideSoftKeyPad() {
        this.mEb.hideSoftKeyPad();
    }

    public void dzI() {
        this.mEc.dzv();
    }

    public int getCurrentTabType() {
        return this.mEd.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mEb.onChangeSkinType(i);
        this.mEc.onChangeSkinType(i);
        this.mEd.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mDk.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mEb != null) {
            this.mEb.onDestroy();
        }
    }
}
