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
/* loaded from: classes9.dex */
public class q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f64142a;

    /* renamed from: b  reason: collision with root package name */
    public final String f64143b;

    /* renamed from: c  reason: collision with root package name */
    public final String f64144c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64145d;

    /* renamed from: e  reason: collision with root package name */
    public final String f64146e;

    /* renamed from: f  reason: collision with root package name */
    public final String f64147f;

    /* renamed from: g  reason: collision with root package name */
    public final String f64148g;

    /* renamed from: h  reason: collision with root package name */
    public final String f64149h;

    /* renamed from: com.bytedance.sdk.component.a.q$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f64150a;

        /* renamed from: b  reason: collision with root package name */
        public String f64151b;

        /* renamed from: c  reason: collision with root package name */
        public String f64152c;

        /* renamed from: d  reason: collision with root package name */
        public String f64153d;

        /* renamed from: e  reason: collision with root package name */
        public String f64154e;

        /* renamed from: f  reason: collision with root package name */
        public String f64155f;

        /* renamed from: g  reason: collision with root package name */
        public String f64156g;

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
                this.f64150a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f64151b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f64152c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f64153d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f64154e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f64155f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f64156g = str;
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
            return "methodName: " + this.f64145d + ", params: " + this.f64146e + ", callbackId: " + this.f64147f + ", type: " + this.f64144c + ", version: " + this.f64143b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
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
        this.f64143b = null;
        this.f64144c = null;
        this.f64145d = null;
        this.f64146e = null;
        this.f64147f = str;
        this.f64148g = null;
        this.f64142a = i2;
        this.f64149h = null;
    }

    public static q a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) ? new q(str, i2) : (q) invokeLI.objValue;
    }

    public static boolean a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, qVar)) == null) ? qVar == null || qVar.f64142a != 1 || TextUtils.isEmpty(qVar.f64145d) || TextUtils.isEmpty(qVar.f64146e) : invokeL.booleanValue;
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
        this.f64143b = aVar.f64150a;
        this.f64144c = aVar.f64151b;
        this.f64145d = aVar.f64152c;
        this.f64146e = aVar.f64153d;
        this.f64147f = aVar.f64154e;
        this.f64148g = aVar.f64155f;
        this.f64142a = 1;
        this.f64149h = aVar.f64156g;
    }
}
