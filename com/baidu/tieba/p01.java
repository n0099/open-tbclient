package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class p01 extends q01 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ArrayList<Object> a;
    public final String b;
    public final Boolean c;
    public final String d;
    public final String e;
    public final String f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof p01) {
                    p01 p01Var = (p01) obj;
                    return Intrinsics.areEqual(this.a, p01Var.a) && Intrinsics.areEqual(this.b, p01Var.b) && Intrinsics.areEqual(b(), p01Var.b()) && Intrinsics.areEqual(c(), p01Var.c()) && Intrinsics.areEqual(e(), p01Var.e()) && Intrinsics.areEqual(a(), p01Var.a());
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ArrayList<Object> arrayList = this.a;
            int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
            String str = this.b;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Boolean b = b();
            int hashCode3 = (hashCode2 + (b != null ? b.hashCode() : 0)) * 31;
            String c = c();
            int hashCode4 = (hashCode3 + (c != null ? c.hashCode() : 0)) * 31;
            String e = e();
            int hashCode5 = (hashCode4 + (e != null ? e.hashCode() : 0)) * 31;
            String a = a();
            return hashCode5 + (a != null ? a.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "AdaptationSet(representationList=" + this.a + ", type=" + this.b + ", frmAlign=" + b() + ", pre=" + c() + ", suf=" + e() + ", codecs=" + a() + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p01(ArrayList<Object> arrayList, String str, Boolean bool, String str2, String str3, String str4) {
        super(bool, str2, str3, str4);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arrayList, str, bool, str2, str3, str4};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Boolean) objArr2[0], (String) objArr2[1], (String) objArr2[2], (String) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = arrayList;
        this.b = str;
        this.c = bool;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ p01(ArrayList arrayList, String str, Boolean bool, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, str, r3, r4, r5, r6);
        String str5;
        String str6;
        String str7;
        Boolean bool2 = (i & 4) != 0 ? null : bool;
        if ((i & 8) != 0) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if ((i & 16) != 0) {
            str6 = "";
        } else {
            str6 = str3;
        }
        if ((i & 32) != 0) {
            str7 = "";
        } else {
            str7 = str4;
        }
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public Boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Boolean) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public final ArrayList<Object> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public final String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }
}
