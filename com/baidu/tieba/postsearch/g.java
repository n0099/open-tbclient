package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gjj;
    private a gka;
    private c gkb;
    private f gkc;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gjj = postSearchActivity;
    }

    public void initView() {
        this.gjj.setContentView(d.i.post_search_activity);
        this.mRootView = this.gjj.findViewById(d.g.search_rootview);
        this.gka = new a(this.gjj, this.mRootView);
        this.gkb = new c(this.gjj, this.mRootView);
        this.gkc = new f(this.gjj, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gkc != null) {
            this.gkc.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aw(ArrayList<String> arrayList) {
        this.gkc.eR(false);
        this.gkb.aw(arrayList);
    }

    public void rW(int i) {
        this.gka.aAF();
        bnr();
        this.gka.bns();
        this.gkc.eR(true);
        this.gkc.rW(i);
    }

    public void sv(String str) {
        this.gka.sv(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gkc.a(i, bVar, z);
    }

    public boolean bnw() {
        return this.gkb.bnE();
    }

    public void showLoadingView() {
        this.gkb.showLoadingView();
    }

    public void hideLoadingView() {
        this.gkb.hideLoadingView();
    }

    public void bnD() {
        this.gkb.bnD();
    }

    public void bnr() {
        this.gka.bnr();
    }

    public void bnP() {
        this.gkb.bnC();
    }

    public int getCurrentTabType() {
        return this.gkc.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gka.onChangeSkinType(i);
        this.gkb.onChangeSkinType(i);
        this.gkc.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.gjj.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gka != null) {
            this.gka.onDestroy();
        }
    }
}
