package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes23.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String iFR;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.HY(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private g moy;
    private d moz;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.moy = new g(this);
        this.moy.initView();
        this.moy.setOnPageChangeListener(this.mOnPageChangeListener);
        this.moz = new d(this);
        initData();
    }

    public void yc(String str) {
        this.iFR = str;
        this.moy.Id(1);
        this.moz.dyo();
        this.moy.showLoadingView();
    }

    public void Qn(String str) {
        this.moy.Qn(str);
    }

    public void dxY() {
        this.moy.bf(this.moz.moW);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cUy())) {
            this.moy.hideLoadingView();
            this.moy.dys();
            return;
        }
        this.moy.hideLoadingView();
        this.moy.dyg();
        this.moy.a(i, bVar, z);
    }

    public boolean dxZ() {
        return this.moy.dxZ();
    }

    public void hideSoftKeyPad() {
        this.moy.hideSoftKeyPad();
    }

    public d dya() {
        return this.moz;
    }

    public g dyb() {
        return this.moy;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.moy.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.moz.dyl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.moy != null) {
            this.moy.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY(int i) {
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
        ar dR = new ar("c12404").dR("fid", this.mForumId).dR("fname", this.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dR.ak("tab_id", i2);
        }
        TiebaStatic.log(dR);
    }
}
