package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class wb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context, String str) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, context, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            format = String.format("http://graph.baidu.com/details?image=%s&carousel=0&tn=tieba&promotion_name=shitu", URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            format = String.format("http://graph.baidu.com/details?image=%s&carousel=0&tn=tieba&promotion_name=shitu", str);
        }
        qx4.s(context, format);
    }
}
