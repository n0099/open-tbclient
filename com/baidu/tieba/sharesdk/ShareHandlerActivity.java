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
    protected boolean gRb = false;
    protected int gRc = -1;
    protected ShareEntity gRd;
    protected com.baidu.tieba.sharesdk.a.a gRe;
    protected e gRf;
    private ShareReportModel gRg;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gRd = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gRd == null) {
            finish();
            return;
        }
        F(this.gRd.IQ());
        this.gRc = this.gRd.bxn();
        if (this.gRe != null) {
            this.gRe.onDestroy();
            this.gRe = null;
        }
        if (this.gRf != null) {
            this.gRf.onDestroy();
            this.gRf = null;
        }
        switch (this.gRc) {
            case 0:
                this.gRe = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gRe = null;
                break;
            case 2:
                this.gRe = new f(this, 2);
                break;
            case 3:
                this.gRe = new f(this, 3);
                break;
            case 4:
                this.gRe = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gRf = new e(this, this, this);
                this.gRe = this.gRf;
                break;
            case 8:
                this.gRe = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gRe != null) {
            this.gRe.q(getUniqueId());
            this.gRe.H(getIntent());
            this.gRe.a(this.gRd, this);
            return;
        }
        g(this.gRc, 2, this.gRd.IQ() != null ? this.gRd.IQ().getString("tid") : null);
    }

    private void F(Bundle bundle) {
        if (bundle != null) {
            if (this.gRg == null) {
                this.gRg = new ShareReportModel(getPageContext());
            }
            this.gRg.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gRb) {
            finish();
        } else {
            this.gRb = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gRe != null) {
            this.gRe.H(intent);
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
    public void bI(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gRd);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gRd);
        }
        String str = null;
        if (this.gRd.IQ() != null) {
            str = this.gRd.IQ().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gRe != null) {
            this.gRe.onDestroy();
        }
        if (this.gRg != null) {
            this.gRg.cancelMessage();
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
        if (this.gRf != null) {
            this.gRf.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gRf != null) {
            this.gRf.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gRf != null) {
            this.gRf.onWbShareFail();
        }
    }
}
