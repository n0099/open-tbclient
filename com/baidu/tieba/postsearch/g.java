package com.baidu.tieba.postsearch;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class g {
    private PostSearchActivity mOI;
    private c mPA;
    private f mPB;
    private a mPz;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mOI = postSearchActivity;
    }

    public void initView() {
        this.mOI.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mOI.findViewById(R.id.search_rootview);
        this.mPz = new a(this.mOI, this.mRootView);
        this.mPA = new c(this.mOI, this.mRootView);
        this.mPB = new f(this.mOI, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mPB != null) {
            this.mPB.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bb(ArrayList<String> arrayList) {
        this.mPB.iv(false);
        this.mPA.bb(arrayList);
    }

    public void HC(int i) {
        this.mPz.cNu();
        hideSoftKeyPad();
        this.mPz.dBK();
        this.mPB.iv(true);
        this.mPB.HC(i);
    }

    public void QS(String str) {
        this.mPz.QS(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mPB.a(i, bVar, z);
    }

    public boolean dBO() {
        return this.mPA.dBW();
    }

    public void showLoadingView() {
        this.mPA.showLoadingView();
        this.mPA.hideNoDataView();
    }

    public void hideLoadingView() {
        this.mPA.hideLoadingView();
    }

    public void dBV() {
        this.mPA.dBV();
    }

    public void hideSoftKeyPad() {
        this.mPz.hideSoftKeyPad();
    }

    public void dCh() {
        this.mPA.dBU();
    }

    public int getCurrentTabType() {
        return this.mPB.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mPz.onChangeSkinType(i);
        this.mPA.onChangeSkinType(i);
        this.mPB.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mOI.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mPz != null) {
            this.mPz.onDestroy();
        }
    }
}
