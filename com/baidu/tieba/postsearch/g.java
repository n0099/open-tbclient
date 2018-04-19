package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity fSQ;
    private a fTI;
    private c fTJ;
    private f fTK;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.fSQ = postSearchActivity;
    }

    public void initView() {
        this.fSQ.setContentView(d.i.post_search_activity);
        this.mRootView = this.fSQ.findViewById(d.g.search_rootview);
        this.fTI = new a(this.fSQ, this.mRootView);
        this.fTJ = new c(this.fSQ, this.mRootView);
        this.fTK = new f(this.fSQ, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.fTK != null) {
            this.fTK.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void as(ArrayList<String> arrayList) {
        this.fTK.eM(false);
        this.fTJ.as(arrayList);
    }

    public void rC(int i) {
        this.fTI.avQ();
        bhP();
        this.fTI.bhQ();
        this.fTK.eM(true);
        this.fTK.rC(i);
    }

    public void rB(String str) {
        this.fTI.rB(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.fTK.a(i, bVar, z);
    }

    public boolean bhU() {
        return this.fTJ.bic();
    }

    public void showLoadingView() {
        this.fTJ.showLoadingView();
    }

    public void Ou() {
        this.fTJ.Ou();
    }

    public void bib() {
        this.fTJ.bib();
    }

    public void bhP() {
        this.fTI.bhP();
    }

    public void bin() {
        this.fTJ.bia();
    }

    public int getCurrentTabType() {
        return this.fTK.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.fTI.onChangeSkinType(i);
        this.fTJ.onChangeSkinType(i);
        this.fTK.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.fSQ.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.fTI != null) {
            this.fTI.onDestroy();
        }
    }
}
