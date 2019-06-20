package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity iuI;
    private c ivA;
    private f ivB;
    private a ivz;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iuI = postSearchActivity;
    }

    public void initView() {
        this.iuI.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iuI.findViewById(R.id.search_rootview);
        this.ivz = new a(this.iuI, this.mRootView);
        this.ivA = new c(this.iuI, this.mRootView);
        this.ivB = new f(this.iuI, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.ivB != null) {
            this.ivB.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.ivB.cZ(false);
        this.ivA.aB(arrayList);
    }

    public void yH(int i) {
        this.ivz.brC();
        cdb();
        this.ivz.cdc();
        this.ivB.cZ(true);
        this.ivB.yH(i);
    }

    public void Cw(String str) {
        this.ivz.Cw(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.ivB.a(i, bVar, z);
    }

    public boolean cdg() {
        return this.ivA.cdo();
    }

    public void showLoadingView() {
        this.ivA.showLoadingView();
    }

    public void hideLoadingView() {
        this.ivA.hideLoadingView();
    }

    public void cdn() {
        this.ivA.cdn();
    }

    public void cdb() {
        this.ivz.cdb();
    }

    public void cdz() {
        this.ivA.cdm();
    }

    public int getCurrentTabType() {
        return this.ivB.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.ivz.onChangeSkinType(i);
        this.ivA.onChangeSkinType(i);
        this.ivB.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iuI.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.ivz != null) {
            this.ivz.onDestroy();
        }
    }
}
