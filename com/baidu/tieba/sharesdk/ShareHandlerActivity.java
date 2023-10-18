package com.baidu.tieba.sharesdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tieba.a6a;
import com.baidu.tieba.ad;
import com.baidu.tieba.b6a;
import com.baidu.tieba.c6a;
import com.baidu.tieba.d6a;
import com.baidu.tieba.e6a;
import com.baidu.tieba.g6a;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.j6a;
import com.baidu.tieba.model.ShareReportModel;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.tieba.z5a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.tencent.tauth.Tencent;
/* loaded from: classes8.dex */
public class ShareHandlerActivity extends ShareBaseActivity implements g6a, WbShareCallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public int b;
    public ShareEntity c;
    public z5a d;
    public d6a e;
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
            z5a z5aVar = this.d;
            if (z5aVar != null) {
                z5aVar.r();
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
        d6a d6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (d6aVar = this.e) != null) {
            d6aVar.N();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareFail() {
        d6a d6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (d6aVar = this.e) != null) {
            d6aVar.O();
        }
    }

    @Override // com.sina.weibo.sdk.share.WbShareCallback
    public void onWbShareSuccess() {
        d6a d6aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (d6aVar = this.e) != null) {
            d6aVar.P();
        }
    }

    public final void N0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bundle) != null) || bundle == null) {
            return;
        }
        if (this.f == null) {
            this.f = new ShareReportModel(getPageContext());
        }
        this.f.O(bundle.getString("fid"), bundle.getString("tid"), bundle.getInt("obj_source"));
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i != 10103 && i != 10104) {
                z5a z5aVar = this.d;
                if (z5aVar != null) {
                    z5aVar.n(intent);
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
            N0(shareEntity.getStats());
            this.b = this.c.getShareTo();
            z5a z5aVar = this.d;
            if (z5aVar != null) {
                z5aVar.r();
                this.d = null;
            }
            d6a d6aVar = this.e;
            if (d6aVar != null) {
                d6aVar.r();
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
                                    this.d = new b6a(this);
                                }
                            } else {
                                this.d = new e6a(this, 3);
                            }
                        } else {
                            this.d = new e6a(this, 2);
                        }
                    } else {
                        this.d = new a6a(this);
                    }
                } else {
                    d6a d6aVar2 = new d6a(this, this, this);
                    this.e = d6aVar2;
                    this.d = d6aVar2;
                }
            } else {
                this.d = new c6a(this);
            }
            z5a z5aVar2 = this.d;
            if (z5aVar2 != null) {
                z5aVar2.A(this.c.getTid());
                this.d.y(this.c.getExtLiveInfo());
                if (!GroupInfoData.isValidGroup(this.c.groupData)) {
                    this.d.x(true);
                }
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
            z5a z5aVar3 = this.d;
            if (z5aVar3 != null) {
                z5aVar3.s(getUniqueId());
                this.d.n(getIntent());
                this.d.a(this.c, this);
                return;
            }
            if (this.c.getStats() != null) {
                this.c.getStats().getString("tid");
            }
            M0(this.b, 2, this.c.getStats(), null);
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
            z5a z5aVar = this.d;
            if (z5aVar != null) {
                z5aVar.n(intent);
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

    @Override // com.baidu.tieba.g6a
    public void q0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i, i2) == null) {
            if (i2 == 1) {
                j6a.b(i, this.c);
            }
            if (i2 == 3) {
                if (i != 8 && i != 6) {
                    j6a.a(i, this.c);
                } else {
                    j6a.b(i, this.c);
                }
            }
            if (this.c.getStats() != null) {
                this.c.getStats().getString("tid");
                this.c.getStats().getString("pid");
            }
            String str = null;
            if (!ad.isEmpty(this.c.taskCompleteId)) {
                str = this.c.taskCompleteId;
            }
            M0(i, i2, this.c.getStats(), str);
        }
    }
}
