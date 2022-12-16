package com.baidu.tieba.tbadkCore.util;

import android.location.Address;
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
import com.baidu.tieba.ik8;
import com.baidu.tieba.ry4;
import com.baidu.tieba.tf;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class MercatorModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public final tf.c b;

    /* loaded from: classes6.dex */
    public static class MercatorData extends OrmObject {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public int d;
        public long e;
        public String f;
        public String g;
        public String h;

        public MercatorData() {
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

        public int G() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.d;
            }
            return invokeV.intValue;
        }

        public String H() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.g;
            }
            return (String) invokeV.objValue;
        }

        public String I() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.h;
            }
            return (String) invokeV.objValue;
        }

        public String J() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.b;
            }
            return (String) invokeV.objValue;
        }

        public String K() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a;
            }
            return (String) invokeV.objValue;
        }

        public String L() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.f;
            }
            return (String) invokeV.objValue;
        }

        public String M() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.c;
            }
            return (String) invokeV.objValue;
        }

        public long N() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.e;
            }
            return invokeV.longValue;
        }

        public MercatorData(String str, String str2, String str3, int i, long j, String str4, String str5, String str6) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Integer.valueOf(i), Long.valueOf(j), str4, str5, str6};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = i;
            this.e = j;
            this.f = str4;
            this.g = str5;
            this.h = str6;
        }
    }

    /* loaded from: classes6.dex */
    public static class MercatorLocationResponseMessage extends JsonHttpResponsedMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MercatorLocationResponseMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, jSONObject) == null) {
                super.decodeLogicInBackGround(i, jSONObject);
                if (jSONObject == null) {
                    return;
                }
                MercatorModel.g(new MercatorData(jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LON), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_LAT), jSONObject.optString(SearchJsBridge.COOKIE_MERCATOR_RADIUS), jSONObject.optInt(SearchJsBridge.COOKIE_MERCATOR_CITY), jSONObject.optLong(SearchJsBridge.COOKIE_MERCATOR_TIME), jSONObject.optString("mercator_province_name"), jSONObject.optString("mercator_city_name"), jSONObject.optString("mercator_district_name")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class MercatorRequestHttpMessage extends HttpMessage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean isFromHomePageTabFeedFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MercatorRequestHttpMessage(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.isFromHomePageTabFeedFragment;
            }
            return invokeV.booleanValue;
        }

        public void setFromHomePageTabFeedFragment(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.isFromHomePageTabFeedFragment = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements tf.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mercatorModel;
        }

        @Override // com.baidu.tieba.tf.c
        public void a(int i, String str, Address address) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, address) == null) {
                TbadkCoreApplication inst = TbadkCoreApplication.getInst();
                if (i != 0 || address == null || inst == null || this.a.a) {
                    if (TbSingleton.getInstance().isMercatorRequestFromHomePageTabFeedFragment()) {
                        yi.Q(TbadkCoreApplication.getInst().getContext(), str);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921649, Boolean.valueOf(TbSingleton.getInstance().isMercatorRequestFromHomePageTabFeedFragment())));
                    return;
                }
                this.a.a = true;
                String valueOf = String.valueOf(address.getLatitude());
                String valueOf2 = String.valueOf(address.getLongitude());
                String locString = BDLocManager.getInstance(inst).getLocString();
                String version = TbConfig.getVersion();
                String cuid = TbadkCoreApplication.getInst().getCuid();
                String clientIP = UtilHelper.getClientIP();
                ik8.e().i(valueOf);
                ik8.e().j(valueOf2);
                ik8.e().k(System.currentTimeMillis());
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
            }
        }
    }

    /* loaded from: classes6.dex */
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
        tf.n().g(MercatorModel.class);
    }

    public static MercatorModel d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return b.a;
        }
        return (MercatorModel) invokeV.objValue;
    }

    public MercatorData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            MercatorData mercatorData = TbSingleton.getInstance().getMercatorData();
            if (mercatorData == null) {
                return (MercatorData) OrmObject.objectWithJsonStr(ry4.l().r("key_mercator_location", null), MercatorData.class);
            }
            return mercatorData;
        }
        return (MercatorData) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            tf.n().k(false, this.b);
        }
    }

    public MercatorModel() {
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
        this.a = false;
        this.b = new a(this);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_MERCATOR, TbConfig.SERVER_ADDRESS + TbConfig.MERCATOR_LOCATION_URL);
        tbHttpMessageTask.setResponsedClass(MercatorLocationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public /* synthetic */ MercatorModel(a aVar) {
        this();
    }

    public static void g(MercatorData mercatorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, mercatorData) == null) {
            TbSingleton.getInstance().setMercatorData(mercatorData);
            ry4.l().z("key_mercator_location", OrmObject.jsonStrWithObject(mercatorData));
        }
    }
}
