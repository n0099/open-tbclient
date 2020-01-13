package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class g {
    private a jAB;
    private c jAC;
    private f jAD;
    private PostSearchActivity jzL;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.jzL = postSearchActivity;
    }

    public void initView() {
        this.jzL.setContentView(R.layout.post_search_activity);
        this.mRootView = this.jzL.findViewById(R.id.search_rootview);
        this.jAB = new a(this.jzL, this.mRootView);
        this.jAC = new c(this.jzL, this.mRootView);
        this.jAD = new f(this.jzL, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.jAD != null) {
            this.jAD.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aP(ArrayList<String> arrayList) {
        this.jAD.setVisibility(false);
        this.jAC.aP(arrayList);
    }

    public void Aw(int i) {
        this.jAB.bKi();
        hideSoftKeyPad();
        this.jAB.cyW();
        this.jAD.setVisibility(true);
        this.jAD.Aw(i);
    }

    public void GY(String str) {
        this.jAB.GY(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.jAD.a(i, bVar, z);
    }

    public boolean cza() {
        return this.jAC.czi();
    }

    public void showLoadingView() {
        this.jAC.showLoadingView();
    }

    public void hideLoadingView() {
        this.jAC.hideLoadingView();
    }

    public void czh() {
        this.jAC.czh();
    }

    public void hideSoftKeyPad() {
        this.jAB.hideSoftKeyPad();
    }

    public void czt() {
        this.jAC.czg();
    }

    public int getCurrentTabType() {
        return this.jAD.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.jAB.onChangeSkinType(i);
        this.jAC.onChangeSkinType(i);
        this.jAD.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.jzL.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.jAB != null) {
            this.jAB.onDestroy();
        }
    }
}
