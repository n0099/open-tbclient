package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    v bvC;
    s bvD;
    r bvE;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bvD = new s(getPageContext().getPageActivity());
        this.bvC = new v(this, this.bvD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.bvE != null) {
            this.bvE.cancel();
            this.bvE = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvC.Vs()) {
            if (this.bvE == null) {
                this.bvC.Vs().setText(getResources().getText(com.baidu.tieba.z.stop));
                this.bvE = new r(this, null);
                this.bvE.execute(new Object[0]);
                return;
            }
            this.bvC.Vs().setText(getResources().getText(com.baidu.tieba.z.diagnose));
            if (this.bvE != null) {
                this.bvE.cancel();
                this.bvE = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.bvC.onChangeSkinType(i);
    }
}
