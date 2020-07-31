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
    protected boolean lBh = false;
    protected int lBi = -1;
    protected ShareEntity lBj;
    protected com.baidu.tieba.sharesdk.a.a lBk;
    protected e lBl;
    private ShareReportModel lBm;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.lBj = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aho = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.lBj == null) {
            finish();
            return;
        }
        aI(this.lBj.bgL());
        this.lBi = this.lBj.dhd();
        if (this.lBk != null) {
            this.lBk.onDestroy();
            this.lBk = null;
        }
        if (this.lBl != null) {
            this.lBl.onDestroy();
            this.lBl = null;
        }
        switch (this.lBi) {
            case 0:
                this.lBk = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.lBk = null;
                break;
            case 2:
                this.lBk = new f(this, 2);
                break;
            case 3:
                this.lBk = new f(this, 3);
                break;
            case 4:
                this.lBk = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.lBl = new e(this, this, this);
                this.lBk = this.lBl;
                break;
            case 8:
                this.lBk = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.lBk != null) {
            this.lBk.setTid(this.lBj.getTid());
            this.lBk.Nb(this.lBj.dhf());
        }
        if (this.lBj.dhi() && !TextUtils.isEmpty(this.lBj.aUh())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.lBk != null) {
            this.lBk.z(getUniqueId());
            this.lBk.K(getIntent());
            this.lBk.a(this.lBj, this);
            return;
        }
        b(this.lBi, 2, this.lBj.bgL() != null ? this.lBj.bgL().getString("tid") : null, null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.lBm == null) {
                this.lBm = new ShareReportModel(getPageContext());
            }
            this.lBm.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.lBh) {
            finish();
        } else {
            this.lBh = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aho = intent.getIntExtra("extra_skin", 3);
        }
        if (this.lBk != null) {
            this.lBk.K(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.lBk != null) {
            this.lBk.K(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cX(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.lBj);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.lBj);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.lBj);
            }
        }
        b(i, i2, this.lBj.bgL() != null ? this.lBj.bgL().getString("tid") : null, as.isEmpty(this.lBj.taskCompleteId) ? null : this.lBj.taskCompleteId);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.lBk != null) {
            this.lBk.onDestroy();
        }
        if (this.lBm != null) {
            this.lBm.cancelMessage();
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
        if (this.lBl != null) {
            this.lBl.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.lBl != null) {
            this.lBl.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.lBl != null) {
            this.lBl.onWbShareFail();
        }
    }
}
