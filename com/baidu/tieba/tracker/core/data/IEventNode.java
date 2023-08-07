package com.baidu.tieba.tracker.core.data;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0000H\u0096\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0010H&R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/tracker/core/data/IEventNode;", "Ljava/io/Serializable;", "", "next", "getNext", "()Lcom/baidu/tieba/tracker/core/data/IEventNode;", "setNext", "(Lcom/baidu/tieba/tracker/core/data/IEventNode;)V", "parent", "getParent", "compareTo", "", "other", "fillTrackParams", "", "params", "Lcom/baidu/tieba/tracker/core/data/EventParams;", "getTimeStamp", "", "getTrackParams", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface IEventNode extends Serializable, Comparable<IEventNode> {
    int compareTo(IEventNode iEventNode);

    void fillTrackParams(EventParams eventParams);

    IEventNode getNext();

    IEventNode getParent();

    long getTimeStamp();

    EventParams getTrackParams();

    void setNext(IEventNode iEventNode);

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static int a(IEventNode iEventNode, IEventNode other) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, iEventNode, other)) == null) {
                Intrinsics.checkNotNullParameter(other, "other");
                return (int) (iEventNode.getTimeStamp() - other.getTimeStamp());
            }
            return invokeLL.intValue;
        }
    }
}
