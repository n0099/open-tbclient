package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.network.models.ReservationGameInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class n04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements h04<List<ReservationGameInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String[] a;
        public final /* synthetic */ n04 b;

        @Override // com.baidu.tieba.h04
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            }
        }

        public a(n04 n04Var, String[] strArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n04Var, strArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n04Var;
            this.a = strArr;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.h04
        /* renamed from: a */
        public void onSuccess(List<ReservationGameInfo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, list) != null) || list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            ArrayList arrayList2 = new ArrayList(Arrays.asList(this.a));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ReservationGameInfo reservationGameInfo = (ReservationGameInfo) it.next();
                boolean z = reservationGameInfo.auto_download;
                String str = reservationGameInfo.app_id;
                if (z) {
                    String str2 = reservationGameInfo.download_url;
                    String str3 = reservationGameInfo.package_id;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str)) {
                        this.b.e(str2, str3, str);
                        g04.b().c(str);
                        if (arrayList2.remove(str)) {
                            this.b.f(arrayList2);
                        }
                    }
                } else if (arrayList2.remove(str)) {
                    this.b.f(arrayList2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final n04 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-627125671, "Lcom/baidu/tieba/n04$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-627125671, "Lcom/baidu/tieba/n04$b;");
                    return;
                }
            }
            a = new n04();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements nz3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.nz3
        public void a(pz3 pz3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pz3Var) == null) {
            }
        }

        public c(n04 n04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public n04() {
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

    public static final n04 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (n04) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !br2.h0().e(br2.c())) {
            return;
        }
        String string = ig3.a().getString("reservation_apk_ids", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        String[] split = string.split(",");
        if (split.length == 0) {
            return;
        }
        g04.b().d(new a(this, split));
    }

    public final void e(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            if (ProcessUtils.isMainProcess()) {
                ty3.n().H(str, str2, str3, new c(this));
                return;
            }
            p43 y = t73.K().y();
            if (y != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("url", str);
                    jSONObject.put("packageName", str2);
                    jSONObject.put("apkId", str3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Bundle bundle = new Bundle();
                bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "startDownload");
                bundle.putString("data", jSONObject.toString());
                bundle.putString("ubc_params", new tz3().a());
                y.W(bundle, hz3.class);
            }
        }
    }

    public final void f(ArrayList<String> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < arrayList.size(); i++) {
                stringBuffer.append(arrayList.get(i));
                if (i < arrayList.size() - 1) {
                    stringBuffer.append(",");
                }
            }
            ig3.a().putString("reservation_apk_ids", stringBuffer.toString());
        }
    }
}
