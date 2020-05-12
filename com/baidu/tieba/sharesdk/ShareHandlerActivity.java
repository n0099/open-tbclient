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
    public static int afW = 3;
    protected boolean kGH = false;
    protected int kGI = -1;
    protected ShareEntity kGJ;
    protected com.baidu.tieba.sharesdk.a.a kGK;
    protected e kGL;
    private ShareReportModel kGM;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.kGJ = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            afW = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.kGJ == null) {
            finish();
            return;
        }
        az(this.kGJ.aUR());
        this.kGI = this.kGJ.cSl();
        if (this.kGK != null) {
            this.kGK.onDestroy();
            this.kGK = null;
        }
        if (this.kGL != null) {
            this.kGL.onDestroy();
            this.kGL = null;
        }
        switch (this.kGI) {
            case 0:
                this.kGK = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.kGK = null;
                break;
            case 2:
                this.kGK = new f(this, 2);
                break;
            case 3:
                this.kGK = new f(this, 3);
                break;
            case 4:
                this.kGK = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.kGL = new e(this, this, this);
                this.kGK = this.kGL;
                break;
            case 8:
                this.kGK = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.kGK != null) {
            this.kGK.setTid(this.kGJ.getTid());
        }
        if (this.kGJ.cSp() && !TextUtils.isEmpty(this.kGJ.aIU())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.kGK != null) {
            this.kGK.v(getUniqueId());
            this.kGK.M(getIntent());
            this.kGK.a(this.kGJ, this);
            return;
        }
        b(this.kGI, 2, this.kGJ.aUR() != null ? this.kGJ.aUR().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.kGM == null) {
                this.kGM = new ShareReportModel(getPageContext());
            }
            this.kGM.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.kGH) {
            finish();
        } else {
            this.kGH = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            afW = intent.getIntExtra("extra_skin", 3);
        }
        if (this.kGK != null) {
            this.kGK.M(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.kGK != null) {
            this.kGK.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cK(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.kGJ);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.kGJ);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.kGJ);
            }
        }
        b(i, i2, this.kGJ.aUR() != null ? this.kGJ.aUR().getString("tid") : null, aq.isEmpty(this.kGJ.taskCompleteId) ? null : this.kGJ.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.kGK != null) {
            this.kGK.onDestroy();
        }
        if (this.kGM != null) {
            this.kGM.cancelMessage();
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
        if (this.kGL != null) {
            this.kGL.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.kGL != null) {
            this.kGL.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.kGL != null) {
            this.kGL.onWbShareFail();
        }
    }
}
