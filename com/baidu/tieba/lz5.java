package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class lz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public pz5 c;
    public b d;
    public final og<gn> e;

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public class a extends og<gn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lz5 a;

        public a(lz5 lz5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lz5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lz5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.og
        public void onLoaded(gn gnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, gnVar, str, i) == null) {
                super.onLoaded((a) gnVar, str, i);
                if (!StringUtils.isNull(str) && this.a.c != null && this.a.c.isValid()) {
                    if (str.equals(this.a.c.a())) {
                        this.a.b.setImageDrawable(gnVar.j());
                    }
                    if (str.equals(this.a.c.d())) {
                        this.a.a.setImageDrawable(gnVar.j());
                    }
                    this.a.c.b(str);
                    if (this.a.c.e() && this.a.d != null) {
                        this.a.d.a();
                    }
                }
            }
        }
    }

    public lz5(ImageView imageView, ImageView imageView2) {
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

    public void f(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void e() {
        pz5 pz5Var;
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (pz5Var = this.c) == null || !pz5Var.isValid() || !this.c.e() || (bVar = this.d) == null) {
            return;
        }
        bVar.a();
    }

    public void g(pz5 pz5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pz5Var) == null) && pz5Var != null && pz5Var.isValid()) {
            this.c = pz5Var;
            pg.h().m(this.c.a(), 10, this.e, null);
            pg.h().m(this.c.d(), 10, this.e, null);
        }
    }
}
