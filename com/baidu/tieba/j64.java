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
/* loaded from: classes4.dex */
public class j64 extends pw1<TextureMapView, mn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<i64> n;
    public List<h64> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j64(@NonNull Context context, @NonNull mn2 mn2Var) {
        super(context, mn2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, mn2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (qw1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = mn2Var.c;
        this.j = mn2Var.b;
        String str = mn2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = mn2Var.r;
    }

    public static j64 K(Context context, mn2 mn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, mn2Var)) == null) {
            if (context == null || mn2Var == null || !mn2Var.isValid()) {
                return null;
            }
            return new j64(context, mn2Var);
        }
        return (j64) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (i64 i64Var : this.n) {
                this.l.removeView(i64Var.e);
            }
            this.n.clear();
            for (h64 h64Var : this.o) {
                this.l.removeView(h64Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public h64 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (h64 h64Var : this.o) {
                if (h64Var.b == view2) {
                    return h64Var;
                }
            }
            return null;
        }
        return (h64) invokeL.objValue;
    }

    @Nullable
    public i64 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (i64 i64Var : this.n) {
                if (marker == i64Var.b) {
                    return i64Var;
                }
            }
            return null;
        }
        return (i64) invokeL.objValue;
    }

    public List<i64> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (i64 i64Var : this.n) {
                un2 un2Var = i64Var.a;
                if (un2Var != null && TextUtils.equals(str, un2Var.a)) {
                    arrayList.add(i64Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pw1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
