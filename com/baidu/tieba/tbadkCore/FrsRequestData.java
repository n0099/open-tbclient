package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.w;
import c.a.p0.i0.b.d;
import c.a.p0.i0.b.g;
import c.a.q0.x2.j0.a;
import c.a.q0.x2.l0.b;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.FrsPage.AdParam;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes7.dex */
public class FrsRequestData extends OrmObject implements g, d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CATEGORY_ID_KEY = "categoryid";
    public static final int FRS_SMARTLOAD_TYPE_BY_REFRESH = 1;
    public static final int FRS_SMART_LOAD_TYPE_BY_MORE = 2;
    public static final int FRS_SORT_TYPE_BY_LIKED_SORT = 4;
    public static final int FRS_SORT_TYPE_BY_LIKE_USER = 2;
    public static final int FRS_SORT_TYPE_BY_REPLY_TIME = 0;
    public static final int FRS_SORT_TYPE_BY_SEND_TYPE = 1;
    public static final int FRS_SORT_TYPE_BY_SMART_SORT = 3;
    public static final int FRS_SORT_TYPE_DEFAULT_VALUE = -1;
    public static final int IS_GOOD = 1;
    public static final int IS_NOT_GOOD = 0;
    public static final int THREAD_NUM_LOAD = 30;
    public static final int THREAD_NUM_PAGE = 90;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public String E;
    public String F;
    public int G;
    public int H;
    public HashMap<String, String> I;
    public long J;
    public int K;
    public String L;
    public int M;
    public String N;

    /* renamed from: e  reason: collision with root package name */
    public int f56889e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f56890f;

    /* renamed from: g  reason: collision with root package name */
    public String f56891g;

    /* renamed from: h  reason: collision with root package name */
    public int f56892h;

    /* renamed from: i  reason: collision with root package name */
    public int f56893i;

    /* renamed from: j  reason: collision with root package name */
    public int f56894j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public double p;
    public int q;
    public String r;
    public String s;
    public int t;
    public String u;
    public int v;
    public int w;
    public int x;
    public int y;
    public long z;

    public FrsRequestData() {
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
        this.f56893i = 90;
        this.f56894j = 30;
        this.u = "";
        this.A = -1;
        this.B = 1;
        this.G = 0;
        this.H = 0;
        this.I = null;
        this.J = 0L;
        this.K = 0;
        this.L = "";
        this.M = -1;
        this.N = "";
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.B : invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.A : invokeV.intValue;
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.N = str;
        }
    }

    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.t = i2;
        }
    }

    public void E(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.m = i2;
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.w = i2;
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.x = i2;
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.M = i2;
        }
    }

    public void I(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            this.J = j2;
        }
    }

    public void J(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.K = i2;
        }
    }

    public void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.l = i2;
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.G = i2;
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f56891g = str;
        }
    }

    public void N(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j2) == null) {
            this.z = j2;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.s = str;
        }
    }

    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.C = i2;
        }
    }

    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.B = i2;
        }
    }

    public void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.y = i2;
        }
    }

    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.E = str;
        }
    }

    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.F = str;
        }
    }

    public void U(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.D = i2;
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.L = str;
        }
    }

    public void W(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Double.valueOf(d2)}) == null) {
            this.p = d2;
        }
    }

    public void X(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.o = i2;
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.n = i2;
        }
    }

    public void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.k = i2;
        }
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.u = str;
        }
    }

    public void b0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.q = i2;
        }
    }

    @Override // c.a.p0.i0.b.i
    public Object c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.kw = this.f56891g;
            builder.pn = Integer.valueOf(this.f56892h);
            builder.rn = Integer.valueOf(this.f56893i);
            builder.rn_need = Integer.valueOf(this.f56894j);
            builder.with_group = Integer.valueOf(this.k);
            builder.is_good = Integer.valueOf(this.l);
            builder.cid = Integer.valueOf(this.m);
            builder.scr_w = Integer.valueOf(this.n);
            builder.scr_h = Integer.valueOf(this.o);
            builder.scr_dip = Double.valueOf(this.p);
            builder.st_type = this.r;
            builder.q_type = Integer.valueOf(this.q);
            builder.st_param = Integer.valueOf(this.v);
            builder.ctime = Integer.valueOf(this.w);
            builder.data_size = Integer.valueOf(this.x);
            builder.net_error = Integer.valueOf(this.y);
            builder.lastids = this.s;
            builder.category_id = Integer.valueOf(this.t);
            builder.yuelaou_locate = this.u;
            builder.sort_type = Integer.valueOf(this.A);
            builder.last_click_tid = Long.valueOf(this.z);
            builder.app_pos = a.e().a();
            builder.load_type = Integer.valueOf(this.B);
            builder.obj_locate = this.E;
            builder.obj_source = this.F;
            builder.is_selection = Integer.valueOf(this.G);
            builder.call_from = Integer.valueOf(this.H);
            builder.hot_thread_id = Long.valueOf(this.J);
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.refresh_count = Integer.valueOf(this.D);
            builder2.load_count = Integer.valueOf(this.C);
            builder2.yoga_lib_version = "";
            builder.ad_param = builder2.build(false);
            builder.is_default_navtab = Integer.valueOf(this.K);
            builder.ad_context_list = this.B != 1 ? b.f().d("FRS") : "";
            builder.up_schema = this.L;
            builder.default_sort_type = Integer.valueOf(this.M);
            AdExtParam.a b2 = AdExtParam.a.b();
            b2.e(this.N);
            builder.ad_ext_params = b2.a();
            w.c(builder, true, false, true);
            FrsPageReqIdl.Builder builder3 = new FrsPageReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        }
        return invokeZ.objValue;
    }

    @Override // c.a.p0.i0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getCid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.m : invokeV.intValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.f56892h : invokeV.intValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f56889e : invokeV.intValue;
    }

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f56890f : invokeV.booleanValue;
    }

    @Override // c.a.p0.i0.b.d
    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.i0.b.d
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.i0.b.f
    public HashMap<String, Object> s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    public void setCallFrom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            this.H = i2;
        }
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.f56890f = z;
        }
    }

    public void setPn(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.f56892h = i2;
        }
    }

    public void setSortType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.A = i2;
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.r = str;
        }
    }

    public void setUpdateType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.f56889e = i2;
        }
    }

    @Override // c.a.p0.i0.b.f
    public HashMap<String, String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.I : (HashMap) invokeV.objValue;
    }

    @Override // c.a.p0.i0.b.d
    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) {
            if (this.I == null) {
                this.I = new HashMap<>();
            }
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            this.I.put(str, str2);
        }
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.t : invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.l : invokeV.intValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f56891g : (String) invokeV.objValue;
    }
}
