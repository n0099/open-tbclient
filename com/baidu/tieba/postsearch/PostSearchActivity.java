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
    public String gWq;
    private g kmB;
    private d kmC;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Bi(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kmB = new g(this);
        this.kmB.initView();
        this.kmB.setOnPageChangeListener(this.mOnPageChangeListener);
        this.kmC = new d(this);
        initData();
    }

    public void rp(String str) {
        this.gWq = str;
        this.kmB.Bn(1);
        this.kmC.cLU();
        this.kmB.showLoadingView();
    }

    public void IU(String str) {
        this.kmB.IU(str);
    }

    public void cLE() {
        this.kmB.aQ(this.kmC.kna);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.ciH())) {
            this.kmB.hideLoadingView();
            this.kmB.cLY();
            return;
        }
        this.kmB.hideLoadingView();
        this.kmB.cLM();
        this.kmB.a(i, bVar, z);
    }

    public boolean cLF() {
        return this.kmB.cLF();
    }

    public void hideSoftKeyPad() {
        this.kmB.hideSoftKeyPad();
    }

    public d cLG() {
        return this.kmC;
    }

    public g cLH() {
        return this.kmB;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.kmB.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.kmC.cLR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.kmB != null) {
            this.kmB.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bi(int i) {
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
        an cI = new an("c12404").cI("fid", this.mForumId).cI("fname", this.mForumName).cI("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            cI.af("tab_id", i2);
        }
        TiebaStatic.log(cI);
    }
}
