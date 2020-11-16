package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes25.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mHn = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHn = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mHn.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mHn.dDl()) {
            this.mHn.dDp();
            TiebaStatic.log("c10649");
        }
        if (view == this.mHn.dDm()) {
            this.mHn.dDq();
            TiebaStatic.log("c10653");
        } else if (view == this.mHn.dDn()) {
            this.mHn.dDr();
        } else if (view == this.mHn.dDo()) {
            this.mHn.dDs();
        } else if (view == this.mHn.dDt()) {
            bf.bqF().b(getPageContext(), new String[]{"http://10.64.36.212:8011/auxiliary-pages/index.html#/app-tool"});
        }
    }
}
