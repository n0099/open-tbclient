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
public class t94 extends yz1<TextureMapView, vq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<s94> n;
    public List<r94> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t94(@NonNull Context context, @NonNull vq2 vq2Var) {
        super(context, vq2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vq2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (zz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = vq2Var.c;
        this.j = vq2Var.b;
        String str = vq2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = vq2Var.r;
    }

    public static t94 K(Context context, vq2 vq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, vq2Var)) == null) {
            if (context != null && vq2Var != null && vq2Var.isValid()) {
                return new t94(context, vq2Var);
            }
            return null;
        }
        return (t94) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (s94 s94Var : this.n) {
                this.l.removeView(s94Var.e);
            }
            this.n.clear();
            for (r94 r94Var : this.o) {
                this.l.removeView(r94Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public r94 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (r94 r94Var : this.o) {
                if (r94Var.b == view2) {
                    return r94Var;
                }
            }
            return null;
        }
        return (r94) invokeL.objValue;
    }

    @Nullable
    public s94 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (s94 s94Var : this.n) {
                if (marker == s94Var.b) {
                    return s94Var;
                }
            }
            return null;
        }
        return (s94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yz1
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

    public List<s94> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (s94 s94Var : this.n) {
                dr2 dr2Var = s94Var.a;
                if (dr2Var != null && TextUtils.equals(str, dr2Var.a)) {
                    arrayList.add(s94Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
