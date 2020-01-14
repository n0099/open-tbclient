package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes9.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String gkm;
    private g jzT;
    private d jzU;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Aq(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jzT = new g(this);
        this.jzT.initView();
        this.jzT.setOnPageChangeListener(this.mOnPageChangeListener);
        this.jzU = new d(this);
        initData();
    }

    public void pO(String str) {
        this.gkm = str;
        this.jzT.Aw(1);
        this.jzU.czr();
        this.jzT.showLoadingView();
    }

    public void GY(String str) {
        this.jzT.GY(str);
    }

    public void czb() {
        this.jzT.aP(this.jzU.jAs);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bWk())) {
            this.jzT.hideLoadingView();
            this.jzT.czv();
            return;
        }
        this.jzT.hideLoadingView();
        this.jzT.czj();
        this.jzT.a(i, bVar, z);
    }

    public boolean czc() {
        return this.jzT.czc();
    }

    public void hideSoftKeyPad() {
        this.jzT.hideSoftKeyPad();
    }

    public d czd() {
        return this.jzU;
    }

    public g cze() {
        return this.jzT;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.jzT.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.jzU.czo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.jzT != null) {
            this.jzT.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq(int i) {
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
