package com.baidu.tieba;

import android.util.Log;
import com.baidu.tieba.tracker.Tracker;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class qna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Object obj, final String tid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, obj, tid) == null) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            Intrinsics.checkNotNullParameter(tid, "tid");
            final IEventNode b = gna.a.a(tid).b();
            if (b != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append("\nonEvent：" + tid);
                for (IEventNode iEventNode = b; iEventNode != null; iEventNode = iEventNode.getNext()) {
                    sb.append("\nvalue = " + iEventNode);
                }
                sb.append("\n------------------------------------------------------");
                Log.d("lt-log", sb.toString());
                kna.b.a().c(new jna(tid, new Runnable() { // from class: com.baidu.tieba.pna
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            qna.b(tid, b);
                        }
                    }
                }));
                gna.a.b(tid);
            }
        }
    }

    public static final void b(String tid, IEventNode iEventNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, tid, iEventNode) == null) {
            Intrinsics.checkNotNullParameter(tid, "$tid");
            Tracker.d.d(tid, iEventNode);
        }
    }
}
