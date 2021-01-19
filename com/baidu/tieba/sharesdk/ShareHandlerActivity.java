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
/* loaded from: classes7.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int akf = 3;
    private PermissionJudgePolicy mPermissionJudgement;
    protected boolean nam = false;
    protected int nan = -1;
    protected ShareEntity nao;
    protected com.baidu.tieba.sharesdk.a.a nap;
    protected e naq;
    private ShareReportModel nar;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.nao = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            akf = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.nao == null) {
            finish();
            return;
        }
        aI(this.nao.byK());
        this.nan = this.nao.dGQ();
        if (this.nap != null) {
            this.nap.onDestroy();
            this.nap = null;
        }
        if (this.naq != null) {
            this.naq.onDestroy();
            this.naq = null;
        }
        switch (this.nan) {
            case 0:
                this.nap = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.nap = null;
                break;
            case 2:
                this.nap = new f(this, 2);
                break;
            case 3:
                this.nap = new f(this, 3);
                break;
            case 4:
                this.nap = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.naq = new e(this, this, this);
                this.nap = this.naq;
                break;
            case 8:
                this.nap = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.nap != null) {
            this.nap.setTid(this.nao.getTid());
            this.nap.Rt(this.nao.dGS());
        }
        if (this.nao.dGV() && !TextUtils.isEmpty(this.nao.getImgUrl())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.nap != null) {
            this.nap.y(getUniqueId());
            this.nap.N(getIntent());
            this.nap.a(this.nao, this);
            return;
        }
        if (this.nao.byK() != null) {
            this.nao.byK().getString("tid");
        }
        a(this.nan, 2, this.nao.byK(), null);
    }

    private void aI(Bundle bundle) {
        if (bundle != null) {
            if (this.nar == null) {
                this.nar = new ShareReportModel(getPageContext());
            }
            this.nar.u(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.nam) {
            finish();
        } else {
            this.nam = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            akf = intent.getIntExtra("extra_skin", 3);
        }
        if (this.nap != null) {
            this.nap.N(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.nap != null) {
            this.nap.N(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    /* renamed from: do  reason: not valid java name */
    public void mo47do(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.nao);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.nao);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.nao);
            }
        }
        if (this.nao.byK() != null) {
            this.nao.byK().getString("tid");
            this.nao.byK().getString("pid");
        }
        String str = null;
        if (!at.isEmpty(this.nao.taskCompleteId)) {
            str = this.nao.taskCompleteId;
        }
        a(i, i2, this.nao.byK(), str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.nap != null) {
            this.nap.onDestroy();
        }
        if (this.nar != null) {
            this.nar.cancelMessage();
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
        if (this.naq != null) {
            this.naq.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.naq != null) {
            this.naq.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.naq != null) {
            this.naq.onWbShareFail();
        }
    }
}
