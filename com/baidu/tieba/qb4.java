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
public class qb4 extends w12<TextureMapView, ss2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<pb4> n;
    public List<ob4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qb4(@NonNull Context context, @NonNull ss2 ss2Var) {
        super(context, ss2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ss2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (x12) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = ss2Var.c;
        this.j = ss2Var.b;
        String str = ss2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = ss2Var.r;
    }

    public static qb4 M(Context context, ss2 ss2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, ss2Var)) == null) {
            if (context != null && ss2Var != null && ss2Var.isValid()) {
                return new qb4(context, ss2Var);
            }
            return null;
        }
        return (qb4) invokeLL.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (pb4 pb4Var : this.n) {
                this.l.removeView(pb4Var.e);
            }
            this.n.clear();
            for (ob4 ob4Var : this.o) {
                this.l.removeView(ob4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public ob4 I(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (ob4 ob4Var : this.o) {
                if (ob4Var.b == view2) {
                    return ob4Var;
                }
            }
            return null;
        }
        return (ob4) invokeL.objValue;
    }

    @Nullable
    public pb4 J(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (pb4 pb4Var : this.n) {
                if (marker == pb4Var.b) {
                    return pb4Var;
                }
            }
            return null;
        }
        return (pb4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.w12
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

    public List<pb4> K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (pb4 pb4Var : this.n) {
                at2 at2Var = pb4Var.a;
                if (at2Var != null && TextUtils.equals(str, at2Var.a)) {
                    arrayList.add(pb4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
