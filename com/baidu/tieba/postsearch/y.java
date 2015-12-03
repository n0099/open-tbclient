package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class y {
    private a deP;
    private k deQ;
    private x deR;
    private PostSearchActivity deb;
    private View mRootView;

    public y(PostSearchActivity postSearchActivity) {
        this.deb = postSearchActivity;
    }

    public void initView() {
        this.deb.setContentView(n.g.post_search_activity);
        this.mRootView = this.deb.findViewById(n.f.search_rootview);
        this.deP = new a(this.deb, this.mRootView);
        this.deQ = new k(this.deb, this.mRootView);
        this.deR = new x(this.deb, this.mRootView);
    }

    public void aj(ArrayList<String> arrayList) {
        this.deR.gG(false);
        this.deQ.aj(arrayList);
    }

    public void lA(int i) {
        this.deP.Qb();
        aus();
        this.deP.aut();
        this.deR.gG(true);
        this.deR.lA(i);
    }

    public void lJ(String str) {
        this.deP.lJ(str);
    }

    public void a(int i, j jVar, boolean z) {
        this.deR.a(i, jVar, z);
    }

    public boolean aux() {
        return this.deQ.auE();
    }

    public void Mm() {
        this.deQ.Mm();
    }

    public void asV() {
        this.deQ.asV();
    }

    public void auD() {
        this.deQ.auD();
    }

    public void aus() {
        this.deP.aus();
    }

    public void auO() {
        this.deQ.auC();
    }

    public void onChangeSkinType(int i) {
        this.deP.onChangeSkinType(i);
        this.deQ.onChangeSkinType(i);
        this.deR.onChangeSkinType(i);
        com.baidu.tbadk.i.a.a(this.deb.getPageContext(), this.mRootView);
    }
}
