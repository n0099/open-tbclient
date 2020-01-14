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
    protected boolean jUI = false;
    protected int jUJ = -1;
    protected ShareEntity jUK;
    protected com.baidu.tieba.sharesdk.a.a jUL;
    protected e jUM;
    private ShareReportModel jUN;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jUK = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            MH = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jUK == null) {
            finish();
            return;
        }
        az(this.jUK.aJV());
        this.jUJ = this.jUK.cFP();
        if (this.jUL != null) {
            this.jUL.onDestroy();
            this.jUL = null;
        }
        if (this.jUM != null) {
            this.jUM.onDestroy();
            this.jUM = null;
        }
        switch (this.jUJ) {
            case 0:
                this.jUL = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jUL = null;
                break;
            case 2:
                this.jUL = new f(this, 2);
                break;
            case 3:
                this.jUL = new f(this, 3);
                break;
            case 4:
                this.jUL = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jUM = new e(this, this, this);
                this.jUL = this.jUM;
                break;
            case 8:
                this.jUL = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jUL != null) {
            this.jUL.setTid(this.jUK.getTid());
        }
        if (this.jUK.cFT() && !TextUtils.isEmpty(this.jUK.ayq())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jUL != null) {
            this.jUL.v(getUniqueId());
            this.jUL.aa(getIntent());
            this.jUL.a(this.jUK, this);
            return;
        }
        b(this.jUJ, 2, this.jUK.aJV() != null ? this.jUK.aJV().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jUN == null) {
                this.jUN = new ShareReportModel(getPageContext());
            }
            this.jUN.t(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jUI) {
            finish();
        } else {
            this.jUI = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            MH = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jUL != null) {
            this.jUL.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jUL != null) {
            this.jUL.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cC(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jUK);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jUK);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jUK);
            }
        }
        b(i, i2, this.jUK.aJV() != null ? this.jUK.aJV().getString("tid") : null, aq.isEmpty(this.jUK.taskCompleteId) ? null : this.jUK.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jUL != null) {
            this.jUL.onDestroy();
        }
        if (this.jUN != null) {
            this.jUN.cancelMessage();
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
        if (this.jUM != null) {
            this.jUM.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jUM != null) {
            this.jUM.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jUM != null) {
            this.jUM.onWbShareFail();
        }
    }
}
