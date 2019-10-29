package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes6.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String ftx;
    private g iCU;
    private d iCV;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.xQ(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iCU = new g(this);
        this.iCU.initView();
        this.iCU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iCV = new d(this);
        initData();
    }

    public void kQ(String str) {
        this.ftx = str;
        this.iCU.xW(1);
        this.iCV.cer();
        this.iCU.showLoadingView();
    }

    public void Cc(String str) {
        this.iCU.Cc(str);
    }

    public void ceb() {
        this.iCU.aF(this.iCV.iDt);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bDR())) {
            this.iCU.hideLoadingView();
            this.iCU.cev();
            return;
        }
        this.iCU.hideLoadingView();
        this.iCU.cej();
        this.iCU.a(i, bVar, z);
    }

    public boolean cec() {
        return this.iCU.cec();
    }

    public void hideSoftKeyPad() {
        this.iCU.hideSoftKeyPad();
    }

    public d ced() {
        return this.iCV;
    }

    public g cee() {
        return this.iCU;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iCU.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.iCV.ceo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.iCU != null) {
            this.iCU.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ(int i) {
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
        an bS = new an("c12404").bS("fid", this.mForumId).bS("fname", this.mForumName).bS("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            bS.O("tab_id", i2);
        }
        TiebaStatic.log(bS);
    }
}
