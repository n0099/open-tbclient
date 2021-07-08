package com.baidu.webkit.internal.b;

import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
/* loaded from: classes5.dex */
public final class f extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f() {
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

    @Override // com.baidu.webkit.internal.b.g
    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str == null) {
                return false;
            }
            if (!str.startsWith(WebView.SCHEME_MAILTO)) {
                if (str.startsWith("rtsp:")) {
                    try {
                        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return true;
                } else if (str.startsWith("ftp://")) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent.addCategory("android.intent.category.BROWSABLE");
                    return g.a(context, intent);
                } else {
                    return false;
                }
            }
            MailTo parse = MailTo.parse(str);
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.EMAIL", new String[]{parse.getTo()});
            intent2.putExtra("android.intent.extra.SUBJECT", parse.getSubject());
            intent2.putExtra("android.intent.extra.CC", parse.getCc());
            intent2.putExtra("android.intent.extra.TEXT", parse.getBody());
            try {
                context.startActivity(intent2);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            return true;
        }
        return invokeLL.booleanValue;
    }
}
