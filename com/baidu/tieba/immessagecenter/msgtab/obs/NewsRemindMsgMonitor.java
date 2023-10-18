package com.baidu.tieba.immessagecenter.msgtab.obs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tieba.b7c;
import com.baidu.tieba.fbc;
import com.baidu.tieba.h6c;
import com.baidu.tieba.immessagecenter.msgtab.obs.NewsRemindMsgMonitor;
import com.baidu.tieba.o6c;
import com.baidu.tieba.r6c;
import com.baidu.tieba.v6c;
import com.baidu.tieba.yq8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0006\u0010\u001e\u001a\u00020\u001cJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180 J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0 J\u0006\u0010\"\u001a\u00020\u000eJ\b\u0010#\u001a\u00020\u001cH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0019\u0010\n¨\u0006&"}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/obs/NewsRemindMsgMonitor;", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "()V", "mDataChangedListener", "com/baidu/tieba/immessagecenter/msgtab/obs/NewsRemindMsgMonitor$mDataChangedListener$1", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/NewsRemindMsgMonitor$mDataChangedListener$1;", "mDelaySubject", "Lrx/subjects/BehaviorSubject;", "", "getMDelaySubject", "()Lrx/subjects/BehaviorSubject;", "mDelaySubject$delegate", "Lkotlin/Lazy;", "mSubject", "Lcom/baidu/tbadk/coreExtra/messageCenter/NewsRemindMessage;", "getMSubject", "mSubject$delegate", TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE, "Lrx/Subscription;", "getSubscribe", "()Lrx/Subscription;", "setSubscribe", "(Lrx/Subscription;)V", "upgradeTipsSubject", "", "getUpgradeTipsSubject", "upgradeTipsSubject$delegate", "delayWakeUp", "", "num", "forceRefreshRemind", "getShowUpgradeTipsObs", "Lrx/Observable;", "newsRemindChangedObs", "newsRemindMessage", "start", "stop", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NewsRemindMsgMonitor implements yq8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a f;
    public static final Lazy<NewsRemindMsgMonitor> g;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;
    public o6c c;
    public final Lazy d;
    public final b e;

    public static final NewsRemindMessage l(Integer num, NewsRemindMessage newsRemindMessage) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, num, newsRemindMessage)) == null) ? newsRemindMessage : (NewsRemindMessage) invokeLL.objValue;
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

        public final NewsRemindMsgMonitor a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (NewsRemindMsgMonitor) invokeV.objValue;
        }

        public final NewsRemindMsgMonitor b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (NewsRemindMsgMonitor) NewsRemindMsgMonitor.g.getValue();
            }
            return (NewsRemindMsgMonitor) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewsRemindMsgMonitor a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(NewsRemindMsgMonitor newsRemindMsgMonitor) {
            super(2001626);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newsRemindMsgMonitor};
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
            this.a = newsRemindMsgMonitor;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                if (customResponsedMessage.getCmd() == 2001626) {
                    z = true;
                } else {
                    z = false;
                }
                NewsRemindMessage newsRemindMessage = null;
                if (!z) {
                    customResponsedMessage = null;
                }
                if (customResponsedMessage != null) {
                    if (customResponsedMessage instanceof NewsRemindMessage) {
                        newsRemindMessage = (NewsRemindMessage) customResponsedMessage;
                    }
                    if (newsRemindMessage != null) {
                        NewsRemindMsgMonitor newsRemindMsgMonitor = this.a;
                        newsRemindMsgMonitor.d(0);
                        newsRemindMsgMonitor.h().onNext(newsRemindMessage);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1375596891, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/NewsRemindMsgMonitor;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1375596891, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/NewsRemindMsgMonitor;");
                return;
            }
        }
        f = new a(null);
        g = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) NewsRemindMsgMonitor$Companion$instance$2.INSTANCE);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d(1);
        }
    }

    public final fbc<Integer> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mDelaySubject>(...)");
            return (fbc) value;
        }
        return (fbc) invokeV.objValue;
    }

    public final fbc<NewsRemindMessage> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Object value = this.a.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mSubject>(...)");
            return (fbc) value;
        }
        return (fbc) invokeV.objValue;
    }

    public final h6c<Boolean> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            h6c<Boolean> g2 = j().g();
            Intrinsics.checkNotNullExpressionValue(g2, "upgradeTipsSubject.distinctUntilChanged()");
            return g2;
        }
        return (h6c) invokeV.objValue;
    }

    public final fbc<Boolean> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Object value = this.b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-upgradeTipsSubject>(...)");
            return (fbc) value;
        }
        return (fbc) invokeV.objValue;
    }

    public final NewsRemindMessage m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            NewsRemindMessage T2 = h().T();
            Intrinsics.checkNotNullExpressionValue(T2, "mSubject.value");
            return T2;
        }
        return (NewsRemindMessage) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yq8
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            MessageManager.getInstance().registerListener(this.e);
        }
    }

    public NewsRemindMsgMonitor() {
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
        this.a = LazyKt__LazyJVMKt.lazy(NewsRemindMsgMonitor$mSubject$2.INSTANCE);
        this.b = LazyKt__LazyJVMKt.lazy(NewsRemindMsgMonitor$upgradeTipsSubject$2.INSTANCE);
        this.d = LazyKt__LazyJVMKt.lazy(NewsRemindMsgMonitor$mDelaySubject$2.INSTANCE);
        this.e = new b(this);
    }

    public final h6c<NewsRemindMessage> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            h6c<NewsRemindMessage> s = h6c.c(g(), h(), new b7c() { // from class: com.baidu.tieba.xq8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.b7c
                public final Object a(Object obj, Object obj2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) {
                        NewsRemindMessage newsRemindMessage = (NewsRemindMessage) obj2;
                        NewsRemindMsgMonitor.l((Integer) obj, newsRemindMessage);
                        return newsRemindMessage;
                    }
                    return invokeLL.objValue;
                }
            }).x().s(r6c.b());
            Intrinsics.checkNotNullExpressionValue(s, "combineLatest(\n         …dSchedulers.mainThread())");
            return s;
        }
        return (h6c) invokeV.objValue;
    }

    public static final void e(NewsRemindMsgMonitor this$0, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, this$0, l) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.g().onNext(1);
        }
    }

    public final void d(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            Long valueOf = Long.valueOf(SharedPrefHelper.getInstance().getLong("key_msg_remind_frequency_minute", 0L));
            boolean z2 = true;
            if (valueOf.longValue() > 0) {
                z = true;
            } else {
                z = false;
            }
            Long l = null;
            if (!z) {
                valueOf = null;
            }
            if (valueOf != null) {
                Long valueOf2 = Long.valueOf(valueOf.longValue() - (System.currentTimeMillis() - SharedPrefHelper.getInstance().getLong("key_msg_remind_last_show_time", 0L)));
                if (valueOf2.longValue() <= 0) {
                    z2 = false;
                }
                if (z2) {
                    l = valueOf2;
                }
                if (l != null) {
                    long longValue = l.longValue();
                    o6c o6cVar = this.c;
                    if (o6cVar != null) {
                        o6cVar.unsubscribe();
                    }
                    g().onNext(Integer.valueOf(i));
                    this.c = h6c.n(Long.valueOf(longValue)).e(longValue, TimeUnit.MILLISECONDS).H(new v6c() { // from class: com.baidu.tieba.vq8
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // com.baidu.tieba.v6c
                        public final void call(Object obj) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                                NewsRemindMsgMonitor.e(NewsRemindMsgMonitor.this, (Long) obj);
                            }
                        }
                    });
                }
            }
        }
    }
}
