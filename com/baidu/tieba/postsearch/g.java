package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {
    private PostSearchActivity gyB;
    private a gzs;
    private c gzt;
    private f gzu;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.gyB = postSearchActivity;
    }

    public void initView() {
        this.gyB.setContentView(e.h.post_search_activity);
        this.mRootView = this.gyB.findViewById(e.g.search_rootview);
        this.gzs = new a(this.gyB, this.mRootView);
        this.gzt = new c(this.gyB, this.mRootView);
        this.gzu = new f(this.gyB, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gzu != null) {
            this.gzu.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void au(ArrayList<String> arrayList) {
        this.gzu.fB(false);
        this.gzt.au(arrayList);
    }

    public void sN(int i) {
        this.gzs.aGO();
        brC();
        this.gzs.brD();
        this.gzu.fB(true);
        this.gzu.sN(i);
    }

    public void tz(String str) {
        this.gzs.tz(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gzu.a(i, bVar, z);
    }

    public boolean brH() {
        return this.gzt.brP();
    }

    public void showLoadingView() {
        this.gzt.showLoadingView();
    }

    public void hideLoadingView() {
        this.gzt.hideLoadingView();
    }

    public void brO() {
        this.gzt.brO();
    }

    public void brC() {
        this.gzs.brC();
    }

    public void bsa() {
        this.gzt.brN();
    }

    public int getCurrentTabType() {
        return this.gzu.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gzs.onChangeSkinType(i);
        this.gzt.onChangeSkinType(i);
        this.gzu.onChangeSkinType(i);
        com.baidu.tbadk.o.a.a(this.gyB.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gzs != null) {
            this.gzs.onDestroy();
        }
    }
}
