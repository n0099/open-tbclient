package com.baidu.tieba;

import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class j4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Object obj, String tid) {
        boolean z;
        IEventNode iEventNode;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, obj, tid) == null) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            Intrinsics.checkNotNullParameter(tid, "tid");
            Monitor.a.e(tid);
            IEventNode b = v3b.a.b(tid).b();
            if (b != null) {
                if (b.getNext() != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    iEventNode = b;
                } else {
                    iEventNode = null;
                }
                if (iEventNode != null) {
                    Tracker.i.d("ubc_id_stub", b);
                }
            }
            v3b.a.c(tid);
        }
    }
}
