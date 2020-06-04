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
    public String hlt;
    private g kFI;
    private d kFJ;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.BU(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kFI = new g(this);
        this.kFI.initView();
        this.kFI.setOnPageChangeListener(this.mOnPageChangeListener);
        this.kFJ = new d(this);
        initData();
    }

    public void sT(String str) {
        this.hlt = str;
        this.kFI.BZ(1);
        this.kFJ.cTi();
        this.kFI.showLoadingView();
    }

    public void KK(String str) {
        this.kFI.KK(str);
    }

    public void cSS() {
        this.kFI.aR(this.kFJ.kGh);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cpm())) {
            this.kFI.hideLoadingView();
            this.kFI.cTm();
            return;
        }
        this.kFI.hideLoadingView();
        this.kFI.cTa();
        this.kFI.a(i, bVar, z);
    }

    public boolean cST() {
        return this.kFI.cST();
    }

    public void hideSoftKeyPad() {
        this.kFI.hideSoftKeyPad();
    }

    public d cSU() {
        return this.kFJ;
    }

    public g cSV() {
        return this.kFI;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kFI.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.kFJ.cTf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kFI != null) {
            this.kFI.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU(int i) {
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
        an dh = new an("c12404").dh("fid", this.mForumId).dh("fname", this.mForumName).dh("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dh.ag("tab_id", i2);
        }
        TiebaStatic.log(dh);
    }
}
