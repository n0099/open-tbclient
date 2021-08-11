package com.baidu.webkit.logsdk.upload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.logsdk.d.c;
import java.net.URLEncoder;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f63529a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Long, a> f63530b;

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
                return;
            }
        }
        this.f63530b = new ConcurrentHashMap<>();
    }

    public static JSONObject a(a aVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, aVar, j2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("version", "1");
                jSONObject.putOpt("log_type", aVar.f63524e.f63489a);
                jSONObject.putOpt("file", Boolean.valueOf(aVar.f63522c));
                jSONObject.putOpt("upload_time", Long.valueOf(j2));
                jSONObject.putOpt("retry_count", Integer.valueOf(aVar.f63521b));
                jSONObject.putOpt("f2", aVar.f63525f);
                com.baidu.webkit.logsdk.a.b.a().e();
                jSONObject.putOpt("f1", com.baidu.webkit.logsdk.b.b.e());
                jSONObject.putOpt("f3", com.baidu.webkit.logsdk.b.b.g());
                jSONObject.putOpt("log_level", Integer.valueOf(aVar.f63524e.f63490b));
                String str = aVar.f63528i;
                String a2 = (TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equals(str)) ? "full".equals(aVar.f63524e.f63493e) ? com.baidu.webkit.logsdk.a.b.a().g().a(com.baidu.webkit.logsdk.a.b.d()) : com.baidu.webkit.logsdk.a.b.a().g().b(com.baidu.webkit.logsdk.a.b.d(), aVar.f63524e.f63493e) : aVar.f63528i;
                if (!TextUtils.isEmpty(a2)) {
                    jSONObject.putOpt("base_info", Integer.toString(aVar.f63521b));
                    aVar.f63528i = a2;
                }
                jSONObject.putOpt("content", aVar.f63520a);
            } catch (Throwable th) {
                c.a(th);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLJ.objValue;
    }

    public final String a(com.baidu.webkit.logsdk.b.a aVar) {
        InterceptResult invokeL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if ("full".equals(aVar.f63493e)) {
                com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
                str = a2.g().a(a2.f63470c, this.f63529a);
                str2 = aVar.f63489a;
            } else {
                com.baidu.webkit.logsdk.a.b a3 = com.baidu.webkit.logsdk.a.b.a();
                String str3 = this.f63529a;
                String str4 = aVar.f63493e;
                if ("full".equals(str4)) {
                    str = a3.g().a(a3.f63470c, str3);
                } else {
                    com.baidu.webkit.logsdk.a.a g2 = a3.g();
                    Context context = a3.f63470c;
                    com.baidu.webkit.logsdk.b.c d2 = com.baidu.webkit.logsdk.a.b.a().e().d(str4);
                    if ("full".equals(d2.f63500a)) {
                        str = g2.a(context, str3);
                    } else {
                        HashSet<String> hashSet = d2.f63501b;
                        if (hashSet != null) {
                            StringBuilder sb = new StringBuilder(str3);
                            if (!hashSet.isEmpty() && str3.indexOf("?") < 0) {
                                sb.append("?");
                            }
                            com.baidu.webkit.logsdk.b c2 = com.baidu.webkit.logsdk.a.b.a().c();
                            Iterator<String> it = hashSet.iterator();
                            String str5 = "";
                            String str6 = "";
                            String str7 = str6;
                            String str8 = str7;
                            while (it.hasNext()) {
                                String next = it.next();
                                Iterator<String> it2 = it;
                                String a4 = g2.a(next, context, c2);
                                if ("ua".equals(next)) {
                                    str6 = a4;
                                } else if ("cuid".equals(next)) {
                                    str7 = a4;
                                } else if ("uid".equals(next)) {
                                    str8 = a4;
                                }
                                if (TextUtils.isEmpty(a4)) {
                                    int a5 = g2.a(next, context);
                                    if (a5 > 0) {
                                        sb.append("&");
                                        sb.append(next);
                                        sb.append("=");
                                        sb.append(a5);
                                    }
                                } else {
                                    sb.append("&");
                                    sb.append(next);
                                    sb.append("=");
                                    sb.append(a4);
                                }
                                it = it2;
                            }
                            if (!TextUtils.isEmpty(str6)) {
                                str5 = "ua";
                            }
                            if (!TextUtils.isEmpty(str7)) {
                                if (!TextUtils.isEmpty(str6)) {
                                    str5 = str5 + "_";
                                }
                                str5 = str5 + "cuid";
                            }
                            if (!TextUtils.isEmpty(str8)) {
                                if (!TextUtils.isEmpty(str7) || !TextUtils.isEmpty(str6)) {
                                    str5 = str5 + "_";
                                }
                                str5 = str5 + "uid";
                            }
                            if (!TextUtils.isEmpty(str5)) {
                                sb.append("&cen=");
                                sb.append(str5);
                            }
                            str = sb.toString();
                        } else {
                            str = str3;
                        }
                    }
                }
                str2 = aVar.f63493e;
            }
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb2.append(str);
                if (sb2.indexOf("?") < 0) {
                    sb2.append("?");
                } else {
                    sb2.append("&");
                }
            }
            try {
                String encode = URLEncoder.encode(str2, "UTF-8");
                if (TextUtils.isEmpty(encode)) {
                    sb2.append("lt=");
                    sb2.append(str2);
                } else {
                    sb2.append("lt=");
                    sb2.append(encode);
                }
            } catch (Exception e2) {
                c.a(e2);
            }
            return sb2.toString();
        }
        return (String) invokeL.objValue;
    }

    public final void a(long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 <= 0) {
            return;
        }
        c.e("BdLogSDK", "mNetTasks remove ".concat(String.valueOf(j2)));
        this.f63530b.remove(Long.valueOf(j2));
    }

    public final void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            c.a("BdLogSDK", "onUploadFailed", null);
            if (this.f63530b.containsValue(aVar)) {
                com.baidu.webkit.logsdk.a.b.a().a(aVar, System.currentTimeMillis(), true);
            } else {
                c.e("BdLogSDK", "onUploadFailed aTask not exists");
            }
        }
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.e("BdLogSDK", "isNetTaskAllComplete = " + this.f63530b.isEmpty());
            try {
                if (com.baidu.webkit.logsdk.a.f63455a && !this.f63530b.isEmpty()) {
                    Iterator<Map.Entry<Long, a>> it = this.f63530b.entrySet().iterator();
                    while (it.hasNext()) {
                        c.e("BdLogSDK", "inComplete NetTask = " + it.next());
                    }
                }
            } catch (ConcurrentModificationException e2) {
                c.a(e2);
            }
            return this.f63530b.isEmpty();
        }
        return invokeV.booleanValue;
    }
}
