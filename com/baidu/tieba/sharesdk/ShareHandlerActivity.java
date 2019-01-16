package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes3.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    protected ShareEntity hdB;
    protected com.baidu.tieba.sharesdk.a.a hdC;
    protected e hdD;
    private ShareReportModel hdE;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    protected boolean hdz = false;
    protected int hdA = -1;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.hdB = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.hdB == null) {
            finish();
            return;
        }
        L(this.hdB.Kw());
        this.hdA = this.hdB.bAa();
        if (this.hdC != null) {
            this.hdC.onDestroy();
            this.hdC = null;
        }
        if (this.hdD != null) {
            this.hdD.onDestroy();
            this.hdD = null;
        }
        switch (this.hdA) {
            case 0:
                this.hdC = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.hdC = null;
                break;
            case 2:
                this.hdC = new f(this, 2);
                break;
            case 3:
                this.hdC = new f(this, 3);
                break;
            case 4:
                this.hdC = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.hdD = new e(this, this, this);
                this.hdC = this.hdD;
                break;
            case 8:
                this.hdC = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.hdB.bAc() && !TextUtils.isEmpty(this.hdB.yF())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.EG();
            this.mPermissionJudgement.c(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.B(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.hdC != null) {
            this.hdC.q(getUniqueId());
            this.hdC.H(getIntent());
            this.hdC.a(this.hdB, this);
            return;
        }
        a(this.hdA, 2, this.hdB.Kw() != null ? this.hdB.Kw().getString("tid") : null, null);
    }

    private void L(Bundle bundle) {
        if (bundle != null) {
            if (this.hdE == null) {
                this.hdE = new ShareReportModel(getPageContext());
            }
            this.hdE.k(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.hdz) {
            finish();
        } else {
            this.hdz = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hdC != null) {
            this.hdC.H(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.hdC != null) {
            this.hdC.H(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void bJ(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.hdB);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.hdB);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.hdB);
            }
        }
        a(i, i2, this.hdB.Kw() != null ? this.hdB.Kw().getString("tid") : null, ao.isEmpty(this.hdB.aSX) ? null : this.hdB.aSX);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.hdC != null) {
            this.hdC.onDestroy();
        }
        if (this.hdE != null) {
            this.hdE.cancelMessage();
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
        if (this.hdD != null) {
            this.hdD.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.hdD != null) {
            this.hdD.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.hdD != null) {
            this.hdD.onWbShareFail();
        }
    }
}
