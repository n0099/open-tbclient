package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity kEx;
    private a kFn;
    private c kFo;
    private f kFp;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.kEx = postSearchActivity;
    }

    public void initView() {
        this.kEx.setContentView(R.layout.post_search_activity);
        this.mRootView = this.kEx.findViewById(R.id.search_rootview);
        this.kFn = new a(this.kEx, this.mRootView);
        this.kFo = new c(this.kEx, this.mRootView);
        this.kFp = new f(this.kEx, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.kFp != null) {
            this.kFp.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aR(ArrayList<String> arrayList) {
        this.kFp.setVisibility(false);
        this.kFo.aR(arrayList);
    }

    public void BX(int i) {
        this.kFn.cde();
        hideSoftKeyPad();
        this.kFn.cSz();
        this.kFp.setVisibility(true);
        this.kFp.BX(i);
    }

    public void KJ(String str) {
        this.kFn.KJ(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.kFp.a(i, bVar, z);
    }

    public boolean cSD() {
        return this.kFo.cSL();
    }

    public void showLoadingView() {
        this.kFo.showLoadingView();
    }

    public void hideLoadingView() {
        this.kFo.hideLoadingView();
    }

    public void cSK() {
        this.kFo.cSK();
    }

    public void hideSoftKeyPad() {
        this.kFn.hideSoftKeyPad();
    }

    public void cSW() {
        this.kFo.cSJ();
    }

    public int getCurrentTabType() {
        return this.kFp.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.kFn.onChangeSkinType(i);
        this.kFo.onChangeSkinType(i);
        this.kFp.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.kEx.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.kFn != null) {
            this.kFn.onDestroy();
        }
    }
}
