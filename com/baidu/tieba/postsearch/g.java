package com.baidu.tieba.postsearch;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class g {
    private PostSearchActivity mMG;
    private a mNv;
    private c mNw;
    private f mNx;
    private View mRootView;

    public g(PostSearchActivity postSearchActivity) {
        this.mMG = postSearchActivity;
    }

    public void initView() {
        this.mMG.setContentView(R.layout.post_search_activity);
        this.mRootView = this.mMG.findViewById(R.id.search_rootview);
        this.mNv = new a(this.mMG, this.mRootView);
        this.mNw = new c(this.mMG, this.mRootView);
        this.mNx = new f(this.mMG, this.mRootView);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        if (this.mNx != null) {
            this.mNx.setOnPageChangeListener(onPageChangeListener);
        }
    }

    public void bb(ArrayList<String> arrayList) {
        this.mNx.iv(false);
        this.mNw.bb(arrayList);
    }

    public void Hz(int i) {
        this.mNv.cNo();
        hideSoftKeyPad();
        this.mNv.dBC();
        this.mNx.iv(true);
        this.mNx.Hz(i);
    }

    public void QM(String str) {
        this.mNv.QM(str);
    }

    public void a(int i, b bVar, boolean z) {
        this.mNx.a(i, bVar, z);
    }

    public boolean dBG() {
        return this.mNw.dBO();
    }

    public void showLoadingView() {
        this.mNw.showLoadingView();
        this.mNw.hideNoDataView();
    }

    public void hideLoadingView() {
        this.mNw.hideLoadingView();
    }

    public void dBN() {
        this.mNw.dBN();
    }

    public void hideSoftKeyPad() {
        this.mNv.hideSoftKeyPad();
    }

    public void dBZ() {
        this.mNw.dBM();
    }

    public int getCurrentTabType() {
        return this.mNx.getCurrentTabType();
    }

    public void onChangeSkinType(int i) {
        this.mNv.onChangeSkinType(i);
        this.mNw.onChangeSkinType(i);
        this.mNx.onChangeSkinType(i);
        com.baidu.tbadk.r.a.a(this.mMG.getPageContext(), this.mRootView);
    }

    public void onDestroy() {
        if (this.mNv != null) {
            this.mNv.onDestroy();
        }
    }
}
