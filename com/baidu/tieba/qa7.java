package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class qa7 {
    public static /* synthetic */ Interceptable $ic;
    public static Pattern a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public int g;
        public long h;
        public String i;
        public int j;
        public long k;
        public long l;
        public long m;
        public String n;
        public int o;

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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948085186, "Lcom/baidu/tieba/qa7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948085186, "Lcom/baidu/tieba/qa7;");
                return;
            }
        }
        a = Pattern.compile(UrlSchemaHelper.PB_URL);
    }

    public static List<a> a(String str, String str2, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Long.valueOf(j), Long.valueOf(j2)})) == null) ? b(str, str2, null, 0L, j, j2) : (List) invokeCommon.objValue;
    }

    public static List<a> b(String str, String str2, UserData userData, long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{str, str2, userData, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            int i = -1;
            int userType = userData != null ? userData.getUserType() : -1;
            LinkedList linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                int i2 = 0;
                while (i2 < length) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    String optString = optJSONObject.optString("title");
                    String optString2 = optJSONObject.optString("url");
                    String optString3 = optJSONObject.optString("src");
                    String optString4 = optJSONObject.optString("text");
                    optJSONObject.optLong("picId");
                    String optString5 = optJSONObject.optString("msg_src");
                    a aVar = new a();
                    if (!TextUtils.isEmpty(optString2)) {
                        optString2 = optString2.trim();
                        Matcher matcher = a.matcher(optString2);
                        if (matcher.find()) {
                            aVar.n = matcher.group(1);
                        }
                    }
                    aVar.d = optString2;
                    aVar.a = optString;
                    aVar.b = optString4;
                    aVar.c = optString3;
                    aVar.e = str2;
                    aVar.k = j2;
                    aVar.l = j3;
                    aVar.f = optString5;
                    if (userType > i) {
                        aVar.g = userType;
                    }
                    if (userData != null) {
                        aVar.h = j;
                        aVar.i = userData.getUserId();
                        aVar.j = userData.getUserType();
                    }
                    linkedList.add(aVar);
                    i2++;
                    i = -1;
                }
                return linkedList;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (List) invokeCommon.objValue;
    }
}
