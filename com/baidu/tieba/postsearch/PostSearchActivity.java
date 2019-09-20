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
    public String fuk;
    private g iEy;
    private d iEz;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.zl(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iEy = new g(this);
        this.iEy.initView();
        this.iEy.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iEz = new d(this);
        initData();
    }

    public void ko(String str) {
        this.fuk = str;
        this.iEy.zr(1);
        this.iEz.chs();
        this.iEy.showLoadingView();
    }

    public void DJ(String str) {
        this.iEy.DJ(str);
    }

    public void chc() {
        this.iEy.aB(this.iEz.iEX);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bHg())) {
            this.iEy.hideLoadingView();
            this.iEy.chw();
            return;
        }
        this.iEy.hideLoadingView();
        this.iEy.chk();
        this.iEy.a(i, bVar, z);
    }

    public boolean chd() {
        return this.iEy.chd();
    }

    public void cgY() {
        this.iEy.cgY();
    }

    public d che() {
        return this.iEz;
    }

    public g chf() {
        return this.iEy;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iEy.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.iEz.chp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.iEy != null) {
            this.iEy.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(int i) {
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
