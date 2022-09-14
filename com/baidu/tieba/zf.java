package com.baidu.tieba;

import android.location.Address;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public class zf {
    public static /* synthetic */ Interceptable $ic;
    public static zf n;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;
    public long c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int g;
    public Address h;
    public ArrayList<SoftReference<c>> i;
    public ArrayList<ag> j;
    public Handler k;
    @NonNull
    public e l;
    public d m;

    /* loaded from: classes6.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf a;

        public a(zf zfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zfVar;
        }

        @Override // com.baidu.tieba.zf.d
        public void a(int i, String str, Address address, long j, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), str, address, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
                zf zfVar = this.a;
                zfVar.b = j;
                zfVar.h = address;
                this.a.d = z;
                this.a.g = i;
                this.a.u();
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4 && StringUtils.isNull(str)) {
                                str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                            }
                        } else if (StringUtils.isNull(str)) {
                            str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                        }
                    } else if (StringUtils.isNull(str)) {
                        str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                    }
                } else if (StringUtils.isNull(str)) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                }
                this.a.i(i, str, address);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zf a;

        public b(zf zfVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zfVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zfVar;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what != 0) {
                    return false;
                }
                this.a.u();
                int i = this.a.g;
                String str = "";
                if (i == 1) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_gps_offline);
                } else if (i == 2) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_net_offline);
                } else if (i == 3) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_all_offline);
                } else if (i == 4) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                } else if (i == 6) {
                    str = BdBaseApplication.getInst().getResources().getString(R.string.location_out_time);
                }
                zf zfVar = this.a;
                zfVar.i(zfVar.g, str, null);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(int i, String str, Address address);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a(int i, String str, Address address, long j, boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448323585, "Lcom/baidu/tieba/zf;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448323585, "Lcom/baidu/tieba/zf;");
        }
    }

    public zf() {
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
        this.a = 10000L;
        this.b = 0L;
        this.c = 300000L;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 4;
        this.h = null;
        this.i = new ArrayList<>();
        this.j = new ArrayList<>();
        this.k = null;
        this.l = new e(null);
        this.m = new a(this);
    }

    public static zf n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (n == null) {
                synchronized (zf.class) {
                    if (n == null) {
                        n = new zf();
                    }
                }
            }
            return n;
        }
        return (zf) invokeV.objValue;
    }

    public void g(@NonNull Class<?> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cls) == null) {
            this.l.a(cls.getName());
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l.b() : invokeV.booleanValue;
    }

    public final void i(int i, String str, Address address) {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, address) == null) {
            Handler handler = this.k;
            if (handler != null && handler.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            ArrayList<SoftReference<c>> arrayList = this.i;
            if (arrayList != null) {
                synchronized (arrayList) {
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        SoftReference<c> softReference = this.i.get(i2);
                        if (softReference != null && (cVar = softReference.get()) != null) {
                            cVar.a(i, str, address);
                        }
                    }
                    this.i.clear();
                }
            }
        }
    }

    public Address j(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) ? l(z, false) : (Address) invokeZ.objValue;
    }

    public Address k(boolean z, c cVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZL = interceptable.invokeZL(1048580, this, z, cVar)) == null) ? m(z, false, cVar) : (Address) invokeZL.objValue;
    }

    public Address l(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (System.currentTimeMillis() - this.b > this.c) {
                this.h = null;
            }
            if (this.h != null && !z && ((z2 && this.d) || !z2)) {
                return this.h;
            }
            this.h = null;
            boolean z3 = this.f;
            if (!z3) {
                t(z2);
                return null;
            }
            if (z3 && z2 && !this.e) {
                u();
                t(z2);
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public Address m(boolean z, boolean z2, c cVar) {
        InterceptResult invokeCommon;
        boolean z3;
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), cVar})) == null) {
            if (System.currentTimeMillis() - this.b > this.c) {
                this.h = null;
            }
            if (this.h != null && !z && ((z2 && this.d) || !z2)) {
                if (cVar != null) {
                    cVar.a(0, "", this.h);
                }
                return this.h;
            }
            if (cVar != null) {
                synchronized (this.i) {
                    int i = 0;
                    while (true) {
                        if (i >= this.i.size()) {
                            z3 = false;
                            break;
                        }
                        SoftReference<c> softReference = this.i.get(i);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            z3 = true;
                            break;
                        }
                        i++;
                    }
                    if (!z3) {
                        if (this.i.size() >= 100) {
                            this.i.remove(0);
                        }
                        this.i.add(new SoftReference<>(cVar));
                    }
                }
                boolean z4 = this.f;
                if (!z4) {
                    t(z2);
                    return null;
                } else if (z4 && z2 && !this.e) {
                    u();
                    t(z2);
                    return null;
                }
            }
            return null;
        }
        return (Address) invokeCommon.objValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.longValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.k = new Handler(Looper.getMainLooper(), new b(this));
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p();
        }
    }

    public void r(ag agVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, agVar) == null) || agVar == null) {
            return;
        }
        synchronized (this.j) {
            if (!this.j.contains(agVar)) {
                agVar.b(this.m);
                this.j.add(agVar);
            }
        }
    }

    public void s(c cVar) {
        c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            synchronized (this.i) {
                int i = 0;
                while (true) {
                    if (i < this.i.size()) {
                        SoftReference<c> softReference = this.i.get(i);
                        if (softReference != null && (cVar2 = softReference.get()) != null && cVar2.equals(cVar)) {
                            this.i.remove(softReference);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public final void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            Handler handler = this.k;
            if (handler != null && handler.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.g = 4;
            this.e = z;
            this.f = true;
            ArrayList<ag> arrayList = this.j;
            if (arrayList != null && !arrayList.isEmpty()) {
                if (!this.l.b()) {
                    this.g = 7;
                    Handler handler2 = this.k;
                    if (handler2 != null) {
                        handler2.sendMessage(handler2.obtainMessage(0));
                        return;
                    }
                    return;
                }
                Iterator<ag> it = this.j.iterator();
                while (it.hasNext()) {
                    ag next = it.next();
                    if (next != null) {
                        try {
                            next.a(z);
                        } catch (Exception e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                }
                Handler handler3 = this.k;
                if (handler3 != null) {
                    handler3.sendMessageDelayed(handler3.obtainMessage(0), this.a);
                    return;
                }
                return;
            }
            this.g = 6;
            Handler handler4 = this.k;
            if (handler4 != null) {
                handler4.sendMessage(handler4.obtainMessage(0));
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            Handler handler = this.k;
            if (handler != null && handler.hasMessages(0)) {
                this.k.removeMessages(0);
            }
            this.f = false;
            Iterator<ag> it = this.j.iterator();
            while (it.hasNext()) {
                ag next = it.next();
                if (next != null) {
                    try {
                        next.c();
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                    }
                }
            }
        }
    }

    public void v(ag agVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, agVar) == null) || agVar == null) {
            return;
        }
        synchronized (this.j) {
            agVar.destroy();
            this.j.remove(agVar);
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final Set<String> a;

        public e() {
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
            this.a = new HashSet();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.add(str);
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                int min = Math.min(stackTrace.length, 20);
                for (int i = 0; i < min; i++) {
                    if (this.a.contains(stackTrace[i].getClassName())) {
                        return true;
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }
}
