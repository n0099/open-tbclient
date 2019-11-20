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
    public String fsG;
    private g iCd;
    private d iCe;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.xP(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iCd = new g(this);
        this.iCd.initView();
        this.iCd.setOnPageChangeListener(this.mOnPageChangeListener);
        this.iCe = new d(this);
        initData();
    }

    public void kQ(String str) {
        this.fsG = str;
        this.iCd.xV(1);
        this.iCe.cep();
        this.iCd.showLoadingView();
    }

    public void Cc(String str) {
        this.iCd.Cc(str);
    }

    public void cdZ() {
        this.iCd.aF(this.iCe.iCC);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.bDP())) {
            this.iCd.hideLoadingView();
            this.iCd.cet();
            return;
        }
        this.iCd.hideLoadingView();
        this.iCd.ceh();
        this.iCd.a(i, bVar, z);
    }

    public boolean cea() {
        return this.iCd.cea();
    }

    public void hideSoftKeyPad() {
        this.iCd.hideSoftKeyPad();
    }

    public d ceb() {
        return this.iCe;
    }

    public g cec() {
        return this.iCd;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.iCd.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.iCe.cem();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.iCd != null) {
            this.iCd.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xP(int i) {
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
