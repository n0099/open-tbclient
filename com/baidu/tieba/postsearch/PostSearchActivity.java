package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes6.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String fsx;
    private g iCg;
    private d iCh;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.zi(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iCg = new g(this);
        this.iCg.initView();
        this.iCg.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iCh = new d(this);
        initData();
    }

    public void km(String str) {
        this.fsx = str;
        this.iCg.zo(1);
        this.iCh.cgE();
        this.iCg.showLoadingView();
    }

    public void Dk(String str) {
        this.iCg.Dk(str);
    }

    public void cgo() {
        this.iCg.aB(this.iCh.iCF);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bGs())) {
            this.iCg.hideLoadingView();
            this.iCg.cgI();
            return;
        }
        this.iCg.hideLoadingView();
        this.iCg.cgw();
        this.iCg.a(i, bVar, z);
    }

    public boolean cgp() {
        return this.iCg.cgp();
    }

    public void cgk() {
        this.iCg.cgk();
    }

    public d cgq() {
        return this.iCh;
    }

    public g cgr() {
        return this.iCg;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iCg.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.iCh.cgB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.iCg != null) {
            this.iCg.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi(int i) {
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
        an bT = new an("c12404").bT("fid", this.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            bT.P(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(bT);
    }
}
