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
    public String jel;
    public String mForumId;
    public String mForumName;
    private g mMJ;
    private d mMK;
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
        this.mMJ = new g(this);
        this.mMJ.initView();
        this.mMJ.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mMK = new d(this);
        initData();
    }

    public void xQ(String str) {
        this.jel = str;
        this.mMJ.Hz(1);
        this.mMK.dBV();
        this.mMJ.showLoadingView();
    }

    public void QM(String str) {
        this.mMJ.QM(str);
    }

    public void dBF() {
        this.mMJ.bb(this.mMK.mNh);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cXL())) {
            this.mMJ.hideLoadingView();
            this.mMJ.dBZ();
            return;
        }
        this.mMJ.hideLoadingView();
        this.mMJ.dBN();
        this.mMJ.a(i, bVar, z);
    }

    public boolean dBG() {
        return this.mMJ.dBG();
    }

    public void hideSoftKeyPad() {
        this.mMJ.hideSoftKeyPad();
    }

    public d dBH() {
        return this.mMK;
    }

    public g dBI() {
        return this.mMJ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mMJ.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mMK.dBS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mMJ != null) {
            this.mMJ.onDestroy();
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
