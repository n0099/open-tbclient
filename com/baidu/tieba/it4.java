package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.MissionInfo;
/* loaded from: classes6.dex */
public class it4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String D = "activityid";
    public static String E = "missionid";
    public static String F = "activitysource";
    public static String G = "source";
    public static String H = "tab";
    public static String I = "calltype";
    public static String J = "tasktype";
    public static String K = "browsetimepage";
    public static String L = "browsetime";
    public static String M = "threadnum";
    public static String N = "forumnum";
    public static String O = "cleartype";
    public static String P = "cleartime";
    public static String Q = "tid";
    public static String R = "fid";
    public static String S = "threadtext";

    /* renamed from: T  reason: collision with root package name */
    public static String f1139T = "threadimg";
    public static String U = "threadforum";
    public static String V = "tab_code";
    public static String W = "wise_sample_id";
    public static String X = "total_limit";
    public static int Y = -1;
    public static int Z = 1;
    public static int a0 = 2;
    public static int b0 = 3;
    public static int c0 = 8;
    public static int d0 = 9;
    public static int e0 = 10;
    public static int f0 = -1;
    public static int g0 = 0;
    public static int h0 = 1;
    public static int i0 = 2;
    public static int j0 = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public final ArrayList<ot4> C;
    public int a;
    public int b;
    public int c;
    public long d;
    public String e;
    public int f;
    public int g;
    public long h;
    public long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public long o;
    public int p;
    public long q;
    public int[] r;
    public long s;
    public int t;
    public volatile int u;
    public volatile int v;
    public boolean w;
    public int x;
    public volatile int y;
    public boolean z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947865024, "Lcom/baidu/tieba/it4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947865024, "Lcom/baidu/tieba/it4;");
        }
    }

    public it4() {
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
        this.p = f0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.C = new ArrayList<>();
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int size = this.C.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                ot4 ot4Var = (ot4) ListUtils.getItem(this.C, i2);
                if ((ot4Var instanceof rt4) && ((rt4) ot4Var).d() == w()) {
                    i++;
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public it4(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.p = f0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.C = new ArrayList<>();
        O(str);
    }

    public final int[] R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            int i = this.c;
            if (i == 8) {
                return new int[]{Y};
            }
            if (i == 7) {
                return new int[]{Z, c0, d0};
            }
            if (str == null) {
                return null;
            }
            String[] split = str.split(",");
            int[] iArr = new int[split.length];
            for (int i2 = 0; i2 < split.length; i2++) {
                int i3 = JavaTypesHelper.toInt(split[i2], 0);
                if (i3 != 0) {
                    iArr[i2] = i3;
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public it4(MissionInfo missionInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {missionInfo};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.p = f0;
        this.u = 0;
        this.v = 0;
        this.w = false;
        this.x = 1;
        this.y = 0;
        this.z = false;
        this.C = new ArrayList<>();
        if (missionInfo == null) {
            return;
        }
        this.a = missionInfo.activityid.intValue();
        this.b = missionInfo.missionid.intValue();
        this.c = missionInfo.tasktype.intValue();
        this.p = missionInfo.cleartype.intValue();
        this.q = missionInfo.cleartime.intValue();
        this.s = c();
        String str = missionInfo.browsetimepage;
        this.e = str;
        this.r = R(str);
        if (missionInfo.threadnum.intValue() > 0) {
            this.f = missionInfo.threadnum.intValue();
        }
        if (missionInfo.browsetime.intValue() > 0) {
            this.d = missionInfo.browsetime.intValue();
        }
        if (missionInfo.total_limit.intValue() > 0) {
            this.x = missionInfo.total_limit.intValue();
        }
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.m;
        }
        return (String) invokeV.objValue;
    }

    public long C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.A;
        }
        return (String) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public synchronized int H() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = this.v + 1;
                this.v = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int I() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                i = this.y + 1;
                this.y = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int J() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                i = this.u + 1;
                this.u = i;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.a > 0 && this.b > 0 && this.c > 0 && this.d > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (System.currentTimeMillis() > t() * 1000) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.C.clear();
            this.u = 0;
            this.v = 0;
            this.y = 0;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public int[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.r;
        }
        return (int[]) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.t;
        }
        return invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public ArrayList<ot4> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.C;
        }
        return (ArrayList) invokeV.objValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.i;
        }
        return invokeV.longValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            int size = this.C.size();
            for (int i = 0; i < size; i++) {
                ot4 ot4Var = (ot4) ListUtils.getItem(this.C, i);
                if (ot4Var != null) {
                    ot4Var.f(true);
                }
            }
        }
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.l;
        }
        return (String) invokeV.objValue;
    }

    public long t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.s;
        }
        return invokeV.longValue;
    }

    public final long u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis();
        }
        return invokeV.longValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.k;
        }
        return (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.o;
        }
        return invokeV.longValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.n;
        }
        return (String) invokeV.objValue;
    }

    public final long D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            long u = u();
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, i);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTimeInMillis() - u;
        }
        return invokeI.longValue;
    }

    public boolean K(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048586, this, j)) == null) {
            for (int i = 0; i < this.C.size(); i++) {
                ot4 ot4Var = (ot4) ListUtils.getItem(this.C, i);
                if (ot4Var != null) {
                    long m = m(ot4Var);
                    if (m > 0 && m == j && ot4Var.e()) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public long m(ot4 ot4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, ot4Var)) == null) {
            if (ot4Var == null) {
                return 0L;
            }
            if (this.c == 7 && (ot4Var instanceof rt4)) {
                return ((rt4) ot4Var).i();
            }
            if (this.c == 1 && (ot4Var instanceof tt4)) {
                return ((tt4) ot4Var).i();
            }
            if (this.c != 2 || !(ot4Var instanceof qt4)) {
                return 0L;
            }
            return ((qt4) ot4Var).i();
        }
        return invokeL.longValue;
    }

    public boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (di.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.a = jSONObject.optInt(D);
                this.b = jSONObject.optInt(E);
                this.j = jSONObject.optString(F);
                this.l = jSONObject.optString(G);
                this.k = jSONObject.optString(H);
                this.t = jSONObject.optInt(I);
                int optInt = jSONObject.optInt(J);
                this.c = optInt;
                if (optInt == 15) {
                    this.c = 4;
                }
                String optString = jSONObject.optString(K);
                this.e = optString;
                this.r = R(optString);
                this.d = jSONObject.optLong(L);
                this.f = jSONObject.optInt(M);
                this.g = jSONObject.optInt(N);
                this.p = jSONObject.optInt(O);
                this.q = jSONObject.optLong(P);
                this.s = c();
                this.h = jSONObject.optLong(Q);
                this.i = jSONObject.optLong(R);
                this.m = jSONObject.optString(S);
                this.n = jSONObject.optString(f1139T);
                this.o = jSONObject.optLong(U);
                int optInt2 = jSONObject.optInt(X);
                if (optInt2 > 0) {
                    this.x = optInt2;
                }
                String optString2 = jSONObject.optString(V);
                if (!TextUtils.isEmpty(optString2)) {
                    String valueOf = String.valueOf(optString2.hashCode());
                    this.e = valueOf;
                    this.r = R(valueOf);
                }
                this.B = jSONObject.optString(W);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public void P(ActiveCenterData.ActiveCenterMissionData activeCenterMissionData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, activeCenterMissionData) == null) && activeCenterMissionData != null) {
            c0(activeCenterMissionData.mission_id);
            n0(activeCenterMissionData.total_limit);
            g0(activeCenterMissionData.task_type);
            T(activeCenterMissionData.active_id);
            Z(activeCenterMissionData.cleartype);
            Y(activeCenterMissionData.cleartime);
        }
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.a = i;
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.j = str;
        }
    }

    public void V(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.d = j;
        }
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.e = str;
            this.r = R(str);
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.t = i;
        }
    }

    public void Y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.q = j;
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.p = i;
        }
    }

    public void a0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.i = j;
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.g = i;
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.b = i;
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.w = z;
        }
    }

    public void e0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048611, this, j) == null) {
            this.s = j;
        }
    }

    public void f0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i) == null) {
            this.y = i;
        }
    }

    public void g0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.c = i;
        }
    }

    public void h0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048617, this, j) == null) {
            this.o = j;
        }
    }

    public void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.n = str;
        }
    }

    public void j0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.f = i;
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.m = str;
        }
    }

    public void l0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048625, this, j) == null) {
            this.h = j;
        }
    }

    public void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.A = str;
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
            this.x = i;
        }
    }

    public void Q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, str) == null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    long optLong = jSONObject.optLong("i");
                    long optLong2 = jSONObject.optLong("t");
                    boolean optBoolean = jSONObject.optBoolean("c");
                    int optInt = jSONObject.optInt("a");
                    if (i == 7) {
                        if (optLong > 0) {
                            rt4 rt4Var = new rt4(this, optLong);
                            rt4Var.f(optBoolean);
                            rt4Var.g(optLong2);
                            rt4Var.h(optInt);
                            a(rt4Var);
                        }
                    } else if (i == 1) {
                        if (optLong > 0) {
                            tt4 tt4Var = new tt4(this, optLong);
                            tt4Var.f(optBoolean);
                            tt4Var.g(optLong2);
                            tt4Var.h(optInt);
                            a(tt4Var);
                        }
                    } else if (i == 2) {
                        if (optLong > 0) {
                            qt4 qt4Var = new qt4(this, optLong);
                            qt4Var.f(optBoolean);
                            qt4Var.g(optLong2);
                            qt4Var.h(optInt);
                            a(qt4Var);
                        }
                    } else if (i == 4) {
                        pt4 pt4Var = new pt4(this);
                        pt4Var.f(optBoolean);
                        pt4Var.g(optLong2);
                        pt4Var.h(optInt);
                        a(pt4Var);
                    } else if (i == 8) {
                        st4 st4Var = new st4(this);
                        st4Var.f(optBoolean);
                        st4Var.g(optLong2);
                        st4Var.h(optInt);
                        a(st4Var);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a(ot4 ot4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ot4Var) == null) {
            if (this.c == 7 && (ot4Var instanceof rt4)) {
                if (!this.C.contains(ot4Var)) {
                    this.C.add(ot4Var);
                }
            } else if (this.c == 1 && (ot4Var instanceof tt4)) {
                if (!this.C.contains(ot4Var)) {
                    this.C.add(ot4Var);
                }
            } else if (this.c == 2 && (ot4Var instanceof qt4)) {
                if (!this.C.contains(ot4Var)) {
                    this.C.add(ot4Var);
                }
            } else if (this.c == 4 && (ot4Var instanceof pt4)) {
                if (!this.C.contains(ot4Var)) {
                    this.C.add(ot4Var);
                }
            } else if (this.c == 8 && (ot4Var instanceof st4) && !this.C.contains(ot4Var)) {
                this.C.add(ot4Var);
            }
        }
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            try {
                ArrayList<ot4> arrayList = this.C;
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < arrayList.size(); i++) {
                    ot4 ot4Var = (ot4) ListUtils.getItem(arrayList, i);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("i", m(ot4Var));
                    jSONObject.put("t", ot4Var.b());
                    jSONObject.put("c", ot4Var.e());
                    jSONObject.put("a", ot4Var.d());
                    jSONArray.put(jSONObject);
                }
                return jSONArray.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return "[]";
            }
        }
        return (String) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            int i = this.p;
            if (i == f0) {
                return 0L;
            }
            if (i == g0) {
                return this.q + (System.currentTimeMillis() / 1000);
            }
            if (i == h0) {
                long u = this.q + (u() / 1000);
                if (System.currentTimeMillis() > u) {
                    return u + 86400;
                }
                return u;
            } else if (i == i0) {
                return r((int) this.q, D(4)) / 1000;
            } else {
                if (i != j0) {
                    return 0L;
                }
                return this.q / 1000;
            }
        }
        return invokeV.longValue;
    }

    public final long r(int i, long j) {
        InterceptResult invokeCommon;
        long timeInMillis;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            switch (i) {
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 3;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 6;
                    break;
                case 6:
                    i = 7;
                    break;
                case 7:
                    i = 1;
                    break;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            long timeInMillis2 = calendar.getTimeInMillis();
            if (calendar.get(7) == i && System.currentTimeMillis() - timeInMillis2 < j) {
                timeInMillis = calendar.getTimeInMillis();
            } else {
                do {
                    calendar.add(5, 1);
                } while (calendar.get(7) != i);
                timeInMillis = calendar.getTimeInMillis();
            }
            return timeInMillis + j;
        }
        return invokeCommon.longValue;
    }
}
