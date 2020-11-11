package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class g {
    private View mRootView;
    private a moQ;
    private c moR;
    private f moS;
    private PostSearchActivity moa;

    public g(PostSearchActivity postSearchActivity) {
        this.moa = postSearchActivity;
    }

    public void initView() {
        this.moa.setContentView(R.layout.post_search_activity);
        this.mRootView = this.moa.findViewById(R.id.search_rootview);
        this.moQ = new a(this.moa, this.mRootView);
        this.moR = new c(this.moa, this.mRootView);
        this.moS = new f(this.moa, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.moS != null) {
            this.moS.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void be(ArrayList<String> arrayList) {
        this.moS.setVisibility(false);
        this.moR.be(arrayList);
    }

    public void HF(int i) {
        this.moQ.cHm();
        hideSoftKeyPad();
        this.moQ.dyv();
        this.moS.setVisibility(true);
        this.moS.HF(i);
    }

    public void QS(String str) {
        this.moQ.QS(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.moS.a(i, bVar, z);
    }

    public boolean dyz() {
        return this.moR.dyH();
    }

    public void showLoadingView() {
        this.moR.showLoadingView();
    }

    public void hideLoadingView() {
        this.moR.hideLoadingView();
    }

    public void dyG() {
        this.moR.dyG();
    }

    public void hideSoftKeyPad() {
        this.moQ.hideSoftKeyPad();
    }

    public void dyS() {
        this.moR.dyF();
    }

    public int getCurrentTabType() {
        return this.moS.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.moQ.onChangeSkinType(i);
        this.moR.onChangeSkinType(i);
        this.moS.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.moa.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.moQ != null) {
            this.moQ.onDestroy();
        }
    }
}
