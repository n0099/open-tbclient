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
    protected boolean gRc = false;
    protected int gRd = -1;
    protected ShareEntity gRe;
    protected com.baidu.tieba.sharesdk.a.a gRf;
    protected e gRg;
    private ShareReportModel gRh;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gRe = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gRe == null) {
            finish();
            return;
        }
        F(this.gRe.IQ());
        this.gRd = this.gRe.bxn();
        if (this.gRf != null) {
            this.gRf.onDestroy();
            this.gRf = null;
        }
        if (this.gRg != null) {
            this.gRg.onDestroy();
            this.gRg = null;
        }
        switch (this.gRd) {
            case 0:
                this.gRf = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gRf = null;
                break;
            case 2:
                this.gRf = new f(this, 2);
                break;
            case 3:
                this.gRf = new f(this, 3);
                break;
            case 4:
                this.gRf = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gRg = new e(this, this, this);
                this.gRf = this.gRg;
                break;
            case 8:
                this.gRf = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gRf != null) {
            this.gRf.q(getUniqueId());
            this.gRf.H(getIntent());
            this.gRf.a(this.gRe, this);
            return;
        }
        g(this.gRd, 2, this.gRe.IQ() != null ? this.gRe.IQ().getString("tid") : null);
    }

    private void F(Bundle bundle) {
        if (bundle != null) {
            if (this.gRh == null) {
                this.gRh = new ShareReportModel(getPageContext());
            }
            this.gRh.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gRc) {
            finish();
        } else {
            this.gRc = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gRf != null) {
            this.gRf.H(intent);
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
            com.baidu.tieba.sharesdk.c.b.a(i, this.gRe);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gRe);
        }
        String str = null;
        if (this.gRe.IQ() != null) {
            str = this.gRe.IQ().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gRf != null) {
            this.gRf.onDestroy();
        }
        if (this.gRh != null) {
            this.gRh.cancelMessage();
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
        if (this.gRg != null) {
            this.gRg.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gRg != null) {
            this.gRg.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gRg != null) {
            this.gRg.onWbShareFail();
        }
    }
}
