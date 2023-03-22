package com.baidu.tieba;

import android.widget.ImageView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ur5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView a;
    public ImageView b;
    public yr5 c;
    public b d;
    public final bg<rm> e;

    /* loaded from: classes6.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes6.dex */
    public class a extends bg<rm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ur5 a;

        public a(ur5 ur5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ur5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(rm rmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, rmVar, str, i) == null) {
                super.onLoaded((a) rmVar, str, i);
                if (!StringUtils.isNull(str) && this.a.c != null && this.a.c.isValid()) {
                    if (str.equals(this.a.c.a())) {
                        this.a.b.setImageDrawable(rmVar.j());
                    }
                    if (str.equals(this.a.c.d())) {
                        this.a.a.setImageDrawable(rmVar.j());
                    }
                    this.a.c.b(str);
                    if (this.a.c.e() && this.a.d != null) {
                        this.a.d.a();
                    }
                }
            }
        }
    }

    public ur5(ImageView imageView, ImageView imageView2) {
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
        yr5 yr5Var;
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (yr5Var = this.c) == null || !yr5Var.isValid() || !this.c.e() || (bVar = this.d) == null) {
            return;
        }
        bVar.a();
    }

    public void g(yr5 yr5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, yr5Var) == null) && yr5Var != null && yr5Var.isValid()) {
            this.c = yr5Var;
            cg.h().m(this.c.a(), 10, this.e, null);
            cg.h().m(this.c.d(), 10, this.e, null);
        }
    }
}
