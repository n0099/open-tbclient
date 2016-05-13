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
    private String bzs;
    private ImageView dQG;
    private ImageView dsV;
    private String ejP;
    private boolean ejQ;
    private TbImageView ejR;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.bzs = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_PIC);
        this.ejP = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_URL);
        this.ejQ = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        nq();
        aQq();
    }

    private void nq() {
        setContentView(t.h.signallforum_advert_view);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.signallforum));
        this.dsV = (ImageView) findViewById(t.g.signallforum_icon);
        this.ejR = (TbImageView) findViewById(t.g.signallforum_advert_pic);
        this.dQG = (ImageView) findViewById(t.g.signallforum_advert_close);
        this.ejR.setDefaultBgResource(t.f.transparent_bg);
        com.baidu.adp.lib.g.c.dF().a(this.bzs, 10, new r(this), null);
        this.ejR.c(this.bzs, 10, false);
        this.ejR.setOnClickListener(new s(this));
        this.dQG.setOnClickListener(new t(this));
    }

    private void aQq() {
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
