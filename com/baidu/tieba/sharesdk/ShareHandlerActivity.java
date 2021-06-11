package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
import d.a.c.e.p.k;
import d.a.n0.x2.d.a;
import d.a.n0.x2.d.c;
import d.a.n0.x2.d.d;
import d.a.n0.x2.d.e;
import d.a.n0.x2.d.f;
import d.a.n0.x2.e.b;
/* loaded from: classes5.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements b, WbShareCallback {
    public static int skinType = 3;
    public a mCurrentShare;
    public PermissionJudgePolicy mPermissionJudgement;
    public e mShareByWeibo;
    public ShareEntity mShareEntity;
    public ShareReportModel mShareReportModel;
    public boolean isSecondOnResume = false;
    public int mShareChannel = -1;

    private void shareReport(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (this.mShareReportModel == null) {
            this.mShareReportModel = new ShareReportModel(getPageContext());
        }
        this.mShareReportModel.x(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        super.closeAnimation();
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        super.enterExitAnimation();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 10103 && i2 != 10104) {
            a aVar = this.mCurrentShare;
            if (aVar != null) {
                aVar.l(intent);
                return;
            }
            return;
        }
        Tencent.onActivityResultData(i2, i3, intent, null);
    }

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            this.mShareEntity = (ShareEntity) intent.getParcelableExtra("extra_share_data");
            skinType = intent.getIntExtra("extra_skin", 3);
        } catch (Exception unused) {
        }
        ShareEntity shareEntity = this.mShareEntity;
        if (shareEntity == null) {
            finish();
            return;
        }
        shareReport(shareEntity.l());
        this.mShareChannel = this.mShareEntity.j();
        a aVar = this.mCurrentShare;
        if (aVar != null) {
            aVar.p();
            this.mCurrentShare = null;
        }
        e eVar = this.mShareByWeibo;
        if (eVar != null) {
            eVar.p();
            this.mShareByWeibo = null;
        }
        int i2 = this.mShareChannel;
        if (i2 == 0) {
            this.mCurrentShare = new d(this);
        } else if (i2 == 6) {
            e eVar2 = new e(this, this, this);
            this.mShareByWeibo = eVar2;
            this.mCurrentShare = eVar2;
        } else if (i2 == 8) {
            this.mCurrentShare = new d.a.n0.x2.d.b(this);
        } else if (i2 == 2) {
            this.mCurrentShare = new f(this, 2);
        } else if (i2 == 3) {
            this.mCurrentShare = new f(this, 3);
        } else if (i2 != 4) {
            this.mCurrentShare = null;
        } else {
            this.mCurrentShare = new c(this);
        }
        a aVar2 = this.mCurrentShare;
        if (aVar2 != null) {
            aVar2.t(this.mShareEntity.m());
            this.mCurrentShare.s(this.mShareEntity.c());
        }
        if (this.mShareEntity.r() && !TextUtils.isEmpty(this.mShareEntity.e())) {
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
            if (this.mPermissionJudgement.startRequestPermission(getPageContext().getPageActivity())) {
                return;
            }
        }
        a aVar3 = this.mCurrentShare;
        if (aVar3 != null) {
            aVar3.q(getUniqueId());
            this.mCurrentShare.l(getIntent());
            this.mCurrentShare.a(this.mShareEntity, this);
            return;
        }
        if (this.mShareEntity.l() != null) {
            this.mShareEntity.l().getString("tid");
        }
        finishWithResult(this.mShareChannel, 2, this.mShareEntity.l(), null);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        a aVar = this.mCurrentShare;
        if (aVar != null) {
            aVar.p();
        }
        ShareReportModel shareReportModel = this.mShareReportModel;
        if (shareReportModel != null) {
            shareReportModel.cancelMessage();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            skinType = intent.getIntExtra("extra_skin", 3);
        }
        a aVar = this.mCurrentShare;
        if (aVar != null) {
            aVar.l(intent);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isSecondOnResume) {
            finish();
        } else {
            this.isSecondOnResume = true;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // d.a.n0.x2.e.b
    public void onShare(int i2, int i3) {
        if (i3 == 1) {
            d.a.n0.x2.f.b.b(i2, this.mShareEntity);
        }
        if (i3 == 3) {
            if (i2 != 8 && i2 != 6) {
                d.a.n0.x2.f.b.a(i2, this.mShareEntity);
            } else {
                d.a.n0.x2.f.b.b(i2, this.mShareEntity);
            }
        }
        if (this.mShareEntity.l() != null) {
            this.mShareEntity.l().getString("tid");
            this.mShareEntity.l().getString("pid");
        }
        finishWithResult(i2, i3, this.mShareEntity.l(), k.isEmpty(this.mShareEntity.taskCompleteId) ? null : this.mShareEntity.taskCompleteId);
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        e eVar = this.mShareByWeibo;
        if (eVar != null) {
            eVar.I();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        e eVar = this.mShareByWeibo;
        if (eVar != null) {
            eVar.J();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        e eVar = this.mShareByWeibo;
        if (eVar != null) {
            eVar.K();
        }
    }
}
