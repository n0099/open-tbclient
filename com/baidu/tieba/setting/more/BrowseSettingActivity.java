package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import d.a.o0.w2.c.c;
/* loaded from: classes5.dex */
public class BrowseSettingActivity extends BaseActivity {
    public c mView = null;

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.onChangeSkinType(i2);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mView.l()) {
            this.mView.v();
            TiebaStatic.log("c10649");
        }
        if (view == this.mView.o()) {
            this.mView.x();
            TiebaStatic.log("c10653");
        } else if (view == this.mView.n()) {
            this.mView.w();
        } else if (view == this.mView.p()) {
            this.mView.y();
        } else if (view == this.mView.m()) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{"http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/#/app-tool"});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mView = new c(this);
    }
}
