package com.baidu.voyager.impl.service;

import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.voyager.impl.IVoyagerCallback;
import com.baidu.voyager.impl.IVoyagerService;
import com.repackage.ga9;
import com.repackage.p99;
import com.repackage.z99;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class VoyagerIPCManager$1 extends IVoyagerService.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements ga9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IVoyagerCallback a;

        public a(VoyagerIPCManager$1 voyagerIPCManager$1, IVoyagerCallback iVoyagerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voyagerIPCManager$1, iVoyagerCallback};
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

        @Override // com.repackage.ga9
        public void onFailure(String str, JSONObject jSONObject) {
            IVoyagerCallback iVoyagerCallback;
            String jSONObject2;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) || (iVoyagerCallback = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                try {
                    jSONObject2 = jSONObject.toString();
                } catch (RemoteException e) {
                    z = z99.a;
                    if (z) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onFailure(str, jSONObject2);
        }

        @Override // com.repackage.ga9
        public void onSuccess(String str, JSONObject jSONObject) {
            IVoyagerCallback iVoyagerCallback;
            String jSONObject2;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) || (iVoyagerCallback = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                try {
                    jSONObject2 = jSONObject.toString();
                } catch (RemoteException e) {
                    z = z99.a;
                    if (z) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onSuccess(str, jSONObject2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ga9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IVoyagerCallback a;

        public b(VoyagerIPCManager$1 voyagerIPCManager$1, IVoyagerCallback iVoyagerCallback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voyagerIPCManager$1, iVoyagerCallback};
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

        @Override // com.repackage.ga9
        public void onFailure(String str, JSONObject jSONObject) {
            IVoyagerCallback iVoyagerCallback;
            String jSONObject2;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) || (iVoyagerCallback = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                try {
                    jSONObject2 = jSONObject.toString();
                } catch (RemoteException e) {
                    z = z99.a;
                    if (z) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onFailure(str, jSONObject2);
        }

        @Override // com.repackage.ga9
        public void onSuccess(String str, JSONObject jSONObject) {
            IVoyagerCallback iVoyagerCallback;
            String jSONObject2;
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject) == null) || (iVoyagerCallback = this.a) == null) {
                return;
            }
            if (jSONObject == null) {
                jSONObject2 = "";
            } else {
                try {
                    jSONObject2 = jSONObject.toString();
                } catch (RemoteException e) {
                    z = z99.a;
                    if (z) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onSuccess(str, jSONObject2);
        }
    }

    public VoyagerIPCManager$1() {
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

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadFileList(List<String> list, String str, long j, int i, int i2, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), str2}) == null) {
            try {
                p99.m().p(list, str, j, i, i2, new JSONObject(str2));
            } catch (JSONException e) {
                z = z99.a;
                if (z) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadFileListWithCallback(List<String> list, String str, long j, int i, IVoyagerCallback iVoyagerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), iVoyagerCallback}) == null) {
            p99.m().q(list, str, j, i, new a(this, iVoyagerCallback));
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadZipFile(String str, String str2, int i, int i2, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3}) == null) {
            try {
                p99.m().r(str, str2, i, i2, new JSONObject(str3));
            } catch (JSONException e) {
                z = z99.a;
                if (z) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadZipFileWithCallback(String str, String str2, int i, IVoyagerCallback iVoyagerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, str2, i, iVoyagerCallback) == null) {
            p99.m().s(str, str2, new b(this, iVoyagerCallback));
        }
    }
}
