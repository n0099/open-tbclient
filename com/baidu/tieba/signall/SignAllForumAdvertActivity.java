package com.baidu.tieba.signall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SignAllForumAdvertActivity extends BaseActivity<SignAllForumAdvertActivity> {
    private String gSF;
    private String gSG;
    private boolean gSH;
    private TbImageView gSI;
    private ImageView gSJ;
    private ImageView jt;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.gSF = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_PIC);
        this.gSG = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_URL);
        this.gSH = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        initUI();
        btC();
    }

    private void initUI() {
        setContentView(d.h.signallforum_advert_view);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(d.j.signallforum));
        this.jt = (ImageView) findViewById(d.g.signallforum_icon);
        this.gSI = (TbImageView) findViewById(d.g.signallforum_advert_pic);
        this.gSJ = (ImageView) findViewById(d.g.signallforum_advert_close);
        this.gSI.setDefaultBgResource(d.f.transparent_bg);
        com.baidu.adp.lib.f.c.nm().a(this.gSF, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.signall.SignAllForumAdvertActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    SignAllForumAdvertActivity.this.finish();
                }
            }
        }, null);
        this.gSI.startLoad(this.gSF, 10, false);
        this.gSI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumAdvertActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.signall.SignAllForumAdvertActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aw.Du().c(SignAllForumAdvertActivity.this.getPageContext(), new String[]{SignAllForumAdvertActivity.this.gSG});
            }
        });
        this.gSJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumAdvertActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SignAllForumAdvertActivity.this.finish();
            }
        });
    }

    private void btC() {
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
