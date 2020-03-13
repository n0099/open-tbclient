package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity jAU;
    private a jBK;
    private c jBL;
    private f jBM;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jAU = postSearchActivity;
    }

    public void initView() {
        this.jAU.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jAU.findViewById(R.id.search_rootview);
        this.jBK = new a(this.jAU, this.mRootView);
        this.jBL = new c(this.jAU, this.mRootView);
        this.jBM = new f(this.jAU, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jBM != null) {
            this.jBM.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aO(ArrayList<String> arrayList) {
        this.jBM.setVisibility(false);
        this.jBL.aO(arrayList);
    }

    public void AF(int i) {
        this.jBK.bLN();
        hideSoftKeyPad();
        this.jBK.cAw();
        this.jBM.setVisibility(true);
        this.jBM.AF(i);
    }

    public void Hn(String str) {
        this.jBK.Hn(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jBM.a(i, bVar, z);
    }

    public boolean cAA() {
        return this.jBL.cAI();
    }

    public void showLoadingView() {
        this.jBL.showLoadingView();
    }

    public void hideLoadingView() {
        this.jBL.hideLoadingView();
    }

    public void cAH() {
        this.jBL.cAH();
    }

    public void hideSoftKeyPad() {
        this.jBK.hideSoftKeyPad();
    }

    public void cAT() {
        this.jBL.cAG();
    }

    public int getCurrentTabType() {
        return this.jBM.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jBK.onChangeSkinType(i);
        this.jBL.onChangeSkinType(i);
        this.jBM.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jAU.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jBK != null) {
            this.jBK.onDestroy();
        }
    }
}
