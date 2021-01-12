package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes7.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String iYq;
    private g mDn;
    private d mDo;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Hc(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mDn = new g(this);
        this.mDn.initView();
        this.mDn.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mDo = new d(this);
        initData();
    }

    public void xx(String str) {
        this.iYq = str;
        this.mDn.Hh(1);
        this.mDo.dzE();
        this.mDn.showLoadingView();
    }

    public void PT(String str) {
        this.mDn.PT(str);
    }

    public void dzo() {
        this.mDn.bc(this.mDo.mDN);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cVG())) {
            this.mDn.hideLoadingView();
            this.mDn.dzI();
            return;
        }
        this.mDn.hideLoadingView();
        this.mDn.dzw();
        this.mDn.a(i, bVar, z);
    }

    public boolean dzp() {
        return this.mDn.dzp();
    }

    public void hideSoftKeyPad() {
        this.mDn.hideSoftKeyPad();
    }

    public d dzq() {
        return this.mDo;
    }

    public g dzr() {
        return this.mDn;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mDn.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mDo.dzB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mDn != null) {
            this.mDn.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(int i) {
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
        aq dW = new aq("c12404").dW("fid", this.mForumId).dW("fname", this.mForumName).dW("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dW.an("tab_id", i2);
        }
        TiebaStatic.log(dW);
    }
}
