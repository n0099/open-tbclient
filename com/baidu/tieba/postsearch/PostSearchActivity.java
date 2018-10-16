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
    public String dyD;
    private g gyF;
    private d gyG;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.sH(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gyF = new g(this);
        this.gyF.initView();
        this.gyF.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gyG = new d(this);
        initData();
    }

    public void tA(String str) {
        this.dyD = str;
        this.gyF.sN(1);
        this.gyG.brW();
        this.gyF.showLoadingView();
    }

    public void tz(String str) {
        this.gyF.tz(str);
    }

    public void brG() {
        this.gyF.au(this.gyG.gzd);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aSH())) {
            this.gyF.hideLoadingView();
            this.gyF.bsa();
            return;
        }
        this.gyF.hideLoadingView();
        this.gyF.brO();
        this.gyF.a(i, bVar, z);
    }

    public boolean brH() {
        return this.gyF.brH();
    }

    public void brC() {
        this.gyF.brC();
    }

    public d brI() {
        return this.gyG;
    }

    public g brJ() {
        return this.gyF;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gyF.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gyG.brT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gyF != null) {
            this.gyF.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sH(int i) {
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
        am ax = new am("c12404").ax(ImageViewerConfig.FORUM_ID, this.mForumId).ax(ImageViewerConfig.FORUM_NAME, this.mForumName).ax("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ax.x(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ax);
    }
}
