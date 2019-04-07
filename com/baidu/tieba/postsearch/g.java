package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity ibZ;
    private a icP;
    private c icQ;
    private f icR;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.ibZ = postSearchActivity;
    }

    public void initView() {
        this.ibZ.setContentView(d.h.post_search_activity);
        this.mRootView = this.ibZ.findViewById(d.g.search_rootview);
        this.icP = new a(this.ibZ, this.mRootView);
        this.icQ = new c(this.ibZ, this.mRootView);
        this.icR = new f(this.ibZ, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.icR != null) {
            this.icR.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.icR.cI(false);
        this.icQ.ax(arrayList);
    }

    public void xA(int i) {
        this.icP.bkf();
        bUW();
        this.icP.bUX();
        this.icR.cI(true);
        this.icR.xA(i);
    }

    public void Bc(String str) {
        this.icP.Bc(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.icR.a(i, bVar, z);
    }

    public boolean bVb() {
        return this.icQ.bVj();
    }

    public void showLoadingView() {
        this.icQ.showLoadingView();
    }

    public void hideLoadingView() {
        this.icQ.hideLoadingView();
    }

    public void bVi() {
        this.icQ.bVi();
    }

    public void bUW() {
        this.icP.bUW();
    }

    public void bVu() {
        this.icQ.bVh();
    }

    public int getCurrentTabType() {
        return this.icR.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.icP.onChangeSkinType(i);
        this.icQ.onChangeSkinType(i);
        this.icR.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.ibZ.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.icP != null) {
            this.icP.onDestroy();
        }
    }
}
