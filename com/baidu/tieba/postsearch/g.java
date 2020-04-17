package com.baidu.tieba.postsearch;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private PostSearchActivity kmy;
    private a kno;
    private c knp;
    private f knq;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.kmy = postSearchActivity;
    }

    public void initView() {
        this.kmy.setContentView(R.layout.post_search_activity);
        this.mRootView = this.kmy.findViewById(R.id.search_rootview);
        this.kno = new a(this.kmy, this.mRootView);
        this.knp = new c(this.kmy, this.mRootView);
        this.knq = new f(this.kmy, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.knq != null) {
            this.knq.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void aQ(ArrayList<String> arrayList) {
        this.knq.setVisibility(false);
        this.knp.aQ(arrayList);
    }

    public void Bn(int i) {
        this.kno.bWH();
        hideSoftKeyPad();
        this.kno.cLB();
        this.knq.setVisibility(true);
        this.knq.Bn(i);
    }

    public void IU(String str) {
        this.kno.IU(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.knq.a(i, bVar, z);
    }

    public boolean cLF() {
        return this.knp.cLN();
    }

    public void showLoadingView() {
        this.knp.showLoadingView();
    }

    public void hideLoadingView() {
        this.knp.hideLoadingView();
    }

    public void cLM() {
        this.knp.cLM();
    }

    public void hideSoftKeyPad() {
        this.kno.hideSoftKeyPad();
    }

    public void cLY() {
        this.knp.cLL();
    }

    public int getCurrentTabType() {
        return this.knq.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.kno.onChangeSkinType(i);
        this.knp.onChangeSkinType(i);
        this.knq.onChangeSkinType(i);
        com.baidu.tbadk.q.a.a(this.kmy.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.kno != null) {
            this.kno.onDestroy();
        }
    }
}
