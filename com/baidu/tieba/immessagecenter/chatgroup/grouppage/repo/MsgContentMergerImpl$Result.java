package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J9\u0010\r\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/MsgContentMergerImpl$Result;", "Ljava/io/Serializable;", "userInfo", "", "", "", "msgInfo", "(Ljava/util/Map;Ljava/util/Map;)V", "getMsgInfo", "()Ljava/util/Map;", "getUserInfo", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", TTDownloadField.TT_HASHCODE, "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MsgContentMergerImpl$Result implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("msg_info")
    public final Map<String, Object> msgInfo;
    @SerializedName(SourceConstant.SOURCE_USER_INFO)
    public final Map<String, Object> userInfo;

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.MsgContentMergerImpl$Result */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MsgContentMergerImpl$Result copy$default(MsgContentMergerImpl$Result msgContentMergerImpl$Result, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = msgContentMergerImpl$Result.userInfo;
        }
        if ((i & 2) != 0) {
            map2 = msgContentMergerImpl$Result.msgInfo;
        }
        return msgContentMergerImpl$Result.copy(map, map2);
    }

    public final Map<String, Object> component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.userInfo : (Map) invokeV.objValue;
    }

    public final Map<String, Object> component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.msgInfo : (Map) invokeV.objValue;
    }

    public final MsgContentMergerImpl$Result copy(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, map2)) == null) ? new MsgContentMergerImpl$Result(map, map2) : (MsgContentMergerImpl$Result) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MsgContentMergerImpl$Result) {
                MsgContentMergerImpl$Result msgContentMergerImpl$Result = (MsgContentMergerImpl$Result) obj;
                return Intrinsics.areEqual(this.userInfo, msgContentMergerImpl$Result.userInfo) && Intrinsics.areEqual(this.msgInfo, msgContentMergerImpl$Result.msgInfo);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Map<String, Object> map = this.userInfo;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            Map<String, Object> map2 = this.msgInfo;
            return hashCode + (map2 != null ? map2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "Result(userInfo=" + this.userInfo + ", msgInfo=" + this.msgInfo + ')';
        }
        return (String) invokeV.objValue;
    }

    public MsgContentMergerImpl$Result(Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map, map2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.userInfo = map;
        this.msgInfo = map2;
    }

    public final Map<String, Object> getMsgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.msgInfo;
        }
        return (Map) invokeV.objValue;
    }

    public final Map<String, Object> getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.userInfo;
        }
        return (Map) invokeV.objValue;
    }
}
