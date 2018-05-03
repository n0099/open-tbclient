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
    protected boolean gks = false;
    protected int gkt = -1;
    protected ShareEntity gku;
    protected com.baidu.tieba.sharesdk.a.a gkv;
    protected e gkw;
    private ShareReportModel gkx;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.gku = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.gku == null) {
            finish();
            return;
        }
        D(this.gku.BL());
        this.gkt = this.gku.bnr();
        if (this.gkv != null) {
            this.gkv.onDestroy();
            this.gkv = null;
        }
        if (this.gkw != null) {
            this.gkw.onDestroy();
            this.gkw = null;
        }
        switch (this.gkt) {
            case 0:
                this.gkv = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.gkv = null;
                break;
            case 2:
                this.gkv = new f(this, 2);
                break;
            case 3:
                this.gkv = new f(this, 3);
                break;
            case 4:
                this.gkv = new c(this);
                break;
            case 6:
                this.gkw = new e(this, this, this);
                this.gkv = this.gkw;
                break;
            case 8:
                this.gkv = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.gkv != null) {
            this.gkv.q(getUniqueId());
            this.gkv.D(getIntent());
            this.gkv.a(this.gku, this);
            return;
        }
        g(this.gkt, 2, this.gku.BL() != null ? this.gku.BL().getString("tid") : null);
    }

    private void D(Bundle bundle) {
        if (bundle != null) {
            if (this.gkx == null) {
                this.gkx = new ShareReportModel(getPageContext());
            }
            this.gkx.i(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gks) {
            finish();
        } else {
            this.gks = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gkv != null) {
            this.gkv.D(intent);
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
    public void bB(int i, int i2) {
        if (i2 == 1) {
            com.baidu.tieba.sharesdk.c.b.a(i, this.gku);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.gku);
        }
        String str = null;
        if (this.gku.BL() != null) {
            str = this.gku.BL().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.gkv != null) {
            this.gkv.onDestroy();
        }
        if (this.gkx != null) {
            this.gkx.cancelMessage();
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
        if (this.gkw != null) {
            this.gkw.onResponse(baseResponse);
        }
    }
}
