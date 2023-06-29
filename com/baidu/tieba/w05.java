package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;

    public w05() {
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

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if ("advanced_cert_face_match".equals(this.b)) {
                return 2;
            }
            if ("cert_face_match".equals(this.b)) {
                return 1;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Nullable
    public static w05 b(CheckUserFaceIdResult checkUserFaceIdResult, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, checkUserFaceIdResult, z)) == null) {
            if (checkUserFaceIdResult == null) {
                return null;
            }
            w05 w05Var = new w05();
            w05Var.a = checkUserFaceIdResult.getResultCode();
            w05Var.b = checkUserFaceIdResult.action;
            w05Var.c = checkUserFaceIdResult.status;
            w05Var.d = checkUserFaceIdResult.getResultMsg();
            w05Var.e = checkUserFaceIdResult.livingUname;
            w05Var.f = checkUserFaceIdResult.authsid;
            w05Var.g = checkUserFaceIdResult.authWidgetURL;
            return w05Var;
        }
        return (w05) invokeLZ.objValue;
    }
}
