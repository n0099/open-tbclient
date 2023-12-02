package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k42 {
    public static /* synthetic */ Interceptable $ic;
    public static ActivityManager c;
    public static float d;
    public static int e;
    public static int f;
    public transient /* synthetic */ FieldHolder $fh;
    public DecimalFormat a;
    public volatile d b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                Bundle bundle2 = new Bundle();
                bundle2.putLong("key_get_host_pss", Debug.getPss());
                return bundle2;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;

        public c() {
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
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic = null;
        public static volatile String e = "0";
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-709378560, "Lcom/baidu/tieba/k42$d;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-709378560, "Lcom/baidu/tieba/k42$d;");
            }
        }

        public d() {
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
            this.a = "0";
            this.b = "0";
            this.c = "0";
            this.d = "0";
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public static final k42 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-709378529, "Lcom/baidu/tieba/k42$e;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-709378529, "Lcom/baidu/tieba/k42$e;");
                    return;
                }
            }
            a = new k42(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947863040, "Lcom/baidu/tieba/k42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947863040, "Lcom/baidu/tieba/k42;");
                return;
            }
        }
        boolean z = vm1.a;
        c = (ActivityManager) rp2.c().getSystemService("activity");
        d = -1.0f;
        rp2.g0().getSwitch("swan_memory_sample", 0);
        e = 0;
        f = new Random().nextInt(100);
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (!m()) {
                return "";
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            c.getMemoryInfo(memoryInfo);
            String b2 = b(((float) memoryInfo.totalMem) / 1048576.0f);
            k32.k("SwanMemoryProperty", "getMemoryInfo sysTotalMemory=" + b2);
            return b2;
        }
        return (String) invokeV.objValue;
    }

    public k42() {
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
        this.a = new DecimalFormat("#.###");
    }

    public static k42 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return e.a;
        }
        return (k42) invokeV.objValue;
    }

    public static float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d < 0.0f) {
                d = e().floatValue();
            }
            return d;
        }
        return invokeV.floatValue;
    }

    public static Float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            c.getMemoryInfo(memoryInfo);
            return Float.valueOf(((float) memoryInfo.totalMem) / 1048576.0f);
        }
        return (Float) invokeV.objValue;
    }

    public static long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return x23.c(b.class, null).a.getLong("key_get_host_pss");
        }
        return invokeV.longValue;
    }

    @NonNull
    public d g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.b != null) {
                return this.b;
            }
            return new d();
        }
        return (d) invokeV.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.b == null) {
            this.b = j();
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b = null;
        }
    }

    public /* synthetic */ k42(a aVar) {
        this();
    }

    public final String b(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            return this.a.format(f2);
        }
        return (String) invokeF.objValue;
    }

    @NonNull
    public static c i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            c cVar = new c();
            Debug.MemoryInfo[] processMemoryInfo = c.getProcessMemoryInfo(new int[]{Process.myPid(), j63.K().q().X().i("main_pid", -1)});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            c.getMemoryInfo(memoryInfo);
            cVar.c = ((float) (memoryInfo.totalMem - memoryInfo.availMem)) / 1048576.0f;
            if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                Debug.MemoryInfo memoryInfo3 = processMemoryInfo[1];
                if (memoryInfo2 != null) {
                    cVar.b = ((float) Debug.getPss()) / 1024.0f;
                }
                if (memoryInfo3 != null) {
                    cVar.a = ((float) f()) / 1024.0f;
                }
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }

    public final void a(JSONObject jSONObject, ActivityManager.MemoryInfo memoryInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, memoryInfo) == null) && jSONObject != null && memoryInfo != null) {
            this.b = new d();
            this.b.b = jSONObject.optString("host_used_mem");
            this.b.a = jSONObject.optString("smart_app_used_mem");
            this.b.d = jSONObject.optString("sys_free_mem");
            this.b.c = b(((float) memoryInfo.totalMem) / 1048576.0f);
        }
    }

    public String h(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (!m()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                k32.k("SwanMemoryProperty", "getMemoryInfo mainPid: " + i);
                Debug.MemoryInfo[] processMemoryInfo = c.getProcessMemoryInfo(new int[]{Process.myPid(), i});
                if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                    Debug.MemoryInfo memoryInfo = processMemoryInfo[0];
                    if (memoryInfo != null) {
                        jSONObject.put("smart_app_used_mem", b(((float) Debug.getPss()) / 1024.0f));
                        jSONObject.put("total_rss", b((((memoryInfo.getTotalPrivateClean() + memoryInfo.getTotalPrivateDirty()) + memoryInfo.getTotalSharedClean()) + memoryInfo.getTotalSharedDirty()) / 1024.0f));
                        jSONObject.put("private_clean", b(memoryInfo.getTotalPrivateClean() / 1024.0f));
                        jSONObject.put("private_dirty", b(memoryInfo.getTotalPrivateDirty() / 1024.0f));
                        jSONObject.put("shared_clean", b(memoryInfo.getTotalSharedClean() / 1024.0f));
                        jSONObject.put("shared_dirty", b(memoryInfo.getTotalSharedDirty() / 1024.0f));
                    }
                    Debug.MemoryInfo memoryInfo2 = processMemoryInfo[1];
                    if (memoryInfo2 != null) {
                        jSONObject.put("host_used_mem", b((((memoryInfo2.getTotalPrivateClean() + memoryInfo2.getTotalPrivateDirty()) + memoryInfo2.getTotalSharedClean()) + memoryInfo2.getTotalSharedDirty()) / 1024.0f));
                    }
                }
                ActivityManager.MemoryInfo memoryInfo3 = new ActivityManager.MemoryInfo();
                c.getMemoryInfo(memoryInfo3);
                jSONObject.put("sys_free_mem", b(((float) memoryInfo3.availMem) / 1048576.0f));
                if (memoryInfo3.lowMemory) {
                    str = "1";
                } else {
                    str = "0";
                }
                jSONObject.put("sys_low_mem", str);
                jSONObject.put("native_heap", b(((float) Debug.getNativeHeapSize()) / 1048576.0f));
                jSONObject.put("native_heap_alloc", b(((float) Debug.getNativeHeapAllocatedSize()) / 1048576.0f));
                jSONObject.put("vm_max_mem", b(((float) Runtime.getRuntime().maxMemory()) / 1048576.0f));
                jSONObject.put("vm_total_mem", b(((float) Runtime.getRuntime().totalMemory()) / 1048576.0f));
                jSONObject.put("vm_free_mem", b(((float) Runtime.getRuntime().freeMemory()) / 1048576.0f));
                jSONObject.put("thread_count", Thread.activeCount());
                a(jSONObject, memoryInfo3);
            } catch (Exception e2) {
                k32.k("SwanMemoryProperty", "getMemoryInfo: " + Log.getStackTraceString(e2));
            }
            k32.k("SwanMemoryProperty", "getMemoryInfo result=" + jSONObject);
            return jSONObject.toString();
        }
        return (String) invokeI.objValue;
    }

    public d j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d dVar = new d();
            Debug.MemoryInfo[] processMemoryInfo = c.getProcessMemoryInfo(new int[]{Process.myPid(), j63.K().q().X().i("main_pid", -1)});
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            c.getMemoryInfo(memoryInfo);
            if (processMemoryInfo != null && processMemoryInfo.length == 2) {
                Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                Debug.MemoryInfo memoryInfo3 = processMemoryInfo[1];
                if (memoryInfo2 != null) {
                    if (TextUtils.equals("0", d.e)) {
                        String unused = d.e = b(((float) memoryInfo.totalMem) / 1048576.0f);
                    }
                    dVar.c = d.e;
                    dVar.d = b(((float) memoryInfo.availMem) / 1048576.0f);
                    dVar.a = b(((float) Debug.getPss()) / 1024.0f);
                }
                if (memoryInfo3 != null) {
                    dVar.b = b((((memoryInfo3.getTotalPrivateClean() + memoryInfo3.getTotalPrivateDirty()) + memoryInfo3.getTotalSharedClean()) + memoryInfo3.getTotalSharedDirty()) / 1024.0f);
                }
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            k32.k("SwanMemoryProperty", "getMemoryInfo mMemSample =" + e + "; mRandomNum =" + f);
            int i = e;
            if (i <= 0) {
                return false;
            }
            if (i < 100 && f > i) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
