package com.baidu.tieba.postsearch;

import android.view.View;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class aa {
    private PostSearchActivity bXM;
    private a bYA;
    private l bYB;
    private z bYC;
    private View mRootView;

    public aa(PostSearchActivity postSearchActivity) {
        this.bXM = postSearchActivity;
    }

    public void initView() {
        this.bXM.setContentView(com.baidu.tieba.r.post_search_activity);
        this.mRootView = this.bXM.findViewById(com.baidu.tieba.q.search_rootview);
        this.bYA = new a(this.bXM, this.mRootView);
        this.bYB = new l(this.bXM, this.mRootView);
        this.bYC = new z(this.bXM, this.mRootView);
    }

    public void O(ArrayList<String> arrayList) {
        this.bYC.ew(false);
        this.bYB.O(arrayList);
    }

    public void ic(int i) {
        this.bYA.Vj();
        afQ();
        this.bYA.afR();
        this.bYC.ew(true);
        this.bYC.ic(i);
    }

    public void iK(String str) {
        this.bYA.iK(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.bYC.a(i, jVar, z);
    }

    public boolean afV() {
        return this.bYB.agd();
    }

    public void NW() {
        this.bYB.NW();
    }

    public void agb() {
        this.bYB.agb();
    }

    public void agc() {
        this.bYB.agc();
    }

    public void afQ() {
        this.bYA.afQ();
    }

    public void agn() {
        this.bYB.aga();
    }

    public void onChangeSkinType(int i) {
        this.bYA.onChangeSkinType(i);
        this.bYB.onChangeSkinType(i);
        this.bYC.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(this.bXM.getPageContext(), this.mRootView);
    }
}
