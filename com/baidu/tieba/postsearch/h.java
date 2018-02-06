package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class h {
    private PostSearchActivity gxZ;
    private a gyQ;
    private c gyR;
    private g gyS;
    private View mRootView;

    public h(PostSearchActivity postSearchActivity) {
        this.gxZ = postSearchActivity;
    }

    public void initView() {
        this.gxZ.setContentView(d.h.post_search_activity);
        this.mRootView = this.gxZ.findViewById(d.g.search_rootview);
        this.gyQ = new a(this.gxZ, this.mRootView);
        this.gyR = new c(this.gxZ, this.mRootView);
        this.gyS = new g(this.gxZ, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.gyS != null) {
            this.gyS.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void ar(ArrayList<String> arrayList) {
        this.gyS.fh(false);
        this.gyR.ar(arrayList);
    }

    public void ue(int i) {
        this.gyQ.aAU();
        bmJ();
        this.gyQ.bmK();
        this.gyS.fh(true);
        this.gyS.ue(i);
    }

    public void rv(String str) {
        this.gyQ.rv(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.gyS.a(i, bVar, z);
    }

    public boolean bmO() {
        return this.gyR.bmW();
    }

    public void VU() {
        this.gyR.VU();
    }

    public void VV() {
        this.gyR.VV();
    }

    public void bmV() {
        this.gyR.bmV();
    }

    public void bmJ() {
        this.gyQ.bmJ();
    }

    public void bnh() {
        this.gyR.bmU();
    }

    public int getCurrentTabType() {
        return this.gyS.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.gyQ.onChangeSkinType(i);
        this.gyR.onChangeSkinType(i);
        this.gyS.onChangeSkinType(i);
        com.baidu.tbadk.n.a.a(this.gxZ.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.gyQ != null) {
            this.gyQ.onDestroy();
        }
    }
}
