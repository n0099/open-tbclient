package com.baidu.tts;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.c1;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.d1;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
/* loaded from: classes9.dex */
public class e1<A extends d1<A, R>, R extends c1> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ConcurrentMap<A, Future<R>> a;

    public e1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ConcurrentHashMap();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0082 */
    /* JADX DEBUG: Type inference failed for r0v10. Raw type applied. Possible types: java.util.concurrent.ConcurrentMap<A extends com.baidu.tts.d1<A, R>, java.util.concurrent.Future<R extends com.baidu.tts.c1>>, java.util.concurrent.ConcurrentMap */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.util.concurrent.Future, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.util.concurrent.FutureTask, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public R a(A a) throws Exception {
        InterceptResult invokeL;
        Future<R> future;
        A a2;
        Future<R> future2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a)) == null) {
            Iterator<A> it = this.a.keySet().iterator();
            while (true) {
                future = 0;
                if (it.hasNext()) {
                    a2 = it.next();
                    if (a.compareTo(a2) == 0) {
                        break;
                    }
                } else {
                    a2 = null;
                    break;
                }
            }
            if (a2 != null) {
                future2 = this.a.get(a2);
            } else {
                future2 = null;
            }
            try {
                if (future2 != null) {
                    LoggerProxy.d("Memorizer", "+ get f=" + future2);
                    R r = future2.get();
                    LoggerProxy.d("Memorizer", "- get f=" + future2);
                    if (!r.a()) {
                        LoggerProxy.d("Memorizer", "arg invalid r=" + r);
                        this.a.remove(a2);
                        if (future == 0) {
                            future = new FutureTask<>(a);
                            Future future3 = (Future) ((ConcurrentMap<A, Future<R>>) this.a).putIfAbsent(a, future);
                            if (future3 == null) {
                                LoggerProxy.d("Memorizer", "+ run f=" + future);
                                future.run();
                                LoggerProxy.d("Memorizer", "- run f=" + future);
                            } else {
                                future = future3;
                            }
                        }
                        return (R) future.get();
                    }
                }
                return (R) future.get();
            } catch (Exception e) {
                this.a.remove(a, future);
                throw e;
            }
            future = future2;
            if (future == 0) {
            }
        } else {
            return (R) invokeL.objValue;
        }
    }
}
