package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z {
    private PostSearchActivity djG;
    private a dkv;
    private l dkw;
    private y dkx;
    private View mRootView;

    public z(PostSearchActivity postSearchActivity) {
        this.djG = postSearchActivity;
    }

    public void initView() {
        this.djG.setContentView(n.h.post_search_activity);
        this.mRootView = this.djG.findViewById(n.g.search_rootview);
        this.dkv = new a(this.djG, this.mRootView);
        this.dkw = new l(this.djG, this.mRootView);
        this.dkx = new y(this.djG, this.mRootView);
    }

    public void aj(ArrayList<String> arrayList) {
        this.dkx.gM(false);
        this.dkw.aj(arrayList);
    }

    public void lZ(int i) {
        this.dkv.Qt();
        awl();
        this.dkv.awm();
        this.dkx.gM(true);
        this.dkx.lZ(i);
    }

    public void lH(String str) {
        this.dkv.lH(str);
    }

    public void a(int i, k kVar, boolean z) {
        this.dkx.a(i, kVar, z);
    }

    public boolean awq() {
        return this.dkw.awx();
    }

    public void MF() {
        this.dkw.MF();
    }

    public void auH() {
        this.dkw.auH();
    }

    public void aww() {
        this.dkw.aww();
    }

    public void awl() {
        this.dkv.awl();
    }

    public void awH() {
        this.dkw.awv();
    }

    public void onChangeSkinType(int i) {
        this.dkv.onChangeSkinType(i);
        this.dkw.onChangeSkinType(i);
        this.dkx.onChangeSkinType(i);
        com.baidu.tbadk.i.a.a(this.djG.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.dkv != null) {
            this.dkv.onDestroy();
        }
    }
}
