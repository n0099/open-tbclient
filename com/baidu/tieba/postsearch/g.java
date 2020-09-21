package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class g {
    private PostSearchActivity lGp;
    private a lHe;
    private c lHf;
    private f lHg;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.lGp = postSearchActivity;
    }

    public void initView() {
        this.lGp.setContentView(R.layout.post_search_activity);
        this.mRootView = this.lGp.findViewById(R.id.search_rootview);
        this.lHe = new a(this.lGp, this.mRootView);
        this.lHf = new c(this.lGp, this.mRootView);
        this.lHg = new f(this.lGp, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.lHg != null) {
            this.lHg.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bb(ArrayList<String> arrayList) {
        this.lHg.setVisibility(false);
        this.lHf.bb(arrayList);
    }

    public void Gt(int i) {
        this.lHe.cyh();
        hideSoftKeyPad();
        this.lHe.dpb();
        this.lHg.setVisibility(true);
        this.lHg.Gt(i);
    }

    public void Po(String str) {
        this.lHe.Po(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.lHg.a(i, bVar, z);
    }

    public boolean dpf() {
        return this.lHf.dpn();
    }

    public void showLoadingView() {
        this.lHf.showLoadingView();
    }

    public void hideLoadingView() {
        this.lHf.hideLoadingView();
    }

    public void dpm() {
        this.lHf.dpm();
    }

    public void hideSoftKeyPad() {
        this.lHe.hideSoftKeyPad();
    }

    public void dpy() {
        this.lHf.dpl();
    }

    public int getCurrentTabType() {
        return this.lHg.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.lHe.onChangeSkinType(i);
        this.lHf.onChangeSkinType(i);
        this.lHg.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.lGp.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.lHe != null) {
            this.lHe.onDestroy();
        }
    }
}
