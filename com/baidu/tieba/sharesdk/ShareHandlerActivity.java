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
    public static int ajp = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected boolean mse = false;
    protected int msf = -1;
    protected ShareEntity msh;
    protected com.baidu.tieba.sharesdk.a.a msi;
    protected e msj;
    private ShareReportModel msk;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.msh = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ajp = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.msh == null) {
            finish();
            return;
        }
        aH(this.msh.btb());
        this.msf = this.msh.dAh();
        if (this.msi != null) {
            this.msi.onDestroy();
            this.msi = null;
        }
        if (this.msj != null) {
            this.msj.onDestroy();
            this.msj = null;
        }
        switch (this.msf) {
            case 0:
                this.msi = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.msi = null;
                break;
            case 2:
                this.msi = new f(this, 2);
                break;
            case 3:
                this.msi = new f(this, 3);
                break;
            case 4:
                this.msi = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.msj = new e(this, this, this);
                this.msi = this.msj;
                break;
            case 8:
                this.msi = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.msi != null) {
            this.msi.setTid(this.msh.getTid());
            this.msi.Rn(this.msh.dAj());
        }
        if (this.msh.dAm() && !TextUtils.isEmpty(this.msh.bgd())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.msi != null) {
            this.msi.y(getUniqueId());
            this.msi.M(getIntent());
            this.msi.a(this.msh, this);
            return;
        }
        if (this.msh.btb() != null) {
            this.msh.btb().getString("tid");
        }
        a(this.msf, 2, this.msh.btb(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.msk == null) {
                this.msk = new ShareReportModel(getPageContext());
            }
            this.msk.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mse) {
            finish();
        } else {
            this.mse = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ajp = intent.getIntExtra("extra_skin", 3);
        }
        if (this.msi != null) {
            this.msi.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.msi != null) {
            this.msi.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dj(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.msh);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.msh);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.msh);
            }
        }
        if (this.msh.btb() != null) {
            this.msh.btb().getString("tid");
            this.msh.btb().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.msh.taskCompleteId)) {
            str = this.msh.taskCompleteId;
        }
        a(i, i2, this.msh.btb(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.msi != null) {
            this.msi.onDestroy();
        }
        if (this.msk != null) {
            this.msk.cancelMessage();
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
        if (this.msj != null) {
            this.msj.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.msj != null) {
            this.msj.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.msj != null) {
            this.msj.onWbShareFail();
        }
    }
}
