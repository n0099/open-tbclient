package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity iuE;
    private a ivv;
    private c ivw;
    private f ivx;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.iuE = postSearchActivity;
    }

    public void initView() {
        this.iuE.setContentView(R.layout.post_search_activity);
        this.mRootView = this.iuE.findViewById(R.id.search_rootview);
        this.ivv = new a(this.iuE, this.mRootView);
        this.ivw = new c(this.iuE, this.mRootView);
        this.ivx = new f(this.iuE, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.ivx != null) {
            this.ivx.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aB(ArrayList<String> arrayList) {
        this.ivx.cZ(false);
        this.ivw.aB(arrayList);
    }

    public void yH(int i) {
        this.ivv.brx();
        ccX();
        this.ivv.ccY();
        this.ivx.cZ(true);
        this.ivx.yH(i);
    }

    public void Cu(String str) {
        this.ivv.Cu(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.ivx.a(i, bVar, z);
    }

    public boolean cdc() {
        return this.ivw.cdk();
    }

    public void showLoadingView() {
        this.ivw.showLoadingView();
    }

    public void hideLoadingView() {
        this.ivw.hideLoadingView();
    }

    public void cdj() {
        this.ivw.cdj();
    }

    public void ccX() {
        this.ivv.ccX();
    }

    public void cdv() {
        this.ivw.cdi();
    }

    public int getCurrentTabType() {
        return this.ivx.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.ivv.onChangeSkinType(i);
        this.ivw.onChangeSkinType(i);
        this.ivx.onChangeSkinType(i);
        com.baidu.tbadk.s.a.a(this.iuE.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.ivv != null) {
            this.ivv.onDestroy();
        }
    }
}
