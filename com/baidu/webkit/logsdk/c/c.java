package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.logsdk.d;
import com.baidu.webkit.logsdk.d.c;
import com.baidu.webkit.logsdk.upload.BdLogNetRequest;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<com.baidu.webkit.logsdk.upload.a> f61074a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, a> f61075b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f61076c;

    /* renamed from: d  reason: collision with root package name */
    public b f61077d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f61078e;

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
                return;
            }
        }
        this.f61078e = new Object();
        this.f61074a = new LinkedList<>();
        this.f61075b = new ConcurrentHashMap<>();
        this.f61076c = new ConcurrentHashMap<>();
    }

    public static com.baidu.webkit.logsdk.upload.a a(File file, com.baidu.webkit.logsdk.b.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, file, aVar)) == null) {
            String a2 = com.baidu.webkit.logsdk.d.c.a(file);
            if (com.baidu.webkit.logsdk.a.f61024b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile read", a2);
            }
            String[] split = a2.split("\\r\\n");
            if (split.length == 4) {
                int i2 = 0;
                try {
                    i2 = Integer.parseInt(split[0]);
                } catch (Exception e2) {
                    com.baidu.webkit.logsdk.d.c.a(e2);
                }
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile count = ".concat(String.valueOf(i2)));
                String str = split[1];
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile keyId = ".concat(String.valueOf(str)));
                String str2 = split[2];
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile baseInfoEncode", str2);
                String str3 = split[3];
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile content", str3);
                com.baidu.webkit.logsdk.upload.a aVar2 = new com.baidu.webkit.logsdk.upload.a(aVar, str3, str);
                aVar2.f61094i = str2;
                aVar2.f61087b = i2;
                return aVar2;
            }
            return null;
        }
        return (com.baidu.webkit.logsdk.upload.a) invokeLL.objValue;
    }

    public static String a(String str, long j) {
        JSONObject jSONObject;
        boolean z;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, str, j)) == null) {
            try {
                jSONObject = new JSONObject(str);
                z = true;
            } catch (Exception unused) {
                jSONObject = new JSONObject();
                z = false;
            }
            try {
                if (z) {
                    jSONObject.put("log_time", j);
                } else {
                    jSONObject.put("log_time", j);
                    jSONObject.put("data", str);
                }
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
            if (com.baidu.webkit.logsdk.a.f61024b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor new log", jSONObject.toString());
            }
            return jSONObject.toString();
        }
        return (String) invokeLJ.objValue;
    }

    public static void a(com.baidu.webkit.logsdk.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, aVar) == null) {
            com.baidu.webkit.logsdk.b.b e2 = com.baidu.webkit.logsdk.a.b.a().e();
            String f2 = com.baidu.webkit.logsdk.b.b.f();
            if (f2.equals(aVar.f61057c)) {
                return;
            }
            int a2 = com.baidu.webkit.logsdk.d.c.a(f2);
            if ((a2 != 0 || TextUtils.isEmpty(com.baidu.webkit.logsdk.d.c.a(e2, f2))) && a2 != 1) {
                return;
            }
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "updateConfig = " + aVar.f61055a + " ;enType = " + a2);
            aVar.f61057c = f2;
            aVar.f61058d = com.baidu.webkit.logsdk.b.b.d();
            e2.a(aVar);
        }
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            try {
                long parseLong = Long.parseLong(str);
                long currentTimeMillis = System.currentTimeMillis();
                com.baidu.webkit.logsdk.a.b.a().e();
                return currentTimeMillis - parseLong < com.baidu.webkit.logsdk.b.b.c();
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!this.f61075b.containsKey(str)) {
                this.f61075b.put(str, new a(str));
            }
            return this.f61075b.get(str);
        }
        return (a) invokeL.objValue;
    }

    public final void a(int i2) {
        com.baidu.webkit.logsdk.upload.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.baidu.webkit.logsdk.a.b.a().g();
            if (com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d())) {
                com.baidu.webkit.logsdk.a.b.a().e();
                i2 = Math.min(i2, com.baidu.webkit.logsdk.b.b.b());
            } else {
                com.baidu.webkit.logsdk.a.b.a().g();
                if (!com.baidu.webkit.logsdk.a.a.b(com.baidu.webkit.logsdk.a.b.d()).equals("wifi")) {
                    return;
                }
            }
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalRetryFile check ".concat(String.valueOf(i2)));
            File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (file.isFile()) {
                    String name = file.getName();
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "LocalRetryFile: ".concat(String.valueOf(name)));
                    if (!TextUtils.isEmpty(name) && !d(name)) {
                        try {
                            byte[] decode = Base64.decode(name, 0);
                            if (decode.length > 0) {
                                String str = new String(decode);
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "LocalRetryFile realFileName", str);
                                String[] split = str.split("-");
                                if (split.length > 1) {
                                    String str2 = split[0];
                                    String str3 = split[1];
                                    com.baidu.webkit.logsdk.b.a a3 = com.baidu.webkit.logsdk.a.b.a().e().a(str2);
                                    int i3 = a3.f61056b;
                                    if (!str3.equals(SapiOptions.KEY_CACHE) && !str3.equals(SevenZipUtils.FILE_NAME_TEMP)) {
                                        if (str3.equals("upload")) {
                                            if (i2 == 3 && i3 == 3) {
                                                b().a(str2, true);
                                            }
                                        } else if (e(str3)) {
                                            if (i3 <= i2 && i3 > 0 && (a2 = a(file, a3)) != null) {
                                                a2.f61093h = name;
                                                c(name);
                                                this.f61074a.add(a2);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                        file.delete();
                    }
                }
            }
        }
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f61074a.add(aVar);
        }
    }

    public final synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.f61074a.isEmpty()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule empty");
                    return false;
                }
                final com.baidu.webkit.logsdk.upload.a remove = this.f61074a.remove(0);
                if (remove != null) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule task");
                    int i2 = remove.f61090e.f61056b;
                    com.baidu.webkit.logsdk.a.b.a().e();
                    int b2 = com.baidu.webkit.logsdk.b.b.b();
                    com.baidu.webkit.logsdk.a.b.a().g();
                    if (!com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d()) || i2 <= b2) {
                        final com.baidu.webkit.logsdk.upload.b f2 = com.baidu.webkit.logsdk.a.b.a().f();
                        long currentTimeMillis = System.currentTimeMillis();
                        f2.f61096b.put(Long.valueOf(currentTimeMillis), remove);
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks put ".concat(String.valueOf(currentTimeMillis)));
                        JSONObject a2 = com.baidu.webkit.logsdk.upload.b.a(remove, currentTimeMillis);
                        remove.f61089d = currentTimeMillis;
                        String a3 = f2.a(remove.f61090e);
                        if (com.baidu.webkit.logsdk.a.f61024b) {
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload object", a2.toString());
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload url", a3);
                            if (remove.f61090e.f61056b == 1) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "real: content", com.baidu.webkit.logsdk.d.c.a(remove.f61086a, remove.f61091f));
                            }
                            if (remove.f61090e.f61056b == 2) {
                                try {
                                    JSONArray jSONArray = new JSONArray(remove.f61086a);
                                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "short: content", com.baidu.webkit.logsdk.d.c.a(jSONArray.getString(i3), remove.f61091f));
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (remove.f61090e.f61056b == 3) {
                                try {
                                    JSONObject jSONObject = new JSONObject(remove.f61086a);
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                                    Iterator<String> keys = jSONObject2.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: keyId=".concat(String.valueOf(next)));
                                        JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                                        for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: content=".concat(String.valueOf(com.baidu.webkit.logsdk.d.c.a(jSONArray2.getString(i4), next))));
                                        }
                                    }
                                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "long: static", com.baidu.webkit.logsdk.d.c.a(jSONObject.getString("static"), remove.f61091f));
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "baseinfo", com.baidu.webkit.logsdk.d.c.a(remove.f61094i, remove.f61091f));
                        } else {
                            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "upload");
                        }
                        d dVar = new d(f2, remove) { // from class: com.baidu.webkit.logsdk.upload.b.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ a f61097a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ b f61098b;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {f2, remove};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i5 = newInitContext.flag;
                                    if ((i5 & 1) != 0) {
                                        int i6 = i5 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f61098b = f2;
                                this.f61097a = remove;
                            }

                            @Override // com.baidu.webkit.logsdk.d
                            public final void a(byte[] bArr) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, bArr) == null) {
                                    if (bArr == null) {
                                        this.f61098b.a(this.f61097a);
                                        return;
                                    }
                                    b bVar = this.f61098b;
                                    a aVar = this.f61097a;
                                    c.a("BdLogSDK", "onUploadSuccess", null);
                                    com.baidu.webkit.logsdk.b.a aVar2 = aVar.f61090e;
                                    String str = aVar2.f61055a;
                                    if (aVar2.f61056b == 3) {
                                        com.baidu.webkit.logsdk.a.b.a().e();
                                        com.baidu.webkit.logsdk.b.b.a(str, System.currentTimeMillis());
                                        com.baidu.webkit.logsdk.a.b.a().h().b().a(str, false);
                                    }
                                    String str2 = aVar.f61093h;
                                    if (!TextUtils.isEmpty(str2)) {
                                        com.baidu.webkit.logsdk.a.b.a().h().b(str2);
                                        new File(c.b(str2)).delete();
                                    }
                                    bVar.a(aVar.f61089d);
                                    com.baidu.webkit.logsdk.a.b.a().a(0L);
                                }
                            }
                        };
                        try {
                            try {
                                if (com.baidu.webkit.logsdk.a.b.a().f61035a == null) {
                                    BdLogNetRequest.uploadLog(a3, a2, null, dVar);
                                }
                            } catch (Throwable unused) {
                                f2.a(remove);
                            }
                        } catch (Throwable unused2) {
                        }
                    } else {
                        com.baidu.webkit.logsdk.a.b.a().a(remove, System.currentTimeMillis(), false);
                    }
                }
                return !this.f61074a.isEmpty();
            }
        }
        return invokeV.booleanValue;
    }

    public final b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f61077d == null) {
                this.f61077d = new b(this);
            }
            return this.f61077d;
        }
        return (b) invokeV.objValue;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "removeFileHandlingState ".concat(String.valueOf(str)));
            synchronized (this.f61078e) {
                if (this.f61076c.containsKey(str)) {
                    int intValue = this.f61076c.get(str).intValue();
                    if (intValue > 1) {
                        this.f61076c.put(str, Integer.valueOf(intValue - 1));
                    } else {
                        this.f61076c.remove(str);
                    }
                }
            }
        }
    }

    public final synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
                if (listFiles == null) {
                    return;
                }
                int length = listFiles.length;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum num = ".concat(String.valueOf(length)));
                if (length >= 1000) {
                    Arrays.sort(listFiles, new Comparator<File>(this) { // from class: com.baidu.webkit.logsdk.c.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f61079a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f61079a = this;
                        }

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(File file, File file2) {
                            int i2 = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                            if (i2 > 0) {
                                return 1;
                            }
                            return i2 == 0 ? 0 : -1;
                        }
                    });
                    int max = Math.max(length - 1000, 99);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum deleteNum ".concat(String.valueOf(max)));
                    int i2 = 0;
                    while (i2 <= max) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum i = ".concat(String.valueOf(i2)));
                        File file = listFiles[i2];
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum lastModified = " + file.lastModified());
                        String str = new String(Base64.decode(file.getName(), 0));
                        String[] split = str.split("-");
                        if (split.length > 1) {
                            String str2 = split[1];
                            if (str2.equals(SapiOptions.KEY_CACHE) || str2.equals(SevenZipUtils.FILE_NAME_TEMP) || str2.equals("upload")) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "checkLocalFileNum file", str);
                                i2++;
                                max++;
                            }
                        }
                        if (file.delete()) {
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "checkLocalFileNum delete file", str);
                            i2++;
                        }
                    }
                }
            }
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            synchronized (this.f61078e) {
                int intValue = this.f61076c.containsKey(str) ? 1 + this.f61076c.get(str).intValue() : 1;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addFileHandlingState " + str + "; value = " + intValue);
                this.f61076c.put(str, Integer.valueOf(intValue));
            }
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            synchronized (this.f61078e) {
                containsKey = this.f61076c.containsKey(str);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isFileHandlingState " + str + ": " + containsKey);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }
}
