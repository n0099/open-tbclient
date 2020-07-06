package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.ar;
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
    public static int ahx = 3;
    protected boolean ltQ = false;
    protected int ltR = -1;
    protected ShareEntity ltS;
    protected com.baidu.tieba.sharesdk.a.a ltT;
    protected e ltU;
    private ShareReportModel ltV;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.ltS = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ahx = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.ltS == null) {
            finish();
            return;
        }
        aH(this.ltS.bde());
        this.ltR = this.ltS.ddU();
        if (this.ltT != null) {
            this.ltT.onDestroy();
            this.ltT = null;
        }
        if (this.ltU != null) {
            this.ltU.onDestroy();
            this.ltU = null;
        }
        switch (this.ltR) {
            case 0:
                this.ltT = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.ltT = null;
                break;
            case 2:
                this.ltT = new f(this, 2);
                break;
            case 3:
                this.ltT = new f(this, 3);
                break;
            case 4:
                this.ltT = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.ltU = new e(this, this, this);
                this.ltT = this.ltU;
                break;
            case 8:
                this.ltT = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.ltT != null) {
            this.ltT.setTid(this.ltS.getTid());
            this.ltT.Mt(this.ltS.ddW());
        }
        if (this.ltS.ddZ() && !TextUtils.isEmpty(this.ltS.aQl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.ltT != null) {
            this.ltT.y(getUniqueId());
            this.ltT.J(getIntent());
            this.ltT.a(this.ltS, this);
            return;
        }
        b(this.ltR, 2, this.ltS.bde() != null ? this.ltS.bde().getString("tid") : null, null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.ltV == null) {
                this.ltV = new ShareReportModel(getPageContext());
            }
            this.ltV.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.ltQ) {
            finish();
        } else {
            this.ltQ = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ahx = intent.getIntExtra("extra_skin", 3);
        }
        if (this.ltT != null) {
            this.ltT.J(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.ltT != null) {
            this.ltT.J(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cV(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.ltS);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.ltS);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.ltS);
            }
        }
        b(i, i2, this.ltS.bde() != null ? this.ltS.bde().getString("tid") : null, ar.isEmpty(this.ltS.taskCompleteId) ? null : this.ltS.taskCompleteId);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.ltT != null) {
            this.ltT.onDestroy();
        }
        if (this.ltV != null) {
            this.ltV.cancelMessage();
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
        if (this.ltU != null) {
            this.ltU.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.ltU != null) {
            this.ltU.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.ltU != null) {
            this.ltU.onWbShareFail();
        }
    }
}
