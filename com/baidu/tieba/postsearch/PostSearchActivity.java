package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes8.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String ghc;
    private g jwm;
    private d jwn;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Al(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jwm = new g(this);
        this.jwm.initView();
        this.jwm.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jwn = new d(this);
        initData();
    }

    public void pL(String str) {
        this.ghc = str;
        this.jwm.Ar(1);
        this.jwn.cyi();
        this.jwm.showLoadingView();
    }

    public void GO(String str) {
        this.jwm.GO(str);
    }

    public void cxS() {
        this.jwm.aP(this.jwn.jwL);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bVb())) {
            this.jwm.hideLoadingView();
            this.jwm.cym();
            return;
        }
        this.jwm.hideLoadingView();
        this.jwm.cya();
        this.jwm.a(i, bVar, z);
    }

    public boolean cxT() {
        return this.jwm.cxT();
    }

    public void hideSoftKeyPad() {
        this.jwm.hideSoftKeyPad();
    }

    public d cxU() {
        return this.jwn;
    }

    public g cxV() {
        return this.jwm;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jwm.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.jwn.cyf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.jwm != null) {
            this.jwm.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Al(int i) {
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
        an cp = new an("c12404").cp("fid", this.mForumId).cp("fname", this.mForumName).cp("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            cp.Z("tab_id", i2);
        }
        TiebaStatic.log(cp);
    }
}
