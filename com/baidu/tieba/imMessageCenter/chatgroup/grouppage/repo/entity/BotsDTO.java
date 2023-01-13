package com.baidu.tieba.imMessageCenter.chatgroup.grouppage.repo.entity;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class BotsDTO extends OrmObject implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -313586391413374981L;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("bot_list")
    public List<BotListDTO> botList;
    @SerializedName("guide")
    public String guide;

    /* loaded from: classes4.dex */
    public static class BotListDTO extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @SerializedName("at_guide")
        public String atGuide;
        @SerializedName("guide")
        public String guide;
        @SerializedName("scene")
        public String scene;
        @SerializedName("skill")
        public List<SkillDTO> skill;
        @SerializedName("user")
        public UserDTO user;

        /* loaded from: classes4.dex */
        public static class SkillDTO extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic = null;
            public static final long serialVersionUID = -757491177728675334L;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("alias")
            public String alias;
            @SerializedName(ShareCallPacking.StatModel.KEY_CALL_TYPE)
            public int callType;
            @SerializedName("desc")
            public String desc;
            @SerializedName("exec")
            public int exec;
            @SerializedName("exp")
            public String exp;
            @SerializedName("items")
            public List<ItemsDTO> items;
            @SerializedName(IntentConfig.SHOW_KEYBOARD)
            public int keyboard;
            @SerializedName("name")
            public String name;
            @SerializedName("sub_skill")
            public List<SkillDTO> subSkill;
            @SerializedName("type")
            public int type;

            /* loaded from: classes4.dex */
            public static class ItemsDTO extends OrmObject implements Serializable {
                public static /* synthetic */ Interceptable $ic = null;
                public static final long serialVersionUID = -5238062091986617562L;
                public transient /* synthetic */ FieldHolder $fh;
                @SerializedName("name")
                public String name;
                @SerializedName("opts")
                public List<OptsDTO> opts;
                @SerializedName("value")
                public String value;

                /* loaded from: classes4.dex */
                public static class OptsDTO extends OrmObject implements Serializable {
                    public static /* synthetic */ Interceptable $ic = null;
                    public static final long serialVersionUID = 4936592687580444738L;
                    public transient /* synthetic */ FieldHolder $fh;
                    @SerializedName("default")
                    public int defaultX;
                    @SerializedName("name")
                    public String name;

                    public OptsDTO() {
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

                    public OptsDTO copy() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                            OptsDTO optsDTO = new OptsDTO();
                            optsDTO.defaultX = this.defaultX;
                            optsDTO.name = this.name;
                            return optsDTO;
                        }
                        return (OptsDTO) invokeV.objValue;
                    }

                    public int getDefaultX() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                            return this.defaultX;
                        }
                        return invokeV.intValue;
                    }

                    public String getName() {
                        InterceptResult invokeV;
                        Interceptable interceptable = $ic;
                        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            return this.name;
                        }
                        return (String) invokeV.objValue;
                    }

                    public void setDefaultX(int i) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                            this.defaultX = i;
                        }
                    }

                    public void setName(String str) {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                            this.name = str;
                        }
                    }
                }

                public ItemsDTO() {
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

                public String getName() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        return this.name;
                    }
                    return (String) invokeV.objValue;
                }

                @Nullable
                public List<OptsDTO> getOpts() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return this.opts;
                    }
                    return (List) invokeV.objValue;
                }

                public String getValue() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                        return this.value;
                    }
                    return (String) invokeV.objValue;
                }

                public ItemsDTO copy() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                        ItemsDTO itemsDTO = new ItemsDTO();
                        itemsDTO.name = this.name;
                        itemsDTO.value = this.value;
                        if (!ListUtils.isEmpty(this.opts)) {
                            itemsDTO.opts = new ArrayList();
                            for (OptsDTO optsDTO : this.opts) {
                                itemsDTO.opts.add(optsDTO.copy());
                            }
                        }
                        return itemsDTO;
                    }
                    return (ItemsDTO) invokeV.objValue;
                }

                public void setName(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                        this.name = str;
                    }
                }

                public void setOpts(List<OptsDTO> list) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
                        this.opts = list;
                    }
                }

                public void setValue(String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                        this.value = str;
                    }
                }
            }

            public SkillDTO() {
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

            public String getAlias() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.alias;
                }
                return (String) invokeV.objValue;
            }

            public int getCallType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.callType;
                }
                return invokeV.intValue;
            }

            public String getDesc() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.desc;
                }
                return (String) invokeV.objValue;
            }

            public int getExec() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.exec;
                }
                return invokeV.intValue;
            }

            public String getExp() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.exp;
                }
                return (String) invokeV.objValue;
            }

            @Nullable
            public List<ItemsDTO> getItems() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    return this.items;
                }
                return (List) invokeV.objValue;
            }

            public int getKeyboard() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    return this.keyboard;
                }
                return invokeV.intValue;
            }

            public String getName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return this.name;
                }
                return (String) invokeV.objValue;
            }

            @Nullable
            public List<SkillDTO> getSubSkill() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                    return this.subSkill;
                }
                return (List) invokeV.objValue;
            }

            public int getType() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                    return this.type;
                }
                return invokeV.intValue;
            }

            public SkillDTO copy() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    SkillDTO skillDTO = new SkillDTO();
                    skillDTO.type = this.type;
                    skillDTO.name = this.name;
                    skillDTO.alias = this.alias;
                    skillDTO.desc = this.desc;
                    skillDTO.exp = this.exp;
                    skillDTO.exec = this.exec;
                    skillDTO.callType = this.callType;
                    skillDTO.keyboard = this.keyboard;
                    if (!ListUtils.isEmpty(this.items)) {
                        skillDTO.items = new ArrayList();
                        for (ItemsDTO itemsDTO : this.items) {
                            skillDTO.items.add(itemsDTO.copy());
                        }
                    }
                    if (!ListUtils.isEmpty(this.subSkill)) {
                        skillDTO.subSkill = new ArrayList();
                        for (SkillDTO skillDTO2 : this.subSkill) {
                            skillDTO.subSkill.add(skillDTO2.copy());
                        }
                    }
                    return skillDTO;
                }
                return (SkillDTO) invokeV.objValue;
            }

            public void setAlias(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                    this.alias = str;
                }
            }

            public void setCallType(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                    this.callType = i;
                }
            }

            public void setDesc(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
                    this.desc = str;
                }
            }

            public void setExec(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
                    this.exec = i;
                }
            }

            public void setExp(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
                    this.exp = str;
                }
            }

            public void setItems(List<ItemsDTO> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048592, this, list) == null) {
                    this.items = list;
                }
            }

            public void setKeyboard(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
                    this.keyboard = i;
                }
            }

            public void setName(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
                    this.name = str;
                }
            }

            public void setSubSkill(List<SkillDTO> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
                    this.subSkill = list;
                }
            }

            public void setType(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
                    this.type = i;
                }
            }
        }

        /* loaded from: classes4.dex */
        public static class UserDTO extends OrmObject implements Serializable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            @SerializedName("forum_level")
            public int forumLevel;
            @SerializedName("name")
            public String name;
            @SerializedName("name_show")
            public String nameShow;
            @SerializedName("portrait")
            public String portrait;
            @SerializedName("robot_role")
            public int robotRole;
            @SerializedName("uk")
            public String uk;

            public UserDTO() {
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

            public int getForumLevel() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.forumLevel;
                }
                return invokeV.intValue;
            }

            public String getName() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.name;
                }
                return (String) invokeV.objValue;
            }

            public String getNameShow() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.nameShow;
                }
                return (String) invokeV.objValue;
            }

            public String getPortrait() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.portrait;
                }
                return (String) invokeV.objValue;
            }

            public int getRobotRole() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    return this.robotRole;
                }
                return invokeV.intValue;
            }

            public String getUk() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    return this.uk;
                }
                return (String) invokeV.objValue;
            }

            public void setForumLevel(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                    this.forumLevel = i;
                }
            }

            public void setName(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                    this.name = str;
                }
            }

            public void setNameShow(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                    this.nameShow = str;
                }
            }

            public void setPortrait(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                    this.portrait = str;
                }
            }

            public void setRobotRole(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
                    this.robotRole = i;
                }
            }

            public void setUk(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
                    this.uk = str;
                }
            }
        }

        public BotListDTO() {
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

        public String getAtGuide() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.atGuide;
            }
            return (String) invokeV.objValue;
        }

        public String getGuide() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.guide;
            }
            return (String) invokeV.objValue;
        }

        public String getScene() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.scene;
            }
            return (String) invokeV.objValue;
        }

        public List<SkillDTO> getSkill() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.skill;
            }
            return (List) invokeV.objValue;
        }

        public UserDTO getUser() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.user;
            }
            return (UserDTO) invokeV.objValue;
        }

        public void setAtGuide(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.atGuide = str;
            }
        }

        public void setGuide(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.guide = str;
            }
        }

        public void setScene(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
                this.scene = str;
            }
        }

        public void setSkill(List<SkillDTO> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
                this.skill = list;
            }
        }

        public void setUser(UserDTO userDTO) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, userDTO) == null) {
                this.user = userDTO;
            }
        }
    }

    public BotsDTO() {
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

    public List<BotListDTO> getBotList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.botList;
        }
        return (List) invokeV.objValue;
    }

    public String getGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.guide;
        }
        return (String) invokeV.objValue;
    }

    public void setBotList(List<BotListDTO> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.botList = list;
        }
    }

    public void setGuide(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.guide = str;
        }
    }
}
