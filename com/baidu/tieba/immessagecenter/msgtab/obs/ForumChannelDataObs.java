package com.baidu.tieba.immessagecenter.msgtab.obs;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabForumData;
import com.baidu.tieba.immessagecenter.msgtab.data.MsgTabFunctionData;
import com.baidu.tieba.t5c;
import com.baidu.tieba.tp8;
import com.baidu.tieba.y0c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\u00050\u0014J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0019\u001a\u00020\u0006J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0007J\u0016\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016Ro\u0010\u0003\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0005 \b**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007 \b*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nRo\u0010\r\u001aV\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e \b*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00050\u0005 \b**\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e \b*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u000f\u0010\n¨\u0006 "}, d2 = {"Lcom/baidu/tieba/immessagecenter/msgtab/obs/ForumChannelDataObs;", "Lcom/baidu/tieba/immessagecenter/msgtab/obs/DataChangedMonitor;", "()V", "mForumSubject", "Lrx/subjects/BehaviorSubject;", "", "", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabForumData;", "kotlin.jvm.PlatformType", "getMForumSubject", "()Lrx/subjects/BehaviorSubject;", "mForumSubject$delegate", "Lkotlin/Lazy;", "mFunDataSubject", "Lcom/baidu/tieba/immessagecenter/msgtab/data/MsgTabFunctionData;", "getMFunDataSubject", "mFunDataSubject$delegate", DownloadStatisticConstants.UBC_VALUE_CLEAR, "", "dataChangedObs", "Lrx/Observable;", "forumSize", "", "funDataChangedObs", "getForumDataById", "key", "getFuncDataById", "notifyDataChanged", "value", "start", "stop", "Companion", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ForumChannelDataObs implements tp8 {
    public static /* synthetic */ Interceptable $ic;
    public static final a c;
    public static final Lazy<ForumChannelDataObs> d;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    @Override // com.baidu.tieba.tp8
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
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

        public final ForumChannelDataObs a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b();
            }
            return (ForumChannelDataObs) invokeV.objValue;
        }

        public final ForumChannelDataObs b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return (ForumChannelDataObs) ForumChannelDataObs.d.getValue();
            }
            return (ForumChannelDataObs) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2071794348, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/ForumChannelDataObs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2071794348, "Lcom/baidu/tieba/immessagecenter/msgtab/obs/ForumChannelDataObs;");
                return;
            }
        }
        c = new a(null);
        d = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) ForumChannelDataObs$Companion$instance$2.INSTANCE);
    }

    public final y0c<Map<Long, MsgTabForumData>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y0c<Map<Long, MsgTabForumData>> a2 = g().a();
            Intrinsics.checkNotNullExpressionValue(a2, "mForumSubject.asObservable()");
            return a2;
        }
        return (y0c) invokeV.objValue;
    }

    public final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return g().T().size();
        }
        return invokeV.intValue;
    }

    public final y0c<Map<Long, MsgTabFunctionData>> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            y0c<Map<Long, MsgTabFunctionData>> a2 = h().a();
            Intrinsics.checkNotNullExpressionValue(a2, "mFunDataSubject.asObservable()");
            return a2;
        }
        return (y0c) invokeV.objValue;
    }

    public final t5c<Map<Long, MsgTabForumData>> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (t5c) this.a.getValue();
        }
        return (t5c) invokeV.objValue;
    }

    public final t5c<Map<Long, MsgTabFunctionData>> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (t5c) this.b.getValue();
        }
        return (t5c) invokeV.objValue;
    }

    public ForumChannelDataObs() {
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
        this.a = LazyKt__LazyJVMKt.lazy(ForumChannelDataObs$mForumSubject$2.INSTANCE);
        this.b = LazyKt__LazyJVMKt.lazy(ForumChannelDataObs$mFunDataSubject$2.INSTANCE);
    }

    public final MsgTabForumData e(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            return g().T().get(Long.valueOf(j));
        }
        return (MsgTabForumData) invokeJ.objValue;
    }

    public final MsgTabFunctionData f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            return h().T().get(Long.valueOf(j));
        }
        return (MsgTabFunctionData) invokeJ.objValue;
    }

    public final void i(long j, MsgTabForumData value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048583, this, j, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            Map<Long, MsgTabForumData> T2 = g().T();
            Intrinsics.checkNotNullExpressionValue(T2, "mForumSubject.value");
            T2.put(Long.valueOf(j), value);
            g().onNext(g().T());
        }
    }

    public final void j(long j, MsgTabFunctionData value) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j, value) == null) {
            Intrinsics.checkNotNullParameter(value, "value");
            Map<Long, MsgTabFunctionData> T2 = h().T();
            Intrinsics.checkNotNullExpressionValue(T2, "mFunDataSubject.value");
            T2.put(Long.valueOf(j), value);
            h().onNext(h().T());
        }
    }
}
