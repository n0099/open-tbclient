package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tieba.feed.component.uistate.CardPicUiStateKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class q77 extends v77 implements PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q87 d;
    public String e;
    public final Function4<Context, Integer, Rect, String, Unit> f;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof q77) {
                q77 q77Var = (q77) obj;
                return Intrinsics.areEqual(this.d, q77Var.d) && Intrinsics.areEqual(this.e, q77Var.e) && Intrinsics.areEqual(this.f, q77Var.f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (((this.d.hashCode() * 31) + this.e.hashCode()) * 31) + this.f.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "CardPicUiState(cardPicData=" + this.d + ", schema=" + this.e + ", onImageClick=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public q77(q87 cardPicData, String schema, Function4<? super Context, ? super Integer, ? super Rect, ? super String, Unit> onImageClick) {
        super(null, null, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cardPicData, schema, onImageClick};
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
        Intrinsics.checkNotNullParameter(cardPicData, "cardPicData");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(onImageClick, "onImageClick");
        this.d = cardPicData;
        this.e = schema;
        this.f = onImageClick;
    }

    public /* synthetic */ q77(q87 q87Var, String str, Function4 function4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(q87Var, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? CardPicUiStateKt.a : function4);
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            List<y97> list = this.d.a;
            Intrinsics.checkNotNullExpressionValue(list, "cardPicData.picDataList");
            for (y97 y97Var : CollectionsKt___CollectionsKt.take(list, 3)) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.imgUrl = y97Var.a;
                preLoadImageInfo.procType = 13;
                if (this.d.a.size() == 1) {
                    preLoadImageInfo.preloadType = 1;
                } else {
                    preLoadImageInfo.preloadType = 2;
                }
                arrayList.add(preLoadImageInfo);
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final q87 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (q87) invokeV.objValue;
    }

    public final Function4<Context, Integer, Rect, String, Unit> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.f;
        }
        return (Function4) invokeV.objValue;
    }

    public final String j(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i >= this.d.a.size()) {
                return this.e;
            }
            y97 y97Var = this.d.a.get(i);
            String str = y97Var.g;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String str2 = y97Var.g;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            data.scheme\n        }");
                return str2;
            }
            return this.e;
        }
        return (String) invokeI.objValue;
    }
}
