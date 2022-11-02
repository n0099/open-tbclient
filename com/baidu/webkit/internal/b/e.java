package com.baidu.webkit.internal.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.Log;
import java.net.URISyntaxException;
@SuppressLint({"NewApi"})
/* loaded from: classes6.dex */
public final class e extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // com.baidu.webkit.internal.b.g
    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str != null && !str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://")) {
                try {
                    Intent parseUri = Intent.parseUri(str, 1);
                    if (context.getPackageManager().resolveActivity(parseUri, 0) == null) {
                        String str2 = parseUri.getPackage();
                        if (str2 != null) {
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:".concat(String.valueOf(str2))));
                            intent.addCategory("android.intent.category.BROWSABLE");
                            return g.a(context, intent);
                        }
                        return true;
                    }
                    parseUri.addCategory("android.intent.category.BROWSABLE");
                    parseUri.setComponent(null);
                    parseUri.setSelector(null);
                    try {
                        if (context instanceof Activity) {
                            if (((Activity) context).startActivityIfNeeded(parseUri, -1)) {
                                return true;
                            }
                        }
                    } catch (ActivityNotFoundException | Exception e) {
                        Log.printStackTrace(e);
                    }
                    return true;
                } catch (URISyntaxException e2) {
                    String str3 = Log.LOG_TAG;
                    Log.d(str3, "Bad URI " + str + ": " + e2.getMessage());
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
