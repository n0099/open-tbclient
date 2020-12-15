package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes24.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String iQL;
    private g mCE;
    private d mCF;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.IP(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCE = new g(this);
        this.mCE.initView();
        this.mCE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mCF = new d(this);
        initData();
    }

    public void yJ(String str) {
        this.iQL = str;
        this.mCE.IU(1);
        this.mCF.dDG();
        this.mCE.showLoadingView();
    }

    public void Rw(String str) {
        this.mCE.Rw(str);
    }

    public void dDq() {
        this.mCE.bh(this.mCF.mDd);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cZL())) {
            this.mCE.hideLoadingView();
            this.mCE.dDK();
            return;
        }
        this.mCE.hideLoadingView();
        this.mCE.dDy();
        this.mCE.a(i, bVar, z);
    }

    public boolean dDr() {
        return this.mCE.dDr();
    }

    public void hideSoftKeyPad() {
        this.mCE.hideSoftKeyPad();
    }

    public d dDs() {
        return this.mCF;
    }

    public g dDt() {
        return this.mCE;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mCE.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mCF.dDD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mCE != null) {
            this.mCE.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP(int i) {
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
        ar dY = new ar("c12404").dY("fid", this.mForumId).dY("fname", this.mForumName).dY("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dY.al("tab_id", i2);
        }
        TiebaStatic.log(dY);
    }
}
