package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class z57 extends j67 implements ja7, jb7<z57>, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c77 d;
    public final r77 e;
    public final sd7 f;
    public final rd7 g;
    public final String h;
    public final List<r87> i;
    public final Function2<View, String, Unit> j;
    public final Function2<View, String, Unit> k;
    public final Function2<r77, View, Unit> l;

    @Override // com.baidu.tieba.jb7
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "feed_head" : (String) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof z57) {
                z57 z57Var = (z57) obj;
                return Intrinsics.areEqual(this.d, z57Var.d) && Intrinsics.areEqual(this.e, z57Var.e) && Intrinsics.areEqual(this.f, z57Var.f) && Intrinsics.areEqual(this.g, z57Var.g) && Intrinsics.areEqual(this.h, z57Var.h) && Intrinsics.areEqual(this.i, z57Var.i) && Intrinsics.areEqual(this.j, z57Var.j) && Intrinsics.areEqual(this.k, z57Var.k) && Intrinsics.areEqual(this.l, z57Var.l);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public z57 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this : (z57) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int hashCode = this.d.hashCode() * 31;
            r77 r77Var = this.e;
            int hashCode2 = (hashCode + (r77Var == null ? 0 : r77Var.hashCode())) * 31;
            sd7 sd7Var = this.f;
            int hashCode3 = (hashCode2 + (sd7Var == null ? 0 : sd7Var.hashCode())) * 31;
            rd7 rd7Var = this.g;
            int hashCode4 = (hashCode3 + (rd7Var == null ? 0 : rd7Var.hashCode())) * 31;
            String str = this.h;
            return ((((((((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return "CardHeadUiState(headData=" + this.d + ", feedBackData=" + this.e + ", personAttentionUiState=" + this.f + ", forumAttentionUiState=" + this.g + ", schema=" + this.h + ", statDataList=" + this.i + ", onItemClick=" + this.j + ", onImageClick=" + this.k + ", onFeedBackClick=" + this.l + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public z57(c77 headData, r77 r77Var, sd7 sd7Var, rd7 rd7Var, String str, List<r87> statDataList, Function2<? super View, ? super String, Unit> onItemClick, Function2<? super View, ? super String, Unit> onImageClick, Function2<? super r77, ? super View, Unit> onFeedBackClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {headData, r77Var, sd7Var, rd7Var, str, statDataList, onItemClick, onImageClick, onFeedBackClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Function2) objArr2[0], (Function1) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(statDataList, "statDataList");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        Intrinsics.checkNotNullParameter(onFeedBackClick, "onFeedBackClick");
        this.d = headData;
        this.e = r77Var;
        this.f = sd7Var;
        this.g = rd7Var;
        this.h = str;
        this.i = statDataList;
        this.j = onItemClick;
        this.k = onImageClick;
        this.l = onFeedBackClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ z57(c77 c77Var, r77 r77Var, sd7 sd7Var, rd7 rd7Var, String str, List list, Function2 function2, Function2 function22, Function2 function23, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c77Var, r77Var, sd7Var, rd7Var, str, r8, r9, r10, r11);
        ArrayList arrayList;
        Function2<View, String, Unit> function24;
        Function2<View, String, Unit> function25;
        Function2<r77, View, Unit> function26;
        if ((i & 32) != 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        if ((i & 64) != 0) {
            function24 = CommonOnClickKt.b();
        } else {
            function24 = function2;
        }
        if ((i & 128) != 0) {
            function25 = CommonOnClickKt.b();
        } else {
            function25 = function22;
        }
        if ((i & 256) != 0) {
            function26 = CommonOnClickKt.a();
        } else {
            function26 = function23;
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.jb7
    public /* bridge */ /* synthetic */ z57 b() {
        h();
        return this;
    }

    public final r77 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (r77) invokeV.objValue;
    }

    public final rd7 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (rd7) invokeV.objValue;
    }

    public final c77 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (c77) invokeV.objValue;
    }

    public final Function2<r77, View, Unit> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, String, Unit> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function2<View, String, Unit> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j;
        }
        return (Function2) invokeV.objValue;
    }

    public final sd7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f;
        }
        return (sd7) invokeV.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public final List<r87> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ja7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            sd7 sd7Var = this.f;
            if (sd7Var != null) {
                sd7Var.d(event);
            }
            rd7 rd7Var = this.g;
            if (rd7Var != null) {
                rd7Var.d(event);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = this.d.b().c();
            preLoadImageInfo.procType = 28;
            preLoadImageInfo.preloadType = 3;
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
