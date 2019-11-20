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
    public static int csg = 3;
    protected boolean iWF = false;
    protected int iWG = -1;
    protected ShareEntity iWH;
    protected com.baidu.tieba.sharesdk.a.a iWI;
    protected e iWJ;
    private ShareReportModel iWK;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iWH = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            csg = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iWH == null) {
            finish();
            return;
        }
        af(this.iWH.asc());
        this.iWG = this.iWH.ckD();
        if (this.iWI != null) {
            this.iWI.onDestroy();
            this.iWI = null;
        }
        if (this.iWJ != null) {
            this.iWJ.onDestroy();
            this.iWJ = null;
        }
        switch (this.iWG) {
            case 0:
                this.iWI = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iWI = null;
                break;
            case 2:
                this.iWI = new f(this, 2);
                break;
            case 3:
                this.iWI = new f(this, 3);
                break;
            case 4:
                this.iWI = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iWJ = new e(this, this, this);
                this.iWI = this.iWJ;
                break;
            case 8:
                this.iWI = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iWI != null) {
            this.iWI.setTid(this.iWH.getTid());
        }
        if (this.iWH.ckF() && !TextUtils.isEmpty(this.iWH.ahd())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iWI != null) {
            this.iWI.u(getUniqueId());
            this.iWI.ai(getIntent());
            this.iWI.a(this.iWH, this);
            return;
        }
        b(this.iWG, 2, this.iWH.asc() != null ? this.iWH.asc().getString("tid") : null, null);
    }

    private void af(Bundle bundle) {
        if (bundle != null) {
            if (this.iWK == null) {
                this.iWK = new ShareReportModel(getPageContext());
            }
            this.iWK.p(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
        if (this.iWF) {
            finish();
        } else {
            this.iWF = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            csg = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iWI != null) {
            this.iWI.ai(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iWI != null) {
            this.iWI.ai(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cj(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iWH);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iWH);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iWH);
            }
        }
        b(i, i2, this.iWH.asc() != null ? this.iWH.asc().getString("tid") : null, aq.isEmpty(this.iWH.cyd) ? null : this.iWH.cyd);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iWI != null) {
            this.iWI.onDestroy();
        }
        if (this.iWK != null) {
            this.iWK.cancelMessage();
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
        if (this.iWJ != null) {
            this.iWJ.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iWJ != null) {
            this.iWJ.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iWJ != null) {
            this.iWJ.onWbShareFail();
        }
    }
}
