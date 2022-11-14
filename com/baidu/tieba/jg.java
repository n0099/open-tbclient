package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.network.outback.statistics.DoRecordManager;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.outback.statistics.RecordObserver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class jg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public final e b;
    public final c c;
    public final d d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final jg a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(254795730, "Lcom/baidu/tieba/jg$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(254795730, "Lcom/baidu/tieba/jg$b;");
                    return;
                }
            }
            a = new jg(null);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements RecordObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public final void a(NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, networkStatRecord) == null) && networkStatRecord != null && networkStatRecord.subFrom == 8927) {
                networkStatRecord.from = kg.a(networkStatRecord.url);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ext", networkStatRecord.toUBCJson());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent("1625", jSONObject);
                }
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord, i) == null) {
                a(networkStatRecord);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements RecordObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        public /* synthetic */ d(a aVar) {
            this();
        }

        public final void a(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, networkStatRecord, i) == null) && networkStatRecord != null && i == DoRecordManager.FAILED_MSG && networkStatRecord.subFrom == 8927) {
                networkStatRecord.from = kg.a(networkStatRecord.url);
                JSONObject uBCJson = networkStatRecord.toUBCJson();
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(HttpConfig.UBC_HTTP_EXCEPTION_ID, uBCJson.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord, i) == null) {
                a(networkStatRecord, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements RecordObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public final boolean b(NetworkStatRecord networkStatRecord) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, networkStatRecord)) == null) {
                if (networkStatRecord.from == 3 || networkStatRecord.subFrom != 8927 || new Random().nextInt(100) >= 20) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final void a(NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, networkStatRecord) == null) && networkStatRecord != null && b(networkStatRecord)) {
                networkStatRecord.from = kg.a(networkStatRecord.url);
                JSONObject uBCJson = networkStatRecord.toUBCJson();
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(HttpConfig.UBC_HTTP_ID, uBCJson.toString());
                }
            }
        }

        @Override // com.baidu.searchbox.network.outback.statistics.RecordObserver
        public void doRecord(NetworkStatRecord networkStatRecord, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, networkStatRecord, i) == null) {
                a(networkStatRecord);
            }
        }
    }

    public jg() {
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
        this.a = false;
        this.b = new e(null);
        this.c = new c(null);
        this.d = new d(null);
    }

    public synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.a) {
                    this.a = true;
                    DoRecordManager.getInstance().attach(this.b);
                    DoRecordManager.getInstance().attach(this.c);
                    DoRecordManager.getInstance().attach(this.d);
                }
            }
        }
    }

    public /* synthetic */ jg(a aVar) {
        this();
    }

    public static jg a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b.a;
        }
        return (jg) invokeV.objValue;
    }
}
