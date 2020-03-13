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
    public String gmC;
    private g jAX;
    private d jAY;
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
        this.jAX = new g(this);
        this.jAX.initView();
        this.jAX.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jAY = new d(this);
        initData();
    }

    public void qd(String str) {
        this.gmC = str;
        this.jAX.AF(1);
        this.jAY.cAP();
        this.jAX.showLoadingView();
    }

    public void Hn(String str) {
        this.jAX.Hn(str);
    }

    public void cAz() {
        this.jAX.aO(this.jAY.jBw);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bXO())) {
            this.jAX.hideLoadingView();
            this.jAX.cAT();
            return;
        }
        this.jAX.hideLoadingView();
        this.jAX.cAH();
        this.jAX.a(i, bVar, z);
    }

    public boolean cAA() {
        return this.jAX.cAA();
    }

    public void hideSoftKeyPad() {
        this.jAX.hideSoftKeyPad();
    }

    public d cAB() {
        return this.jAY;
    }

    public g cAC() {
        return this.jAX;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jAX.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.jAY.cAM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.jAX != null) {
            this.jAX.onDestroy();
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
