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
    public String dqC;
    private g grf;
    private d grg;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.sk(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.grf = new g(this);
        this.grf.initView();
        this.grf.setOnPageChangeListener(this.mOnPageChangeListener);
        this.grg = new d(this);
        initData();
    }

    public void ta(String str) {
        this.dqC = str;
        this.grf.sq(1);
        this.grg.boH();
        this.grf.showLoadingView();
    }

    public void sZ(String str) {
        this.grf.sZ(str);
    }

    public void bor() {
        this.grf.au(this.grg.grD);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aPt())) {
            this.grf.hideLoadingView();
            this.grf.boL();
            return;
        }
        this.grf.hideLoadingView();
        this.grf.boz();
        this.grf.a(i, bVar, z);
    }

    public boolean bos() {
        return this.grf.bos();
    }

    public void bon() {
        this.grf.bon();
    }

    public d bot() {
        return this.grg;
    }

    public g bou() {
        return this.grf;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.grf.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.grg.boE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.grf != null) {
            this.grf.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sk(int i) {
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
        am al = new am("c12404").al(ImageViewerConfig.FORUM_ID, this.mForumId).al(ImageViewerConfig.FORUM_NAME, this.mForumName).al("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            al.w(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(al);
    }
}
