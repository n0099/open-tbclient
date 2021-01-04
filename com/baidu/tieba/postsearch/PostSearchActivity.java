package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes8.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String jcX;
    public String mForumId;
    public String mForumName;
    private g mHV;
    private d mHW;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.IJ(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHV = new g(this);
        this.mHV.initView();
        this.mHV.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mHW = new d(this);
        initData();
    }

    public void yI(String str) {
        this.jcX = str;
        this.mHV.IO(1);
        this.mHW.dDv();
        this.mHV.showLoadingView();
    }

    public void Rc(String str) {
        this.mHV.Rc(str);
    }

    public void dDf() {
        this.mHV.bh(this.mHW.mIw);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cZx())) {
            this.mHV.hideLoadingView();
            this.mHV.dDz();
            return;
        }
        this.mHV.hideLoadingView();
        this.mHV.dDn();
        this.mHV.a(i, bVar, z);
    }

    public boolean dDg() {
        return this.mHV.dDg();
    }

    public void hideSoftKeyPad() {
        this.mHV.hideSoftKeyPad();
    }

    public d dDh() {
        return this.mHW;
    }

    public g dDi() {
        return this.mHV;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mHV.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mHW.dDs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHV != null) {
            this.mHV.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IJ(int i) {
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
        aq dX = new aq("c12404").dX("fid", this.mForumId).dX("fname", this.mForumName).dX("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            dX.an("tab_id", i2);
        }
        TiebaStatic.log(dX);
    }
}
