package com.baidu.voyager.impl.service;

import android.os.RemoteException;
import c.a.c1.b.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.voyager.impl.IVoyagerCallback;
import com.baidu.voyager.impl.IVoyagerService;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public final class VoyagerIPCManager$1 extends IVoyagerService.Stub {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes13.dex */
    public class a implements c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVoyagerCallback;
        }

        @Override // c.a.c1.b.c
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
                } catch (RemoteException e2) {
                    z = c.a.c1.a.g.b.a;
                    if (z) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onFailure(str, jSONObject2);
        }

        @Override // c.a.c1.b.c
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
                } catch (RemoteException e2) {
                    z = c.a.c1.a.g.b.a;
                    if (z) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onSuccess(str, jSONObject2);
        }
    }

    /* loaded from: classes13.dex */
    public class b implements c {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iVoyagerCallback;
        }

        @Override // c.a.c1.b.c
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
                } catch (RemoteException e2) {
                    z = c.a.c1.a.g.b.a;
                    if (z) {
                        e2.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            iVoyagerCallback.onFailure(str, jSONObject2);
        }

        @Override // c.a.c1.b.c
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
                } catch (RemoteException e2) {
                    z = c.a.c1.a.g.b.a;
                    if (z) {
                        e2.printStackTrace();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadFileList(List<String> list, String str, long j2, int i2, int i3, String str2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) {
            try {
                c.a.c1.a.a.m().p(list, str, j2, i2, i3, new JSONObject(str2));
            } catch (JSONException e2) {
                z = c.a.c1.a.g.b.a;
                if (z) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadFileListWithCallback(List<String> list, String str, long j2, int i2, IVoyagerCallback iVoyagerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), iVoyagerCallback}) == null) {
            c.a.c1.a.a.m().q(list, str, j2, i2, new a(this, iVoyagerCallback));
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadZipFile(String str, String str2, int i2, int i3, String str3) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), str3}) == null) {
            try {
                c.a.c1.a.a.m().r(str, str2, i2, i3, new JSONObject(str3));
            } catch (JSONException e2) {
                z = c.a.c1.a.g.b.a;
                if (z) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.voyager.impl.IVoyagerService
    public void uploadZipFileWithCallback(String str, String str2, int i2, IVoyagerCallback iVoyagerCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048579, this, str, str2, i2, iVoyagerCallback) == null) {
            c.a.c1.a.a.m().s(str, str2, new b(this, iVoyagerCallback));
        }
    }
}
