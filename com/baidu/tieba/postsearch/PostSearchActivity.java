package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes24.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String imJ;
    private g lVG;
    private d lVH;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.GU(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lVG = new g(this);
        this.lVG.initView();
        this.lVG.setOnPageChangeListener(this.mOnPageChangeListener);
        this.lVH = new d(this);
        initData();
    }

    public void xA(String str) {
        this.imJ = str;
        this.lVG.GZ(1);
        this.lVH.dtf();
        this.lVG.showLoadingView();
    }

    public void Qd(String str) {
        this.lVG.Qd(str);
    }

    public void dsP() {
        this.lVG.bb(this.lVH.lWe);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cPk())) {
            this.lVG.hideLoadingView();
            this.lVG.dtj();
            return;
        }
        this.lVG.hideLoadingView();
        this.lVG.dsX();
        this.lVG.a(i, bVar, z);
    }

    public boolean dsQ() {
        return this.lVG.dsQ();
    }

    public void hideSoftKeyPad() {
        this.lVG.hideSoftKeyPad();
    }

    public d dsR() {
        return this.lVH;
    }

    public g dsS() {
        return this.lVG;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lVG.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.lVH.dtc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lVG != null) {
            this.lVG.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(int i) {
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
        aq dK = new aq("c12404").dK("fid", this.mForumId).dK("fname", this.mForumName).dK("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dK.aj("tab_id", i2);
        }
        TiebaStatic.log(dK);
    }
}
