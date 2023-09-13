package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes6.dex */
public class ir2 extends bp2<sr2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bp2
    @NonNull
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "setSoundModel" : (String) invokeV.objValue;
    }

    public ir2() {
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
    @Override // com.baidu.tieba.bp2
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull sr2 sr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, command, sr2Var) == null) {
            String str = command.what;
            d(sr2Var, str, "" + command.obj, true);
            Object obj = command.obj;
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (TextUtils.equals(str2, "ear")) {
                    sr2Var.r(str2);
                } else if (TextUtils.equals(str2, "speaker")) {
                    sr2Var.r(str2);
                }
            }
        }
    }
}
