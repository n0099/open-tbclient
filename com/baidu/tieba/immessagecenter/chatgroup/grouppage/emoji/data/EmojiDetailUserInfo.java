package com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/immessagecenter/chatgroup/grouppage/emoji/data/EmojiDetailUserInfo;", "Ljava/io/Serializable;", TbEnum.SystemMessage.KEY_USER_NAME, "", "uk", "portrait", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPortrait", "()Ljava/lang/String;", "getUk", "getUserName", "component1", "component2", "component3", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "", "hashCode", "", "toString", "imMessageCenter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmojiDetailUserInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String portrait;
    public final String uk;
    @SerializedName("user_name")
    public final String userName;

    public static /* synthetic */ EmojiDetailUserInfo copy$default(EmojiDetailUserInfo emojiDetailUserInfo, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiDetailUserInfo.userName;
        }
        if ((i & 2) != 0) {
            str2 = emojiDetailUserInfo.uk;
        }
        if ((i & 4) != 0) {
            str3 = emojiDetailUserInfo.portrait;
        }
        return emojiDetailUserInfo.copy(str, str2, str3);
    }

    public final String component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.userName : (String) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.uk : (String) invokeV.objValue;
    }

    public final String component3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.portrait : (String) invokeV.objValue;
    }

    public final EmojiDetailUserInfo copy(String userName, String uk, String portrait) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, userName, uk, portrait)) == null) {
            Intrinsics.checkNotNullParameter(userName, "userName");
            Intrinsics.checkNotNullParameter(uk, "uk");
            Intrinsics.checkNotNullParameter(portrait, "portrait");
            return new EmojiDetailUserInfo(userName, uk, portrait);
        }
        return (EmojiDetailUserInfo) invokeLLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EmojiDetailUserInfo) {
                EmojiDetailUserInfo emojiDetailUserInfo = (EmojiDetailUserInfo) obj;
                return Intrinsics.areEqual(this.userName, emojiDetailUserInfo.userName) && Intrinsics.areEqual(this.uk, emojiDetailUserInfo.uk) && Intrinsics.areEqual(this.portrait, emojiDetailUserInfo.portrait);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((this.userName.hashCode() * 31) + this.uk.hashCode()) * 31) + this.portrait.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "EmojiDetailUserInfo(userName=" + this.userName + ", uk=" + this.uk + ", portrait=" + this.portrait + ')';
        }
        return (String) invokeV.objValue;
    }

    public EmojiDetailUserInfo(String userName, String uk, String portrait) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {userName, uk, portrait};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(uk, "uk");
        Intrinsics.checkNotNullParameter(portrait, "portrait");
        this.userName = userName;
        this.uk = uk;
        this.portrait = portrait;
    }

    public final String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    public final String getUk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.uk;
        }
        return (String) invokeV.objValue;
    }

    public final String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }
}
