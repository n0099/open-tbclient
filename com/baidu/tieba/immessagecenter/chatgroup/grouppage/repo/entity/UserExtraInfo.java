package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/UserExtraInfo;", "Ljava/io/Serializable;", "userIdentificationConf", "Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/UserIdentificationConf;", "(Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/UserIdentificationConf;)V", "getUserIdentificationConf", "()Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/repo/entity/UserIdentificationConf;", "component1", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UserExtraInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("user_identification_conf")
    public final UserIdentificationConf userIdentificationConf;

    public static /* synthetic */ UserExtraInfo copy$default(UserExtraInfo userExtraInfo, UserIdentificationConf userIdentificationConf, int i, Object obj) {
        if ((i & 1) != 0) {
            userIdentificationConf = userExtraInfo.userIdentificationConf;
        }
        return userExtraInfo.copy(userIdentificationConf);
    }

    public final UserIdentificationConf component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.userIdentificationConf : (UserIdentificationConf) invokeV.objValue;
    }

    public final UserExtraInfo copy(UserIdentificationConf userIdentificationConf) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userIdentificationConf)) == null) {
            Intrinsics.checkNotNullParameter(userIdentificationConf, "userIdentificationConf");
            return new UserExtraInfo(userIdentificationConf);
        }
        return (UserExtraInfo) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UserExtraInfo) && Intrinsics.areEqual(this.userIdentificationConf, ((UserExtraInfo) obj).userIdentificationConf);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.userIdentificationConf.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "UserExtraInfo(userIdentificationConf=" + this.userIdentificationConf + ')';
        }
        return (String) invokeV.objValue;
    }

    public UserExtraInfo(UserIdentificationConf userIdentificationConf) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {userIdentificationConf};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(userIdentificationConf, "userIdentificationConf");
        this.userIdentificationConf = userIdentificationConf;
    }

    public final UserIdentificationConf getUserIdentificationConf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.userIdentificationConf;
        }
        return (UserIdentificationConf) invokeV.objValue;
    }
}
