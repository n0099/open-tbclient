package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity iuH;
    private f ivA;
    private a ivy;
    private c ivz;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iuH = postSearchActivity;
    }

    public void initView() {
        this.iuH.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iuH.findViewById(R.id.search_rootview);
        this.ivy = new a(this.iuH, this.mRootView);
        this.ivz = new c(this.iuH, this.mRootView);
        this.ivA = new f(this.iuH, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.ivA != null) {
            this.ivA.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.ivA.cZ(false);
        this.ivz.aB(arrayList);
    }

    public void yH(int i) {
        this.ivy.brA();
        cda();
        this.ivy.cdb();
        this.ivA.cZ(true);
        this.ivA.yH(i);
    }

    public void Cu(String str) {
        this.ivy.Cu(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.ivA.a(i, bVar, z);
    }

    public boolean cdf() {
        return this.ivz.cdn();
    }

    public void showLoadingView() {
        this.ivz.showLoadingView();
    }

    public void hideLoadingView() {
        this.ivz.hideLoadingView();
    }

    public void cdm() {
        this.ivz.cdm();
    }

    public void cda() {
        this.ivy.cda();
    }

    public void cdy() {
        this.ivz.cdl();
    }

    public int getCurrentTabType() {
        return this.ivA.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.ivy.onChangeSkinType(i);
        this.ivz.onChangeSkinType(i);
        this.ivA.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iuH.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.ivy != null) {
            this.ivy.onDestroy();
        }
    }
}
