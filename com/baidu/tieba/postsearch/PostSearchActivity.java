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
    public String gmp;
    private g jAL;
    private d jAM;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.AA(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jAL = new g(this);
        this.jAL.initView();
        this.jAL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jAM = new d(this);
        initData();
    }

    public void qd(String str) {
        this.gmp = str;
        this.jAL.AF(1);
        this.jAM.cAO();
        this.jAL.showLoadingView();
    }

    public void Hm(String str) {
        this.jAL.Hm(str);
    }

    public void cAy() {
        this.jAL.aO(this.jAM.jBk);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bXN())) {
            this.jAL.hideLoadingView();
            this.jAL.cAS();
            return;
        }
        this.jAL.hideLoadingView();
        this.jAL.cAG();
        this.jAL.a(i, bVar, z);
    }

    public boolean cAz() {
        return this.jAL.cAz();
    }

    public void hideSoftKeyPad() {
        this.jAL.hideSoftKeyPad();
    }

    public d cAA() {
        return this.jAM;
    }

    public g cAB() {
        return this.jAL;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jAL.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.jAM.cAL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.jAL != null) {
            this.jAL.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(int i) {
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
        an cy = new an("c12404").cy("fid", this.mForumId).cy("fname", this.mForumName).cy("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            cy.X("tab_id", i2);
        }
        TiebaStatic.log(cy);
    }
}
