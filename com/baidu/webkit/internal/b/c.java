package com.baidu.webkit.internal.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public final class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008f  */
    @Override // com.baidu.webkit.internal.b.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, str)) == null) {
            if (str == null) {
                return false;
            }
            if (str.startsWith("wtai://")) {
                if (str.length() > 13) {
                    String substring = str.substring(13);
                    if (context != null) {
                        g.a(context, new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(substring)))));
                    }
                    return true;
                }
            } else if (str.startsWith("tel:")) {
                try {
                    context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(str)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return true;
            } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_SMS)) {
                String str4 = null;
                try {
                    indexOf = str.indexOf("?");
                } catch (Exception e3) {
                    e = e3;
                    str2 = null;
                }
                if (indexOf == -1) {
                    str3 = str.substring(4);
                    if (context != null) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlSchemaHelper.SCHEMA_TYPE_SMS.concat(String.valueOf(str3))));
                        intent.putExtra("sms_body", str4);
                        g.a(context, intent);
                    }
                    return true;
                }
                str2 = str.substring(4, indexOf);
                try {
                    String query = Uri.parse(str).getQuery();
                    if (query != null && query.startsWith("body=")) {
                        str4 = query.substring(5);
                    }
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    str3 = str2;
                    if (context != null) {
                    }
                    return true;
                }
                str3 = str2;
                if (context != null) {
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
