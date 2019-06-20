package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes6.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    public static int ccJ = 3;
    protected boolean iNQ = false;
    protected int iNR = -1;
    protected ShareEntity iNS;
    protected com.baidu.tieba.sharesdk.a.a iNT;
    protected e iNU;
    private ShareReportModel iNV;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.iNS = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            ccJ = intent.getIntExtra("extra_skin", 3);
        } catch (Exception e) {
        }
        if (this.iNS == null) {
            finish();
            return;
        }
        ag(this.iNS.aoQ());
        this.iNR = this.iNS.ciV();
        if (this.iNT != null) {
            this.iNT.onDestroy();
            this.iNT = null;
        }
        if (this.iNU != null) {
            this.iNU.onDestroy();
            this.iNU = null;
        }
        switch (this.iNR) {
            case 0:
                this.iNT = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.iNT = null;
                break;
            case 2:
                this.iNT = new f(this, 2);
                break;
            case 3:
                this.iNT = new f(this, 3);
                break;
            case 4:
                this.iNT = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.iNU = new e(this, this, this);
                this.iNT = this.iNU;
                break;
            case 8:
                this.iNT = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.iNT != null) {
            this.iNT.setTid(this.iNS.getTid());
        }
        if (this.iNS.ciX() && !TextUtils.isEmpty(this.iNS.abS())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.aa(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.iNT != null) {
            this.iNT.t(getUniqueId());
            this.iNT.aa(getIntent());
            this.iNT.a(this.iNS, this);
            return;
        }
        b(this.iNR, 2, this.iNS.aoQ() != null ? this.iNS.aoQ().getString("tid") : null, null);
    }

    private void ag(Bundle bundle) {
        if (bundle != null) {
            if (this.iNV == null) {
                this.iNV = new ShareReportModel(getPageContext());
            }
            this.iNV.r(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.iNQ) {
            finish();
        } else {
            this.iNQ = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            ccJ = intent.getIntExtra("extra_skin", 3);
        }
        if (this.iNT != null) {
            this.iNT.aa(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        } else if (this.iNT != null) {
            this.iNT.aa(intent);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void cm(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.iNS);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.iNS);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.iNS);
            }
        }
        b(i, i2, this.iNS.aoQ() != null ? this.iNS.aoQ().getString("tid") : null, ap.isEmpty(this.iNS.cjN) ? null : this.iNS.cjN);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.iNT != null) {
            this.iNT.onDestroy();
        }
        if (this.iNV != null) {
            this.iNV.cancelMessage();
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
        if (this.iNU != null) {
            this.iNU.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.iNU != null) {
            this.iNU.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.iNU != null) {
            this.iNU.onWbShareFail();
        }
    }
}
