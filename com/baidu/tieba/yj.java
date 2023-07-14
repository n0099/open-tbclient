package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes8.dex */
public class yj {
    public static /* synthetic */ Interceptable $ic;
    public static yj h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public zj e;
    public ArrayList<xj> f;
    public xj g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448322748, "Lcom/baidu/tieba/yj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448322748, "Lcom/baidu/tieba/yj;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements xj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj a;

        public a(yj yjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yjVar;
        }

        @Override // com.baidu.tieba.xj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).a(str);
                }
            }
        }

        @Override // com.baidu.tieba.xj
        public void c(tj tjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).c(tjVar);
                }
            }
        }

        @Override // com.baidu.tieba.xj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).d(bArr);
                }
            }
        }

        @Override // com.baidu.tieba.xj
        public void f(bk bkVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, bkVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).f(bkVar);
                }
            }
        }

        @Override // com.baidu.tieba.xj
        public void h(tj tjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, tjVar) == null) && tjVar != null) {
                tjVar.c();
            }
        }

        @Override // com.baidu.tieba.xj
        public void i(tj tjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tjVar) == null) && tjVar != null) {
                tjVar.b();
            }
        }

        @Override // com.baidu.tieba.xj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).onOpen(map);
                }
            }
        }

        @Override // com.baidu.tieba.xj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.e = null;
            Iterator it = this.a.f.iterator();
            while (it.hasNext()) {
                ((xj) it.next()).b(i, str);
            }
        }

        @Override // com.baidu.tieba.xj
        public void g(int i, tj tjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, tjVar) == null) && tjVar != null) {
                tjVar.a(i);
            }
        }

        @Override // com.baidu.tieba.xj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((xj) it.next()).e();
                }
            }
        }
    }

    public yj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = new ArrayList<>();
        this.g = null;
        this.g = new a(this);
    }

    public boolean c(xj xjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xjVar)) == null) {
            if (xjVar != null) {
                synchronized (yj.class) {
                    if (!this.f.contains(xjVar)) {
                        return this.f.add(xjVar);
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean v(tj tjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, tjVar)) == null) {
            synchronized (this) {
                if (tjVar == null) {
                    return false;
                }
                yi.c();
                if (this.e != null) {
                    return this.e.I(tjVar);
                }
                if (tjVar != null) {
                    tjVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void f(int i, String str) {
        zj zjVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (zjVar = this.e) != null) {
            this.e = null;
            zjVar.q(i, str);
            if (this.e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.e = null;
            }
        }
    }

    public static yj j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (yj.class) {
                    if (h == null) {
                        h = new yj();
                    }
                }
            }
            return h;
        }
        return (yj) invokeV.objValue;
    }

    public void d() {
        zj zjVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (zjVar = this.e) != null) {
            zjVar.o();
        }
    }

    public void e() {
        zj zjVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (zjVar = this.e) != null) {
            zjVar.p();
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.v();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (t()) {
                yi.c();
            }
            zj zjVar = this.e;
            if (zjVar != null && zjVar.E() && !this.e.F()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (t()) {
                yi.c();
            }
            zj zjVar = this.e;
            if (zjVar != null && zjVar.E()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            zj zjVar = this.e;
            if (zjVar != null) {
                return zjVar.y();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (t()) {
                yi.c();
            }
            zj zjVar = this.e;
            if (zjVar != null && zjVar.C()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public void r(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048590, this, str, str2, strArr, list) == null) {
            this.a = str;
            this.d = str2;
            this.c = strArr;
            this.b = list;
            t();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (t()) {
                yi.c();
            }
            zj zjVar = this.e;
            if (zjVar != null) {
                if (!zjVar.C() && !this.e.E()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.e = new zj();
            try {
                uk ukVar = new uk();
                ukVar.j(this.d);
                this.e.r(this.a, this.c, this.g, ukVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
