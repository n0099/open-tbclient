package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes23.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String hXJ;
    private g lGs;
    private d lGt;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Go(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lGs = new g(this);
        this.lGs.initView();
        this.lGs.setOnPageChangeListener(this.mOnPageChangeListener);
        this.lGt = new d(this);
        initData();
    }

    public void wO(String str) {
        this.hXJ = str;
        this.lGs.Gt(1);
        this.lGt.dpu();
        this.lGs.showLoadingView();
    }

    public void Po(String str) {
        this.lGs.Po(str);
    }

    public void dpe() {
        this.lGs.bb(this.lGt.lGQ);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cLC())) {
            this.lGs.hideLoadingView();
            this.lGs.dpy();
            return;
        }
        this.lGs.hideLoadingView();
        this.lGs.dpm();
        this.lGs.a(i, bVar, z);
    }

    public boolean dpf() {
        return this.lGs.dpf();
    }

    public void hideSoftKeyPad() {
        this.lGs.hideSoftKeyPad();
    }

    public d dpg() {
        return this.lGt;
    }

    public g dph() {
        return this.lGs;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lGs.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.lGt.dpr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lGs != null) {
            this.lGs.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(int i) {
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
        aq dF = new aq("c12404").dF("fid", this.mForumId).dF("fname", this.mForumName).dF("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dF.ai("tab_id", i2);
        }
        TiebaStatic.log(dF);
    }
}
