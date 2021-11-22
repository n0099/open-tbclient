package com.baidu.wallet.core.domain;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class DomainConfig implements com.baidu.wallet.core.domain.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.wallet.core.domain.a m;
    public com.baidu.wallet.core.domain.a n;
    public com.baidu.wallet.core.domain.a o;

    /* renamed from: com.baidu.wallet.core.domain.DomainConfig$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f58912a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(295064037, "Lcom/baidu/wallet/core/domain/DomainConfig$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(295064037, "Lcom/baidu/wallet/core/domain/DomainConfig$1;");
                    return;
                }
            }
            int[] iArr = new int[DomainStrategyType.values().length];
            f58912a = iArr;
            try {
                iArr[DomainStrategyType.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58912a[DomainStrategyType.ONLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class DomainStrategyType {
        public static final /* synthetic */ DomainStrategyType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DomainStrategyType ONLINE;
        public static final DomainStrategyType QA;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1809004463, "Lcom/baidu/wallet/core/domain/DomainConfig$DomainStrategyType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1809004463, "Lcom/baidu/wallet/core/domain/DomainConfig$DomainStrategyType;");
                    return;
                }
            }
            ONLINE = new DomainStrategyType("ONLINE", 0);
            DomainStrategyType domainStrategyType = new DomainStrategyType("QA", 1);
            QA = domainStrategyType;
            $VALUES = new DomainStrategyType[]{ONLINE, domainStrategyType};
        }

        public DomainStrategyType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static DomainStrategyType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DomainStrategyType) Enum.valueOf(DomainStrategyType.class, str) : (DomainStrategyType) invokeL.objValue;
        }

        public static DomainStrategyType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DomainStrategyType[]) $VALUES.clone() : (DomainStrategyType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final DomainConfig f58913a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(295065525, "Lcom/baidu/wallet/core/domain/DomainConfig$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(295065525, "Lcom/baidu/wallet/core/domain/DomainConfig$a;");
                    return;
                }
            }
            f58913a = new DomainConfig(null);
        }

        public a() {
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
    }

    public /* synthetic */ DomainConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static DomainConfig getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f58913a : (DomainConfig) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, boolArr)) == null) ? this.m.getAppHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, boolArr)) == null) ? this.m.getAppPayHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, boolArr)) == null) ? this.m.getCOHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, boolArr)) == null) ? this.m.getCometHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, boolArr)) == null) ? this.m.getCreditCardHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getHawkinghost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, boolArr)) == null) ? this.m.getHawkinghost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(int i2, @NonNull Boolean[] boolArr) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, boolArr)) == null) ? this.m.getInitHost(i2, boolArr) : (String) invokeIL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, boolArr)) == null) ? this.m.getLifeHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, boolArr)) == null) ? this.m.getMHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, boolArr)) == null) ? this.m.getMyHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNetcheckhost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, boolArr)) == null) ? this.m.getNetcheckhost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, boolArr)) == null) ? this.m.getNfcHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, boolArr)) == null) ? this.m.getQianbaoHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getSensorhost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, boolArr)) == null) ? this.m.getSensorhost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, boolArr)) == null) ? this.m.getWebCacheHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost(@NonNull Boolean[] boolArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, boolArr)) == null) ? this.m.getZhiFuHost(boolArr) : (String) invokeL.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        com.baidu.wallet.core.domain.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, str) == null) || (aVar = this.m) == null) {
            return;
        }
        aVar.setDomainConfig(str);
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, domainStrategyType) == null) {
            int i2 = AnonymousClass1.f58912a[domainStrategyType.ordinal()];
            if (i2 == 1) {
                this.m = this.o;
            } else if (i2 != 2) {
            } else {
                this.m = this.n;
            }
        }
    }

    public DomainConfig() {
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
        this.n = new b();
        this.o = c.a();
        this.m = this.n;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, domainStrategyType, str) == null) {
            int i2 = AnonymousClass1.f58912a[domainStrategyType.ordinal()];
            if (i2 == 1) {
                this.m = this.o;
            } else if (i2 == 2) {
                this.m = this.n;
            }
            this.m.setDomainConfig(str);
        }
    }
}
