package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String dkJ;
    private g gjN;
    private d gjO;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.rN(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gjN = new g(this);
        this.gjN.initView();
        this.gjN.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gjO = new d(this);
        initData();
    }

    public void st(String str) {
        this.dkJ = str;
        this.gjN.rT(1);
        this.gjO.bmb();
        this.gjN.showLoadingView();
    }

    public void ss(String str) {
        this.gjN.ss(str);
    }

    public void blL() {
        this.gjN.au(this.gjO.gkl);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aNe())) {
            this.gjN.hideLoadingView();
            this.gjN.bmf();
            return;
        }
        this.gjN.hideLoadingView();
        this.gjN.blT();
        this.gjN.a(i, bVar, z);
    }

    public boolean blM() {
        return this.gjN.blM();
    }

    public void blH() {
        this.gjN.blH();
    }

    public d blN() {
        return this.gjO;
    }

    public g blO() {
        return this.gjN;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gjN.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gjO.blY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gjN != null) {
            this.gjN.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rN(int i) {
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
        an ae = new an("c12404").ae(ImageViewerConfig.FORUM_ID, this.mForumId).ae(ImageViewerConfig.FORUM_NAME, this.mForumName).ae("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ae.r(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ae);
    }
}
