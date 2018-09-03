package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gjJ;
    private a gkA;
    private c gkB;
    private f gkC;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gjJ = postSearchActivity;
    }

    public void initView() {
        this.gjJ.setContentView(f.h.post_search_activity);
        this.mRootView = this.gjJ.findViewById(f.g.search_rootview);
        this.gkA = new a(this.gjJ, this.mRootView);
        this.gkB = new c(this.gjJ, this.mRootView);
        this.gkC = new f(this.gjJ, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gkC != null) {
            this.gkC.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void au(ArrayList<String> arrayList) {
        this.gkC.eS(false);
        this.gkB.au(arrayList);
    }

    public void rT(int i) {
        this.gkA.aBl();
        blH();
        this.gkA.blI();
        this.gkC.eS(true);
        this.gkC.rT(i);
    }

    public void ss(String str) {
        this.gkA.ss(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gkC.a(i, bVar, z);
    }

    public boolean blM() {
        return this.gkB.blU();
    }

    public void showLoadingView() {
        this.gkB.showLoadingView();
    }

    public void hideLoadingView() {
        this.gkB.hideLoadingView();
    }

    public void blT() {
        this.gkB.blT();
    }

    public void blH() {
        this.gkA.blH();
    }

    public void bmf() {
        this.gkB.blS();
    }

    public int getCurrentTabType() {
        return this.gkC.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gkA.onChangeSkinType(i);
        this.gkB.onChangeSkinType(i);
        this.gkC.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gjJ.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gkA != null) {
            this.gkA.onDestroy();
        }
    }
}
