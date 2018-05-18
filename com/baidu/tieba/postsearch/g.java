package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity fTT;
    private a fUL;
    private c fUM;
    private f fUN;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.fTT = postSearchActivity;
    }

    public void initView() {
        this.fTT.setContentView(d.i.post_search_activity);
        this.mRootView = this.fTT.findViewById(d.g.search_rootview);
        this.fUL = new a(this.fTT, this.mRootView);
        this.fUM = new c(this.fTT, this.mRootView);
        this.fUN = new f(this.fTT, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.fUN != null) {
            this.fUN.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void as(ArrayList<String> arrayList) {
        this.fUN.eN(false);
        this.fUM.as(arrayList);
    }

    public void rB(int i) {
        this.fUL.avP();
        bhP();
        this.fUL.bhQ();
        this.fUN.eN(true);
        this.fUN.rB(i);
    }

    public void rE(String str) {
        this.fUL.rE(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.fUN.a(i, bVar, z);
    }

    public boolean bhU() {
        return this.fUM.bic();
    }

    public void showLoadingView() {
        this.fUM.showLoadingView();
    }

    public void Os() {
        this.fUM.Os();
    }

    public void bib() {
        this.fUM.bib();
    }

    public void bhP() {
        this.fUL.bhP();
    }

    public void bin() {
        this.fUM.bia();
    }

    public int getCurrentTabType() {
        return this.fUN.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.fUL.onChangeSkinType(i);
        this.fUM.onChangeSkinType(i);
        this.fUN.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.fTT.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.fUL != null) {
            this.fUL.onDestroy();
        }
    }
}
