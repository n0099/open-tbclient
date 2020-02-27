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
/* loaded from: classes11.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int Ni = 3;
    protected boolean jVD = false;
    protected int jVE = -1;
    protected ShareEntity jVF;
    protected com.baidu.tieba.sharesdk.a.a jVG;
    protected e jVH;
    private ShareReportModel jVI;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jVF = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            Ni = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jVF == null) {
            finish();
            return;
        }
        az(this.jVF.aMp());
        this.jVE = this.jVF.cHs();
        if (this.jVG != null) {
            this.jVG.onDestroy();
            this.jVG = null;
        }
        if (this.jVH != null) {
            this.jVH.onDestroy();
            this.jVH = null;
        }
        switch (this.jVE) {
            case 0:
                this.jVG = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jVG = null;
                break;
            case 2:
                this.jVG = new f(this, 2);
                break;
            case 3:
                this.jVG = new f(this, 3);
                break;
            case 4:
                this.jVG = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jVH = new e(this, this, this);
                this.jVG = this.jVH;
                break;
            case 8:
                this.jVG = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jVG != null) {
            this.jVG.setTid(this.jVF.getTid());
        }
        if (this.jVF.cHw() && !TextUtils.isEmpty(this.jVF.aAE())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jVG != null) {
            this.jVG.v(getUniqueId());
            this.jVG.aa(getIntent());
            this.jVG.a(this.jVF, this);
            return;
        }
        b(this.jVE, 2, this.jVF.aMp() != null ? this.jVF.aMp().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jVI == null) {
                this.jVI = new ShareReportModel(getPageContext());
            }
            this.jVI.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jVD) {
            finish();
        } else {
            this.jVD = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            Ni = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jVG != null) {
            this.jVG.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jVG != null) {
            this.jVG.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cD(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jVF);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jVF);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jVF);
            }
        }
        b(i, i2, this.jVF.aMp() != null ? this.jVF.aMp().getString("tid") : null, aq.isEmpty(this.jVF.taskCompleteId) ? null : this.jVF.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jVG != null) {
            this.jVG.onDestroy();
        }
        if (this.jVI != null) {
            this.jVI.cancelMessage();
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
        if (this.jVH != null) {
            this.jVH.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jVH != null) {
            this.jVH.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jVH != null) {
            this.jVH.onWbShareFail();
        }
    }
}
