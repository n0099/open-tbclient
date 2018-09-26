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
    protected boolean gJD = false;
    protected int gJE = -1;
    protected ShareEntity gJF;
    protected com.baidu.tieba.sharesdk.a.a gJG;
    protected e gJH;
    private ShareReportModel gJI;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gJF = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gJF == null) {
            finish();
            return;
        }
        E(this.gJF.GP());
        this.gJE = this.gJF.btY();
        if (this.gJG != null) {
            this.gJG.onDestroy();
            this.gJG = null;
        }
        if (this.gJH != null) {
            this.gJH.onDestroy();
            this.gJH = null;
        }
        switch (this.gJE) {
            case 0:
                this.gJG = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gJG = null;
                break;
            case 2:
                this.gJG = new f(this, 2);
                break;
            case 3:
                this.gJG = new f(this, 3);
                break;
            case 4:
                this.gJG = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gJH = new e(this, this, this);
                this.gJG = this.gJH;
                break;
            case 8:
                this.gJG = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gJG != null) {
            this.gJG.q(getUniqueId());
            this.gJG.D(getIntent());
            this.gJG.a(this.gJF, this);
            return;
        }
        g(this.gJE, 2, this.gJF.GP() != null ? this.gJF.GP().getString("tid") : null);
    }

    private void E(Bundle bundle) {
        if (bundle != null) {
            if (this.gJI == null) {
                this.gJI = new ShareReportModel(getPageContext());
            }
            this.gJI.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gJD) {
            finish();
        } else {
            this.gJD = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gJG != null) {
            this.gJG.D(intent);
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
    public void bF(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gJF);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gJF);
        }
        String str = null;
        if (this.gJF.GP() != null) {
            str = this.gJF.GP().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gJG != null) {
            this.gJG.onDestroy();
        }
        if (this.gJI != null) {
            this.gJI.cancelMessage();
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
        if (this.gJH != null) {
            this.gJH.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gJH != null) {
            this.gJH.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gJH != null) {
            this.gJH.onWbShareFail();
        }
    }
}
