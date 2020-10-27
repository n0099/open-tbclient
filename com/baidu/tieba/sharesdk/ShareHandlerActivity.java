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
    protected boolean mEJ = false;
    protected int mEK = -1;
    protected ShareEntity mEL;
    protected com.baidu.tieba.sharesdk.a.a mEM;
    protected e mEN;
    private ShareReportModel mEO;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mEL = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ajq = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.mEL == null) {
            finish();
            return;
        }
        aH(this.mEL.buU());
        this.mEK = this.mEL.dDp();
        if (this.mEM != null) {
            this.mEM.onDestroy();
            this.mEM = null;
        }
        if (this.mEN != null) {
            this.mEN.onDestroy();
            this.mEN = null;
        }
        switch (this.mEK) {
            case 0:
                this.mEM = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.mEM = null;
                break;
            case 2:
                this.mEM = new f(this, 2);
                break;
            case 3:
                this.mEM = new f(this, 3);
                break;
            case 4:
                this.mEM = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.mEN = new e(this, this, this);
                this.mEM = this.mEN;
                break;
            case 8:
                this.mEM = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.mEM != null) {
            this.mEM.setTid(this.mEL.getTid());
            this.mEM.RM(this.mEL.dDr());
        }
        if (this.mEL.dDu() && !TextUtils.isEmpty(this.mEL.bhW())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.mEM != null) {
            this.mEM.y(getUniqueId());
            this.mEM.M(getIntent());
            this.mEM.a(this.mEL, this);
            return;
        }
        if (this.mEL.buU() != null) {
            this.mEL.buU().getString("tid");
        }
        a(this.mEK, 2, this.mEL.buU(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.mEO == null) {
                this.mEO = new ShareReportModel(getPageContext());
            }
            this.mEO.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mEJ) {
            finish();
        } else {
            this.mEJ = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ajq = intent.getIntExtra("extra_skin", 3);
        }
        if (this.mEM != null) {
            this.mEM.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.mEM != null) {
            this.mEM.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dl(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.mEL);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.mEL);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.mEL);
            }
        }
        if (this.mEL.buU() != null) {
            this.mEL.buU().getString("tid");
            this.mEL.buU().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.mEL.taskCompleteId)) {
            str = this.mEL.taskCompleteId;
        }
        a(i, i2, this.mEL.buU(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mEM != null) {
            this.mEM.onDestroy();
        }
        if (this.mEO != null) {
            this.mEO.cancelMessage();
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
        if (this.mEN != null) {
            this.mEN.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.mEN != null) {
            this.mEN.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.mEN != null) {
            this.mEN.onWbShareFail();
        }
    }
}
