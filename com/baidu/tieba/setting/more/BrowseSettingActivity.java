package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes26.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mVr = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mVr = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mVr.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mVr.dIw()) {
            this.mVr.dIA();
            TiebaStatic.log("c10649");
        }
        if (view == this.mVr.dIx()) {
            this.mVr.dIB();
            TiebaStatic.log("c10653");
        } else if (view == this.mVr.dIy()) {
            this.mVr.dIC();
        } else if (view == this.mVr.dIz()) {
            this.mVr.dID();
        } else if (view == this.mVr.dIE()) {
            bf.bua().b(getPageContext(), new String[]{"http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/#/app-tool"});
        }
    }
}
