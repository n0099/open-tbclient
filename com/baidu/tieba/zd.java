package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
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
/* loaded from: classes9.dex */
public class zd {
    public static /* synthetic */ Interceptable $ic;
    public static zd h;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<BasicNameValuePair> b;
    public String[] c;
    public String d;
    public ae e;
    public ArrayList<yd> f;
    public yd g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448323523, "Lcom/baidu/tieba/zd;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448323523, "Lcom/baidu/tieba/zd;");
        }
    }

    /* loaded from: classes9.dex */
    public class a implements yd {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zd a;

        public a(zd zdVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zdVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zdVar;
        }

        @Override // com.baidu.tieba.yd
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((yd) it.next()).a(str);
                }
            }
        }

        @Override // com.baidu.tieba.yd
        public void c(ud udVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, udVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((yd) it.next()).c(udVar);
                }
            }
        }

        @Override // com.baidu.tieba.yd
        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((yd) it.next()).d(bArr);
                }
            }
        }

        @Override // com.baidu.tieba.yd
        public void f(ce ceVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, ceVar) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((yd) it.next()).f(ceVar);
                }
            }
        }

        @Override // com.baidu.tieba.yd
        public void h(ud udVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048583, this, udVar) == null) && udVar != null) {
                udVar.c();
            }
        }

        @Override // com.baidu.tieba.yd
        public void i(ud udVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, udVar) == null) && udVar != null) {
                udVar.b();
            }
        }

        @Override // com.baidu.tieba.yd
        public void onOpen(Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((yd) it.next()).onOpen(map);
                }
            }
        }

        @Override // com.baidu.tieba.yd
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.e = null;
            Iterator it = this.a.f.iterator();
            while (it.hasNext()) {
                ((yd) it.next()).b(i, str);
            }
        }

        @Override // com.baidu.tieba.yd
        public void g(int i, ud udVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, udVar) == null) && udVar != null) {
                udVar.a(i);
            }
        }

        @Override // com.baidu.tieba.yd
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                Iterator it = this.a.f.iterator();
                while (it.hasNext()) {
                    ((yd) it.next()).e();
                }
            }
        }
    }

    public zd() {
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

    public boolean c(yd ydVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ydVar)) == null) {
            if (ydVar != null) {
                synchronized (zd.class) {
                    if (!this.f.contains(ydVar)) {
                        return this.f.add(ydVar);
                    }
                    return false;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public synchronized boolean p(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, udVar)) == null) {
            synchronized (this) {
                if (udVar == null) {
                    return false;
                }
                BdUtilHelper.checkMainThread();
                if (this.e != null) {
                    return this.e.D(udVar);
                }
                if (udVar != null) {
                    udVar.a(1);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void f(int i, String str) {
        ae aeVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048579, this, i, str) == null) && (aeVar = this.e) != null) {
            this.e = null;
            aeVar.q(i, str);
            if (this.e != null) {
                BdLog.e("close is opened and thread is leaded!!!");
                this.e = null;
            }
        }
    }

    public static zd h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (h == null) {
                synchronized (zd.class) {
                    if (h == null) {
                        h = new zd();
                    }
                }
            }
            return h;
        }
        return (zd) invokeV.objValue;
    }

    public void d() {
        ae aeVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (aeVar = this.e) != null) {
            aeVar.o();
        }
    }

    public void e() {
        ae aeVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (aeVar = this.e) != null) {
            aeVar.p();
        }
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ae aeVar = this.e;
            if (aeVar != null) {
                return aeVar.v();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ae aeVar = this.e;
            if (aeVar != null && aeVar.z() && !this.e.A()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ae aeVar = this.e;
            if (aeVar != null && aeVar.z()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ae aeVar = this.e;
            if (aeVar != null) {
                return aeVar.w();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ae aeVar = this.e;
            if (aeVar != null && aeVar.x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public void l(String str, String str2, String[] strArr, List<BasicNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, strArr, list) == null) {
            this.a = str;
            this.d = str2;
            this.c = strArr;
            this.b = list;
            n();
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (n()) {
                BdUtilHelper.checkMainThread();
            }
            ae aeVar = this.e;
            if (aeVar != null) {
                if (!aeVar.x() && !this.e.z()) {
                    this.e.q(1, null);
                    this.e = null;
                } else {
                    n();
                    return true;
                }
            }
            this.e = new ae();
            try {
                ve veVar = new ve();
                veVar.j(this.d);
                this.e.r(this.a, this.c, this.g, veVar, this.b);
                return true;
            } catch (WebSocketException unused) {
                this.e = null;
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
