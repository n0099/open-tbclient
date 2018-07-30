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
    protected boolean gBX = false;
    protected int gBY = -1;
    protected ShareEntity gBZ;
    protected com.baidu.tieba.sharesdk.a.a gCa;
    protected e gCb;
    private ShareReportModel gCc;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gBZ = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gBZ == null) {
            finish();
            return;
        }
        E(this.gBZ.Fz());
        this.gBY = this.gBZ.brs();
        if (this.gCa != null) {
            this.gCa.onDestroy();
            this.gCa = null;
        }
        if (this.gCb != null) {
            this.gCb.onDestroy();
            this.gCb = null;
        }
        switch (this.gBY) {
            case 0:
                this.gCa = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gCa = null;
                break;
            case 2:
                this.gCa = new f(this, 2);
                break;
            case 3:
                this.gCa = new f(this, 3);
                break;
            case 4:
                this.gCa = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gCb = new e(this, this, this);
                this.gCa = this.gCb;
                break;
            case 8:
                this.gCa = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gCa != null) {
            this.gCa.r(getUniqueId());
            this.gCa.D(getIntent());
            this.gCa.a(this.gBZ, this);
            return;
        }
        g(this.gBY, 2, this.gBZ.Fz() != null ? this.gBZ.Fz().getString("tid") : null);
    }

    private void E(Bundle bundle) {
        if (bundle != null) {
            if (this.gCc == null) {
                this.gCc = new ShareReportModel(getPageContext());
            }
            this.gCc.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gBX) {
            finish();
        } else {
            this.gBX = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gCa != null) {
            this.gCa.D(intent);
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
    public void bD(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gBZ);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gBZ);
        }
        String str = null;
        if (this.gBZ.Fz() != null) {
            str = this.gBZ.Fz().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gCa != null) {
            this.gCa.onDestroy();
        }
        if (this.gCc != null) {
            this.gCc.cancelMessage();
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
        if (this.gCb != null) {
            this.gCb.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gCb != null) {
            this.gCb.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gCb != null) {
            this.gCb.onWbShareFail();
        }
    }
}
