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
    public String gmn;
    private g jAJ;
    private d jAK;
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
        this.jAJ = new g(this);
        this.jAJ.initView();
        this.jAJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jAK = new d(this);
        initData();
    }

    public void qd(String str) {
        this.gmn = str;
        this.jAJ.AF(1);
        this.jAK.cAM();
        this.jAJ.showLoadingView();
    }

    public void Hm(String str) {
        this.jAJ.Hm(str);
    }

    public void cAw() {
        this.jAJ.aO(this.jAK.jBi);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bXL())) {
            this.jAJ.hideLoadingView();
            this.jAJ.cAQ();
            return;
        }
        this.jAJ.hideLoadingView();
        this.jAJ.cAE();
        this.jAJ.a(i, bVar, z);
    }

    public boolean cAx() {
        return this.jAJ.cAx();
    }

    public void hideSoftKeyPad() {
        this.jAJ.hideSoftKeyPad();
    }

    public d cAy() {
        return this.jAK;
    }

    public g cAz() {
        return this.jAJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jAJ.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.jAK.cAJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.jAJ != null) {
            this.jAJ.onDestroy();
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
