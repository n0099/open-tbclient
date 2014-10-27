package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity {
    w bqE;
    t bqF;
    s bqG;

    static {
        TbadkApplication.m251getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bqF = new t(this);
        this.bqE = new w(this, this.bqF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bqG != null) {
            this.bqG.cancel();
            this.bqG = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bqE.UK()) {
            if (this.bqG == null) {
                this.bqE.UK().setText(getResources().getText(com.baidu.tieba.y.stop));
                this.bqG = new s(this, null);
                this.bqG.execute(new Object[0]);
                return;
            }
            this.bqE.UK().setText(getResources().getText(com.baidu.tieba.y.diagnose));
            if (this.bqG != null) {
                this.bqG.cancel();
                this.bqG = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bqE.onChangeSkinType(i);
    }
}
