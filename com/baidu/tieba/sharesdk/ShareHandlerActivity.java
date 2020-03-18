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
    public static int Nj = 3;
    protected boolean jXt = false;
    protected int jXu = -1;
    protected ShareEntity jXv;
    protected com.baidu.tieba.sharesdk.a.a jXw;
    protected e jXx;
    private ShareReportModel jXy;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jXv = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            Nj = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jXv == null) {
            finish();
            return;
        }
        az(this.jXv.aMw());
        this.jXu = this.jXv.cHP();
        if (this.jXw != null) {
            this.jXw.onDestroy();
            this.jXw = null;
        }
        if (this.jXx != null) {
            this.jXx.onDestroy();
            this.jXx = null;
        }
        switch (this.jXu) {
            case 0:
                this.jXw = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jXw = null;
                break;
            case 2:
                this.jXw = new f(this, 2);
                break;
            case 3:
                this.jXw = new f(this, 3);
                break;
            case 4:
                this.jXw = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jXx = new e(this, this, this);
                this.jXw = this.jXx;
                break;
            case 8:
                this.jXw = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jXw != null) {
            this.jXw.setTid(this.jXv.getTid());
        }
        if (this.jXv.cHT() && !TextUtils.isEmpty(this.jXv.aAJ())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jXw != null) {
            this.jXw.v(getUniqueId());
            this.jXw.aa(getIntent());
            this.jXw.a(this.jXv, this);
            return;
        }
        b(this.jXu, 2, this.jXv.aMw() != null ? this.jXv.aMw().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jXy == null) {
                this.jXy = new ShareReportModel(getPageContext());
            }
            this.jXy.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jXt) {
            finish();
        } else {
            this.jXt = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            Nj = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jXw != null) {
            this.jXw.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jXw != null) {
            this.jXw.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cE(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jXv);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jXv);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jXv);
            }
        }
        b(i, i2, this.jXv.aMw() != null ? this.jXv.aMw().getString("tid") : null, aq.isEmpty(this.jXv.taskCompleteId) ? null : this.jXv.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jXw != null) {
            this.jXw.onDestroy();
        }
        if (this.jXy != null) {
            this.jXy.cancelMessage();
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
        if (this.jXx != null) {
            this.jXx.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jXx != null) {
            this.jXx.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jXx != null) {
            this.jXx.onWbShareFail();
        }
    }
}
