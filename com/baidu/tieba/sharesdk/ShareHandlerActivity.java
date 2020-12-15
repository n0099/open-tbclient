package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.au;
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
    public static int aku = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected ShareEntity mZA;
    protected com.baidu.tieba.sharesdk.a.a mZB;
    protected e mZC;
    private ShareReportModel mZD;
    protected boolean mZy = false;
    protected int mZz = -1;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mZA = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aku = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.mZA == null) {
            finish();
            return;
        }
        aI(this.mZA.bAj());
        this.mZz = this.mZA.dKS();
        if (this.mZB != null) {
            this.mZB.onDestroy();
            this.mZB = null;
        }
        if (this.mZC != null) {
            this.mZC.onDestroy();
            this.mZC = null;
        }
        switch (this.mZz) {
            case 0:
                this.mZB = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.mZB = null;
                break;
            case 2:
                this.mZB = new f(this, 2);
                break;
            case 3:
                this.mZB = new f(this, 3);
                break;
            case 4:
                this.mZB = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.mZC = new e(this, this, this);
                this.mZB = this.mZC;
                break;
            case 8:
                this.mZB = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.mZB != null) {
            this.mZB.setTid(this.mZA.getTid());
            this.mZB.SS(this.mZA.dKU());
        }
        if (this.mZA.dKX() && !TextUtils.isEmpty(this.mZA.bmL())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.mZB != null) {
            this.mZB.y(getUniqueId());
            this.mZB.M(getIntent());
            this.mZB.a(this.mZA, this);
            return;
        }
        if (this.mZA.bAj() != null) {
            this.mZA.bAj().getString("tid");
        }
        a(this.mZz, 2, this.mZA.bAj(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.mZD == null) {
                this.mZD = new ShareReportModel(getPageContext());
            }
            this.mZD.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mZy) {
            finish();
        } else {
            this.mZy = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aku = intent.getIntExtra("extra_skin", 3);
        }
        if (this.mZB != null) {
            this.mZB.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.mZB != null) {
            this.mZB.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void ds(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.mZA);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.mZA);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.mZA);
            }
        }
        if (this.mZA.bAj() != null) {
            this.mZA.bAj().getString("tid");
            this.mZA.bAj().getString("pid");
        }
        String str = null;
        if (!au.isEmpty(this.mZA.taskCompleteId)) {
            str = this.mZA.taskCompleteId;
        }
        a(i, i2, this.mZA.bAj(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mZB != null) {
            this.mZB.onDestroy();
        }
        if (this.mZD != null) {
            this.mZD.cancelMessage();
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
        if (this.mZC != null) {
            this.mZC.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.mZC != null) {
            this.mZC.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.mZC != null) {
            this.mZC.onWbShareFail();
        }
    }
}
