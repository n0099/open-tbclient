package com.baidu.wallet.core.domain;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class DomainConfig implements com.baidu.wallet.core.domain.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.wallet.core.domain.a f60766i;

    /* renamed from: j  reason: collision with root package name */
    public com.baidu.wallet.core.domain.a f60767j;
    public com.baidu.wallet.core.domain.a k;

    /* renamed from: com.baidu.wallet.core.domain.DomainConfig$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f60768a;
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
            f60768a = iArr;
            try {
                iArr[DomainStrategyType.QA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f60768a[DomainStrategyType.ONLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final DomainConfig f60769a;
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
            f60769a = new DomainConfig(null);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f60769a : (DomainConfig) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60766i.getAppHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getAppPayHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60766i.getAppPayHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCOHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f60766i.getCOHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCometHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60766i.getCometHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getCreditCardHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60766i.getCreditCardHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getInitHost(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) ? this.f60766i.getInitHost(z) : (String) invokeZ.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getLifeHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f60766i.getLifeHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60766i.getMHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getMyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60766i.getMyHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getNfcHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f60766i.getNfcHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getQianbaoHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f60766i.getQianbaoHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getWebCacheHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f60766i.getWebCacheHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public String getZhiFuHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f60766i.getZhiFuHost() : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.domain.a
    public void setDomainConfig(String str) {
        com.baidu.wallet.core.domain.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (aVar = this.f60766i) == null) {
            return;
        }
        aVar.setDomainConfig(str);
    }

    public void setStrategy(DomainStrategyType domainStrategyType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, domainStrategyType) == null) {
            int i2 = AnonymousClass1.f60768a[domainStrategyType.ordinal()];
            if (i2 == 1) {
                this.f60766i = this.k;
            } else if (i2 != 2) {
            } else {
                this.f60766i = this.f60767j;
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
        this.f60767j = new b();
        this.k = c.a();
        this.f60766i = this.f60767j;
    }

    public void setStrategy(DomainStrategyType domainStrategyType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, domainStrategyType, str) == null) {
            int i2 = AnonymousClass1.f60768a[domainStrategyType.ordinal()];
            if (i2 == 1) {
                this.f60766i = this.k;
            } else if (i2 == 2) {
                this.f60766i = this.f60767j;
            }
            this.f60766i.setDomainConfig(str);
        }
    }
}
