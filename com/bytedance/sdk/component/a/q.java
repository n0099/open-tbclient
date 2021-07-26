package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f27925a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27926b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27927c;

    /* renamed from: d  reason: collision with root package name */
    public final String f27928d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27929e;

    /* renamed from: f  reason: collision with root package name */
    public final String f27930f;

    /* renamed from: g  reason: collision with root package name */
    public final String f27931g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27932h;

    /* renamed from: com.bytedance.sdk.component.a.q$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27933a;

        /* renamed from: b  reason: collision with root package name */
        public String f27934b;

        /* renamed from: c  reason: collision with root package name */
        public String f27935c;

        /* renamed from: d  reason: collision with root package name */
        public String f27936d;

        /* renamed from: e  reason: collision with root package name */
        public String f27937e;

        /* renamed from: f  reason: collision with root package name */
        public String f27938f;

        /* renamed from: g  reason: collision with root package name */
        public String f27939g;

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        public a() {
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

        public a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                this.f27933a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f27934b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f27935c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f27936d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f27937e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f27938f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f27939g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public q a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new q(this, (AnonymousClass1) null) : (q) invokeV.objValue;
        }
    }

    public /* synthetic */ q(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new a(null) : (a) invokeV.objValue;
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "methodName: " + this.f27928d + ", params: " + this.f27929e + ", callbackId: " + this.f27930f + ", type: " + this.f27927c + ", version: " + this.f27926b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
        }
        return (String) invokeV.objValue;
    }

    public q(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f27926b = null;
        this.f27927c = null;
        this.f27928d = null;
        this.f27929e = null;
        this.f27930f = str;
        this.f27931g = null;
        this.f27925a = i2;
        this.f27932h = null;
    }

    public static q a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) ? new q(str, i2) : (q) invokeLI.objValue;
    }

    public static boolean a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, qVar)) == null) ? qVar == null || qVar.f27925a != 1 || TextUtils.isEmpty(qVar.f27928d) || TextUtils.isEmpty(qVar.f27929e) : invokeL.booleanValue;
    }

    public q(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f27926b = aVar.f27933a;
        this.f27927c = aVar.f27934b;
        this.f27928d = aVar.f27935c;
        this.f27929e = aVar.f27936d;
        this.f27930f = aVar.f27937e;
        this.f27931g = aVar.f27938f;
        this.f27925a = 1;
        this.f27932h = aVar.f27939g;
    }
}
