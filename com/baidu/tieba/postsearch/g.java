package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity jAG;
    private a jBw;
    private c jBx;
    private f jBy;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jAG = postSearchActivity;
    }

    public void initView() {
        this.jAG.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jAG.findViewById(R.id.search_rootview);
        this.jBw = new a(this.jAG, this.mRootView);
        this.jBx = new c(this.jAG, this.mRootView);
        this.jBy = new f(this.jAG, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jBy != null) {
            this.jBy.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aO(ArrayList<String> arrayList) {
        this.jBy.setVisibility(false);
        this.jBx.aO(arrayList);
    }

    public void AF(int i) {
        this.jBw.bLK();
        hideSoftKeyPad();
        this.jBw.cAt();
        this.jBy.setVisibility(true);
        this.jBy.AF(i);
    }

    public void Hm(String str) {
        this.jBw.Hm(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jBy.a(i, bVar, z);
    }

    public boolean cAx() {
        return this.jBx.cAF();
    }

    public void showLoadingView() {
        this.jBx.showLoadingView();
    }

    public void hideLoadingView() {
        this.jBx.hideLoadingView();
    }

    public void cAE() {
        this.jBx.cAE();
    }

    public void hideSoftKeyPad() {
        this.jBw.hideSoftKeyPad();
    }

    public void cAQ() {
        this.jBx.cAD();
    }

    public int getCurrentTabType() {
        return this.jBy.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jBw.onChangeSkinType(i);
        this.jBx.onChangeSkinType(i);
        this.jBy.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jAG.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jBw != null) {
            this.jBw.onDestroy();
        }
    }
}
