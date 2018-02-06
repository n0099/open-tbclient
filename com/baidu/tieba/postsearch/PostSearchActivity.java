package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
/* loaded from: classes3.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public String dDb;
    private h gyc;
    private e gyd;
    public String mForumId;
    public String mForumName;
    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.postsearch.PostSearchActivity.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PostSearchActivity.this.tY(i);
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gyc = new h(this);
        this.gyc.initView();
        this.gyc.setOnPageChangeListener(this.mOnPageChangeListener);
        this.gyd = new e(this);
        initData();
    }

    public void rw(String str) {
        this.dDb = str;
        this.gyc.ue(1);
        this.gyd.bnd();
        this.gyc.VU();
    }

    public void rv(String str) {
        this.gyc.rv(str);
    }

    public void bmN() {
        this.gyc.ar(this.gyd.gyB);
    }

    public void a(int i, b bVar, boolean z) {
        if (i == 1 && (bVar == null || !bVar.aLK())) {
            this.gyc.VV();
            this.gyc.bnh();
            return;
        }
        this.gyc.VV();
        this.gyc.bmV();
        this.gyc.a(i, bVar, z);
    }

    public boolean bmO() {
        return this.gyc.bmO();
    }

    public void bmJ() {
        this.gyc.bmJ();
    }

    public e bmP() {
        return this.gyd;
    }

    public h bmQ() {
        return this.gyc;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        this.gyc.onChangeSkinType(i);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.gyd.bna();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gyc != null) {
            this.gyc.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tY(int i) {
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
        ak ab = new ak("c12404").ab(ImageViewerConfig.FORUM_ID, this.mForumId).ab(ImageViewerConfig.FORUM_NAME, this.mForumName).ab("uid", TbadkCoreApplication.getCurrentAccount());
        if (i2 != 0) {
            ab.s(MyBookrackActivityConfig.TAB_ID, i2);
        }
        TiebaStatic.log(ab);
    }
}
