package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gjK;
    private a gkB;
    private c gkC;
    private f gkD;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gjK = postSearchActivity;
    }

    public void initView() {
        this.gjK.setContentView(d.h.post_search_activity);
        this.mRootView = this.gjK.findViewById(d.g.search_rootview);
        this.gkB = new a(this.gjK, this.mRootView);
        this.gkC = new c(this.gjK, this.mRootView);
        this.gkD = new f(this.gjK, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gkD != null) {
            this.gkD.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void au(ArrayList<String> arrayList) {
        this.gkD.eS(false);
        this.gkC.au(arrayList);
    }

    public void rT(int i) {
        this.gkB.aBo();
        blK();
        this.gkB.blL();
        this.gkD.eS(true);
        this.gkD.rT(i);
    }

    public void so(String str) {
        this.gkB.so(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gkD.a(i, bVar, z);
    }

    public boolean blP() {
        return this.gkC.blX();
    }

    public void showLoadingView() {
        this.gkC.showLoadingView();
    }

    public void hideLoadingView() {
        this.gkC.hideLoadingView();
    }

    public void blW() {
        this.gkC.blW();
    }

    public void blK() {
        this.gkB.blK();
    }

    public void bmi() {
        this.gkC.blV();
    }

    public int getCurrentTabType() {
        return this.gkD.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gkB.onChangeSkinType(i);
        this.gkC.onChangeSkinType(i);
        this.gkD.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gjK.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gkB != null) {
            this.gkB.onDestroy();
        }
    }
}
