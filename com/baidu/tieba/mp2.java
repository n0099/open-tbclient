package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes5.dex */
public class mp2 extends ol2<fq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.ol2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setRate" : (String) invokeV.objValue;
    }

    public mp2() {
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
    @Override // com.baidu.tieba.ol2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull fq2 fq2Var) {
        Object obj;
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, fq2Var) != null) || (obj = command.obj) == null) {
            return;
        }
        if (obj instanceof Float) {
            f = ((Float) obj).floatValue();
        } else if (obj instanceof Double) {
            f = ((Double) obj).floatValue();
        } else {
            f = Float.MIN_VALUE;
        }
        if (f != Float.MIN_VALUE) {
            fq2Var.setSpeed(f);
            String str = command.what;
            d(fq2Var, str, "playbackRate: " + command.obj, false);
        }
    }
}
