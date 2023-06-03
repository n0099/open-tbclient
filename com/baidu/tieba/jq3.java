package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tieba.lo3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jq3 extends lo3.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947891901, "Lcom/baidu/tieba/jq3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947891901, "Lcom/baidu/tieba/jq3;");
                return;
            }
        }
        c = is1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq3(boolean z) {
        super(z);
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            str = "swan_js_native_v8_ab.txt";
        } else {
            str = "swan_js_native_webview_ab.txt";
        }
        this.b = uu2.g().getPath() + File.separator + "js_native" + File.separator + str;
    }

    public boolean a(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            String str = uu2.g().getPath() + File.separator + "js_native" + File.separator;
            if ((i & 1) != 0) {
                z = cs4.M(str + "swan_js_native_v8_ab.txt");
            } else {
                z = true;
            }
            if ((i & 2) != 0) {
                return z & cs4.M(str + "swan_js_native_webview_ab.txt");
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    @Nullable
    public final List<String> b(boolean z, String str) {
        InterceptResult invokeZL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, str)) == null) {
            if (z) {
                str2 = SchemeCollecter.CLASSIFY_SWAN_V8;
            } else {
                str2 = SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
            }
            if (z) {
                str3 = "swan/v8_ab";
            } else {
                str3 = "swan/webview_ab";
            }
            List<JSONObject> b = hq3.b(str2, str3);
            if (b != null) {
                File file = new File(str);
                ArrayList arrayList = new ArrayList();
                for (JSONObject jSONObject : b) {
                    if (jSONObject != null) {
                        arrayList.add(jSONObject.toString());
                    }
                }
                if (file.exists()) {
                    cs4.L(file);
                }
                cs4.h(file);
                cs4.P(arrayList, file);
                return arrayList;
            }
            return null;
        }
        return (List) invokeZL.objValue;
    }

    public boolean c(@NonNull JSONArray jSONArray) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            if (jSONArray.length() > 0 && cs4.v(this.b)) {
                if (this.a) {
                    str = SchemeCollecter.CLASSIFY_SWAN_V8;
                } else {
                    str = SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
                }
                return iq3.a(jSONArray, new File(this.b), SchemeCollecter.getSchemesDesListSize(str));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (c) {
                Log.i("SwanAppCompat", "FileDescriptionsManager obtain desc...");
            }
            if (!fo4.b() && !TextUtils.equals(fo4.a(), "0")) {
                File file = new File(this.b);
                if (file.exists()) {
                    cs4.L(file);
                }
            }
            if (cs4.v(this.b)) {
                if (c) {
                    Log.d("SwanAppCompat", "start create cache");
                }
                return cs4.F(new File(this.b));
            }
            return b(this.a, this.b);
        }
        return (List) invokeV.objValue;
    }
}
