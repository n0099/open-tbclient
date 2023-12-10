package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.forum.secondfloor.SecondFloorVisitHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ni7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qi7 a;
    public final zi7 b;
    public final List<mi7> c;
    public final mi7 d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public mi7 i;
    public boolean j;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ni7) {
                ni7 ni7Var = (ni7) obj;
                return Intrinsics.areEqual(this.a, ni7Var.a) && Intrinsics.areEqual(this.b, ni7Var.b) && Intrinsics.areEqual(this.c, ni7Var.c) && Intrinsics.areEqual(this.d, ni7Var.d) && Intrinsics.areEqual(this.e, ni7Var.e) && Intrinsics.areEqual(this.f, ni7Var.f) && Intrinsics.areEqual(this.g, ni7Var.g) && Intrinsics.areEqual(this.h, ni7Var.h);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            zi7 zi7Var = this.b;
            int hashCode2 = (hashCode + (zi7Var == null ? 0 : zi7Var.hashCode())) * 31;
            List<mi7> list = this.c;
            int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
            mi7 mi7Var = this.d;
            int hashCode4 = (((hashCode3 + (mi7Var == null ? 0 : mi7Var.hashCode())) * 31) + this.e.hashCode()) * 31;
            String str = this.f;
            int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.g;
            int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.h;
            return hashCode6 + (str3 != null ? str3.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return "AiChatroomGuideInfoData(defaultGuideInfo=" + this.a + ", newGuideInfo=" + this.b + ", aiBotList=" + this.c + ", defaultBot=" + this.d + ", titleImg=" + this.e + ", navBtnIcon=" + this.f + ", secondFloorTopImage=" + this.g + ", aiPageUrl=" + this.h + ')';
        }
        return (String) invokeV.objValue;
    }

    public ni7(qi7 defaultGuideInfo, zi7 zi7Var, List<mi7> list, mi7 mi7Var, String titleImg, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultGuideInfo, zi7Var, list, mi7Var, titleImg, str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultGuideInfo, "defaultGuideInfo");
        Intrinsics.checkNotNullParameter(titleImg, "titleImg");
        this.a = defaultGuideInfo;
        this.b = zi7Var;
        this.c = list;
        this.d = mi7Var;
        this.e = titleImg;
        this.f = str;
        this.g = str2;
        this.h = str3;
        this.j = true;
    }

    public final List<mi7> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final qi7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (qi7) invokeV.objValue;
    }

    public final String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final zi7 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (zi7) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.b != null || (!this.a.a().isEmpty()) || this.d != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(String fid) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fid) == null) {
            Intrinsics.checkNotNullParameter(fid, "fid");
            SecondFloorVisitHelper secondFloorVisitHelper = SecondFloorVisitHelper.a;
            zi7 zi7Var = this.b;
            if (zi7Var != null) {
                str = zi7Var.a();
            } else {
                str = null;
            }
            this.j = secondFloorVisitHelper.a(fid, str);
        }
    }

    public final void h(mi7 mi7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mi7Var) == null) {
            this.i = mi7Var;
        }
    }

    public final oi7 i() {
        InterceptResult invokeV;
        String b;
        List list;
        String str;
        String str2;
        zi7 zi7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            mi7 mi7Var = this.i;
            if (mi7Var == null) {
                zi7 zi7Var2 = this.b;
                if (zi7Var2 != null) {
                    mi7Var = zi7Var2.d();
                } else {
                    mi7Var = null;
                }
                if (mi7Var == null) {
                    List<mi7> list2 = this.c;
                    if (list2 != null) {
                        mi7Var = (mi7) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    } else {
                        mi7Var = null;
                    }
                    if (mi7Var == null && (mi7Var = this.d) == null) {
                        return null;
                    }
                }
            }
            mi7 mi7Var2 = mi7Var;
            if (this.j && (zi7Var = this.b) != null) {
                b = zi7Var.c();
                list = CollectionsKt__CollectionsKt.arrayListOf(this.b.d());
            } else {
                b = this.a.b();
                list = this.c;
                if (list == null) {
                    list = new ArrayList();
                }
            }
            String str3 = b;
            List list3 = list;
            String str4 = this.g;
            if (str4 == null) {
                str = "";
            } else {
                str = str4;
            }
            String str5 = this.e;
            String str6 = this.h;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            return new oi7(list3, mi7Var2, str3, str, str5, str2);
        }
        return (oi7) invokeV.objValue;
    }
}
