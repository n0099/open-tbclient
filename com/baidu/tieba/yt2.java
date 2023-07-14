package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes8.dex */
public class yt2 extends pp2<gu2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.pp2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updateVideoRect" : (String) invokeV.objValue;
    }

    public yt2() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pp2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull gu2 gu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, gu2Var) == null) {
            gu2Var.L(command.arg1, command.arg2, command.arg3, command.arg4);
            String str = command.what;
            d(gu2Var, str, "Rect: (" + command.arg1 + StringUtil.ARRAY_ELEMENT_SEPARATOR + command.arg2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + command.arg3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + command.arg4 + SmallTailInfo.EMOTION_SUFFIX, false);
        }
    }
}
