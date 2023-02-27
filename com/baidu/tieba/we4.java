package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class we4 extends b52<TextureMapView, yv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<ve4> n;
    public List<ue4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public we4(@NonNull Context context, @NonNull yv2 yv2Var) {
        super(context, yv2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, yv2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c52) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = yv2Var.c;
        this.j = yv2Var.b;
        String str = yv2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = yv2Var.r;
    }

    public static we4 K(Context context, yv2 yv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, yv2Var)) == null) {
            if (context != null && yv2Var != null && yv2Var.isValid()) {
                return new we4(context, yv2Var);
            }
            return null;
        }
        return (we4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (ve4 ve4Var : this.n) {
                this.l.removeView(ve4Var.e);
            }
            this.n.clear();
            for (ue4 ue4Var : this.o) {
                this.l.removeView(ue4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public ue4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (ue4 ue4Var : this.o) {
                if (ue4Var.b == view2) {
                    return ue4Var;
                }
            }
            return null;
        }
        return (ue4) invokeL.objValue;
    }

    @Nullable
    public ve4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (ve4 ve4Var : this.n) {
                if (marker == ve4Var.b) {
                    return ve4Var;
                }
            }
            return null;
        }
        return (ve4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b52
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return this.l;
        }
        return (TextureMapView) invokeL.objValue;
    }

    public List<ve4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (ve4 ve4Var : this.n) {
                gw2 gw2Var = ve4Var.a;
                if (gw2Var != null && TextUtils.equals(str, gw2Var.a)) {
                    arrayList.add(ve4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
