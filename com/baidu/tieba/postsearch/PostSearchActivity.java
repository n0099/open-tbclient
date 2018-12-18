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
    public String dGt;
    private g gGX;
    private d gGY;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.tu(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gGX = new g(this);
        this.gGX.initView();
        this.gGX.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gGY = new d(this);
        initData();
    }

    public void startSearch(String str) {
        this.dGt = str;
        this.gGX.tA(1);
        this.gGY.btk();
        this.gGX.showLoadingView();
    }

    public void ug(String str) {
        this.gGX.ug(str);
    }

    public void bsU() {
        this.gGX.at(this.gGY.gHv);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aTV())) {
            this.gGX.hideLoadingView();
            this.gGX.bto();
            return;
        }
        this.gGX.hideLoadingView();
        this.gGX.btc();
        this.gGX.a(i, bVar, z);
    }

    public boolean bsV() {
        return this.gGX.bsV();
    }

    public void bsQ() {
        this.gGX.bsQ();
    }

    public d bsW() {
        return this.gGY;
    }

    public g bsX() {
        return this.gGX;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gGX.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gGY.bth();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gGX != null) {
            this.gGX.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
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
        am aA = new am("c12404").aA(ImageViewerConfig.FORUM_ID, this.mForumId).aA(ImageViewerConfig.FORUM_NAME, this.mForumName).aA("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            aA.x(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(aA);
    }
}
