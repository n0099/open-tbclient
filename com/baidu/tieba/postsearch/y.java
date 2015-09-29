package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private PostSearchActivity cDL;
    private k cEA;
    private x cEB;
    private a cEz;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity) {
        this.cDL = postSearchActivity;
    }

    public void initView() {
        this.cDL.setContentView(i.g.post_search_activity);
        this.mRootView = this.cDL.findViewById(i.f.search_rootview);
        this.cEz = new a(this.cDL, this.mRootView);
        this.cEA = new k(this.cDL, this.mRootView);
        this.cEB = new x(this.cDL, this.mRootView);
    }

    public void ac(ArrayList<String> arrayList) {
        this.cEB.fL(false);
        this.cEA.ac(arrayList);
    }

    public void kb(int i) {
        this.cEz.Od();
        aoe();
        this.cEz.aof();
        this.cEB.fL(true);
        this.cEB.kb(i);
    }

    public void kI(String str) {
        this.cEz.kI(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.cEB.a(i, jVar, z);
    }

    public boolean aoj() {
        return this.cEA.aoq();
    }

    public void KB() {
        this.cEA.KB();
    }

    public void amT() {
        this.cEA.amT();
    }

    public void aop() {
        this.cEA.aop();
    }

    public void aoe() {
        this.cEz.aoe();
    }

    public void aoA() {
        this.cEA.aoo();
    }

    public void onChangeSkinType(int i) {
        this.cEz.onChangeSkinType(i);
        this.cEA.onChangeSkinType(i);
        this.cEB.onChangeSkinType(i);
        com.baidu.tbadk.h.a.a(this.cDL.getPageContext(), this.mRootView);
    }
}
