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
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<InterfaceC0276a> f25737a;

    /* renamed from: com.baidu.wallet.paysdk.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.wallet.paysdk.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0276a {
        boolean a(CharSequence charSequence);
    }

    /* loaded from: classes6.dex */
    public static class b implements InterfaceC0276a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25739a;
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
            f25739a = Pattern.compile("^[A-z0-9*]{1,50}$");
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

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0276a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f25739a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements InterfaceC0276a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25740a;
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
            f25740a = Pattern.compile("^[HM]\\d{8,10}$");
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

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0276a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f25740a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements InterfaceC0276a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25741a;
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
            f25741a = Pattern.compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[\\dxX]$|^[1-9]\\d{5}\\d{2}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
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

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0276a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f25741a.matcher(charSequence).matches() : invokeL.booleanValue;
        }

        public /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements InterfaceC0276a {
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

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0276a
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

    /* loaded from: classes6.dex */
    public static class f implements InterfaceC0276a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final Pattern f25742a;
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
            f25742a = Pattern.compile("^[A-Za-z0-9]{1,18}$");
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

        @Override // com.baidu.wallet.paysdk.a.InterfaceC0276a
        public boolean a(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, charSequence)) == null) ? f25742a.matcher(charSequence).matches() : invokeL.booleanValue;
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
            for (InterfaceC0276a interfaceC0276a : this.f25737a) {
                if (interfaceC0276a.a(charSequence)) {
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
        this.f25737a = new ArrayList();
        if (a(j, 2L)) {
            this.f25737a.add(new d(null));
        }
        if (a(j, 4L)) {
            this.f25737a.add(new f(null));
        }
        if (a(j, 8L)) {
            this.f25737a.add(new c(null));
        }
        if (a(j, 16L)) {
            this.f25737a.add(new e(null));
        }
        if (a(j, 1L)) {
            this.f25737a.add(new b(null));
        }
    }
}
