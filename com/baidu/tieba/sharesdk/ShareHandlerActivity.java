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
import com.repackage.ad8;
import com.repackage.bd8;
import com.repackage.cd8;
import com.repackage.ed8;
import com.repackage.gd8;
import com.repackage.oi;
import com.repackage.xc8;
import com.repackage.yc8;
import com.repackage.zc8;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes4.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements ed8, WbShareCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public ShareEntity c;
    public xc8 d;
    public bd8 e;
    public ShareReportModel f;
    public PermissionJudgePolicy g;

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
        this.a = false;
        this.b = -1;
    }

    public final void B1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) || bundle == null) {
            return;
        }
        if (this.f == null) {
            this.f = new ShareReportModel(getPageContext());
        }
        this.f.B(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.closeAnimation();
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.repackage.ed8
    public void e1(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            if (i2 == 1) {
                gd8.b(i, this.c);
            }
            if (i2 == 3) {
                if (i != 8 && i != 6) {
                    gd8.a(i, this.c);
                } else {
                    gd8.b(i, this.c);
                }
            }
            if (this.c.getStats() != null) {
                this.c.getStats().getString("tid");
                this.c.getStats().getString("pid");
            }
            A1(i, i2, this.c.getStats(), oi.isEmpty(this.c.taskCompleteId) ? null : this.c.taskCompleteId);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.enterExitAnimation();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i != 10103 && i != 10104) {
                xc8 xc8Var = this.d;
                if (xc8Var != null) {
                    xc8Var.m(intent);
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
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            requestWindowFeature(1);
            super.onCreate(bundle);
            try {
                Intent intent = getIntent();
                this.c = (ShareEntity) intent.getParcelableExtra("extra_share_data");
                intent.getIntExtra("extra_skin", 3);
            } catch (Exception unused) {
            }
            ShareEntity shareEntity = this.c;
            if (shareEntity == null) {
                finish();
                return;
            }
            B1(shareEntity.getStats());
            this.b = this.c.getShareTo();
            xc8 xc8Var = this.d;
            if (xc8Var != null) {
                xc8Var.q();
                this.d = null;
            }
            bd8 bd8Var = this.e;
            if (bd8Var != null) {
                bd8Var.q();
                this.e = null;
            }
            int i = this.b;
            if (i == 0) {
                this.d = new ad8(this);
            } else if (i == 6) {
                bd8 bd8Var2 = new bd8(this, this, this);
                this.e = bd8Var2;
                this.d = bd8Var2;
            } else if (i == 8) {
                this.d = new yc8(this);
            } else if (i == 2) {
                this.d = new cd8(this, 2);
            } else if (i == 3) {
                this.d = new cd8(this, 3);
            } else if (i != 4) {
                this.d = null;
            } else {
                this.d = new zc8(this);
            }
            xc8 xc8Var2 = this.d;
            if (xc8Var2 != null) {
                xc8Var2.v(this.c.getTid());
                this.d.u(this.c.getExtLiveInfo());
            }
            if (this.c.needCheckStoragePermission() && !TextUtils.isEmpty(this.c.getImgUrl())) {
                if (this.g == null) {
                    this.g = new PermissionJudgePolicy();
                }
                this.g.clearRequestPermissionList();
                this.g.appendRequestPermission(getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                if (this.g.startRequestPermission(getPageContext().getPageActivity())) {
                    return;
                }
            }
            xc8 xc8Var3 = this.d;
            if (xc8Var3 != null) {
                xc8Var3.r(getUniqueId());
                this.d.m(getIntent());
                this.d.a(this.c, this);
                return;
            }
            if (this.c.getStats() != null) {
                this.c.getStats().getString("tid");
            }
            A1(this.b, 2, this.c.getStats(), null);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            xc8 xc8Var = this.d;
            if (xc8Var != null) {
                xc8Var.q();
            }
            ShareReportModel shareReportModel = this.f;
            if (shareReportModel != null) {
                shareReportModel.cancelMessage();
            }
            super.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                intent.getIntExtra("extra_skin", 3);
            }
            xc8 xc8Var = this.d;
            if (xc8Var != null) {
                xc8Var.m(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            if (this.a) {
                finish();
            } else {
                this.a = true;
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        bd8 bd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (bd8Var = this.e) == null) {
            return;
        }
        bd8Var.I();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        bd8 bd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bd8Var = this.e) == null) {
            return;
        }
        bd8Var.J();
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        bd8 bd8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bd8Var = this.e) == null) {
            return;
        }
        bd8Var.K();
    }
}
