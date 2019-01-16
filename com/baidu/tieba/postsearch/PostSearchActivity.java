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
    public String dJQ;
    private g gKS;
    private d gKT;
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
        this.gKS = new g(this);
        this.gKS.initView();
        this.gKS.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gKT = new d(this);
        initData();
    }

    public void startSearch(String str) {
        this.dJQ = str;
        this.gKS.tR(1);
        this.gKT.buF();
        this.gKS.showLoadingView();
    }

    public void uz(String str) {
        this.gKS.uz(str);
    }

    public void bup() {
        this.gKS.at(this.gKT.gLq);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aVj())) {
            this.gKS.hideLoadingView();
            this.gKS.buJ();
            return;
        }
        this.gKS.hideLoadingView();
        this.gKS.bux();
        this.gKS.a(i, bVar, z);
    }

    public boolean buq() {
        return this.gKS.buq();
    }

    public void bul() {
        this.gKS.bul();
    }

    public d bur() {
        return this.gKT;
    }

    public g bus() {
        return this.gKS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gKS.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gKT.buC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gKS != null) {
            this.gKS.onDestroy();
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
