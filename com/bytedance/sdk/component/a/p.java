package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f27656a;

    /* renamed from: b  reason: collision with root package name */
    public final String f27657b;

    /* renamed from: c  reason: collision with root package name */
    public final String f27658c;

    /* renamed from: d  reason: collision with root package name */
    public final String f27659d;

    /* renamed from: e  reason: collision with root package name */
    public final String f27660e;

    /* renamed from: f  reason: collision with root package name */
    public final String f27661f;

    /* renamed from: g  reason: collision with root package name */
    public final String f27662g;

    /* renamed from: h  reason: collision with root package name */
    public final String f27663h;

    /* renamed from: com.bytedance.sdk.component.a.p$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f27664a;

        /* renamed from: b  reason: collision with root package name */
        public String f27665b;

        /* renamed from: c  reason: collision with root package name */
        public String f27666c;

        /* renamed from: d  reason: collision with root package name */
        public String f27667d;

        /* renamed from: e  reason: collision with root package name */
        public String f27668e;

        /* renamed from: f  reason: collision with root package name */
        public String f27669f;

        /* renamed from: g  reason: collision with root package name */
        public String f27670g;

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
                this.f27664a = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.f27665b = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.f27666c = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.f27667d = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a e(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.f27668e = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a f(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.f27669f = str;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a g(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
                this.f27670g = str;
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
            return "methodName: " + this.f27659d + ", params: " + this.f27660e + ", callbackId: " + this.f27661f + ", type: " + this.f27658c + ", version: " + this.f27657b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
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
        this.f27657b = null;
        this.f27658c = null;
        this.f27659d = null;
        this.f27660e = null;
        this.f27661f = str;
        this.f27662g = null;
        this.f27656a = i2;
        this.f27663h = null;
    }

    public static p a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65540, null, str, i2)) == null) ? new p(str, i2) : (p) invokeLI.objValue;
    }

    public static boolean a(p pVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, pVar)) == null) ? pVar == null || pVar.f27656a != 1 || TextUtils.isEmpty(pVar.f27659d) || TextUtils.isEmpty(pVar.f27660e) : invokeL.booleanValue;
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
        this.f27657b = aVar.f27664a;
        this.f27658c = aVar.f27665b;
        this.f27659d = aVar.f27666c;
        this.f27660e = aVar.f27667d;
        this.f27661f = aVar.f27668e;
        this.f27662g = aVar.f27669f;
        this.f27656a = 1;
        this.f27663h = aVar.f27670g;
    }
}
