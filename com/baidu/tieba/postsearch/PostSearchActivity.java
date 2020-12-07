package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes24.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String iQJ;
    private g mCC;
    private d mCD;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.IP(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCC = new g(this);
        this.mCC.initView();
        this.mCC.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mCD = new d(this);
        initData();
    }

    public void yJ(String str) {
        this.iQJ = str;
        this.mCC.IU(1);
        this.mCD.dDF();
        this.mCC.showLoadingView();
    }

    public void Rw(String str) {
        this.mCC.Rw(str);
    }

    public void dDp() {
        this.mCC.bh(this.mCD.mDa);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cZK())) {
            this.mCC.hideLoadingView();
            this.mCC.dDJ();
            return;
        }
        this.mCC.hideLoadingView();
        this.mCC.dDx();
        this.mCC.a(i, bVar, z);
    }

    public boolean dDq() {
        return this.mCC.dDq();
    }

    public void hideSoftKeyPad() {
        this.mCC.hideSoftKeyPad();
    }

    public d dDr() {
        return this.mCD;
    }

    public g dDs() {
        return this.mCC;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mCC.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mCD.dDC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mCC != null) {
            this.mCC.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IP(int i) {
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
        ar dY = new ar("c12404").dY("fid", this.mForumId).dY("fname", this.mForumName).dY("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dY.al("tab_id", i2);
        }
        TiebaStatic.log(dY);
    }
}
