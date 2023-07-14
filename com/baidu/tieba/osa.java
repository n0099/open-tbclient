package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.ksa;
import com.baidu.tieba.msa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes7.dex */
public class osa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile osa c;
    public transient /* synthetic */ FieldHolder $fh;
    public msa a;
    public List<tsa> b;

    /* loaded from: classes7.dex */
    public class a implements ssa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ osa a;

        public a(osa osaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {osaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = osaVar;
        }

        @Override // com.baidu.tieba.ssa
        public void a(ksa.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                ksa.a().c(bVar);
                if (!kab.e(this.a.b)) {
                    osa osaVar = this.a;
                    osaVar.h((tsa) kab.c(osaVar.b, 0));
                    kab.g(this.a.b, 0);
                }
            }
        }
    }

    public osa() {
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
        this.a = new msa.b().d();
    }

    public void i(usa usaVar, lsa lsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, usaVar, lsaVar) == null) {
            List<tsa> c2 = qsa.c(usaVar, lsaVar);
            if (!kab.e(c2)) {
                for (tsa tsaVar : c2) {
                    h(tsaVar);
                }
            }
        }
    }

    public void j(vsa vsaVar, lsa lsaVar) {
        tsa b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, vsaVar, lsaVar) == null) && (b = qsa.b(vsaVar, lsaVar)) != null) {
            h(b);
        }
    }

    public static osa f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (osa.class) {
                    if (c == null) {
                        c = new osa();
                    }
                }
            }
            return c;
        }
        return (osa) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a != null) {
            return;
        }
        throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
    }

    public rsa g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (rsa) invokeV.objValue;
    }

    public Bitmap d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Bitmap a2 = g().a(str);
            if (a2 != null && !a2.isRecycled()) {
                return a2;
            }
            Bitmap a3 = e().a(str);
            if (a3 == null || a3.isRecycled()) {
                return null;
            }
            return a3;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void h(tsa tsaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tsaVar) == null) {
            c();
            ksa.b b = ksa.a().b();
            if (b != null) {
                b.m(this.a.a);
                b.setDataSource(tsaVar.a);
                b.h(tsaVar, new a(this));
                return;
            }
            this.b.add(tsaVar);
        }
    }

    public hsa e() {
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
        return (hsa) invokeV.objValue;
    }
}
