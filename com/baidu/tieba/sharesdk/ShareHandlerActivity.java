package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes6.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int ceL = 3;
    protected boolean iXH = false;
    protected int iXI = -1;
    protected ShareEntity iXJ;
    protected com.baidu.tieba.sharesdk.a.a iXK;
    protected e iXL;
    private ShareReportModel iXM;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iXJ = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ceL = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iXJ == null) {
            finish();
            return;
        }
        ag(this.iXJ.aqk());
        this.iXI = this.iXJ.cmQ();
        if (this.iXK != null) {
            this.iXK.onDestroy();
            this.iXK = null;
        }
        if (this.iXL != null) {
            this.iXL.onDestroy();
            this.iXL = null;
        }
        switch (this.iXI) {
            case 0:
                this.iXK = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iXK = null;
                break;
            case 2:
                this.iXK = new f(this, 2);
                break;
            case 3:
                this.iXK = new f(this, 3);
                break;
            case 4:
                this.iXK = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iXL = new e(this, this, this);
                this.iXK = this.iXL;
                break;
            case 8:
                this.iXK = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iXK != null) {
            this.iXK.setTid(this.iXJ.getTid());
        }
        if (this.iXJ.cmS() && !TextUtils.isEmpty(this.iXJ.acZ())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.ake();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.ad(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iXK != null) {
            this.iXK.t(getUniqueId());
            this.iXK.ac(getIntent());
            this.iXK.a(this.iXJ, this);
            return;
        }
        b(this.iXI, 2, this.iXJ.aqk() != null ? this.iXJ.aqk().getString("tid") : null, null);
    }

    private void ag(Bundle bundle) {
        if (bundle != null) {
            if (this.iXM == null) {
                this.iXM = new ShareReportModel(getPageContext());
            }
            this.iXM.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iXH) {
            finish();
        } else {
            this.iXH = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ceL = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iXK != null) {
            this.iXK.ac(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iXK != null) {
            this.iXK.ac(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cs(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iXJ);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iXJ);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iXJ);
            }
        }
        b(i, i2, this.iXJ.aqk() != null ? this.iXJ.aqk().getString("tid") : null, aq.isEmpty(this.iXJ.clU) ? null : this.iXJ.clU);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iXK != null) {
            this.iXK.onDestroy();
        }
        if (this.iXM != null) {
            this.iXM.cancelMessage();
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
        if (this.iXL != null) {
            this.iXL.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iXL != null) {
            this.iXL.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iXL != null) {
            this.iXL.onWbShareFail();
        }
    }
}
