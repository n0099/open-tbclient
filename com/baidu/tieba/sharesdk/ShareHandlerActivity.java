package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes18.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int aho = 3;
    protected boolean lBj = false;
    protected int lBk = -1;
    protected ShareEntity lBl;
    protected com.baidu.tieba.sharesdk.a.a lBm;
    protected e lBn;
    private ShareReportModel lBo;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.lBl = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aho = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.lBl == null) {
            finish();
            return;
        }
        aI(this.lBl.bgL());
        this.lBk = this.lBl.dhd();
        if (this.lBm != null) {
            this.lBm.onDestroy();
            this.lBm = null;
        }
        if (this.lBn != null) {
            this.lBn.onDestroy();
            this.lBn = null;
        }
        switch (this.lBk) {
            case 0:
                this.lBm = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.lBm = null;
                break;
            case 2:
                this.lBm = new f(this, 2);
                break;
            case 3:
                this.lBm = new f(this, 3);
                break;
            case 4:
                this.lBm = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.lBn = new e(this, this, this);
                this.lBm = this.lBn;
                break;
            case 8:
                this.lBm = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.lBm != null) {
            this.lBm.setTid(this.lBl.getTid());
            this.lBm.Nb(this.lBl.dhf());
        }
        if (this.lBl.dhi() && !TextUtils.isEmpty(this.lBl.aUh())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.lBm != null) {
            this.lBm.z(getUniqueId());
            this.lBm.K(getIntent());
            this.lBm.a(this.lBl, this);
            return;
        }
        b(this.lBk, 2, this.lBl.bgL() != null ? this.lBl.bgL().getString("tid") : null, null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.lBo == null) {
                this.lBo = new ShareReportModel(getPageContext());
            }
            this.lBo.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.lBj) {
            finish();
        } else {
            this.lBj = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aho = intent.getIntExtra("extra_skin", 3);
        }
        if (this.lBm != null) {
            this.lBm.K(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.lBm != null) {
            this.lBm.K(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cX(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.lBl);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.lBl);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.lBl);
            }
        }
        b(i, i2, this.lBl.bgL() != null ? this.lBl.bgL().getString("tid") : null, as.isEmpty(this.lBl.taskCompleteId) ? null : this.lBl.taskCompleteId);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.lBm != null) {
            this.lBm.onDestroy();
        }
        if (this.lBo != null) {
            this.lBo.cancelMessage();
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
        if (this.lBn != null) {
            this.lBn.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.lBn != null) {
            this.lBn.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.lBn != null) {
            this.lBn.onWbShareFail();
        }
    }
}
