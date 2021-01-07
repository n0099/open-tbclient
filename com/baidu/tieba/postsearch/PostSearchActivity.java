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
    private g mHU;
    private d mHV;
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
        this.mHU = new g(this);
        this.mHU.initView();
        this.mHU.setOnPageChangeListener(this.mOnPageChangeListener);
        this.mHV = new d(this);
        initData();
    }

    public void yI(String str) {
        this.jcX = str;
        this.mHU.IO(1);
        this.mHV.dDw();
        this.mHU.showLoadingView();
    }

    public void Rb(String str) {
        this.mHU.Rb(str);
    }

    public void dDg() {
        this.mHU.bh(this.mHV.mIv);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.cZy())) {
            this.mHU.hideLoadingView();
            this.mHU.dDA();
            return;
        }
        this.mHU.hideLoadingView();
        this.mHU.dDo();
        this.mHU.a(i, bVar, z);
    }

    public boolean dDh() {
        return this.mHU.dDh();
    }

    public void hideSoftKeyPad() {
        this.mHU.hideSoftKeyPad();
    }

    public d dDi() {
        return this.mHV;
    }

    public g dDj() {
        return this.mHU;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.mHU.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mHV.dDt();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.mHU != null) {
            this.mHU.onDestroy();
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
