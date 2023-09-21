package com.baidu.voyager.impl.service;

import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.omb;
import com.baidu.tieba.ylb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.voyager.impl.IVoyagerCallback;
import com.baidu.voyager.impl.IVoyagerService;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class VoyagerIPCManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile IVoyagerService b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(104704662, "Lcom/baidu/voyager/impl/service/VoyagerIPCManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(104704662, "Lcom/baidu/voyager/impl/service/VoyagerIPCManager;");
                return;
            }
        }
        a = AppConfig.isDebug();
    }

    public VoyagerIPCManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            IPCServiceManager.c("remote_voyager_service", new IVoyagerService.Stub() { // from class: com.baidu.voyager.impl.service.VoyagerIPCManager.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: com.baidu.voyager.impl.service.VoyagerIPCManager$1$a */
                /* loaded from: classes9.dex */
                public class a implements omb {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IVoyagerCallback a;

                    public a(AnonymousClass1 anonymousClass1, IVoyagerCallback iVoyagerCallback) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass1, iVoyagerCallback};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = iVoyagerCallback;
                    }

                    @Override // com.baidu.tieba.omb
                    public void onFailure(String str, JSONObject jSONObject) {
                        IVoyagerCallback iVoyagerCallback;
                        String jSONObject2;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) && (iVoyagerCallback = this.a) != null) {
                            if (jSONObject == null) {
                                jSONObject2 = "";
                            } else {
                                try {
                                    jSONObject2 = jSONObject.toString();
                                } catch (RemoteException e) {
                                    if (VoyagerIPCManager.a) {
                                        e.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                            iVoyagerCallback.onFailure(str, jSONObject2);
                        }
                    }

                    @Override // com.baidu.tieba.omb
                    public void onSuccess(String str, JSONObject jSONObject) {
                        IVoyagerCallback iVoyagerCallback;
                        String jSONObject2;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) && (iVoyagerCallback = this.a) != null) {
                            if (jSONObject == null) {
                                jSONObject2 = "";
                            } else {
                                try {
                                    jSONObject2 = jSONObject.toString();
                                } catch (RemoteException e) {
                                    if (VoyagerIPCManager.a) {
                                        e.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                            iVoyagerCallback.onSuccess(str, jSONObject2);
                        }
                    }
                }

                /* renamed from: com.baidu.voyager.impl.service.VoyagerIPCManager$1$b */
                /* loaded from: classes9.dex */
                public class b implements omb {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ IVoyagerCallback a;

                    public b(AnonymousClass1 anonymousClass1, IVoyagerCallback iVoyagerCallback) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {anonymousClass1, iVoyagerCallback};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = iVoyagerCallback;
                    }

                    @Override // com.baidu.tieba.omb
                    public void onFailure(String str, JSONObject jSONObject) {
                        IVoyagerCallback iVoyagerCallback;
                        String jSONObject2;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) && (iVoyagerCallback = this.a) != null) {
                            if (jSONObject == null) {
                                jSONObject2 = "";
                            } else {
                                try {
                                    jSONObject2 = jSONObject.toString();
                                } catch (RemoteException e) {
                                    if (VoyagerIPCManager.a) {
                                        e.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                            iVoyagerCallback.onFailure(str, jSONObject2);
                        }
                    }

                    @Override // com.baidu.tieba.omb
                    public void onSuccess(String str, JSONObject jSONObject) {
                        IVoyagerCallback iVoyagerCallback;
                        String jSONObject2;
                        Interceptable interceptable = $ic;
                        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) && (iVoyagerCallback = this.a) != null) {
                            if (jSONObject == null) {
                                jSONObject2 = "";
                            } else {
                                try {
                                    jSONObject2 = jSONObject.toString();
                                } catch (RemoteException e) {
                                    if (VoyagerIPCManager.a) {
                                        e.printStackTrace();
                                        return;
                                    }
                                    return;
                                }
                            }
                            iVoyagerCallback.onSuccess(str, jSONObject2);
                        }
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.baidu.voyager.impl.IVoyagerService
                public void uploadFileList(List<String> list, String str, long j, int i, int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2}) == null) {
                        try {
                            ylb.n().q(list, str, j, i, i2, new JSONObject(str2));
                        } catch (JSONException e) {
                            if (VoyagerIPCManager.a) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                @Override // com.baidu.voyager.impl.IVoyagerService
                public void uploadFileListWithCallback(List<String> list, String str, long j, int i, IVoyagerCallback iVoyagerCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), iVoyagerCallback}) == null) {
                        ylb.n().r(list, str, j, i, new a(this, iVoyagerCallback));
                    }
                }

                @Override // com.baidu.voyager.impl.IVoyagerService
                public void uploadZipFile(String str, String str2, int i, int i2, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
                        try {
                            ylb.n().s(str, str2, i, i2, new JSONObject(str3));
                        } catch (JSONException e) {
                            if (VoyagerIPCManager.a) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

                @Override // com.baidu.voyager.impl.IVoyagerService
                public void uploadZipFileWithCallback(String str, String str2, int i, IVoyagerCallback iVoyagerCallback) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLLIL(1048579, this, str, str2, i, iVoyagerCallback) == null) {
                        ylb.n().t(str, str2, new b(this, iVoyagerCallback));
                    }
                }
            }, false);
        }
    }

    public static IVoyagerService c() {
        InterceptResult invokeV;
        IBinder f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                synchronized (VoyagerIPCManager.class) {
                    if (b == null && (f = IPCServiceManager.f("remote_voyager_service", true)) != null) {
                        b = IVoyagerService.Stub.asInterface(f);
                    }
                }
            }
            return b;
        }
        return (IVoyagerService) invokeV.objValue;
    }
}
