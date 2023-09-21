package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.yun.YunDialogManager;
import com.baidu.tbadk.core.log.ActivityLog;
import com.baidu.tieba.aaa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class z9a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements aaa.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<Context> a;
        public final String b;
        public final Uri c;

        public a(Context context, Uri uri, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, uri, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(context);
            this.b = str;
            this.c = uri;
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00a9 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.baidu.tieba.aaa.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(HashMap<String, String> hashMap) {
            JSONObject jSONObject;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            Class<?> cls = null;
            try {
                JSONObject jSONObject2 = new JSONObject(this.b);
                str = jSONObject2.optString("page");
                try {
                    String optString = jSONObject2.optString("refre");
                    jSONObject = jSONObject2.optJSONObject(YunDialogManager.PAGE_PARAMS_KEY);
                    if (jSONObject == null) {
                        try {
                            jSONObject = new JSONObject();
                        } catch (Exception e) {
                            e = e;
                            e.printStackTrace();
                            if (jSONObject == null) {
                            }
                        }
                    }
                    jSONObject.put("page", str);
                    jSONObject.put("refre", optString);
                    jSONObject.put("from", 1);
                    for (String str2 : this.c.getQueryParameterNames()) {
                        if (!"params".equals(str2)) {
                            jSONObject.put(str2, this.c.getQueryParameter(str2));
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    jSONObject = null;
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject = null;
                str = null;
            }
            if (jSONObject == null) {
                try {
                    cls = Class.forName(hashMap.get(str));
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                if (cls == null) {
                    return;
                }
                for (Class<?> cls2 : cls.getInterfaces()) {
                    if (cls2.isAssignableFrom(y9a.class)) {
                        try {
                            ((y9a) cls.newInstance()).dispatch(jSONObject, this.a.get());
                            return;
                        } catch (Exception e5) {
                            e5.printStackTrace();
                            return;
                        }
                    }
                }
            }
        }
    }

    public static int a(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, strArr)) == null) {
            if (context != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (TextUtils.isEmpty(str)) {
                    return 3;
                }
                if (!str.startsWith("tiebaapp://router/portal") && !str.startsWith("com.baidu.tieba://unidispatch/router/portal") && ((str = di.getUrlDecode(str)) == null || !str.startsWith("com.baidu.tieba://unidispatch/router/portal"))) {
                    str = null;
                }
                if (!TextUtils.isEmpty(str)) {
                    Uri parse = Uri.parse(str);
                    ActivityLog.getInstance().i("scheme", "SchemaHelper:" + str);
                    try {
                        aaa.c().b(new a(context, parse, parse.getQueryParameter("params")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return 0;
                }
            }
            return 3;
        }
        return invokeLL.intValue;
    }

    public static int b(TbPageContext<?> tbPageContext, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, tbPageContext, strArr)) == null) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                return a(tbPageContext.getPageActivity(), strArr);
            }
            return 3;
        }
        return invokeLL.intValue;
    }
}
