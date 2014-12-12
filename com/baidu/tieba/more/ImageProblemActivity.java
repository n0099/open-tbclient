package com.baidu.tieba.more;

import android.os.Bundle;
import android.view.View;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageProblemActivityConfig;
/* loaded from: classes.dex */
public class ImageProblemActivity extends BaseActivity<ImageProblemActivity> {
    v buh;
    s bui;
    r buj;

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(ImageProblemActivityConfig.class, ImageProblemActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bui = new s(getPageContext().getPageActivity());
        this.buh = new v(this, this.bui);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.buj != null) {
            this.buj.cancel();
            this.buj = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.buh.UZ()) {
            if (this.buj == null) {
                this.buh.UZ().setText(getResources().getText(com.baidu.tieba.z.stop));
                this.buj = new r(this, null);
                this.buj.execute(new Object[0]);
                return;
            }
            this.buh.UZ().setText(getResources().getText(com.baidu.tieba.z.diagnose));
            if (this.buj != null) {
                this.buj.cancel();
                this.buj = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.buh.onChangeSkinType(i);
    }
}
