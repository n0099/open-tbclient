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
/* loaded from: classes18.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int aiD = 3;
    protected boolean lTd = false;
    protected int lTe = -1;
    protected ShareEntity lTf;
    protected com.baidu.tieba.sharesdk.a.a lTg;
    protected e lTh;
    private ShareReportModel lTi;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.lTf = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aiD = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.lTf == null) {
            finish();
            return;
        }
        aH(this.lTf.bpx());
        this.lTe = this.lTf.dsE();
        if (this.lTg != null) {
            this.lTg.onDestroy();
            this.lTg = null;
        }
        if (this.lTh != null) {
            this.lTh.onDestroy();
            this.lTh = null;
        }
        switch (this.lTe) {
            case 0:
                this.lTg = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.lTg = null;
                break;
            case 2:
                this.lTg = new f(this, 2);
                break;
            case 3:
                this.lTg = new f(this, 3);
                break;
            case 4:
                this.lTg = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.lTh = new e(this, this, this);
                this.lTg = this.lTh;
                break;
            case 8:
                this.lTg = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.lTg != null) {
            this.lTg.setTid(this.lTf.getTid());
            this.lTg.PZ(this.lTf.dsG());
        }
        if (this.lTf.dsJ() && !TextUtils.isEmpty(this.lTf.bcA())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.lTg != null) {
            this.lTg.z(getUniqueId());
            this.lTg.M(getIntent());
            this.lTg.a(this.lTf, this);
            return;
        }
        if (this.lTf.bpx() != null) {
            this.lTf.bpx().getString("tid");
        }
        a(this.lTe, 2, this.lTf.bpx(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.lTi == null) {
                this.lTi = new ShareReportModel(getPageContext());
            }
            this.lTi.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.lTd) {
            finish();
        } else {
            this.lTd = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aiD = intent.getIntExtra("extra_skin", 3);
        }
        if (this.lTg != null) {
            this.lTg.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.lTg != null) {
            this.lTg.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void df(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.lTf);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.lTf);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.lTf);
            }
        }
        if (this.lTf.bpx() != null) {
            this.lTf.bpx().getString("tid");
            this.lTf.bpx().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.lTf.taskCompleteId)) {
            str = this.lTf.taskCompleteId;
        }
        a(i, i2, this.lTf.bpx(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.lTg != null) {
            this.lTg.onDestroy();
        }
        if (this.lTi != null) {
            this.lTi.cancelMessage();
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
        if (this.lTh != null) {
            this.lTh.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.lTh != null) {
            this.lTh.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.lTh != null) {
            this.lTh.onWbShareFail();
        }
    }
}
