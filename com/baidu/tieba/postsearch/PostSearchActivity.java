package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String dJh;
    private g gJO;
    private d gJP;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.tH(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gJO = new g(this);
        this.gJO.initView();
        this.gJO.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gJP = new d(this);
        initData();
    }

    public void startSearch(String str) {
        this.dJh = str;
        this.gJO.tN(1);
        this.gJP.btW();
        this.gJO.showLoadingView();
    }

    public void uj(String str) {
        this.gJO.uj(str);
    }

    public void btG() {
        this.gJO.at(this.gJP.gKm);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aUJ())) {
            this.gJO.hideLoadingView();
            this.gJO.bua();
            return;
        }
        this.gJO.hideLoadingView();
        this.gJO.btO();
        this.gJO.a(i, bVar, z);
    }

    public boolean btH() {
        return this.gJO.btH();
    }

    public void btC() {
        this.gJO.btC();
    }

    public d btI() {
        return this.gJP;
    }

    public g btJ() {
        return this.gJO;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gJO.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gJP.btT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gJO != null) {
            this.gJO.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tH(int i) {
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
        am aA = new am("c12404").aA(ImageViewerConfig.FORUM_ID, this.mForumId).aA(ImageViewerConfig.FORUM_NAME, this.mForumName).aA("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            aA.x(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(aA);
    }
}
