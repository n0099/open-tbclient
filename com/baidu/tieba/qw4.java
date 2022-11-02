package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class qw4 implements ow4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ow4
    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (View) invokeV.objValue;
    }

    public qw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ow4
    public rw4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            rw4 rw4Var = new rw4();
            rw4Var.c(R.drawable.obfuscated_res_0x7f0806a6);
            rw4Var.g(R.drawable.obfuscated_res_0x7f0806a7);
            rw4Var.h(R.dimen.obfuscated_res_0x7f070279);
            rw4Var.d(81);
            rw4Var.e(R.dimen.obfuscated_res_0x7f070279);
            return rw4Var;
        }
        return (rw4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow4
    public uw4 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            uw4 uw4Var = new uw4();
            Resources resources = TbadkCoreApplication.getInst().getResources();
            if (resources != null) {
                uw4Var.a(resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702a2));
            }
            return uw4Var;
        }
        return (uw4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ow4
    public TbImageView d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }
        return (TbImageView) invokeL.objValue;
    }
}
