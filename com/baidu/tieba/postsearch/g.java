package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private a iCR;
    private c iCS;
    private f iCT;
    private PostSearchActivity iCa;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iCa = postSearchActivity;
    }

    public void initView() {
        this.iCa.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iCa.findViewById(R.id.search_rootview);
        this.iCR = new a(this.iCa, this.mRootView);
        this.iCS = new c(this.iCa, this.mRootView);
        this.iCT = new f(this.iCa, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.iCT != null) {
            this.iCT.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aF(ArrayList<String> arrayList) {
        this.iCT.dt(false);
        this.iCS.aF(arrayList);
    }

    public void xV(int i) {
        this.iCR.brE();
        hideSoftKeyPad();
        this.iCR.cdW();
        this.iCT.dt(true);
        this.iCT.xV(i);
    }

    public void Cc(String str) {
        this.iCR.Cc(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.iCT.a(i, bVar, z);
    }

    public boolean cea() {
        return this.iCS.cei();
    }

    public void showLoadingView() {
        this.iCS.showLoadingView();
    }

    public void hideLoadingView() {
        this.iCS.hideLoadingView();
    }

    public void ceh() {
        this.iCS.ceh();
    }

    public void hideSoftKeyPad() {
        this.iCR.hideSoftKeyPad();
    }

    public void cet() {
        this.iCS.ceg();
    }

    public int getCurrentTabType() {
        return this.iCT.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.iCR.onChangeSkinType(i);
        this.iCS.onChangeSkinType(i);
        this.iCT.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iCa.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.iCR != null) {
            this.iCR.onDestroy();
        }
    }
}
