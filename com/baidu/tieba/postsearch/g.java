package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes23.dex */
public class g {
    private View mRootView;
    private PostSearchActivity mov;
    private a mpk;
    private c mpl;
    private f mpm;

    public g(PostSearchActivity postSearchActivity) {
        this.mov = postSearchActivity;
    }

    public void initView() {
        this.mov.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mov.findViewById(R.id.search_rootview);
        this.mpk = new a(this.mov, this.mRootView);
        this.mpl = new c(this.mov, this.mRootView);
        this.mpm = new f(this.mov, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mpm != null) {
            this.mpm.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bf(ArrayList<String> arrayList) {
        this.mpm.setVisibility(false);
        this.mpl.bf(arrayList);
    }

    public void Id(int i) {
        this.mpk.cGR();
        hideSoftKeyPad();
        this.mpk.dxV();
        this.mpm.setVisibility(true);
        this.mpm.Id(i);
    }

    public void Qn(String str) {
        this.mpk.Qn(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mpm.a(i, bVar, z);
    }

    public boolean dxZ() {
        return this.mpl.dyh();
    }

    public void showLoadingView() {
        this.mpl.showLoadingView();
    }

    public void hideLoadingView() {
        this.mpl.hideLoadingView();
    }

    public void dyg() {
        this.mpl.dyg();
    }

    public void hideSoftKeyPad() {
        this.mpk.hideSoftKeyPad();
    }

    public void dys() {
        this.mpl.dyf();
    }

    public int getCurrentTabType() {
        return this.mpm.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mpk.onChangeSkinType(i);
        this.mpl.onChangeSkinType(i);
        this.mpm.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mov.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mpk != null) {
            this.mpk.onDestroy();
        }
    }
}
