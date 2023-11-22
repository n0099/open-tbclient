package com.baidu.tieba.tracker.core.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.hza;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0006HÂ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\b\u0010\u0012\u001a\u00020\tH\u0016J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/tracker/core/data/TraceEventNode;", "Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "page", "", "source", "traceType", "Lcom/baidu/tieba/tracker/core/data/TraceType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/tracker/core/data/TraceType;)V", "timestamp", "", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "getTimeStamp", "hashCode", "", "toString", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TraceEventNode extends AbsEventNode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String page;
    public final String source;
    public final long timestamp;
    public final hza traceType;

    private final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.page : (String) invokeV.objValue;
    }

    private final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.source : (String) invokeV.objValue;
    }

    private final hza component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.traceType : (hza) invokeV.objValue;
    }

    public static /* synthetic */ TraceEventNode copy$default(TraceEventNode traceEventNode, String str, String str2, hza hzaVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traceEventNode.page;
        }
        if ((i & 2) != 0) {
            str2 = traceEventNode.source;
        }
        if ((i & 4) != 0) {
            hzaVar = traceEventNode.traceType;
        }
        return traceEventNode.copy(str, str2, hzaVar);
    }

    public final TraceEventNode copy(String page, String source, hza traceType) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, page, source, traceType)) == null) {
            Intrinsics.checkNotNullParameter(page, "page");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(traceType, "traceType");
            return new TraceEventNode(page, source, traceType);
        }
        return (TraceEventNode) invokeLLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TraceEventNode) {
                TraceEventNode traceEventNode = (TraceEventNode) obj;
                return Intrinsics.areEqual(this.page, traceEventNode.page) && Intrinsics.areEqual(this.source, traceEventNode.source) && Intrinsics.areEqual(this.traceType, traceEventNode.traceType);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (((this.page.hashCode() * 31) + this.source.hashCode()) * 31) + this.traceType.hashCode() : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraceEventNode(String page, String source, hza traceType) {
        super(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {page, source, traceType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((IEventNode) objArr2[0], ((Integer) objArr2[1]).intValue(), (DefaultConstructorMarker) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(traceType, "traceType");
        this.page = page;
        this.source = source;
        this.traceType = traceType;
        this.timestamp = System.currentTimeMillis();
        EventParams params = getParams();
        params.set("type", this.traceType.a());
        params.set("page", this.page);
        if (this.source.length() == 0) {
            params.set("source", this.page);
        } else {
            params.set("source", this.source);
        }
    }

    @Override // com.baidu.tieba.tracker.core.data.IEventNode
    public long getTimeStamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.timestamp;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return getParams().toString();
        }
        return (String) invokeV.objValue;
    }
}
