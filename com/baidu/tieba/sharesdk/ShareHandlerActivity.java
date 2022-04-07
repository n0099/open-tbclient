package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
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
import com.repackage.af8;
import com.repackage.cf8;
import com.repackage.ef8;
import com.repackage.ni;
import com.repackage.ve8;
import com.repackage.we8;
import com.repackage.xe8;
import com.repackage.ye8;
import com.repackage.ze8;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes4.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements cf8, WbShareCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static int skinType = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSecondOnResume;
    public ve8 mCurrentShare;
    public PermissionJudgePolicy mPermissionJudgement;
    public ze8 mShareByWeibo;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.mShareReportModel.z(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
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
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i != 10103 && i != 10104) {
                ve8 ve8Var = this.mCurrentShare;
                if (ve8Var != null) {
                    ve8Var.l(intent);
                    return;
                }
                return;
            }
            Tencent.onActivityResultData(i, i2, intent, null);
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
            ve8 ve8Var = this.mCurrentShare;
            if (ve8Var != null) {
                ve8Var.p();
                this.mCurrentShare = null;
            }
            ze8 ze8Var = this.mShareByWeibo;
            if (ze8Var != null) {
                ze8Var.p();
                this.mShareByWeibo = null;
            }
            int i = this.mShareChannel;
            if (i == 0) {
                this.mCurrentShare = new ye8(this);
            } else if (i == 6) {
                ze8 ze8Var2 = new ze8(this, this, this);
                this.mShareByWeibo = ze8Var2;
                this.mCurrentShare = ze8Var2;
            } else if (i == 8) {
                this.mCurrentShare = new we8(this);
            } else if (i == 2) {
                this.mCurrentShare = new af8(this, 2);
            } else if (i == 3) {
                this.mCurrentShare = new af8(this, 3);
            } else if (i != 4) {
                this.mCurrentShare = null;
            } else {
                this.mCurrentShare = new xe8(this);
            }
            ve8 ve8Var2 = this.mCurrentShare;
            if (ve8Var2 != null) {
                ve8Var2.t(this.mShareEntity.getTid());
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
            ve8 ve8Var3 = this.mCurrentShare;
            if (ve8Var3 != null) {
                ve8Var3.q(getUniqueId());
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
            ve8 ve8Var = this.mCurrentShare;
            if (ve8Var != null) {
                ve8Var.p();
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
            ve8 ve8Var = this.mCurrentShare;
            if (ve8Var != null) {
                ve8Var.l(intent);
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

    @Override // com.repackage.cf8
    public void onShare(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            if (i2 == 1) {
                ef8.b(i, this.mShareEntity);
            }
            if (i2 == 3) {
                if (i != 8 && i != 6) {
                    ef8.a(i, this.mShareEntity);
                } else {
                    ef8.b(i, this.mShareEntity);
                }
            }
            if (this.mShareEntity.getStats() != null) {
                this.mShareEntity.getStats().getString("tid");
                this.mShareEntity.getStats().getString("pid");
            }
            finishWithResult(i, i2, this.mShareEntity.getStats(), ni.isEmpty(this.mShareEntity.taskCompleteId) ? null : this.mShareEntity.taskCompleteId);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        ze8 ze8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (ze8Var = this.mShareByWeibo) == null) {
            return;
        }
        ze8Var.I();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        ze8 ze8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (ze8Var = this.mShareByWeibo) == null) {
            return;
        }
        ze8Var.J();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        ze8 ze8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (ze8Var = this.mShareByWeibo) == null) {
            return;
        }
        ze8Var.K();
    }
}
