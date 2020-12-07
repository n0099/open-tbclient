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
    protected e mZA;
    private ShareReportModel mZB;
    protected boolean mZw = false;
    protected int mZx = -1;
    protected ShareEntity mZy;
    protected com.baidu.tieba.sharesdk.a.a mZz;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mZy = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aku = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.mZy == null) {
            finish();
            return;
        }
        aI(this.mZy.bAj());
        this.mZx = this.mZy.dKR();
        if (this.mZz != null) {
            this.mZz.onDestroy();
            this.mZz = null;
        }
        if (this.mZA != null) {
            this.mZA.onDestroy();
            this.mZA = null;
        }
        switch (this.mZx) {
            case 0:
                this.mZz = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.mZz = null;
                break;
            case 2:
                this.mZz = new f(this, 2);
                break;
            case 3:
                this.mZz = new f(this, 3);
                break;
            case 4:
                this.mZz = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.mZA = new e(this, this, this);
                this.mZz = this.mZA;
                break;
            case 8:
                this.mZz = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.mZz != null) {
            this.mZz.setTid(this.mZy.getTid());
            this.mZz.SS(this.mZy.dKT());
        }
        if (this.mZy.dKW() && !TextUtils.isEmpty(this.mZy.bmL())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.mZz != null) {
            this.mZz.y(getUniqueId());
            this.mZz.M(getIntent());
            this.mZz.a(this.mZy, this);
            return;
        }
        if (this.mZy.bAj() != null) {
            this.mZy.bAj().getString("tid");
        }
        a(this.mZx, 2, this.mZy.bAj(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.mZB == null) {
                this.mZB = new ShareReportModel(getPageContext());
            }
            this.mZB.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mZw) {
            finish();
        } else {
            this.mZw = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aku = intent.getIntExtra("extra_skin", 3);
        }
        if (this.mZz != null) {
            this.mZz.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.mZz != null) {
            this.mZz.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void ds(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.mZy);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.mZy);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.mZy);
            }
        }
        if (this.mZy.bAj() != null) {
            this.mZy.bAj().getString("tid");
            this.mZy.bAj().getString("pid");
        }
        String str = null;
        if (!au.isEmpty(this.mZy.taskCompleteId)) {
            str = this.mZy.taskCompleteId;
        }
        a(i, i2, this.mZy.bAj(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mZz != null) {
            this.mZz.onDestroy();
        }
        if (this.mZB != null) {
            this.mZB.cancelMessage();
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
        if (this.mZA != null) {
            this.mZA.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.mZA != null) {
            this.mZA.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.mZA != null) {
            this.mZA.onWbShareFail();
        }
    }
}
