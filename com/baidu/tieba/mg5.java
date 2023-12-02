package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.editortools.meme.list.MemeData;
import com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData;
import com.baidu.tbadk.editortools.meme.pan.SpriteMemePanStateType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class mg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SpriteMemePanStateType a;
    public final SpriteMemeReplyData b;
    public final List<MemeData> c;

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof mg5) {
                mg5 mg5Var = (mg5) obj;
                return this.a == mg5Var.a && Intrinsics.areEqual(this.b, mg5Var.b) && Intrinsics.areEqual(this.c, mg5Var.c);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "SpriteMemePanState(type=" + this.a + ", bubbleData=" + this.b + ", memeDataList=" + this.c + ')';
        }
        return (String) invokeV.objValue;
    }

    public mg5(SpriteMemePanStateType type, SpriteMemeReplyData bubbleData, List<? extends MemeData> memeDataList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {type, bubbleData, memeDataList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(bubbleData, "bubbleData");
        Intrinsics.checkNotNullParameter(memeDataList, "memeDataList");
        this.a = type;
        this.b = bubbleData;
        this.c = memeDataList;
    }

    public final SpriteMemeReplyData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (SpriteMemeReplyData) invokeV.objValue;
    }

    public final List<MemeData> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (List) invokeV.objValue;
    }

    public final SpriteMemePanStateType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (SpriteMemePanStateType) invokeV.objValue;
    }
}
