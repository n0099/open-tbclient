package com.baidu.tieba.tbadkCore.util;

import android.location.Address;
import c.a.d.f.i.a;
import c.a.d.f.p.m;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.loc.str.BDLocManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class MercatorModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final a.c f49854b;

    /* loaded from: classes12.dex */
    public static class MercatorData extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f49855e;

        /* renamed from: f  reason: collision with root package name */
        public String f49856f;

        /* renamed from: g  reason: collision with root package name */
        public String f49857g;

        /* renamed from: h  reason: collision with root package name */
        public int f49858h;

        /* renamed from: i  reason: collision with root package name */
        public long f49859i;

        /* renamed from: j  reason: collision with root package name */
        public String f49860j;

        /* renamed from: k  reason: collision with root package name */
        public String f49861k;
        public String l;

        public MercatorData() {
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

        public String A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49855e : (String) invokeV.objValue;
        }

        public String B() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49860j : (String) invokeV.objValue;
        }

        public String C() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f49857g : (String) invokeV.objValue;
        }

        public long D() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f49859i : invokeV.longValue;
        }

        public int w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f49858h : invokeV.intValue;
        }

        public String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f49861k : (String) invokeV.objValue;
        }

        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.l : (String) invokeV.objValue;
        }

        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f49856f : (String) invokeV.objValue;
        }

        public MercatorData(String str, String str2, String str3, int i2, long j2, String str4, String str5, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2), str4, str5, str6};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f49855e = str;
            this.f49856f = str2;
            this.f49857g = str3;
            this.f49858h = i2;
            this.f49859i = j2;
            this.f49860j = str4;
            this.f49861k = str5;
            this.l = str6;
        }
    }

    /* loaded from: classes12.dex */
    public static class MercatorLocationResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MercatorLocationResponseMessage(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, jSONObject) == null) {
                super.decodeLogicInBackGround(i2, jSONObject);
                if (jSONObject == null) {
                    return;
                }
                MercatorModel.g(new MercatorData(jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LON), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LAT), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_RADIUS), jSONObject.optInt(SearchJsBridge.COOKIE_MERCATOR_CITY), jSONObject.optLong(SearchJsBridge.COOKIE_MERCATOR_TIME), jSONObject.optString("mercator_province_name"), jSONObject.optString("mercator_city_name"), jSONObject.optString("mercator_district_name")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class MercatorRequestHttpMessage extends HttpMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isFromHomePageTabFeedFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MercatorRequestHttpMessage(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public boolean isFromHomePageTabFeedFragment() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.isFromHomePageTabFeedFragment : invokeV.booleanValue;
        }

        public void setFromHomePageTabFeedFragment(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.isFromHomePageTabFeedFragment = z;
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MercatorModel a;

        public a(MercatorModel mercatorModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mercatorModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mercatorModel;
        }

        @Override // c.a.d.f.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i2 == 0 && address != null && inst != null && !this.a.a) {
                    this.a.a = true;
                    String valueOf = String.valueOf(address.getLatitude());
                    String valueOf2 = String.valueOf(address.getLongitude());
                    String locString = BDLocManager.getInstance(inst).getLocString();
                    String version = TbConfig.getVersion();
                    String cuid = TbadkCoreApplication.getInst().getCuid();
                    String clientIP = UtilHelper.getClientIP();
                    c.a.s0.j3.j0.a.e().i(valueOf);
                    c.a.s0.j3.j0.a.e().j(valueOf2);
                    c.a.s0.j3.j0.a.e().k(System.currentTimeMillis());
                    MercatorRequestHttpMessage mercatorRequestHttpMessage = new MercatorRequestHttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
                    mercatorRequestHttpMessage.addParam("cuid", cuid);
                    mercatorRequestHttpMessage.addParam("cip", clientIP);
                    mercatorRequestHttpMessage.addParam("ver", version);
                    mercatorRequestHttpMessage.addParam("apinfo", locString);
                    mercatorRequestHttpMessage.addParam("longitude", valueOf2);
                    mercatorRequestHttpMessage.addParam("latitude", valueOf);
                    mercatorRequestHttpMessage.setFromHomePageTabFeedFragment(TbSingleton.getInstance().isMercatorRequestFromHomePageTabFeedFragment());
                    MessageManager.getInstance().sendMessage(mercatorRequestHttpMessage);
                    this.a.a = false;
                    return;
                }
                if (TbSingleton.getInstance().isMercatorRequestFromHomePageTabFeedFragment()) {
                    m.M(TbadkCoreApplication.getInst().getContext(), str);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921649, Boolean.valueOf(TbSingleton.getInstance().isMercatorRequestFromHomePageTabFeedFragment())));
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final MercatorModel a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1756423900, "Lcom/baidu/tieba/tbadkCore/util/MercatorModel$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1756423900, "Lcom/baidu/tieba/tbadkCore/util/MercatorModel$b;");
                    return;
                }
            }
            a = new MercatorModel(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1436463002, "Lcom/baidu/tieba/tbadkCore/util/MercatorModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1436463002, "Lcom/baidu/tieba/tbadkCore/util/MercatorModel;");
                return;
            }
        }
        c.a.d.f.i.a.n().g(MercatorModel.class);
    }

    public /* synthetic */ MercatorModel(a aVar) {
        this();
    }

    public static MercatorModel d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? b.a : (MercatorModel) invokeV.objValue;
    }

    public static void g(MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, mercatorData) == null) {
            TbSingleton.getInstance().setMercatorData(mercatorData);
            c.a.r0.s.g0.b.j().x("key_mercator_location", OrmObject.jsonStrWithObject(mercatorData));
        }
    }

    public MercatorData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
            return mercatorData == null ? (MercatorData) OrmObject.objectWithJsonStr(c.a.r0.s.g0.b.j().p("key_mercator_location", null), MercatorData.class) : mercatorData;
        }
        return (MercatorData) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.d.f.i.a.n().k(false, this.f49854b);
        }
    }

    public MercatorModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f49854b = new a(this);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
