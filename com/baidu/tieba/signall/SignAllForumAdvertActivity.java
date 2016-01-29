package com.baidu.tieba.signall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SignAllForumAdvertActivity extends BaseActivity<SignAllForumAdvertActivity> {
    private String bug;
    private ImageView cVW;
    private String dOf;
    private boolean dOg;
    private TbImageView dOh;
    private ImageView dsO;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.bug = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_PIC);
        this.dOf = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_URL);
        this.dOg = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        qD();
        aJg();
    }

    private void qD() {
        setContentView(t.h.signallforum_advert_view);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.signallforum));
        this.cVW = (ImageView) findViewById(t.g.signallforum_icon);
        this.dOh = (TbImageView) findViewById(t.g.signallforum_advert_pic);
        this.dsO = (ImageView) findViewById(t.g.signallforum_advert_close);
        this.dOh.setDefaultBgResource(t.f.transparent_bg);
        com.baidu.adp.lib.g.c.hl().a(this.bug, 10, new r(this), null);
        this.dOh.d(this.bug, 10, false);
        this.dOh.setOnClickListener(new s(this));
        this.dsO.setOnClickListener(new t(this));
    }

    private void aJg() {
        TiebaStatic.log("c10746");
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        clearAnimatable();
        clearAnimation();
        overridePendingTransition(0, 0);
    }
}
