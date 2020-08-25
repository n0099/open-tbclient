package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes18.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String hQD;
    private g lxq;
    private d lxr;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.FN(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lxq = new g(this);
        this.lxq.initView();
        this.lxq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.lxr = new d(this);
        initData();
    }

    public void wu(String str) {
        this.hQD = str;
        this.lxq.FS(1);
        this.lxr.dlK();
        this.lxq.showLoadingView();
    }

    public void OM(String str) {
        this.lxq.OM(str);
    }

    public void dlu() {
        this.lxq.aZ(this.lxr.lxO);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cHV())) {
            this.lxq.hideLoadingView();
            this.lxq.dlO();
            return;
        }
        this.lxq.hideLoadingView();
        this.lxq.dlC();
        this.lxq.a(i, bVar, z);
    }

    public boolean dlv() {
        return this.lxq.dlv();
    }

    public void hideSoftKeyPad() {
        this.lxq.hideSoftKeyPad();
    }

    public d dlw() {
        return this.lxr;
    }

    public g dlx() {
        return this.lxq;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lxq.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.lxr.dlH();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lxq != null) {
            this.lxq.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FN(int i) {
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
        aq dD = new aq("c12404").dD("fid", this.mForumId).dD("fname", this.mForumName).dD("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dD.ai("tab_id", i2);
        }
        TiebaStatic.log(dD);
    }
}
