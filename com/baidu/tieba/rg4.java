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
/* loaded from: classes7.dex */
public class rg4 extends w62<TextureMapView, tx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<qg4> n;
    public List<pg4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rg4(@NonNull Context context, @NonNull tx2 tx2Var) {
        super(context, tx2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tx2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (x62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = tx2Var.c;
        this.j = tx2Var.b;
        String str = tx2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = tx2Var.r;
    }

    public static rg4 K(Context context, tx2 tx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, tx2Var)) == null) {
            if (context != null && tx2Var != null && tx2Var.isValid()) {
                return new rg4(context, tx2Var);
            }
            return null;
        }
        return (rg4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (qg4 qg4Var : this.n) {
                this.l.removeView(qg4Var.e);
            }
            this.n.clear();
            for (pg4 pg4Var : this.o) {
                this.l.removeView(pg4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public pg4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (pg4 pg4Var : this.o) {
                if (pg4Var.b == view2) {
                    return pg4Var;
                }
            }
            return null;
        }
        return (pg4) invokeL.objValue;
    }

    @Nullable
    public qg4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (qg4 qg4Var : this.n) {
                if (marker == qg4Var.b) {
                    return qg4Var;
                }
            }
            return null;
        }
        return (qg4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w62
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

    public List<qg4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (qg4 qg4Var : this.n) {
                by2 by2Var = qg4Var.a;
                if (by2Var != null && TextUtils.equals(str, by2Var.a)) {
                    arrayList.add(qg4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
