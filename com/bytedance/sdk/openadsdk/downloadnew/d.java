package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.frameworks.encryptor.EncryptorUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.downloadnew.c;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.a.a;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.b.j;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ad;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.i;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f61707a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f61708b;

    /* renamed from: c  reason: collision with root package name */
    public static ITTDownloadVisitor f61709c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicBoolean f61710d;

    /* renamed from: e  reason: collision with root package name */
    public static Context f61711e;

    /* renamed from: f  reason: collision with root package name */
    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f61712f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.ss.android.download.api.download.a.a f61713g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static class e implements IDownloadHttpService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public i downloadWithConnection(int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws IOException {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i2, str, list)) == null) {
                c.a a2 = com.bytedance.sdk.openadsdk.downloadnew.c.a(str, list);
                if (a2 != null) {
                    return new i(this, a2) { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.e.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c.a f61724a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ e f61725b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, a2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61725b = this;
                            this.f61724a = a2;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.i
                        public InputStream a() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.f61724a.f61700a : (InputStream) invokeV.objValue;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.g
                        public int b() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f61724a.f61702c : invokeV.intValue;
                        }

                        @Override // com.ss.android.socialbase.downloader.network.g
                        public void c() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                            }
                        }

                        @Override // com.ss.android.socialbase.downloader.network.i
                        public void d() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                                try {
                                    this.f61724a.f61703d.disconnect();
                                } catch (Exception unused) {
                                }
                            }
                        }

                        @Override // com.ss.android.socialbase.downloader.network.g
                        public String a(String str2) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2)) == null) {
                                Map<String, String> map = this.f61724a.f61701b;
                                if (map != null) {
                                    return map.get(str2);
                                }
                                return null;
                            }
                            return (String) invokeL.objValue;
                        }
                    };
                }
                return null;
            }
            return (i) invokeILL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1936537469, "Lcom/bytedance/sdk/openadsdk/downloadnew/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1936537469, "Lcom/bytedance/sdk/openadsdk/downloadnew/d;");
                return;
            }
        }
        f61710d = new AtomicBoolean(false);
        f61708b = true;
        try {
            f61707a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f61713g = new com.ss.android.download.api.download.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(1048576, this, downloadModel, downloadController, downloadEventConfig) == null) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onDownloadStart");
                }
            }

            @Override // com.ss.android.download.api.download.a.a
            public void b(DownloadInfo downloadInfo, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048580, this, downloadInfo, str) == null) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onInstalled");
                    d.c(str);
                }
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048579, this, downloadInfo, str) == null) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onDownloadFinished");
                }
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, downloadInfo, baseException, str) == null) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onDownloadFailed");
                }
            }

            @Override // com.ss.android.download.api.download.a.a
            public void a(DownloadInfo downloadInfo) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, downloadInfo) == null) {
                    com.bytedance.sdk.openadsdk.api.b.d.a("TTDownloadVisitor", "completeListener: onCanceled");
                }
            }
        };
    }

    public d() {
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

    public static void c(String str) {
        com.ss.android.downloadad.api.a.b a2;
        JSONObject g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, null, str) == null) || TextUtils.isEmpty(str) || (a2 = f.a().a(str)) == null || (g2 = a2.g()) == null || e() == null) {
            return;
        }
        e().checkAutoControl(g2, str);
    }

    public static ITTDownloadVisitor e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            ITTDownloadVisitor iTTDownloadVisitor = f61709c;
            return iTTDownloadVisitor == null ? (ITTDownloadVisitor) TTAdSdk.getAdManager().getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.b.a(1)) : iTTDownloadVisitor;
        }
        return (ITTDownloadVisitor) invokeV.objValue;
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            Context context = f61711e;
            return context == null ? TTAppContextHolder.getContext() : context;
        }
        return (Context) invokeV.objValue;
    }

    /* loaded from: classes11.dex */
    public static class a implements com.ss.android.download.api.config.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        private void c(com.ss.android.download.api.model.c cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65538, this, cVar) == null) || cVar == null) {
                return;
            }
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(cVar.b()).setExtJson(cVar.h()).setLabel(cVar.c());
            boolean z = "download_notification".equals(cVar.b()) || "landing_h5_download_ad_button".equals(cVar.b());
            if (d.e() != null) {
                d.e().executeLogUpload(label, z);
            }
        }

        @Override // com.ss.android.download.api.config.f
        public void a(com.ss.android.download.api.model.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
                com.bytedance.sdk.openadsdk.api.b.d.a("LibEventLogger", "onV3Event");
                a(cVar, true);
            }
        }

        @Override // com.ss.android.download.api.config.f
        public void b(com.ss.android.download.api.model.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
                com.bytedance.sdk.openadsdk.api.b.d.a("LibEventLogger", "onEvent called");
                a(cVar, false);
                c(cVar);
            }
        }

        private void a(com.ss.android.download.api.model.c cVar, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(65537, this, cVar, z) == null) || d.e() == null || (tTDownloadEventLogger = d.e().getTTDownloadEventLogger()) == null || cVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && d.e().isOpenSdkEvent(cVar.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(d.b(cVar));
            } else {
                tTDownloadEventLogger.onEvent(d.b(cVar));
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class c implements h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
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

        @Override // com.ss.android.download.api.config.h
        public void a(Activity activity, int i2, String[] strArr, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, activity, i2, strArr, iArr) == null) {
            }
        }

        @Override // com.ss.android.download.api.config.h
        public void a(Activity activity, String[] strArr, s sVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, strArr, sVar) == null) || d.e() == null) {
                return;
            }
            d.e().requestPermission(activity, strArr, new ITTPermissionCallback(this, sVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.c.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ s f61719a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f61720b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61720b = this;
                    this.f61719a = sVar;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                public void onDenied(String str) {
                    s sVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || (sVar2 = this.f61719a) == null) {
                        return;
                    }
                    sVar2.a(str);
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                public void onGranted() {
                    s sVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar2 = this.f61719a) == null) {
                        return;
                    }
                    sVar2.a();
                }
            });
        }

        @Override // com.ss.android.download.api.config.h
        public boolean a(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, str)) == null) {
                if (d.e() != null) {
                    return d.e().hasPermission(context, str);
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            if (context == null) {
                context = TTAppContextHolder.getContext();
            }
            if (context == null || f61710d.get()) {
                return;
            }
            synchronized (d.class) {
                if (!f61710d.get()) {
                    f61711e = context.getApplicationContext();
                    if (e() != null) {
                        String initPath = e().initPath(f61708b);
                        if (!TextUtils.isEmpty(initPath)) {
                            f61707a = initPath;
                        }
                    }
                    f61710d.set(b(f61711e));
                }
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            a().g();
            if (e() != null) {
                e().clearAllData(f61707a);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class b implements g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.ss.android.download.api.config.g
        public void a(String str, String str2, Map<String, Object> map, q qVar) {
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, map, qVar) == null) {
                int hashCode = str.hashCode();
                int i2 = 1;
                if (hashCode != 70454) {
                    if (hashCode == 2461856 && str.equals("POST")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                } else {
                    if (str.equals("GET")) {
                        c2 = 0;
                    }
                    c2 = 65535;
                }
                i2 = (c2 == 0 || c2 != 1) ? 0 : 0;
                if (d.e() != null) {
                    d.e().execute(i2, str2, map, new ITTHttpCallback(this, qVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ q f61715a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f61716b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, qVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61716b = this;
                            this.f61715a = qVar;
                        }

                        @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                        public void onError(Throwable th) {
                            q qVar2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) || (qVar2 = this.f61715a) == null) {
                                return;
                            }
                            qVar2.a(th);
                        }

                        @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                        public void onResponse(String str3) {
                            q qVar2;
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3) == null) || (qVar2 = this.f61715a) == null) {
                                return;
                            }
                            qVar2.a(str3);
                        }
                    });
                }
            }
        }

        @Override // com.ss.android.download.api.config.g
        public void a(String str, byte[] bArr, String str2, int i2, q qVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, bArr, str2, Integer.valueOf(i2), qVar}) == null) || d.e() == null) {
                return;
            }
            d.e().postBody(str, bArr, str2, new ITTHttpCallback(this, qVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f61717a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ b f61718b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, qVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i3 = newInitContext.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61718b = this;
                    this.f61717a = qVar;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                public void onError(Throwable th) {
                    q qVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, th) == null) || (qVar2 = this.f61717a) == null) {
                        return;
                    }
                    qVar2.a(th);
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                public void onResponse(String str3) {
                    q qVar2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3) == null) || (qVar2 = this.f61717a) == null) {
                        return;
                    }
                    qVar2.a(str3);
                }
            });
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.d$d  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C1850d implements k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<Context> f61721a;

        public C1850d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61721a = new WeakReference<>(context);
        }

        private DialogBuilder c(com.ss.android.download.api.model.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bVar)) == null) ? DialogBuilder.builder().setTitle(bVar.f68340b).setMessage(bVar.f68341c).setNegativeBtnText(bVar.f68343e).setPositiveBtnText(bVar.f68342d).setIcon(bVar.f68345g).setDialogStatusChangedListener(new IDialogStatusChangedListener(this, bVar) { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.download.api.model.b f61722a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ C1850d f61723b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61723b = this;
                    this.f61722a = bVar;
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    b.InterfaceC1965b interfaceC1965b;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, dialogInterface) == null) || (interfaceC1965b = this.f61722a.f68346h) == null) {
                        return;
                    }
                    interfaceC1965b.c(dialogInterface);
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC1965b interfaceC1965b;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dialogInterface) == null) || (interfaceC1965b = this.f61722a.f68346h) == null) {
                        return;
                    }
                    try {
                        interfaceC1965b.b(dialogInterface);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    b.InterfaceC1965b interfaceC1965b;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, dialogInterface) == null) || (interfaceC1965b = this.f61722a.f68346h) == null) {
                        return;
                    }
                    interfaceC1965b.a(dialogInterface);
                }
            }) : (DialogBuilder) invokeL.objValue;
        }

        @Override // com.ss.android.download.api.config.k
        public void a(int i2, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), context, downloadModel, str, drawable, Integer.valueOf(i3)}) == null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    Toast.makeText(context, str, 0).show();
                } catch (Exception e2) {
                    String str2 = "showToastWithDuration e " + e2.getMessage();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.ss.android.download.api.config.k
        /* renamed from: a */
        public AlertDialog b(com.ss.android.download.api.model.b bVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
                if (bVar != null && d.e() != null) {
                    Context context = bVar.f68339a;
                    if (context != null && (context instanceof Activity)) {
                        return d.e().showDialogBySelf((Activity) bVar.f68339a, bVar.j == 1, c(bVar));
                    }
                    d.e().showDialogByDelegate(this.f61721a, bVar.j == 1, c(bVar));
                }
                return null;
            }
            return (AlertDialog) invokeL.objValue;
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (context == null) {
                return false;
            }
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "";
            }
            com.ss.android.download.api.a a2 = com.ss.android.downloadlib.g.a(applicationContext).a();
            if (a2 == null) {
                return false;
            }
            com.ss.android.download.api.a a3 = a2.a(new c()).a(new a()).a(new C1850d(applicationContext)).a(new b()).a(new com.ss.android.download.api.config.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.ss.android.download.api.config.i
                public JSONObject a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (d.e() != null) {
                            return d.e().getDownloadSettings();
                        }
                        return new JSONObject();
                    }
                    return (JSONObject) invokeV.objValue;
                }
            }).a(new com.ss.android.download.api.config.b() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.ss.android.download.api.config.b
                public boolean a() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (d.e() != null) {
                            return d.e().getAppIsBackground();
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            }).a(new a.C1964a().b("143").a(TTAdConstant.APP_NAME).c("4.0.1.1").d(String.valueOf(4011)).a()).a(new p() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.ss.android.download.api.config.p
                public byte[] a(byte[] bArr, int i2) {
                    InterceptResult invokeLI;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLI = interceptable2.invokeLI(1048576, this, bArr, i2)) == null) ? EncryptorUtil.encrypt(bArr, i2) : (byte[]) invokeLI.objValue;
                }
            });
            a3.a(packageName + ".TTFileProvider").a(a(applicationContext, e() != null ? e().getDownloadSettings() : new JSONObject())).a();
            com.ss.android.downloadlib.g.a.a();
            com.ss.android.downloadlib.g.a(applicationContext).d().a(1);
            com.ss.android.downloadlib.g.a(applicationContext).a(f61713g);
            com.ss.android.socialbase.appdownloader.d.j().a(new ad() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // com.ss.android.socialbase.downloader.depend.ad
                public boolean a(Intent intent) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, intent)) == null) {
                        return false;
                    }
                    return invokeL2.booleanValue;
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? f61712f : (Map) invokeV.objValue;
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        f61707a = str;
    }

    public static com.ss.android.downloadlib.g a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            a(getContext());
            return com.ss.android.downloadlib.g.a(getContext());
        }
        return (com.ss.android.downloadlib.g) invokeV.objValue;
    }

    public static boolean a(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65546, null, context, uri, downloadModel, downloadEventConfig, downloadController)) == null) ? a().e().a(context, uri, downloadModel, downloadEventConfig, downloadController) : invokeLLLLL.booleanValue;
    }

    public static boolean a(Uri uri) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, uri)) == null) ? j.a(uri) : invokeL.booleanValue;
    }

    public static void a(int i2) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) || (map = f61712f) == null) {
            return;
        }
        map.remove(Integer.valueOf(i2));
    }

    public static void a(int i2, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(AdIconUtil.BAIDU_LOGO_ID, null, i2, onEventLogHandler) == null) || onEventLogHandler == null) {
            return;
        }
        if (f61712f == null) {
            f61712f = Collections.synchronizedMap(new WeakHashMap());
        }
        f61712f.put(Integer.valueOf(i2), onEventLogHandler);
    }

    public static boolean a(String str, String str2, JSONObject jSONObject, Object obj) {
        InterceptResult invokeLLLL;
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, str, str2, jSONObject, obj)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (c2 = c()) != null) {
                for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : c2.entrySet()) {
                    int intValue = entry.getKey().intValue();
                    ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                    if (value != null) {
                        boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                        if (!z && !onEventLog) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
        return invokeLLLL.booleanValue;
    }

    public static JSONObject b(com.ss.android.download.api.model.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("category", cVar.a());
                jSONObject.put("tag", cVar.b());
                jSONObject.put("label", cVar.c());
                jSONObject.put("isAd", cVar.d());
                jSONObject.put("adId", cVar.e());
                jSONObject.put("logExtra", cVar.f());
                jSONObject.put("extValue", cVar.g());
                jSONObject.put("extJson", cVar.h());
                jSONObject.put("paramsJson", cVar.i());
                jSONObject.put("eventSource", cVar.k());
                jSONObject.put("extraObject", cVar.l());
                jSONObject.put("clickTrackUrl", cVar.j());
                jSONObject.put("isV3", cVar.m());
                jSONObject.put("V3EventName", cVar.n());
                jSONObject.put("V3EventParams", cVar.o());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static DownloaderBuilder a(Context context, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, jSONObject)) == null) ? new DownloaderBuilder(context).downloadSetting(new aa() { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.aa
            public JSONObject a() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    if (d.e() != null) {
                        return d.e().getDownloadSettings();
                    }
                    return new JSONObject();
                }
                return (JSONObject) invokeV.objValue;
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new e()) : (DownloaderBuilder) invokeLL.objValue;
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                List<DownloadInfo> b2 = com.ss.android.socialbase.appdownloader.d.j().b(context);
                if (!b2.isEmpty()) {
                    for (DownloadInfo downloadInfo : b2) {
                        if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean a(Activity activity, ExitInstallListener exitInstallListener) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, activity, exitInstallListener)) == null) ? com.ss.android.downloadlib.addownload.a.a.a().a(activity, false, new a.InterfaceC1970a(exitInstallListener) { // from class: com.bytedance.sdk.openadsdk.downloadnew.d.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ExitInstallListener f61714a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {exitInstallListener};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61714a = exitInstallListener;
            }

            @Override // com.ss.android.downloadlib.addownload.a.a.InterfaceC1970a
            public void a() {
                ExitInstallListener exitInstallListener2;
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (exitInstallListener2 = this.f61714a) == null) {
                    return;
                }
                exitInstallListener2.onExitInstall();
            }
        }) : invokeLL.booleanValue;
    }
}
