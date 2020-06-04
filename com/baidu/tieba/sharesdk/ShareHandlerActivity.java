package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes11.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int agt = 3;
    protected boolean kZS = false;
    protected int kZT = -1;
    protected ShareEntity kZU;
    protected com.baidu.tieba.sharesdk.a.a kZV;
    protected e kZW;
    private ShareReportModel kZX;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.kZU = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            agt = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.kZU == null) {
            finish();
            return;
        }
        aF(this.kZU.bbc());
        this.kZT = this.kZU.cZE();
        if (this.kZV != null) {
            this.kZV.onDestroy();
            this.kZV = null;
        }
        if (this.kZW != null) {
            this.kZW.onDestroy();
            this.kZW = null;
        }
        switch (this.kZT) {
            case 0:
                this.kZV = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.kZV = null;
                break;
            case 2:
                this.kZV = new f(this, 2);
                break;
            case 3:
                this.kZV = new f(this, 3);
                break;
            case 4:
                this.kZV = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.kZW = new e(this, this, this);
                this.kZV = this.kZW;
                break;
            case 8:
                this.kZV = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.kZV != null) {
            this.kZV.setTid(this.kZU.getTid());
        }
        if (this.kZU.cZI() && !TextUtils.isEmpty(this.kZU.aOP())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.kZV != null) {
            this.kZV.y(getUniqueId());
            this.kZV.J(getIntent());
            this.kZV.a(this.kZU, this);
            return;
        }
        b(this.kZT, 2, this.kZU.bbc() != null ? this.kZU.bbc().getString("tid") : null, null);
    }

    private void aF(Bundle bundle) {
        if (bundle != null) {
            if (this.kZX == null) {
                this.kZX = new ShareReportModel(getPageContext());
            }
            this.kZX.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kZS) {
            finish();
        } else {
            this.kZS = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            agt = intent.getIntExtra("extra_skin", 3);
        }
        if (this.kZV != null) {
            this.kZV.J(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.kZV != null) {
            this.kZV.J(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cP(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.kZU);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.kZU);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.kZU);
            }
        }
        b(i, i2, this.kZU.bbc() != null ? this.kZU.bbc().getString("tid") : null, aq.isEmpty(this.kZU.taskCompleteId) ? null : this.kZU.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kZV != null) {
            this.kZV.onDestroy();
        }
        if (this.kZX != null) {
            this.kZX.cancelMessage();
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
        if (this.kZW != null) {
            this.kZW.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.kZW != null) {
            this.kZW.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.kZW != null) {
            this.kZW.onWbShareFail();
        }
    }
}
