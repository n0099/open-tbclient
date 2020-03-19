package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity jCt;
    private a jDj;
    private c jDk;
    private f jDl;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jCt = postSearchActivity;
    }

    public void initView() {
        this.jCt.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jCt.findViewById(R.id.search_rootview);
        this.jDj = new a(this.jCt, this.mRootView);
        this.jDk = new c(this.jCt, this.mRootView);
        this.jDl = new f(this.jCt, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jDl != null) {
            this.jDl.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aO(ArrayList<String> arrayList) {
        this.jDl.setVisibility(false);
        this.jDk.aO(arrayList);
    }

    public void AN(int i) {
        this.jDj.bMb();
        hideSoftKeyPad();
        this.jDj.cAQ();
        this.jDl.setVisibility(true);
        this.jDl.AN(i);
    }

    public void Hn(String str) {
        this.jDj.Hn(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jDl.a(i, bVar, z);
    }

    public boolean cAU() {
        return this.jDk.cBc();
    }

    public void showLoadingView() {
        this.jDk.showLoadingView();
    }

    public void hideLoadingView() {
        this.jDk.hideLoadingView();
    }

    public void cBb() {
        this.jDk.cBb();
    }

    public void hideSoftKeyPad() {
        this.jDj.hideSoftKeyPad();
    }

    public void cBn() {
        this.jDk.cBa();
    }

    public int getCurrentTabType() {
        return this.jDl.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jDj.onChangeSkinType(i);
        this.jDk.onChangeSkinType(i);
        this.jDl.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jCt.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jDj != null) {
            this.jDj.onDestroy();
        }
    }
}
