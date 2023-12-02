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
/* loaded from: classes8.dex */
public class ub4 extends a22<TextureMapView, ws2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<tb4> n;
    public List<sb4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ub4(@NonNull Context context, @NonNull ws2 ws2Var) {
        super(context, ws2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ws2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (b22) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = ws2Var.c;
        this.j = ws2Var.b;
        String str = ws2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = ws2Var.r;
    }

    public static ub4 M(Context context, ws2 ws2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ws2Var)) == null) {
            if (context != null && ws2Var != null && ws2Var.isValid()) {
                return new ub4(context, ws2Var);
            }
            return null;
        }
        return (ub4) invokeLL.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (tb4 tb4Var : this.n) {
                this.l.removeView(tb4Var.e);
            }
            this.n.clear();
            for (sb4 sb4Var : this.o) {
                this.l.removeView(sb4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public sb4 I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (sb4 sb4Var : this.o) {
                if (sb4Var.b == view2) {
                    return sb4Var;
                }
            }
            return null;
        }
        return (sb4) invokeL.objValue;
    }

    @Nullable
    public tb4 J(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (tb4 tb4Var : this.n) {
                if (marker == tb4Var.b) {
                    return tb4Var;
                }
            }
            return null;
        }
        return (tb4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a22
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

    public List<tb4> K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (tb4 tb4Var : this.n) {
                et2 et2Var = tb4Var.a;
                if (et2Var != null && TextUtils.equals(str, et2Var.a)) {
                    arrayList.add(tb4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
