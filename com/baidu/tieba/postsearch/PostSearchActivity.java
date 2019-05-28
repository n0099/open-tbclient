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
    public String fmZ;
    private g iuK;
    private d iuL;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.yB(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iuK = new g(this);
        this.iuK.initView();
        this.iuK.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iuL = new d(this);
        initData();
    }

    public void kf(String str) {
        this.fmZ = str;
        this.iuK.yH(1);
        this.iuL.cdu();
        this.iuK.showLoadingView();
    }

    public void Cu(String str) {
        this.iuK.Cu(str);
    }

    public void cde() {
        this.iuK.aB(this.iuL.ivj);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bDw())) {
            this.iuK.hideLoadingView();
            this.iuK.cdy();
            return;
        }
        this.iuK.hideLoadingView();
        this.iuK.cdm();
        this.iuK.a(i, bVar, z);
    }

    public boolean cdf() {
        return this.iuK.cdf();
    }

    public void cda() {
        this.iuK.cda();
    }

    public d cdg() {
        return this.iuL;
    }

    public g cdh() {
        return this.iuK;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iuK.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.iuL.cdr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.iuK != null) {
            this.iuK.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yB(int i) {
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
        am bT = new am("c12404").bT("fid", this.mForumId).bT(ImageViewerConfig.FORUM_NAME, this.mForumName).bT("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            bT.P(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(bT);
    }
}
