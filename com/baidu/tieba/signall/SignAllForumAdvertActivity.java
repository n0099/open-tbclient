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
    private String bzo;
    private ImageView dNw;
    private ImageView dqR;
    private String egE;
    private boolean egF;
    private TbImageView egG;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.bzo = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_PIC);
        this.egE = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_URL);
        this.egF = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        pU();
        aPW();
    }

    private void pU() {
        setContentView(t.h.signallforum_advert_view);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(t.j.signallforum));
        this.dqR = (ImageView) findViewById(t.g.signallforum_icon);
        this.egG = (TbImageView) findViewById(t.g.signallforum_advert_pic);
        this.dNw = (ImageView) findViewById(t.g.signallforum_advert_close);
        this.egG.setDefaultBgResource(t.f.transparent_bg);
        com.baidu.adp.lib.g.c.hr().a(this.bzo, 10, new r(this), null);
        this.egG.c(this.bzo, 10, false);
        this.egG.setOnClickListener(new s(this));
        this.dNw.setOnClickListener(new t(this));
    }

    private void aPW() {
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
