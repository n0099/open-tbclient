package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.a.d;
import com.baidu.tieba.sharesdk.a.e;
import com.baidu.tieba.sharesdk.a.f;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.tencent.tauth.Tencent;
/* loaded from: classes3.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements com.baidu.tieba.sharesdk.b.b, IWeiboHandler.Response {
    protected boolean gwW = false;
    protected int gwX = -1;
    protected ShareEntity gwY;
    protected com.baidu.tieba.sharesdk.a.a gwZ;
    protected e gxa;
    private ShareReportModel gxb;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gwY = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gwY == null) {
            finish();
            return;
        }
        E(this.gwY.Fl());
        this.gwX = this.gwY.bsp();
        if (this.gwZ != null) {
            this.gwZ.onDestroy();
            this.gwZ = null;
        }
        if (this.gxa != null) {
            this.gxa.onDestroy();
            this.gxa = null;
        }
        switch (this.gwX) {
            case 0:
                this.gwZ = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gwZ = null;
                break;
            case 2:
                this.gwZ = new f(this, 2);
                break;
            case 3:
                this.gwZ = new f(this, 3);
                break;
            case 4:
                this.gwZ = new com.baidu.tieba.sharesdk.a.c(this);
                break;
            case 6:
                this.gxa = new e(this, this, this);
                this.gwZ = this.gxa;
                break;
            case 8:
                this.gwZ = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gwZ != null) {
            this.gwZ.r(getUniqueId());
            this.gwZ.D(getIntent());
            this.gwZ.a(this.gwY, this);
            return;
        }
        g(this.gwX, 2, this.gwY.Fl() != null ? this.gwY.Fl().getString("tid") : null);
    }

    private void E(Bundle bundle) {
        if (bundle != null) {
            if (this.gxb == null) {
                this.gxb = new ShareReportModel(getPageContext());
            }
            this.gxb.j(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gwW) {
            finish();
        } else {
            this.gwW = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gwZ != null) {
            this.gwZ.D(intent);
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
    public void bD(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gwY);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gwY);
        }
        String str = null;
        if (this.gwY.Fl() != null) {
            str = this.gwY.Fl().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gwZ != null) {
            this.gwZ.onDestroy();
        }
        if (this.gxb != null) {
            this.gxb.cancelMessage();
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
        if (this.gxa != null) {
            this.gxa.onResponse(baseResponse);
        }
    }
}
