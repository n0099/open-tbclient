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
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String dhV;
    private g gjn;
    private d gjo;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.rQ(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjn = new g(this);
        this.gjn.initView();
        this.gjn.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gjo = new d(this);
        initData();
    }

    public void sw(String str) {
        this.dhV = str;
        this.gjn.rW(1);
        this.gjo.bnL();
        this.gjn.showLoadingView();
    }

    public void sv(String str) {
        this.gjn.sv(str);
    }

    public void bnv() {
        this.gjn.aw(this.gjo.gjL);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aMh())) {
            this.gjn.hideLoadingView();
            this.gjn.bnP();
            return;
        }
        this.gjn.hideLoadingView();
        this.gjn.bnD();
        this.gjn.a(i, bVar, z);
    }

    public boolean bnw() {
        return this.gjn.bnw();
    }

    public void bnr() {
        this.gjn.bnr();
    }

    public d bnx() {
        return this.gjo;
    }

    public g bny() {
        return this.gjn;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gjn.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gjo.bnI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gjn != null) {
            this.gjn.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rQ(int i) {
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
        an ah = new an("c12404").ah(ImageViewerConfig.FORUM_ID, this.mForumId).ah(ImageViewerConfig.FORUM_NAME, this.mForumName).ah("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ah.r(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ah);
    }
}
