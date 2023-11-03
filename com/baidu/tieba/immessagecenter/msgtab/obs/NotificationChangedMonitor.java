package com.baidu.tieba.immessagecenter.msgtab.obs;

import androidx.core.app.NotificationManagerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.c49;
import com.baidu.tieba.ckc;
import com.baidu.tieba.goc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor;
import com.baidu.tieba.sjc;
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
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00110\u0010J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016R?\u0010\u0003\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR?\u0010\u000b\u001a&\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0012\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/obs/NotificationChangedMonitor;", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "()V", "mFrequencyControlSubject", "Lrx/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getMFrequencyControlSubject", "()Lrx/subjects/BehaviorSubject;", "mFrequencyControlSubject$delegate", "Lkotlin/Lazy;", "mSubject", "getMSubject", "mSubject$delegate", "isAllowShowGuide", "notificationChangedObs", "Lrx/Observable;", "Lkotlin/Pair;", "refreshStatus", "", "start", "stop", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NotificationChangedMonitor implements c49 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static final Lazy<NotificationChangedMonitor> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    public /* synthetic */ NotificationChangedMonitor(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.baidu.tieba.c49
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
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

        public final NotificationChangedMonitor a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (NotificationChangedMonitor) invokeV.objValue;
        }

        public final NotificationChangedMonitor b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (NotificationChangedMonitor) NotificationChangedMonitor.d.getValue();
            }
            return (NotificationChangedMonitor) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-322972923, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/NotificationChangedMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-322972923, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/NotificationChangedMonitor;");
                return;
            }
        }
        c = new a(null);
        d = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) NotificationChangedMonitor$Companion$instance$2.INSTANCE);
    }

    public final goc<Boolean> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (goc) this.b.getValue();
        }
        return (goc) invokeV.objValue;
    }

    public final goc<Boolean> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (goc) this.a.getValue();
        }
        return (goc) invokeV.objValue;
    }

    public final boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = SharedPrefHelper.getInstance().getLong("key_im_open_notification_close_time", 0L);
            if (j != 0 && System.currentTimeMillis() - j <= 604800000) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public NotificationChangedMonitor() {
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
        this.a = LazyKt__LazyJVMKt.lazy(NotificationChangedMonitor$mSubject$2.INSTANCE);
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<goc<Boolean>>(this) { // from class: com.baidu.tieba.immessagecenter.msgtab.obs.NotificationChangedMonitor$mFrequencyControlSubject$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ NotificationChangedMonitor this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final goc<Boolean> invoke() {
                InterceptResult invokeV;
                boolean e;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (goc) invokeV.objValue;
                }
                e = this.this$0.e();
                return goc.R(Boolean.valueOf(e));
            }
        });
    }

    public final ijc<Pair<Boolean, Boolean>> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ijc<Pair<Boolean, Boolean>> s = ijc.c(d().g(), c().g(), new ckc() { // from class: com.baidu.tieba.y39
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ckc
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? NotificationChangedMonitor.g((Boolean) obj, (Boolean) obj2) : invokeLL.objValue;
                }
            }).h(new ckc() { // from class: com.baidu.tieba.a49
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ckc
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? NotificationChangedMonitor.h((Pair) obj, (Pair) obj2) : invokeLL.objValue;
                }
            }).s(sjc.b());
            Intrinsics.checkNotNullExpressionValue(s, "combineLatest(\n         …dSchedulers.mainThread())");
            return s;
        }
        return (ijc) invokeV.objValue;
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d().onNext(Boolean.valueOf(NotificationManagerCompat.from(TbadkCoreApplication.getInst()).areNotificationsEnabled()));
            c().onNext(Boolean.valueOf(e()));
        }
    }

    public static final Pair g(Boolean bool, Boolean bool2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, bool, bool2)) == null) {
            return new Pair(bool, bool2);
        }
        return (Pair) invokeLL.objValue;
    }

    public static final Boolean h(Pair pair, Pair pair2) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, pair, pair2)) == null) {
            if (Intrinsics.areEqual(pair.getFirst(), pair2.getFirst()) && Intrinsics.areEqual(pair.getSecond(), pair2.getSecond())) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeLL.objValue;
    }
}
