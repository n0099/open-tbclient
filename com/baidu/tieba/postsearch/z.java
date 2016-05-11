package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z {
    private PostSearchActivity dUY;
    private a dVO;
    private l dVP;
    private y dVQ;
    private View mRootView;

    public z(PostSearchActivity postSearchActivity) {
        this.dUY = postSearchActivity;
    }

    public void initView() {
        this.dUY.setContentView(t.h.post_search_activity);
        this.mRootView = this.dUY.findViewById(t.g.search_rootview);
        this.dVO = new a(this.dUY, this.mRootView);
        this.dVP = new l(this.dUY, this.mRootView);
        this.dVQ = new y(this.dUY, this.mRootView);
    }

    public void ak(ArrayList<String> arrayList) {
        this.dVQ.iF(false);
        this.dVP.ak(arrayList);
    }

    public void nZ(int i) {
        this.dVO.Um();
        aKy();
        this.dVO.aKz();
        this.dVQ.iF(true);
        this.dVQ.nZ(i);
    }

    public void nj(String str) {
        this.dVO.nj(str);
    }

    public void a(int i, k kVar, boolean z) {
        this.dVQ.a(i, kVar, z);
    }

    public boolean aKD() {
        return this.dVP.aKL();
    }

    public void Pc() {
        this.dVP.Pc();
    }

    public void Pd() {
        this.dVP.Pd();
    }

    public void aKK() {
        this.dVP.aKK();
    }

    public void aKy() {
        this.dVO.aKy();
    }

    public void aKV() {
        this.dVP.aKJ();
    }

    public int getCurrentTabType() {
        return this.dVQ.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.dVO.onChangeSkinType(i);
        this.dVP.onChangeSkinType(i);
        this.dVQ.onChangeSkinType(i);
        com.baidu.tbadk.i.a.a(this.dUY.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.dVO != null) {
            this.dVO.onDestroy();
        }
    }
}
