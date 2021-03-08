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
/* loaded from: classes7.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int aln = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected ShareEntity nmB;
    protected com.baidu.tieba.sharesdk.a.a nmC;
    protected e nmD;
    private ShareReportModel nmE;
    protected boolean nmz = false;
    protected int nmA = -1;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.nmB = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            aln = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.nmB == null) {
            finish();
            return;
        }
        aI(this.nmB.bzf());
        this.nmA = this.nmB.dJr();
        if (this.nmC != null) {
            this.nmC.onDestroy();
            this.nmC = null;
        }
        if (this.nmD != null) {
            this.nmD.onDestroy();
            this.nmD = null;
        }
        switch (this.nmA) {
            case 0:
                this.nmC = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.nmC = null;
                break;
            case 2:
                this.nmC = new f(this, 2);
                break;
            case 3:
                this.nmC = new f(this, 3);
                break;
            case 4:
                this.nmC = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.nmD = new e(this, this, this);
                this.nmC = this.nmD;
                break;
            case 8:
                this.nmC = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.nmC != null) {
            this.nmC.setTid(this.nmB.getTid());
            this.nmC.SI(this.nmB.dJt());
        }
        if (this.nmB.dJw() && !TextUtils.isEmpty(this.nmB.getImgUrl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.nmC != null) {
            this.nmC.A(getUniqueId());
            this.nmC.N(getIntent());
            this.nmC.a(this.nmB, this);
            return;
        }
        if (this.nmB.bzf() != null) {
            this.nmB.bzf().getString("tid");
        }
        a(this.nmA, 2, this.nmB.bzf(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.nmE == null) {
                this.nmE = new ShareReportModel(getPageContext());
            }
            this.nmE.u(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.nmz) {
            finish();
        } else {
            this.nmz = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            aln = intent.getIntExtra("extra_skin", 3);
        }
        if (this.nmC != null) {
            this.nmC.N(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.nmC != null) {
            this.nmC.N(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void dm(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.nmB);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.nmB);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.nmB);
            }
        }
        if (this.nmB.bzf() != null) {
            this.nmB.bzf().getString("tid");
            this.nmB.bzf().getString("pid");
        }
        String str = null;
        if (!au.isEmpty(this.nmB.taskCompleteId)) {
            str = this.nmB.taskCompleteId;
        }
        a(i, i2, this.nmB.bzf(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.nmC != null) {
            this.nmC.onDestroy();
        }
        if (this.nmE != null) {
            this.nmE.cancelMessage();
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
        if (this.nmD != null) {
            this.nmD.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.nmD != null) {
            this.nmD.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.nmD != null) {
            this.nmD.onWbShareFail();
        }
    }
}
