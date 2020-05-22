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
    public String hli;
    private g kEA;
    private d kEB;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.BS(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kEA = new g(this);
        this.kEA.initView();
        this.kEA.setOnPageChangeListener(this.mOnPageChangeListener);
        this.kEB = new d(this);
        initData();
    }

    public void sT(String str) {
        this.hli = str;
        this.kEA.BX(1);
        this.kEB.cSS();
        this.kEA.showLoadingView();
    }

    public void KJ(String str) {
        this.kEA.KJ(str);
    }

    public void cSC() {
        this.kEA.aR(this.kEB.kEZ);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cpd())) {
            this.kEA.hideLoadingView();
            this.kEA.cSW();
            return;
        }
        this.kEA.hideLoadingView();
        this.kEA.cSK();
        this.kEA.a(i, bVar, z);
    }

    public boolean cSD() {
        return this.kEA.cSD();
    }

    public void hideSoftKeyPad() {
        this.kEA.hideSoftKeyPad();
    }

    public d cSE() {
        return this.kEB;
    }

    public g cSF() {
        return this.kEA;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kEA.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.kEB.cSP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kEA != null) {
            this.kEA.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS(int i) {
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
        an dh = new an("c12404").dh("fid", this.mForumId).dh("fname", this.mForumName).dh("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dh.ag("tab_id", i2);
        }
        TiebaStatic.log(dh);
    }
}
