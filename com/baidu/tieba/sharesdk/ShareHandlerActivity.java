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
    protected boolean gSA = false;
    protected int gSB = -1;
    protected ShareEntity gSC;
    protected com.baidu.tieba.sharesdk.a.a gSD;
    protected e gSE;
    private ShareReportModel gSF;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gSC = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gSC == null) {
            finish();
            return;
        }
        I(this.gSC.Jc());
        this.gSB = this.gSC.bwJ();
        if (this.gSD != null) {
            this.gSD.onDestroy();
            this.gSD = null;
        }
        if (this.gSE != null) {
            this.gSE.onDestroy();
            this.gSE = null;
        }
        switch (this.gSB) {
            case 0:
                this.gSD = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gSD = null;
                break;
            case 2:
                this.gSD = new f(this, 2);
                break;
            case 3:
                this.gSD = new f(this, 3);
                break;
            case 4:
                this.gSD = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gSE = new e(this, this, this);
                this.gSD = this.gSE;
                break;
            case 8:
                this.gSD = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gSD != null) {
            this.gSD.q(getUniqueId());
            this.gSD.H(getIntent());
            this.gSD.a(this.gSC, this);
            return;
        }
        g(this.gSB, 2, this.gSC.Jc() != null ? this.gSC.Jc().getString("tid") : null);
    }

    private void I(Bundle bundle) {
        if (bundle != null) {
            if (this.gSF == null) {
                this.gSF = new ShareReportModel(getPageContext());
            }
            this.gSF.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gSA) {
            finish();
        } else {
            this.gSA = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gSD != null) {
            this.gSD.H(intent);
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
    public void bK(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gSC);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gSC);
        }
        String str = null;
        if (this.gSC.Jc() != null) {
            str = this.gSC.Jc().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gSD != null) {
            this.gSD.onDestroy();
        }
        if (this.gSF != null) {
            this.gSF.cancelMessage();
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
        if (this.gSE != null) {
            this.gSE.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gSE != null) {
            this.gSE.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gSE != null) {
            this.gSE.onWbShareFail();
        }
    }
}
