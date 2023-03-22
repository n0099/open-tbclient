package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class l90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947897574, "Lcom/baidu/tieba/l90;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947897574, "Lcom/baidu/tieba/l90;");
        }
    }

    @JvmStatic
    public static final String a(LiveRoomEntity liveRoomEntity) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, liveRoomEntity)) == null) {
            String str2 = "";
            String str3 = (liveRoomEntity == null || (str3 = liveRoomEntity.cmd) == null) ? "" : "";
            String str4 = null;
            if (liveRoomEntity != null) {
                str = liveRoomEntity.beginTime;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                String b = new p90(str3).b("params");
                boolean z2 = false;
                if (b != null && b.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    try {
                        JSONObject jSONObject = new JSONObject(URLDecoder.decode(b, "UTF-8"));
                        JSONObject optJSONObject = jSONObject.optJSONObject("extLog");
                        if (optJSONObject == null) {
                            optJSONObject = new JSONObject();
                        }
                        if (liveRoomEntity != null) {
                            str4 = liveRoomEntity.beginTime;
                        }
                        optJSONObject.put("live_union_id", str4);
                        optJSONObject.put("auto_play", "1");
                        jSONObject.put("extLog", optJSONObject);
                        String removedUrl = i90.j(str3, "params");
                        Intrinsics.checkExpressionValueIsNotNull(removedUrl, "removedUrl");
                        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null);
                        if (removedUrl != null) {
                            String substring = removedUrl.substring(0, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            if (StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null) + 1 < removedUrl.length()) {
                                str2 = removedUrl.substring(StringsKt__StringsKt.indexOf$default((CharSequence) removedUrl, "?", 0, false, 6, (Object) null) + 1, removedUrl.length());
                                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            }
                            String encode = URLEncoder.encode(jSONObject.toString());
                            StringBuilder sb = new StringBuilder();
                            sb.append(substring);
                            sb.append("?params=" + encode);
                            if (str2.length() > 0) {
                                z2 = true;
                            }
                            if (z2) {
                                sb.append(str2);
                            }
                            String sb2 = sb.toString();
                            Intrinsics.checkExpressionValueIsNotNull(sb2, "newScheme.toString()");
                            return sb2;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return str3;
                    }
                }
                return str3;
            }
            return str3;
        }
        return (String) invokeL.objValue;
    }
}
