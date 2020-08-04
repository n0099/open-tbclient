package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* loaded from: classes18.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String hDo;
    private g lgX;
    private d lgY;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Ds(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.lgX = new g(this);
        this.lgX.initView();
        this.lgX.setOnPageChangeListener(this.mOnPageChangeListener);
        this.lgY = new d(this);
        initData();
    }

    public void ue(String str) {
        this.hDo = str;
        this.lgX.Dx(1);
        this.lgY.daG();
        this.lgX.showLoadingView();
    }

    public void LT(String str) {
        this.lgX.LT(str);
    }

    public void daq() {
        this.lgX.aT(this.lgY.lhv);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cxe())) {
            this.lgX.hideLoadingView();
            this.lgX.daK();
            return;
        }
        this.lgX.hideLoadingView();
        this.lgX.day();
        this.lgX.a(i, bVar, z);
    }

    public boolean dar() {
        return this.lgX.dar();
    }

    public void hideSoftKeyPad() {
        this.lgX.hideSoftKeyPad();
    }

    public d das() {
        return this.lgY;
    }

    public g dat() {
        return this.lgX;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.lgX.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.lgY.daD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.lgX != null) {
            this.lgX.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(int i) {
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
        ap dn = new ap("c12404").dn("fid", this.mForumId).dn("fname", this.mForumName).dn("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dn.ah("tab_id", i2);
        }
        TiebaStatic.log(dn);
    }
}
