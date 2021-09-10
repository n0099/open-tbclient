package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import com.baidu.down.utils.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.searchbox.task.item.StrictModeTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f63885c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f63886a;

    /* renamed from: b  reason: collision with root package name */
    public c f63887b;

    public b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63886a = new HashMap<>();
        this.f63887b = cVar;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                com.baidu.webkit.logsdk.a.b.a().c();
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            com.baidu.webkit.logsdk.a.b.a().e();
            try {
                return new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SapiOptions.KEY_CACHE))).length() >= com.baidu.webkit.logsdk.b.b.a().getLong("filesize", Constants.TEST_SPEED_THRESHOLD_DEFAULT);
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataEventProcessor: checkLongTimeLogCanUpload");
        Iterator<String> it = this.f63886a.keySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                f63885c = true;
                return;
            }
            String next = it.next();
            if (!this.f63887b.d(com.baidu.webkit.logsdk.d.c.c(next, "upload"))) {
                HashMap<String, Boolean> hashMap = this.f63886a;
                if (!hashMap.get(next).booleanValue()) {
                    b();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long c2 = com.baidu.webkit.logsdk.b.b.c();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long b2 = com.baidu.webkit.logsdk.b.b.b(next);
                    boolean z2 = false;
                    if (b2 != 0 && System.currentTimeMillis() - b2 >= c2) {
                        com.baidu.webkit.logsdk.d.c.d(next, SapiOptions.KEY_CACHE);
                        com.baidu.webkit.logsdk.d.c.d(next, "upload");
                        com.baidu.webkit.logsdk.d.c.d(next, SevenZipUtils.FILE_NAME_TEMP);
                        long currentTimeMillis = System.currentTimeMillis();
                        com.baidu.webkit.logsdk.a.b.a().e();
                        com.baidu.webkit.logsdk.b.b.a(next, currentTimeMillis);
                    } else {
                        boolean b3 = b(next);
                        if (b3) {
                            z2 = b3;
                        } else {
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long j2 = com.baidu.webkit.logsdk.b.b.a().getLong("timeup", StrictModeTask.CLEAN_FILE_INTERVAL);
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long b4 = com.baidu.webkit.logsdk.b.b.b(next);
                            if (b4 != 0 && System.currentTimeMillis() - b4 >= j2) {
                                z2 = true;
                            }
                        }
                    }
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "canUpload: " + next + " = " + z2);
                    if (!com.baidu.webkit.logsdk.a.f63835a) {
                        z = z2;
                    }
                }
                hashMap.put(next, Boolean.valueOf(z));
            }
        }
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile " + aVar.f63883a);
            try {
                String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.f63883a, SapiOptions.KEY_CACHE);
                String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
                File file = new File(b2);
                String a2 = file.exists() ? com.baidu.webkit.logsdk.d.c.a(file) : null;
                com.baidu.webkit.logsdk.b.a a3 = com.baidu.webkit.logsdk.a.b.a().e().a(aVar.f63883a);
                JSONObject jSONObject = !TextUtils.isEmpty(a2) ? new JSONObject(a2) : new JSONObject();
                String str = a3.f63871c;
                JSONArray jSONArray = jSONObject.has(str) ? jSONObject.getJSONArray(str) : new JSONArray();
                if (com.baidu.webkit.logsdk.a.f63836b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonArray", jSONArray.toString());
                }
                int size = aVar.f63884b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(aVar.f63884b.get(i2));
                }
                jSONObject.put(a3.f63871c, jSONArray);
                if (com.baidu.webkit.logsdk.a.f63836b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonObject", jSONObject.toString());
                }
                com.baidu.webkit.logsdk.d.c.b(b2, jSONObject.toString());
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile writeDataToFile");
                aVar.f63884b.clear();
                c.a(a3);
                this.f63887b.b(c2);
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
    }

    public final void a(String str) {
        com.baidu.webkit.logsdk.upload.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                File file = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SapiOptions.KEY_CACHE)));
                String str2 = null;
                if (file.exists()) {
                    File file2 = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SevenZipUtils.FILE_NAME_TEMP)));
                    file2.delete();
                    file.renameTo(file2);
                    str2 = com.baidu.webkit.logsdk.d.c.a(file2);
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache fileData", str2);
                }
                com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(str);
                JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : new JSONObject();
                String str3 = a2.f63871c;
                JSONArray jSONArray = jSONObject.has(str3) ? jSONObject.getJSONArray(str3) : new JSONArray();
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache jsonArray", jSONArray.toString());
                a a3 = this.f63887b.a(str);
                int size = a3.f63884b.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(a3.f63884b.get(i2));
                }
                a3.f63884b.clear();
                com.baidu.webkit.logsdk.d.c.d(str, SevenZipUtils.FILE_NAME_TEMP);
                if (!TextUtils.isEmpty(str2) || jSONArray.length() > 0) {
                    jSONObject.put(a2.f63871c, jSONArray);
                    if ("frame_event".equals(str)) {
                        JSONObject jSONObject2 = new JSONObject();
                        com.baidu.webkit.logsdk.a.b.a().c();
                        jSONObject2.put("user", jSONObject);
                        aVar = new com.baidu.webkit.logsdk.upload.a(a2, jSONObject2.toString());
                    } else {
                        aVar = new com.baidu.webkit.logsdk.upload.a(a2, jSONObject.toString());
                    }
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache task", aVar.f63900a);
                    aVar.f63905f = a2.f63871c;
                    aVar.f63906g = a2.f63872d;
                    this.f63887b.a(aVar);
                }
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
        }
    }

    public final void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setCanUpload: " + str + " = " + z);
            this.f63886a.put(str, Boolean.valueOf(z));
        }
    }
}
