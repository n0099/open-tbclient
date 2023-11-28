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
public class rb4 extends x12<TextureMapView, ts2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<qb4> n;
    public List<pb4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rb4(@NonNull Context context, @NonNull ts2 ts2Var) {
        super(context, ts2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ts2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (y12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = ts2Var.c;
        this.j = ts2Var.b;
        String str = ts2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = ts2Var.r;
    }

    public static rb4 M(Context context, ts2 ts2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ts2Var)) == null) {
            if (context != null && ts2Var != null && ts2Var.isValid()) {
                return new rb4(context, ts2Var);
            }
            return null;
        }
        return (rb4) invokeLL.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (qb4 qb4Var : this.n) {
                this.l.removeView(qb4Var.e);
            }
            this.n.clear();
            for (pb4 pb4Var : this.o) {
                this.l.removeView(pb4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public pb4 I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (pb4 pb4Var : this.o) {
                if (pb4Var.b == view2) {
                    return pb4Var;
                }
            }
            return null;
        }
        return (pb4) invokeL.objValue;
    }

    @Nullable
    public qb4 J(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (qb4 qb4Var : this.n) {
                if (marker == qb4Var.b) {
                    return qb4Var;
                }
            }
            return null;
        }
        return (qb4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x12
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

    public List<qb4> K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (qb4 qb4Var : this.n) {
                bt2 bt2Var = qb4Var.a;
                if (bt2Var != null && TextUtils.equals(str, bt2Var.a)) {
                    arrayList.add(qb4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
