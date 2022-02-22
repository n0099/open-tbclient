package com.baidu.voyager.impl;

import android.os.RemoteException;
import android.text.TextUtils;
import c.a.d1.a.g.b;
import c.a.d1.b.c;
import c.a.d1.b.d;
import c.a.l0.b.a.a;
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
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class VoyagerImpl implements d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f50521b;
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
        f50521b = AppConfig.isDebug();
    }

    public VoyagerImpl() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.a.d1.b.d
    public void a(String str, String str2, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, str, str2, i2, cVar) == null) {
            if (a.g()) {
                c.a.d1.a.a.m().s(str, str2, cVar);
                return;
            }
            try {
                IVoyagerService b2 = b.b();
                if (b2 != null) {
                    b2.uploadZipFileWithCallback(str, str2, i2, new IVoyagerCallback.Stub(this, cVar) { // from class: com.baidu.voyager.impl.VoyagerImpl.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VoyagerImpl this$0;
                        public final /* synthetic */ c val$uploadListener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$uploadListener = cVar;
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
                                } catch (JSONException e2) {
                                    if (VoyagerImpl.f50521b) {
                                        e2.printStackTrace();
                                    }
                                }
                                c.a.d1.a.a.m().j(false, str3, jSONObject, this.val$uploadListener);
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
                            } catch (JSONException e2) {
                                if (VoyagerImpl.f50521b) {
                                    e2.printStackTrace();
                                }
                            }
                            c.a.d1.a.a.m().j(true, str3, jSONObject, this.val$uploadListener);
                        }
                    });
                } else {
                    boolean z = f50521b;
                }
            } catch (RemoteException e2) {
                if (f50521b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // c.a.d1.b.d
    public void b(List<String> list, String str, long j2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{list, str, Long.valueOf(j2), jSONObject}) == null) {
            g(list, str, j2, 0, c.a.d1.a.b.b.f().c(str), jSONObject);
        }
    }

    @Override // c.a.d1.b.d
    public void c(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, jSONObject) == null) {
            i(str, str2, 0, c.a.d1.a.b.b.f().c(str2), jSONObject);
        }
    }

    @Override // c.a.d1.b.d
    public void d(String str, String str2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, cVar) == null) {
            a(str, str2, c.a.d1.a.b.b.f().c(str2), cVar);
        }
    }

    @Override // c.a.d1.b.d
    public void e(List<String> list, String str, long j2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{list, str, Long.valueOf(j2), cVar}) == null) {
            h(list, str, j2, c.a.d1.a.b.b.f().c(str), cVar);
        }
    }

    public void g(List<String> list, String str, long j2, int i2, int i3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), jSONObject}) == null) {
            if (a.g()) {
                c.a.d1.a.a.m().p(list, str, j2, i2, i3, jSONObject);
                return;
            }
            try {
                IVoyagerService b2 = b.b();
                if (b2 != null) {
                    b2.uploadFileList(list, str, j2, i2, i3, jSONObject.toString());
                } else {
                    boolean z = f50521b;
                }
            } catch (RemoteException e2) {
                if (f50521b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void h(List<String> list, String str, long j2, int i2, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{list, str, Long.valueOf(j2), Integer.valueOf(i2), cVar}) == null) {
            if (a.g()) {
                c.a.d1.a.a.m().q(list, str, j2, i2, cVar);
                return;
            }
            try {
                IVoyagerService b2 = b.b();
                if (b2 != null) {
                    b2.uploadFileListWithCallback(list, str, j2, i2, new IVoyagerCallback.Stub(this, cVar) { // from class: com.baidu.voyager.impl.VoyagerImpl.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ VoyagerImpl this$0;
                        public final /* synthetic */ c val$uploadListener;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$uploadListener = cVar;
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
                                } catch (JSONException e2) {
                                    if (VoyagerImpl.f50521b) {
                                        e2.printStackTrace();
                                    }
                                }
                                c.a.d1.a.a.m().j(false, str2, jSONObject, this.val$uploadListener);
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
                            } catch (JSONException e2) {
                                if (VoyagerImpl.f50521b) {
                                    e2.printStackTrace();
                                }
                            }
                            c.a.d1.a.a.m().j(true, str2, jSONObject, this.val$uploadListener);
                        }
                    });
                } else {
                    boolean z = f50521b;
                }
            } catch (RemoteException e2) {
                if (f50521b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void i(String str, String str2, int i2, int i3, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), jSONObject}) == null) {
            if (a.g()) {
                c.a.d1.a.a.m().r(str, str2, i2, i3, jSONObject);
                return;
            }
            try {
                IVoyagerService b2 = b.b();
                if (b2 != null) {
                    b2.uploadZipFile(str, str2, i2, i3, jSONObject.toString());
                } else {
                    boolean z = f50521b;
                }
            } catch (RemoteException e2) {
                if (f50521b) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
