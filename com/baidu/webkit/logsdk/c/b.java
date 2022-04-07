package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import com.baidu.down.utils.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
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
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public c b;

    public b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = cVar;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            try {
                com.baidu.webkit.logsdk.a.b.a().c();
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            com.baidu.webkit.logsdk.a.b.a().e();
            try {
                return new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, "cache"))).length() >= com.baidu.webkit.logsdk.b.b.a().getLong("filesize", Constants.TEST_SPEED_THRESHOLD_DEFAULT);
            } catch (Exception e) {
                e.printStackTrace();
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
        Iterator<String> it = this.a.keySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                c = true;
                return;
            }
            String next = it.next();
            if (!this.b.d(com.baidu.webkit.logsdk.d.c.c(next, StatConstants.VALUE_TYPE_UPLOAD))) {
                HashMap<String, Boolean> hashMap = this.a;
                if (!hashMap.get(next).booleanValue()) {
                    b();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long c2 = com.baidu.webkit.logsdk.b.b.c();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long b = com.baidu.webkit.logsdk.b.b.b(next);
                    boolean z2 = false;
                    if (b != 0 && System.currentTimeMillis() - b >= c2) {
                        com.baidu.webkit.logsdk.d.c.d(next, "cache");
                        com.baidu.webkit.logsdk.d.c.d(next, StatConstants.VALUE_TYPE_UPLOAD);
                        com.baidu.webkit.logsdk.d.c.d(next, SevenZipUtils.FILE_NAME_TEMP);
                        long currentTimeMillis = System.currentTimeMillis();
                        com.baidu.webkit.logsdk.a.b.a().e();
                        com.baidu.webkit.logsdk.b.b.a(next, currentTimeMillis);
                    } else {
                        boolean b2 = b(next);
                        if (b2) {
                            z2 = b2;
                        } else {
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long j = com.baidu.webkit.logsdk.b.b.a().getLong("timeup", 172800000L);
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long b3 = com.baidu.webkit.logsdk.b.b.b(next);
                            if (b3 != 0 && System.currentTimeMillis() - b3 >= j) {
                                z2 = true;
                            }
                        }
                    }
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "canUpload: " + next + " = " + z2);
                    if (!com.baidu.webkit.logsdk.a.a) {
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
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile " + aVar.a);
            try {
                String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.a, "cache");
                String b = com.baidu.webkit.logsdk.d.c.b(c2);
                File file = new File(b);
                String a = file.exists() ? com.baidu.webkit.logsdk.d.c.a(file) : null;
                com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(aVar.a);
                JSONObject jSONObject = !TextUtils.isEmpty(a) ? new JSONObject(a) : new JSONObject();
                String str = a2.c;
                JSONArray jSONArray = jSONObject.has(str) ? jSONObject.getJSONArray(str) : new JSONArray();
                if (com.baidu.webkit.logsdk.a.b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonArray", jSONArray.toString());
                }
                int size = aVar.b.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(aVar.b.get(i));
                }
                jSONObject.put(a2.c, jSONArray);
                if (com.baidu.webkit.logsdk.a.b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonObject", jSONObject.toString());
                }
                com.baidu.webkit.logsdk.d.c.b(b, jSONObject.toString());
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile writeDataToFile");
                aVar.b.clear();
                c.a(a2);
                this.b.b(c2);
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
    }

    public final void a(String str) {
        com.baidu.webkit.logsdk.upload.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            try {
                File file = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, "cache")));
                String str2 = null;
                if (file.exists()) {
                    File file2 = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SevenZipUtils.FILE_NAME_TEMP)));
                    file2.delete();
                    file.renameTo(file2);
                    str2 = com.baidu.webkit.logsdk.d.c.a(file2);
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache fileData", str2);
                }
                com.baidu.webkit.logsdk.b.a a = com.baidu.webkit.logsdk.a.b.a().e().a(str);
                JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : new JSONObject();
                String str3 = a.c;
                JSONArray jSONArray = jSONObject.has(str3) ? jSONObject.getJSONArray(str3) : new JSONArray();
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache jsonArray", jSONArray.toString());
                a a2 = this.b.a(str);
                int size = a2.b.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(a2.b.get(i));
                }
                a2.b.clear();
                com.baidu.webkit.logsdk.d.c.d(str, SevenZipUtils.FILE_NAME_TEMP);
                if (!TextUtils.isEmpty(str2) || jSONArray.length() > 0) {
                    jSONObject.put(a.c, jSONArray);
                    if ("frame_event".equals(str)) {
                        JSONObject jSONObject2 = new JSONObject();
                        com.baidu.webkit.logsdk.a.b.a().c();
                        jSONObject2.put("user", jSONObject);
                        aVar = new com.baidu.webkit.logsdk.upload.a(a, jSONObject2.toString());
                    } else {
                        aVar = new com.baidu.webkit.logsdk.upload.a(a, jSONObject.toString());
                    }
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache task", aVar.a);
                    aVar.f = a.c;
                    aVar.g = a.d;
                    this.b.a(aVar);
                }
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
        }
    }

    public final void a(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, str, z) == null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setCanUpload: " + str + " = " + z);
            this.a.put(str, Boolean.valueOf(z));
        }
    }
}
