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
public class jh4 extends o72<TextureMapView, ly2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<ih4> n;
    public List<hh4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jh4(@NonNull Context context, @NonNull ly2 ly2Var) {
        super(context, ly2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ly2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (p72) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = ly2Var.c;
        this.j = ly2Var.b;
        String str = ly2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = ly2Var.r;
    }

    public static jh4 K(Context context, ly2 ly2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ly2Var)) == null) {
            if (context != null && ly2Var != null && ly2Var.isValid()) {
                return new jh4(context, ly2Var);
            }
            return null;
        }
        return (jh4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (ih4 ih4Var : this.n) {
                this.l.removeView(ih4Var.e);
            }
            this.n.clear();
            for (hh4 hh4Var : this.o) {
                this.l.removeView(hh4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public hh4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (hh4 hh4Var : this.o) {
                if (hh4Var.b == view2) {
                    return hh4Var;
                }
            }
            return null;
        }
        return (hh4) invokeL.objValue;
    }

    @Nullable
    public ih4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (ih4 ih4Var : this.n) {
                if (marker == ih4Var.b) {
                    return ih4Var;
                }
            }
            return null;
        }
        return (ih4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o72
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

    public List<ih4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (ih4 ih4Var : this.n) {
                ty2 ty2Var = ih4Var.a;
                if (ty2Var != null && TextUtils.equals(str, ty2Var.a)) {
                    arrayList.add(ih4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
