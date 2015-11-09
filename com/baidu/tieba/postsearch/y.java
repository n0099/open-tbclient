package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private PostSearchActivity cFs;
    private a cGg;
    private k cGh;
    private x cGi;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity) {
        this.cFs = postSearchActivity;
    }

    public void initView() {
        this.cFs.setContentView(i.g.post_search_activity);
        this.mRootView = this.cFs.findViewById(i.f.search_rootview);
        this.cGg = new a(this.cFs, this.mRootView);
        this.cGh = new k(this.cFs, this.mRootView);
        this.cGi = new x(this.cFs, this.mRootView);
    }

    public void ac(ArrayList<String> arrayList) {
        this.cGi.fO(false);
        this.cGh.ac(arrayList);
    }

    public void kp(int i) {
        this.cGg.Ov();
        aoG();
        this.cGg.aoH();
        this.cGi.fO(true);
        this.cGi.kp(i);
    }

    public void kM(String str) {
        this.cGg.kM(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.cGi.a(i, jVar, z);
    }

    public boolean aoL() {
        return this.cGh.aoS();
    }

    public void KN() {
        this.cGh.KN();
    }

    public void anv() {
        this.cGh.anv();
    }

    public void aoR() {
        this.cGh.aoR();
    }

    public void aoG() {
        this.cGg.aoG();
    }

    public void apc() {
        this.cGh.aoQ();
    }

    public void onChangeSkinType(int i) {
        this.cGg.onChangeSkinType(i);
        this.cGh.onChangeSkinType(i);
        this.cGi.onChangeSkinType(i);
        com.baidu.tbadk.h.a.a(this.cFs.getPageContext(), this.mRootView);
    }
}
