package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.lollipop.json.JSONArray;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.multipage.i;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes8.dex */
public class e implements i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f61818a;

    /* renamed from: b  reason: collision with root package name */
    public Long f61819b;

    /* renamed from: com.baidu.wallet.lightapp.multipage.e$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static e f61820a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549752508, "Lcom/baidu/wallet/lightapp/multipage/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(549752508, "Lcom/baidu/wallet/lightapp/multipage/e$a;");
                    return;
                }
            }
            f61820a = new e(null);
        }
    }

    public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.f61820a : (e) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray b(Context context) {
        InterceptResult invokeL;
        JSONArray jSONArray;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            String str = (String) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONArray = new JSONArray(str);
                } catch (Exception unused) {
                }
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                for (i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (jSONArray.optLong(i2) + (i.a().a(context).MW_BHM_RECORD_TIME * 1000) < valueOf.longValue()) {
                        jSONArray.remove(i2);
                    }
                }
                return jSONArray;
            }
            jSONArray = null;
            if (jSONArray == null) {
            }
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            while (i2 < jSONArray.length()) {
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    private void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            JSONArray jSONArray = new JSONArray();
            this.f61818a = jSONArray;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", jSONArray.toString());
        }
    }

    private int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, context)) == null) {
            JSONArray a2 = a(context);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            int i2 = 0;
            for (int i3 = 0; i3 < a2.length(); i3++) {
                i2 += a2.optLong(i3) + ((long) (i.a().a(context).MW_BHM_RECORD_TIME * 1000)) >= valueOf.longValue() ? 1 : 0;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, context) == null) {
            LogUtil.d("LangbridgeBehaviourMonitor", "coldDown");
            DXMSdkSAUtils.onEvent("#MW_BHM_ColdDown");
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            this.f61819b = valueOf;
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_cold_point", valueOf);
            i.a().c(context);
        }
    }

    public e() {
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
        this.f61819b = -1L;
    }

    public void a(@NonNull Context context, int i2, @NonNull String str, List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i2, str, list) == null) {
            LangbridgeSettings a2 = i.a().a(context);
            if (!a2.MW_BHM_ON || b(context, a2.MW_BHM_COLD_TIME)) {
                return;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(str, "" + i2));
            arrayList.addAll(list);
            LogUtil.i("LangbridgeBehaviourMonitor", "behaviourRecord" + str + GlideException.IndentedAppendable.INDENT + i2 + " " + arrayList.toString());
            DXMSdkSAUtils.onEventWithValues("#MW_BHM_BadBehaviour", arrayList);
            if (i2 < 1) {
                return;
            }
            int i3 = a2.MW_BHM_LIMIT;
            if (i2 > i3) {
                i2 = i3;
            }
            a(context, i2);
            if (d(context) >= i3) {
                e(context);
                c(context);
            }
        }
    }

    private boolean b(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(AdIconUtil.BAIDU_LOGO_ID, this, context, i2)) == null) {
            if (this.f61819b.longValue() == -1) {
                this.f61819b = (Long) SharedPreferencesUtils.getParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_cold_point", 0L);
            }
            return System.currentTimeMillis() < this.f61819b.longValue() + ((long) (i2 * 1000));
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.wallet.lightapp.multipage.i.b
    public LangbridgeSettings a(Context context, LangbridgeSettings langbridgeSettings) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, langbridgeSettings)) == null) {
            if (langbridgeSettings.MW_BHM_ON && b(context, langbridgeSettings.MW_BHM_COLD_TIME)) {
                LangbridgeSettings m46clone = langbridgeSettings.m46clone();
                m46clone.MW_ON = false;
                m46clone.MW_USE_OLD = true;
                LogUtil.d("LangbridgeSettings", "");
                return m46clone;
            }
            return langbridgeSettings;
        }
        return (LangbridgeSettings) invokeLL.objValue;
    }

    private JSONArray a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, context)) == null) {
            if (this.f61818a == null) {
                this.f61818a = b(context);
            }
            return this.f61818a;
        }
        return (JSONArray) invokeL.objValue;
    }

    private void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, context, i2) == null) {
            JSONArray a2 = a(context);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            for (int i3 = 0; i3 < i2; i3++) {
                a2.put(valueOf);
            }
            SharedPreferencesUtils.setParam(context, BeanConstants.PREFERENCES_NAME, "langbridge_behaviour_book", a2.toString());
        }
    }
}
