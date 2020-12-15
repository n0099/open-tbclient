package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes26.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mVt = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mVt = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mVt.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mVt.dIx()) {
            this.mVt.dIB();
            TiebaStatic.log("c10649");
        }
        if (view == this.mVt.dIy()) {
            this.mVt.dIC();
            TiebaStatic.log("c10653");
        } else if (view == this.mVt.dIz()) {
            this.mVt.dID();
        } else if (view == this.mVt.dIA()) {
            this.mVt.dIE();
        } else if (view == this.mVt.dIF()) {
            bf.bua().b(getPageContext(), new String[]{"http://bjhw-bac-orp-tieba-core-137287.bjhw.baidu.com:8899/#/app-tool"});
        }
    }
}
