package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.sdk.crashreportbaidu.CrashInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class lgc {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "https://crash-reporting.yy.com/crash/reporting";
    public static long b = 31457280;
    public static Executor c = null;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface f {
        void onResult(String str, boolean z, int i, String str2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947943361, "Lcom/baidu/tieba/lgc;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947943361, "Lcom/baidu/tieba/lgc;");
        }
    }

    /* loaded from: classes7.dex */
    public static class a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            }
        }

        public a() {
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
    }

    /* loaded from: classes7.dex */
    public static class b implements ComponentCallbacks2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, configuration) == null) {
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            }
        }

        public b() {
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
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pgc.a(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ f e;

        public d(List list, String str, String str2, Map map, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, str, str2, map, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = map;
            this.e = fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:113:0x022c A[Catch: all -> 0x0279, TRY_LEAVE, TryCatch #9 {all -> 0x0279, blocks: (B:111:0x0223, B:113:0x022c), top: B:150:0x0223 }] */
        /* JADX WARN: Removed duplicated region for block: B:144:0x025c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:152:0x027d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:154:0x023c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:158:0x029d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x012e A[Catch: all -> 0x01de, Exception -> 0x01e3, TryCatch #14 {Exception -> 0x01e3, blocks: (B:28:0x0064, B:29:0x006c, B:31:0x0072, B:34:0x009a, B:37:0x00a2, B:38:0x00a5, B:39:0x00ab, B:43:0x00b6, B:45:0x00bc, B:47:0x00ca, B:49:0x00d1, B:50:0x00d5, B:52:0x00e1, B:54:0x00fb, B:55:0x0100, B:57:0x0106, B:60:0x010d, B:62:0x0118, B:64:0x012e, B:67:0x0140, B:70:0x0155, B:73:0x0172, B:71:0x0161, B:61:0x0112, B:80:0x0180, B:81:0x0183, B:82:0x019d), top: B:156:0x0064 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0161 A[Catch: all -> 0x01de, Exception -> 0x01e3, TryCatch #14 {Exception -> 0x01e3, blocks: (B:28:0x0064, B:29:0x006c, B:31:0x0072, B:34:0x009a, B:37:0x00a2, B:38:0x00a5, B:39:0x00ab, B:43:0x00b6, B:45:0x00bc, B:47:0x00ca, B:49:0x00d1, B:50:0x00d5, B:52:0x00e1, B:54:0x00fb, B:55:0x0100, B:57:0x0106, B:60:0x010d, B:62:0x0118, B:64:0x012e, B:67:0x0140, B:70:0x0155, B:73:0x0172, B:71:0x0161, B:61:0x0112, B:80:0x0180, B:81:0x0183, B:82:0x019d), top: B:156:0x0064 }] */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0172 A[Catch: all -> 0x01de, Exception -> 0x01e3, TryCatch #14 {Exception -> 0x01e3, blocks: (B:28:0x0064, B:29:0x006c, B:31:0x0072, B:34:0x009a, B:37:0x00a2, B:38:0x00a5, B:39:0x00ab, B:43:0x00b6, B:45:0x00bc, B:47:0x00ca, B:49:0x00d1, B:50:0x00d5, B:52:0x00e1, B:54:0x00fb, B:55:0x0100, B:57:0x0106, B:60:0x010d, B:62:0x0118, B:64:0x012e, B:67:0x0140, B:70:0x0155, B:73:0x0172, B:71:0x0161, B:61:0x0112, B:80:0x0180, B:81:0x0183, B:82:0x019d), top: B:156:0x0064 }] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.util.zip.ZipOutputStream] */
        /* JADX WARN: Type inference failed for: r6v20 */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.util.zip.ZipOutputStream] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            WritableByteChannel writableByteChannel;
            Throwable th;
            ZipOutputStream zipOutputStream;
            ZipOutputStream zipOutputStream2;
            Exception exc;
            StringBuilder sb;
            ZipOutputStream zipOutputStream3;
            ZipOutputStream zipOutputStream4;
            FileChannel fileChannel;
            long length;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    ArrayList<String> arrayList = new ArrayList();
                    if (this.a != null) {
                        try {
                            if (this.a.size() > 0) {
                                for (String str : this.a) {
                                    if (str != null && str.length() > 0) {
                                        arrayList.add(str);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            zipOutputStream4 = null;
                            writableByteChannel = null;
                            zipOutputStream2 = zipOutputStream4;
                            try {
                                jgc.h("CrashUploader", "uploadReport ERROR:", e);
                                if (this.e != null) {
                                }
                                if (zipOutputStream2 != 0) {
                                }
                                if (writableByteChannel == null) {
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                zipOutputStream = zipOutputStream2;
                                if (zipOutputStream != 0) {
                                    try {
                                        zipOutputStream.finish();
                                        zipOutputStream.close();
                                    } catch (Exception e2) {
                                        jgc.g("CrashUploader", "outZip close ERROR:" + e2.getMessage());
                                    }
                                }
                                if (writableByteChannel != null) {
                                    try {
                                        writableByteChannel.close();
                                    } catch (Exception e3) {
                                        jgc.g("CrashUploader", "writableByteChannel close ERROR:" + e3.getMessage());
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            zipOutputStream3 = null;
                            writableByteChannel = null;
                            zipOutputStream = zipOutputStream3;
                            if (zipOutputStream != 0) {
                            }
                            if (writableByteChannel != null) {
                            }
                            throw th;
                        }
                    }
                    if (arrayList.size() > 0) {
                        ZipOutputStream zipOutputStream5 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.b)));
                        try {
                            writableByteChannel = Channels.newChannel(zipOutputStream5);
                            try {
                                try {
                                    long j = 0;
                                    for (String str2 : arrayList) {
                                        try {
                                            jgc.d("CrashUploader", "uploadReport file = " + str2);
                                            fileChannel = new FileInputStream(str2).getChannel();
                                        } catch (Exception e4) {
                                            e = e4;
                                            fileChannel = null;
                                        }
                                        try {
                                            File file = new File(str2);
                                            if (!file.exists()) {
                                                if (fileChannel != null) {
                                                    fileChannel.close();
                                                }
                                                jgc.b("CrashUploader", "Exception: File is not exists");
                                            } else {
                                                if (!str2.endsWith("dmp")) {
                                                    if (str2.endsWith("hprof")) {
                                                        if (j + (file.length() / 4) > lgc.b) {
                                                            jgc.b("CrashUploader", "Upload hprof file too large, not upload!");
                                                            if (fileChannel != null) {
                                                                fileChannel.close();
                                                            }
                                                        }
                                                    } else if (j + file.length() > lgc.b) {
                                                        jgc.b("CrashUploader", file.getName() + " too large, not upload!");
                                                        if (fileChannel != null) {
                                                            fileChannel.close();
                                                        }
                                                    }
                                                }
                                                if (!str2.endsWith("dmp") && !str2.endsWith("hprof")) {
                                                    length = file.length();
                                                    long j2 = j + length;
                                                    zipOutputStream5.putNextEntry(new ZipEntry(file.getName()));
                                                    if (!str2.endsWith("hprof")) {
                                                        long length2 = file.length() / 4;
                                                        long length3 = file.length();
                                                        long j3 = 0;
                                                        while (length3 > length2) {
                                                            length3 -= length2;
                                                            j3 += fileChannel.transferTo(j3, length2, writableByteChannel);
                                                        }
                                                        if (length3 > 0) {
                                                            fileChannel.transferTo(j3, length3, writableByteChannel);
                                                        }
                                                    } else {
                                                        fileChannel.transferTo(0L, file.length(), writableByteChannel);
                                                    }
                                                    if (fileChannel != null) {
                                                        fileChannel.close();
                                                    }
                                                    j = j2;
                                                }
                                                length = file.length() / 4;
                                                long j22 = j + length;
                                                zipOutputStream5.putNextEntry(new ZipEntry(file.getName()));
                                                if (!str2.endsWith("hprof")) {
                                                }
                                                if (fileChannel != null) {
                                                }
                                                j = j22;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            if (fileChannel != null) {
                                                fileChannel.close();
                                            }
                                            jgc.b("CrashUploader", "Exception: " + e.getMessage());
                                        }
                                    }
                                    zipOutputStream5.flush();
                                    zipOutputStream5.finish();
                                    zipOutputStream5.close();
                                    jgc.d("CrashUploader", "post file size = " + j);
                                    lgc.h(lgc.c, this.c, this.d, this.b, this.e);
                                    jgc.d("CrashUploader", "post end file size = " + j);
                                } catch (Exception e6) {
                                    e = e6;
                                    zipOutputStream2 = zipOutputStream5;
                                    jgc.h("CrashUploader", "uploadReport ERROR:", e);
                                    if (this.e != null) {
                                        this.e.onResult(this.c, false, 201, e.getMessage());
                                    }
                                    if (zipOutputStream2 != 0) {
                                        try {
                                            zipOutputStream2.finish();
                                            zipOutputStream2.close();
                                        } catch (Exception e7) {
                                            jgc.g("CrashUploader", "outZip close ERROR:" + e7.getMessage());
                                        }
                                    }
                                    if (writableByteChannel == null) {
                                        try {
                                            writableByteChannel.close();
                                            return;
                                        } catch (Exception e8) {
                                            exc = e8;
                                            sb = new StringBuilder();
                                            sb.append("writableByteChannel close ERROR:");
                                            sb.append(exc.getMessage());
                                            jgc.g("CrashUploader", sb.toString());
                                        }
                                    }
                                    return;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                zipOutputStream = zipOutputStream5;
                                if (zipOutputStream != 0) {
                                }
                                if (writableByteChannel != null) {
                                }
                                throw th;
                            }
                        } catch (Exception e9) {
                            e = e9;
                            zipOutputStream4 = zipOutputStream5;
                            writableByteChannel = null;
                            zipOutputStream2 = zipOutputStream4;
                            jgc.h("CrashUploader", "uploadReport ERROR:", e);
                            if (this.e != null) {
                            }
                            if (zipOutputStream2 != 0) {
                            }
                            if (writableByteChannel == null) {
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            zipOutputStream3 = zipOutputStream5;
                            writableByteChannel = null;
                            zipOutputStream = zipOutputStream3;
                            if (zipOutputStream != 0) {
                            }
                            if (writableByteChannel != null) {
                            }
                            throw th;
                        }
                    } else {
                        jgc.d("CrashUploader", "post file null");
                        writableByteChannel = null;
                        try {
                            lgc.h(lgc.c, this.c, this.d, null, this.e);
                            jgc.d("CrashUploader", "post file null end");
                        } catch (Exception e10) {
                            e = e10;
                            zipOutputStream2 = writableByteChannel;
                            jgc.h("CrashUploader", "uploadReport ERROR:", e);
                            if (this.e != null) {
                            }
                            if (zipOutputStream2 != 0) {
                            }
                            if (writableByteChannel == null) {
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            th = th;
                            zipOutputStream = writableByteChannel;
                            if (zipOutputStream != 0) {
                            }
                            if (writableByteChannel != null) {
                            }
                            throw th;
                        }
                    }
                    WritableByteChannel writableByteChannel2 = writableByteChannel;
                    if (writableByteChannel2 != null) {
                        try {
                            writableByteChannel2.close();
                        } catch (Exception e11) {
                            exc = e11;
                            sb = new StringBuilder();
                            sb.append("writableByteChannel close ERROR:");
                            sb.append(exc.getMessage());
                            jgc.g("CrashUploader", sb.toString());
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    writableByteChannel = null;
                } catch (Throwable th7) {
                    th = th7;
                    writableByteChannel = null;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ f d;

        public e(Map map, String str, String str2, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map, str, str2, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.b = str;
            this.c = str2;
            this.d = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.currentThread().setName("fallThread");
                    MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                    for (Map.Entry entry : this.a.entrySet()) {
                        type.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + ((String) entry.getKey()) + "\""), RequestBody.create((MediaType) null, (String) entry.getValue()));
                    }
                    if (this.b != null && this.b.length() > 0) {
                        File file = new File(this.b);
                        MediaType parse = MediaType.parse(URLConnection.getFileNameMap().getContentTypeFor(this.b));
                        type.addPart(Headers.of("Content-Disposition", "form-data; name=\"files\"; filename=\"" + file.getName() + "\""), RequestBody.create(parse, file));
                    }
                    Request build = new Request.Builder().url(this.c).post(type.build()).build();
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    builder.connectTimeout(3000L, TimeUnit.SECONDS);
                    builder.writeTimeout(5000L, TimeUnit.SECONDS);
                    builder.readTimeout(3000L, TimeUnit.SECONDS);
                    Response execute = builder.build().newCall(build).execute();
                    jgc.d("CrashUploader", "post end");
                    String string = execute.body().string();
                    int code = execute.code();
                    if (this.d != null) {
                        this.d.onResult(this.c, true, code, string);
                    }
                    execute.close();
                } catch (Throwable th) {
                    f fVar = this.d;
                    if (fVar != null) {
                        fVar.onResult(this.c, false, -3, th.getMessage());
                    }
                }
            }
        }
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d;
        }
        return invokeV.booleanValue;
    }

    public static String b(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put(str2, str3);
                return jSONObject.toString();
            } catch (Exception unused) {
                return str;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static Map<String, String> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, mgc.e());
            hashMap.put("sign", "");
            hashMap.put("data", ogc.a(str));
            jgc.d("CrashUploader", "APP_ID_KEY: " + mgc.e());
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            return mgc.s() + File.separator + str + "_" + str2 + ".zip";
        }
        return (String) invokeLL.objValue;
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, context) != null) || c != null) {
            return;
        }
        c = Executors.newSingleThreadExecutor();
        if ((context instanceof Application) && Build.VERSION.SDK_INT >= 14) {
            g((Application) context);
        }
        i(context);
    }

    @TargetApi(14)
    public static void g(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, application) == null) {
            application.registerActivityLifecycleCallbacks(new a());
            application.registerComponentCallbacks(new b());
        }
    }

    public static void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, context) == null) {
            if (context == null) {
                jgc.b("CrashUploader", "Context is null");
            } else {
                c.execute(new c(context));
            }
        }
    }

    public static boolean h(Executor executor, String str, Map<String, String> map, String str2, f fVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, executor, str, map, str2, fVar)) == null) {
            if (str != null && str.length() > 0) {
                jgc.d("CrashUploader", "post start file name is " + str2);
                executor.execute(new e(map, str2, str, fVar));
                return true;
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean j(CrashInfo crashInfo, String str, f fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, crashInfo, str, fVar)) == null) {
            Map<String, String> c2 = c(b(crashInfo.nyyData, "stage", "1"));
            if (str != null && str.length() > 0) {
                c2.put("errorInfo", str);
            }
            return h(c, a, c2, null, fVar);
        }
        return invokeLLL.booleanValue;
    }

    public static boolean k(CrashInfo crashInfo, String str, List<String> list, f fVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65547, null, crashInfo, str, list, fVar)) == null) {
            return l(a, c(b(crashInfo.nyyData, "stage", str)), list, d(crashInfo.crashId, str), fVar);
        }
        return invokeLLLL.booleanValue;
    }

    public static boolean l(String str, Map<String, String> map, List<String> list, String str2, f fVar) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, str, map, list, str2, fVar)) == null) {
            c.execute(new d(list, str2, str, map, fVar));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }
}
