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
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String dge;
    private g gfm;
    private d gfn;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.rH(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gfm = new g(this);
        this.gfm.initView();
        this.gfm.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gfn = new d(this);
        initData();
    }

    public void sx(String str) {
        this.dge = str;
        this.gfm.rN(1);
        this.gfn.bnh();
        this.gfm.showLoadingView();
    }

    public void sw(String str) {
        this.gfm.sw(str);
    }

    public void bmR() {
        this.gfm.as(this.gfn.gfL);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aLB())) {
            this.gfm.hideLoadingView();
            this.gfm.bnl();
            return;
        }
        this.gfm.hideLoadingView();
        this.gfm.bmZ();
        this.gfm.a(i, bVar, z);
    }

    public boolean bmS() {
        return this.gfm.bmS();
    }

    public void bmN() {
        this.gfm.bmN();
    }

    public d bmT() {
        return this.gfn;
    }

    public g bmU() {
        return this.gfm;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gfm.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gfn.bne();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gfm != null) {
            this.gfm.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rH(int i) {
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
        am ah = new am("c12404").ah(ImageViewerConfig.FORUM_ID, this.mForumId).ah(ImageViewerConfig.FORUM_NAME, this.mForumName).ah("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ah.r(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ah);
    }
}
