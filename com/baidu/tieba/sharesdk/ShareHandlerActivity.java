package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes23.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int aiX = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected boolean mcA = false;
    protected int mcB = -1;
    protected ShareEntity mcC;
    protected com.baidu.tieba.sharesdk.a.a mcD;
    protected e mcE;
    private ShareReportModel mcF;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mcC = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aiX = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.mcC == null) {
            finish();
            return;
        }
        aH(this.mcC.bqr());
        this.mcB = this.mcC.dww();
        if (this.mcD != null) {
            this.mcD.onDestroy();
            this.mcD = null;
        }
        if (this.mcE != null) {
            this.mcE.onDestroy();
            this.mcE = null;
        }
        switch (this.mcB) {
            case 0:
                this.mcD = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.mcD = null;
                break;
            case 2:
                this.mcD = new f(this, 2);
                break;
            case 3:
                this.mcD = new f(this, 3);
                break;
            case 4:
                this.mcD = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.mcE = new e(this, this, this);
                this.mcD = this.mcE;
                break;
            case 8:
                this.mcD = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.mcD != null) {
            this.mcD.setTid(this.mcC.getTid());
            this.mcD.Qz(this.mcC.dwy());
        }
        if (this.mcC.dwB() && !TextUtils.isEmpty(this.mcC.bdu())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.mcD != null) {
            this.mcD.y(getUniqueId());
            this.mcD.M(getIntent());
            this.mcD.a(this.mcC, this);
            return;
        }
        if (this.mcC.bqr() != null) {
            this.mcC.bqr().getString("tid");
        }
        a(this.mcB, 2, this.mcC.bqr(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.mcF == null) {
                this.mcF = new ShareReportModel(getPageContext());
            }
            this.mcF.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mcA) {
            finish();
        } else {
            this.mcA = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aiX = intent.getIntExtra("extra_skin", 3);
        }
        if (this.mcD != null) {
            this.mcD.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.mcD != null) {
            this.mcD.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dj(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.mcC);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.mcC);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.mcC);
            }
        }
        if (this.mcC.bqr() != null) {
            this.mcC.bqr().getString("tid");
            this.mcC.bqr().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.mcC.taskCompleteId)) {
            str = this.mcC.taskCompleteId;
        }
        a(i, i2, this.mcC.bqr(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mcD != null) {
            this.mcD.onDestroy();
        }
        if (this.mcF != null) {
            this.mcF.cancelMessage();
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
        if (this.mcE != null) {
            this.mcE.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.mcE != null) {
            this.mcE.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.mcE != null) {
            this.mcE.onWbShareFail();
        }
    }
}
