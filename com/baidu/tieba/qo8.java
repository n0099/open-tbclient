package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.MsgSendHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qo8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MsgSendHelper<? extends BaseChatAdapter, ? extends BaseMsg> a;

    public qo8() {
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
    public <T extends BaseChatAdapter, Msg extends BaseMsg> MsgSendHelper<T, Msg> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (MsgSendHelper<T, Msg>) this.a;
        }
        return (MsgSendHelper) invokeV.objValue;
    }

    @Nullable
    public static qo8 b(@NonNull View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, view2)) == null) {
            return (qo8) view2.getTag(R.id.obfuscated_res_0x7f092419);
        }
        return (qo8) invokeL.objValue;
    }

    public <T extends BaseChatAdapter, Msg extends BaseMsg> void c(@NonNull MsgSendHelper<T, Msg> msgSendHelper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msgSendHelper) == null) {
            this.a = msgSendHelper;
        }
    }

    public static void d(@NonNull View view2, @NonNull qo8 qo8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, qo8Var) == null) {
            view2.setTag(R.id.obfuscated_res_0x7f092419, qo8Var);
        }
    }
}
