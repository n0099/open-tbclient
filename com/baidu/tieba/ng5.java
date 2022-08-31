package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ng5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public rg5 c;
    public b d;
    public final kg<an> e;

    /* loaded from: classes5.dex */
    public class a extends kg<an> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ng5 a;

        public a(ng5 ng5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ng5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ng5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        public void onLoaded(an anVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, anVar, str, i) == null) {
                super.onLoaded((a) anVar, str, i);
                if (StringUtils.isNull(str) || this.a.c == null || !this.a.c.isValid()) {
                    return;
                }
                if (str.equals(this.a.c.a())) {
                    this.a.b.setImageDrawable(anVar.j());
                }
                if (str.equals(this.a.c.d())) {
                    this.a.a.setImageDrawable(anVar.j());
                }
                this.a.c.b(str);
                if (!this.a.c.e() || this.a.d == null) {
                    return;
                }
                this.a.d.a();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();
    }

    public ng5(ImageView imageView, ImageView imageView2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageView, imageView2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.a = imageView;
        this.b = imageView2;
    }

    public void e() {
        rg5 rg5Var;
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (rg5Var = this.c) != null && rg5Var.isValid() && this.c.e() && (bVar = this.d) != null) {
            bVar.a();
        }
    }

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void g(rg5 rg5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rg5Var) == null) && rg5Var != null && rg5Var.isValid()) {
            this.c = rg5Var;
            lg.h().m(this.c.a(), 10, this.e, null);
            lg.h().m(this.c.d(), 10, this.e, null);
        }
    }
}
