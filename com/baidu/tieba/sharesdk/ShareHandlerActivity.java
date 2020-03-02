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
    protected boolean jVF = false;
    protected int jVG = -1;
    protected ShareEntity jVH;
    protected com.baidu.tieba.sharesdk.a.a jVI;
    protected e jVJ;
    private ShareReportModel jVK;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.jVH = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            Ni = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.jVH == null) {
            finish();
            return;
        }
        az(this.jVH.aMr());
        this.jVG = this.jVH.cHu();
        if (this.jVI != null) {
            this.jVI.onDestroy();
            this.jVI = null;
        }
        if (this.jVJ != null) {
            this.jVJ.onDestroy();
            this.jVJ = null;
        }
        switch (this.jVG) {
            case 0:
                this.jVI = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.jVI = null;
                break;
            case 2:
                this.jVI = new f(this, 2);
                break;
            case 3:
                this.jVI = new f(this, 3);
                break;
            case 4:
                this.jVI = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.jVJ = new e(this, this, this);
                this.jVI = this.jVJ;
                break;
            case 8:
                this.jVI = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.jVI != null) {
            this.jVI.setTid(this.jVH.getTid());
        }
        if (this.jVH.cHy() && !TextUtils.isEmpty(this.jVH.aAG())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.jVI != null) {
            this.jVI.v(getUniqueId());
            this.jVI.aa(getIntent());
            this.jVI.a(this.jVH, this);
            return;
        }
        b(this.jVG, 2, this.jVH.aMr() != null ? this.jVH.aMr().getString("tid") : null, null);
    }

    private void az(Bundle bundle) {
        if (bundle != null) {
            if (this.jVK == null) {
                this.jVK = new ShareReportModel(getPageContext());
            }
            this.jVK.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.jVF) {
            finish();
        } else {
            this.jVF = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            Ni = intent.getIntExtra("extra_skin", 3);
        }
        if (this.jVI != null) {
            this.jVI.aa(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.jVI != null) {
            this.jVI.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cD(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.jVH);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.jVH);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.jVH);
            }
        }
        b(i, i2, this.jVH.aMr() != null ? this.jVH.aMr().getString("tid") : null, aq.isEmpty(this.jVH.taskCompleteId) ? null : this.jVH.taskCompleteId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.jVI != null) {
            this.jVI.onDestroy();
        }
        if (this.jVK != null) {
            this.jVK.cancelMessage();
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
        if (this.jVJ != null) {
            this.jVJ.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.jVJ != null) {
            this.jVJ.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.jVJ != null) {
            this.jVJ.onWbShareFail();
        }
    }
}
