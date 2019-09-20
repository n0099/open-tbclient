package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity iEv;
    private a iFm;
    private c iFn;
    private f iFo;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iEv = postSearchActivity;
    }

    public void initView() {
        this.iEv.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iEv.findViewById(R.id.search_rootview);
        this.iFm = new a(this.iEv, this.mRootView);
        this.iFn = new c(this.iEv, this.mRootView);
        this.iFo = new f(this.iEv, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.iFo != null) {
            this.iFo.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.iFo.dc(false);
        this.iFn.aB(arrayList);
    }

    public void zr(int i) {
        this.iFm.buE();
        cgY();
        this.iFm.cgZ();
        this.iFo.dc(true);
        this.iFo.zr(i);
    }

    public void DJ(String str) {
        this.iFm.DJ(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.iFo.a(i, bVar, z);
    }

    public boolean chd() {
        return this.iFn.chl();
    }

    public void showLoadingView() {
        this.iFn.showLoadingView();
    }

    public void hideLoadingView() {
        this.iFn.hideLoadingView();
    }

    public void chk() {
        this.iFn.chk();
    }

    public void cgY() {
        this.iFm.cgY();
    }

    public void chw() {
        this.iFn.chj();
    }

    public int getCurrentTabType() {
        return this.iFo.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.iFm.onChangeSkinType(i);
        this.iFn.onChangeSkinType(i);
        this.iFo.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iEv.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.iFm != null) {
            this.iFm.onDestroy();
        }
    }
}
