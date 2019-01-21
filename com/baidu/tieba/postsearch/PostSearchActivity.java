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
    public String dJR;
    private g gKT;
    private d gKU;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.tL(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gKT = new g(this);
        this.gKT.initView();
        this.gKT.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gKU = new d(this);
        initData();
    }

    public void startSearch(String str) {
        this.dJR = str;
        this.gKT.tR(1);
        this.gKU.buF();
        this.gKT.showLoadingView();
    }

    public void uz(String str) {
        this.gKT.uz(str);
    }

    public void bup() {
        this.gKT.at(this.gKU.gLr);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aVj())) {
            this.gKT.hideLoadingView();
            this.gKT.buJ();
            return;
        }
        this.gKT.hideLoadingView();
        this.gKT.bux();
        this.gKT.a(i, bVar, z);
    }

    public boolean buq() {
        return this.gKT.buq();
    }

    public void bul() {
        this.gKT.bul();
    }

    public d bur() {
        return this.gKU;
    }

    public g bus() {
        return this.gKT;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gKT.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gKU.buC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gKT != null) {
            this.gKT.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tL(int i) {
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
        am aB = new am("c12404").aB(ImageViewerConfig.FORUM_ID, this.mForumId).aB(ImageViewerConfig.FORUM_NAME, this.mForumName).aB("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            aB.y(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(aB);
    }
}
