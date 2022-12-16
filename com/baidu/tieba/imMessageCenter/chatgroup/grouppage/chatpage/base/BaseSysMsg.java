package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.xg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes4.dex */
public abstract class BaseSysMsg extends BaseMsg {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("chatroom_id")
    public long roomId;
    @SerializedName("msg_type")
    public int sysMsgType;
    @SerializedName("user_from")
    public User userFrom;

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg
    @NonNull
    public CharSequence getThumbnailText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.tieba.imMessageCenter.chatgroup.grouppage.chatpage.base.BaseMsg, com.baidu.tieba.xn
    public abstract /* synthetic */ BdUniqueId getType();

    public boolean isConvertToNormalMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isNoUISysMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public BaseMsg tryCreateRecalledMsgShadow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (BaseMsg) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public static class ChatRoomInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("chatroom_view_type")
        public int chatroomViewType;
        @SerializedName("notice_url")
        public String noticeUrl;
        @SerializedName("talk_threshold_level")
        public int talkThresholdLevel;

        public ChatRoomInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int getChatroomViewType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.chatroomViewType;
            }
            return invokeV.intValue;
        }

        public String getNoticeUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.noticeUrl;
            }
            return (String) invokeV.objValue;
        }

        public int getTalkThresholdLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.talkThresholdLevel;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class User extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("uk")
        public String bduk;
        @SerializedName("forum_level")
        public int level;
        @Nullable
        @SerializedName("avatar")
        public String portrait;
        @SerializedName("identity")
        public int role;
        public String username;

        public User() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public int getLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.level;
            }
            return invokeV.intValue;
        }

        @Nullable
        public String getPortrait() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.portrait;
            }
            return (String) invokeV.objValue;
        }

        public int getRole() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.role;
            }
            return invokeV.intValue;
        }

        public long getUserId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return xg.g(BIMManager.getBdUidFromBdUK(this.bduk), 0L);
            }
            return invokeV.longValue;
        }

        public String getUsername() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.username;
            }
            return (String) invokeV.objValue;
        }
    }

    public BaseSysMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.roomId;
        }
        return invokeV.longValue;
    }

    public int getSysMsgType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.sysMsgType;
        }
        return invokeV.intValue;
    }

    public User getUserFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.userFrom;
        }
        return (User) invokeV.objValue;
    }
}
