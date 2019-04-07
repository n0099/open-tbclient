package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes6.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String eWT;
    private g icc;
    private d icd;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.xu(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.icc = new g(this);
        this.icc.initView();
        this.icc.setOnPageChangeListener(this.mOnPageChangeListener);
        this.icd = new d(this);
        initData();
    }

    public void jg(String str) {
        this.eWT = str;
        this.icc.xA(1);
        this.icd.bVq();
        this.icc.showLoadingView();
    }

    public void Bc(String str) {
        this.icc.Bc(str);
    }

    public void bVa() {
        this.icc.ax(this.icd.icA);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bvL())) {
            this.icc.hideLoadingView();
            this.icc.bVu();
            return;
        }
        this.icc.hideLoadingView();
        this.icc.bVi();
        this.icc.a(i, bVar, z);
    }

    public boolean bVb() {
        return this.icc.bVb();
    }

    public void bUW() {
        this.icc.bUW();
    }

    public d bVc() {
        return this.icd;
    }

    public g bVd() {
        return this.icc;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.icc.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.icd.bVn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.icc != null) {
            this.icc.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(int i) {
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
        am bJ = new am("c12404").bJ(ImageViewerConfig.FORUM_ID, this.mForumId).bJ(ImageViewerConfig.FORUM_NAME, this.mForumName).bJ("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            bJ.T(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(bJ);
    }
}
