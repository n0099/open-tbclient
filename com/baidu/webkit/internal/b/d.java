package com.baidu.webkit.internal.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.CommonUtils;
import java.net.URISyntaxException;
import java.net.URLDecoder;
/* loaded from: classes6.dex */
public final class d extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d() {
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
        if (r4.versionCode < r6) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Intent intent;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(65537, null, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        String queryParameter = CommonUtils.getQueryParameter(str, "weburl");
        if (!TextUtils.isEmpty(queryParameter)) {
            queryParameter = URLDecoder.decode(queryParameter);
        }
        String queryParameter2 = CommonUtils.getQueryParameter(str, "nativeurl");
        if (!TextUtils.isEmpty(queryParameter2)) {
            queryParameter2 = URLDecoder.decode(queryParameter2);
        }
        boolean z = true;
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(queryParameter2)) {
            intent = null;
        } else {
            try {
                intent = Intent.parseUri(queryParameter2, 1);
            } catch (URISyntaxException e) {
                e = e;
                intent = null;
            }
            try {
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setComponent(null);
                intent.setSelector(null);
            } catch (URISyntaxException e2) {
                e = e2;
                e.printStackTrace();
                if (intent != null) {
                }
                z = false;
                if (!z) {
                }
            }
        }
        if (intent != null) {
            String str2 = intent.getPackage();
            if (context.getPackageManager().resolveActivity(intent, 0) != null) {
                int intExtra = intent.getIntExtra("minversion", -1);
                if (str2 != null && intExtra > 0) {
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                    } catch (PackageManager.NameNotFoundException e3) {
                        e3.printStackTrace();
                    }
                    if (packageInfo != null) {
                    }
                }
                if (!z) {
                    return (queryParameter == null || queryParameter.length() == 0) ? str : queryParameter;
                }
                context.startActivity(intent);
                return "";
            }
        }
        z = false;
        if (!z) {
        }
    }

    @Override // com.baidu.webkit.internal.b.g
    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str != null && !TextUtils.isEmpty(str) && str.startsWith("bds://") && "openurl".equals(Uri.parse(str).getHost())) {
                String b = b(context, str);
                if (TextUtils.isEmpty(b)) {
                    return true;
                }
                return new e().a(context, b);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
