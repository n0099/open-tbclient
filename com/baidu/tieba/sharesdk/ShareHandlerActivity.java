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
/* loaded from: classes24.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int ajq = 3;
    protected boolean mKL = false;
    protected int mKM = -1;
    protected ShareEntity mKN;
    protected com.baidu.tieba.sharesdk.a.a mKO;
    protected e mKP;
    private ShareReportModel mKQ;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mKN = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ajq = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.mKN == null) {
            finish();
            return;
        }
        aH(this.mKN.bxt());
        this.mKM = this.mKN.dFR();
        if (this.mKO != null) {
            this.mKO.onDestroy();
            this.mKO = null;
        }
        if (this.mKP != null) {
            this.mKP.onDestroy();
            this.mKP = null;
        }
        switch (this.mKM) {
            case 0:
                this.mKO = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.mKO = null;
                break;
            case 2:
                this.mKO = new f(this, 2);
                break;
            case 3:
                this.mKO = new f(this, 3);
                break;
            case 4:
                this.mKO = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.mKP = new e(this, this, this);
                this.mKO = this.mKP;
                break;
            case 8:
                this.mKO = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.mKO != null) {
            this.mKO.setTid(this.mKN.getTid());
            this.mKO.Sd(this.mKN.dFT());
        }
        if (this.mKN.dFW() && !TextUtils.isEmpty(this.mKN.bkw())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.mKO != null) {
            this.mKO.y(getUniqueId());
            this.mKO.M(getIntent());
            this.mKO.a(this.mKN, this);
            return;
        }
        if (this.mKN.bxt() != null) {
            this.mKN.bxt().getString("tid");
        }
        a(this.mKM, 2, this.mKN.bxt(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.mKQ == null) {
                this.mKQ = new ShareReportModel(getPageContext());
            }
            this.mKQ.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mKL) {
            finish();
        } else {
            this.mKL = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ajq = intent.getIntExtra("extra_skin", 3);
        }
        if (this.mKO != null) {
            this.mKO.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.mKO != null) {
            this.mKO.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dn(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.mKN);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.mKN);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.mKN);
            }
        }
        if (this.mKN.bxt() != null) {
            this.mKN.bxt().getString("tid");
            this.mKN.bxt().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.mKN.taskCompleteId)) {
            str = this.mKN.taskCompleteId;
        }
        a(i, i2, this.mKN.bxt(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mKO != null) {
            this.mKO.onDestroy();
        }
        if (this.mKQ != null) {
            this.mKQ.cancelMessage();
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
        if (this.mKP != null) {
            this.mKP.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.mKP != null) {
            this.mKP.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.mKP != null) {
            this.mKP.onWbShareFail();
        }
    }
}
