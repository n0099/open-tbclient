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
public class ng4 extends s62<TextureMapView, px2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<mg4> n;
    public List<lg4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ng4(@NonNull Context context, @NonNull px2 px2Var) {
        super(context, px2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, px2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (t62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = px2Var.c;
        this.j = px2Var.b;
        String str = px2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = px2Var.r;
    }

    public static ng4 K(Context context, px2 px2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, px2Var)) == null) {
            if (context != null && px2Var != null && px2Var.isValid()) {
                return new ng4(context, px2Var);
            }
            return null;
        }
        return (ng4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (mg4 mg4Var : this.n) {
                this.l.removeView(mg4Var.e);
            }
            this.n.clear();
            for (lg4 lg4Var : this.o) {
                this.l.removeView(lg4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public lg4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (lg4 lg4Var : this.o) {
                if (lg4Var.b == view2) {
                    return lg4Var;
                }
            }
            return null;
        }
        return (lg4) invokeL.objValue;
    }

    @Nullable
    public mg4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (mg4 mg4Var : this.n) {
                if (marker == mg4Var.b) {
                    return mg4Var;
                }
            }
            return null;
        }
        return (mg4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
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

    public List<mg4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (mg4 mg4Var : this.n) {
                xx2 xx2Var = mg4Var.a;
                if (xx2Var != null && TextUtils.equals(str, xx2Var.a)) {
                    arrayList.add(mg4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
