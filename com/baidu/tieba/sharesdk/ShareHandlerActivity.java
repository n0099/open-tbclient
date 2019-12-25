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
/* loaded from: classes8.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int MA = 3;
    protected boolean jRa = false;
    protected int jRb = -1;
    protected ShareEntity jRc;
    protected com.baidu.tieba.sharesdk.a.a jRd;
    protected e jRe;
    private ShareReportModel jRf;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jRc = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            MA = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jRc == null) {
            finish();
            return;
        }
        az(this.jRc.aJB());
        this.jRb = this.jRc.cEJ();
        if (this.jRd != null) {
            this.jRd.onDestroy();
            this.jRd = null;
        }
        if (this.jRe != null) {
            this.jRe.onDestroy();
            this.jRe = null;
        }
        switch (this.jRb) {
            case 0:
                this.jRd = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jRd = null;
                break;
            case 2:
                this.jRd = new f(this, 2);
                break;
            case 3:
                this.jRd = new f(this, 3);
                break;
            case 4:
                this.jRd = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jRe = new e(this, this, this);
                this.jRd = this.jRe;
                break;
            case 8:
                this.jRd = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jRd != null) {
            this.jRd.setTid(this.jRc.getTid());
        }
        if (this.jRc.cEN() && !TextUtils.isEmpty(this.jRc.axX())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jRd != null) {
            this.jRd.v(getUniqueId());
            this.jRd.aa(getIntent());
            this.jRd.a(this.jRc, this);
            return;
        }
        b(this.jRb, 2, this.jRc.aJB() != null ? this.jRc.aJB().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jRf == null) {
                this.jRf = new ShareReportModel(getPageContext());
            }
            this.jRf.t(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jRa) {
            finish();
        } else {
            this.jRa = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            MA = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jRd != null) {
            this.jRd.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jRd != null) {
            this.jRd.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cD(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jRc);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jRc);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jRc);
            }
        }
        b(i, i2, this.jRc.aJB() != null ? this.jRc.aJB().getString("tid") : null, aq.isEmpty(this.jRc.taskCompleteId) ? null : this.jRc.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jRd != null) {
            this.jRd.onDestroy();
        }
        if (this.jRf != null) {
            this.jRf.cancelMessage();
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
        if (this.jRe != null) {
            this.jRe.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jRe != null) {
            this.jRe.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jRe != null) {
            this.jRe.onWbShareFail();
        }
    }
}
