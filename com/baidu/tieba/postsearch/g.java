package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity iCR;
    private a iDI;
    private c iDJ;
    private f iDK;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iCR = postSearchActivity;
    }

    public void initView() {
        this.iCR.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iCR.findViewById(R.id.search_rootview);
        this.iDI = new a(this.iCR, this.mRootView);
        this.iDJ = new c(this.iCR, this.mRootView);
        this.iDK = new f(this.iCR, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.iDK != null) {
            this.iDK.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aF(ArrayList<String> arrayList) {
        this.iDK.dt(false);
        this.iDJ.aF(arrayList);
    }

    public void xW(int i) {
        this.iDI.brG();
        hideSoftKeyPad();
        this.iDI.cdY();
        this.iDK.dt(true);
        this.iDK.xW(i);
    }

    public void Cc(String str) {
        this.iDI.Cc(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.iDK.a(i, bVar, z);
    }

    public boolean cec() {
        return this.iDJ.cek();
    }

    public void showLoadingView() {
        this.iDJ.showLoadingView();
    }

    public void hideLoadingView() {
        this.iDJ.hideLoadingView();
    }

    public void cej() {
        this.iDJ.cej();
    }

    public void hideSoftKeyPad() {
        this.iDI.hideSoftKeyPad();
    }

    public void cev() {
        this.iDJ.cei();
    }

    public int getCurrentTabType() {
        return this.iDK.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.iDI.onChangeSkinType(i);
        this.iDJ.onChangeSkinType(i);
        this.iDK.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iCR.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.iDI != null) {
            this.iDI.onDestroy();
        }
    }
}
