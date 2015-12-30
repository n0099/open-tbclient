package com.baidu.tieba.signall;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SignAllForumAdvertActivity extends BaseActivity<SignAllForumAdvertActivity> {
    private String bra;
    private ImageView cMV;
    private ImageView dfG;
    private String dyb;
    private boolean dyc;
    private TbImageView dyd;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.bra = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_PIC);
        this.dyb = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_URL);
        this.dyc = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        initUI();
        aBZ();
    }

    private void initUI() {
        setContentView(n.h.signallforum_advert_view);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(n.j.signallforum));
        this.cMV = (ImageView) findViewById(n.g.signallforum_icon);
        this.dyd = (TbImageView) findViewById(n.g.signallforum_advert_pic);
        this.dfG = (ImageView) findViewById(n.g.signallforum_advert_close);
        this.dyd.setDefaultBgResource(n.f.transparent_bg);
        com.baidu.adp.lib.g.c.hd().a(this.bra, 10, new r(this), null);
        this.dyd.d(this.bra, 10, false);
        this.dyd.setOnClickListener(new s(this));
        this.dfG.setOnClickListener(new t(this));
    }

    private void aBZ() {
        TiebaStatic.log("c10504");
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
