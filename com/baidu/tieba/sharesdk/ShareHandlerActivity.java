package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.c;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.tencent.tauth.Tencent;
/* loaded from: classes3.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, IWeiboHandler.Response {
    protected boolean gPp = false;
    protected int gPq = -1;
    protected ShareEntity gPr;
    protected com.baidu.tieba.sharesdk.a.a gPs;
    protected e gPt;
    private ShareReportModel gPu;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gPr = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gPr == null) {
            finish();
            return;
        }
        I(this.gPr.IX());
        this.gPq = this.gPr.bsi();
        if (this.gPs != null) {
            this.gPs.onDestroy();
            this.gPs = null;
        }
        if (this.gPt != null) {
            this.gPt.onDestroy();
            this.gPt = null;
        }
        switch (this.gPq) {
            case 0:
                this.gPs = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gPs = null;
                break;
            case 2:
                this.gPs = new f(this, 2);
                break;
            case 3:
                this.gPs = new f(this, 3);
                break;
            case 4:
                this.gPs = new c(this);
                break;
            case 6:
                this.gPt = new e(this, this, this);
                this.gPs = this.gPt;
                break;
            case 8:
                this.gPs = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gPs != null) {
            this.gPs.q(getUniqueId());
            this.gPs.F(getIntent());
            this.gPs.a(this.gPr, this);
            return;
        }
        j(this.gPq, 2, this.gPr.IX() != null ? this.gPr.IX().getString("tid") : null);
    }

    private void I(Bundle bundle) {
        if (bundle != null) {
            if (this.gPu == null) {
                this.gPu = new ShareReportModel(getPageContext());
            }
            this.gPu.i(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gPp) {
            finish();
        } else {
            this.gPp = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gPs != null) {
            this.gPs.F(intent);
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
    public void cA(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gPr);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gPr);
        }
        String str = null;
        if (this.gPr.IX() != null) {
            str = this.gPr.IX().getString("tid");
        }
        j(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gPs != null) {
            this.gPs.onDestroy();
        }
        if (this.gPu != null) {
            this.gPu.cancelMessage();
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

    @Override // com.sina.weibo.sdk.api.share.IWeiboHandler.Response
    public void onResponse(BaseResponse baseResponse) {
        if (this.gPt != null) {
            this.gPt.onResponse(baseResponse);
        }
    }
}
