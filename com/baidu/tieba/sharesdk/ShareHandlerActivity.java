package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    public static int ccI = 3;
    protected boolean iNM = false;
    protected int iNN = -1;
    protected ShareEntity iNO;
    protected com.baidu.tieba.sharesdk.a.a iNP;
    protected e iNQ;
    private ShareReportModel iNR;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iNO = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ccI = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iNO == null) {
            finish();
            return;
        }
        ag(this.iNO.aoQ());
        this.iNN = this.iNO.ciU();
        if (this.iNP != null) {
            this.iNP.onDestroy();
            this.iNP = null;
        }
        if (this.iNQ != null) {
            this.iNQ.onDestroy();
            this.iNQ = null;
        }
        switch (this.iNN) {
            case 0:
                this.iNP = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iNP = null;
                break;
            case 2:
                this.iNP = new f(this, 2);
                break;
            case 3:
                this.iNP = new f(this, 3);
                break;
            case 4:
                this.iNP = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iNQ = new e(this, this, this);
                this.iNP = this.iNQ;
                break;
            case 8:
                this.iNP = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iNP != null) {
            this.iNP.setTid(this.iNO.getTid());
        }
        if (this.iNO.ciW() && !TextUtils.isEmpty(this.iNO.abS())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.aa(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iNP != null) {
            this.iNP.t(getUniqueId());
            this.iNP.aa(getIntent());
            this.iNP.a(this.iNO, this);
            return;
        }
        b(this.iNN, 2, this.iNO.aoQ() != null ? this.iNO.aoQ().getString("tid") : null, null);
    }

    private void ag(Bundle bundle) {
        if (bundle != null) {
            if (this.iNR == null) {
                this.iNR = new ShareReportModel(getPageContext());
            }
            this.iNR.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iNM) {
            finish();
        } else {
            this.iNM = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ccI = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iNP != null) {
            this.iNP.aa(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iNP != null) {
            this.iNP.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cm(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iNO);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iNO);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iNO);
            }
        }
        b(i, i2, this.iNO.aoQ() != null ? this.iNO.aoQ().getString("tid") : null, ap.isEmpty(this.iNO.cjM) ? null : this.iNO.cjM);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iNP != null) {
            this.iNP.onDestroy();
        }
        if (this.iNR != null) {
            this.iNR.cancelMessage();
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
        if (this.iNQ != null) {
            this.iNQ.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iNQ != null) {
            this.iNQ.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iNQ != null) {
            this.iNQ.onWbShareFail();
        }
    }
}
