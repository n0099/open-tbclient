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
    public final int f63962a;

    /* renamed from: b  reason: collision with root package name */
    public final String f63963b;

    /* renamed from: c  reason: collision with root package name */
    public final String f63964c;

    /* renamed from: d  reason: collision with root package name */
    public final String f63965d;

    /* renamed from: e  reason: collision with root package name */
    public final String f63966e;

    /* renamed from: f  reason: collision with root package name */
    public final String f63967f;

    /* renamed from: g  reason: collision with root package name */
    public final String f63968g;

    /* renamed from: h  reason: collision with root package name */
    public final String f63969h;

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
        public String f63970a;

        /* renamed from: b  reason: collision with root package name */
        public String f63971b;

        /* renamed from: c  reason: collision with root package name */
        public String f63972c;

        /* renamed from: d  reason: collision with root package name */
        public String f63973d;

        /* renamed from: e  reason: collision with root package name */
        public String f63974e;

        /* renamed from: f  reason: collision with root package name */
        public String f63975f;

        /* renamed from: g  reason: collision with root package name */
        public String f63976g;

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
                this.f63970a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f63971b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f63972c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f63973d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f63974e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f63975f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f63976g = str;
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
            return "methodName: " + this.f63965d + ", params: " + this.f63966e + ", callbackId: " + this.f63967f + ", type: " + this.f63964c + ", version: " + this.f63963b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
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
        this.f63963b = null;
        this.f63964c = null;
        this.f63965d = null;
        this.f63966e = null;
        this.f63967f = str;
        this.f63968g = null;
        this.f63962a = i2;
        this.f63969h = null;
    }

    public static q a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) ? new q(str, i2) : (q) invokeLI.objValue;
    }

    public static boolean a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, qVar)) == null) ? qVar == null || qVar.f63962a != 1 || TextUtils.isEmpty(qVar.f63965d) || TextUtils.isEmpty(qVar.f63966e) : invokeL.booleanValue;
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
        this.f63963b = aVar.f63970a;
        this.f63964c = aVar.f63971b;
        this.f63965d = aVar.f63972c;
        this.f63966e = aVar.f63973d;
        this.f63967f = aVar.f63974e;
        this.f63968g = aVar.f63975f;
        this.f63962a = 1;
        this.f63969h = aVar.f63976g;
    }
}
