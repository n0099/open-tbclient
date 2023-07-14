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
/* loaded from: classes7.dex */
public final class o77 extends m77 implements s77, mb7, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final x97 d;
    public final y97 e;
    public final List<u97> f;
    public final Function3<Context, Rect, y97, Unit> g;
    public SpannableString h;
    public t77 i;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof o77) {
                o77 o77Var = (o77) obj;
                return Intrinsics.areEqual(this.d, o77Var.d) && Intrinsics.areEqual(this.e, o77Var.e) && Intrinsics.areEqual(this.f, o77Var.f) && Intrinsics.areEqual(this.g, o77Var.g);
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
    public o77(x97 videoData, y97 schemaData, List<u97> statDataList, Function3<? super Context, ? super Rect, ? super y97, Unit> onVideoClick) {
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

    public /* synthetic */ o77(x97 x97Var, y97 y97Var, List list, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(x97Var, y97Var, (i & 4) != 0 ? new ArrayList() : list, (i & 8) != 0 ? CardVideoUiStateKt.a() : function3);
    }

    @Override // com.baidu.tieba.s77
    public boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            t77 t77Var = this.i;
            if (t77Var != null) {
                this.g.invoke(context, t77Var.a(), this.e);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.mb7
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

    public final void n(t77 t77Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, t77Var) == null) {
            this.i = t77Var;
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

    public final Function3<Context, Rect, y97, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.g;
        }
        return (Function3) invokeV.objValue;
    }

    public final y97 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (y97) invokeV.objValue;
    }

    public final List<u97> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public final x97 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.d;
        }
        return (x97) invokeV.objValue;
    }
}
