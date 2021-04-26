package com.baidu.tieba.postsearch;

import android.content.Intent;
import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.j0.n2.b;
import d.a.j0.n2.d;
import d.a.j0.n2.g;
/* loaded from: classes4.dex */
public class PostSearchActivity extends BaseFragmentActivity {
    public static final String FORUM_SEARCH_CLICK = "c12842";
    public static final int TAB_ID_ONLY_THREAD = 3;
    public static final int TAB_ID_RELATIVE = 2;
    public static final int TAB_ID_TIME = 1;
    public String mForumId;
    public String mForumName;
    public d mModel;
    public ViewPager.OnPageChangeListener mOnPageChangeListener = new a();
    public String mSearchKey;
    public g mView;

    /* loaded from: classes4.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            PostSearchActivity.this.stateTabClick(i2);
        }
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mForumName = intent.getStringExtra("forum_name");
            this.mForumId = intent.getStringExtra("forum_id");
        }
        this.mModel.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stateTabClick(int i2) {
        int i3 = 2;
        if (i2 == 0) {
            i3 = 1;
        } else if (i2 != 1) {
            i3 = i2 != 2 ? 0 : 3;
        }
        StatisticItem param = new StatisticItem("c12404").param("fid", this.mForumId).param("fname", this.mForumName).param("uid", TbadkCoreApplication.getCurrentAccount());
        if (i3 != 0) {
            param.param("tab_id", i3);
        }
        TiebaStatic.log(param);
    }

    public d getModel() {
        return this.mModel;
    }

    public g getPostSearchView() {
        return this.mView;
    }

    public void hideSoftKeyPad() {
        this.mView.d();
    }

    public boolean isHistoryVisible() {
        return this.mView.f();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        this.mView.g(i2);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g gVar = new g(this);
        this.mView = gVar;
        gVar.e();
        this.mView.l(this.mOnPageChangeListener);
        this.mModel = new d(this);
        initData();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        g gVar = this.mView;
        if (gVar != null) {
            gVar.h();
        }
        super.onDestroy();
    }

    public void refreshHistoryList() {
        this.mView.i(this.mModel.j);
    }

    public void refreshResultListByTab(int i2, b bVar, boolean z) {
        if (i2 == 1 && (bVar == null || !bVar.a())) {
            this.mView.c();
            this.mView.n();
            return;
        }
        this.mView.c();
        this.mView.b();
        this.mView.j(i2, bVar, z);
    }

    public void setEditSearchText(String str) {
        this.mView.k(str);
    }

    public void startSearch(String str) {
        this.mSearchKey = str;
        this.mView.o(1);
        this.mModel.q();
        this.mView.m();
    }
}
