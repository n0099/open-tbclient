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
    public static int bUM = 3;
    protected boolean iuV = false;
    protected int iuW = -1;
    protected ShareEntity iuX;
    protected com.baidu.tieba.sharesdk.a.a iuY;
    protected e iuZ;
    private ShareReportModel iva;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iuX = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            bUM = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iuX == null) {
            finish();
            return;
        }
        af(this.iuX.ajP());
        this.iuW = this.iuX.caO();
        if (this.iuY != null) {
            this.iuY.onDestroy();
            this.iuY = null;
        }
        if (this.iuZ != null) {
            this.iuZ.onDestroy();
            this.iuZ = null;
        }
        switch (this.iuW) {
            case 0:
                this.iuY = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iuY = null;
                break;
            case 2:
                this.iuY = new f(this, 2);
                break;
            case 3:
                this.iuY = new f(this, 3);
                break;
            case 4:
                this.iuY = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iuZ = new e(this, this, this);
                this.iuY = this.iuZ;
                break;
            case 8:
                this.iuY = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iuX.caQ() && !TextUtils.isEmpty(this.iuX.Xk())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adN();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.Y(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iuY != null) {
            this.iuY.r(getUniqueId());
            this.iuY.X(getIntent());
            this.iuY.a(this.iuX, this);
            return;
        }
        a(this.iuW, 2, this.iuX.ajP() != null ? this.iuX.ajP().getString("tid") : null, null);
    }

    private void af(Bundle bundle) {
        if (bundle != null) {
            if (this.iva == null) {
                this.iva = new ShareReportModel(getPageContext());
            }
            this.iva.s(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iuV) {
            finish();
        } else {
            this.iuV = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            bUM = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iuY != null) {
            this.iuY.X(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iuY != null) {
            this.iuY.X(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cf(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iuX);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iuX);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iuX);
            }
        }
        a(i, i2, this.iuX.ajP() != null ? this.iuX.ajP().getString("tid") : null, ap.isEmpty(this.iuX.cbK) ? null : this.iuX.cbK);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iuY != null) {
            this.iuY.onDestroy();
        }
        if (this.iva != null) {
            this.iva.cancelMessage();
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
        if (this.iuZ != null) {
            this.iuZ.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iuZ != null) {
            this.iuZ.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iuZ != null) {
            this.iuZ.onWbShareFail();
        }
    }
}
