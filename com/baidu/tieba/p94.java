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
/* loaded from: classes5.dex */
public class p94 extends uz1<TextureMapView, rq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<o94> n;
    public List<n94> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p94(@NonNull Context context, @NonNull rq2 rq2Var) {
        super(context, rq2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, rq2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (vz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = rq2Var.c;
        this.j = rq2Var.b;
        String str = rq2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = rq2Var.r;
    }

    public static p94 K(Context context, rq2 rq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, rq2Var)) == null) {
            if (context != null && rq2Var != null && rq2Var.isValid()) {
                return new p94(context, rq2Var);
            }
            return null;
        }
        return (p94) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (o94 o94Var : this.n) {
                this.l.removeView(o94Var.e);
            }
            this.n.clear();
            for (n94 n94Var : this.o) {
                this.l.removeView(n94Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public n94 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (n94 n94Var : this.o) {
                if (n94Var.b == view2) {
                    return n94Var;
                }
            }
            return null;
        }
        return (n94) invokeL.objValue;
    }

    @Nullable
    public o94 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (o94 o94Var : this.n) {
                if (marker == o94Var.b) {
                    return o94Var;
                }
            }
            return null;
        }
        return (o94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.uz1
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

    public List<o94> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (o94 o94Var : this.n) {
                zq2 zq2Var = o94Var.a;
                if (zq2Var != null && TextUtils.equals(str, zq2Var.a)) {
                    arrayList.add(o94Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
