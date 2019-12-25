package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private a jwZ;
    private PostSearchActivity jwj;
    private c jxa;
    private f jxb;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jwj = postSearchActivity;
    }

    public void initView() {
        this.jwj.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jwj.findViewById(R.id.search_rootview);
        this.jwZ = new a(this.jwj, this.mRootView);
        this.jxa = new c(this.jwj, this.mRootView);
        this.jxb = new f(this.jwj, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jxb != null) {
            this.jxb.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aP(ArrayList<String> arrayList) {
        this.jxb.setVisibility(false);
        this.jxa.aP(arrayList);
    }

    public void Ar(int i) {
        this.jwZ.bJg();
        hideSoftKeyPad();
        this.jwZ.cxP();
        this.jxb.setVisibility(true);
        this.jxb.Ar(i);
    }

    public void GO(String str) {
        this.jwZ.GO(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jxb.a(i, bVar, z);
    }

    public boolean cxT() {
        return this.jxa.cyb();
    }

    public void showLoadingView() {
        this.jxa.showLoadingView();
    }

    public void hideLoadingView() {
        this.jxa.hideLoadingView();
    }

    public void cya() {
        this.jxa.cya();
    }

    public void hideSoftKeyPad() {
        this.jwZ.hideSoftKeyPad();
    }

    public void cym() {
        this.jxa.cxZ();
    }

    public int getCurrentTabType() {
        return this.jxb.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jwZ.onChangeSkinType(i);
        this.jxa.onChangeSkinType(i);
        this.jxb.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jwj.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jwZ != null) {
            this.jwZ.onDestroy();
        }
    }
}
