package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity {
    w bqS;
    t bqT;
    s bqU;

    static {
        TbadkApplication.m251getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bqT = new t(this);
        this.bqS = new w(this, this.bqT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bqU != null) {
            this.bqU.cancel();
            this.bqU = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bqS.UN()) {
            if (this.bqU == null) {
                this.bqS.UN().setText(getResources().getText(com.baidu.tieba.y.stop));
                this.bqU = new s(this, null);
                this.bqU.execute(new Object[0]);
                return;
            }
            this.bqS.UN().setText(getResources().getText(com.baidu.tieba.y.diagnose));
            if (this.bqU != null) {
                this.bqU.cancel();
                this.bqU = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bqS.onChangeSkinType(i);
    }
}
