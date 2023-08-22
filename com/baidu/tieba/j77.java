package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final a77 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j77() {
        this(null, null, null, null, null, null, 63, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (a77) objArr[5], ((Integer) objArr[6]).intValue(), (DefaultConstructorMarker) objArr[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public j77(String type, String icon, String guideText, String buttonText, String schema, a77 businessInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type, icon, guideText, buttonText, schema, businessInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(guideText, "guideText");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
        this.a = type;
        this.b = businessInfo;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ j77(String str, String str2, String str3, String str4, String str5, a77 a77Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r12, r1, r2, r3, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? new a77() : a77Var);
        String str6;
        String str7;
        String str8;
        String str9;
        if ((i & 1) != 0) {
            str6 = "";
        } else {
            str6 = str;
        }
        if ((i & 2) != 0) {
            str7 = "";
        } else {
            str7 = str2;
        }
        if ((i & 4) != 0) {
            str8 = "";
        } else {
            str8 = str3;
        }
        if ((i & 8) != 0) {
            str9 = "";
        } else {
            str9 = str4;
        }
    }

    public final a77 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (a77) invokeV.objValue;
    }

    public final String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
