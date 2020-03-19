package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String gnk;
    private g jCw;
    private d jCx;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.AI(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jCw = new g(this);
        this.jCw.initView();
        this.jCw.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jCx = new d(this);
        initData();
    }

    public void qc(String str) {
        this.gnk = str;
        this.jCw.AN(1);
        this.jCx.cBj();
        this.jCw.showLoadingView();
    }

    public void Hn(String str) {
        this.jCw.Hn(str);
    }

    public void cAT() {
        this.jCw.aO(this.jCx.jCV);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bYg())) {
            this.jCw.hideLoadingView();
            this.jCw.cBn();
            return;
        }
        this.jCw.hideLoadingView();
        this.jCw.cBb();
        this.jCw.a(i, bVar, z);
    }

    public boolean cAU() {
        return this.jCw.cAU();
    }

    public void hideSoftKeyPad() {
        this.jCw.hideSoftKeyPad();
    }

    public d cAV() {
        return this.jCx;
    }

    public g cAW() {
        return this.jCw;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jCw.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.jCx.cBg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.jCw != null) {
            this.jCw.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(int i) {
        int i2 = 0;
        switch (i) {
            case 0:
                i2 = 1;
                break;
            case 1:
                i2 = 2;
                break;
            case 2:
                i2 = 3;
                break;
        }
        an cx = new an("c12404").cx("fid", this.mForumId).cx("fname", this.mForumName).cx("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            cx.X("tab_id", i2);
        }
        TiebaStatic.log(cx);
    }
}
