package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity fSN;
    private a fTF;
    private c fTG;
    private f fTH;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.fSN = postSearchActivity;
    }

    public void initView() {
        this.fSN.setContentView(d.i.post_search_activity);
        this.mRootView = this.fSN.findViewById(d.g.search_rootview);
        this.fTF = new a(this.fSN, this.mRootView);
        this.fTG = new c(this.fSN, this.mRootView);
        this.fTH = new f(this.fSN, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.fTH != null) {
            this.fTH.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void as(ArrayList<String> arrayList) {
        this.fTH.eM(false);
        this.fTG.as(arrayList);
    }

    public void rC(int i) {
        this.fTF.avQ();
        bhP();
        this.fTF.bhQ();
        this.fTH.eM(true);
        this.fTH.rC(i);
    }

    public void rB(String str) {
        this.fTF.rB(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.fTH.a(i, bVar, z);
    }

    public boolean bhU() {
        return this.fTG.bic();
    }

    public void showLoadingView() {
        this.fTG.showLoadingView();
    }

    public void Ou() {
        this.fTG.Ou();
    }

    public void bib() {
        this.fTG.bib();
    }

    public void bhP() {
        this.fTF.bhP();
    }

    public void bin() {
        this.fTG.bia();
    }

    public int getCurrentTabType() {
        return this.fTH.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.fTF.onChangeSkinType(i);
        this.fTG.onChangeSkinType(i);
        this.fTH.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.fSN.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.fTF != null) {
            this.fTF.onDestroy();
        }
    }
}
