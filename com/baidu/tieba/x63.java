package com.baidu.tieba;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.du2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class x63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public Set<String> c;
    public List<Long> d;
    public List<Integer> e;
    public List<Float> f;
    public List<Float> g;
    public List<Float> h;
    public List<Float> i;
    public a j;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile long a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public int g;

        public a() {
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

        public static float a(List<Float> list, List<Long> list2, long j, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, list2, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
                if (j == 0 || list == null || list.isEmpty() || list2 == null || list2.isEmpty() || list.size() != list2.size()) {
                    return 0.0f;
                }
                ay1.b("SwanAppStabilityData", "#calcFirstAndMaxMemDiff memList=" + list + " timeList=" + list2 + " fmp=" + j + " isBefore=" + z);
                float f = Float.MIN_VALUE;
                Float f2 = list.get(0);
                float floatValue = f2 != null ? f2.floatValue() : 0.0f;
                for (int i = 0; i < list.size(); i++) {
                    Long l = list2.get(i);
                    Float f3 = list.get(i);
                    if (l != null && f3 != null) {
                        if (z) {
                            if (l.longValue() <= j) {
                                f = Math.max(f, f3.floatValue());
                            }
                        } else if (l.longValue() >= j) {
                            f = Math.max(f, f3.floatValue());
                        }
                    }
                }
                return f - floatValue;
            }
            return invokeCommon.floatValue;
        }

        public static float b(List<Integer> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
                int i = 0;
                float f = 0.0f;
                for (Integer num : list) {
                    if (num != null && num.intValue() > 0) {
                        i++;
                        f += num.intValue();
                    }
                }
                if (i == 0) {
                    return 0.0f;
                }
                return f / i;
            }
            return invokeL.floatValue;
        }

        public static long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? du2.a.a().a : invokeV.longValue;
        }

        public static long d() {
            InterceptResult invokeV;
            i02 o;
            gn1 o3;
            rn1 M;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                j02 V = nm2.U().V();
                if (V == null || (o = V.o()) == null || (o3 = o.o3()) == null) {
                    return 0L;
                }
                jn1 j = o3.j();
                if (j == null) {
                    M = o3.M();
                } else {
                    M = j.M();
                }
                if (M == null) {
                    return 0L;
                }
                return M.c;
            }
            return invokeV.longValue;
        }

        public static float e(List<Float> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
                float f = 0.0f;
                if (list == null || list.isEmpty()) {
                    return 0.0f;
                }
                int i = 0;
                for (Float f2 : list) {
                    if (f2 != null) {
                        i++;
                        f += f2.floatValue();
                    }
                }
                if (i == 0) {
                    return -1.0f;
                }
                return f / i;
            }
            return invokeL.floatValue;
        }

        public static float f(List<Float> list, List<Long> list2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{list, list2, Long.valueOf(j)})) == null) ? a(list, list2, j, true) : invokeCommon.floatValue;
        }

        public static float g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
                PMSAppInfo u = v84.i().u(z03.K().getAppId());
                if (u == null) {
                    return 0.0f;
                }
                return ((float) u.pkgSize) / 1024.0f;
            }
            return invokeV.floatValue;
        }

        public static int h(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) {
                int i = 0;
                for (q12 q12Var : r12.d().c()) {
                    if (q12Var != null && q12Var.e() < j) {
                        i++;
                    }
                }
                return i;
            }
            return invokeJ.intValue;
        }

        public static float i(List<Float> list, List<Long> list2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{list, list2, Long.valueOf(j)})) == null) ? a(list, list2, j, false) : invokeCommon.floatValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "VerificationData{mFmp=" + this.a + ", mMainPkgSize=" + this.b + ", mIdleCpuAvg=" + this.c + ", mFpsAvg=" + this.d + ", mLaunchDiffMem=" + this.e + ", mRunningDiffMem=" + this.f + ", mLaunchRequestCount=" + this.g + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    public x63() {
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
        this.a = 500;
        this.b = 0.0f;
        this.c = new ConcurrentSkipListSet();
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        this.f = new CopyOnWriteArrayList();
        this.g = new CopyOnWriteArrayList();
        this.h = new CopyOnWriteArrayList();
        this.i = new CopyOnWriteArrayList();
        this.j = new a();
    }

    public void a(List<Float> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
            a aVar = this.j;
            Pair<Long, Long> b = b(10000);
            long longValue = ((Long) b.first).longValue();
            aVar.a = ((Long) b.second).longValue();
            aVar.c = a.e(list);
            aVar.b = a.g();
            aVar.e = a.f(this.i, this.d, longValue);
            aVar.f = a.i(this.i, this.d, longValue);
            aVar.g = a.h(longValue);
            aVar.d = a.b(this.e);
        }
    }

    public final Pair<Long, Long> b(int i) {
        InterceptResult invokeI;
        long c;
        long d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            long currentTimeMillis = i + System.currentTimeMillis();
            do {
                c = a.c();
                d = a.d();
                if (c > 0 && d > 0) {
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100L);
                } catch (InterruptedException e) {
                    ay1.l("SwanAppStabilityData", "sleep 中断", e);
                }
            } while (currentTimeMillis > System.currentTimeMillis());
            ay1.i("SwanAppStabilityData", "fmpTimestamp=" + d + " fmp=" + c);
            return Pair.create(Long.valueOf(d), Long.valueOf(c));
        }
        return (Pair) invokeI.objValue;
    }

    @NonNull
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? String.valueOf(JSONObject.wrap(d())) : (String) invokeV.objValue;
    }

    @NonNull
    public Map<String, String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TreeMap treeMap = new TreeMap();
            try {
                treeMap.put("obtainInterval", String.valueOf(this.a));
                treeMap.put("totalMem", String.valueOf(this.b));
                treeMap.put("prelinkUrlList", JSONObject.wrap(this.c).toString());
                treeMap.put("timestampList", JSONObject.wrap(this.d).toString());
                treeMap.put("fpsList", JSONObject.wrap(this.e).toString());
                treeMap.put("cpuList", JSONObject.wrap(this.f).toString());
                treeMap.put("deviceMemList", JSONObject.wrap(this.g).toString());
                treeMap.put("hostMemList", JSONObject.wrap(this.h).toString());
                treeMap.put("mnpMemList", JSONObject.wrap(this.i).toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("fmp", String.valueOf(this.j.a));
                jSONObject.put("mainPkgSize", String.valueOf(this.j.b));
                jSONObject.put("idleCpuAvg", String.valueOf(this.j.c));
                jSONObject.put("fpsAvg", String.valueOf(this.j.d));
                jSONObject.put("launchMemDiff", String.valueOf(this.j.e));
                jSONObject.put("runningMemDiff", String.valueOf(this.j.f));
                jSONObject.put("launchRequestCount", String.valueOf(this.j.g));
                treeMap.put("verificationData", jSONObject.toString());
            } catch (Exception e) {
                ay1.l("SwanAppStabilityData", "#toMap 出错", e);
            }
            return treeMap;
        }
        return (Map) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "SwanAppStabilityData{mObtainInterval=" + this.a + ", mTotalMem=" + this.b + ", mPrelinkUrlList=" + this.c + ", mTimestampList=" + this.d + ", mFpsList=" + this.e + ", mCpuList=" + this.f + ", mDeviceMemList=" + this.g + ", mHostMemList=" + this.h + ", mMnpMemList=" + this.i + ", mVerificationData=" + this.j + '}';
        }
        return (String) invokeV.objValue;
    }
}
