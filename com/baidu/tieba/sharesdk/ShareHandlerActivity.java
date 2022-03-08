package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.o3.d.a;
import c.a.r0.o3.d.c;
import c.a.r0.o3.d.d;
import c.a.r0.o3.d.e;
import c.a.r0.o3.d.f;
import c.a.r0.o3.e.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes6.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements b, WbShareCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static int skinType = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSecondOnResume;
    public a mCurrentShare;
    public PermissionJudgePolicy mPermissionJudgement;
    public e mShareByWeibo;
    public int mShareChannel;
    public ShareEntity mShareEntity;
    public ShareReportModel mShareReportModel;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1525307131, "Lcom/baidu/tieba/sharesdk/ShareHandlerActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1525307131, "Lcom/baidu/tieba/sharesdk/ShareHandlerActivity;");
        }
    }

    public ShareHandlerActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.isSecondOnResume = false;
        this.mShareChannel = -1;
    }

    private void shareReport(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, bundle) == null) || bundle == null) {
            return;
        }
        if (this.mShareReportModel == null) {
            this.mShareReportModel = new ShareReportModel(getPageContext());
        }
        this.mShareReportModel.x(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.closeAnimation();
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.enterExitAnimation();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
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
    }

    @Override // com.baidu.tieba.sharesdk.ShareBaseActivity, com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
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
            shareReport(shareEntity.getStats());
            this.mShareChannel = this.mShareEntity.getShareTo();
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
                this.mCurrentShare = new c.a.r0.o3.d.b(this);
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
                aVar2.t(this.mShareEntity.getTid());
                this.mCurrentShare.s(this.mShareEntity.getExtLiveInfo());
            }
            if (this.mShareEntity.needCheckStoragePermission() && !TextUtils.isEmpty(this.mShareEntity.getImgUrl())) {
                if (this.mPermissionJudgement == null) {
                    this.mPermissionJudgement = new PermissionJudgePolicy();
                }
                this.mPermissionJudgement.clearRequestPermissionList();
                this.mPermissionJudgement.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
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
            if (this.mShareEntity.getStats() != null) {
                this.mShareEntity.getStats().getString("tid");
            }
            finishWithResult(this.mShareChannel, 2, this.mShareEntity.getStats(), null);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                skinType = intent.getIntExtra("extra_skin", 3);
            }
            a aVar = this.mCurrentShare;
            if (aVar != null) {
                aVar.l(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (this.isSecondOnResume) {
                finish();
            } else {
                this.isSecondOnResume = true;
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // c.a.r0.o3.e.b
    public void onShare(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            if (i3 == 1) {
                c.a.r0.o3.f.b.b(i2, this.mShareEntity);
            }
            if (i3 == 3) {
                if (i2 != 8 && i2 != 6) {
                    c.a.r0.o3.f.b.a(i2, this.mShareEntity);
                } else {
                    c.a.r0.o3.f.b.b(i2, this.mShareEntity);
                }
            }
            if (this.mShareEntity.getStats() != null) {
                this.mShareEntity.getStats().getString("tid");
                this.mShareEntity.getStats().getString("pid");
            }
            finishWithResult(i2, i3, this.mShareEntity.getStats(), m.isEmpty(this.mShareEntity.taskCompleteId) ? null : this.mShareEntity.taskCompleteId);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (eVar = this.mShareByWeibo) == null) {
            return;
        }
        eVar.I();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (eVar = this.mShareByWeibo) == null) {
            return;
        }
        eVar.J();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (eVar = this.mShareByWeibo) == null) {
            return;
        }
        eVar.K();
    }
}
