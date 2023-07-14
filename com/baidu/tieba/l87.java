package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class l87 extends z77 implements d97, mb7, PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.mc7
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "common_card" : (String) invokeV.objValue;
    }

    public l87() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.mb7
    public void d(@NonNull Object obj) {
        e87<?> e87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) && (e87Var = this.c) != null) {
            e87Var.d(obj);
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<PreLoadImageInfo> images;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.c != null) {
                ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
                for (mc7<? extends Object> mc7Var : this.c.b()) {
                    if ((mc7Var instanceof PreLoadImageProvider) && (images = ((PreLoadImageProvider) mc7Var).getImages()) != null && images.size() > 0) {
                        arrayList.addAll(images);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d97
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            for (mc7<? extends Object> mc7Var : this.c.b()) {
                if (mc7Var.b() instanceof d97) {
                    ((d97) mc7Var.b()).setPosition(i);
                }
            }
        }
    }
}
