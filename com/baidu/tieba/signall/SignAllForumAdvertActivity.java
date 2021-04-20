package com.baidu.tieba.signall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.l.d;
/* loaded from: classes4.dex */
public class SignAllForumAdvertActivity extends BaseActivity<SignAllForumAdvertActivity> {
    public String mAdPic;
    public String mAdUrl;
    public TbImageView mAdvertPic;
    public ImageView mCloseBtn;
    public boolean mHasPrivilege;
    public ImageView mIcon;
    public NavigationBar mNavigationBar;

    /* loaded from: classes4.dex */
    public class a extends d.b.c.e.l.c<d.b.c.j.d.a> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.l.c
        public void onLoaded(d.b.c.j.d.a aVar, String str, int i) {
            super.onLoaded((a) aVar, str, i);
            if (aVar == null) {
                SignAllForumAdvertActivity.this.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UrlManager.getInstance().dealOneLink(SignAllForumAdvertActivity.this.getPageContext(), new String[]{SignAllForumAdvertActivity.this.mAdUrl});
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SignAllForumAdvertActivity.this.finish();
        }
    }

    private void addStats() {
        TiebaStatic.log("c10746");
    }

    private void initUI() {
        setContentView(R.layout.signallforum_advert_view);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        navigationBar.setTitleText(getPageContext().getString(R.string.signallforum));
        this.mIcon = (ImageView) findViewById(R.id.signallforum_icon);
        this.mAdvertPic = (TbImageView) findViewById(R.id.signallforum_advert_pic);
        this.mCloseBtn = (ImageView) findViewById(R.id.signallforum_advert_close);
        this.mAdvertPic.setDefaultBgResource(R.drawable.transparent_bg);
        d.h().m(this.mAdPic, 10, new a(), null);
        this.mAdvertPic.W(this.mAdPic, 10, false);
        this.mAdvertPic.setOnClickListener(new b());
        this.mCloseBtn.setOnClickListener(new c());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.mAdPic = intent.getStringExtra("ad_pic");
        this.mAdUrl = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_URL);
        this.mHasPrivilege = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        initUI();
        addStats();
    }
}
