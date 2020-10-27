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
    public String izg;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Hn(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };
    private g mig;
    private d mih;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mig = new g(this);
        this.mig.initView();
        this.mig.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mih = new d(this);
        initData();
    }

    public void xT(String str) {
        this.izg = str;
        this.mig.Hs(1);
        this.mih.dwm();
        this.mig.showLoadingView();
    }

    public void QB(String str) {
        this.mig.QB(str);
    }

    public void dvW() {
        this.mig.be(this.mih.miF);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cSr())) {
            this.mig.hideLoadingView();
            this.mig.dwq();
            return;
        }
        this.mig.hideLoadingView();
        this.mig.dwe();
        this.mig.a(i, bVar, z);
    }

    public boolean dvX() {
        return this.mig.dvX();
    }

    public void hideSoftKeyPad() {
        this.mig.hideSoftKeyPad();
    }

    public d dvY() {
        return this.mih;
    }

    public g dvZ() {
        return this.mig;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mig.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mih.dwj();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mig != null) {
            this.mig.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn(int i) {
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
        aq dR = new aq("c12404").dR("fid", this.mForumId).dR("fname", this.mForumName).dR("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dR.aj("tab_id", i2);
        }
        TiebaStatic.log(dR);
    }
}
