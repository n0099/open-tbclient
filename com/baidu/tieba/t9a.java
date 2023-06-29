package com.baidu.tieba;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.w55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t9a extends w55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final e7a d;

    @Override // com.baidu.tieba.w55
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t9a(@NonNull MainTabActivity mainTabActivity, @NonNull e7a e7aVar) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, e7aVar};
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
        this.d = e7aVar;
        this.c = mainTabActivity;
    }

    @Override // com.baidu.tieba.w55
    public void d(@NonNull w55.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            boolean z2 = false;
            if (this.d.y() != null && this.d.y().getCurrentTabType() != 2) {
                aVar.callback(false);
                return;
            }
            boolean l = r95.p().l(r95.t("key_new_god_pop_is_show"), false);
            if (TbSingleton.getInstance().getNewGodData() != null) {
                z = true;
            } else {
                z = false;
            }
            if (l && z) {
                z2 = true;
            }
            aVar.callback(z2);
        }
    }

    @Override // com.baidu.tieba.w55
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TbWebViewActivityConfig h = ux4.h(this.c, "", "https://tieba.baidu.com/mo/q/hybrid/popups?page=god-invite", false, true, true);
            h.setPageTranslucent(TbWebViewActivityConfig.PAGE_TYPE_BLACK_TRANSLUCENT);
            h.setWebDialogName("newGod");
            this.c.sendMessage(new CustomMessage(2002001, h));
            r95.p().A(r95.t("key_new_god_pop_is_show"), false);
            d65.m("newGod");
        }
    }
}
