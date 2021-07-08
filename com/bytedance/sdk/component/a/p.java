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
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f27766a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27767b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27768c;

    /* renamed from: d  reason: collision with root package name */
    public final String f27769d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27770e;

    /* renamed from: f  reason: collision with root package name */
    public final String f27771f;

    /* renamed from: g  reason: collision with root package name */
    public final String f27772g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27773h;

    /* renamed from: com.bytedance.sdk.component.a.p$1  reason: invalid class name */
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
        public String f27774a;

        /* renamed from: b  reason: collision with root package name */
        public String f27775b;

        /* renamed from: c  reason: collision with root package name */
        public String f27776c;

        /* renamed from: d  reason: collision with root package name */
        public String f27777d;

        /* renamed from: e  reason: collision with root package name */
        public String f27778e;

        /* renamed from: f  reason: collision with root package name */
        public String f27779f;

        /* renamed from: g  reason: collision with root package name */
        public String f27780g;

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
                this.f27774a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f27775b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f27776c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f27777d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f27778e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f27779f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f27780g = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public p a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new p(this, (AnonymousClass1) null) : (p) invokeV.objValue;
        }
    }

    public /* synthetic */ p(a aVar, AnonymousClass1 anonymousClass1) {
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
            return "methodName: " + this.f27769d + ", params: " + this.f27770e + ", callbackId: " + this.f27771f + ", type: " + this.f27768c + ", version: " + this.f27767b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
        }
        return (String) invokeV.objValue;
    }

    public p(String str, int i2) {
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
        this.f27767b = null;
        this.f27768c = null;
        this.f27769d = null;
        this.f27770e = null;
        this.f27771f = str;
        this.f27772g = null;
        this.f27766a = i2;
        this.f27773h = null;
    }

    public static p a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2)) == null) ? new p(str, i2) : (p) invokeLI.objValue;
    }

    public static boolean a(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, pVar)) == null) ? pVar == null || pVar.f27766a != 1 || TextUtils.isEmpty(pVar.f27769d) || TextUtils.isEmpty(pVar.f27770e) : invokeL.booleanValue;
    }

    public p(a aVar) {
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
        this.f27767b = aVar.f27774a;
        this.f27768c = aVar.f27775b;
        this.f27769d = aVar.f27776c;
        this.f27770e = aVar.f27777d;
        this.f27771f = aVar.f27778e;
        this.f27772g = aVar.f27779f;
        this.f27766a = 1;
        this.f27773h = aVar.f27780g;
    }
}
