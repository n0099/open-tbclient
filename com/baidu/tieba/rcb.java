package com.baidu.tieba;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.ncb;
import com.baidu.tieba.pcb;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.core.ImageLoader;
import java.io.File;
import java.util.List;
import java.util.Vector;
/* loaded from: classes8.dex */
public class rcb {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rcb c;
    public transient /* synthetic */ FieldHolder $fh;
    public pcb a;
    public List<wcb> b;

    /* loaded from: classes8.dex */
    public class a implements vcb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rcb a;

        public a(rcb rcbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rcbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rcbVar;
        }

        @Override // com.baidu.tieba.vcb
        public void a(ncb.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                ncb.a().c(bVar);
                if (!xwb.e(this.a.b)) {
                    rcb rcbVar = this.a;
                    rcbVar.h((wcb) xwb.c(rcbVar.b, 0));
                    xwb.g(this.a.b, 0);
                }
            }
        }
    }

    public rcb() {
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
        this.a = new pcb.b().d();
    }

    public void i(xcb xcbVar, ocb ocbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, xcbVar, ocbVar) == null) {
            List<wcb> c2 = tcb.c(xcbVar, ocbVar);
            if (!xwb.e(c2)) {
                for (wcb wcbVar : c2) {
                    h(wcbVar);
                }
            }
        }
    }

    public void j(ycb ycbVar, ocb ocbVar) {
        wcb b;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, ycbVar, ocbVar) == null) && (b = tcb.b(ycbVar, ocbVar)) != null) {
            h(b);
        }
    }

    public static rcb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (c == null) {
                synchronized (rcb.class) {
                    if (c == null) {
                        c = new rcb();
                    }
                }
            }
            return c;
        }
        return (rcb) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a != null) {
            return;
        }
        throw new IllegalStateException(ImageLoader.ERROR_NOT_INIT);
    }

    public ucb g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c();
            return this.a.b;
        }
        return (ucb) invokeV.objValue;
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

    public final void h(wcb wcbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wcbVar) == null) {
            c();
            ncb.b b = ncb.a().b();
            if (b != null) {
                b.p(this.a.a);
                b.setDataSource(wcbVar.a);
                b.h(wcbVar, new a(this));
                return;
            }
            this.b.add(wcbVar);
        }
    }

    public kcb e() {
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
        return (kcb) invokeV.objValue;
    }
}
