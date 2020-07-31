package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes18.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String hDo;
    private g lgV;
    private d lgW;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Ds(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lgV = new g(this);
        this.lgV.initView();
        this.lgV.setOnPageChangeListener(this.mOnPageChangeListener);
        this.lgW = new d(this);
        initData();
    }

    public void ue(String str) {
        this.hDo = str;
        this.lgV.Dx(1);
        this.lgW.daG();
        this.lgV.showLoadingView();
    }

    public void LT(String str) {
        this.lgV.LT(str);
    }

    public void daq() {
        this.lgV.aT(this.lgW.lht);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cxe())) {
            this.lgV.hideLoadingView();
            this.lgV.daK();
            return;
        }
        this.lgV.hideLoadingView();
        this.lgV.day();
        this.lgV.a(i, bVar, z);
    }

    public boolean dar() {
        return this.lgV.dar();
    }

    public void hideSoftKeyPad() {
        this.lgV.hideSoftKeyPad();
    }

    public d das() {
        return this.lgW;
    }

    public g dat() {
        return this.lgV;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lgV.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.lgW.daD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lgV != null) {
            this.lgV.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(int i) {
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
        ap dn = new ap("c12404").dn("fid", this.mForumId).dn("fname", this.mForumName).dn("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dn.ah("tab_id", i2);
        }
        TiebaStatic.log(dn);
    }
}
