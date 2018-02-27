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
    protected boolean gOZ = false;
    protected int gPa = -1;
    protected ShareEntity gPb;
    protected com.baidu.tieba.sharesdk.a.a gPc;
    protected e gPd;
    private ShareReportModel gPe;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gPb = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gPb == null) {
            finish();
            return;
        }
        I(this.gPb.IW());
        this.gPa = this.gPb.bsh();
        if (this.gPc != null) {
            this.gPc.onDestroy();
            this.gPc = null;
        }
        if (this.gPd != null) {
            this.gPd.onDestroy();
            this.gPd = null;
        }
        switch (this.gPa) {
            case 0:
                this.gPc = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gPc = null;
                break;
            case 2:
                this.gPc = new f(this, 2);
                break;
            case 3:
                this.gPc = new f(this, 3);
                break;
            case 4:
                this.gPc = new c(this);
                break;
            case 6:
                this.gPd = new e(this, this, this);
                this.gPc = this.gPd;
                break;
            case 8:
                this.gPc = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gPc != null) {
            this.gPc.q(getUniqueId());
            this.gPc.F(getIntent());
            this.gPc.a(this.gPb, this);
            return;
        }
        j(this.gPa, 2, this.gPb.IW() != null ? this.gPb.IW().getString("tid") : null);
    }

    private void I(Bundle bundle) {
        if (bundle != null) {
            if (this.gPe == null) {
                this.gPe = new ShareReportModel(getPageContext());
            }
            this.gPe.i(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gOZ) {
            finish();
        } else {
            this.gOZ = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gPc != null) {
            this.gPc.F(intent);
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
            com.baidu.tieba.sharesdk.c.b.a(i, this.gPb);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gPb);
        }
        String str = null;
        if (this.gPb.IW() != null) {
            str = this.gPb.IW().getString("tid");
        }
        j(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gPc != null) {
            this.gPc.onDestroy();
        }
        if (this.gPe != null) {
            this.gPe.cancelMessage();
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
        if (this.gPd != null) {
            this.gPd.onResponse(baseResponse);
        }
    }
}
