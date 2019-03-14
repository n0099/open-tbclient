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
    public static int bUK = 3;
    protected boolean ivl = false;
    protected int ivm = -1;
    protected ShareEntity ivn;
    protected com.baidu.tieba.sharesdk.a.a ivo;
    protected e ivp;
    private ShareReportModel ivq;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.ivn = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            bUK = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.ivn == null) {
            finish();
            return;
        }
        af(this.ivn.ajS());
        this.ivm = this.ivn.caS();
        if (this.ivo != null) {
            this.ivo.onDestroy();
            this.ivo = null;
        }
        if (this.ivp != null) {
            this.ivp.onDestroy();
            this.ivp = null;
        }
        switch (this.ivm) {
            case 0:
                this.ivo = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.ivo = null;
                break;
            case 2:
                this.ivo = new f(this, 2);
                break;
            case 3:
                this.ivo = new f(this, 3);
                break;
            case 4:
                this.ivo = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.ivp = new e(this, this, this);
                this.ivo = this.ivp;
                break;
            case 8:
                this.ivo = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.ivn.caU() && !TextUtils.isEmpty(this.ivn.Xn())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adQ();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.Y(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.ivo != null) {
            this.ivo.r(getUniqueId());
            this.ivo.X(getIntent());
            this.ivo.a(this.ivn, this);
            return;
        }
        a(this.ivm, 2, this.ivn.ajS() != null ? this.ivn.ajS().getString("tid") : null, null);
    }

    private void af(Bundle bundle) {
        if (bundle != null) {
            if (this.ivq == null) {
                this.ivq = new ShareReportModel(getPageContext());
            }
            this.ivq.s(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.ivl) {
            finish();
        } else {
            this.ivl = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            bUK = intent.getIntExtra("extra_skin", 3);
        }
        if (this.ivo != null) {
            this.ivo.X(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.ivo != null) {
            this.ivo.X(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cf(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.ivn);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.ivn);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.ivn);
            }
        }
        a(i, i2, this.ivn.ajS() != null ? this.ivn.ajS().getString("tid") : null, ap.isEmpty(this.ivn.cbI) ? null : this.ivn.cbI);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.ivo != null) {
            this.ivo.onDestroy();
        }
        if (this.ivq != null) {
            this.ivq.cancelMessage();
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
        if (this.ivp != null) {
            this.ivp.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.ivp != null) {
            this.ivp.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.ivp != null) {
            this.ivp.onWbShareFail();
        }
    }
}
