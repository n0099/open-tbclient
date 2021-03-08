package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes7.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String jfU;
    public String mForumId;
    public String mForumName;
    private g mOL;
    private d mOM;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.Hx(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mOL = new g(this);
        this.mOL.initView();
        this.mOL.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mOM = new d(this);
        initData();
    }

    public void xX(String str) {
        this.jfU = str;
        this.mOL.HC(1);
        this.mOM.dCd();
        this.mOL.showLoadingView();
    }

    public void QS(String str) {
        this.mOL.QS(str);
    }

    public void dBN() {
        this.mOL.bb(this.mOM.mPj);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cXS())) {
            this.mOL.hideLoadingView();
            this.mOL.dCh();
            return;
        }
        this.mOL.hideLoadingView();
        this.mOL.dBV();
        this.mOL.a(i, bVar, z);
    }

    public boolean dBO() {
        return this.mOL.dBO();
    }

    public void hideSoftKeyPad() {
        this.mOL.hideSoftKeyPad();
    }

    public d dBP() {
        return this.mOM;
    }

    public g dBQ() {
        return this.mOL;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mOL.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mOM.dCa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mOL != null) {
            this.mOL.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hx(int i) {
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
            dR.aq("tab_id", i2);
        }
        TiebaStatic.log(dR);
    }
}
