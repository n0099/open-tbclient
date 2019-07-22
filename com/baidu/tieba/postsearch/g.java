package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity iAZ;
    private a iBQ;
    private c iBR;
    private f iBS;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iAZ = postSearchActivity;
    }

    public void initView() {
        this.iAZ.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iAZ.findViewById(R.id.search_rootview);
        this.iBQ = new a(this.iAZ, this.mRootView);
        this.iBR = new c(this.iAZ, this.mRootView);
        this.iBS = new f(this.iAZ, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.iBS != null) {
            this.iBS.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.iBS.dc(false);
        this.iBR.aB(arrayList);
    }

    public void zm(int i) {
        this.iBQ.btD();
        cfS();
        this.iBQ.cfT();
        this.iBS.dc(true);
        this.iBS.zm(i);
    }

    public void Dj(String str) {
        this.iBQ.Dj(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.iBS.a(i, bVar, z);
    }

    public boolean cfX() {
        return this.iBR.cgf();
    }

    public void showLoadingView() {
        this.iBR.showLoadingView();
    }

    public void hideLoadingView() {
        this.iBR.hideLoadingView();
    }

    public void cge() {
        this.iBR.cge();
    }

    public void cfS() {
        this.iBQ.cfS();
    }

    public void cgq() {
        this.iBR.cgd();
    }

    public int getCurrentTabType() {
        return this.iBS.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.iBQ.onChangeSkinType(i);
        this.iBR.onChangeSkinType(i);
        this.iBS.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iAZ.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.iBQ != null) {
            this.iBQ.onDestroy();
        }
    }
}
