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
    public String eXh;
    private g icq;
    private d icr;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.xy(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.icq = new g(this);
        this.icq.initView();
        this.icq.setOnPageChangeListener(this.mOnPageChangeListener);
        this.icr = new d(this);
        initData();
    }

    public void jf(String str) {
        this.eXh = str;
        this.icq.xE(1);
        this.icr.bVu();
        this.icq.showLoadingView();
    }

    public void Bd(String str) {
        this.icq.Bd(str);
    }

    public void bVe() {
        this.icq.ax(this.icr.icO);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bvO())) {
            this.icq.hideLoadingView();
            this.icq.bVy();
            return;
        }
        this.icq.hideLoadingView();
        this.icq.bVm();
        this.icq.a(i, bVar, z);
    }

    public boolean bVf() {
        return this.icq.bVf();
    }

    public void bVa() {
        this.icq.bVa();
    }

    public d bVg() {
        return this.icr;
    }

    public g bVh() {
        return this.icq;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.icq.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.icr.bVr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.icq != null) {
            this.icq.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(int i) {
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
