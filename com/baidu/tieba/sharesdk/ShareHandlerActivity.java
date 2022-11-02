package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.fj8;
import com.baidu.tieba.gj8;
import com.baidu.tieba.hj8;
import com.baidu.tieba.ij8;
import com.baidu.tieba.jj8;
import com.baidu.tieba.kj8;
import com.baidu.tieba.mj8;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.oj8;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.tieba.wi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes5.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements mj8, WbShareCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public ShareEntity c;
    public fj8 d;
    public jj8 e;
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

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.closeAnimation();
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.enterExitAnimation();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            fj8 fj8Var = this.d;
            if (fj8Var != null) {
                fj8Var.s();
            }
            ShareReportModel shareReportModel = this.f;
            if (shareReportModel != null) {
                shareReportModel.cancelMessage();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onResume();
            if (this.a) {
                finish();
            } else {
                this.a = true;
            }
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareCancel() {
        jj8 jj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (jj8Var = this.e) != null) {
            jj8Var.P();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        jj8 jj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (jj8Var = this.e) != null) {
            jj8Var.Q();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        jj8 jj8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (jj8Var = this.e) != null) {
            jj8Var.R();
        }
    }

    @Override // com.baidu.tieba.mj8
    public void b1(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            if (i2 == 1) {
                oj8.b(i, this.c);
            }
            if (i2 == 3) {
                if (i != 8 && i != 6) {
                    oj8.a(i, this.c);
                } else {
                    oj8.b(i, this.c);
                }
            }
            if (this.c.getStats() != null) {
                this.c.getStats().getString("tid");
                this.c.getStats().getString("pid");
            }
            String str = null;
            if (!wi.isEmpty(this.c.taskCompleteId)) {
                str = this.c.taskCompleteId;
            }
            x1(i, i2, this.c.getStats(), str);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i != 10103 && i != 10104) {
                fj8 fj8Var = this.d;
                if (fj8Var != null) {
                    fj8Var.o(intent);
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
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
            y1(shareEntity.getStats());
            this.b = this.c.getShareTo();
            fj8 fj8Var = this.d;
            if (fj8Var != null) {
                fj8Var.s();
                this.d = null;
            }
            jj8 jj8Var = this.e;
            if (jj8Var != null) {
                jj8Var.s();
                this.e = null;
            }
            int i = this.b;
            if (i != 0) {
                if (i != 6) {
                    if (i != 8) {
                        if (i != 2) {
                            if (i != 3) {
                                if (i != 4) {
                                    this.d = null;
                                } else {
                                    this.d = new hj8(this);
                                }
                            } else {
                                this.d = new kj8(this, 3);
                            }
                        } else {
                            this.d = new kj8(this, 2);
                        }
                    } else {
                        this.d = new gj8(this);
                    }
                } else {
                    jj8 jj8Var2 = new jj8(this, this, this);
                    this.e = jj8Var2;
                    this.d = jj8Var2;
                }
            } else {
                this.d = new ij8(this);
            }
            fj8 fj8Var2 = this.d;
            if (fj8Var2 != null) {
                fj8Var2.A(this.c.getTid());
                this.d.y(this.c.getExtLiveInfo());
                this.d.B(this.c.getUserGrowthWeight());
                this.d.z(this.c.getTopicId());
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
            fj8 fj8Var3 = this.d;
            if (fj8Var3 != null) {
                fj8Var3.t(getUniqueId());
                this.d.o(getIntent());
                this.d.a(this.c, this);
                return;
            }
            if (this.c.getStats() != null) {
                this.c.getStats().getString("tid");
            }
            x1(this.b, 2, this.c.getStats(), null);
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                intent.getIntExtra("extra_skin", 3);
            }
            fj8 fj8Var = this.d;
            if (fj8Var != null) {
                fj8Var.o(intent);
            }
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
        }
    }

    public final void y1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, bundle) != null) || bundle == null) {
            return;
        }
        if (this.f == null) {
            this.f = new ShareReportModel(getPageContext());
        }
        this.f.A(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
    }
}
