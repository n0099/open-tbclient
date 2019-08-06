package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private a iCU;
    private c iCV;
    private f iCW;
    private PostSearchActivity iCd;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iCd = postSearchActivity;
    }

    public void initView() {
        this.iCd.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iCd.findViewById(R.id.search_rootview);
        this.iCU = new a(this.iCd, this.mRootView);
        this.iCV = new c(this.iCd, this.mRootView);
        this.iCW = new f(this.iCd, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.iCW != null) {
            this.iCW.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.iCW.dc(false);
        this.iCV.aB(arrayList);
    }

    public void zo(int i) {
        this.iCU.btQ();
        cgk();
        this.iCU.cgl();
        this.iCW.dc(true);
        this.iCW.zo(i);
    }

    public void Dk(String str) {
        this.iCU.Dk(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.iCW.a(i, bVar, z);
    }

    public boolean cgp() {
        return this.iCV.cgx();
    }

    public void showLoadingView() {
        this.iCV.showLoadingView();
    }

    public void hideLoadingView() {
        this.iCV.hideLoadingView();
    }

    public void cgw() {
        this.iCV.cgw();
    }

    public void cgk() {
        this.iCU.cgk();
    }

    public void cgI() {
        this.iCV.cgv();
    }

    public int getCurrentTabType() {
        return this.iCW.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.iCU.onChangeSkinType(i);
        this.iCV.onChangeSkinType(i);
        this.iCW.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iCd.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.iCU != null) {
            this.iCU.onDestroy();
        }
    }
}
