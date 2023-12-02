package com.baidu.tieba.impersonal.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.ot5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/impersonal/data/Extra;", "Ljava/io/Serializable;", "msgSugInfo", "Lcom/baidu/tieba/impersonal/data/Extra$MsgSugInfo;", "(Lcom/baidu/tieba/impersonal/data/Extra$MsgSugInfo;)V", "getMsgSugInfo", "()Lcom/baidu/tieba/impersonal/data/Extra$MsgSugInfo;", "setMsgSugInfo", "component1", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "MsgSugInfo", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Extra implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("msg_sug_info")
    @ot5(serialize = false)
    public MsgSugInfo msgSugInfo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Extra() {
        this(null, 1, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((MsgSugInfo) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static /* synthetic */ Extra copy$default(Extra extra, MsgSugInfo msgSugInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            msgSugInfo = extra.msgSugInfo;
        }
        return extra.copy(msgSugInfo);
    }

    public final MsgSugInfo component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msgSugInfo : (MsgSugInfo) invokeV.objValue;
    }

    public final Extra copy(MsgSugInfo msgSugInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msgSugInfo)) == null) ? new Extra(msgSugInfo) : (Extra) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Extra) && Intrinsics.areEqual(this.msgSugInfo, ((Extra) obj).msgSugInfo);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MsgSugInfo msgSugInfo = this.msgSugInfo;
            if (msgSugInfo == null) {
                return 0;
            }
            return msgSugInfo.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "Extra(msgSugInfo=" + this.msgSugInfo + ')';
        }
        return (String) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/baidu/tieba/impersonal/data/Extra$MsgSugInfo;", "Ljava/io/Serializable;", "msgSugAbilityItems", "", "Lcom/baidu/tieba/im/lib/socket/msg/data/AbilityItem;", "(Ljava/util/List;)V", "getMsgSugAbilityItems", "()Ljava/util/List;", "setMsgSugAbilityItems", "component1", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class MsgSugInfo implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("sug_list")
        @ot5(serialize = false)
        public List<AbilityItem> msgSugAbilityItems;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MsgSugInfo() {
            this(null, 1, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((List) objArr[0], ((Integer) objArr[1]).intValue(), (DefaultConstructorMarker) objArr[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.impersonal.data.Extra$MsgSugInfo */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MsgSugInfo copy$default(MsgSugInfo msgSugInfo, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = msgSugInfo.msgSugAbilityItems;
            }
            return msgSugInfo.copy(list);
        }

        public final List<AbilityItem> component1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.msgSugAbilityItems : (List) invokeV.objValue;
        }

        public final MsgSugInfo copy(List<AbilityItem> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) ? new MsgSugInfo(list) : (MsgSugInfo) invokeL.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof MsgSugInfo) && Intrinsics.areEqual(this.msgSugAbilityItems, ((MsgSugInfo) obj).msgSugAbilityItems);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<AbilityItem> list = this.msgSugAbilityItems;
                if (list == null) {
                    return 0;
                }
                return list.hashCode();
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "MsgSugInfo(msgSugAbilityItems=" + this.msgSugAbilityItems + ')';
            }
            return (String) invokeV.objValue;
        }

        public MsgSugInfo(List<AbilityItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.msgSugAbilityItems = list;
        }

        public final void setMsgSugAbilityItems(List<AbilityItem> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                this.msgSugAbilityItems = list;
            }
        }

        public /* synthetic */ MsgSugInfo(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<AbilityItem> getMsgSugAbilityItems() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.msgSugAbilityItems;
            }
            return (List) invokeV.objValue;
        }
    }

    public Extra(MsgSugInfo msgSugInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msgSugInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.msgSugInfo = msgSugInfo;
    }

    public final void setMsgSugInfo(MsgSugInfo msgSugInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, msgSugInfo) == null) {
            this.msgSugInfo = msgSugInfo;
        }
    }

    public /* synthetic */ Extra(MsgSugInfo msgSugInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : msgSugInfo);
    }

    public final MsgSugInfo getMsgSugInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.msgSugInfo;
        }
        return (MsgSugInfo) invokeV.objValue;
    }
}
