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
import com.baidu.tieba.fra;
import com.baidu.tieba.nra;
import com.baidu.tieba.zla;
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
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.flavor.CallBackAware;
import com.fun.ad.sdk.internal.api.flavor.Flavors;
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
/* loaded from: classes5.dex */
public final class nra extends fra<b> {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ int l = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final Random d;
    public final zla e;
    public final Map<Ssp.Pid, PidLoader> f;
    public final List<PidLoader> g;
    public final List<PidLoader> h;
    public FunAdInteractionListener i;
    public final boolean j;
    public final Handler k;

    public nra(zla zlaVar, nla nlaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zlaVar, nlaVar};
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
        this.e = zlaVar;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (zla.c cVar : zlaVar.e) {
            for (zla.b bVar : cVar.b) {
                PidLoader a2 = nlaVar.a(bVar.c);
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

    public static /* synthetic */ Object m(yla ylaVar, PidLoader pidLoader, String str) {
        Object a2 = ylaVar.a(pidLoader);
        if (a2 == null || !ylaVar.a((yla) a2)) {
            return null;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(FunAdInteractionListener funAdInteractionListener) {
        funAdInteractionListener.onAdError(this.e.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean o(List list, zla.b bVar) {
        PidLoader pidLoader = this.f.get(bVar.c);
        if (pidLoader != null) {
            if (list == null || !list.contains(pidLoader)) {
                return pidLoader.isLoaded();
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.fra, com.fun.ad.sdk.FunAdLoader
    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                super.destroy();
                this.i = null;
                for (PidLoader pidLoader : this.f.values()) {
                    pidLoader.destroy();
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public FunNativeAd2 getNativeAd2(final Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            FunNativeAd2 funNativeAd2 = (FunNativeAd2) l(new rla() { // from class: com.baidu.tieba.wka
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rla
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

    public final PidLoader h(zla.c cVar, final List<PidLoader> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, cVar, list)) == null) {
            zla.b bVar = (zla.b) pla.a(this.d, cVar.b, new wla() { // from class: com.baidu.tieba.fla
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.wla
                public final boolean a(Object obj) {
                    InterceptResult invokeL;
                    boolean o;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                        o = nra.this.o(list, (zla.b) obj);
                        return o;
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
    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            for (PidLoader pidLoader : this.f.values()) {
                if (pidLoader.isLoaded()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final <Result> Result k(final FunAdInteractionListener funAdInteractionListener, final yla<Result> ylaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, funAdInteractionListener, ylaVar)) == null) {
            this.i = funAdInteractionListener;
            Result result = (Result) l(new rla() { // from class: com.baidu.tieba.zka
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.rla
                public final Object a(PidLoader pidLoader, String str) {
                    InterceptResult invokeLL2;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL2 = interceptable2.invokeLL(1048576, this, pidLoader, str)) == null) ? nra.m(yla.this, pidLoader, str) : invokeLL2.objValue;
                }
            });
            if (result == null) {
                LogPrinter.e("showFailed for sid:%s with No ready pidLoader found or all pidLoader showFailed", this.e.a);
                this.k.post(new Runnable() { // from class: com.baidu.tieba.gla
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            nra.this.n(funAdInteractionListener);
                        }
                    }
                });
            }
            return result;
        }
        return (Result) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.fra, com.fun.ad.sdk.FunAdLoader
    public void recycleListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.recycleListener();
            this.i = null;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends fra.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedHashMap<zla.c, Integer> d;
        public long e;
        public double f;
        public final List<Double> g;
        public final /* synthetic */ nra h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(nra nraVar) {
            super(nraVar.e.a, nraVar.e.d, "p");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nraVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], ((Integer) objArr2[1]).intValue(), (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = nraVar;
            this.d = new LinkedHashMap<>();
            this.f = 0.0d;
            this.g = new ArrayList();
        }

        public static /* synthetic */ int h(Double d, Double d2) {
            return -Double.compare(d.doubleValue(), d2.doubleValue());
        }

        /* loaded from: classes5.dex */
        public class a implements yla<Boolean> {
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
            @Override // com.baidu.tieba.yla
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
            @Override // com.baidu.tieba.yla
            public boolean a(Boolean bool) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool)) == null) {
                    return bool.booleanValue();
                }
                return invokeL.booleanValue;
            }
        }

        /* renamed from: com.baidu.tieba.nra$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0361b implements yla<FunSplashAd> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Activity a;
            public final /* synthetic */ ViewGroup b;
            public final /* synthetic */ b c;

            public C0361b(b bVar, Activity activity, ViewGroup viewGroup) {
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
            @Override // com.baidu.tieba.yla
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
            @Override // com.baidu.tieba.yla
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

        /* JADX WARN: Removed duplicated region for block: B:38:0x0105  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0128 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0121 A[EDGE_INSN: B:64:0x0121->B:47:0x0121 ?: BREAK  , SYNTHETIC] */
        @Override // com.baidu.tieba.fra.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Context context, FunAdSlot funAdSlot, FunAdLoadListener funAdLoadListener) {
            boolean z;
            Iterator<zla.b> it;
            PidLoader i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, context, funAdSlot, funAdLoadListener) == null) {
                this.h.k.removeMessages(101);
                this.h.k.removeMessages(100);
                nra nraVar = this.h;
                nraVar.getClass();
                ArrayList arrayList = new ArrayList();
                for (zla.c cVar : nraVar.e.e) {
                    zla.b bVar = (zla.b) pla.a(nraVar.d, cVar.b, null);
                    if (bVar != null) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.isEmpty()) {
                    b("g_empty");
                    return;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.d.put(((zla.b) it2.next()).d, 0);
                }
                this.e = System.currentTimeMillis();
                Message obtainMessage = this.h.k.obtainMessage(100);
                obtainMessage.obj = this;
                nra nraVar2 = this.h;
                nraVar2.k.sendMessageDelayed(obtainMessage, nraVar2.e.c);
                nra nraVar3 = this.h;
                if (nraVar3.e.b > 0) {
                    Message obtainMessage2 = nraVar3.k.obtainMessage(101);
                    obtainMessage2.obj = this;
                    nra nraVar4 = this.h;
                    nraVar4.k.sendMessageDelayed(obtainMessage2, nraVar4.e.b);
                }
                LogPrinter.d("Start load for sid:%s", this.h.e.a);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    zla.b bVar2 = (zla.b) arrayList.get(i2);
                    PidLoader i3 = nra.i(this.h, bVar2);
                    if (i3 != null) {
                        if (i3.isLoaded()) {
                            i(bVar2);
                        } else {
                            RCInterceptor shouldIntercept = Flavors.PLUGIN_RC.shouldIntercept(i3.getPid().pid, i3.getAdType());
                            if (shouldIntercept == null || !shouldIntercept.shouldInterceptLoad()) {
                                i3.load(context, funAdSlot, this.a);
                                z = false;
                                it = bVar2.d.b.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    zla.b next = it.next();
                                    if (next != bVar2 && (i = nra.i(this.h, next)) != null && i.isLoaded()) {
                                        i(next);
                                        z = false;
                                        break;
                                    }
                                }
                                if (!z) {
                                    j(bVar2, 0, "F1:No ready loader found");
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

        @Override // com.baidu.tieba.fra.a
        public boolean d(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, viewGroup, funAdInteractionListener)) == null) {
                nra nraVar = this.h;
                a aVar = new a(this, activity, viewGroup);
                int i = nra.l;
                Boolean bool = (Boolean) nraVar.k(funAdInteractionListener, aVar);
                if (bool != null && bool.booleanValue()) {
                    return true;
                }
                return false;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.tieba.fra.a
        public FunSplashAd e(Activity activity, ViewGroup viewGroup, FunAdInteractionListener funAdInteractionListener) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, activity, viewGroup, funAdInteractionListener)) == null) {
                nra nraVar = this.h;
                C0361b c0361b = new C0361b(this, activity, viewGroup);
                int i = nra.l;
                return (FunSplashAd) nraVar.k(funAdInteractionListener, c0361b);
            }
            return (FunSplashAd) invokeLLL.objValue;
        }

        @Override // com.baidu.tieba.fra.a
        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.c = null;
                this.h.k.removeMessages(100, this);
                this.h.k.removeMessages(101, this);
            }
        }

        public synchronized void i(zla.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.c;
                    LogPrinter.d("onAdLoaded group.weight:%d type:%s pid:%s", Integer.valueOf(bVar.d.a), pid.type, pid.pid);
                    if (c()) {
                        return;
                    }
                    zla.c cVar = bVar.d;
                    if (!this.d.containsKey(cVar)) {
                        return;
                    }
                    this.d.put(cVar, 1);
                    PidLoader i = nra.i(this.h, bVar);
                    if (i != null) {
                        double biddingOrBasePrices = i.getBiddingOrBasePrices();
                        if (this.f < biddingOrBasePrices) {
                            this.f = biddingOrBasePrices;
                        }
                        if (this.h.j) {
                            this.g.add(Double.valueOf(biddingOrBasePrices));
                        }
                    }
                    if (this.h.e.b > 0 && System.currentTimeMillis() - this.e < this.h.e.b) {
                        l();
                        return;
                    }
                    m();
                }
            }
        }

        public synchronized void j(zla.b bVar, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048581, this, bVar, i, str) == null) {
                synchronized (this) {
                    Ssp.Pid pid = bVar.c;
                    LogPrinter.d("onError code:%d message:%s group.weight:%d type:%s pid:%s", Integer.valueOf(i), str, Integer.valueOf(bVar.d.a), pid.type, pid.pid);
                    if (!this.d.containsKey(bVar.d)) {
                        return;
                    }
                    this.d.put(bVar.d, -1);
                    l();
                }
            }
        }

        public final double k() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.h.j && this.g.size() != 0) {
                    Collections.sort(this.g, new Comparator() { // from class: com.baidu.tieba.ala
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, obj, obj2)) == null) ? nra.b.h((Double) obj, (Double) obj2) : invokeLL.intValue;
                        }
                    });
                    int indexOf = this.g.indexOf(Double.valueOf(this.f));
                    if (indexOf >= 0 && this.g.size() > (i = indexOf + 1)) {
                        return this.g.get(i).doubleValue();
                    }
                    return this.f;
                }
                return this.f;
            }
            return invokeV.doubleValue;
        }

        public final synchronized void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                synchronized (this) {
                    if (c()) {
                        return;
                    }
                    boolean z = true;
                    int i = -1;
                    for (Map.Entry<zla.c, Integer> entry : this.d.entrySet()) {
                        int intValue = entry.getValue().intValue();
                        if (intValue != -1) {
                            zla.c key = entry.getKey();
                            if (i < 0) {
                                i = key.a;
                            } else if (i != key.a) {
                                return;
                            }
                            if (intValue == 0) {
                                z = false;
                            } else if (intValue == 1) {
                                LogPrinter.d("callback onAdLoaded(%s) because max priority adId is loaded", this.h.e.a);
                                m();
                                return;
                            } else {
                                throw new IllegalStateException("Unknown value:" + intValue);
                            }
                        }
                    }
                    if (z) {
                        LogPrinter.e("callback onError(%s) as all group failed to load", this.h.e.a);
                        b("af");
                    }
                }
            }
        }

        public synchronized void m() {
            boolean z;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                synchronized (this) {
                    synchronized (this) {
                        Iterator<Map.Entry<zla.c, Integer>> it = this.d.entrySet().iterator();
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
                        double k = k();
                        for (Map.Entry<zla.c, Integer> entry : this.d.entrySet()) {
                            int intValue = entry.getValue().intValue();
                            for (zla.b bVar : entry.getKey().b) {
                                PidLoader i2 = nra.i(this.h, bVar);
                                if (i2 != null) {
                                    if (intValue == 1) {
                                        if (i2.getBiddingOrBasePrices() == this.f) {
                                            i = 1;
                                        } else {
                                            i = 2;
                                        }
                                    } else if (intValue == -1) {
                                        i = 5;
                                    } else {
                                        i = 3;
                                    }
                                    i2.setBiddingResult(this.f, k, i);
                                }
                            }
                        }
                    }
                    f();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nra nraVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nraVar, looper};
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
                    if (!bVar.c()) {
                        zla zlaVar = bVar.h.e;
                        LogPrinter.e("callback onError(%s) because of timeout(%d)", zlaVar.a, Long.valueOf(zlaVar.c));
                        bVar.b("tm_out");
                    }
                } else if (i == 101) {
                    ((b) message.obj).m();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ila {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ boolean d;
        public transient /* synthetic */ FieldHolder $fh;
        public final zla.b a;
        public final PidLoader b;
        public final /* synthetic */ nra c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-564832659, "Lcom/baidu/tieba/nra$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-564832659, "Lcom/baidu/tieba/nra$c;");
                    return;
                }
            }
            d = !nra.class.desiredAssertionStatus();
        }

        public c(nra nraVar, zla.b bVar, PidLoader pidLoader) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nraVar, bVar, pidLoader};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.c = nraVar;
            this.a = bVar;
            this.b = pidLoader;
        }

        @Override // com.baidu.tieba.ila
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            }
        }

        @Override // com.baidu.tieba.ila
        public void a() {
            nra nraVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (funAdInteractionListener = (nraVar = this.c).i) != null) {
                funAdInteractionListener.onAdClose(nraVar.e.a);
            }
        }

        @Override // com.baidu.tieba.ila
        public void b() {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bVar = (b) this.c.b) != null) {
                bVar.i(this.a);
            }
        }

        @Override // com.baidu.tieba.ila
        public void a(int i, String str) {
            b bVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && (bVar = (b) this.c.b) != null) {
                bVar.j(this.a, i, str);
            }
        }

        @Override // com.baidu.tieba.ila
        public void c(int i, String str) {
            nra nraVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) && (funAdInteractionListener = (nraVar = this.c).i) != null) {
                funAdInteractionListener.onAdError(nraVar.e.a);
            }
        }

        @Override // com.baidu.tieba.ila
        public void a(boolean z, int i, String... strArr) {
            nra nraVar;
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), strArr}) == null) && (funAdInteractionListener = (nraVar = this.c).i) != null) {
                CallBackAware callBackAware = Flavors.CALL_BACK_AWARE;
                String str = nraVar.e.a;
                Ssp.Pid pid = this.a.c;
                callBackAware.onRewardedVideo(funAdInteractionListener, str, z, pid.ssp.type, i, pid.pid, strArr);
            }
        }

        @Override // com.baidu.tieba.ila
        public void b(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048580, this, rippedAd, strArr) == null) && (funAdInteractionListener = this.c.i) != null) {
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
                callBackAware.onAdClicked(funAdInteractionListener, str, pid.ssp.type, pid.pid, strArr);
            }
        }

        @Override // com.baidu.tieba.ila
        public void d(RippedAd rippedAd, String... strArr) {
            FunAdInteractionListener funAdInteractionListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048583, this, rippedAd, strArr) == null) && (funAdInteractionListener = this.c.i) != null) {
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
                callBackAware.show(funAdInteractionListener, str, pid.ssp.type, pid.pid, rippedAd, strArr);
            }
        }
    }

    public static PidLoader i(nra nraVar, zla.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, nraVar, bVar)) == null) {
            nraVar.getClass();
            if (bVar == null) {
                return null;
            }
            return nraVar.f.get(bVar.c);
        }
        return (PidLoader) invokeLL.objValue;
    }

    /* JADX DEBUG: Return type fixed from 'com.baidu.tieba.fra$a' to match base method */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.baidu.tieba.fra$a, com.baidu.tieba.nra$b] */
    @Override // com.baidu.tieba.fra
    public b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new b(this);
        }
        return (fra.a) invokeV.objValue;
    }

    @Override // com.fun.ad.sdk.FunAdLoader
    public synchronized List<CacheStatistic> getCacheStatistics(String str) {
        InterceptResult invokeL;
        ArrayList arrayList;
        PidLoader pidLoader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (zla.c cVar : this.e.e) {
                    for (zla.b bVar : cVar.b) {
                        if (bVar != null && (pidLoader = this.f.get(bVar.c)) != null && pidLoader.isLoaded()) {
                            arrayList.add(new CacheStatistic(pidLoader.getAdType(), pidLoader.getPid().pid, pidLoader.getAdCount(), pidLoader.getPid().basePrice));
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final <N> N l(rla<N> rlaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rlaVar)) == null) {
            if (this.j) {
                return (N) c(this.h, this.g, rlaVar, this.e.a);
            }
            for (zla.c cVar : this.e.e) {
                ArrayList arrayList = new ArrayList();
                while (true) {
                    PidLoader h = h(cVar, arrayList);
                    if (h != null) {
                        N a2 = rlaVar.a(h, this.e.a);
                        if (a2 == null) {
                            arrayList.add(h);
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
}
