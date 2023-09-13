package com.baidu.tieba.tracker.core.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0006HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\b\u0010\u0014\u001a\u00020\nH\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/tracker/core/data/TraceEventNode;", "Lcom/baidu/tieba/tracker/core/data/AbsEventNode;", "from", "", "scene", "type", "Lcom/baidu/tieba/tracker/core/data/TraceType;", "subPage", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tieba/tracker/core/data/TraceType;Ljava/lang/String;)V", "timestamp", "", "component1", "component2", "component3", "component4", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "getTimeStamp", TTDownloadField.TT_HASHCODE, "", "toString", "tracker"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TraceEventNode extends AbsEventNode {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String from;
    public final String scene;
    public final String subPage;
    public final long timestamp;
    public final TraceType type;

    private final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? this.from : (String) invokeV.objValue;
    }

    private final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.scene : (String) invokeV.objValue;
    }

    private final TraceType component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.type : (TraceType) invokeV.objValue;
    }

    private final String component4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) ? this.subPage : (String) invokeV.objValue;
    }

    public static /* synthetic */ TraceEventNode copy$default(TraceEventNode traceEventNode, String str, String str2, TraceType traceType, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = traceEventNode.from;
        }
        if ((i & 2) != 0) {
            str2 = traceEventNode.scene;
        }
        if ((i & 4) != 0) {
            traceType = traceEventNode.type;
        }
        if ((i & 8) != 0) {
            str3 = traceEventNode.subPage;
        }
        return traceEventNode.copy(str, str2, traceType, str3);
    }

    public final TraceEventNode copy(String from, String scene, TraceType type, String subPage) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, from, scene, type, subPage)) == null) {
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(subPage, "subPage");
            return new TraceEventNode(from, scene, type, subPage);
        }
        return (TraceEventNode) invokeLLLL.objValue;
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
                return Intrinsics.areEqual(this.from, traceEventNode.from) && Intrinsics.areEqual(this.scene, traceEventNode.scene) && this.type == traceEventNode.type && Intrinsics.areEqual(this.subPage, traceEventNode.subPage);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (((((this.from.hashCode() * 31) + this.scene.hashCode()) * 31) + this.type.hashCode()) * 31) + this.subPage.hashCode() : invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraceEventNode(String from, String scene, TraceType type, String subPage) {
        super(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {from, scene, type, subPage};
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
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subPage, "subPage");
        this.from = from;
        this.scene = scene;
        this.type = type;
        this.subPage = subPage;
        this.timestamp = System.currentTimeMillis();
        EventParams params = getParams();
        params.set("from", this.from);
        params.set("type", this.type);
        params.set("page", this.scene);
        if (this.subPage.length() == 0) {
            params.set("source", this.scene);
        } else {
            params.set("source", this.subPage);
        }
    }

    public /* synthetic */ TraceEventNode(String str, String str2, TraceType traceType, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, traceType, (i & 8) != 0 ? "" : str3);
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
