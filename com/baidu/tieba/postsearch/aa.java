package com.baidu.tieba.postsearch;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa {
    private PostSearchActivity bXN;
    private a bYB;
    private l bYC;
    private z bYD;
    private View mRootView;

    public aa(PostSearchActivity postSearchActivity) {
        this.bXN = postSearchActivity;
    }

    public void initView() {
        this.bXN.setContentView(com.baidu.tieba.r.post_search_activity);
        this.mRootView = this.bXN.findViewById(com.baidu.tieba.q.search_rootview);
        this.bYB = new a(this.bXN, this.mRootView);
        this.bYC = new l(this.bXN, this.mRootView);
        this.bYD = new z(this.bXN, this.mRootView);
    }

    public void O(ArrayList<String> arrayList) {
        this.bYD.ew(false);
        this.bYC.O(arrayList);
    }

    public void ic(int i) {
        this.bYB.Vk();
        afR();
        this.bYB.afS();
        this.bYD.ew(true);
        this.bYD.ic(i);
    }

    public void iK(String str) {
        this.bYB.iK(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.bYD.a(i, jVar, z);
    }

    public boolean afW() {
        return this.bYC.age();
    }

    public void NX() {
        this.bYC.NX();
    }

    public void agc() {
        this.bYC.agc();
    }

    public void agd() {
        this.bYC.agd();
    }

    public void afR() {
        this.bYB.afR();
    }

    public void ago() {
        this.bYC.agb();
    }

    public void onChangeSkinType(int i) {
        this.bYB.onChangeSkinType(i);
        this.bYC.onChangeSkinType(i);
        this.bYD.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(this.bXN.getPageContext(), this.mRootView);
    }
}
