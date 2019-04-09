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
    public String eWU;
    private g icd;
    private d ice;
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
        this.icd = new g(this);
        this.icd.initView();
        this.icd.setOnPageChangeListener(this.mOnPageChangeListener);
        this.ice = new d(this);
        initData();
    }

    public void jg(String str) {
        this.eWU = str;
        this.icd.xA(1);
        this.ice.bVq();
        this.icd.showLoadingView();
    }

    public void Bc(String str) {
        this.icd.Bc(str);
    }

    public void bVa() {
        this.icd.ax(this.ice.icB);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bvL())) {
            this.icd.hideLoadingView();
            this.icd.bVu();
            return;
        }
        this.icd.hideLoadingView();
        this.icd.bVi();
        this.icd.a(i, bVar, z);
    }

    public boolean bVb() {
        return this.icd.bVb();
    }

    public void bUW() {
        this.icd.bUW();
    }

    public d bVc() {
        return this.ice;
    }

    public g bVd() {
        return this.icd;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.icd.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.ice.bVn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.icd != null) {
            this.icd.onDestroy();
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
