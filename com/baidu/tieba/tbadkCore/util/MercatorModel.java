package com.baidu.tieba.tbadkCore.util;

import android.location.Address;
import c.a.e.e.i.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.loc.str.BDLocManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class MercatorModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f57209a;

    /* renamed from: b  reason: collision with root package name */
    public final a.c f57210b;

    /* loaded from: classes7.dex */
    public static class MercatorData extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f57211e;

        /* renamed from: f  reason: collision with root package name */
        public String f57212f;

        /* renamed from: g  reason: collision with root package name */
        public String f57213g;

        /* renamed from: h  reason: collision with root package name */
        public int f57214h;

        /* renamed from: i  reason: collision with root package name */
        public long f57215i;

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

        public long A() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f57215i : invokeV.longValue;
        }

        public int w() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f57214h : invokeV.intValue;
        }

        public String x() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f57212f : (String) invokeV.objValue;
        }

        public String y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f57211e : (String) invokeV.objValue;
        }

        public String z() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f57213g : (String) invokeV.objValue;
        }

        public MercatorData(String str, String str2, String str3, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f57211e = str;
            this.f57212f = str2;
            this.f57213g = str3;
            this.f57214h = i2;
            this.f57215i = j2;
        }
    }

    /* loaded from: classes7.dex */
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
                MercatorModel.g(new MercatorData(jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LON), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LAT), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_RADIUS), jSONObject.optInt(SearchJsBridge.COOKIE_MERCATOR_CITY), jSONObject.optLong(SearchJsBridge.COOKIE_MERCATOR_TIME)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MercatorModel f57216a;

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
            this.f57216a = mercatorModel;
        }

        @Override // c.a.e.e.i.a.c
        public void onLocationGeted(int i2, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, address) == null) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i2 != 0 || address == null || inst == null || this.f57216a.f57209a) {
                    return;
                }
                this.f57216a.f57209a = true;
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                String locString = BDLocManager.getInstance(inst).getLocString();
                String version = TbConfig.getVersion();
                String cuid = TbadkCoreApplication.getInst().getCuid();
                String clientIP = UtilHelper.getClientIP();
                c.a.r0.z2.j0.a.e().i(valueOf);
                c.a.r0.z2.j0.a.e().j(valueOf2);
                c.a.r0.z2.j0.a.e().k(System.currentTimeMillis());
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_MERCATOR);
                httpMessage.addParam("cuid", cuid);
                httpMessage.addParam("cip", clientIP);
                httpMessage.addParam("ver", version);
                httpMessage.addParam(IAdRequestParam.APINFO, locString);
                httpMessage.addParam("longitude", valueOf2);
                httpMessage.addParam("latitude", valueOf);
                MessageManager.getInstance().sendMessage(httpMessage);
                this.f57216a.f57209a = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final MercatorModel f57217a;
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
            f57217a = new MercatorModel(null);
        }
    }

    public /* synthetic */ MercatorModel(a aVar) {
        this();
    }

    public static MercatorModel d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f57217a : (MercatorModel) invokeV.objValue;
    }

    public static void g(MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, mercatorData) == null) {
            TbSingleton.getInstance().setMercatorData(mercatorData);
            c.a.q0.s.d0.b.j().x("key_mercator_location", OrmObject.jsonStrWithObject(mercatorData));
        }
    }

    public MercatorData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
            return mercatorData == null ? (MercatorData) OrmObject.objectWithJsonStr(c.a.q0.s.d0.b.j().p("key_mercator_location", null), MercatorData.class) : mercatorData;
        }
        return (MercatorData) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c.a.e.e.i.a.l().i(true, this.f57210b);
        }
    }

    public MercatorModel() {
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
        this.f57209a = false;
        this.f57210b = new a(this);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
