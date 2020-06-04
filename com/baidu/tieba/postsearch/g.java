package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity kFF;
    private a kGv;
    private c kGw;
    private f kGx;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.kFF = postSearchActivity;
    }

    public void initView() {
        this.kFF.setContentView(R.layout.post_search_activity);
        this.mRootView = this.kFF.findViewById(R.id.search_rootview);
        this.kGv = new a(this.kFF, this.mRootView);
        this.kGw = new c(this.kFF, this.mRootView);
        this.kGx = new f(this.kFF, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.kGx != null) {
            this.kGx.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aR(ArrayList<String> arrayList) {
        this.kGx.setVisibility(false);
        this.kGw.aR(arrayList);
    }

    public void BZ(int i) {
        this.kGv.cdm();
        hideSoftKeyPad();
        this.kGv.cSP();
        this.kGx.setVisibility(true);
        this.kGx.BZ(i);
    }

    public void KK(String str) {
        this.kGv.KK(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.kGx.a(i, bVar, z);
    }

    public boolean cST() {
        return this.kGw.cTb();
    }

    public void showLoadingView() {
        this.kGw.showLoadingView();
    }

    public void hideLoadingView() {
        this.kGw.hideLoadingView();
    }

    public void cTa() {
        this.kGw.cTa();
    }

    public void hideSoftKeyPad() {
        this.kGv.hideSoftKeyPad();
    }

    public void cTm() {
        this.kGw.cSZ();
    }

    public int getCurrentTabType() {
        return this.kGx.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.kGv.onChangeSkinType(i);
        this.kGw.onChangeSkinType(i);
        this.kGx.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.kFF.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.kGv != null) {
            this.kGv.onDestroy();
        }
    }
}
