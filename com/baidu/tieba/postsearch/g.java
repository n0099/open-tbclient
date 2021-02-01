package com.baidu.tieba.postsearch;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private PostSearchActivity mMr;
    private a mNg;
    private c mNh;
    private f mNi;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mMr = postSearchActivity;
    }

    public void initView() {
        this.mMr.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mMr.findViewById(R.id.search_rootview);
        this.mNg = new a(this.mMr, this.mRootView);
        this.mNh = new c(this.mMr, this.mRootView);
        this.mNi = new f(this.mMr, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mNi != null) {
            this.mNi.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bb(ArrayList<String> arrayList) {
        this.mNi.iv(false);
        this.mNh.bb(arrayList);
    }

    public void Hz(int i) {
        this.mNg.cNh();
        hideSoftKeyPad();
        this.mNg.dBv();
        this.mNi.iv(true);
        this.mNi.Hz(i);
    }

    public void QL(String str) {
        this.mNg.QL(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mNi.a(i, bVar, z);
    }

    public boolean dBz() {
        return this.mNh.dBH();
    }

    public void showLoadingView() {
        this.mNh.showLoadingView();
        this.mNh.hideNoDataView();
    }

    public void hideLoadingView() {
        this.mNh.hideLoadingView();
    }

    public void dBG() {
        this.mNh.dBG();
    }

    public void hideSoftKeyPad() {
        this.mNg.hideSoftKeyPad();
    }

    public void dBS() {
        this.mNh.dBF();
    }

    public int getCurrentTabType() {
        return this.mNi.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mNg.onChangeSkinType(i);
        this.mNh.onChangeSkinType(i);
        this.mNi.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mMr.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mNg != null) {
            this.mNg.onDestroy();
        }
    }
}
