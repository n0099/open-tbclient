package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gyC;
    private a gzt;
    private c gzu;
    private f gzv;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gyC = postSearchActivity;
    }

    public void initView() {
        this.gyC.setContentView(e.h.post_search_activity);
        this.mRootView = this.gyC.findViewById(e.g.search_rootview);
        this.gzt = new a(this.gyC, this.mRootView);
        this.gzu = new c(this.gyC, this.mRootView);
        this.gzv = new f(this.gyC, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gzv != null) {
            this.gzv.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void au(ArrayList<String> arrayList) {
        this.gzv.fB(false);
        this.gzu.au(arrayList);
    }

    public void sN(int i) {
        this.gzt.aGO();
        brC();
        this.gzt.brD();
        this.gzv.fB(true);
        this.gzv.sN(i);
    }

    public void tz(String str) {
        this.gzt.tz(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gzv.a(i, bVar, z);
    }

    public boolean brH() {
        return this.gzu.brP();
    }

    public void showLoadingView() {
        this.gzu.showLoadingView();
    }

    public void hideLoadingView() {
        this.gzu.hideLoadingView();
    }

    public void brO() {
        this.gzu.brO();
    }

    public void brC() {
        this.gzt.brC();
    }

    public void bsa() {
        this.gzu.brN();
    }

    public int getCurrentTabType() {
        return this.gzv.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gzt.onChangeSkinType(i);
        this.gzu.onChangeSkinType(i);
        this.gzv.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gyC.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gzt != null) {
            this.gzt.onDestroy();
        }
    }
}
