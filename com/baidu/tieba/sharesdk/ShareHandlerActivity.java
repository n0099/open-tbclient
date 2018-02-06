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
    protected boolean gPo = false;
    protected int gPp = -1;
    protected ShareEntity gPq;
    protected com.baidu.tieba.sharesdk.a.a gPr;
    protected e gPs;
    private ShareReportModel gPt;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gPq = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gPq == null) {
            finish();
            return;
        }
        I(this.gPq.IX());
        this.gPp = this.gPq.bsi();
        if (this.gPr != null) {
            this.gPr.onDestroy();
            this.gPr = null;
        }
        if (this.gPs != null) {
            this.gPs.onDestroy();
            this.gPs = null;
        }
        switch (this.gPp) {
            case 0:
                this.gPr = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gPr = null;
                break;
            case 2:
                this.gPr = new f(this, 2);
                break;
            case 3:
                this.gPr = new f(this, 3);
                break;
            case 4:
                this.gPr = new c(this);
                break;
            case 6:
                this.gPs = new e(this, this, this);
                this.gPr = this.gPs;
                break;
            case 8:
                this.gPr = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gPr != null) {
            this.gPr.q(getUniqueId());
            this.gPr.F(getIntent());
            this.gPr.a(this.gPq, this);
            return;
        }
        j(this.gPp, 2, this.gPq.IX() != null ? this.gPq.IX().getString("tid") : null);
    }

    private void I(Bundle bundle) {
        if (bundle != null) {
            if (this.gPt == null) {
                this.gPt = new ShareReportModel(getPageContext());
            }
            this.gPt.i(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gPo) {
            finish();
        } else {
            this.gPo = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gPr != null) {
            this.gPr.F(intent);
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
            com.baidu.tieba.sharesdk.c.b.a(i, this.gPq);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gPq);
        }
        String str = null;
        if (this.gPq.IX() != null) {
            str = this.gPq.IX().getString("tid");
        }
        j(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gPr != null) {
            this.gPr.onDestroy();
        }
        if (this.gPt != null) {
            this.gPt.cancelMessage();
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
        if (this.gPs != null) {
            this.gPs.onResponse(baseResponse);
        }
    }
}
