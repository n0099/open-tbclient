package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.multipage.i;
/* loaded from: classes10.dex */
public class f implements i.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f59244a;

    /* renamed from: com.baidu.wallet.lightapp.multipage.f$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static f f59245a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(549782299, "Lcom/baidu/wallet/lightapp/multipage/f$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(549782299, "Lcom/baidu/wallet/lightapp/multipage/f$a;");
                    return;
                }
            }
            f59245a = new f(null);
        }
    }

    public /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f59245a : (f) invokeV.objValue;
    }

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
                return;
            }
        }
        this.f59244a = true;
    }

    @Override // com.baidu.wallet.lightapp.multipage.i.b
    public LangbridgeSettings a(Context context, LangbridgeSettings langbridgeSettings) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, langbridgeSettings)) == null) {
            if (this.f59244a) {
                return langbridgeSettings;
            }
            LangbridgeSettings m46clone = langbridgeSettings.m46clone();
            m46clone.MW_ON = false;
            m46clone.MW_USE_OLD = true;
            LogUtil.d("LangbridgeSettings", "");
            return m46clone;
        }
        return (LangbridgeSettings) invokeLL.objValue;
    }
}
