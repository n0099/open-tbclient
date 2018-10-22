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
    private g gyG;
    private d gyH;
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
        this.gyG = new g(this);
        this.gyG.initView();
        this.gyG.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gyH = new d(this);
        initData();
    }

    public void tA(String str) {
        this.dyD = str;
        this.gyG.sN(1);
        this.gyH.brW();
        this.gyG.showLoadingView();
    }

    public void tz(String str) {
        this.gyG.tz(str);
    }

    public void brG() {
        this.gyG.au(this.gyH.gze);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aSH())) {
            this.gyG.hideLoadingView();
            this.gyG.bsa();
            return;
        }
        this.gyG.hideLoadingView();
        this.gyG.brO();
        this.gyG.a(i, bVar, z);
    }

    public boolean brH() {
        return this.gyG.brH();
    }

    public void brC() {
        this.gyG.brC();
    }

    public d brI() {
        return this.gyH;
    }

    public g brJ() {
        return this.gyG;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gyG.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gyH.brT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gyG != null) {
            this.gyG.onDestroy();
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
