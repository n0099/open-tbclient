package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.utils.FileUtils;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class sra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public int b;
    public sra c;
    public pra d;
    public volatile boolean e;
    public volatile boolean f;
    public String g;

    /* loaded from: classes7.dex */
    public interface a {
        void a(sra sraVar);

        void b(sra sraVar);

        void c(int i, int i2);

        void d(String str, sra sraVar);
    }

    public sra() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String a(String str, String str2) {
        InterceptResult invokeLL;
        String fileNameWithOutExtention;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str2 == null) {
                str2 = "";
            }
            if (TextUtils.isEmpty(this.g)) {
                sb = new StringBuilder();
                fileNameWithOutExtention = FileUtils.removeExtention(str);
            } else {
                fileNameWithOutExtention = FileUtils.getFileNameWithOutExtention(str);
                sb = new StringBuilder();
                sb.append(this.g);
            }
            sb.append(fileNameWithOutExtention);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public abstract void b();

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.b = i;
        }
    }

    public abstract void d(pra praVar);

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a = aVar;
        }
    }

    public void f(sra sraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sraVar) == null) {
            this.c = sraVar;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || this.f) {
            return;
        }
        this.e = true;
        a aVar = this.a;
        if (aVar != null) {
            aVar.d(getClass().getName() + str, this);
        }
    }

    public abstract void h();

    public void i(int i) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.c(this.b, i);
    }

    public boolean j(pra praVar) {
        InterceptResult invokeL;
        List<nra> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, praVar)) == null) {
            if (praVar != null && praVar.c() != null && praVar.c().size() == 1 && praVar.c().get(0).a() != null && (a2 = praVar.c().get(0).a()) != null && a2.size() == 1) {
                nra nraVar = a2.get(0);
                if (nraVar.b() != null && !nraVar.b().isNeedEdit()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : invokeV.intValue;
    }

    public void l(pra praVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, praVar) == null) {
            this.d = praVar;
            a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, 100);
                this.a.b(this);
            }
            sra sraVar = this.c;
            if (sraVar != null) {
                sraVar.d(praVar);
            }
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.c == null : invokeV.booleanValue;
    }

    public pra n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.d : (pra) invokeV.objValue;
    }

    public void o() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (aVar = this.a) == null) {
            return;
        }
        aVar.a(this);
    }
}
