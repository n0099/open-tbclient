package com.baidu.tieba.tbadkCore;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.data.INetRequestData;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.tieba.ad;
import com.baidu.tieba.bt7;
import com.baidu.tieba.h1a;
import com.baidu.tieba.pq5;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.tieba.uq5;
import com.baidu.tieba.xl5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import tbclient.FrsPage.AdParam;
import tbclient.FrsPage.DataReq;
import tbclient.FrsPage.FrsPageReqIdl;
/* loaded from: classes8.dex */
public class FrsRequestData extends OrmObject implements INetRequestData, xl5 {
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
    public String C;
    public String D;
    public int E;
    public int F;
    public HashMap<String, String> G;
    public long H;
    public int I;
    public String J;
    public int K;
    public String L;
    public long M;
    public int a;
    public boolean b;
    public String c;
    public String d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public double m;
    public int n;
    public String o;
    public String p;
    public int q;
    public int r;
    public String s;
    public int t;
    public int u;
    public int v;
    public int w;
    public long x;
    public int y;
    public int z;

    @Override // com.baidu.tieba.wl5
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xl5
    public String getCacheTableName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xl5
    public boolean isNeedUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, Object> makeHttpParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return null;
        }
        return (HashMap) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xl5
    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public FrsRequestData() {
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
        this.f = 90;
        this.g = 30;
        this.s = "";
        this.y = -1;
        this.z = 1;
        this.E = 0;
        this.F = 0;
        this.G = null;
        this.H = 0L;
        this.I = 0;
        this.J = "";
        this.K = -1;
        this.L = "";
    }

    public void N(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) {
            if (this.G == null) {
                this.G = new HashMap<>();
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.G.put(str, str2);
            }
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.z;
        }
        return invokeV.intValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.mvc.data.IHttpParamRequestData
    public HashMap<String, String> getHttpHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.G;
        }
        return (HashMap) invokeV.objValue;
    }

    public int getPn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int getUpdateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public boolean isNeedCache() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.L = str;
        }
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.q = i;
        }
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.j = i;
        }
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.u = i;
        }
    }

    public void Y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.v = i;
        }
    }

    public void Z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.K = i;
        }
    }

    public void a0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.H = j;
        }
    }

    public void b0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.I = i;
        }
    }

    public void c0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.i = i;
        }
    }

    public void d0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.E = i;
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.c = str;
            this.d = ad.getUrlEncode(str);
        }
    }

    public void f0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.x = j;
        }
    }

    public void g0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.p = str;
        }
    }

    public void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.A = i;
        }
    }

    public void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.z = i;
        }
    }

    public void j0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.w = i;
        }
    }

    public void k0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.C = str;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            this.D = str;
        }
    }

    public void m0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.B = i;
        }
    }

    public void n0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.r = i;
        }
    }

    public void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.J = str;
        }
    }

    public void p0(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Double.valueOf(d)}) == null) {
            this.m = d;
        }
    }

    public void q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.l = i;
        }
    }

    public void r0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.k = i;
        }
    }

    public void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.h = i;
        }
    }

    public void setCallFrom(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.F = i;
        }
    }

    public void setNeedCache(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
            this.b = z;
        }
    }

    public void setPn(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.e = i;
        }
    }

    public void setPushTid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.M = JavaTypesHelper.toLong(str, 0L);
        }
    }

    public void setSortType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.y = i;
        }
    }

    public void setStType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.o = str;
        }
    }

    public void setUpdateType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.a = i;
        }
    }

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.s = str;
        }
    }

    public void u0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.n = i;
        }
    }

    @Override // com.baidu.tbadk.mvc.data.ISocketProtobufRequestData
    public Object encodeSocketRequestData(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048594, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.kw = this.d;
            builder.pn = Integer.valueOf(this.e);
            builder.rn = Integer.valueOf(this.f);
            builder.rn_need = Integer.valueOf(this.g);
            builder.with_group = Integer.valueOf(this.h);
            builder.is_good = Integer.valueOf(this.i);
            builder.cid = Integer.valueOf(this.j);
            builder.scr_w = Integer.valueOf(this.k);
            builder.scr_h = Integer.valueOf(this.l);
            builder.scr_dip = Double.valueOf(this.m);
            builder.st_type = this.o;
            builder.q_type = Integer.valueOf(this.n);
            builder.st_param = Integer.valueOf(this.t);
            builder.ctime = Integer.valueOf(this.u);
            builder.data_size = Integer.valueOf(this.v);
            builder.net_error = Integer.valueOf(this.w);
            builder.lastids = this.p;
            builder.category_id = Integer.valueOf(this.q);
            builder.request_times = Integer.valueOf(this.r);
            builder.yuelaou_locate = this.s;
            builder.sort_type = Integer.valueOf(this.y);
            builder.last_click_tid = Long.valueOf(this.x);
            builder.app_pos = LocationCacheData.getInstance().createAppPosInfo();
            builder.load_type = Integer.valueOf(this.z);
            builder.obj_locate = this.C;
            builder.obj_source = this.D;
            builder.is_selection = Integer.valueOf(this.E);
            builder.call_from = Integer.valueOf(this.F);
            builder.hot_thread_id = Long.valueOf(this.H);
            String d = bt7.e().d("frs_feed");
            builder.ad_bear_sid = d;
            builder.ad_bear_context = pq5.f(d, pq5.e());
            builder.ad_bear_sid_price = Double.valueOf(pq5.h());
            builder.has_ad_bear = Integer.valueOf(pq5.m(builder.ad_bear_sid) ? 1 : 0);
            AdParam.Builder builder2 = new AdParam.Builder();
            builder2.refresh_count = Integer.valueOf(this.B);
            builder2.load_count = Integer.valueOf(this.A);
            String str = "";
            builder2.yoga_lib_version = "";
            builder.ad_param = builder2.build(false);
            builder.is_default_navtab = Integer.valueOf(this.I);
            if (this.z != 1) {
                str = h1a.f().d("FRS");
            }
            builder.ad_context_list = str;
            builder.up_schema = this.J;
            builder.default_sort_type = Integer.valueOf(this.K);
            AdExtParam.a b = AdExtParam.a.b();
            b.e(this.L);
            builder.ad_ext_params = b.a();
            builder.app_transmit_data = uq5.b();
            builder.push_tid = Long.valueOf(this.M);
            NetMessageHelper.bindCommonParamsToProtobufData(builder, true, false, true);
            FrsPageReqIdl.Builder builder3 = new FrsPageReqIdl.Builder();
            builder3.data = builder.build(false);
            return builder3.build(false);
        }
        return invokeZ.objValue;
    }
}
