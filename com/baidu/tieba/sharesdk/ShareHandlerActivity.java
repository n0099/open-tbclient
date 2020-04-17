package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.aq;
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
    public static int afT = 3;
    protected boolean kGD = false;
    protected int kGE = -1;
    protected ShareEntity kGF;
    protected com.baidu.tieba.sharesdk.a.a kGG;
    protected e kGH;
    private ShareReportModel kGI;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.kGF = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            afT = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.kGF == null) {
            finish();
            return;
        }
        az(this.kGF.aUT());
        this.kGE = this.kGF.cSn();
        if (this.kGG != null) {
            this.kGG.onDestroy();
            this.kGG = null;
        }
        if (this.kGH != null) {
            this.kGH.onDestroy();
            this.kGH = null;
        }
        switch (this.kGE) {
            case 0:
                this.kGG = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.kGG = null;
                break;
            case 2:
                this.kGG = new f(this, 2);
                break;
            case 3:
                this.kGG = new f(this, 3);
                break;
            case 4:
                this.kGG = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.kGH = new e(this, this, this);
                this.kGG = this.kGH;
                break;
            case 8:
                this.kGG = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.kGG != null) {
            this.kGG.setTid(this.kGF.getTid());
        }
        if (this.kGF.cSr() && !TextUtils.isEmpty(this.kGF.aIW())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.kGG != null) {
            this.kGG.v(getUniqueId());
            this.kGG.Z(getIntent());
            this.kGG.a(this.kGF, this);
            return;
        }
        b(this.kGE, 2, this.kGF.aUT() != null ? this.kGF.aUT().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.kGI == null) {
                this.kGI = new ShareReportModel(getPageContext());
            }
            this.kGI.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.kGD) {
            finish();
        } else {
            this.kGD = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            afT = intent.getIntExtra("extra_skin", 3);
        }
        if (this.kGG != null) {
            this.kGG.Z(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.kGG != null) {
            this.kGG.Z(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cK(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.kGF);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.kGF);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.kGF);
            }
        }
        b(i, i2, this.kGF.aUT() != null ? this.kGF.aUT().getString("tid") : null, aq.isEmpty(this.kGF.taskCompleteId) ? null : this.kGF.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kGG != null) {
            this.kGG.onDestroy();
        }
        if (this.kGI != null) {
            this.kGI.cancelMessage();
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
        if (this.kGH != null) {
            this.kGH.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.kGH != null) {
            this.kGH.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.kGH != null) {
            this.kGH.onWbShareFail();
        }
    }
}
