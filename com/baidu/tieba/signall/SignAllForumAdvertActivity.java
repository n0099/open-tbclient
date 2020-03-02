package com.baidu.tieba.signall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.SignAllForumAdvertActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class SignAllForumAdvertActivity extends BaseActivity<SignAllForumAdvertActivity> {
    private String jZc;
    private String jZd;
    private boolean jZe;
    private TbImageView jZf;
    private ImageView mCloseBtn;
    private ImageView mIcon;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.setActivityBgTransparent();
        super.setSwipeBackEnabled(false);
        Intent intent = getIntent();
        this.jZc = intent.getStringExtra(SignAllForumAdvertActivityConfig.AD_PIC);
        this.jZd = intent.getStringExtra("ad_url");
        this.jZe = intent.getBooleanExtra(SignAllForumAdvertActivityConfig.HAS_PRIVILEGE, false);
        initUI();
        cIX();
    }

    private void initUI() {
        setContentView(R.layout.signallforum_advert_view);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(getPageContext().getString(R.string.signallforum));
        this.mIcon = (ImageView) findViewById(R.id.signallforum_icon);
        this.jZf = (TbImageView) findViewById(R.id.signallforum_advert_pic);
        this.mCloseBtn = (ImageView) findViewById(R.id.signallforum_advert_close);
        this.jZf.setDefaultBgResource(R.drawable.transparent_bg);
        com.baidu.adp.lib.e.c.gr().a(this.jZc, 10, new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.signall.SignAllForumAdvertActivity.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    SignAllForumAdvertActivity.this.finish();
                }
            }
        }, null);
        this.jZf.startLoad(this.jZc, 10, false);
        this.jZf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumAdvertActivity.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.signall.SignAllForumAdvertActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ba.aGG().b(SignAllForumAdvertActivity.this.getPageContext(), new String[]{SignAllForumAdvertActivity.this.jZd});
            }
        });
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.signall.SignAllForumAdvertActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SignAllForumAdvertActivity.this.finish();
            }
        });
    }

    private void cIX() {
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
