package com.baidu.voyager.impl;

import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.voyager.impl.IVoyagerCallback;
import com.repackage.h99;
import com.repackage.j99;
import com.repackage.r99;
import com.repackage.sa1;
import com.repackage.y99;
import com.repackage.z99;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VoyagerImpl implements z99 {
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

    @Override // com.repackage.z99
    public void a(String str, String str2, int i, y99 y99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, str, str2, i, y99Var) == null) {
            if (sa1.g()) {
                h99.m().s(str, str2, y99Var);
                return;
            }
            try {
                IVoyagerService b2 = r99.b();
                if (b2 != null) {
                    b2.uploadZipFileWithCallback(str, str2, i, new IVoyagerCallback.Stub(this, y99Var) { // from class: com.baidu.voyager.impl.VoyagerImpl.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VoyagerImpl this$0;
                        public final /* synthetic */ y99 val$uploadListener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, y99Var};
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
                            this.val$uploadListener = y99Var;
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
                                h99.m().j(false, str3, jSONObject, this.val$uploadListener);
                            }
                        }

                        @Override // com.baidu.voyager.impl.IVoyagerCallback
                        public void onSuccess(String str3, String str4) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, str4) == null) || this.val$uploadListener == null) {
                                return;
                            }
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
                            h99.m().j(true, str3, jSONObject, this.val$uploadListener);
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

    @Override // com.repackage.z99
    public void b(List<String> list, String str, long j, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j), jSONObject}) == null) {
            g(list, str, j, 0, j99.f().c(str), jSONObject);
        }
    }

    @Override // com.repackage.z99
    public void c(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, jSONObject) == null) {
            i(str, str2, 0, j99.f().c(str2), jSONObject);
        }
    }

    @Override // com.repackage.z99
    public void d(String str, String str2, y99 y99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, y99Var) == null) {
            a(str, str2, j99.f().c(str2), y99Var);
        }
    }

    @Override // com.repackage.z99
    public void e(List<String> list, String str, long j, y99 y99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, str, Long.valueOf(j), y99Var}) == null) {
            h(list, str, j, j99.f().c(str), y99Var);
        }
    }

    public void g(List<String> list, String str, long j, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            if (sa1.g()) {
                h99.m().p(list, str, j, i, i2, jSONObject);
                return;
            }
            try {
                IVoyagerService b2 = r99.b();
                if (b2 != null) {
                    b2.uploadFileList(list, str, j, i, i2, jSONObject.toString());
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

    public void h(List<String> list, String str, long j, int i, y99 y99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j), Integer.valueOf(i), y99Var}) == null) {
            if (sa1.g()) {
                h99.m().q(list, str, j, i, y99Var);
                return;
            }
            try {
                IVoyagerService b2 = r99.b();
                if (b2 != null) {
                    b2.uploadFileListWithCallback(list, str, j, i, new IVoyagerCallback.Stub(this, y99Var) { // from class: com.baidu.voyager.impl.VoyagerImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VoyagerImpl this$0;
                        public final /* synthetic */ y99 val$uploadListener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, y99Var};
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
                            this.val$uploadListener = y99Var;
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
                                h99.m().j(false, str2, jSONObject, this.val$uploadListener);
                            }
                        }

                        @Override // com.baidu.voyager.impl.IVoyagerCallback
                        public void onSuccess(String str2, String str3) {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2, str3) == null) || this.val$uploadListener == null) {
                                return;
                            }
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
                            h99.m().j(true, str2, jSONObject, this.val$uploadListener);
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

    public void i(String str, String str2, int i, int i2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), jSONObject}) == null) {
            if (sa1.g()) {
                h99.m().r(str, str2, i, i2, jSONObject);
                return;
            }
            try {
                IVoyagerService b2 = r99.b();
                if (b2 != null) {
                    b2.uploadZipFile(str, str2, i, i2, jSONObject.toString());
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
