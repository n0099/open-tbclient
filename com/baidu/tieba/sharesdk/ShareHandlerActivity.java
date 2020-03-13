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
    public static int Ni = 3;
    protected boolean jVR = false;
    protected int jVS = -1;
    protected ShareEntity jVT;
    protected com.baidu.tieba.sharesdk.a.a jVU;
    protected e jVV;
    private ShareReportModel jVW;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jVT = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            Ni = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jVT == null) {
            finish();
            return;
        }
        az(this.jVT.aMs());
        this.jVS = this.jVT.cHv();
        if (this.jVU != null) {
            this.jVU.onDestroy();
            this.jVU = null;
        }
        if (this.jVV != null) {
            this.jVV.onDestroy();
            this.jVV = null;
        }
        switch (this.jVS) {
            case 0:
                this.jVU = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jVU = null;
                break;
            case 2:
                this.jVU = new f(this, 2);
                break;
            case 3:
                this.jVU = new f(this, 3);
                break;
            case 4:
                this.jVU = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jVV = new e(this, this, this);
                this.jVU = this.jVV;
                break;
            case 8:
                this.jVU = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jVU != null) {
            this.jVU.setTid(this.jVT.getTid());
        }
        if (this.jVT.cHz() && !TextUtils.isEmpty(this.jVT.aAG())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jVU != null) {
            this.jVU.v(getUniqueId());
            this.jVU.aa(getIntent());
            this.jVU.a(this.jVT, this);
            return;
        }
        b(this.jVS, 2, this.jVT.aMs() != null ? this.jVT.aMs().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jVW == null) {
                this.jVW = new ShareReportModel(getPageContext());
            }
            this.jVW.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jVR) {
            finish();
        } else {
            this.jVR = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            Ni = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jVU != null) {
            this.jVU.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jVU != null) {
            this.jVU.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cD(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jVT);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jVT);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jVT);
            }
        }
        b(i, i2, this.jVT.aMs() != null ? this.jVT.aMs().getString("tid") : null, aq.isEmpty(this.jVT.taskCompleteId) ? null : this.jVT.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jVU != null) {
            this.jVU.onDestroy();
        }
        if (this.jVW != null) {
            this.jVW.cancelMessage();
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
        if (this.jVV != null) {
            this.jVV.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jVV != null) {
            this.jVV.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jVV != null) {
            this.jVV.onWbShareFail();
        }
    }
}
