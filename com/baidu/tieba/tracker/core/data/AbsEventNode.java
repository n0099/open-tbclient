package com.baidu.tieba.tracker.core.data;

import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.tracker.core.data.IEventNode;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0017J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\b\u0010\u0017\u001a\u00020\nH\u0016J\u001b\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0086\u0002J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001b\u0010\t\u001a\u00020\n8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "Lcom/baidu/tieba/tracker/core/data/IEventNode;", "Ljava/io/Serializable;", "parent", "(Lcom/baidu/tieba/tracker/core/data/IEventNode;)V", "next", "getNext", "()Lcom/baidu/tieba/tracker/core/data/IEventNode;", "setNext", "params", "Lcom/baidu/tieba/tracker/core/data/EventParams;", "getParams", "()Lcom/baidu/tieba/tracker/core/data/EventParams;", "params$delegate", "Lkotlin/Lazy;", "getParent", "fillTrackParams", "", CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, "", "key", "", "default", "getTrackParams", "set", "value", "setIfNull", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class AbsEventNode implements IEventNode, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IEventNode next;
    public final Lazy params$delegate;
    public final IEventNode parent;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbsEventNode() {
        this(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((IEventNode) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AbsEventNode(IEventNode iEventNode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iEventNode};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.parent = iEventNode;
        this.params$delegate = LazyKt__LazyJVMKt.lazy(AbsEventNode$params$2.INSTANCE);
    }

    public /* synthetic */ AbsEventNode(IEventNode iEventNode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iEventNode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public int compareTo(IEventNode iEventNode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iEventNode)) == null) {
            return IEventNode.a.a(this, iEventNode);
        }
        return invokeL.intValue;
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    @CallSuper
    public void fillTrackParams(EventParams eventParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eventParams) == null) {
            getParams().merge(eventParams);
        }
    }

    public final Object get(String key) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, key)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            return getParams().get(key);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    public void setNext(IEventNode iEventNode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iEventNode) == null) {
            this.next = iEventNode;
        }
    }

    public final Object get(String key, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, key, str)) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            return getParams().get(key, str);
        }
        return invokeLL.objValue;
    }

    public final void set(String key, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, key, obj) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            getParams().set(key, obj);
        }
    }

    public final void setIfNull(String key, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, key, obj) == null) {
            Intrinsics.checkNotNullParameter(key, "key");
            getParams().setIfNull(key, obj);
        }
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    public IEventNode getEndNode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return IEventNode.a.b(this);
        }
        return (IEventNode) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    public IEventNode getNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.next;
        }
        return (IEventNode) invokeV.objValue;
    }

    public final EventParams getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (EventParams) this.params$delegate.getValue();
        }
        return (EventParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    public IEventNode getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.parent;
        }
        return (IEventNode) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    public EventParams getTrackParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getParams();
        }
        return (EventParams) invokeV.objValue;
    }
}
