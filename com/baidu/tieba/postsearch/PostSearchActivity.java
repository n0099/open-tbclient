package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes11.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String gWw;
    private g kmF;
    private d kmG;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Bi(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kmF = new g(this);
        this.kmF.initView();
        this.kmF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.kmG = new d(this);
        initData();
    }

    public void rp(String str) {
        this.gWw = str;
        this.kmF.Bn(1);
        this.kmG.cLS();
        this.kmF.showLoadingView();
    }

    public void IX(String str) {
        this.kmF.IX(str);
    }

    public void cLC() {
        this.kmF.aQ(this.kmG.kne);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.ciG())) {
            this.kmF.hideLoadingView();
            this.kmF.cLW();
            return;
        }
        this.kmF.hideLoadingView();
        this.kmF.cLK();
        this.kmF.a(i, bVar, z);
    }

    public boolean cLD() {
        return this.kmF.cLD();
    }

    public void hideSoftKeyPad() {
        this.kmF.hideSoftKeyPad();
    }

    public d cLE() {
        return this.kmG;
    }

    public g cLF() {
        return this.kmF;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kmF.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.kmG.cLP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kmF != null) {
            this.kmF.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(int i) {
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
        an cI = new an("c12404").cI("fid", this.mForumId).cI("fname", this.mForumName).cI("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            cI.af("tab_id", i2);
        }
        TiebaStatic.log(cI);
    }
}
