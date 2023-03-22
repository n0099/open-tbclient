package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class pp2 extends nl2<eq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.nl2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setDataSource" : (String) invokeV.objValue;
    }

    public pp2() {
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
    @Override // com.baidu.tieba.nl2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull eq2 eq2Var) {
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, eq2Var) != null) || (obj = command.obj) == null) {
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        if (command.arg1 != 0) {
            z = true;
        } else {
            z = false;
        }
        String str = (String) arrayList.get(0);
        String f = pg3.l().f(str, (String) arrayList.get(1));
        command.ret = eq2Var.O(str, f, (String) arrayList.get(2), z) ? 1 : 0;
        String str2 = command.what;
        d(eq2Var, str2, "DataSource: " + str + " ;UserAgent: " + ((String) arrayList.get(2)) + " ;Cookies: " + f + ";hideUrlLog: " + z, true);
    }
}
