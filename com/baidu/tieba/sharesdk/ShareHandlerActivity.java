package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes3.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, WbShareCallback {
    private com.baidu.tbadk.core.util.b.a bzf;
    protected boolean gZq = false;
    protected int gZr = -1;
    protected ShareEntity gZs;
    protected com.baidu.tieba.sharesdk.a.a gZt;
    protected e gZu;
    private ShareReportModel gZv;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gZs = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gZs == null) {
            finish();
            return;
        }
        L(this.gZs.Kg());
        this.gZr = this.gZs.byC();
        if (this.gZt != null) {
            this.gZt.onDestroy();
            this.gZt = null;
        }
        if (this.gZu != null) {
            this.gZu.onDestroy();
            this.gZu = null;
        }
        switch (this.gZr) {
            case 0:
                this.gZt = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gZt = null;
                break;
            case 2:
                this.gZt = new f(this, 2);
                break;
            case 3:
                this.gZt = new f(this, 3);
                break;
            case 4:
                this.gZt = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gZu = new e(this, this, this);
                this.gZt = this.gZu;
                break;
            case 8:
                this.gZt = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gZs.byE() && !TextUtils.isEmpty(this.gZs.ys())) {
            if (this.bzf == null) {
                this.bzf = new com.baidu.tbadk.core.util.b.a();
            }
            this.bzf.Et();
            this.bzf.c(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.bzf.A(getPageContext().getPageActivity())) {
                return;
            }
        }
        if (this.gZt != null) {
            this.gZt.q(getUniqueId());
            this.gZt.H(getIntent());
            this.gZt.a(this.gZs, this);
            return;
        }
        a(this.gZr, 2, this.gZs.Kg() != null ? this.gZs.Kg().getString("tid") : null, null);
    }

    private void L(Bundle bundle) {
        if (bundle != null) {
            if (this.gZv == null) {
                this.gZv = new ShareReportModel(getPageContext());
            }
            this.gZv.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gZq) {
            finish();
        } else {
            this.gZq = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gZt != null) {
            this.gZt.H(intent);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10103 || i == 10104) {
            Tencent.onActivityResultData(i, i2, intent, null);
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.b
    public void bI(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gZs);
        }
        if (i2 == 3) {
            if (i == 8 || i == 6) {
                com.baidu.tieba.sharesdk.c.b.a(i, this.gZs);
            } else {
                com.baidu.tieba.sharesdk.c.b.b(i, this.gZs);
            }
        }
        a(i, i2, this.gZs.Kg() != null ? this.gZs.Kg().getString("tid") : null, ao.isEmpty(this.gZs.aSo) ? null : this.gZs.aSo);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gZt != null) {
            this.gZt.onDestroy();
        }
        if (this.gZv != null) {
            this.gZv.cancelMessage();
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
        if (this.gZu != null) {
            this.gZu.onWbShareSuccess();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        if (this.gZu != null) {
            this.gZu.onWbShareCancel();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        if (this.gZu != null) {
            this.gZu.onWbShareFail();
        }
    }
}
