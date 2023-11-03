package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ixb;
import com.baidu.tieba.r2c;
import com.baidu.tieba.xwb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.CacheStatistic;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd2;
import com.fun.ad.sdk.FunSplashAd;
import com.fun.ad.sdk.ReadyCacheStatistic;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
import com.fun.ad.sdk.internal.api.flavor.IAdForbidStrategyManager;
import com.fun.ad.sdk.internal.api.flavor.RCInterceptor;
import com.fun.ad.sdk.internal.api.ripper.RippedAd;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* loaded from: classes8.dex */
public final class r2c extends ixb<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int l = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random d;
    public final xwb e;
    public final Map<Ssp.Pid, PidLoader> f;
    public final List<PidLoader> g;
    public final List<PidLoader> h;
    public FunAdInteractionListener i;
    public final boolean j;
    public final Handler k;

    public r2c(xwb xwbVar, v2c v2cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xwbVar, v2cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new Random();
        this.k = new a(this, Looper.getMainLooper());
        this.e = xwbVar;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (xwb.c cVar : xwbVar.e) {
            for (xwb.b bVar : cVar.b) {
                PidLoader a2 = v2cVar.a(bVar.c);
                if (a2 != null) {
                    if (bVar.c.isBidding) {
                        arrayList2.add(a2);
                    } else {
                        arrayList.add(a2);
                    }
                    a2.addListener(new c(this, bVar, a2));
                    hashMap.put(bVar.c, a2);
                }
            }
        }
        this.f = Collections.unmodifiableMap(hashMap);
        this.g = Collections.unmodifiableList(arrayList);
        List<PidLoader> unmodifiableList = Collections.unmodifiableList(arrayList2);
        this.h = unmodifiableList;
        this.j = !unmodifiableList.isEmpty();
    }

    public static /* synthetic */ Object a(qwb qwbVar, PidLoader pidLoader, String str) {
        Object a2 = qwbVar.a(pidLoader);
        if (a2 == null || !qwbVar.a((qwb) a2)) {
            return null;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(FunAdInteractionListener funAdInteractionListener) {
        funAdInteractionListener.onAdError(this.e.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean i(List list, xwb.b bVar) {
        PidLoader pidLoader = this.f.get(bVar.c);
        if (pidLoader != null) {
            if (list == null || !list.contains(pidLoader)) {
                return pidLoader.isLoaded();
            }
            return false;
        }
        return false;
    }

    public final <Result> Result a(final FunAdInteractionListener funAdInteractionListener, final qwb<Result> qwbVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funAdInteractionListener, qwbVar)) == null) {
            this.i = funAdInteractionListener;
            Result result = (Result) a(new x2c() { // from class: com.baidu.tieba.bwb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.x2c
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) ? r2c.a(qwb.this, pidLoader, str) : invokeLL2.objValue;
                }
            });
            if (result == null) {
                LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.e.a);
                this.k.post(new Runnable() { // from class: com.baidu.tieba.ewb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            r2c.this.h(funAdInteractionListener);
                        }
                    }
                });
            }
            return result;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.ixb
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            for (PidLoader pidLoader : this.h) {
                if (!pidLoader.getPid().pid.equals(str) && pidLoader.isLoaded()) {
                    LogPrinter.d("destroy bid : %s ", pidLoader.getPid().pid);
                    pidLoader.destroy(true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ixb, com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                super.destroy();
                this.i = null;
                for (PidLoader pidLoader : this.f.values()) {
                    pidLoader.destroy();
                }
            }
        }
    }

    public final PidLoader e(xwb.c cVar, final List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, cVar, list)) == null) {
            xwb.b bVar = (xwb.b) owb.a(this.d, cVar.b, new pwb() { // from class: com.baidu.tieba.fwb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.pwb
                public final boolean a(Object obj) {
                    InterceptResult invokeL;
                    boolean i;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        i = r2c.this.i(list, (xwb.b) obj);
                        return i;
                    }
                    return invokeL.booleanValue;
                }
            });
            if (bVar == null) {
                return null;
            }
            return this.f.get(bVar.c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public ReadyCacheStatistic getCacheStatistic(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? a(this.h, this.g) : (ReadyCacheStatistic) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(final Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) a(new x2c() { // from class: com.baidu.tieba.qvb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.x2c
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL;
                    FunNativeAd2 nativeAd2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) {
                        nativeAd2 = pidLoader.getNativeAd2(context, str);
                        return nativeAd2;
                    }
                    return invokeLL.objValue;
                }
            });
            if (funNativeAd2 == null) {
                LogPrinter.e("getNativeAd for sid:%s with No ready pidLoader found", this.e.a);
            }
            return funNativeAd2;
        }
        return (FunNativeAd2) invokeL.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            for (PidLoader pidLoader : this.f.values()) {
                if (pidLoader.isLoaded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ixb, com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.recycleListener();
            this.i = null;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends ixb.a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean i;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedHashMap<xwb.c, Integer> d;
        public long e;
        public double f;
        public final List<Double> g;
        public final /* synthetic */ r2c h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-509361848, "Lcom/baidu/tieba/r2c$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-509361848, "Lcom/baidu/tieba/r2c$b;");
                    return;
                }
            }
            i = !r2c.class.desiredAssertionStatus();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r2c r2cVar) {
            super(r2cVar.e.a, r2cVar.e.d, "p");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2cVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.h = r2cVar;
            this.d = new LinkedHashMap<>();
            this.f = 0.0d;
            this.g = new ArrayList();
        }

        public static /* synthetic */ int d(Double d, Double d2) {
            return -Double.compare(d.doubleValue(), d2.doubleValue());
        }

        /* loaded from: classes8.dex */
        public class a implements qwb<Boolean> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public a(b bVar, Activity activity, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = viewGroup;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Boolean, java.lang.Object] */
            @Override // com.baidu.tieba.qwb
            public Boolean a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return Boolean.valueOf(pidLoader.show(this.a, this.b, bVar.h.e.a, bVar.a));
                }
                return invokeL.objValue;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.qwb
            public boolean a(Boolean bool) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
                    return bool.booleanValue();
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: com.baidu.tieba.r2c$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0464b implements qwb<FunSplashAd> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public C0464b(b bVar, Activity activity, ViewGroup viewGroup) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, activity, viewGroup};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = activity;
                this.b = viewGroup;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.qwb
            public boolean a(FunSplashAd funSplashAd) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, funSplashAd)) == null) {
                    return true;
                }
                return invokeL.booleanValue;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            /* JADX WARN: Type inference failed for: r1v0, types: [com.fun.ad.sdk.FunSplashAd, java.lang.Object] */
            @Override // com.baidu.tieba.qwb
            public FunSplashAd a(PidLoader pidLoader) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pidLoader)) == null) {
                    b bVar = this.c;
                    return pidLoader.showSplash(this.a, this.b, bVar.h.e.a, bVar.a);
                }
                return invokeL.objValue;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x0141  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x0146 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x013f A[EDGE_INSN: B:77:0x013f->B:59:0x013f ?: BREAK  , SYNTHETIC] */
        @Override // com.baidu.tieba.ixb.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            boolean z;
            Iterator<xwb.b> it;
            PidLoader f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, funAdSlot, funAdLoadListener) == null) {
                this.h.k.removeMessages(101);
                this.h.k.removeMessages(100);
                r2c r2cVar = this.h;
                r2cVar.getClass();
                ArrayList arrayList = new ArrayList();
                for (xwb.c cVar : r2cVar.e.e) {
                    xwb.b bVar = (xwb.b) owb.a(r2cVar.d, cVar.b, null);
                    if (bVar != null) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    a("g_empty");
                    return;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.d.put(((xwb.b) it2.next()).d, 0);
                }
                this.e = System.currentTimeMillis();
                Message obtainMessage = this.h.k.obtainMessage(100);
                obtainMessage.obj = this;
                r2c r2cVar2 = this.h;
                r2cVar2.k.sendMessageDelayed(obtainMessage, r2cVar2.e.c);
                r2c r2cVar3 = this.h;
                if (r2cVar3.e.b > 0) {
                    Message obtainMessage2 = r2cVar3.k.obtainMessage(101);
                    obtainMessage2.obj = this;
                    r2c r2cVar4 = this.h;
                    r2cVar4.k.sendMessageDelayed(obtainMessage2, r2cVar4.e.b);
                }
                LogPrinter.d("Start load for sid:%s", this.h.e.a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    xwb.b bVar2 = (xwb.b) arrayList.get(i2);
                    PidLoader f2 = r2c.f(this.h, bVar2);
                    if (f2 != null) {
                        if (!i && bVar2.c == null) {
                            throw new AssertionError();
                        }
                        if (bVar2.c.isBidding && f2.isLoaded()) {
                            f2.destroy(true);
                        }
                        if (f2.isLoaded()) {
                            e(bVar2);
                        } else {
                            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(f2.getPid().pid, f2.getAdType());
                            if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                f2.load(context, funAdSlot, this.a);
                                z = false;
                                it = bVar2.d.b.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    xwb.b next = it.next();
                                    if (next != bVar2 && (f = r2c.f(this.h, next)) != null && f.isLoaded()) {
                                        e(next);
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                    f(bVar2, 0, "F1:No ready loader found");
                                }
                            }
                        }
                    }
                    z = true;
                    it = bVar2.d.b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                        }
                    }
                    if (!z) {
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ixb.a
        public boolean a(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, funAdInteractionListener)) == null) {
                r2c r2cVar = this.h;
                a aVar = new a(this, activity, viewGroup);
                int i2 = r2c.l;
                Boolean bool = (Boolean) r2cVar.a(funAdInteractionListener, aVar);
                if (bool != null && bool.booleanValue()) {
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tieba.ixb.a
        public FunSplashAd b(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, funAdInteractionListener)) == null) {
                r2c r2cVar = this.h;
                C0464b c0464b = new C0464b(this, activity, viewGroup);
                int i2 = r2c.l;
                return (FunSplashAd) r2cVar.a(funAdInteractionListener, c0464b);
            }
            return (FunSplashAd) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.ixb.a
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = null;
                this.h.k.removeMessages(100, this);
                this.h.k.removeMessages(101, this);
            }
        }

        public synchronized void e(xwb.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(bVar.d.a), pid.type, pid.pid);
                    if (a()) {
                        return;
                    }
                    xwb.c cVar = bVar.d;
                    if (!this.d.containsKey(cVar)) {
                        return;
                    }
                    this.d.put(cVar, 1);
                    PidLoader f = r2c.f(this.h, bVar);
                    if (f != null) {
                        double biddingOrBasePrices = f.getBiddingOrBasePrices();
                        if (this.f < biddingOrBasePrices) {
                            this.f = biddingOrBasePrices;
                        }
                        if (this.h.j) {
                            this.g.add(Double.valueOf(biddingOrBasePrices));
                        }
                    }
                    if (this.h.e.b > 0 && System.currentTimeMillis() - this.e < this.h.e.b) {
                        j();
                        return;
                    }
                    f();
                }
            }
        }

        public synchronized void f() {
            boolean z;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                synchronized (this) {
                    synchronized (this) {
                        Iterator<Map.Entry<xwb.c, Integer>> it = this.d.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().getValue().intValue() == 1) {
                                    z = true;
                                    break;
                                }
                            } else {
                                z = false;
                                break;
                            }
                        }
                    }
                }
                if (z) {
                    if (this.h.j) {
                        double i3 = i();
                        for (Map.Entry<xwb.c, Integer> entry : this.d.entrySet()) {
                            int intValue = entry.getValue().intValue();
                            for (xwb.b bVar : entry.getKey().b) {
                                PidLoader f = r2c.f(this.h, bVar);
                                if (f != null) {
                                    if (intValue == 1) {
                                        if (f.getBiddingOrBasePrices() == this.f) {
                                            i2 = 1;
                                        } else {
                                            i2 = 2;
                                        }
                                    } else if (intValue == -1) {
                                        i2 = 5;
                                    } else {
                                        i2 = 3;
                                    }
                                    if (i2 != 1 || i3 != 0.0d) {
                                        f.setBiddingResult("", this.f, i3, i2);
                                    }
                                }
                            }
                        }
                    }
                    b();
                }
            }
        }

        public final synchronized void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this) {
                    if (a()) {
                        return;
                    }
                    boolean z = true;
                    int i2 = -1;
                    for (Map.Entry<xwb.c, Integer> entry : this.d.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            xwb.c key = entry.getKey();
                            if (i2 < 0) {
                                i2 = key.a;
                            } else if (i2 != key.a) {
                                return;
                            }
                            if (intValue == 0) {
                                z = false;
                            } else if (intValue == 1) {
                                LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.h.e.a);
                                f();
                                return;
                            } else {
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.h.e.a);
                        a("af");
                    }
                }
            }
        }

        public synchronized void f(xwb.b bVar, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048582, this, bVar, i2, str) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i2), str, Integer.valueOf(bVar.d.a), pid.type, pid.pid);
                    if (!this.d.containsKey(bVar.d)) {
                        return;
                    }
                    this.d.put(bVar.d, -1);
                    j();
                }
            }
        }

        public final double i() {
            InterceptResult invokeV;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.h.j && this.g.size() != 0) {
                    Collections.sort(this.g, new Comparator() { // from class: com.baidu.tieba.dwb
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? r2c.b.d((Double) obj, (Double) obj2) : invokeLL.intValue;
                        }
                    });
                    int indexOf = this.g.indexOf(Double.valueOf(this.f));
                    if (indexOf >= 0 && this.g.size() > (i2 = indexOf + 1)) {
                        return this.g.get(i2).doubleValue();
                    }
                }
                return 0.0d;
            }
            return invokeV.doubleValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r2c r2cVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2cVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 100) {
                    b bVar = (b) message.obj;
                    if (!bVar.a()) {
                        xwb xwbVar = bVar.h.e;
                        LogPrinter.e("callback onError(%s) because of timeout(%d)", xwbVar.a, Long.valueOf(xwbVar.c));
                        bVar.a("tm_out");
                    }
                } else if (i == 101) {
                    ((b) message.obj).f();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements u2c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public final xwb.b a;
        public final PidLoader b;
        public final /* synthetic */ r2c c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-509361817, "Lcom/baidu/tieba/r2c$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-509361817, "Lcom/baidu/tieba/r2c$c;");
                    return;
                }
            }
            d = !r2c.class.desiredAssertionStatus();
        }

        public c(r2c r2cVar, xwb.b bVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r2cVar, bVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = r2cVar;
            this.a = bVar;
            this.b = pidLoader;
        }

        @Override // com.baidu.tieba.u2c
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.tieba.u2c
        public void a() {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (bVar = (b) this.c.c) != null) {
                bVar.e(this.a);
            }
        }

        @Override // com.baidu.tieba.u2c
        public void a(int i, String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (bVar = (b) this.c.c) != null) {
                bVar.f(this.a, i, str);
                IAdForbidStrategyManager iAdForbidStrategyManager = Flavors.STRATEGY_MANAGER;
                Ssp.Pid pid = this.a.c;
                iAdForbidStrategyManager.setErrInfo(pid.ssp.type, pid.pid, i, str);
            }
        }

        @Override // com.baidu.tieba.u2c
        public void b(int i, String str) {
            r2c r2cVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (funAdInteractionListener = (r2cVar = this.c).i) != null) {
                funAdInteractionListener.onAdError(r2cVar.e.a);
            }
        }

        @Override // com.baidu.tieba.u2c
        public void a(RippedAd rippedAd, Map<String, String> map) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, rippedAd, map) == null) && (funAdInteractionListener = this.c.i) != null) {
                if (!d && this.a.c == null) {
                    throw new AssertionError();
                }
                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.c.pid, this.b.getAdType());
                if (shouldIntercept != null) {
                    shouldIntercept.onAdClick(rippedAd);
                }
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = this.c.e.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.u2c
        public void b(RippedAd rippedAd, Map<String, String> map) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, map) == null) && (funAdInteractionListener = this.c.i) != null) {
                if (!d && this.a.c == null) {
                    throw new AssertionError();
                }
                RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(this.a.c.pid, this.b.getAdType());
                if (shouldIntercept != null) {
                    shouldIntercept.onAdShow(rippedAd);
                }
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = this.c.e.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, map);
            }
        }

        @Override // com.baidu.tieba.u2c
        public void a(Map<String, String> map) {
            r2c r2cVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, map) == null) && (funAdInteractionListener = (r2cVar = this.c).i) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = r2cVar.e.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onAdClose(funAdInteractionListener, str, pid.ssp.type, pid.pid, map);
            }
        }

        @Override // com.baidu.tieba.u2c
        public void a(boolean z, int i, Map<String, String> map) {
            r2c r2cVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), map}) == null) && (funAdInteractionListener = (r2cVar = this.c).i) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = r2cVar.e.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onRewardedVideo(funAdInteractionListener, str, z, pid.ssp.type, i, pid.pid, map);
            }
        }
    }

    public static PidLoader f(r2c r2cVar, xwb.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, r2cVar, bVar)) == null) {
            r2cVar.getClass();
            if (bVar == null) {
                return null;
            }
            return r2cVar.f.get(bVar.c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    public final <N> N a(x2c<N> x2cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x2cVar)) == null) {
            if (this.j) {
                return (N) a(this.h, this.g, x2cVar, this.e.a);
            }
            for (xwb.c cVar : this.e.e) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader e = e(cVar, arrayList);
                    if (e != null) {
                        N a2 = x2cVar.a(e, this.e.a);
                        if (a2 == null) {
                            arrayList.add(e);
                        } else {
                            return a2;
                        }
                    }
                }
            }
            return null;
        }
        return (N) invokeL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.ixb$a' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.ixb$a, com.baidu.tieba.r2c$b] */
    @Override // com.baidu.tieba.ixb
    public b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new b(this);
        }
        return (ixb.a) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (xwb.c cVar : this.e.e) {
                    for (xwb.b bVar : cVar.b) {
                        if (bVar != null && (pidLoader = this.f.get(bVar.c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getBiddingOrBasePrices()));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
