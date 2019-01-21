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
    protected boolean hdA = false;
    protected int hdB = -1;
    protected ShareEntity hdC;
    protected com.baidu.tieba.sharesdk.a.a hdD;
    protected e hdE;
    private ShareReportModel hdF;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.hdC = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.hdC == null) {
            finish();
            return;
        }
        L(this.hdC.Kw());
        this.hdB = this.hdC.bAa();
        if (this.hdD != null) {
            this.hdD.onDestroy();
            this.hdD = null;
        }
        if (this.hdE != null) {
            this.hdE.onDestroy();
            this.hdE = null;
        }
        switch (this.hdB) {
            case 0:
                this.hdD = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.hdD = null;
                break;
            case 2:
                this.hdD = new f(this, 2);
                break;
            case 3:
                this.hdD = new f(this, 3);
                break;
            case 4:
                this.hdD = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.hdE = new e(this, this, this);
                this.hdD = this.hdE;
                break;
            case 8:
                this.hdD = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.hdC.bAc() && !TextUtils.isEmpty(this.hdC.yF())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.EG();
            this.mPermissionJudgement.c(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.B(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.hdD != null) {
            this.hdD.q(getUniqueId());
            this.hdD.H(getIntent());
            this.hdD.a(this.hdC, this);
            return;
        }
        a(this.hdB, 2, this.hdC.Kw() != null ? this.hdC.Kw().getString("tid") : null, null);
    }

    private void L(Bundle bundle) {
        if (bundle != null) {
            if (this.hdF == null) {
                this.hdF = new ShareReportModel(getPageContext());
            }
            this.hdF.k(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.hdA) {
            finish();
        } else {
            this.hdA = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hdD != null) {
            this.hdD.H(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.hdD != null) {
            this.hdD.H(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void bJ(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.hdC);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.hdC);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.hdC);
            }
        }
        a(i, i2, this.hdC.Kw() != null ? this.hdC.Kw().getString("tid") : null, ao.isEmpty(this.hdC.aSY) ? null : this.hdC.aSY);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.hdD != null) {
            this.hdD.onDestroy();
        }
        if (this.hdF != null) {
            this.hdF.cancelMessage();
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
        if (this.hdE != null) {
            this.hdE.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.hdE != null) {
            this.hdE.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.hdE != null) {
            this.hdE.onWbShareFail();
        }
    }
}
