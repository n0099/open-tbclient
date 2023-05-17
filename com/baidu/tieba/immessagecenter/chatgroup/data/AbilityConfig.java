package com.baidu.tieba.immessagecenter.chatgroup.data;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.utils.EmotionUbcHelper;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes6.dex */
public class AbilityConfig implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("content")
    public AbilityConfContent abilityConfContent;
    @SerializedName("bot_id")
    public int botId;
    @SerializedName(TbEnum.ChatInputStatus.INPUT_STATUS_TEXT)
    public String inputText;
    @SerializedName("is_at")
    public int isAt;
    @SerializedName("is_reply")
    public int isReply;
    @SerializedName(BigdayActivityConfig.JUMP_URL)
    public String jumpUrl;
    @SerializedName("skill_id")
    public int skillId;
    @SerializedName("type")
    public int type;

    /* loaded from: classes6.dex */
    public static class AbilityConfContent extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("big_size")
        public String bigSize;
        @SerializedName("big_src")
        public String bigSrc;
        @SerializedName("bsize")
        public String bsize;
        @SerializedName("emoticon_content")
        public EmoticonContent emoticonContent;
        @SerializedName("robot_params")
        public Map<String, Object> robotParams;
        @SerializedName("src")
        public String src;
        @SerializedName("text")
        public String text;

        /* loaded from: classes6.dex */
        public static class EmoticonContent extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName(EmotionUbcHelper.MEME_ID)
            public String memeId;
            @SerializedName("meme_type")
            public String memeType;

            public EmoticonContent() {
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

            public String getMemeId() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.memeId;
                }
                return (String) invokeV.objValue;
            }

            public String getMemeType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.memeType;
                }
                return (String) invokeV.objValue;
            }

            public void setMemeId(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                    this.memeId = str;
                }
            }

            public void setMemeType(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                    this.memeType = str;
                }
            }
        }

        public AbilityConfContent() {
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

        public String getBigSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.bigSize;
            }
            return (String) invokeV.objValue;
        }

        public String getBigSrc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.bigSrc;
            }
            return (String) invokeV.objValue;
        }

        public String getBsize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.bsize;
            }
            return (String) invokeV.objValue;
        }

        public EmoticonContent getEmoticonContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.emoticonContent;
            }
            return (EmoticonContent) invokeV.objValue;
        }

        @Nullable
        public Map<String, Object> getRobotParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.robotParams;
            }
            return (Map) invokeV.objValue;
        }

        public String getSrc() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.src;
            }
            return (String) invokeV.objValue;
        }

        public String getText() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.text;
            }
            return (String) invokeV.objValue;
        }

        public void setBigSize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.bigSize = str;
            }
        }

        public void setBigSrc(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                this.bigSrc = str;
            }
        }

        public void setBsize(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.bsize = str;
            }
        }

        public void setEmoticonContent(EmoticonContent emoticonContent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, emoticonContent) == null) {
                this.emoticonContent = emoticonContent;
            }
        }

        public void setRobotParams(@Nullable Map<String, Object> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048587, this, map) == null) {
                this.robotParams = map;
            }
        }

        public void setSrc(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
                this.src = str;
            }
        }

        public void setText(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                this.text = str;
            }
        }
    }

    public AbilityConfig() {
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

    public AbilityConfContent getAbilityConfContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.abilityConfContent;
        }
        return (AbilityConfContent) invokeV.objValue;
    }

    public int getBotId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.botId;
        }
        return invokeV.intValue;
    }

    public String getInputText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.inputText;
        }
        return (String) invokeV.objValue;
    }

    public int getIsAt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.isAt;
        }
        return invokeV.intValue;
    }

    public int getIsReply() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.isReply;
        }
        return invokeV.intValue;
    }

    public String getJumpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.jumpUrl;
        }
        return (String) invokeV.objValue;
    }

    public int getSkillId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.skillId;
        }
        return invokeV.intValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.type;
        }
        return invokeV.intValue;
    }

    public void setAbilityConfContent(AbilityConfContent abilityConfContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, abilityConfContent) == null) {
            this.abilityConfContent = abilityConfContent;
        }
    }

    public void setBotId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.botId = i;
        }
    }

    public void setInputText(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.inputText = str;
        }
    }

    public void setIsAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.isAt = i;
        }
    }

    public void setIsReply(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.isReply = i;
        }
    }

    public void setJumpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.jumpUrl = str;
        }
    }

    public void setSkillId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.skillId = i;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.type = i;
        }
    }
}
