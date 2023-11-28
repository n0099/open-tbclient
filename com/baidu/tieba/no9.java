package com.baidu.tieba;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class no9 extends re5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public no9(Context context) {
        super(context, TbadkCoreApplication.getInst().getString(R.string.show_virtual), 41);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.t = true;
        this.d = R.drawable.icon_mask_post_keyboard24_selection;
        this.e = R.drawable.icon_mask_post_keyboard24_selection;
        h();
        this.i = false;
        this.j = true;
        this.n = 6;
        this.p = new int[]{1};
    }

    @Override // com.baidu.tieba.re5
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.t = !this.t;
            SharedPrefHelper.getInstance().putBoolean("key_virtual_image_and_state_has_show", this.t);
            h();
            return super.a();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.re5
    public void h() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (SharedPrefHelper.getInstance().getBoolean("key_virtual_image_and_state_has_show", true)) {
                i = R.drawable.icon_pure_post_more_virtual_select;
            } else {
                i = R.drawable.icon_pure_post_more_virtual_unselect;
            }
            this.h = i;
        }
    }
}
