package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.hy8;
import com.baidu.tieba.jy8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes4.dex */
public class ly8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ly8 c;
    public transient /* synthetic */ FieldHolder $fh;
    public jy8 a;
    public List<qy8> b;

    /* loaded from: classes4.dex */
    public class a implements py8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ly8 a;

        public a(ly8 ly8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ly8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ly8Var;
        }

        @Override // com.baidu.tieba.py8
        public void a(hy8.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                hy8.a().c(bVar);
                if (dc9.e(this.a.b)) {
                    return;
                }
                ly8 ly8Var = this.a;
                ly8Var.h((qy8) dc9.c(ly8Var.b, 0));
                dc9.g(this.a.b, 0);
            }
        }
    }

    public ly8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new Vector();
        this.a = new jy8.b().d();
    }

    public static ly8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (ly8.class) {
                    if (c == null) {
                        c = new ly8();
                    }
                }
            }
            return c;
        }
        return (ly8) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a == null) {
            throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
        }
    }

    public Bitmap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap a2 = g().a(str);
            if (a2 == null || a2.isRecycled()) {
                Bitmap a3 = e().a(str);
                if (a3 == null || a3.isRecycled()) {
                    return null;
                }
                return a3;
            }
            return a2;
        }
        return (Bitmap) invokeL.objValue;
    }

    public ey8 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c();
            String str = FileHelper.getVideoTmpDir() + File.separator + "shaft_images";
            if (!TextUtils.equals(this.a.c.b(), str)) {
                this.a.c.d(str);
            }
            return this.a.c;
        }
        return (ey8) invokeV.objValue;
    }

    public oy8 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (oy8) invokeV.objValue;
    }

    public final void h(qy8 qy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, qy8Var) == null) {
            c();
            hy8.b b = hy8.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(qy8Var.a);
                b.h(qy8Var, new a(this));
                return;
            }
            this.b.add(qy8Var);
        }
    }

    public void i(ry8 ry8Var, iy8 iy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ry8Var, iy8Var) == null) {
            List<qy8> c2 = ny8.c(ry8Var, iy8Var);
            if (dc9.e(c2)) {
                return;
            }
            for (qy8 qy8Var : c2) {
                h(qy8Var);
            }
        }
    }

    public void j(sy8 sy8Var, iy8 iy8Var) {
        qy8 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, sy8Var, iy8Var) == null) || (b = ny8.b(sy8Var, iy8Var)) == null) {
            return;
        }
        h(b);
    }
}
