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
    public String fmY;
    private g iuH;
    private d iuI;
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
        this.iuH = new g(this);
        this.iuH.initView();
        this.iuH.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iuI = new d(this);
        initData();
    }

    public void kf(String str) {
        this.fmY = str;
        this.iuH.yH(1);
        this.iuI.cdr();
        this.iuH.showLoadingView();
    }

    public void Cu(String str) {
        this.iuH.Cu(str);
    }

    public void cdb() {
        this.iuH.aB(this.iuI.ivg);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bDt())) {
            this.iuH.hideLoadingView();
            this.iuH.cdv();
            return;
        }
        this.iuH.hideLoadingView();
        this.iuH.cdj();
        this.iuH.a(i, bVar, z);
    }

    public boolean cdc() {
        return this.iuH.cdc();
    }

    public void ccX() {
        this.iuH.ccX();
    }

    public d cdd() {
        return this.iuI;
    }

    public g cde() {
        return this.iuH;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iuH.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.iuI.cdo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.iuH != null) {
            this.iuH.onDestroy();
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
