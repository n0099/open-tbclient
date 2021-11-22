package com.baidu.wallet.paysdk;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC1850a> f60391a;

    /* renamed from: com.baidu.wallet.paysdk.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.wallet.paysdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC1850a {
        boolean a(CharSequence charSequence);
    }

    /* loaded from: classes10.dex */
    public static class b implements InterfaceC1850a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f60393a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197491473, "Lcom/baidu/wallet/paysdk/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(197491473, "Lcom/baidu/wallet/paysdk/a$b;");
                    return;
                }
            }
            f60393a = Pattern.compile("^[A-z0-9*]{1,50}$");
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC1850a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f60393a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static class c implements InterfaceC1850a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f60394a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197491504, "Lcom/baidu/wallet/paysdk/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(197491504, "Lcom/baidu/wallet/paysdk/a$c;");
                    return;
                }
            }
            f60394a = Pattern.compile("^[HM]\\d{8,10}$");
        }

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC1850a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f60394a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static class d implements InterfaceC1850a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f60395a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197491535, "Lcom/baidu/wallet/paysdk/a$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(197491535, "Lcom/baidu/wallet/paysdk/a$d;");
                    return;
                }
            }
            f60395a = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        }

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC1850a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f60395a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static class e implements InterfaceC1850a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC1850a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

        public /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes10.dex */
    public static class f implements InterfaceC1850a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f60396a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197491597, "Lcom/baidu/wallet/paysdk/a$f;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(197491597, "Lcom/baidu/wallet/paysdk/a$f;");
                    return;
                }
            }
            f60396a = Pattern.compile("^[A-Za-z0-9]{1,18}$");
        }

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.baidu.wallet.paysdk.a.InterfaceC1850a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f60396a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ f(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a() {
        this(14L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean a(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) ? (j & j2) > 0 : invokeCommon.booleanValue;
    }

    public boolean a(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) {
            if (TextUtils.isEmpty(charSequence)) {
                return false;
            }
            for (InterfaceC1850a interfaceC1850a : this.f60391a) {
                if (interfaceC1850a.a(charSequence)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f60391a = new ArrayList();
        if (a(j, 2L)) {
            this.f60391a.add(new d(null));
        }
        if (a(j, 4L)) {
            this.f60391a.add(new f(null));
        }
        if (a(j, 8L)) {
            this.f60391a.add(new c(null));
        }
        if (a(j, 16L)) {
            this.f60391a.add(new e(null));
        }
        if (a(j, 1L)) {
            this.f60391a.add(new b(null));
        }
    }
}
