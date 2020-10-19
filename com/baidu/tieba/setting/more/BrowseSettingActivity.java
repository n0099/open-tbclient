package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes26.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mok = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mok = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mok.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mok.dxW()) {
            this.mok.dya();
            TiebaStatic.log("c10649");
        }
        if (view == this.mok.dxX()) {
            this.mok.dyb();
            TiebaStatic.log("c10653");
        } else if (view == this.mok.dxY()) {
            this.mok.dyc();
        } else if (view == this.mok.dxZ()) {
            this.mok.dyd();
        } else if (view == this.mok.dye()) {
            be.bmY().b(getPageContext(), new String[]{"http://10.64.36.212:8011/auxiliary-pages/index.html#/app-tool"});
        }
    }
}
