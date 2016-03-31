package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z {
    private a dSW;
    private l dSX;
    private y dSY;
    private PostSearchActivity dSg;
    private View mRootView;

    public z(PostSearchActivity postSearchActivity) {
        this.dSg = postSearchActivity;
    }

    public void initView() {
        this.dSg.setContentView(t.h.post_search_activity);
        this.mRootView = this.dSg.findViewById(t.g.search_rootview);
        this.dSW = new a(this.dSg, this.mRootView);
        this.dSX = new l(this.dSg, this.mRootView);
        this.dSY = new y(this.dSg, this.mRootView);
    }

    public void al(ArrayList<String> arrayList) {
        this.dSY.hV(false);
        this.dSX.al(arrayList);
    }

    public void oj(int i) {
        this.dSW.Uo();
        aKu();
        this.dSW.aKv();
        this.dSY.hV(true);
        this.dSY.oj(i);
    }

    public void nk(String str) {
        this.dSW.nk(str);
    }

    public void a(int i, k kVar, boolean z) {
        this.dSY.a(i, kVar, z);
    }

    public boolean aKz() {
        return this.dSX.aKH();
    }

    public void Ql() {
        this.dSX.Ql();
    }

    public void XX() {
        this.dSX.XX();
    }

    public void aKG() {
        this.dSX.aKG();
    }

    public void aKu() {
        this.dSW.aKu();
    }

    public void aKR() {
        this.dSX.aKF();
    }

    public int getCurrentTabType() {
        return this.dSY.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.dSW.onChangeSkinType(i);
        this.dSX.onChangeSkinType(i);
        this.dSY.onChangeSkinType(i);
        com.baidu.tbadk.i.a.a(this.dSg.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.dSW != null) {
            this.dSW.onDestroy();
        }
    }
}
