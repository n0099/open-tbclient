package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public abstract class ts5<T> extends us5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public List<T> c;
    public Context d;
    public LayoutInflater e;
    public yu4<T> f;

    public abstract void f(vs5 vs5Var, T t, int i);

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;
        public int b;
        public final /* synthetic */ ts5 c;

        public a(ts5 ts5Var, T t, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts5Var, t, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ts5Var;
            this.a = t;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            yu4<T> yu4Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (yu4Var = this.c.f) != null) {
                T t = this.a;
                int i = this.b;
                yu4Var.d(view2, t, i, i);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ts5(Context context, int i) {
        this(context, null, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ts5(Context context, List<T> list, int i) {
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = context;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(list);
        }
        this.c = arrayList;
        this.b = i;
        this.e = LayoutInflater.from(this.d);
    }

    @Override // com.baidu.tieba.us5
    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c.size();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.us5
    public View b(int i, ViewGroup viewGroup) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, viewGroup)) == null) {
            View inflate = this.e.inflate(this.b, viewGroup, false);
            vs5 vs5Var = new vs5(inflate);
            T t = this.c.get(i);
            f(vs5Var, t, i);
            vs5Var.c(new a(this, t, i));
            return inflate;
        }
        return (View) invokeIL.objValue;
    }

    public void g(List<T> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.c = list;
            c();
        }
    }

    public void h(yu4<T> yu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, yu4Var) == null) {
            this.f = yu4Var;
        }
    }
}
