package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes8.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String jdX;
    public String mForumId;
    public String mForumName;
    private g mMu;
    private d mMv;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Hu(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mMu = new g(this);
        this.mMu.initView();
        this.mMu.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mMv = new d(this);
        initData();
    }

    public void xQ(String str) {
        this.jdX = str;
        this.mMu.Hz(1);
        this.mMv.dBO();
        this.mMu.showLoadingView();
    }

    public void QL(String str) {
        this.mMu.QL(str);
    }

    public void dBy() {
        this.mMu.bb(this.mMv.mMS);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cXE())) {
            this.mMu.hideLoadingView();
            this.mMu.dBS();
            return;
        }
        this.mMu.hideLoadingView();
        this.mMu.dBG();
        this.mMu.a(i, bVar, z);
    }

    public boolean dBz() {
        return this.mMu.dBz();
    }

    public void hideSoftKeyPad() {
        this.mMu.hideSoftKeyPad();
    }

    public d dBA() {
        return this.mMv;
    }

    public g dBB() {
        return this.mMu;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mMu.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mMv.dBL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mMu != null) {
            this.mMu.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hu(int i) {
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
            dR.ap("tab_id", i2);
        }
        TiebaStatic.log(dR);
    }
}
