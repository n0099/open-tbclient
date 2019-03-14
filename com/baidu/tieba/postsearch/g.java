package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g {
    private PostSearchActivity icn;
    private a idd;
    private c ide;
    private f idf;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.icn = postSearchActivity;
    }

    public void initView() {
        this.icn.setContentView(d.h.post_search_activity);
        this.mRootView = this.icn.findViewById(d.g.search_rootview);
        this.idd = new a(this.icn, this.mRootView);
        this.ide = new c(this.icn, this.mRootView);
        this.idf = new f(this.icn, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.idf != null) {
            this.idf.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void ax(ArrayList<String> arrayList) {
        this.idf.cI(false);
        this.ide.ax(arrayList);
    }

    public void xE(int i) {
        this.idd.bkh();
        bVa();
        this.idd.bVb();
        this.idf.cI(true);
        this.idf.xE(i);
    }

    public void Bd(String str) {
        this.idd.Bd(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.idf.a(i, bVar, z);
    }

    public boolean bVf() {
        return this.ide.bVn();
    }

    public void showLoadingView() {
        this.ide.showLoadingView();
    }

    public void hideLoadingView() {
        this.ide.hideLoadingView();
    }

    public void bVm() {
        this.ide.bVm();
    }

    public void bVa() {
        this.idd.bVa();
    }

    public void bVy() {
        this.ide.bVl();
    }

    public int getCurrentTabType() {
        return this.idf.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.idd.onChangeSkinType(i);
        this.ide.onChangeSkinType(i);
        this.idf.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.icn.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.idd != null) {
            this.idd.onDestroy();
        }
    }
}
