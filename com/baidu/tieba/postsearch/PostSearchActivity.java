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
    public String dzU;
    private g gAh;
    private d gAi;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.ta(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gAh = new g(this);
        this.gAh.initView();
        this.gAh.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gAi = new d(this);
        initData();
    }

    public void startSearch(String str) {
        this.dzU = str;
        this.gAh.tg(1);
        this.gAi.brs();
        this.gAh.showLoadingView();
    }

    public void tE(String str) {
        this.gAh.tE(str);
    }

    public void brc() {
        this.gAh.at(this.gAi.gAF);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aSe())) {
            this.gAh.hideLoadingView();
            this.gAh.brw();
            return;
        }
        this.gAh.hideLoadingView();
        this.gAh.brk();
        this.gAh.a(i, bVar, z);
    }

    public boolean brd() {
        return this.gAh.brd();
    }

    public void bqY() {
        this.gAh.bqY();
    }

    public d bre() {
        return this.gAi;
    }

    public g brf() {
        return this.gAh;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gAh.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gAi.brp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gAh != null) {
            this.gAh.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ta(int i) {
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
        am ax = new am("c12404").ax(ImageViewerConfig.FORUM_ID, this.mForumId).ax(ImageViewerConfig.FORUM_NAME, this.mForumName).ax("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ax.x(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ax);
    }
}
