package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes9.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int MH = 3;
    protected boolean jUD = false;
    protected int jUE = -1;
    protected ShareEntity jUF;
    protected com.baidu.tieba.sharesdk.a.a jUG;
    protected e jUH;
    private ShareReportModel jUI;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jUF = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            MH = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jUF == null) {
            finish();
            return;
        }
        az(this.jUF.aJV());
        this.jUE = this.jUF.cFN();
        if (this.jUG != null) {
            this.jUG.onDestroy();
            this.jUG = null;
        }
        if (this.jUH != null) {
            this.jUH.onDestroy();
            this.jUH = null;
        }
        switch (this.jUE) {
            case 0:
                this.jUG = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jUG = null;
                break;
            case 2:
                this.jUG = new f(this, 2);
                break;
            case 3:
                this.jUG = new f(this, 3);
                break;
            case 4:
                this.jUG = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jUH = new e(this, this, this);
                this.jUG = this.jUH;
                break;
            case 8:
                this.jUG = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jUG != null) {
            this.jUG.setTid(this.jUF.getTid());
        }
        if (this.jUF.cFR() && !TextUtils.isEmpty(this.jUF.ayq())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jUG != null) {
            this.jUG.v(getUniqueId());
            this.jUG.aa(getIntent());
            this.jUG.a(this.jUF, this);
            return;
        }
        b(this.jUE, 2, this.jUF.aJV() != null ? this.jUF.aJV().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jUI == null) {
                this.jUI = new ShareReportModel(getPageContext());
            }
            this.jUI.t(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jUD) {
            finish();
        } else {
            this.jUD = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            MH = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jUG != null) {
            this.jUG.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jUG != null) {
            this.jUG.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cC(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jUF);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jUF);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jUF);
            }
        }
        b(i, i2, this.jUF.aJV() != null ? this.jUF.aJV().getString("tid") : null, aq.isEmpty(this.jUF.taskCompleteId) ? null : this.jUF.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jUG != null) {
            this.jUG.onDestroy();
        }
        if (this.jUI != null) {
            this.jUI.cancelMessage();
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
        if (this.jUH != null) {
            this.jUH.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jUH != null) {
            this.jUH.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jUH != null) {
            this.jUH.onWbShareFail();
        }
    }
}
