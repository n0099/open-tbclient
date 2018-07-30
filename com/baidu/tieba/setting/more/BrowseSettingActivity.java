package com.baidu.tieba.setting.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes3.dex */
public class BrowseSettingActivity extends BaseActivity {
    private b gze = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gze = new b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gze.onChangeSkinType(i);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gze.bpu()) {
            this.gze.bpz();
            TiebaStatic.log("c10649");
        }
        if (view == this.gze.bpv()) {
            this.gze.bpA();
            TiebaStatic.log("c10653");
        } else if (view == this.gze.bpw()) {
            this.gze.bpB();
        } else if (view == this.gze.bpx()) {
            this.gze.bpC();
        } else if (view == this.gze.bpy()) {
            this.gze.bpD();
        }
    }
}
