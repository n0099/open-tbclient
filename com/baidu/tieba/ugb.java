package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.ghb;
import com.baidu.tieba.write.webwrite.fragment.BaseWebWriteFragment;
import com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ugb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseWebWriteFragment a;
    public boolean b;
    public yfb c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public Boolean h;
    public String i;
    public JSONObject j;
    public BaseDraftBiz.b k;
    public ghb.b l;
    public Function1<? super ImageFileInfo, Unit> m;

    public ugb(BaseWebWriteFragment fragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.a = fragment;
        this.g = true;
        this.i = "";
    }

    public final void r(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && str != null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_draft_fid_" + this.a.m3()), str);
        }
    }

    public static /* synthetic */ void d(ugb ugbVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        ugbVar.c(i);
    }

    public final void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.d = z;
        }
    }

    public final void B(ghb.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.l = bVar;
        }
    }

    public final void C(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
            this.j = jSONObject;
        }
    }

    public final void D(yfb yfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yfbVar) == null) {
            Intrinsics.checkNotNullParameter(yfbVar, "<set-?>");
            this.c = yfbVar;
        }
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a.d3(i);
        }
    }

    public final void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.e = z;
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.f = z;
        }
    }

    public final void u(BaseDraftBiz.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.k = bVar;
        }
    }

    public final void v(Function1<? super ImageFileInfo, Unit> function1) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, function1) == null) {
            this.m = function1;
        }
    }

    public final void w(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bool) == null) {
            this.h = bool;
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.b = z;
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.g = z;
        }
    }

    public final void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.i = str;
        }
    }

    public final String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a.m3();
        }
        return (String) invokeV.objValue;
    }

    public final int F() {
        InterceptResult invokeV;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b = vgb.b(this.a.m3());
            return b;
        }
        return invokeV.intValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.a3();
        }
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final BaseDraftBiz.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            BaseDraftBiz.b bVar = this.k;
            if (bVar != null) {
                return bVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("draftListener");
            return null;
        }
        return (BaseDraftBiz.b) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super com.baidu.tbadk.img.ImageFileInfo, kotlin.Unit>, kotlin.jvm.functions.Function1<com.baidu.tbadk.img.ImageFileInfo, kotlin.Unit> */
    public final Function1<ImageFileInfo, Unit> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.m;
        }
        return (Function1) invokeV.objValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public final ghb.b l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            ghb.b bVar = this.l;
            if (bVar != null) {
                return bVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("postListener");
            return null;
        }
        return (ghb.b) invokeV.objValue;
    }

    public final JSONObject m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.j;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final yfb n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            yfb yfbVar = this.c;
            if (yfbVar != null) {
                return yfbVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("writePageStateObserver");
            return null;
        }
        return (yfb) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.a.r3();
        }
    }

    public final Boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.h;
        }
        return (Boolean) invokeV.objValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            sharedPrefHelper.putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_draft_fid_" + this.a.m3()), "");
        }
    }
}
