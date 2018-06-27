package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes3.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    protected boolean gAP = false;
    protected int gAQ = -1;
    protected ShareEntity gAR;
    protected com.baidu.tieba.sharesdk.a.a gAS;
    protected e gAT;
    private ShareReportModel gAU;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gAR = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gAR == null) {
            finish();
            return;
        }
        E(this.gAR.FD());
        this.gAQ = this.gAR.bsP();
        if (this.gAS != null) {
            this.gAS.onDestroy();
            this.gAS = null;
        }
        if (this.gAT != null) {
            this.gAT.onDestroy();
            this.gAT = null;
        }
        switch (this.gAQ) {
            case 0:
                this.gAS = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gAS = null;
                break;
            case 2:
                this.gAS = new f(this, 2);
                break;
            case 3:
                this.gAS = new f(this, 3);
                break;
            case 4:
                this.gAS = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gAT = new e(this, this, this);
                this.gAS = this.gAT;
                break;
            case 8:
                this.gAS = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gAS != null) {
            this.gAS.r(getUniqueId());
            this.gAS.D(getIntent());
            this.gAS.a(this.gAR, this);
            return;
        }
        g(this.gAQ, 2, this.gAR.FD() != null ? this.gAR.FD().getString("tid") : null);
    }

    private void E(Bundle bundle) {
        if (bundle != null) {
            if (this.gAU == null) {
                this.gAU = new ShareReportModel(getPageContext());
            }
            this.gAU.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.gAP) {
            finish();
        } else {
            this.gAP = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gAS != null) {
            this.gAS.D(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void bC(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gAR);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gAR);
        }
        String str = null;
        if (this.gAR.FD() != null) {
            str = this.gAR.FD().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gAS != null) {
            this.gAS.onDestroy();
        }
        if (this.gAU != null) {
            this.gAU.cancelMessage();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        super.enterExitAnimation();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        super.closeAnimation();
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        if (this.gAT != null) {
            this.gAT.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gAT != null) {
            this.gAT.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gAT != null) {
            this.gAT.onWbShareFail();
        }
    }
}
