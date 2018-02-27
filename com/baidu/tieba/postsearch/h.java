package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h {
    private PostSearchActivity gxO;
    private a gyF;
    private c gyG;
    private g gyH;
    private View mRootView;

    public h(PostSearchActivity postSearchActivity) {
        this.gxO = postSearchActivity;
    }

    public void initView() {
        this.gxO.setContentView(d.h.post_search_activity);
        this.mRootView = this.gxO.findViewById(d.g.search_rootview);
        this.gyF = new a(this.gxO, this.mRootView);
        this.gyG = new c(this.gxO, this.mRootView);
        this.gyH = new g(this.gxO, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gyH != null) {
            this.gyH.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void ar(ArrayList<String> arrayList) {
        this.gyH.fh(false);
        this.gyG.ar(arrayList);
    }

    public void uf(int i) {
        this.gyF.aAT();
        bmI();
        this.gyF.bmJ();
        this.gyH.fh(true);
        this.gyH.uf(i);
    }

    public void rv(String str) {
        this.gyF.rv(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gyH.a(i, bVar, z);
    }

    public boolean bmN() {
        return this.gyG.bmV();
    }

    public void VT() {
        this.gyG.VT();
    }

    public void VU() {
        this.gyG.VU();
    }

    public void bmU() {
        this.gyG.bmU();
    }

    public void bmI() {
        this.gyF.bmI();
    }

    public void bng() {
        this.gyG.bmT();
    }

    public int getCurrentTabType() {
        return this.gyH.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gyF.onChangeSkinType(i);
        this.gyG.onChangeSkinType(i);
        this.gyH.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.gxO.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gyF != null) {
            this.gyF.onDestroy();
        }
    }
}
