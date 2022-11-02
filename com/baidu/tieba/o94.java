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
public class o94 extends tz1<TextureMapView, qq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<n94> n;
    public List<m94> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o94(@NonNull Context context, @NonNull qq2 qq2Var) {
        super(context, qq2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, qq2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (uz1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = qq2Var.c;
        this.j = qq2Var.b;
        String str = qq2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = qq2Var.r;
    }

    public static o94 K(Context context, qq2 qq2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, qq2Var)) == null) {
            if (context != null && qq2Var != null && qq2Var.isValid()) {
                return new o94(context, qq2Var);
            }
            return null;
        }
        return (o94) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (n94 n94Var : this.n) {
                this.l.removeView(n94Var.e);
            }
            this.n.clear();
            for (m94 m94Var : this.o) {
                this.l.removeView(m94Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public m94 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (m94 m94Var : this.o) {
                if (m94Var.b == view2) {
                    return m94Var;
                }
            }
            return null;
        }
        return (m94) invokeL.objValue;
    }

    @Nullable
    public n94 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (n94 n94Var : this.n) {
                if (marker == n94Var.b) {
                    return n94Var;
                }
            }
            return null;
        }
        return (n94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tz1
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

    public List<n94> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (n94 n94Var : this.n) {
                yq2 yq2Var = n94Var.a;
                if (yq2Var != null && TextUtils.equals(str, yq2Var.a)) {
                    arrayList.add(n94Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
