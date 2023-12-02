package com.baidu.tieba.immessagecenter.msgtab.obs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.btc;
import com.baidu.tieba.doc;
import com.baidu.tieba.noc;
import com.baidu.tieba.q79;
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
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0005\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/obs/MainTabChangedMonitor;", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "()V", "mDataChangedListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mSubject", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getMSubject", "()Lrx/subjects/BehaviorSubject;", "mSubject$delegate", "Lkotlin/Lazy;", "mainTabChangedData", "mainTabChangedObs", "Lrx/Observable;", "start", "", "stop", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MainTabChangedMonitor implements q79 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static final Lazy<MainTabChangedMonitor> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final CustomMessageListener b;

    public /* synthetic */ MainTabChangedMonitor(DefaultConstructorMarker defaultConstructorMarker) {
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

        public final MainTabChangedMonitor a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (MainTabChangedMonitor) invokeV.objValue;
        }

        public final MainTabChangedMonitor b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (MainTabChangedMonitor) MainTabChangedMonitor.d.getValue();
            }
            return (MainTabChangedMonitor) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MainTabChangedMonitor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MainTabChangedMonitor mainTabChangedMonitor) {
            super(2001384);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mainTabChangedMonitor};
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
            this.a = mainTabChangedMonitor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Integer num;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                Object data = responsedMessage.getData();
                if (data instanceof Integer) {
                    num = (Integer) data;
                } else {
                    num = null;
                }
                if (num != null) {
                    i = num.intValue();
                } else {
                    i = -1;
                }
                this.a.c().onNext(Integer.valueOf(i));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1346270498, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/MainTabChangedMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1346270498, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/MainTabChangedMonitor;");
                return;
            }
        }
        c = new a(null);
        d = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) MainTabChangedMonitor$Companion$instance$2.INSTANCE);
    }

    public MainTabChangedMonitor() {
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
        this.a = LazyKt__LazyJVMKt.lazy(MainTabChangedMonitor$mSubject$2.INSTANCE);
        this.b = new b(this);
    }

    public final btc<Integer> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (btc) this.a.getValue();
        }
        return (btc) invokeV.objValue;
    }

    public final doc<Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            doc<Integer> s = c().a().w().s(noc.b());
            Intrinsics.checkNotNullExpressionValue(s, "mSubject.asObservable()\n…dSchedulers.mainThread())");
            return s;
        }
        return (doc) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q79
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().registerListener(this.b);
        }
    }
}
