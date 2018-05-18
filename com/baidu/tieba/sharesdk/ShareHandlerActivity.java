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
    protected ShareEntity glA;
    protected com.baidu.tieba.sharesdk.a.a glB;
    protected e glC;
    private ShareReportModel glD;
    protected boolean gly = false;
    protected int glz = -1;

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            this.glA = (ShareEntity) getIntent().getParcelableExtra("extra_share_data");
        } catch (Exception e) {
        }
        if (this.glA == null) {
            finish();
            return;
        }
        D(this.glA.BJ());
        this.glz = this.glA.bnp();
        if (this.glB != null) {
            this.glB.onDestroy();
            this.glB = null;
        }
        if (this.glC != null) {
            this.glC.onDestroy();
            this.glC = null;
        }
        switch (this.glz) {
            case 0:
                this.glB = new d(this);
                break;
            case 1:
            case 5:
            case 7:
            default:
                this.glB = null;
                break;
            case 2:
                this.glB = new f(this, 2);
                break;
            case 3:
                this.glB = new f(this, 3);
                break;
            case 4:
                this.glB = new c(this);
                break;
            case 6:
                this.glC = new e(this, this, this);
                this.glB = this.glC;
                break;
            case 8:
                this.glB = new com.baidu.tieba.sharesdk.a.b(this);
                break;
        }
        if (this.glB != null) {
            this.glB.q(getUniqueId());
            this.glB.D(getIntent());
            this.glB.a(this.glA, this);
            return;
        }
        g(this.glz, 2, this.glA.BJ() != null ? this.glA.BJ().getString("tid") : null);
    }

    private void D(Bundle bundle) {
        if (bundle != null) {
            if (this.glD == null) {
                this.glD = new ShareReportModel(getPageContext());
            }
            this.glD.i(bundle.getString(ImageViewerConfig.FORUM_ID), bundle.getString("tid"), bundle.getInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE));
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
        if (this.gly) {
            finish();
        } else {
            this.gly = true;
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.glB != null) {
            this.glB.D(intent);
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
            com.baidu.tieba.sharesdk.c.b.a(i, this.glA);
        }
        if (i2 == 3) {
            com.baidu.tieba.sharesdk.c.b.b(i, this.glA);
        }
        String str = null;
        if (this.glA.BJ() != null) {
            str = this.glA.BJ().getString("tid");
        }
        g(i, i2, str);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    protected void onDestroy() {
        if (this.glB != null) {
            this.glB.onDestroy();
        }
        if (this.glD != null) {
            this.glD.cancelMessage();
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
        if (this.glC != null) {
            this.glC.onResponse(baseResponse);
        }
    }
}
