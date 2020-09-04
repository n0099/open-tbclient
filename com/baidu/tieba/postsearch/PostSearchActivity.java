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
    public String hQJ;
    private g lxB;
    private d lxC;
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
        this.lxB = new g(this);
        this.lxB.initView();
        this.lxB.setOnPageChangeListener(this.mOnPageChangeListener);
        this.lxC = new d(this);
        initData();
    }

    public void wv(String str) {
        this.hQJ = str;
        this.lxB.FS(1);
        this.lxC.dlN();
        this.lxB.showLoadingView();
    }

    public void ON(String str) {
        this.lxB.ON(str);
    }

    public void dlx() {
        this.lxB.aZ(this.lxC.lxZ);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cHW())) {
            this.lxB.hideLoadingView();
            this.lxB.dlR();
            return;
        }
        this.lxB.hideLoadingView();
        this.lxB.dlF();
        this.lxB.a(i, bVar, z);
    }

    public boolean dly() {
        return this.lxB.dly();
    }

    public void hideSoftKeyPad() {
        this.lxB.hideSoftKeyPad();
    }

    public d dlz() {
        return this.lxC;
    }

    public g dlA() {
        return this.lxB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lxB.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.lxC.dlK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lxB != null) {
            this.lxB.onDestroy();
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
