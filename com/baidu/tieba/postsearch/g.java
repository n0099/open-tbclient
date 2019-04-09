package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private a icQ;
    private c icR;
    private f icS;
    private PostSearchActivity ica;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.ica = postSearchActivity;
    }

    public void initView() {
        this.ica.setContentView(d.h.post_search_activity);
        this.mRootView = this.ica.findViewById(d.g.search_rootview);
        this.icQ = new a(this.ica, this.mRootView);
        this.icR = new c(this.ica, this.mRootView);
        this.icS = new f(this.ica, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.icS != null) {
            this.icS.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.icS.cI(false);
        this.icR.ax(arrayList);
    }

    public void xA(int i) {
        this.icQ.bkf();
        bUW();
        this.icQ.bUX();
        this.icS.cI(true);
        this.icS.xA(i);
    }

    public void Bc(String str) {
        this.icQ.Bc(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.icS.a(i, bVar, z);
    }

    public boolean bVb() {
        return this.icR.bVj();
    }

    public void showLoadingView() {
        this.icR.showLoadingView();
    }

    public void hideLoadingView() {
        this.icR.hideLoadingView();
    }

    public void bVi() {
        this.icR.bVi();
    }

    public void bUW() {
        this.icQ.bUW();
    }

    public void bVu() {
        this.icR.bVh();
    }

    public int getCurrentTabType() {
        return this.icS.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.icQ.onChangeSkinType(i);
        this.icR.onChangeSkinType(i);
        this.icS.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.ica.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.icQ != null) {
            this.icQ.onDestroy();
        }
    }
}
