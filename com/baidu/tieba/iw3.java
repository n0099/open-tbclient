package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.tieba.adnotify.receiver.NotInstallNotificationReceiver;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class iw3 implements p34 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-704731257, "Lcom/baidu/tieba/iw3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-704731257, "Lcom/baidu/tieba/iw3$a;");
                    return;
                }
            }
            int[] iArr = new int[Download.DownloadState.values().length];
            b = iArr;
            try {
                iArr[Download.DownloadState.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Download.DownloadState.DOWNLOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Download.DownloadState.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Download.DownloadState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[Download.DownloadState.CANCEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[Download.DownloadState.FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[SwanAppDownloadAction.SwanAppDownloadType.values().length];
            a = iArr2;
            try {
                iArr2[SwanAppDownloadAction.SwanAppDownloadType.TYPE_QUERY_STATUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_CANCEL_DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_RESUME_DOWNLOAD.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[SwanAppDownloadAction.SwanAppDownloadType.TYPE_INSTALL_APP.ordinal()] = 7;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends n23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public hu3 c;

        @Override // com.baidu.tieba.l23
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // com.baidu.tieba.l23
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        public b(hu3 hu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hu3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.n23, com.baidu.tieba.l23
        public void onEvent(@NonNull j23 j23Var) {
            Bundle a;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, j23Var) != null) || (a = j23Var.a()) == null) {
                return;
            }
            iw3.g(a, this.c);
        }
    }

    public iw3() {
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

    @Override // com.baidu.tieba.p34
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String packageName = getPackageName();
            if (!TextUtils.isEmpty(f()) && !TextUtils.isEmpty(packageName)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return fw3.o.H();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p34
    public String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return fw3.o.I();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.p34
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            fw3.o.w();
        }
    }

    public static void g(@NonNull Bundle bundle, hu3 hu3Var) {
        String string;
        char c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, bundle, hu3Var) == null) && (string = bundle.getString("functionType")) != null && hu3Var != null) {
            String string2 = bundle.getString("resultData", "");
            int hashCode = string.hashCode();
            if (hashCode != -1013362275) {
                if (hashCode == -530890460 && string.equals("onSuccess")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (string.equals("onFail")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c == 0) {
                try {
                    JSONObject jSONObject = new JSONObject(string2);
                    int optInt = jSONObject.optInt("progress", -1);
                    if (optInt > -1 && optInt <= 100) {
                        hu3Var.a(optInt);
                    }
                    if (jSONObject.optBoolean("installed")) {
                        hu3Var.c(DownloadState.INSTALLED, optInt);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null) {
                        return;
                    }
                    switch (a.b[Download.DownloadState.getState(optJSONObject.optInt("status", -1)).ordinal()]) {
                        case 1:
                            hu3Var.c(DownloadState.WAIT, optInt);
                            return;
                        case 2:
                            hu3Var.c(DownloadState.DOWNLOADING, optInt);
                            return;
                        case 3:
                            hu3Var.c(DownloadState.DOWNLOAD_PAUSED, optInt);
                            return;
                        case 4:
                            hu3Var.c(DownloadState.DOWNLOAD_FAILED, optInt);
                            return;
                        case 5:
                            hu3Var.c(DownloadState.DELETED, optInt);
                            return;
                        case 6:
                            hu3Var.c(DownloadState.DOWNLOADED, optInt);
                            return;
                        default:
                            hu3Var.c(DownloadState.NOT_START, optInt);
                            return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tieba.p34
    public boolean a(@NonNull Context context, @NonNull SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType, @NonNull hu3 hu3Var) {
        InterceptResult invokeLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, context, swanAppDownloadType, hu3Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("key_download_package_name", getPackageName());
                jSONObject.put(NotInstallNotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_URL, f());
                JSONObject jSONObject2 = new JSONObject();
                if (fw3.o.z() == null) {
                    str = "";
                } else {
                    str = fw3.o.z().configName;
                }
                jSONObject2.put(GameGuideConfigInfo.KEY_CONFIG_NAME, str);
                jSONObject.put(DownloadConstants.DOWNLOAD_PARAMS, jSONObject2.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            String e2 = e(swanAppDownloadType);
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, e2);
            bundle.putString("ubc_params", new bx3().a());
            bundle.putString("data", jSONObject.toString());
            b33 y = f63.K().y();
            if (y != null) {
                y.X(bundle, tw3.class, new b(hu3Var));
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.tieba.p34
    public boolean b(Context context, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, str2, str3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(kw3.b, str2);
                jSONObject.put(NotInstallNotificationReceiver.INTENT_PARAMS_KEY_DOWNLOAD_URL, str);
                jSONObject.put(kw3.c, str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, "startDownloadFile");
            bundle.putString("ubc_params", new bx3().a());
            bundle.putString("data", jSONObject.toString());
            b33 y = f63.K().y();
            if (y != null) {
                y.W(bundle, tw3.class);
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final String e(SwanAppDownloadAction.SwanAppDownloadType swanAppDownloadType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, swanAppDownloadType)) == null) {
            switch (a.a[swanAppDownloadType.ordinal()]) {
                case 1:
                    return "queryStatus";
                case 2:
                    return "startDownload";
                case 3:
                    return "pauseDownload";
                case 4:
                case 5:
                    return "deleteDownload";
                case 6:
                    return com.baidu.mobads.sdk.internal.ap.d;
                case 7:
                    return "installApp";
                default:
                    return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
