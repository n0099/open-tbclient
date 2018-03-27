package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h {
    private a gyV;
    private c gyW;
    private g gyX;
    private PostSearchActivity gye;
    private View mRootView;

    public h(PostSearchActivity postSearchActivity) {
        this.gye = postSearchActivity;
    }

    public void initView() {
        this.gye.setContentView(d.h.post_search_activity);
        this.mRootView = this.gye.findViewById(d.g.search_rootview);
        this.gyV = new a(this.gye, this.mRootView);
        this.gyW = new c(this.gye, this.mRootView);
        this.gyX = new g(this.gye, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gyX != null) {
            this.gyX.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void ar(ArrayList<String> arrayList) {
        this.gyX.fh(false);
        this.gyW.ar(arrayList);
    }

    public void uf(int i) {
        this.gyV.aAV();
        bmJ();
        this.gyV.bmK();
        this.gyX.fh(true);
        this.gyX.uf(i);
    }

    public void rv(String str) {
        this.gyV.rv(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gyX.a(i, bVar, z);
    }

    public boolean bmO() {
        return this.gyW.bmW();
    }

    public void VU() {
        this.gyW.VU();
    }

    public void VV() {
        this.gyW.VV();
    }

    public void bmV() {
        this.gyW.bmV();
    }

    public void bmJ() {
        this.gyV.bmJ();
    }

    public void bnh() {
        this.gyW.bmU();
    }

    public int getCurrentTabType() {
        return this.gyX.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gyV.onChangeSkinType(i);
        this.gyW.onChangeSkinType(i);
        this.gyX.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.gye.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gyV != null) {
            this.gyV.onDestroy();
        }
    }
}
