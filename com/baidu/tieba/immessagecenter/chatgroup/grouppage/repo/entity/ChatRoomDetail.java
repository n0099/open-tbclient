package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.constants.ARConfigKey;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class ChatRoomDetail extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("at_info")
    public AtInfo atInfo;
    @SerializedName("basic_info")
    public BasicInfo basicInfo;
    @SerializedName("bots")
    public BotsDTO bots;
    @SerializedName(ARConfigKey.EXTRA_INFO)
    public ExtraInfo extraInfo;
    @SerializedName("is_jump_h5")
    public int isJumpH5;
    @SerializedName("jump_h5_err_url")
    public String jumpH5ErrUrl;
    @SerializedName("text_is_show")
    public int shouldUseServerText;
    @SerializedName("show_text")
    public String showText;
    @SerializedName("user_info")
    public UserInfo userInfo;

    /* loaded from: classes5.dex */
    public static class BasicInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String avatar;
        @SerializedName("discuss_num")
        public long discussNum;
        @SerializedName("forum_id")
        public long forumId;
        @SerializedName("forum_name")
        public String forumName;
        @SerializedName("group_id")
        public long groupId;
        public long id;
        public String name;

        public BasicInfo() {
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

        public String getAvatar() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.avatar;
            }
            return (String) invokeV.objValue;
        }

        public long getDiscussNum() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.discussNum;
            }
            return invokeV.longValue;
        }

        public long getForumId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.forumId;
            }
            return invokeV.longValue;
        }

        public String getForumName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.forumName;
            }
            return (String) invokeV.objValue;
        }

        public long getGroupId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.groupId;
            }
            return invokeV.longValue;
        }

        public long getId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.id;
            }
            return invokeV.longValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.name;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class ExtraInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int ONLY_MANAGER_CAN_TALK = 1;
        public transient /* synthetic */ FieldHolder $fh;
        public String announce;
        @SerializedName("chatroom_view_type")
        public int chatroomViewType;
        @SerializedName("forum_entrance_close_type")
        public int forumEntranceCloseType;
        @SerializedName("forum_entrance_switch")
        public int forumEntranceSwitch;
        @SerializedName("is_freezing")
        public int isFreezing;
        @SerializedName("is_talk_banned")
        public int isTalkBanned;
        @SerializedName("talk_threshold_level")
        public int talkThresholdLevel;
        @SerializedName("talk_type")
        public int talkType;

        public ExtraInfo() {
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

        public int getIsFreezing() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.isFreezing;
            }
            return invokeV.intValue;
        }

        public int getIsTalkBanned() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.isTalkBanned;
            }
            return invokeV.intValue;
        }

        public int getTalkThresholdLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.talkThresholdLevel;
            }
            return invokeV.intValue;
        }

        public int getTalkType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.talkType;
            }
            return invokeV.intValue;
        }

        public void setIsFreezing(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.isFreezing = i;
            }
        }

        public void setIsTalkBanned(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.isTalkBanned = i;
            }
        }

        public void setTalkThresholdLevel(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                this.talkThresholdLevel = i;
            }
        }

        public void setTalkType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
                this.talkType = i;
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("cannot_talk_text")
        public String cannotTalkText;
        @SerializedName("forum_level")
        public int forumLevel;
        @SerializedName("identity_role")
        public int identityRole;
        @SerializedName("is_been_talk_banned")
        public int isBeenTalkBanned;
        @SerializedName("is_can_talk")
        public int isCanTalk;
        @SerializedName("is_can_view_chatroom")
        public int isCanViewChatroom;
        @SerializedName("is_subscription")
        public int isSubscription;

        public UserInfo() {
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

        public String getCannotTalkText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.cannotTalkText;
            }
            return (String) invokeV.objValue;
        }

        public int getForumLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.forumLevel;
            }
            return invokeV.intValue;
        }

        public int getIdentityRole() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.identityRole;
            }
            return invokeV.intValue;
        }

        public int getIsBeenTalkBanned() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.isBeenTalkBanned;
            }
            return invokeV.intValue;
        }

        public int getIsCanTalk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.isCanTalk;
            }
            return invokeV.intValue;
        }

        public int getIsCanViewChatroom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.isCanViewChatroom;
            }
            return invokeV.intValue;
        }

        public int getIsSubscription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.isSubscription;
            }
            return invokeV.intValue;
        }

        public boolean isSubscription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.isSubscription == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void setIsBeenTalkBanned(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
                this.isBeenTalkBanned = i;
            }
        }
    }

    public ChatRoomDetail() {
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

    @Nullable
    public AtInfo getAtInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.atInfo;
        }
        return (AtInfo) invokeV.objValue;
    }

    public BasicInfo getBasicInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.basicInfo;
        }
        return (BasicInfo) invokeV.objValue;
    }

    public BotsDTO getBots() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bots;
        }
        return (BotsDTO) invokeV.objValue;
    }

    public ExtraInfo getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.extraInfo;
        }
        return (ExtraInfo) invokeV.objValue;
    }

    public String getJumpH5ErrUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.jumpH5ErrUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getShouldUseServerText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.shouldUseServerText;
        }
        return invokeV.intValue;
    }

    public String getShowText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.showText;
        }
        return (String) invokeV.objValue;
    }

    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.userInfo;
        }
        return (UserInfo) invokeV.objValue;
    }

    public boolean isJumpH5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.isJumpH5 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAtInfo(AtInfo atInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, atInfo) == null) {
            this.atInfo = atInfo;
        }
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, basicInfo) == null) {
            this.basicInfo = basicInfo;
        }
    }

    public void setBots(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, botsDTO) == null) {
            this.bots = botsDTO;
        }
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, extraInfo) == null) {
            this.extraInfo = extraInfo;
        }
    }

    public void setJumpH5ErrUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.jumpH5ErrUrl = str;
        }
    }

    public void setShouldUseServerText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.shouldUseServerText = i;
        }
    }

    public void setShowText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.showText = str;
        }
    }

    public void setUserInfo(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, userInfo) == null) {
            this.userInfo = userInfo;
        }
    }
}
