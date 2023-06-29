package com.baidu.tieba.immessagecenter.msgtab.obs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im8;
import com.baidu.tieba.sxb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/obs/AccountChangedMonitor;", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "()V", "mDataChangedListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mSubject", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getMSubject", "()Lrx/subjects/BehaviorSubject;", "mSubject$delegate", "Lkotlin/Lazy;", "accountChangedObs", "Lrx/Observable;", "start", "", "stop", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AccountChangedMonitor implements im8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static final Lazy<AccountChangedMonitor> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final CustomMessageListener b;

    public /* synthetic */ AccountChangedMonitor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public final AccountChangedMonitor a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (AccountChangedMonitor) invokeV.objValue;
        }

        public final AccountChangedMonitor b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (AccountChangedMonitor) AccountChangedMonitor.d.getValue();
            }
            return (AccountChangedMonitor) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AccountChangedMonitor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AccountChangedMonitor accountChangedMonitor) {
            super(2005016);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountChangedMonitor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = accountChangedMonitor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                Integer valueOf = Integer.valueOf(customResponsedMessage.getCmd());
                if (valueOf.intValue() == 2005016) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    AccountChangedMonitor accountChangedMonitor = this.a;
                    valueOf.intValue();
                    accountChangedMonitor.c().onNext(Long.valueOf(TbadkCoreApplication.getCurrentAccountId()));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(641603501, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/AccountChangedMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(641603501, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/AccountChangedMonitor;");
                return;
            }
        }
        c = new a(null);
        d = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) AccountChangedMonitor$Companion$instance$2.INSTANCE);
    }

    public AccountChangedMonitor() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(AccountChangedMonitor$mSubject$2.INSTANCE);
        this.b = new b(this);
    }

    public final sxb<Long> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (sxb) this.a.getValue();
        }
        return (sxb) invokeV.objValue;
    }

    @Override // com.baidu.tieba.im8
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().registerListener(this.b);
        }
    }
}
