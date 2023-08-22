package com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.cw5;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.emoji.data.EmojiData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.AbilityEffectItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ExcellentInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.UserExtraInfo;
import com.baidu.tieba.immessagecenter.im.dispatcher.PersonalMsgSettingDispatcher;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes6.dex */
public class CommonMsgField extends OrmObject implements Serializable, Cloneable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FROM_ANDROID = "android";
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    @cw5(deserialize = false, serialize = false)
    public AbilityEffectItem abilityEffectItem;
    @Nullable
    @SerializedName("bubble_info")
    public BubbleInfo bubbleInfo;
    public Map<String, Object> content;
    @Nullable
    @SerializedName("emoji_info")
    public List<EmojiData> emojiList;
    @Nullable
    @SerializedName("main_data")
    public List<EnableDegradeUserData> enableDegradeUserDataList;
    @Nullable
    @SerializedName("excellent_info")
    public ExcellentInfo excellentInfo;
    @SerializedName("forum_id")
    public long forumId;
    @Nullable
    public String from;
    public boolean isLocalEmojiReply;
    public boolean isLocalMsgId;
    public int level;
    @SerializedName("msg_id")
    @cw5(serialize = false)
    public long msgId;
    @SerializedName("msg_key")
    @cw5(serialize = false)
    public String msgKey;
    @cw5(serialize = false)
    public String portrait;
    @Nullable
    @SerializedName("quick_operate")
    public List<AbilityItem> quickOperate;
    @SerializedName(PersonalMsgSettingDispatcher.PERSONAL_ROBOT_ROLE)
    public int robotRole;
    public int role;
    @SerializedName("room_id")
    @cw5(serialize = false)
    public long roomId;
    @Nullable
    @SerializedName("second_data")
    public List<EnableDegradeUserData> secondDegradeUserDataList;
    @Nullable
    @SerializedName("task_info")
    @cw5(serialize = false)
    public TaskInfo taskInfo;
    public int type;
    @Nullable
    @SerializedName("user_extra_info")
    public UserExtraInfo userExtraInfo;
    @SerializedName("user_id")
    @cw5(serialize = false)
    public long userId;
    @SerializedName("user_name")
    @cw5(serialize = false)
    public String userName;
    @Nullable
    public String version;

    public CommonMsgField() {
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

    @NonNull
    public static CommonMsgField create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new CommonMsgField();
        }
        return (CommonMsgField) invokeV.objValue;
    }

    public boolean compareVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TbConfig.compareVersion(this.version);
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public AbilityEffectItem getAbilityEffectItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.abilityEffectItem;
        }
        return (AbilityEffectItem) invokeV.objValue;
    }

    @Nullable
    public BubbleInfo getBubbleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bubbleInfo;
        }
        return (BubbleInfo) invokeV.objValue;
    }

    public Map<String, Object> getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.content;
        }
        return (Map) invokeV.objValue;
    }

    @Nullable
    public List<EmojiData> getEmojiList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.emojiList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public List<EnableDegradeUserData> getEnableDegradeUserDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.enableDegradeUserDataList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public ExcellentInfo getExcellentInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.excellentInfo;
        }
        return (ExcellentInfo) invokeV.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.forumId;
        }
        return invokeV.longValue;
    }

    public int getLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.level;
        }
        return invokeV.intValue;
    }

    public long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public String getPortrait() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.portrait;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public List<AbilityItem> getQuickOperate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.quickOperate;
        }
        return (List) invokeV.objValue;
    }

    public int getRobotRole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.robotRole;
        }
        return invokeV.intValue;
    }

    public int getRole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.role;
        }
        return invokeV.intValue;
    }

    public long getRoomId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.roomId;
        }
        return invokeV.longValue;
    }

    @Nullable
    public List<EnableDegradeUserData> getSecondDegradeUserDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.secondDegradeUserDataList;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public TaskInfo getTaskInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.taskInfo;
        }
        return (TaskInfo) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    @Nullable
    public UserExtraInfo getUserExtraInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.userExtraInfo;
        }
        return (UserExtraInfo) invokeV.objValue;
    }

    public long getUserId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.userId;
        }
        return invokeV.longValue;
    }

    public String getUserName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.userName;
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return Objects.hash(this.msgKey);
        }
        return invokeV.intValue;
    }

    public boolean isLocalEmojiReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.isLocalEmojiReply;
        }
        return invokeV.booleanValue;
    }

    public boolean isLocalMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.isLocalMsgId;
        }
        return invokeV.booleanValue;
    }

    public boolean isRobot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.robotRole > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setFromAndroid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.from = "android";
        }
    }

    @Nullable
    public CommonMsgField shallowClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            try {
                return (CommonMsgField) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (CommonMsgField) invokeV.objValue;
    }

    @NonNull
    public static CommonMsgField create(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            CommonMsgField commonMsgField = new CommonMsgField();
            commonMsgField.userId = j;
            commonMsgField.roomId = j2;
            commonMsgField.msgKey = generateMsgKey(j, j2);
            return commonMsgField;
        }
        return (CommonMsgField) invokeCommon.objValue;
    }

    @NonNull
    public static String generateMsgKey(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            return BIMManager.getBdUKFromBdUid(String.valueOf(j)) + j2 + System.currentTimeMillis();
        }
        return (String) invokeCommon.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && CommonMsgField.class == obj.getClass()) {
                return Objects.equals(this.msgKey, ((CommonMsgField) obj).msgKey);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setAbilityEffectItem(@Nullable AbilityEffectItem abilityEffectItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, abilityEffectItem) == null) {
            this.abilityEffectItem = abilityEffectItem;
        }
    }

    public void setBubbleInfo(@Nullable BubbleInfo bubbleInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bubbleInfo) == null) {
            this.bubbleInfo = bubbleInfo;
        }
    }

    public void setContent(Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, map) == null) {
            this.content = map;
        }
    }

    public void setEmojiList(@Nullable List<EmojiData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            this.emojiList = list;
        }
    }

    public void setEnableDegradeUserDataList(@Nullable List<EnableDegradeUserData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            this.enableDegradeUserDataList = list;
        }
    }

    @Nullable
    public void setExcellentInfo(ExcellentInfo excellentInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, excellentInfo) == null) {
            this.excellentInfo = excellentInfo;
        }
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048609, this, j) == null) {
            this.forumId = j;
        }
    }

    public void setIsLocal(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.isLocalEmojiReply = z;
        }
    }

    public void setLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.level = i;
        }
    }

    public void setLocalMsgId(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.isLocalMsgId = z;
        }
    }

    public void setMsgId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048614, this, j) == null) {
            this.msgId = j;
        }
    }

    public void setMsgKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.msgKey = str;
        }
    }

    public void setPortrait(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.portrait = str;
        }
    }

    public void setRobotRole(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.robotRole = i;
        }
    }

    public void setRole(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.role = i;
        }
    }

    public void setRoomId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048619, this, j) == null) {
            this.roomId = j;
        }
    }

    public void setSecondDegradeUserDataList(@Nullable List<EnableDegradeUserData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, list) == null) {
            this.secondDegradeUserDataList = list;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i) == null) {
            this.type = i;
        }
    }

    public void setUserId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048622, this, j) == null) {
            this.userId = j;
        }
    }

    public void setUserName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.userName = str;
        }
    }
}
