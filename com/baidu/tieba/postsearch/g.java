package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class g {
    private PostSearchActivity lxn;
    private a lyc;
    private c lyd;
    private f lye;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.lxn = postSearchActivity;
    }

    public void initView() {
        this.lxn.setContentView(R.layout.post_search_activity);
        this.mRootView = this.lxn.findViewById(R.id.search_rootview);
        this.lyc = new a(this.lxn, this.mRootView);
        this.lyd = new c(this.lxn, this.mRootView);
        this.lye = new f(this.lxn, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lye != null) {
            this.lye.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aZ(ArrayList<String> arrayList) {
        this.lye.setVisibility(false);
        this.lyd.aZ(arrayList);
    }

    public void FS(int i) {
        this.lyc.cuN();
        hideSoftKeyPad();
        this.lyc.dlr();
        this.lye.setVisibility(true);
        this.lye.FS(i);
    }

    public void OM(String str) {
        this.lyc.OM(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lye.a(i, bVar, z);
    }

    public boolean dlv() {
        return this.lyd.dlD();
    }

    public void showLoadingView() {
        this.lyd.showLoadingView();
    }

    public void hideLoadingView() {
        this.lyd.hideLoadingView();
    }

    public void dlC() {
        this.lyd.dlC();
    }

    public void hideSoftKeyPad() {
        this.lyc.hideSoftKeyPad();
    }

    public void dlO() {
        this.lyd.dlB();
    }

    public int getCurrentTabType() {
        return this.lye.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lyc.onChangeSkinType(i);
        this.lyd.onChangeSkinType(i);
        this.lye.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.lxn.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lyc != null) {
            this.lyc.onDestroy();
        }
    }
}
