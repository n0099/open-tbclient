package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class g {
    private View mRootView;
    private a miT;
    private c miU;
    private f miV;
    private PostSearchActivity mic;

    public g(PostSearchActivity postSearchActivity) {
        this.mic = postSearchActivity;
    }

    public void initView() {
        this.mic.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mic.findViewById(R.id.search_rootview);
        this.miT = new a(this.mic, this.mRootView);
        this.miU = new c(this.mic, this.mRootView);
        this.miV = new f(this.mic, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.miV != null) {
            this.miV.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void be(ArrayList<String> arrayList) {
        this.miV.setVisibility(false);
        this.miU.be(arrayList);
    }

    public void Hs(int i) {
        this.miT.cEL();
        hideSoftKeyPad();
        this.miT.dvT();
        this.miV.setVisibility(true);
        this.miV.Hs(i);
    }

    public void QB(String str) {
        this.miT.QB(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.miV.a(i, bVar, z);
    }

    public boolean dvX() {
        return this.miU.dwf();
    }

    public void showLoadingView() {
        this.miU.showLoadingView();
    }

    public void hideLoadingView() {
        this.miU.hideLoadingView();
    }

    public void dwe() {
        this.miU.dwe();
    }

    public void hideSoftKeyPad() {
        this.miT.hideSoftKeyPad();
    }

    public void dwq() {
        this.miU.dwd();
    }

    public int getCurrentTabType() {
        return this.miV.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.miT.onChangeSkinType(i);
        this.miU.onChangeSkinType(i);
        this.miV.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mic.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.miT != null) {
            this.miT.onDestroy();
        }
    }
}
