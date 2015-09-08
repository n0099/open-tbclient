package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private a cxR;
    private k cxS;
    private x cxT;
    private PostSearchActivity cxd;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity) {
        this.cxd = postSearchActivity;
    }

    public void initView() {
        this.cxd.setContentView(i.g.post_search_activity);
        this.mRootView = this.cxd.findViewById(i.f.search_rootview);
        this.cxR = new a(this.cxd, this.mRootView);
        this.cxS = new k(this.cxd, this.mRootView);
        this.cxT = new x(this.cxd, this.mRootView);
    }

    public void aa(ArrayList<String> arrayList) {
        this.cxT.fA(false);
        this.cxS.aa(arrayList);
    }

    public void jG(int i) {
        this.cxR.WT();
        alU();
        this.cxR.alV();
        this.cxT.fA(true);
        this.cxT.jG(i);
    }

    public void kj(String str) {
        this.cxR.kj(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.cxT.a(i, jVar, z);
    }

    public boolean alZ() {
        return this.cxS.amg();
    }

    public void KG() {
        this.cxS.KG();
    }

    public void akM() {
        this.cxS.akM();
    }

    public void amf() {
        this.cxS.amf();
    }

    public void alU() {
        this.cxR.alU();
    }

    public void amq() {
        this.cxS.ame();
    }

    public void onChangeSkinType(int i) {
        this.cxR.onChangeSkinType(i);
        this.cxS.onChangeSkinType(i);
        this.cxT.onChangeSkinType(i);
        com.baidu.tbadk.h.a.a(this.cxd.getPageContext(), this.mRootView);
    }
}
