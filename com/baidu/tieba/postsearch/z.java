package com.baidu.tieba.postsearch;

import android.view.View;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class z {
    private PostSearchActivity dxA;
    private a dyq;
    private l dyr;
    private y dys;
    private View mRootView;

    public z(PostSearchActivity postSearchActivity) {
        this.dxA = postSearchActivity;
    }

    public void initView() {
        this.dxA.setContentView(t.h.post_search_activity);
        this.mRootView = this.dxA.findViewById(t.g.search_rootview);
        this.dyq = new a(this.dxA, this.mRootView);
        this.dyr = new l(this.dxA, this.mRootView);
        this.dys = new y(this.dxA, this.mRootView);
    }

    public void ak(ArrayList<String> arrayList) {
        this.dys.hi(false);
        this.dyr.ak(arrayList);
    }

    public void na(int i) {
        this.dyq.Sx();
        aCG();
        this.dyq.aCH();
        this.dys.hi(true);
        this.dys.na(i);
    }

    public void lV(String str) {
        this.dyq.lV(str);
    }

    public void a(int i, k kVar, boolean z) {
        this.dys.a(i, kVar, z);
    }

    public boolean aCL() {
        return this.dyr.aCT();
    }

    public void Ow() {
        this.dyr.Ow();
    }

    public void aAV() {
        this.dyr.aAV();
    }

    public void aCS() {
        this.dyr.aCS();
    }

    public void aCG() {
        this.dyq.aCG();
    }

    public void aDd() {
        this.dyr.aCR();
    }

    public int getCurrentTabType() {
        return this.dys.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.dyq.onChangeSkinType(i);
        this.dyr.onChangeSkinType(i);
        this.dys.onChangeSkinType(i);
        com.baidu.tbadk.i.a.a(this.dxA.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.dyq != null) {
            this.dyq.onDestroy();
        }
    }
}
