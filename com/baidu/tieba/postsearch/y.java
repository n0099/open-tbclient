package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private PostSearchActivity coG;
    private a cpu;
    private k cpv;
    private x cpw;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity) {
        this.coG = postSearchActivity;
    }

    public void initView() {
        this.coG.setContentView(i.g.post_search_activity);
        this.mRootView = this.coG.findViewById(i.f.search_rootview);
        this.cpu = new a(this.coG, this.mRootView);
        this.cpv = new k(this.coG, this.mRootView);
        this.cpw = new x(this.coG, this.mRootView);
    }

    public void U(ArrayList<String> arrayList) {
        this.cpw.eO(false);
        this.cpv.U(arrayList);
    }

    public void iW(int i) {
        this.cpu.WR();
        ahP();
        this.cpu.ahQ();
        this.cpw.eO(true);
        this.cpw.iW(i);
    }

    public void jE(String str) {
        this.cpu.jE(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.cpw.a(i, jVar, z);
    }

    public boolean ahU() {
        return this.cpv.aic();
    }

    public void KS() {
        this.cpv.KS();
    }

    public void aia() {
        this.cpv.aia();
    }

    public void aib() {
        this.cpv.aib();
    }

    public void ahP() {
        this.cpu.ahP();
    }

    public void aim() {
        this.cpv.ahZ();
    }

    public void onChangeSkinType(int i) {
        this.cpu.onChangeSkinType(i);
        this.cpv.onChangeSkinType(i);
        this.cpw.onChangeSkinType(i);
        com.baidu.tbadk.f.a.a(this.coG.getPageContext(), this.mRootView);
    }
}
