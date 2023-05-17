package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.immessagecenter.chatgroup.data.RecentlyBotSkillInfoDto;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class mb8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mb8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public mb8() {
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

    public static mb8 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (mb8.class) {
                    if (a == null) {
                        a = new mb8();
                    }
                }
            }
            return a;
        }
        return (mb8) invokeV.objValue;
    }

    @NonNull
    public final String i() {
        InterceptResult invokeV;
        String s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                s = o65.m().s("key_group_bot_skill_info", "");
            }
            return s;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public final String a(@NonNull List<RecentlyBotSkillInfoDto> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return "";
            }
            return DataExt.toJson(list);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public final List<RecentlyBotSkillInfoDto> b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return DataExt.toEntityList(str, RecentlyBotSkillInfoDto.class);
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public final List<RecentlyBotSkillInfoDto> d(@NonNull List<RecentlyBotSkillInfoDto> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            synchronized (this) {
                if (10 >= list.size()) {
                    return list;
                }
                return list.subList(0, 10);
            }
        }
        return (List) invokeL.objValue;
    }

    public final void j(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            synchronized (this) {
                o65.m().B("key_group_bot_skill_info", str);
            }
        }
    }

    public RecentlyBotSkillInfoDto c(@NonNull String str, int i, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Integer.valueOf(i), str2, str3, str4, str5, Integer.valueOf(i2)})) == null) {
            RecentlyBotSkillInfoDto recentlyBotSkillInfoDto = new RecentlyBotSkillInfoDto();
            recentlyBotSkillInfoDto.setBotUk(str);
            recentlyBotSkillInfoDto.setSkillId(i);
            recentlyBotSkillInfoDto.setBotName(str2);
            recentlyBotSkillInfoDto.setSkillName(str3);
            recentlyBotSkillInfoDto.setAvatar(str4);
            recentlyBotSkillInfoDto.setDesc(str5);
            recentlyBotSkillInfoDto.setFuncType(i2);
            recentlyBotSkillInfoDto.setTimeStamp(System.currentTimeMillis());
            return recentlyBotSkillInfoDto;
        }
        return (RecentlyBotSkillInfoDto) invokeCommon.objValue;
    }

    public List<RecentlyBotSkillInfoDto> e(List<BotsDTO.BotListDTO> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, list)) == null) {
            String i = i();
            if (!TextUtils.isEmpty(i) && !ListUtils.isEmpty(list)) {
                int i2 = 0;
                ArrayList arrayList = new ArrayList();
                List<RecentlyBotSkillInfoDto> b = b(i);
                synchronized (this) {
                    for (RecentlyBotSkillInfoDto recentlyBotSkillInfoDto : b) {
                        if (recentlyBotSkillInfoDto != null && i2 < 3) {
                            for (BotsDTO.BotListDTO botListDTO : list) {
                                if (i2 < 3 && botListDTO != null && botListDTO.getUser() != null && !TextUtils.isEmpty(botListDTO.getUser().getUk()) && recentlyBotSkillInfoDto.getBotUk().equals(botListDTO.getUser().getUk()) && !ListUtils.isEmpty(botListDTO.getSkill())) {
                                    for (BotsDTO.BotListDTO.SkillDTO skillDTO : botListDTO.getSkill()) {
                                        if (i2 < 3 && skillDTO != null && skillDTO.isShow() && skillDTO.getType() == recentlyBotSkillInfoDto.getSkillId()) {
                                            recentlyBotSkillInfoDto.setDesc(skillDTO.getDesc());
                                            recentlyBotSkillInfoDto.setSkillName(skillDTO.getName());
                                            recentlyBotSkillInfoDto.setBotName(botListDTO.getUser().getNameShow());
                                            recentlyBotSkillInfoDto.setAvatar(botListDTO.getUser().getPortrait());
                                            recentlyBotSkillInfoDto.setFuncType(skillDTO.getFuncType());
                                            arrayList.add(recentlyBotSkillInfoDto);
                                            i2++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
            return new ArrayList();
        }
        return (List) invokeL.objValue;
    }

    public final Boolean g(@NonNull RecentlyBotSkillInfoDto recentlyBotSkillInfoDto, @NonNull List<RecentlyBotSkillInfoDto> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, recentlyBotSkillInfoDto, list)) == null) {
            synchronized (this) {
                if (list.contains(recentlyBotSkillInfoDto)) {
                    list.remove(recentlyBotSkillInfoDto);
                    list.add(0, recentlyBotSkillInfoDto);
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        }
        return (Boolean) invokeLL.objValue;
    }

    public void h(@NonNull RecentlyBotSkillInfoDto recentlyBotSkillInfoDto) {
        List<RecentlyBotSkillInfoDto> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, recentlyBotSkillInfoDto) == null) {
            String i = i();
            if (!TextUtils.isEmpty(i)) {
                list = b(i);
            } else {
                list = null;
            }
            if (list == null) {
                list = new ArrayList<>();
            }
            if (!g(recentlyBotSkillInfoDto, list).booleanValue()) {
                list.add(0, recentlyBotSkillInfoDto);
            }
            String a2 = a(d(list));
            if (!TextUtils.isEmpty(a2)) {
                j(a2);
            }
        }
    }
}
