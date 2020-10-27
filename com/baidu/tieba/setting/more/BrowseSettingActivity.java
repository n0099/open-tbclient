package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
/* loaded from: classes26.dex */
public class BrowseSettingActivity extends BaseActivity {
    private c mAL = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mAL = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mAL.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mAL.dBe()) {
            this.mAL.dBi();
            TiebaStatic.log("c10649");
        }
        if (view == this.mAL.dBf()) {
            this.mAL.dBj();
            TiebaStatic.log("c10653");
        } else if (view == this.mAL.dBg()) {
            this.mAL.dBk();
        } else if (view == this.mAL.dBh()) {
            this.mAL.dBl();
        } else if (view == this.mAL.dBm()) {
            be.boR().b(getPageContext(), new String[]{"http://10.64.36.212:8011/auxiliary-pages/index.html#/app-tool"});
        }
    }
}
