package com.baidu.voyager.impl;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.kub;
import com.baidu.tieba.lub;
import com.baidu.tieba.qf1;
import com.baidu.tieba.utb;
import com.baidu.tieba.wtb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.voyager.impl.IVoyagerCallback;
import com.baidu.voyager.impl.service.VoyagerIPCManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class VoyagerImpl implements lub {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1260754733, "Lcom/baidu/voyager/impl/VoyagerImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1260754733, "Lcom/baidu/voyager/impl/VoyagerImpl;");
                return;
            }
        }
        b = AppConfig.isDebug();
    }

    public VoyagerImpl() {
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

    @Override // com.baidu.tieba.lub
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && qf1.g()) {
            utb.n().l();
        }
    }

    @Override // com.baidu.tieba.lub
    public void retry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            i(false);
        }
    }

    @Override // com.baidu.tieba.lub
    public void a(String str, String str2, int i, kub kubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, str, str2, i, kubVar) == null) {
            if (qf1.g()) {
                utb.n().t(str, str2, kubVar);
                return;
            }
            try {
                IVoyagerService c = VoyagerIPCManager.c();
                if (c != null) {
                    c.uploadZipFileWithCallback(str, str2, i, new IVoyagerCallback.Stub(this, kubVar) { // from class: com.baidu.voyager.impl.VoyagerImpl.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VoyagerImpl this$0;
                        public final /* synthetic */ kub val$uploadListener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, kubVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$uploadListener = kubVar;
                        }

                        @Override // com.baidu.voyager.impl.IVoyagerCallback
                        public void onSuccess(String str3, String str4) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, str4) == null) && this.val$uploadListener != null) {
                                JSONObject jSONObject = null;
                                try {
                                    if (!TextUtils.isEmpty(str4)) {
                                        jSONObject = new JSONObject(str4);
                                    }
                                } catch (JSONException e) {
                                    if (VoyagerImpl.b) {
                                        e.printStackTrace();
                                    }
                                }
                                utb.n().j(true, str3, jSONObject, this.val$uploadListener);
                            }
                        }

                        @Override // com.baidu.voyager.impl.IVoyagerCallback
                        public void onFailure(String str3, String str4) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str3, str4) == null) {
                                JSONObject jSONObject = null;
                                try {
                                    if (!TextUtils.isEmpty(str4)) {
                                        jSONObject = new JSONObject(str4);
                                    }
                                } catch (JSONException e) {
                                    if (VoyagerImpl.b) {
                                        e.printStackTrace();
                                    }
                                }
                                utb.n().j(false, str3, jSONObject, this.val$uploadListener);
                            }
                        }
                    });
                } else if (b) {
                    Log.e("VoyagerImpl", "voyager get remote service empty.");
                }
            } catch (RemoteException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.tieba.lub
    public void b(List<String> list, String str, long j, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j), jSONObject}) == null) {
            j(list, str, j, 0, wtb.f().c(str), jSONObject);
        }
    }

    @Override // com.baidu.tieba.lub
    public void g(List<String> list, String str, long j, kub kubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j), kubVar}) == null) {
            k(list, str, j, wtb.f().c(str), kubVar);
        }
    }

    @Override // com.baidu.tieba.lub
    public void c(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, jSONObject) == null) {
            l(str, str2, 0, wtb.f().c(str2), jSONObject);
        }
    }

    @Override // com.baidu.tieba.lub
    public void e(String str, String str2, kub kubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, kubVar) == null) {
            a(str, str2, wtb.f().c(str2), kubVar);
        }
    }

    @Override // com.baidu.tieba.lub
    public boolean d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (qf1.g()) {
                return wtb.f().C(jSONObject);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && qf1.g()) {
            utb.n().p(z);
        }
    }

    public void j(List<String> list, String str, long j, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            if (qf1.g()) {
                utb.n().q(list, str, j, i, i2, jSONObject);
                return;
            }
            try {
                IVoyagerService c = VoyagerIPCManager.c();
                if (c != null) {
                    c.uploadFileList(list, str, j, i, i2, jSONObject.toString());
                } else if (b) {
                    Log.e("VoyagerImpl", "voyager get remote service empty.");
                }
            } catch (RemoteException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void k(List<String> list, String str, long j, int i, kub kubVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), kubVar}) == null) {
            if (qf1.g()) {
                utb.n().r(list, str, j, i, kubVar);
                return;
            }
            try {
                IVoyagerService c = VoyagerIPCManager.c();
                if (c != null) {
                    c.uploadFileListWithCallback(list, str, j, i, new IVoyagerCallback.Stub(this, kubVar) { // from class: com.baidu.voyager.impl.VoyagerImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VoyagerImpl this$0;
                        public final /* synthetic */ kub val$uploadListener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, kubVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$uploadListener = kubVar;
                        }

                        @Override // com.baidu.voyager.impl.IVoyagerCallback
                        public void onSuccess(String str2, String str3) {
                            Interceptable interceptable2 = $ic;
                            if ((interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, str3) == null) && this.val$uploadListener != null) {
                                JSONObject jSONObject = null;
                                try {
                                    if (!TextUtils.isEmpty(str3)) {
                                        jSONObject = new JSONObject(str3);
                                    }
                                } catch (JSONException e) {
                                    if (VoyagerImpl.b) {
                                        e.printStackTrace();
                                    }
                                }
                                utb.n().j(true, str2, jSONObject, this.val$uploadListener);
                            }
                        }

                        @Override // com.baidu.voyager.impl.IVoyagerCallback
                        public void onFailure(String str2, String str3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLL(1048576, this, str2, str3) == null) {
                                JSONObject jSONObject = null;
                                try {
                                    if (!TextUtils.isEmpty(str3)) {
                                        jSONObject = new JSONObject(str3);
                                    }
                                } catch (JSONException e) {
                                    if (VoyagerImpl.b) {
                                        e.printStackTrace();
                                    }
                                }
                                utb.n().j(false, str2, jSONObject, this.val$uploadListener);
                            }
                        }
                    });
                } else if (b) {
                    Log.e("VoyagerImpl", "voyager get remote service empty.");
                }
            } catch (RemoteException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void l(String str, String str2, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            if (qf1.g()) {
                utb.n().s(str, str2, i, i2, jSONObject);
                return;
            }
            try {
                IVoyagerService c = VoyagerIPCManager.c();
                if (c != null) {
                    c.uploadZipFile(str, str2, i, i2, jSONObject.toString());
                } else if (b) {
                    Log.e("VoyagerImpl", "voyager get remote service empty.");
                }
            } catch (RemoteException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }
}
