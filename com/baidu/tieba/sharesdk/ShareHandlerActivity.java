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
    public static int aiB = 3;
    protected boolean lSO = false;
    protected int lSP = -1;
    protected ShareEntity lSQ;
    protected com.baidu.tieba.sharesdk.a.a lSR;
    protected e lSS;
    private ShareReportModel lST;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.lSQ = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aiB = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.lSQ == null) {
            finish();
            return;
        }
        aH(this.lSQ.bpw());
        this.lSP = this.lSQ.dsz();
        if (this.lSR != null) {
            this.lSR.onDestroy();
            this.lSR = null;
        }
        if (this.lSS != null) {
            this.lSS.onDestroy();
            this.lSS = null;
        }
        switch (this.lSP) {
            case 0:
                this.lSR = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.lSR = null;
                break;
            case 2:
                this.lSR = new f(this, 2);
                break;
            case 3:
                this.lSR = new f(this, 3);
                break;
            case 4:
                this.lSR = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.lSS = new e(this, this, this);
                this.lSR = this.lSS;
                break;
            case 8:
                this.lSR = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.lSR != null) {
            this.lSR.setTid(this.lSQ.getTid());
            this.lSR.PZ(this.lSQ.dsB());
        }
        if (this.lSQ.dsE() && !TextUtils.isEmpty(this.lSQ.bcA())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.lSR != null) {
            this.lSR.z(getUniqueId());
            this.lSR.M(getIntent());
            this.lSR.a(this.lSQ, this);
            return;
        }
        if (this.lSQ.bpw() != null) {
            this.lSQ.bpw().getString("tid");
        }
        a(this.lSP, 2, this.lSQ.bpw(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.lST == null) {
                this.lST = new ShareReportModel(getPageContext());
            }
            this.lST.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.lSO) {
            finish();
        } else {
            this.lSO = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aiB = intent.getIntExtra("extra_skin", 3);
        }
        if (this.lSR != null) {
            this.lSR.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.lSR != null) {
            this.lSR.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void df(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.lSQ);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.lSQ);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.lSQ);
            }
        }
        if (this.lSQ.bpw() != null) {
            this.lSQ.bpw().getString("tid");
            this.lSQ.bpw().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.lSQ.taskCompleteId)) {
            str = this.lSQ.taskCompleteId;
        }
        a(i, i2, this.lSQ.bpw(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.lSR != null) {
            this.lSR.onDestroy();
        }
        if (this.lST != null) {
            this.lST.cancelMessage();
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
        if (this.lSS != null) {
            this.lSS.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.lSS != null) {
            this.lSS.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.lSS != null) {
            this.lSS.onWbShareFail();
        }
    }
}
