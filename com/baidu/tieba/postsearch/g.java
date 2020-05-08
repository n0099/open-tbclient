package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity kmC;
    private a kns;
    private c knt;
    private f knu;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.kmC = postSearchActivity;
    }

    public void initView() {
        this.kmC.setContentView(R.layout.post_search_activity);
        this.mRootView = this.kmC.findViewById(R.id.search_rootview);
        this.kns = new a(this.kmC, this.mRootView);
        this.knt = new c(this.kmC, this.mRootView);
        this.knu = new f(this.kmC, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.knu != null) {
            this.knu.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aQ(ArrayList<String> arrayList) {
        this.knu.setVisibility(false);
        this.knt.aQ(arrayList);
    }

    public void Bn(int i) {
        this.kns.bWF();
        hideSoftKeyPad();
        this.kns.cLy();
        this.knu.setVisibility(true);
        this.knu.Bn(i);
    }

    public void IX(String str) {
        this.kns.IX(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.knu.a(i, bVar, z);
    }

    public boolean cLC() {
        return this.knt.cLK();
    }

    public void showLoadingView() {
        this.knt.showLoadingView();
    }

    public void hideLoadingView() {
        this.knt.hideLoadingView();
    }

    public void cLJ() {
        this.knt.cLJ();
    }

    public void hideSoftKeyPad() {
        this.kns.hideSoftKeyPad();
    }

    public void cLV() {
        this.knt.cLI();
    }

    public int getCurrentTabType() {
        return this.knu.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.kns.onChangeSkinType(i);
        this.knt.onChangeSkinType(i);
        this.knu.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.kmC.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.kns != null) {
            this.kns.onDestroy();
        }
    }
}
