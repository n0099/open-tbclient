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
/* loaded from: classes8.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int akW = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected boolean neS = false;
    protected int neT = -1;
    protected ShareEntity neU;
    protected com.baidu.tieba.sharesdk.a.a neV;
    protected e neW;
    private ShareReportModel neX;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.neU = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            akW = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.neU == null) {
            finish();
            return;
        }
        aI(this.neU.bCE());
        this.neT = this.neU.dKI();
        if (this.neV != null) {
            this.neV.onDestroy();
            this.neV = null;
        }
        if (this.neW != null) {
            this.neW.onDestroy();
            this.neW = null;
        }
        switch (this.neT) {
            case 0:
                this.neV = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.neV = null;
                break;
            case 2:
                this.neV = new f(this, 2);
                break;
            case 3:
                this.neV = new f(this, 3);
                break;
            case 4:
                this.neV = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.neW = new e(this, this, this);
                this.neV = this.neW;
                break;
            case 8:
                this.neV = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.neV != null) {
            this.neV.setTid(this.neU.getTid());
            this.neV.SA(this.neU.dKK());
        }
        if (this.neU.dKN() && !TextUtils.isEmpty(this.neU.getImgUrl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.neV != null) {
            this.neV.y(getUniqueId());
            this.neV.N(getIntent());
            this.neV.a(this.neU, this);
            return;
        }
        if (this.neU.bCE() != null) {
            this.neU.bCE().getString("tid");
        }
        a(this.neT, 2, this.neU.bCE(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.neX == null) {
                this.neX = new ShareReportModel(getPageContext());
            }
            this.neX.u(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.neS) {
            finish();
        } else {
            this.neS = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            akW = intent.getIntExtra("extra_skin", 3);
        }
        if (this.neV != null) {
            this.neV.N(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.neV != null) {
            this.neV.N(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    /* renamed from: do  reason: not valid java name */
    public void mo52do(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.neU);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.neU);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.neU);
            }
        }
        if (this.neU.bCE() != null) {
            this.neU.bCE().getString("tid");
            this.neU.bCE().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.neU.taskCompleteId)) {
            str = this.neU.taskCompleteId;
        }
        a(i, i2, this.neU.bCE(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.neV != null) {
            this.neV.onDestroy();
        }
        if (this.neX != null) {
            this.neX.cancelMessage();
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
        if (this.neW != null) {
            this.neW.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.neW != null) {
            this.neW.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.neW != null) {
            this.neW.onWbShareFail();
        }
    }
}
