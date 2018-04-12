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
    private ShareReportModel gkA;
    protected boolean gkv = false;
    protected int gkw = -1;
    protected ShareEntity gkx;
    protected com.baidu.tieba.sharesdk.a.a gky;
    protected e gkz;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gkx = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gkx == null) {
            finish();
            return;
        }
        D(this.gkx.BL());
        this.gkw = this.gkx.bnr();
        if (this.gky != null) {
            this.gky.onDestroy();
            this.gky = null;
        }
        if (this.gkz != null) {
            this.gkz.onDestroy();
            this.gkz = null;
        }
        switch (this.gkw) {
            case 0:
                this.gky = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gky = null;
                break;
            case 2:
                this.gky = new f(this, 2);
                break;
            case 3:
                this.gky = new f(this, 3);
                break;
            case 4:
                this.gky = new c(this);
                break;
            case 6:
                this.gkz = new e(this, this, this);
                this.gky = this.gkz;
                break;
            case 8:
                this.gky = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gky != null) {
            this.gky.q(getUniqueId());
            this.gky.D(getIntent());
            this.gky.a(this.gkx, this);
            return;
        }
        g(this.gkw, 2, this.gkx.BL() != null ? this.gkx.BL().getString("tid") : null);
    }

    private void D(Bundle bundle) {
        if (bundle != null) {
            if (this.gkA == null) {
                this.gkA = new ShareReportModel(getPageContext());
            }
            this.gkA.i(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gkv) {
            finish();
        } else {
            this.gkv = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gky != null) {
            this.gky.D(intent);
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
    public void bC(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gkx);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gkx);
        }
        String str = null;
        if (this.gkx.BL() != null) {
            str = this.gkx.BL().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gky != null) {
            this.gky.onDestroy();
        }
        if (this.gkA != null) {
            this.gkA.cancelMessage();
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
        if (this.gkz != null) {
            this.gkz.onResponse(baseResponse);
        }
    }
}
