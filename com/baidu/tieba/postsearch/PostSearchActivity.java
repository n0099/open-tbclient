package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String dkL;
    private g gjO;
    private d gjP;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.rN(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjO = new g(this);
        this.gjO.initView();
        this.gjO.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gjP = new d(this);
        initData();
    }

    public void sp(String str) {
        this.dkL = str;
        this.gjO.rT(1);
        this.gjP.bme();
        this.gjO.showLoadingView();
    }

    public void so(String str) {
        this.gjO.so(str);
    }

    public void blO() {
        this.gjO.au(this.gjP.gkm);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aNh())) {
            this.gjO.hideLoadingView();
            this.gjO.bmi();
            return;
        }
        this.gjO.hideLoadingView();
        this.gjO.blW();
        this.gjO.a(i, bVar, z);
    }

    public boolean blP() {
        return this.gjO.blP();
    }

    public void blK() {
        this.gjO.blK();
    }

    public d blQ() {
        return this.gjP;
    }

    public g blR() {
        return this.gjO;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gjO.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gjP.bmb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gjO != null) {
            this.gjO.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(int i) {
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
        an af = new an("c12404").af(ImageViewerConfig.FORUM_ID, this.mForumId).af(ImageViewerConfig.FORUM_NAME, this.mForumName).af("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            af.r(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(af);
    }
}
