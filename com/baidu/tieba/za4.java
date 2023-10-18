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
/* loaded from: classes9.dex */
public class za4 extends f12<TextureMapView, bs2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<ya4> n;
    public List<xa4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public za4(@NonNull Context context, @NonNull bs2 bs2Var) {
        super(context, bs2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bs2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (g12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = bs2Var.c;
        this.j = bs2Var.b;
        String str = bs2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = bs2Var.r;
    }

    public static za4 M(Context context, bs2 bs2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, bs2Var)) == null) {
            if (context != null && bs2Var != null && bs2Var.isValid()) {
                return new za4(context, bs2Var);
            }
            return null;
        }
        return (za4) invokeLL.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (ya4 ya4Var : this.n) {
                this.l.removeView(ya4Var.e);
            }
            this.n.clear();
            for (xa4 xa4Var : this.o) {
                this.l.removeView(xa4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public xa4 I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (xa4 xa4Var : this.o) {
                if (xa4Var.b == view2) {
                    return xa4Var;
                }
            }
            return null;
        }
        return (xa4) invokeL.objValue;
    }

    @Nullable
    public ya4 J(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (ya4 ya4Var : this.n) {
                if (marker == ya4Var.b) {
                    return ya4Var;
                }
            }
            return null;
        }
        return (ya4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f12
    @NonNull
    /* renamed from: L */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return this.l;
        }
        return (TextureMapView) invokeL.objValue;
    }

    public List<ya4> K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (ya4 ya4Var : this.n) {
                js2 js2Var = ya4Var.a;
                if (js2Var != null && TextUtils.equals(str, js2Var.a)) {
                    arrayList.add(ya4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
