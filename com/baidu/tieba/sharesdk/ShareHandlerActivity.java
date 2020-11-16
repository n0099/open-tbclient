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
/* loaded from: classes23.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int ajv = 3;
    protected boolean mLu = false;
    protected int mLv = -1;
    protected ShareEntity mLw;
    protected com.baidu.tieba.sharesdk.a.a mLx;
    protected e mLy;
    private ShareReportModel mLz;
    private PermissionJudgePolicy mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mLw = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ajv = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.mLw == null) {
            finish();
            return;
        }
        aH(this.mLw.bwJ());
        this.mLv = this.mLw.dFF();
        if (this.mLx != null) {
            this.mLx.onDestroy();
            this.mLx = null;
        }
        if (this.mLy != null) {
            this.mLy.onDestroy();
            this.mLy = null;
        }
        switch (this.mLv) {
            case 0:
                this.mLx = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.mLx = null;
                break;
            case 2:
                this.mLx = new f(this, 2);
                break;
            case 3:
                this.mLx = new f(this, 3);
                break;
            case 4:
                this.mLx = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.mLy = new e(this, this, this);
                this.mLx = this.mLy;
                break;
            case 8:
                this.mLx = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.mLx != null) {
            this.mLx.setTid(this.mLw.getTid());
            this.mLx.RE(this.mLw.dFH());
        }
        if (this.mLw.dFK() && !TextUtils.isEmpty(this.mLw.bjy())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.mLx != null) {
            this.mLx.y(getUniqueId());
            this.mLx.M(getIntent());
            this.mLx.a(this.mLw, this);
            return;
        }
        if (this.mLw.bwJ() != null) {
            this.mLw.bwJ().getString("tid");
        }
        a(this.mLv, 2, this.mLw.bwJ(), null);
    }

    private void aH(Bundle bundle) {
        if (bundle != null) {
            if (this.mLz == null) {
                this.mLz = new ShareReportModel(getPageContext());
            }
            this.mLz.s(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.mLu) {
            finish();
        } else {
            this.mLu = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ajv = intent.getIntExtra("extra_skin", 3);
        }
        if (this.mLx != null) {
            this.mLx.M(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.mLx != null) {
            this.mLx.M(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dn(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.mLw);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.mLw);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.mLw);
            }
        }
        if (this.mLw.bwJ() != null) {
            this.mLw.bwJ().getString("tid");
            this.mLw.bwJ().getString("pid");
        }
        String str = null;
        if (!au.isEmpty(this.mLw.taskCompleteId)) {
            str = this.mLw.taskCompleteId;
        }
        a(i, i2, this.mLw.bwJ(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.mLx != null) {
            this.mLx.onDestroy();
        }
        if (this.mLz != null) {
            this.mLz.cancelMessage();
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
        if (this.mLy != null) {
            this.mLy.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.mLy != null) {
            this.mLy.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.mLy != null) {
            this.mLy.onWbShareFail();
        }
    }
}
