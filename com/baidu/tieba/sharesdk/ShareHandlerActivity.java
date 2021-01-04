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
    protected boolean neT = false;
    protected int neU = -1;
    protected ShareEntity neV;
    protected com.baidu.tieba.sharesdk.a.a neW;
    protected e neX;
    private ShareReportModel neY;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.neV = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            akW = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.neV == null) {
            finish();
            return;
        }
        aI(this.neV.bCD());
        this.neU = this.neV.dKH();
        if (this.neW != null) {
            this.neW.onDestroy();
            this.neW = null;
        }
        if (this.neX != null) {
            this.neX.onDestroy();
            this.neX = null;
        }
        switch (this.neU) {
            case 0:
                this.neW = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.neW = null;
                break;
            case 2:
                this.neW = new f(this, 2);
                break;
            case 3:
                this.neW = new f(this, 3);
                break;
            case 4:
                this.neW = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.neX = new e(this, this, this);
                this.neW = this.neX;
                break;
            case 8:
                this.neW = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.neW != null) {
            this.neW.setTid(this.neV.getTid());
            this.neW.SB(this.neV.dKJ());
        }
        if (this.neV.dKM() && !TextUtils.isEmpty(this.neV.getImgUrl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.neW != null) {
            this.neW.y(getUniqueId());
            this.neW.N(getIntent());
            this.neW.a(this.neV, this);
            return;
        }
        if (this.neV.bCD() != null) {
            this.neV.bCD().getString("tid");
        }
        a(this.neU, 2, this.neV.bCD(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.neY == null) {
                this.neY = new ShareReportModel(getPageContext());
            }
            this.neY.u(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.neT) {
            finish();
        } else {
            this.neT = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            akW = intent.getIntExtra("extra_skin", 3);
        }
        if (this.neW != null) {
            this.neW.N(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.neW != null) {
            this.neW.N(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    /* renamed from: do  reason: not valid java name */
    public void mo41do(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.neV);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.neV);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.neV);
            }
        }
        if (this.neV.bCD() != null) {
            this.neV.bCD().getString("tid");
            this.neV.bCD().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.neV.taskCompleteId)) {
            str = this.neV.taskCompleteId;
        }
        a(i, i2, this.neV.bCD(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.neW != null) {
            this.neW.onDestroy();
        }
        if (this.neY != null) {
            this.neY.cancelMessage();
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
        if (this.neX != null) {
            this.neX.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.neX != null) {
            this.neX.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.neX != null) {
            this.neX.onWbShareFail();
        }
    }
}
