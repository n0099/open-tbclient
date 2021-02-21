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
    private ShareReportModel nkA;
    protected boolean nkv = false;
    protected int nkw = -1;
    protected ShareEntity nkx;
    protected com.baidu.tieba.sharesdk.a.a nky;
    protected e nkz;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.nkx = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ajU = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.nkx == null) {
            finish();
            return;
        }
        aI(this.nkx.bzc());
        this.nkw = this.nkx.dJj();
        if (this.nky != null) {
            this.nky.onDestroy();
            this.nky = null;
        }
        if (this.nkz != null) {
            this.nkz.onDestroy();
            this.nkz = null;
        }
        switch (this.nkw) {
            case 0:
                this.nky = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.nky = null;
                break;
            case 2:
                this.nky = new f(this, 2);
                break;
            case 3:
                this.nky = new f(this, 3);
                break;
            case 4:
                this.nky = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.nkz = new e(this, this, this);
                this.nky = this.nkz;
                break;
            case 8:
                this.nky = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.nky != null) {
            this.nky.setTid(this.nkx.getTid());
            this.nky.SC(this.nkx.dJl());
        }
        if (this.nkx.dJo() && !TextUtils.isEmpty(this.nkx.getImgUrl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.nky != null) {
            this.nky.z(getUniqueId());
            this.nky.N(getIntent());
            this.nky.a(this.nkx, this);
            return;
        }
        if (this.nkx.bzc() != null) {
            this.nkx.bzc().getString("tid");
        }
        a(this.nkw, 2, this.nkx.bzc(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.nkA == null) {
                this.nkA = new ShareReportModel(getPageContext());
            }
            this.nkA.u(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.nkv) {
            finish();
        } else {
            this.nkv = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ajU = intent.getIntExtra("extra_skin", 3);
        }
        if (this.nky != null) {
            this.nky.N(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.nky != null) {
            this.nky.N(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dm(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.nkx);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.nkx);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.nkx);
            }
        }
        if (this.nkx.bzc() != null) {
            this.nkx.bzc().getString("tid");
            this.nkx.bzc().getString("pid");
        }
        String str = null;
        if (!au.isEmpty(this.nkx.taskCompleteId)) {
            str = this.nkx.taskCompleteId;
        }
        a(i, i2, this.nkx.bzc(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.nky != null) {
            this.nky.onDestroy();
        }
        if (this.nkA != null) {
            this.nkA.cancelMessage();
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
        if (this.nkz != null) {
            this.nkz.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.nkz != null) {
            this.nkz.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.nkz != null) {
            this.nkz.onWbShareFail();
        }
    }
}
