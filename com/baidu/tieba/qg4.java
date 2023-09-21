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
public class qg4 extends v62<TextureMapView, sx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<pg4> n;
    public List<og4> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qg4(@NonNull Context context, @NonNull sx2 sx2Var) {
        super(context, sx2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sx2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (w62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = sx2Var.c;
        this.j = sx2Var.b;
        String str = sx2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = sx2Var.r;
    }

    public static qg4 K(Context context, sx2 sx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, sx2Var)) == null) {
            if (context != null && sx2Var != null && sx2Var.isValid()) {
                return new qg4(context, sx2Var);
            }
            return null;
        }
        return (qg4) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (pg4 pg4Var : this.n) {
                this.l.removeView(pg4Var.e);
            }
            this.n.clear();
            for (og4 og4Var : this.o) {
                this.l.removeView(og4Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public og4 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (og4 og4Var : this.o) {
                if (og4Var.b == view2) {
                    return og4Var;
                }
            }
            return null;
        }
        return (og4) invokeL.objValue;
    }

    @Nullable
    public pg4 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (pg4 pg4Var : this.n) {
                if (marker == pg4Var.b) {
                    return pg4Var;
                }
            }
            return null;
        }
        return (pg4) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v62
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

    public List<pg4> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (pg4 pg4Var : this.n) {
                ay2 ay2Var = pg4Var.a;
                if (ay2Var != null && TextUtils.equals(str, ay2Var.a)) {
                    arrayList.add(pg4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
