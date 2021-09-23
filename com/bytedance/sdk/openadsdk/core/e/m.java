package com.bytedance.sdk.openadsdk.core.e;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.ETAG;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public h C;
    public Map<String, Object> D;
    public a E;
    public a F;
    public String G;
    public int H;
    public int I;
    public int J;
    public int K;
    public e L;
    public AdSlot M;
    public int N;
    public int O;
    public String P;
    public int Q;
    public int R;
    public int S;
    public JSONObject T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a  reason: collision with root package name */
    public String f66783a;
    public int aa;
    public int ab;
    public r ac;
    public s ad;
    public boolean ae;
    public String af;
    public int ag;
    public float ah;
    public String ai;
    public o aj;
    public c ak;
    public String al;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.c.b f66784b;

    /* renamed from: c  reason: collision with root package name */
    public int f66785c;

    /* renamed from: d  reason: collision with root package name */
    public l f66786d;

    /* renamed from: e  reason: collision with root package name */
    public String f66787e;

    /* renamed from: f  reason: collision with root package name */
    public int f66788f;

    /* renamed from: g  reason: collision with root package name */
    public String f66789g;

    /* renamed from: h  reason: collision with root package name */
    public JSONObject f66790h;

    /* renamed from: i  reason: collision with root package name */
    public List<l> f66791i;

    /* renamed from: j  reason: collision with root package name */
    public String f66792j;
    public List<String> k;
    public List<String> l;
    public String m;
    public String n;
    public String o;
    public String p;
    public b q;
    public j r;
    public g s;
    public int t;
    public String u;
    public String v;
    public long w;
    public int x;
    public x y;
    public boolean z;

    /* loaded from: classes9.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f66793a;

        /* renamed from: b  reason: collision with root package name */
        public String f66794b;

        /* renamed from: c  reason: collision with root package name */
        public String f66795c;

        /* renamed from: d  reason: collision with root package name */
        public String f66796d;

        /* renamed from: e  reason: collision with root package name */
        public String f66797e;

        /* renamed from: f  reason: collision with root package name */
        public String f66798f;

        /* renamed from: g  reason: collision with root package name */
        public String f66799g;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f66798f : (String) invokeV.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66793a : (String) invokeV.objValue;
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f66794b : (String) invokeV.objValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66795c : (String) invokeV.objValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f66796d : (String) invokeV.objValue;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f66797e : (String) invokeV.objValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f66799g : (String) invokeV.objValue;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f66798f = str;
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f66793a = str;
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.f66794b = str;
            }
        }

        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.f66795c = str;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.f66796d = str;
            }
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                this.f66797e = str;
            }
        }

        public void g(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.f66799g = str;
            }
        }
    }

    public m() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66788f = -1;
        this.f66791i = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.p = "0";
        this.G = "";
        this.H = 0;
        this.I = 2;
        this.J = -200;
        this.K = 0;
        this.L = new e();
        this.O = 1;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.U = 1;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 1;
        this.aa = 0;
        this.ab = 1;
        this.ae = false;
        this.ag = 1;
        this.ah = 100.0f;
    }

    public static boolean a(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mVar)) == null) ? mVar != null && mVar.a() == 1 : invokeL.booleanValue;
    }

    public static boolean b(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mVar)) == null) {
            if (mVar == null) {
                return false;
            }
            return mVar.ap() == 5 || mVar.ap() == 15;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, mVar)) == null) {
            try {
                return mVar.aw().optInt("parent_type") == 1;
            } catch (Exception e2) {
                String str = "isLuBanLandingPage error " + e2;
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean d(m mVar) {
        InterceptResult invokeL;
        x xVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mVar)) == null) ? (mVar == null || (xVar = mVar.y) == null || xVar.a() != 1) ? false : true : invokeL.booleanValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 0;
            }
            return hVar.k();
        }
        return invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 1;
            }
            return hVar.f();
        }
        return invokeV.intValue;
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 1;
            }
            return hVar.g();
        }
        return invokeV.intValue;
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 1;
            }
            return hVar.h();
        }
        return invokeV.intValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            r rVar = this.ac;
            if (rVar == null) {
                return 1;
            }
            return rVar.a();
        }
        return invokeV.intValue;
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            r rVar = this.ac;
            return rVar == null ? "" : rVar.b();
        }
        return (String) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r rVar = this.ac;
            if (rVar == null) {
                return 50;
            }
            return rVar.c();
        }
        return invokeV.intValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            r rVar = this.ac;
            if (rVar == null) {
                return 236;
            }
            return rVar.d();
        }
        return invokeV.intValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            r rVar = this.ac;
            if (rVar == null) {
                return 82;
            }
            return rVar.e();
        }
        return invokeV.intValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            r rVar = this.ac;
            if (rVar == null) {
                return 56;
            }
            return rVar.f();
        }
        return invokeV.intValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            s sVar = this.ad;
            if (sVar == null) {
                return 72;
            }
            return sVar.b();
        }
        return invokeV.intValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            s sVar = this.ad;
            if (sVar == null) {
                return 54;
            }
            return sVar.a();
        }
        return invokeV.intValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            s sVar = this.ad;
            if (sVar == null) {
                return 126;
            }
            return sVar.e();
        }
        return invokeV.intValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            s sVar = this.ad;
            if (sVar == null) {
                return 71;
            }
            return sVar.d();
        }
        return invokeV.intValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            s sVar = this.ad;
            return sVar == null ? "" : sVar.c();
        }
        return (String) invokeV.objValue;
    }

    public a P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E : (a) invokeV.objValue;
    }

    public a Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.F : (a) invokeV.objValue;
    }

    public h R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.C : (h) invokeV.objValue;
    }

    public s S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.ad : (s) invokeV.objValue;
    }

    public c T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.ak : (c) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.al : (String) invokeV.objValue;
    }

    public x V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.y : (x) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.u : (String) invokeV.objValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f66785c : invokeV.intValue;
    }

    public l Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f66786d : (l) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f66787e : (String) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.Y : invokeV.intValue;
    }

    public void a(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            this.ah = f2;
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            this.Y = i2;
        }
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j2) == null) {
            this.w = j2;
        }
    }

    public void a(AdSlot adSlot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, adSlot) == null) {
            this.M = adSlot;
        }
    }

    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            this.q = bVar;
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, cVar) == null) {
            this.ak = cVar;
        }
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, eVar) == null) {
            this.L = eVar;
        }
    }

    public void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, gVar) == null) {
            this.s = gVar;
        }
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, hVar) == null) {
            this.C = hVar;
        }
    }

    public void a(j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jVar) == null) {
            this.r = jVar;
        }
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, lVar) == null) {
            this.f66786d = lVar;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, aVar) == null) {
            this.E = aVar;
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(this);
        }
    }

    public void a(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, oVar) == null) {
            this.aj = oVar;
        }
    }

    public void a(r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, rVar) == null) {
            this.ac = rVar;
        }
    }

    public void a(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, sVar) == null) {
            this.ad = sVar;
        }
    }

    public void a(x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, xVar) == null) {
            this.y = xVar;
        }
    }

    public void a(com.bytedance.sdk.openadsdk.dislike.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bVar) == null) {
            this.f66784b = bVar;
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.G = str;
        }
    }

    public void a(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, map) == null) {
            this.D = map;
        }
    }

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, jSONObject) == null) {
            this.f66790h = jSONObject;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            this.z = z;
        }
    }

    public boolean aA() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? aB() == 1 : invokeV.booleanValue;
    }

    public int aB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.X : invokeV.intValue;
    }

    public String aC() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.f66783a : (String) invokeV.objValue;
    }

    public int aD() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.Z : invokeV.intValue;
    }

    public int aE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.aa : invokeV.intValue;
    }

    public int aF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.ab : invokeV.intValue;
    }

    public com.bytedance.sdk.openadsdk.dislike.c.b aG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            com.bytedance.sdk.openadsdk.dislike.a.a();
            return this.f66784b;
        }
        return (com.bytedance.sdk.openadsdk.dislike.c.b) invokeV.objValue;
    }

    public String aH() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.af : (String) invokeV.objValue;
    }

    public int aI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            if (this.ag != 2) {
                this.ag = 1;
            }
            return this.ag;
        }
        return invokeV.intValue;
    }

    public float aJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            if (this.ah <= 0.0f) {
                this.ah = 100.0f;
            }
            return (this.ah * 1000.0f) / 1000.0f;
        }
        return invokeV.floatValue;
    }

    public boolean aK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.f66791i.isEmpty()) {
                return false;
            }
            if (this.t != 4 || this.f66791i.size() >= 3) {
                for (l lVar : this.f66791i) {
                    if (!lVar.e()) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int aL() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return -1;
            }
            return hVar.b();
        }
        return invokeV.intValue;
    }

    public boolean aM() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            if (aG() != null) {
                return aG().f();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean aN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            int i2 = com.bytedance.sdk.openadsdk.q.q.i(ao());
            return i2 == 3 || i2 == 6;
        }
        return invokeV.booleanValue;
    }

    public String aO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (!TextUtils.isEmpty(this.ai)) {
                this.ai = this.ai.trim();
            }
            return this.ai;
        }
        return (String) invokeV.objValue;
    }

    public JSONObject aP() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("interaction_type", X());
                jSONObject.put("target_url", Z());
                jSONObject.put("use_media_video_player", a());
                jSONObject.put("landing_scroll_percentage", aa());
                jSONObject.put("gecko_id", ab());
                jSONObject.put(ETAG.KEY_EXTENSION, ac());
                jSONObject.put(LegoListActivityConfig.AD_ID, ak());
                jSONObject.put("source", W());
                jSONObject.put("package_name", aC());
                jSONObject.put(StatisticConstants.SCREENSHOT, as());
                jSONObject.put("play_bar_style", k());
                jSONObject.put("play_bar_show_time", t());
                jSONObject.put("if_block_lp", e());
                jSONObject.put("cache_sort", u());
                jSONObject.put("if_sp_cache", v());
                jSONObject.put("render_control", d());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("reward_name", b());
                jSONObject2.put("reward_amount", c());
                jSONObject.put("reward_data", jSONObject2);
                l Y = Y();
                if (Y != null && !TextUtils.isEmpty(Y.a())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("url", Y.a());
                    jSONObject3.put("height", Y.c());
                    jSONObject3.put("width", Y.b());
                    jSONObject.put("icon", jSONObject3);
                }
                JSONObject aw = aw();
                if (aw != null) {
                    jSONObject.put("session_params", aw);
                }
                e l = l();
                if (l != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("click_upper_content_area", l.f66714a);
                    jSONObject4.put("click_upper_non_content_area", l.f66715b);
                    jSONObject4.put("click_lower_content_area", l.f66716c);
                    jSONObject4.put("click_lower_non_content_area", l.f66717d);
                    jSONObject4.put("click_button_area", l.f66718e);
                    jSONObject4.put("click_video_area", l.f66719f);
                    jSONObject.put("click_area", jSONObject4);
                }
                AdSlot m = m();
                if (m != null) {
                    jSONObject.put("adslot", m.toJsonObj());
                }
                List<l> ad = ad();
                if (ad != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (l lVar : ad) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("url", lVar.a());
                        jSONObject5.put("height", lVar.c());
                        jSONObject5.put("width", lVar.b());
                        jSONObject5.put("image_preview", lVar.f());
                        jSONObject5.put("image_key", lVar.g());
                        jSONArray.put(jSONObject5);
                    }
                    jSONObject.put("image", jSONArray);
                }
                List<String> af = af();
                if (af != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : af) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("show_url", jSONArray2);
                }
                List<String> ag = ag();
                if (ag != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (String str2 : ag) {
                        jSONArray3.put(str2);
                    }
                    jSONObject.put("click_url", jSONArray3);
                }
                jSONObject.put(Oauth2AccessToken.KEY_PHONE_NUM, ae());
                jSONObject.put("title", ah());
                jSONObject.put("description", ai());
                jSONObject.put("ext", ao());
                jSONObject.put("image_mode", ap());
                jSONObject.put("intercept_flag", s());
                jSONObject.put(GameGuideConfigInfo.KEY_BUTTON_TEXT, aj());
                jSONObject.put("ad_logo", j());
                jSONObject.put("video_adaptation", i());
                jSONObject.put("feed_video_opentype", h());
                jSONObject.put("orientation", aI());
                jSONObject.put("aspect_ratio", aJ());
                b al = al();
                if (al != null) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("app_name", al.c());
                    jSONObject6.put("package_name", al.d());
                    jSONObject6.put("download_url", al.b());
                    jSONObject6.put("score", al.e());
                    jSONObject6.put("comment_num", al.f());
                    jSONObject6.put("quick_app_url", al.a());
                    jSONObject6.put("app_size", al.g());
                    jSONObject.put("app", jSONObject6);
                }
                j am = am();
                if (am != null) {
                    jSONObject.put("download_sdk_conf", am.c());
                }
                g an = an();
                if (an != null) {
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("deeplink_url", an.a());
                    jSONObject7.put("fallback_url", an.b());
                    jSONObject7.put("fallback_type", an.c());
                    jSONObject.put("deep_link", jSONObject7);
                }
                if (aG() != null) {
                    aG().a(jSONObject);
                }
                g().a(jSONObject);
                jSONObject.put("count_down", ar());
                jSONObject.put(GameGuideConfigInfo.KEY_EXPIRATION_TIME, aq());
                x V = V();
                if (V != null) {
                    jSONObject.put("video", V.p());
                }
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("auto_open", y());
                jSONObject8.put("download_mode", z());
                jSONObject8.put("download_type", aL());
                jSONObject8.put("auto_control", o());
                jSONObject8.put("auto_control_choose", q());
                jSONObject8.put("auto_control_time", r());
                jSONObject8.put("if_suspend_download", x());
                jSONObject8.put("if_send_click", A());
                jSONObject8.put("dl_popup", B());
                jSONObject8.put("market_popup", C());
                jSONObject8.put("if_pop_lp", D());
                jSONObject.put("download_conf", jSONObject8);
                jSONObject.put("if_both_open", ay());
                jSONObject.put("if_double_deeplink", aB());
                JSONObject jSONObject9 = new JSONObject();
                jSONObject8.put("splash_clickarea", E());
                jSONObject8.put("splash_clicktext", F());
                jSONObject8.put("area_height", G());
                jSONObject8.put("area_width", H());
                jSONObject8.put("area_blank_height", I());
                jSONObject8.put("half_blank_height", J());
                jSONObject.put("splash_control", jSONObject9);
                JSONObject jSONObject10 = new JSONObject();
                jSONObject8.put("splash_icon_height", K());
                jSONObject8.put("splash_icon_url", O());
                jSONObject8.put("splash_icon_video_height", M());
                jSONObject8.put("splash_icon_video_width", N());
                jSONObject8.put("splash_icon_width", L());
                jSONObject.put("splash_icon", jSONObject10);
                if (av() != null) {
                    JSONObject jSONObject11 = new JSONObject();
                    Set<Map.Entry<String, Object>> entrySet = av().entrySet();
                    if (entrySet != null && !entrySet.isEmpty()) {
                        for (Map.Entry<String, Object> entry : entrySet) {
                            jSONObject11.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("media_ext", jSONObject11);
                }
                jSONObject.put("landing_page_type", aD());
                a P = P();
                if (P != null) {
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("id", P.b());
                    jSONObject12.put(PackageTable.MD5, P.c());
                    jSONObject12.put("url", P.d());
                    jSONObject12.put("data", P.e());
                    jSONObject12.put("diff_data", P.f());
                    jSONObject12.put("version", P.a());
                    jSONObject12.put("dynamic_creative", P.g());
                    jSONObject.put("tpl_info", jSONObject12);
                }
                a Q = Q();
                if (Q != null) {
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("middle_id", Q.b());
                    jSONObject13.put("middle_md5", Q.c());
                    jSONObject13.put("middle_url", Q.d());
                    jSONObject13.put("middle_data", Q.e());
                    jSONObject13.put("middle_diff_data", Q.f());
                    jSONObject13.put("middle_version", Q.a());
                    jSONObject13.put("middle_dynamic_creative", Q.g());
                    jSONObject.put("middle_tpl_info", jSONObject13);
                }
                jSONObject.put("market_url", ax());
                jSONObject.put("close_on_dislike", aQ());
                c T = T();
                if (T != null) {
                    JSONObject jSONObject14 = new JSONObject();
                    jSONObject14.put("developer_name", T.c());
                    jSONObject14.put("app_version", T.b());
                    jSONObject14.put("permissions", T.e());
                    jSONObject14.put("privacy_policy_url", T.d());
                    jSONObject14.put("package_name", T.f());
                    jSONObject14.put("app_name", T.g());
                    jSONObject.put("app_manage", jSONObject14);
                }
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("render_sequence", aE());
                jSONObject15.put("backup_render_control", aF());
                jSONObject.put("render", jSONObject15);
                jSONObject.put("ad_info", aH());
                jSONObject.put("adx_name", aO());
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public boolean aQ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.ae : invokeV.booleanValue;
    }

    public int aa() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.f66788f : invokeV.intValue;
    }

    public String ab() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.f66789g : (String) invokeV.objValue;
    }

    public JSONObject ac() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.f66790h : (JSONObject) invokeV.objValue;
    }

    public List<l> ad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.f66791i : (List) invokeV.objValue;
    }

    public String ae() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.f66792j : (String) invokeV.objValue;
    }

    public List<String> af() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    public List<String> ag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.l : (List) invokeV.objValue;
    }

    public String ah() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.m : (String) invokeV.objValue;
    }

    public String ai() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public String aj() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.o : (String) invokeV.objValue;
    }

    public String ak() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public b al() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.q : (b) invokeV.objValue;
    }

    public j am() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.r : (j) invokeV.objValue;
    }

    public g an() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.s : (g) invokeV.objValue;
    }

    public String ao() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.v : (String) invokeV.objValue;
    }

    public int ap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.t : invokeV.intValue;
    }

    public long aq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.w : invokeV.longValue;
    }

    public int ar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.x : invokeV.intValue;
    }

    public boolean as() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean at() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean au() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public Map<String, Object> av() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.D : (Map) invokeV.objValue;
    }

    public JSONObject aw() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.T : (JSONObject) invokeV.objValue;
    }

    public String ax() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.P : (String) invokeV.objValue;
    }

    public int ay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.W : invokeV.intValue;
    }

    public boolean az() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? ay() == 1 : invokeV.booleanValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048668, this, i2) == null) {
            this.H = i2;
        }
    }

    public void b(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, lVar) == null) {
            this.f66791i.add(lVar);
        }
    }

    public void b(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, aVar) == null) {
            this.F = aVar;
            com.bytedance.sdk.openadsdk.core.widget.webview.a.a.b(this);
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
            this.al = str;
        }
    }

    public void b(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, jSONObject) == null) {
            this.T = jSONObject;
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048673, this, z) == null) {
            this.A = z;
        }
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.H : invokeV.intValue;
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048675, this, i2) == null) {
            this.I = i2;
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.u = str;
        }
    }

    public void c(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048677, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        this.f66785c = 4;
        this.p = jSONObject.optString("id");
        this.u = jSONObject.optString("source");
        b bVar = new b();
        this.q = bVar;
        bVar.d(jSONObject.optString(EmotionResourceInfo.JSON_KEY_PKG_NAME));
        this.q.c(jSONObject.optString("name"));
        this.q.b(jSONObject.optString("download_url"));
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048678, this, z) == null) {
            this.B = z;
        }
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.I : invokeV.intValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048680, this, i2) == null) {
            this.Q = i2;
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, str) == null) {
            this.f66787e = str;
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z) == null) {
            this.ae = z;
        }
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.Q : invokeV.intValue;
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            this.S = i2;
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
            this.f66789g = str;
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            m mVar = (m) obj;
            return this.p.equals(mVar.p) && this.v.equals(mVar.v);
        }
        return invokeL.booleanValue;
    }

    public void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            this.R = i2;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048688, this, str) == null) {
            this.f66792j = str;
        }
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.Q == 1 : invokeV.booleanValue;
    }

    public o g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.aj : (o) invokeV.objValue;
    }

    public void g(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048691, this, i2) == null) {
            this.O = i2;
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, str) == null) {
            this.m = str;
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? this.S : invokeV.intValue;
    }

    public void h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048694, this, i2) == null) {
            this.K = i2;
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048695, this, str) == null) {
            this.n = str;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? (this.p.hashCode() * 31) + this.v.hashCode() : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.R : invokeV.intValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048698, this, i2) == null) {
            this.N = i2;
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, str) == null) {
            this.o = str;
        }
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.O : invokeV.intValue;
    }

    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048701, this, i2) == null) {
            this.J = i2;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, str) == null) {
            this.p = str;
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            if (aJ() != 100.0f || d() == 2) {
                return 0;
            }
            return this.K;
        }
        return invokeV.intValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i2) == null) {
            this.U = i2;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048705, this, str) == null) {
            this.v = str;
        }
    }

    public e l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) ? this.L : (e) invokeV.objValue;
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048707, this, i2) == null) {
            this.V = i2;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048708, this, str) == null) {
            this.P = str;
        }
    }

    public AdSlot m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? this.M : (AdSlot) invokeV.objValue;
    }

    public void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048710, this, i2) == null) {
            this.f66785c = i2;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, str) == null) {
            this.f66783a = str;
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048712, this, i2) == null) {
            this.f66788f = i2;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048713, this, str) == null) {
            this.af = str;
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? o() == 1 : invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 0;
            }
            return hVar.e();
        }
        return invokeV.intValue;
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048716, this, i2) == null) {
            this.t = i2;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, str) == null) {
            this.ai = str;
        }
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i2) == null) {
            this.x = i2;
        }
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? q() == 1 : invokeV.booleanValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 0;
            }
            return hVar.i();
        }
        return invokeV.intValue;
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i2) == null) {
            this.W = i2;
        }
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 300;
            }
            return hVar.j();
        }
        return invokeV.intValue;
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048723, this, i2) == null) {
            this.X = i2;
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.N : invokeV.intValue;
    }

    public void s(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048725, this, i2) == null) {
            this.Z = i2;
        }
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.J : invokeV.intValue;
    }

    public void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i2) == null) {
            this.aa = i2;
        }
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.U : invokeV.intValue;
    }

    public void u(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i2) == null) {
            this.ab = i2;
        }
    }

    public int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.V : invokeV.intValue;
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048731, this, i2) == null) {
            this.ag = i2;
        }
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? x() == 1 : invokeV.booleanValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 1;
            }
            return hVar.a();
        }
        return invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 1;
            }
            return hVar.c();
        }
        return invokeV.intValue;
    }

    public int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            h hVar = this.C;
            if (hVar == null) {
                return 0;
            }
            return hVar.d();
        }
        return invokeV.intValue;
    }
}
