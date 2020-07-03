package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
/* loaded from: classes11.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String hxA;
    private g kZE;
    private d kZF;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.CW(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kZE = new g(this);
        this.kZE.initView();
        this.kZE.setOnPageChangeListener(this.mOnPageChangeListener);
        this.kZF = new d(this);
        initData();
    }

    public void tb(String str) {
        this.hxA = str;
        this.kZE.Db(1);
        this.kZF.cXy();
        this.kZE.showLoadingView();
    }

    public void Ll(String str) {
        this.kZE.Ll(str);
    }

    public void cXi() {
        this.kZE.aS(this.kZF.lad);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.ctb())) {
            this.kZE.hideLoadingView();
            this.kZE.cXC();
            return;
        }
        this.kZE.hideLoadingView();
        this.kZE.cXq();
        this.kZE.a(i, bVar, z);
    }

    public boolean cXj() {
        return this.kZE.cXj();
    }

    public void hideSoftKeyPad() {
        this.kZE.hideSoftKeyPad();
    }

    public d cXk() {
        return this.kZF;
    }

    public g cXl() {
        return this.kZE;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kZE.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.kZF.cXv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kZE != null) {
            this.kZE.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CW(int i) {
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
        ao dk = new ao("c12404").dk("fid", this.mForumId).dk("fname", this.mForumName).dk("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dk.ag("tab_id", i2);
        }
        TiebaStatic.log(dk);
    }
}
