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
    public static int cdL = 3;
    protected boolean iUi = false;
    protected int iUj = -1;
    protected ShareEntity iUk;
    protected com.baidu.tieba.sharesdk.a.a iUl;
    protected e iUm;
    private ShareReportModel iUn;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iUk = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            cdL = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iUk == null) {
            finish();
            return;
        }
        ag(this.iUk.apW());
        this.iUj = this.iUk.clM();
        if (this.iUl != null) {
            this.iUl.onDestroy();
            this.iUl = null;
        }
        if (this.iUm != null) {
            this.iUm.onDestroy();
            this.iUm = null;
        }
        switch (this.iUj) {
            case 0:
                this.iUl = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iUl = null;
                break;
            case 2:
                this.iUl = new f(this, 2);
                break;
            case 3:
                this.iUl = new f(this, 3);
                break;
            case 4:
                this.iUl = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iUm = new e(this, this, this);
                this.iUl = this.iUm;
                break;
            case 8:
                this.iUl = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iUl != null) {
            this.iUl.setTid(this.iUk.getTid());
        }
        if (this.iUk.clO() && !TextUtils.isEmpty(this.iUk.acU())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.ajQ();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.ad(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iUl != null) {
            this.iUl.t(getUniqueId());
            this.iUl.aa(getIntent());
            this.iUl.a(this.iUk, this);
            return;
        }
        b(this.iUj, 2, this.iUk.apW() != null ? this.iUk.apW().getString("tid") : null, null);
    }

    private void ag(Bundle bundle) {
        if (bundle != null) {
            if (this.iUn == null) {
                this.iUn = new ShareReportModel(getPageContext());
            }
            this.iUn.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iUi) {
            finish();
        } else {
            this.iUi = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            cdL = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iUl != null) {
            this.iUl.aa(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iUl != null) {
            this.iUl.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cs(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iUk);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iUk);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iUk);
            }
        }
        b(i, i2, this.iUk.apW() != null ? this.iUk.apW().getString("tid") : null, aq.isEmpty(this.iUk.ckS) ? null : this.iUk.ckS);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iUl != null) {
            this.iUl.onDestroy();
        }
        if (this.iUn != null) {
            this.iUn.cancelMessage();
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
        if (this.iUm != null) {
            this.iUm.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iUm != null) {
            this.iUm.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iUm != null) {
            this.iUm.onWbShareFail();
        }
    }
}
