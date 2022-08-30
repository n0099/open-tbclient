package com.baidu.tieba;

import android.app.Activity;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class op8 extends bb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final ho8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public op8(MainTabActivity mainTabActivity, un8 un8Var) {
        super(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, un8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.f;
    }

    public final void a() {
        ho8 ho8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (ho8Var = this.b) == null || ho8Var.a() == null || this.a.C != 1) {
            return;
        }
        this.b.a().f();
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        MainTabActivity mainTabActivity = this.a;
        if (currentActivity != mainTabActivity || mainTabActivity.D.intValue() == 1) {
            return;
        }
        this.b.a().k();
    }

    public final void b(ProfileHttpResponseMessage profileHttpResponseMessage) {
        ho8 ho8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileHttpResponseMessage) == null) {
            if (profileHttpResponseMessage != null && profileHttpResponseMessage.GetUser() != null) {
                this.a.C = profileHttpResponseMessage.GetUser().my_like_num.intValue();
                if (this.a.C == 1 && (ho8Var = this.b) != null && ho8Var.a() != null) {
                    this.b.a().f();
                    this.b.a().k();
                }
                a();
                s28.a().d(profileHttpResponseMessage.GetUser().virtual_image_info);
                d();
            }
            if (profileHttpResponseMessage == null || profileHttpResponseMessage.getMemberBlockInfo() == null) {
                return;
            }
            this.a.N = profileHttpResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1;
            this.a.O = profileHttpResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1;
            TbSingleton.getInstance().setUserBan(profileHttpResponseMessage.getMemberBlockInfo().is_ban.intValue() == 1);
        }
    }

    public final void c(ProfileSocketResponseMessage profileSocketResponseMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, profileSocketResponseMessage) == null) {
            if (profileSocketResponseMessage != null && profileSocketResponseMessage.GetUser() != null) {
                this.a.C = profileSocketResponseMessage.GetUser().my_like_num.intValue();
                if (this.a.C == 1) {
                    ho8 ho8Var = this.b;
                    if (ho8Var != null && ho8Var.a() != null) {
                        this.b.a().f();
                    }
                    a();
                }
                s28.a().d(profileSocketResponseMessage.GetUser().virtual_image_info);
                d();
            }
            if (profileSocketResponseMessage == null || profileSocketResponseMessage.getMemberBlockInfo() == null) {
                return;
            }
            this.a.N = profileSocketResponseMessage.getMemberBlockInfo().is_permanent_ban.intValue() == 1;
            this.a.O = profileSocketResponseMessage.getMemberBlockInfo().is_auto_pay.intValue() == 1;
            TbSingleton.getInstance().setUserBan(profileSocketResponseMessage.getMemberBlockInfo().is_ban.intValue() == 1);
        }
    }

    public final void d() {
        ho8 ho8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (ho8Var = this.b) == null) {
            return;
        }
        ho8Var.a().j().G();
    }

    @Override // com.baidu.tieba.bb
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, responsedMessage) == null) {
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if (z || (responsedMessage instanceof ProfileHttpResponseMessage)) {
                if (z) {
                    c((ProfileSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    b((ProfileHttpResponseMessage) responsedMessage);
                }
            }
        }
    }
}
