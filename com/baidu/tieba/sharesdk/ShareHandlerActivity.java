package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes6.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int bUN = 3;
    protected boolean iuW = false;
    protected int iuX = -1;
    protected ShareEntity iuY;
    protected com.baidu.tieba.sharesdk.a.a iuZ;
    protected e iva;
    private ShareReportModel ivb;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iuY = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            bUN = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iuY == null) {
            finish();
            return;
        }
        af(this.iuY.ajP());
        this.iuX = this.iuY.caO();
        if (this.iuZ != null) {
            this.iuZ.onDestroy();
            this.iuZ = null;
        }
        if (this.iva != null) {
            this.iva.onDestroy();
            this.iva = null;
        }
        switch (this.iuX) {
            case 0:
                this.iuZ = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iuZ = null;
                break;
            case 2:
                this.iuZ = new f(this, 2);
                break;
            case 3:
                this.iuZ = new f(this, 3);
                break;
            case 4:
                this.iuZ = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iva = new e(this, this, this);
                this.iuZ = this.iva;
                break;
            case 8:
                this.iuZ = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iuY.caQ() && !TextUtils.isEmpty(this.iuY.Xk())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adN();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.Y(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iuZ != null) {
            this.iuZ.r(getUniqueId());
            this.iuZ.X(getIntent());
            this.iuZ.a(this.iuY, this);
            return;
        }
        a(this.iuX, 2, this.iuY.ajP() != null ? this.iuY.ajP().getString("tid") : null, null);
    }

    private void af(Bundle bundle) {
        if (bundle != null) {
            if (this.ivb == null) {
                this.ivb = new ShareReportModel(getPageContext());
            }
            this.ivb.s(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iuW) {
            finish();
        } else {
            this.iuW = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            bUN = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iuZ != null) {
            this.iuZ.X(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iuZ != null) {
            this.iuZ.X(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cf(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iuY);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iuY);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iuY);
            }
        }
        a(i, i2, this.iuY.ajP() != null ? this.iuY.ajP().getString("tid") : null, ap.isEmpty(this.iuY.cbL) ? null : this.iuY.cbL);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iuZ != null) {
            this.iuZ.onDestroy();
        }
        if (this.ivb != null) {
            this.ivb.cancelMessage();
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
        if (this.iva != null) {
            this.iva.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iva != null) {
            this.iva.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iva != null) {
            this.iva.onWbShareFail();
        }
    }
}
