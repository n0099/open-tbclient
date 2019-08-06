package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
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
    public static int cdS = 3;
    protected boolean iVm = false;
    protected int iVn = -1;
    protected ShareEntity iVo;
    protected com.baidu.tieba.sharesdk.a.a iVp;
    protected e iVq;
    private ShareReportModel iVr;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iVo = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            cdS = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iVo == null) {
            finish();
            return;
        }
        ag(this.iVo.apY());
        this.iVn = this.iVo.cme();
        if (this.iVp != null) {
            this.iVp.onDestroy();
            this.iVp = null;
        }
        if (this.iVq != null) {
            this.iVq.onDestroy();
            this.iVq = null;
        }
        switch (this.iVn) {
            case 0:
                this.iVp = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iVp = null;
                break;
            case 2:
                this.iVp = new f(this, 2);
                break;
            case 3:
                this.iVp = new f(this, 3);
                break;
            case 4:
                this.iVp = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iVq = new e(this, this, this);
                this.iVp = this.iVq;
                break;
            case 8:
                this.iVp = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iVp != null) {
            this.iVp.setTid(this.iVo.getTid());
        }
        if (this.iVo.cmg() && !TextUtils.isEmpty(this.iVo.acV())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.ajS();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.ad(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iVp != null) {
            this.iVp.t(getUniqueId());
            this.iVp.ac(getIntent());
            this.iVp.a(this.iVo, this);
            return;
        }
        b(this.iVn, 2, this.iVo.apY() != null ? this.iVo.apY().getString("tid") : null, null);
    }

    private void ag(Bundle bundle) {
        if (bundle != null) {
            if (this.iVr == null) {
                this.iVr = new ShareReportModel(getPageContext());
            }
            this.iVr.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iVm) {
            finish();
        } else {
            this.iVm = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            cdS = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iVp != null) {
            this.iVp.ac(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iVp != null) {
            this.iVp.ac(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cs(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iVo);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iVo);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iVo);
            }
        }
        b(i, i2, this.iVo.apY() != null ? this.iVo.apY().getString("tid") : null, aq.isEmpty(this.iVo.ckZ) ? null : this.iVo.ckZ);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iVp != null) {
            this.iVp.onDestroy();
        }
        if (this.iVr != null) {
            this.iVr.cancelMessage();
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
        if (this.iVq != null) {
            this.iVq.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iVq != null) {
            this.iVq.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iVq != null) {
            this.iVq.onWbShareFail();
        }
    }
}
