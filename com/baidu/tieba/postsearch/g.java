package com.baidu.tieba.postsearch;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private PostSearchActivity mHS;
    private a mIL;
    private c mIM;
    private f mIN;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mHS = postSearchActivity;
    }

    public void initView() {
        this.mHS.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mHS.findViewById(R.id.search_rootview);
        this.mIL = new a(this.mHS, this.mRootView);
        this.mIM = new c(this.mHS, this.mRootView);
        this.mIN = new f(this.mHS, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mIN != null) {
            this.mIN.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bh(ArrayList<String> arrayList) {
        this.mIN.ix(false);
        this.mIM.bh(arrayList);
    }

    public void IO(int i) {
        this.mIL.cPk();
        hideSoftKeyPad();
        this.mIL.dDc();
        this.mIN.ix(true);
        this.mIN.IO(i);
    }

    public void Rc(String str) {
        this.mIL.Rc(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mIN.a(i, bVar, z);
    }

    public boolean dDg() {
        return this.mIM.dDo();
    }

    public void showLoadingView() {
        this.mIM.showLoadingView();
        this.mIM.hideNoDataView();
    }

    public void hideLoadingView() {
        this.mIM.hideLoadingView();
    }

    public void dDn() {
        this.mIM.dDn();
    }

    public void hideSoftKeyPad() {
        this.mIL.hideSoftKeyPad();
    }

    public void dDz() {
        this.mIM.dDm();
    }

    public int getCurrentTabType() {
        return this.mIN.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mIL.onChangeSkinType(i);
        this.mIM.onChangeSkinType(i);
        this.mIN.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mHS.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mIL != null) {
            this.mIL.onDestroy();
        }
    }
}
