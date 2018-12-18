package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gGT;
    private a gHK;
    private c gHL;
    private f gHM;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gGT = postSearchActivity;
    }

    public void initView() {
        this.gGT.setContentView(e.h.post_search_activity);
        this.mRootView = this.gGT.findViewById(e.g.search_rootview);
        this.gHK = new a(this.gGT, this.mRootView);
        this.gHL = new c(this.gGT, this.mRootView);
        this.gHM = new f(this.gGT, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gHM != null) {
            this.gHM.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void at(ArrayList<String> arrayList) {
        this.gHM.setVisibility(false);
        this.gHL.at(arrayList);
    }

    public void tA(int i) {
        this.gHK.aHY();
        bsQ();
        this.gHK.bsR();
        this.gHM.setVisibility(true);
        this.gHM.tA(i);
    }

    public void ug(String str) {
        this.gHK.ug(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gHM.a(i, bVar, z);
    }

    public boolean bsV() {
        return this.gHL.btd();
    }

    public void showLoadingView() {
        this.gHL.showLoadingView();
    }

    public void hideLoadingView() {
        this.gHL.hideLoadingView();
    }

    public void btc() {
        this.gHL.btc();
    }

    public void bsQ() {
        this.gHK.bsQ();
    }

    public void bto() {
        this.gHL.btb();
    }

    public int getCurrentTabType() {
        return this.gHM.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gHK.onChangeSkinType(i);
        this.gHL.onChangeSkinType(i);
        this.gHM.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gGT.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gHK != null) {
            this.gHK.onDestroy();
        }
    }
}
