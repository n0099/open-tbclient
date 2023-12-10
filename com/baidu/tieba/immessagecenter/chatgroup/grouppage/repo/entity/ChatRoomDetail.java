package com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.searchbox.download.unified.SourceConstant;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.tieba.im.lib.socket.msg.data.BubbleInfo;
import com.baidu.tieba.im.lib.socket.msg.data.EnableDegradeUserData;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.tieba.im.lib.socket.msg.data.TopBubbleData;
import com.baidu.tieba.immessagecenter.chatgroup.data.AtInfo;
import com.baidu.tieba.immessagecenter.chatgroup.data.ReplyEmojiMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.bubble.topbubble.ChatActivityInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.ChatConf;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.effect.ChatResource;
import com.baidu.tieba.xv8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes6.dex */
public class ChatRoomDetail extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("at_info")
    public AtInfo atInfo;
    @SerializedName("basic_info")
    public BasicInfo basicInfo;
    @SerializedName("bots")
    public BotsDTO bots;
    @SerializedName("perms")
    public CanExcellent canExcellent;
    @SerializedName("activity_info")
    public ChatActivityInfo chatActivityInfo;
    @SerializedName("top_bubble_list")
    public List<TopBubbleData> chatBubbleData;
    @Nullable
    @SerializedName("conf")
    public ChatConf chatConf;
    @SerializedName("extra_info")
    public ExtraInfo extraInfo;
    @Nullable
    @SerializedName("forbidden_toast")
    public String forbiddenContent;
    @SerializedName(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE)
    public ChatResource groupChatResource;
    @Nullable
    @SerializedName("input_text_list")
    public List<String> inputTipsList;
    @SerializedName("is_jump_h5")
    public int isJumpH5;
    @SerializedName("jump_h5_err_url")
    public String jumpH5ErrUrl;
    @SerializedName("long_press_msg_button")
    public List<AbilityItem> longPressMsgBtn;
    @Nullable
    @SerializedName("mask_info")
    public List<xv8> maskInfoList;
    public String prologue;
    @Nullable
    @SerializedName("quick_talk")
    public List<AbilityItem> quickTalk;
    @Nullable
    @SerializedName("reaction_list")
    public List<Reaction> reactions;
    @SerializedName("reaction_info")
    public ReplyEmojiMsgInfo replyEmojiMsgInfo;
    @SerializedName("text_is_show")
    public int shouldUseServerText;
    @SerializedName("show_text")
    public String showText;
    @SerializedName("has_chated")
    public int todayChatMsgCount;
    @SerializedName(SourceConstant.SOURCE_USER_INFO)
    public UserInfo userInfo;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class ExtraInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BANNED = 1;
        public static final int FREEZING = 1;
        public static final int ONLY_MANAGER_CAN_TALK = 1;
        public static final int UNBANNED = 0;
        public static final int UNFREEZING = 0;
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

    /* loaded from: classes6.dex */
    public static class UserInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BANNED = 1;
        public static final int UNBANNED = 0;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("ban_all_forum_toast")
        public String banAllForumToast;
        @SerializedName("bazhu_type")
        public int bazhuType;
        @Nullable
        @SerializedName("bubble_info")
        public BubbleInfo bubbleInfo;
        @SerializedName("cannot_talk_text")
        public String cannotTalkText;
        @Nullable
        @SerializedName("main_data")
        public List<EnableDegradeUserData> enableDegradeUserDataList;
        @SerializedName("forum_level")
        public int forumLevel;
        @SerializedName("identity_role")
        public int identityRole;
        @SerializedName("is_been_talk_banned")
        public int isBeenTalkBanned;
        @SerializedName("is_can_reaction")
        public int isCanReaction;
        @SerializedName("is_can_talk")
        public int isCanTalk;
        @SerializedName("is_can_view_chatroom")
        public int isCanViewChatroom;
        @SerializedName("is_subscription")
        public int isSubscription;
        @Nullable
        @SerializedName("second_data")
        public List<EnableDegradeUserData> secondDegradeUserDataList;

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

        public int getBaZhuType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.bazhuType;
            }
            return invokeV.intValue;
        }

        public String getBanAllForumContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.banAllForumToast;
            }
            return (String) invokeV.objValue;
        }

        @Nullable
        public BubbleInfo getBubbleInfo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.bubbleInfo;
            }
            return (BubbleInfo) invokeV.objValue;
        }

        public String getCannotTalkText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.cannotTalkText;
            }
            return (String) invokeV.objValue;
        }

        @Nullable
        public List<EnableDegradeUserData> getEnableDegradeUserDataList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.enableDegradeUserDataList;
            }
            return (List) invokeV.objValue;
        }

        public int getForumLevel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.forumLevel;
            }
            return invokeV.intValue;
        }

        public int getIdentityRole() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.identityRole;
            }
            return invokeV.intValue;
        }

        public int getIsBeenTalkBanned() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.isBeenTalkBanned;
            }
            return invokeV.intValue;
        }

        public int getIsCanTalk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.isCanTalk;
            }
            return invokeV.intValue;
        }

        public int getIsCanViewChatroom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.isCanViewChatroom;
            }
            return invokeV.intValue;
        }

        public int getIsSubscription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.isSubscription;
            }
            return invokeV.intValue;
        }

        @Nullable
        public List<EnableDegradeUserData> getSecondDegradeUserDataList() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.secondDegradeUserDataList;
            }
            return (List) invokeV.objValue;
        }

        public boolean isCanReaction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.isCanReaction == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean isSubscription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (this.isSubscription == 1) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void setBubbleInfo(BubbleInfo bubbleInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048590, this, bubbleInfo) == null) {
                this.bubbleInfo = bubbleInfo;
            }
        }

        public void setIsBeenTalkBanned(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
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

    public CanExcellent getCanExcellent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.canExcellent;
        }
        return (CanExcellent) invokeV.objValue;
    }

    public List<TopBubbleData> getChatBubbleData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.chatBubbleData;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public ChatConf getChatConf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.chatConf;
        }
        return (ChatConf) invokeV.objValue;
    }

    public ExtraInfo getExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.extraInfo;
        }
        return (ExtraInfo) invokeV.objValue;
    }

    @Nullable
    public String getForbiddenContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.forbiddenContent;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public ChatResource getGroupChatResource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.groupChatResource;
        }
        return (ChatResource) invokeV.objValue;
    }

    @Nullable
    public List<String> getInputTipsList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.inputTipsList;
        }
        return (List) invokeV.objValue;
    }

    public String getJumpH5ErrUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.jumpH5ErrUrl;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<AbilityItem> getLongPressMsgBtn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.longPressMsgBtn;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public List<xv8> getMaskInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.maskInfoList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public String getPrologue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.prologue;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<AbilityItem> getQuickTalk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.quickTalk;
        }
        return (List) invokeV.objValue;
    }

    public List<Reaction> getReactions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.reactions;
        }
        return (List) invokeV.objValue;
    }

    public ReplyEmojiMsgInfo getReplyEmojiMsgInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.replyEmojiMsgInfo;
        }
        return (ReplyEmojiMsgInfo) invokeV.objValue;
    }

    public int getShouldUseServerText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.shouldUseServerText;
        }
        return invokeV.intValue;
    }

    public String getShowText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.showText;
        }
        return (String) invokeV.objValue;
    }

    public int getTodayChatMsgCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.todayChatMsgCount;
        }
        return invokeV.intValue;
    }

    public UserInfo getUserInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.userInfo;
        }
        return (UserInfo) invokeV.objValue;
    }

    public boolean isJumpH5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.isJumpH5 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAtInfo(AtInfo atInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, atInfo) == null) {
            this.atInfo = atInfo;
        }
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, basicInfo) == null) {
            this.basicInfo = basicInfo;
        }
    }

    public void setBots(BotsDTO botsDTO) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, botsDTO) == null) {
            this.bots = botsDTO;
        }
    }

    public void setChatBubbleData(List<TopBubbleData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, list) == null) {
            this.chatBubbleData = list;
        }
    }

    public void setExtraInfo(ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, extraInfo) == null) {
            this.extraInfo = extraInfo;
        }
    }

    public void setGroupChatResource(ChatResource chatResource) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, chatResource) == null) {
            this.groupChatResource = chatResource;
        }
    }

    public void setJumpH5ErrUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.jumpH5ErrUrl = str;
        }
    }

    public void setShouldUseServerText(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.shouldUseServerText = i;
        }
    }

    public void setShowText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.showText = str;
        }
    }

    public void setTodayChatMsgCount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.todayChatMsgCount = i;
        }
    }

    public void setUserInfo(UserInfo userInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, userInfo) == null) {
            this.userInfo = userInfo;
        }
    }
}
