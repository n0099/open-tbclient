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
    public String cVN;
    private g fSU;
    private d fSV;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.rx(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fSU = new g(this);
        this.fSU.initView();
        this.fSU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.fSV = new d(this);
        initData();
    }

    public void rC(String str) {
        this.cVN = str;
        this.fSU.rD(1);
        this.fSV.bij();
        this.fSU.showLoadingView();
    }

    public void rB(String str) {
        this.fSU.rB(str);
    }

    public void bhT() {
        this.fSU.as(this.fSV.fTt);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aGI())) {
            this.fSU.Ou();
            this.fSU.bin();
            return;
        }
        this.fSU.Ou();
        this.fSU.bib();
        this.fSU.a(i, bVar, z);
    }

    public boolean bhU() {
        return this.fSU.bhU();
    }

    public void bhP() {
        this.fSU.bhP();
    }

    public d bhV() {
        return this.fSV;
    }

    public g bhW() {
        return this.fSU;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.fSU.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.fSV.big();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fSU != null) {
            this.fSU.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rx(int i) {
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
