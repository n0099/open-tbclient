package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class g {
    private a jAG;
    private c jAH;
    private f jAI;
    private PostSearchActivity jzQ;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jzQ = postSearchActivity;
    }

    public void initView() {
        this.jzQ.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jzQ.findViewById(R.id.search_rootview);
        this.jAG = new a(this.jzQ, this.mRootView);
        this.jAH = new c(this.jzQ, this.mRootView);
        this.jAI = new f(this.jzQ, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jAI != null) {
            this.jAI.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aP(ArrayList<String> arrayList) {
        this.jAI.setVisibility(false);
        this.jAH.aP(arrayList);
    }

    public void Aw(int i) {
        this.jAG.bKi();
        hideSoftKeyPad();
        this.jAG.cyY();
        this.jAI.setVisibility(true);
        this.jAI.Aw(i);
    }

    public void GY(String str) {
        this.jAG.GY(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jAI.a(i, bVar, z);
    }

    public boolean czc() {
        return this.jAH.czk();
    }

    public void showLoadingView() {
        this.jAH.showLoadingView();
    }

    public void hideLoadingView() {
        this.jAH.hideLoadingView();
    }

    public void czj() {
        this.jAH.czj();
    }

    public void hideSoftKeyPad() {
        this.jAG.hideSoftKeyPad();
    }

    public void czv() {
        this.jAH.czi();
    }

    public int getCurrentTabType() {
        return this.jAI.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jAG.onChangeSkinType(i);
        this.jAH.onChangeSkinType(i);
        this.jAI.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jzQ.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jAG != null) {
            this.jAG.onDestroy();
        }
    }
}
