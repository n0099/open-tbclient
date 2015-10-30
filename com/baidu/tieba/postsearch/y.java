package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private PostSearchActivity cDW;
    private a cEK;
    private k cEL;
    private x cEM;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity) {
        this.cDW = postSearchActivity;
    }

    public void initView() {
        this.cDW.setContentView(i.g.post_search_activity);
        this.mRootView = this.cDW.findViewById(i.f.search_rootview);
        this.cEK = new a(this.cDW, this.mRootView);
        this.cEL = new k(this.cDW, this.mRootView);
        this.cEM = new x(this.cDW, this.mRootView);
    }

    public void ac(ArrayList<String> arrayList) {
        this.cEM.fL(false);
        this.cEL.ac(arrayList);
    }

    public void kb(int i) {
        this.cEK.NZ();
        aoa();
        this.cEK.aob();
        this.cEM.fL(true);
        this.cEM.kb(i);
    }

    public void kI(String str) {
        this.cEK.kI(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.cEM.a(i, jVar, z);
    }

    public boolean aof() {
        return this.cEL.aom();
    }

    public void Kx() {
        this.cEL.Kx();
    }

    public void amP() {
        this.cEL.amP();
    }

    public void aol() {
        this.cEL.aol();
    }

    public void aoa() {
        this.cEK.aoa();
    }

    public void aow() {
        this.cEL.aok();
    }

    public void onChangeSkinType(int i) {
        this.cEK.onChangeSkinType(i);
        this.cEL.onChangeSkinType(i);
        this.cEM.onChangeSkinType(i);
        com.baidu.tbadk.h.a.a(this.cDW.getPageContext(), this.mRootView);
    }
}
