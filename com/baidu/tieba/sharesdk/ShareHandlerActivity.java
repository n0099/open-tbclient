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
/* loaded from: classes6.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int csX = 3;
    protected e iXA;
    private ShareReportModel iXB;
    protected boolean iXw = false;
    protected int iXx = -1;
    protected ShareEntity iXy;
    protected com.baidu.tieba.sharesdk.a.a iXz;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iXy = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            csX = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iXy == null) {
            finish();
            return;
        }
        af(this.iXy.ase());
        this.iXx = this.iXy.ckF();
        if (this.iXz != null) {
            this.iXz.onDestroy();
            this.iXz = null;
        }
        if (this.iXA != null) {
            this.iXA.onDestroy();
            this.iXA = null;
        }
        switch (this.iXx) {
            case 0:
                this.iXz = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iXz = null;
                break;
            case 2:
                this.iXz = new f(this, 2);
                break;
            case 3:
                this.iXz = new f(this, 3);
                break;
            case 4:
                this.iXz = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iXA = new e(this, this, this);
                this.iXz = this.iXA;
                break;
            case 8:
                this.iXz = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iXz != null) {
            this.iXz.setTid(this.iXy.getTid());
        }
        if (this.iXy.ckH() && !TextUtils.isEmpty(this.iXy.ahf())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iXz != null) {
            this.iXz.u(getUniqueId());
            this.iXz.ai(getIntent());
            this.iXz.a(this.iXy, this);
            return;
        }
        b(this.iXx, 2, this.iXy.ase() != null ? this.iXy.ase().getString("tid") : null, null);
    }

    private void af(Bundle bundle) {
        if (bundle != null) {
            if (this.iXB == null) {
                this.iXB = new ShareReportModel(getPageContext());
            }
            this.iXB.p(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.iXw) {
            finish();
        } else {
            this.iXw = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            csX = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iXz != null) {
            this.iXz.ai(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iXz != null) {
            this.iXz.ai(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cl(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iXy);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iXy);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iXy);
            }
        }
        b(i, i2, this.iXy.ase() != null ? this.iXy.ase().getString("tid") : null, aq.isEmpty(this.iXy.cyU) ? null : this.iXy.cyU);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iXz != null) {
            this.iXz.onDestroy();
        }
        if (this.iXB != null) {
            this.iXB.cancelMessage();
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
        if (this.iXA != null) {
            this.iXA.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iXA != null) {
            this.iXA.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iXA != null) {
            this.iXA.onWbShareFail();
        }
    }
}
