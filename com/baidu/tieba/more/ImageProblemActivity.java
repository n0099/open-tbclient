package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    v bvD;
    s bvE;
    r bvF;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvE = new s(getPageContext().getPageActivity());
        this.bvD = new v(this, this.bvE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bvF != null) {
            this.bvF.cancel();
            this.bvF = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvD.Vx()) {
            if (this.bvF == null) {
                this.bvD.Vx().setText(getResources().getText(com.baidu.tieba.z.stop));
                this.bvF = new r(this, null);
                this.bvF.execute(new Object[0]);
                return;
            }
            this.bvD.Vx().setText(getResources().getText(com.baidu.tieba.z.diagnose));
            if (this.bvF != null) {
                this.bvF.cancel();
                this.bvF = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bvD.onChangeSkinType(i);
    }
}
