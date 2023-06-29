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
public class mh4 extends r72<TextureMapView, oy2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<lh4> n;
    public List<kh4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mh4(@NonNull Context context, @NonNull oy2 oy2Var) {
        super(context, oy2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, oy2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (s72) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = oy2Var.c;
        this.j = oy2Var.b;
        String str = oy2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = oy2Var.r;
    }

    public static mh4 K(Context context, oy2 oy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, oy2Var)) == null) {
            if (context != null && oy2Var != null && oy2Var.isValid()) {
                return new mh4(context, oy2Var);
            }
            return null;
        }
        return (mh4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (lh4 lh4Var : this.n) {
                this.l.removeView(lh4Var.e);
            }
            this.n.clear();
            for (kh4 kh4Var : this.o) {
                this.l.removeView(kh4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public kh4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (kh4 kh4Var : this.o) {
                if (kh4Var.b == view2) {
                    return kh4Var;
                }
            }
            return null;
        }
        return (kh4) invokeL.objValue;
    }

    @Nullable
    public lh4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (lh4 lh4Var : this.n) {
                if (marker == lh4Var.b) {
                    return lh4Var;
                }
            }
            return null;
        }
        return (lh4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.r72
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

    public List<lh4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (lh4 lh4Var : this.n) {
                wy2 wy2Var = lh4Var.a;
                if (wy2Var != null && TextUtils.equals(str, wy2Var.a)) {
                    arrayList.add(lh4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
