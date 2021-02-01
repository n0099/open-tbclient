package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.au;
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
    public static int ajU = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected boolean njV = false;
    protected int njW = -1;
    protected ShareEntity njX;
    protected com.baidu.tieba.sharesdk.a.a njY;
    protected e njZ;
    private ShareReportModel nka;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.njX = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ajU = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.njX == null) {
            finish();
            return;
        }
        aI(this.njX.bzc());
        this.njW = this.njX.dJb();
        if (this.njY != null) {
            this.njY.onDestroy();
            this.njY = null;
        }
        if (this.njZ != null) {
            this.njZ.onDestroy();
            this.njZ = null;
        }
        switch (this.njW) {
            case 0:
                this.njY = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.njY = null;
                break;
            case 2:
                this.njY = new f(this, 2);
                break;
            case 3:
                this.njY = new f(this, 3);
                break;
            case 4:
                this.njY = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.njZ = new e(this, this, this);
                this.njY = this.njZ;
                break;
            case 8:
                this.njY = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.njY != null) {
            this.njY.setTid(this.njX.getTid());
            this.njY.Sq(this.njX.dJd());
        }
        if (this.njX.dJg() && !TextUtils.isEmpty(this.njX.getImgUrl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.njY != null) {
            this.njY.z(getUniqueId());
            this.njY.N(getIntent());
            this.njY.a(this.njX, this);
            return;
        }
        if (this.njX.bzc() != null) {
            this.njX.bzc().getString("tid");
        }
        a(this.njW, 2, this.njX.bzc(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.nka == null) {
                this.nka = new ShareReportModel(getPageContext());
            }
            this.nka.u(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.njV) {
            finish();
        } else {
            this.njV = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ajU = intent.getIntExtra("extra_skin", 3);
        }
        if (this.njY != null) {
            this.njY.N(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.njY != null) {
            this.njY.N(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dl(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.njX);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.njX);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.njX);
            }
        }
        if (this.njX.bzc() != null) {
            this.njX.bzc().getString("tid");
            this.njX.bzc().getString("pid");
        }
        String str = null;
        if (!au.isEmpty(this.njX.taskCompleteId)) {
            str = this.njX.taskCompleteId;
        }
        a(i, i2, this.njX.bzc(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.njY != null) {
            this.njY.onDestroy();
        }
        if (this.nka != null) {
            this.nka.cancelMessage();
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
        if (this.njZ != null) {
            this.njZ.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.njZ != null) {
            this.njZ.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.njZ != null) {
            this.njZ.onWbShareFail();
        }
    }
}
