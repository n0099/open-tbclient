package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes24.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String iFd;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.HA(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private g mod;
    private d moe;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mod = new g(this);
        this.mod.initView();
        this.mod.setOnPageChangeListener(this.mOnPageChangeListener);
        this.moe = new d(this);
        initData();
    }

    public void yh(String str) {
        this.iFd = str;
        this.mod.HF(1);
        this.moe.dyO();
        this.mod.showLoadingView();
    }

    public void QS(String str) {
        this.mod.QS(str);
    }

    public void dyy() {
        this.mod.be(this.moe.moC);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cUS())) {
            this.mod.hideLoadingView();
            this.mod.dyS();
            return;
        }
        this.mod.hideLoadingView();
        this.mod.dyG();
        this.mod.a(i, bVar, z);
    }

    public boolean dyz() {
        return this.mod.dyz();
    }

    public void hideSoftKeyPad() {
        this.mod.hideSoftKeyPad();
    }

    public d dyA() {
        return this.moe;
    }

    public g dyB() {
        return this.mod;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mod.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.moe.dyL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mod != null) {
            this.mod.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HA(int i) {
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
        aq dR = new aq("c12404").dR("fid", this.mForumId).dR("fname", this.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dR.al("tab_id", i2);
        }
        TiebaStatic.log(dR);
    }
}
