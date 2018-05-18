package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String cWR;
    private g fTX;
    private d fTY;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.rv(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fTX = new g(this);
        this.fTX.initView();
        this.fTX.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fTY = new d(this);
        initData();
    }

    public void rF(String str) {
        this.cWR = str;
        this.fTX.rB(1);
        this.fTY.bij();
        this.fTX.showLoadingView();
    }

    public void rE(String str) {
        this.fTX.rE(str);
    }

    public void bhT() {
        this.fTX.as(this.fTY.fUw);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aGG())) {
            this.fTX.Os();
            this.fTX.bin();
            return;
        }
        this.fTX.Os();
        this.fTX.bib();
        this.fTX.a(i, bVar, z);
    }

    public boolean bhU() {
        return this.fTX.bhU();
    }

    public void bhP() {
        this.fTX.bhP();
    }

    public d bhV() {
        return this.fTY;
    }

    public g bhW() {
        return this.fTX;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.fTX.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.fTY.big();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fTX != null) {
            this.fTX.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv(int i) {
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
        al ac = new al("c12404").ac(ImageViewerConfig.FORUM_ID, this.mForumId).ac(ImageViewerConfig.FORUM_NAME, this.mForumName).ac("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ac.r(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ac);
    }
}
