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
    protected boolean kYJ = false;
    protected int kYK = -1;
    protected ShareEntity kYL;
    protected com.baidu.tieba.sharesdk.a.a kYM;
    protected e kYN;
    private ShareReportModel kYO;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.kYL = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            agt = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.kYL == null) {
            finish();
            return;
        }
        aF(this.kYL.bbb());
        this.kYK = this.kYL.cZo();
        if (this.kYM != null) {
            this.kYM.onDestroy();
            this.kYM = null;
        }
        if (this.kYN != null) {
            this.kYN.onDestroy();
            this.kYN = null;
        }
        switch (this.kYK) {
            case 0:
                this.kYM = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.kYM = null;
                break;
            case 2:
                this.kYM = new f(this, 2);
                break;
            case 3:
                this.kYM = new f(this, 3);
                break;
            case 4:
                this.kYM = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.kYN = new e(this, this, this);
                this.kYM = this.kYN;
                break;
            case 8:
                this.kYM = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.kYM != null) {
            this.kYM.setTid(this.kYL.getTid());
        }
        if (this.kYL.cZs() && !TextUtils.isEmpty(this.kYL.aOP())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.kYM != null) {
            this.kYM.y(getUniqueId());
            this.kYM.J(getIntent());
            this.kYM.a(this.kYL, this);
            return;
        }
        b(this.kYK, 2, this.kYL.bbb() != null ? this.kYL.bbb().getString("tid") : null, null);
    }

    private void aF(Bundle bundle) {
        if (bundle != null) {
            if (this.kYO == null) {
                this.kYO = new ShareReportModel(getPageContext());
            }
            this.kYO.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.kYJ) {
            finish();
        } else {
            this.kYJ = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            agt = intent.getIntExtra("extra_skin", 3);
        }
        if (this.kYM != null) {
            this.kYM.J(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.kYM != null) {
            this.kYM.J(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cP(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.kYL);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.kYL);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.kYL);
            }
        }
        b(i, i2, this.kYL.bbb() != null ? this.kYL.bbb().getString("tid") : null, aq.isEmpty(this.kYL.taskCompleteId) ? null : this.kYL.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kYM != null) {
            this.kYM.onDestroy();
        }
        if (this.kYO != null) {
            this.kYO.cancelMessage();
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
        if (this.kYN != null) {
            this.kYN.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.kYN != null) {
            this.kYN.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.kYN != null) {
            this.kYN.onWbShareFail();
        }
    }
}
