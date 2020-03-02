package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity jAI;
    private f jBA;
    private a jBy;
    private c jBz;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jAI = postSearchActivity;
    }

    public void initView() {
        this.jAI.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jAI.findViewById(R.id.search_rootview);
        this.jBy = new a(this.jAI, this.mRootView);
        this.jBz = new c(this.jAI, this.mRootView);
        this.jBA = new f(this.jAI, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jBA != null) {
            this.jBA.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aO(ArrayList<String> arrayList) {
        this.jBA.setVisibility(false);
        this.jBz.aO(arrayList);
    }

    public void AF(int i) {
        this.jBy.bLM();
        hideSoftKeyPad();
        this.jBy.cAv();
        this.jBA.setVisibility(true);
        this.jBA.AF(i);
    }

    public void Hm(String str) {
        this.jBy.Hm(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jBA.a(i, bVar, z);
    }

    public boolean cAz() {
        return this.jBz.cAH();
    }

    public void showLoadingView() {
        this.jBz.showLoadingView();
    }

    public void hideLoadingView() {
        this.jBz.hideLoadingView();
    }

    public void cAG() {
        this.jBz.cAG();
    }

    public void hideSoftKeyPad() {
        this.jBy.hideSoftKeyPad();
    }

    public void cAS() {
        this.jBz.cAF();
    }

    public int getCurrentTabType() {
        return this.jBA.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jBy.onChangeSkinType(i);
        this.jBz.onChangeSkinType(i);
        this.jBA.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jAI.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jBy != null) {
            this.jBy.onDestroy();
        }
    }
}
