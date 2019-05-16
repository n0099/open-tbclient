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
    protected boolean iNK = false;
    protected int iNL = -1;
    protected ShareEntity iNM;
    protected com.baidu.tieba.sharesdk.a.a iNN;
    protected e iNO;
    private ShareReportModel iNP;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iNM = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ccI = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iNM == null) {
            finish();
            return;
        }
        ag(this.iNM.aoQ());
        this.iNL = this.iNM.ciS();
        if (this.iNN != null) {
            this.iNN.onDestroy();
            this.iNN = null;
        }
        if (this.iNO != null) {
            this.iNO.onDestroy();
            this.iNO = null;
        }
        switch (this.iNL) {
            case 0:
                this.iNN = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iNN = null;
                break;
            case 2:
                this.iNN = new f(this, 2);
                break;
            case 3:
                this.iNN = new f(this, 3);
                break;
            case 4:
                this.iNN = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iNO = new e(this, this, this);
                this.iNN = this.iNO;
                break;
            case 8:
                this.iNN = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iNN != null) {
            this.iNN.setTid(this.iNM.getTid());
        }
        if (this.iNM.ciU() && !TextUtils.isEmpty(this.iNM.abS())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.aa(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iNN != null) {
            this.iNN.t(getUniqueId());
            this.iNN.aa(getIntent());
            this.iNN.a(this.iNM, this);
            return;
        }
        b(this.iNL, 2, this.iNM.aoQ() != null ? this.iNM.aoQ().getString("tid") : null, null);
    }

    private void ag(Bundle bundle) {
        if (bundle != null) {
            if (this.iNP == null) {
                this.iNP = new ShareReportModel(getPageContext());
            }
            this.iNP.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iNK) {
            finish();
        } else {
            this.iNK = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ccI = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iNN != null) {
            this.iNN.aa(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iNN != null) {
            this.iNN.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cm(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iNM);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iNM);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iNM);
            }
        }
        b(i, i2, this.iNM.aoQ() != null ? this.iNM.aoQ().getString("tid") : null, ap.isEmpty(this.iNM.cjM) ? null : this.iNM.cjM);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iNN != null) {
            this.iNN.onDestroy();
        }
        if (this.iNP != null) {
            this.iNP.cancelMessage();
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
        if (this.iNO != null) {
            this.iNO.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iNO != null) {
            this.iNO.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iNO != null) {
            this.iNO.onWbShareFail();
        }
    }
}
