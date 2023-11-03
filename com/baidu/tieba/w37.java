package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.component.uistate.CardHeadUiStateKt;
import com.baidu.tieba.feed.helper.CommonOnClickKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class w37 extends h47 implements w97, za7<w37>, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g57 g;
    public final b67 h;
    public final pd7 i;
    public final od7 j;
    public final String k;
    public final Map<String, String> l;
    public final Map<String, String> m;
    public final List<m77> n;
    public final boolean o;
    public final Function3<View, String, w37, Unit> p;
    public final Function3<View, t57, w37, Unit> q;
    public final Function2<b67, View, Unit> r;

    @Override // com.baidu.tieba.za7
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
            if (obj instanceof w37) {
                w37 w37Var = (w37) obj;
                return Intrinsics.areEqual(this.g, w37Var.g) && Intrinsics.areEqual(this.h, w37Var.h) && Intrinsics.areEqual(this.i, w37Var.i) && Intrinsics.areEqual(this.j, w37Var.j) && Intrinsics.areEqual(this.k, w37Var.k) && Intrinsics.areEqual(this.l, w37Var.l) && Intrinsics.areEqual(this.m, w37Var.m) && Intrinsics.areEqual(this.n, w37Var.n) && this.o == w37Var.o && Intrinsics.areEqual(this.p, w37Var.p) && Intrinsics.areEqual(this.q, w37Var.q) && Intrinsics.areEqual(this.r, w37Var.r);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v17, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int hashCode = this.g.hashCode() * 31;
            b67 b67Var = this.h;
            int hashCode2 = (hashCode + (b67Var == null ? 0 : b67Var.hashCode())) * 31;
            pd7 pd7Var = this.i;
            int hashCode3 = (hashCode2 + (pd7Var == null ? 0 : pd7Var.hashCode())) * 31;
            od7 od7Var = this.j;
            int hashCode4 = (hashCode3 + (od7Var == null ? 0 : od7Var.hashCode())) * 31;
            String str = this.k;
            int hashCode5 = (((((((hashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31;
            boolean z = this.o;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return ((((((hashCode5 + i) * 31) + this.p.hashCode()) * 31) + this.q.hashCode()) * 31) + this.r.hashCode();
        }
        return invokeV.intValue;
    }

    public w37 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this : (w37) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return "CardHeadUiState(headData=" + this.g + ", feedBackData=" + this.h + ", personAttentionUiState=" + this.i + ", forumAttentionUiState=" + this.j + ", schema=" + this.k + ", businessInfoMap=" + this.l + ", logInfoMap=" + this.m + ", statDataList=" + this.n + ", hasThemeCard=" + this.o + ", onImageClick=" + this.p + ", onTagClick=" + this.q + ", onFeedBackClick=" + this.r + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public w37(g57 headData, b67 b67Var, pd7 pd7Var, od7 od7Var, String str, Map<String, String> businessInfoMap, Map<String, String> logInfoMap, List<m77> statDataList, boolean z, Function3<? super View, ? super String, ? super w37, Unit> onImageClick, Function3<? super View, ? super t57, ? super w37, Unit> onTagClick, Function2<? super b67, ? super View, Unit> onFeedBackClick) {
        super(businessInfoMap, logInfoMap, null, null, 12, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {headData, b67Var, pd7Var, od7Var, str, businessInfoMap, logInfoMap, statDataList, Boolean.valueOf(z), onImageClick, onTagClick, onFeedBackClick};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Map) objArr2[0], (Map) objArr2[1], (Function2) objArr2[2], (Function1) objArr2[3], ((Integer) objArr2[4]).intValue(), (DefaultConstructorMarker) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(headData, "headData");
        Intrinsics.checkNotNullParameter(businessInfoMap, "businessInfoMap");
        Intrinsics.checkNotNullParameter(logInfoMap, "logInfoMap");
        Intrinsics.checkNotNullParameter(statDataList, "statDataList");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        Intrinsics.checkNotNullParameter(onTagClick, "onTagClick");
        Intrinsics.checkNotNullParameter(onFeedBackClick, "onFeedBackClick");
        this.g = headData;
        this.h = b67Var;
        this.i = pd7Var;
        this.j = od7Var;
        this.k = str;
        this.l = businessInfoMap;
        this.m = logInfoMap;
        this.n = statDataList;
        this.o = z;
        this.p = onImageClick;
        this.q = onTagClick;
        this.r = onFeedBackClick;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ w37(g57 g57Var, b67 b67Var, pd7 pd7Var, od7 od7Var, String str, Map map, Map map2, List list, boolean z, Function3 function3, Function3 function32, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(g57Var, b67Var, pd7Var, od7Var, str, r8, r9, r10, r11, r12, r13, r14);
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        ArrayList arrayList;
        boolean z2;
        Function3 function33;
        Function3 function34;
        Function2<b67, View, Unit> function22;
        Function3 function35;
        Function3 function36;
        if ((i & 32) != 0) {
            linkedHashMap = new LinkedHashMap();
        } else {
            linkedHashMap = map;
        }
        if ((i & 64) != 0) {
            linkedHashMap2 = new LinkedHashMap();
        } else {
            linkedHashMap2 = map2;
        }
        if ((i & 128) != 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        if ((i & 256) != 0) {
            z2 = false;
        } else {
            z2 = z;
        }
        if ((i & 512) != 0) {
            function36 = CardHeadUiStateKt.a;
            function33 = function36;
        } else {
            function33 = function3;
        }
        if ((i & 1024) != 0) {
            function35 = CardHeadUiStateKt.b;
            function34 = function35;
        } else {
            function34 = function32;
        }
        if ((i & 2048) != 0) {
            function22 = CommonOnClickKt.a();
        } else {
            function22 = function2;
        }
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.za7
    public /* bridge */ /* synthetic */ w37 b() {
        l();
        return this;
    }

    public final b67 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (b67) invokeV.objValue;
    }

    public final od7 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (od7) invokeV.objValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public final g57 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.g;
        }
        return (g57) invokeV.objValue;
    }

    public final Function2<b67, View, Unit> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.r;
        }
        return (Function2) invokeV.objValue;
    }

    public final Function3<View, String, w37, Unit> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.p;
        }
        return (Function3) invokeV.objValue;
    }

    public final Function3<View, t57, w37, Unit> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.q;
        }
        return (Function3) invokeV.objValue;
    }

    public final pd7 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return (pd7) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public final List<m77> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.n;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.w97
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            pd7 pd7Var = this.i;
            if (pd7Var != null) {
                pd7Var.d(event);
            }
            od7 od7Var = this.j;
            if (od7Var != null) {
                od7Var.d(event);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = this.g.b().c();
            preLoadImageInfo.procType = 28;
            preLoadImageInfo.preloadType = 3;
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }
}
