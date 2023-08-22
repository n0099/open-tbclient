package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.component.uistate.CardVideoUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class l67 extends j67 implements p67, ja7, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final u87 d;
    public final v87 e;
    public final List<r87> f;
    public final Function3<Context, Rect, v87, Unit> g;
    public SpannableString h;
    public q67 i;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof l67) {
                l67 l67Var = (l67) obj;
                return Intrinsics.areEqual(this.d, l67Var.d) && Intrinsics.areEqual(this.e, l67Var.e) && Intrinsics.areEqual(this.f, l67Var.f) && Intrinsics.areEqual(this.g, l67Var.g);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (((((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return "CardVideoUiState(videoData=" + this.d + ", schemaData=" + this.e + ", statDataList=" + this.f + ", onVideoClick=" + this.g + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l67(u87 videoData, v87 schemaData, List<r87> statDataList, Function3<? super Context, ? super Rect, ? super v87, Unit> onVideoClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoData, schemaData, statDataList, onVideoClick};
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
        Intrinsics.checkNotNullParameter(videoData, "videoData");
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Intrinsics.checkNotNullParameter(statDataList, "statDataList");
        Intrinsics.checkNotNullParameter(onVideoClick, "onVideoClick");
        this.d = videoData;
        this.e = schemaData;
        this.f = statDataList;
        this.g = onVideoClick;
        this.h = new SpannableString("");
    }

    public /* synthetic */ l67(u87 u87Var, v87 v87Var, List list, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(u87Var, v87Var, (i & 4) != 0 ? new ArrayList() : list, (i & 8) != 0 ? CardVideoUiStateKt.a() : function3);
    }

    @Override // com.baidu.tieba.p67
    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            q67 q67Var = this.i;
            if (q67Var != null) {
                this.g.invoke(context, q67Var.a(), this.e);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ja7
    public void d(Object event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.e.d(event);
        }
    }

    public final void m(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, spannableString) == null) {
            Intrinsics.checkNotNullParameter(spannableString, "<set-?>");
            this.h = spannableString;
        }
    }

    public final void n(q67 q67Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, q67Var) == null) {
            this.i = q67Var;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
            preLoadImageInfo.imgUrl = this.d.a;
            preLoadImageInfo.procType = 10;
            preLoadImageInfo.preloadType = 1;
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            arrayList.add(preLoadImageInfo);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final SpannableString h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (SpannableString) invokeV.objValue;
    }

    public final Function3<Context, Rect, v87, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (Function3) invokeV.objValue;
    }

    public final v87 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (v87) invokeV.objValue;
    }

    public final List<r87> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public final u87 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (u87) invokeV.objValue;
    }
}
