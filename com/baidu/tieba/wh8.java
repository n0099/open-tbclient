package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class wh8 implements u98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public wh8() {
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

    public static t98 c(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, recyclerView, i)) == null) {
            return new t98(context, recyclerView, new uh8(), new vh8(), i, 1);
        }
        return (t98) invokeLLI.objValue;
    }

    public static s98 e(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65539, null, context, recyclerView, i)) == null) {
            return new s98(context, recyclerView, new uh8(), new vh8(), i, 1);
        }
        return (s98) invokeLLI.objValue;
    }

    @Override // com.baidu.tieba.u98
    public t98 b(Context context, RecyclerView recyclerView, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, recyclerView, i)) == null) {
            return c(context, recyclerView, i);
        }
        return (t98) invokeLLI.objValue;
    }

    public static t98 d(Context context, RecyclerView recyclerView, int i, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, recyclerView, Integer.valueOf(i), skillDTO, userDTO})) == null) {
            vh8 vh8Var = new vh8();
            vh8Var.e(skillDTO);
            vh8Var.f(userDTO);
            return new t98(context, recyclerView, new uh8(), vh8Var, i, 2);
        }
        return (t98) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.u98
    public t98 a(Context context, RecyclerView recyclerView, int i, @Nullable BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable BotsDTO.BotListDTO.UserDTO userDTO) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, recyclerView, Integer.valueOf(i), skillDTO, userDTO})) == null) {
            return d(context, recyclerView, i, skillDTO, userDTO);
        }
        return (t98) invokeCommon.objValue;
    }
}
