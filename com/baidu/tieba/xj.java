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
public class xj {
    public static /* synthetic */ Interceptable $ic;
    public static xj h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public yj e;
    public ArrayList<wj> f;
    public wj g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448321787, "Lcom/baidu/tieba/xj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448321787, "Lcom/baidu/tieba/xj;");
        }
    }

    /* loaded from: classes8.dex */
    public class a implements wj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xj a;

        public a(xj xjVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xjVar;
        }

        @Override // com.baidu.tieba.wj
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((wj) it.next()).a(str);
                }
            }
        }

        @Override // com.baidu.tieba.wj
        public void c(sj sjVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sjVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((wj) it.next()).c(sjVar);
                }
            }
        }

        @Override // com.baidu.tieba.wj
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((wj) it.next()).d(bArr);
                }
            }
        }

        @Override // com.baidu.tieba.wj
        public void f(ak akVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, akVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((wj) it.next()).f(akVar);
                }
            }
        }

        @Override // com.baidu.tieba.wj
        public void h(sj sjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, sjVar) == null) && sjVar != null) {
                sjVar.c();
            }
        }

        @Override // com.baidu.tieba.wj
        public void i(sj sjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sjVar) == null) && sjVar != null) {
                sjVar.b();
            }
        }

        @Override // com.baidu.tieba.wj
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((wj) it.next()).onOpen(map);
                }
            }
        }

        @Override // com.baidu.tieba.wj
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.e = null;
            Iterator it = this.a.f.iterator();
            while (it.hasNext()) {
                ((wj) it.next()).b(i, str);
            }
        }

        @Override // com.baidu.tieba.wj
        public void g(int i, sj sjVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, sjVar) == null) && sjVar != null) {
                sjVar.a(i);
            }
        }

        @Override // com.baidu.tieba.wj
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((wj) it.next()).e();
                }
            }
        }
    }

    public xj() {
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

    public boolean c(wj wjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wjVar)) == null) {
            if (wjVar != null) {
                synchronized (xj.class) {
                    if (!this.f.contains(wjVar)) {
                        return this.f.add(wjVar);
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean v(sj sjVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, sjVar)) == null) {
            synchronized (this) {
                if (sjVar == null) {
                    return false;
                }
                xi.c();
                if (this.e != null) {
                    return this.e.I(sjVar);
                }
                if (sjVar != null) {
                    sjVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void f(int i, String str) {
        yj yjVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (yjVar = this.e) != null) {
            this.e = null;
            yjVar.q(i, str);
            if (this.e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.e = null;
            }
        }
    }

    public static xj j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (xj.class) {
                    if (h == null) {
                        h = new xj();
                    }
                }
            }
            return h;
        }
        return (xj) invokeV.objValue;
    }

    public void d() {
        yj yjVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (yjVar = this.e) != null) {
            yjVar.o();
        }
    }

    public void e() {
        yj yjVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (yjVar = this.e) != null) {
            yjVar.p();
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.z();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.A();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.v();
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
                xi.c();
            }
            yj yjVar = this.e;
            if (yjVar != null && yjVar.E() && !this.e.F()) {
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
                xi.c();
            }
            yj yjVar = this.e;
            if (yjVar != null && yjVar.E()) {
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
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.w();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.x();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.B();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            yj yjVar = this.e;
            if (yjVar != null) {
                return yjVar.y();
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
                xi.c();
            }
            yj yjVar = this.e;
            if (yjVar != null && yjVar.C()) {
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
                xi.c();
            }
            yj yjVar = this.e;
            if (yjVar != null) {
                if (!yjVar.C() && !this.e.E()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    t();
                    return true;
                }
            }
            this.e = new yj();
            try {
                tk tkVar = new tk();
                tkVar.j(this.d);
                this.e.r(this.a, this.c, this.g, tkVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
