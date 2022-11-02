package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.yv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class xt8 extends yv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final or8 d;

    @Override // com.baidu.tieba.yv4
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xt8(@NonNull MainTabActivity mainTabActivity, @NonNull or8 or8Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, or8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = or8Var;
        this.c = mainTabActivity;
    }

    @Override // com.baidu.tieba.yv4
    public void d(@NonNull yv4.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            boolean z2 = false;
            if (this.d.B() != null && this.d.B().getCurrentTabType() != 2) {
                aVar.a(false);
                return;
            }
            boolean h = ky4.k().h(ky4.o("key_new_god_pop_is_show"), false);
            if (TbSingleton.getInstance().getNewGodData() != null) {
                z = true;
            } else {
                z = false;
            }
            if (h && z) {
                z2 = true;
            }
            aVar.a(z2);
        }
    }

    @Override // com.baidu.tieba.yv4
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.c, "", "https://tieba.baidu.com/mo/q/hybrid/popups?page=god-invite", false, true, true);
            tbWebViewActivityConfig.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            tbWebViewActivityConfig.setWebDialogName("newGod");
            this.c.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            ky4.k().u(ky4.o("key_new_god_pop_is_show"), false);
            ew4.f("newGod");
        }
    }
}
