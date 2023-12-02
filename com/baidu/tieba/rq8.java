package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.base.core.uilist.BaseNormalAdapter;
import com.baidu.tieba.im.base.core.uilist.MsgSender;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class rq8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgSender<? extends BaseNormalAdapter, ? extends BaseItem<? extends TbBaseMsg>> a;

    public rq8() {
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

    @NonNull
    public <T extends BaseNormalAdapter, Msg extends BaseItem<? extends TbBaseMsg>> MsgSender<T, Msg> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (MsgSender<T, Msg>) this.a;
        }
        return (MsgSender) invokeV.objValue;
    }

    @Nullable
    public static rq8 b(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            return (rq8) view2.getTag(R.id.obfuscated_res_0x7f0924ca);
        }
        return (rq8) invokeL.objValue;
    }

    public <T extends BaseNormalAdapter, Msg extends BaseItem<? extends TbBaseMsg>> void c(@NonNull MsgSender<T, Msg> msgSender) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msgSender) == null) {
            this.a = msgSender;
        }
    }

    public static void d(@NonNull View view2, @NonNull rq8 rq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, rq8Var) == null) {
            view2.setTag(R.id.obfuscated_res_0x7f0924ca, rq8Var);
        }
    }
}
