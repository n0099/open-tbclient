package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
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
public class w84 extends bz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    public TextureMapView l;
    public Context m;
    public List n;
    public List o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w84(Context context, yp2 yp2Var) {
        super(context, yp2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, yp2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (cz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = yp2Var.c;
        this.j = yp2Var.b;
        String str = yp2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = yp2Var.r;
    }

    public static w84 K(Context context, yp2 yp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, yp2Var)) == null) {
            if (context != null && yp2Var != null && yp2Var.isValid()) {
                return new w84(context, yp2Var);
            }
            return null;
        }
        return (w84) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (v84 v84Var : this.n) {
                this.l.removeView(v84Var.e);
            }
            this.n.clear();
            for (u84 u84Var : this.o) {
                this.l.removeView(u84Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public u84 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (u84 u84Var : this.o) {
                if (u84Var.b == view2) {
                    return u84Var;
                }
            }
            return null;
        }
        return (u84) invokeL.objValue;
    }

    public v84 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (v84 v84Var : this.n) {
                if (marker == v84Var.b) {
                    return v84Var;
                }
            }
            return null;
        }
        return (v84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bz1
    /* renamed from: J */
    public TextureMapView v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            return this.l;
        }
        return (TextureMapView) invokeL.objValue;
    }

    public List I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (v84 v84Var : this.n) {
                gq2 gq2Var = v84Var.a;
                if (gq2Var != null && TextUtils.equals(str, gq2Var.a)) {
                    arrayList.add(v84Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
