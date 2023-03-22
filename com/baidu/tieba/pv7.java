package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AtUserInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public class pv7 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075576, "Lcom/baidu/tieba/pv7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075576, "Lcom/baidu/tieba/pv7;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f086f);
        b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f086e);
        c = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0870);
    }

    public static String a(@Nullable String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            return String.format(b, str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> b(@Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list) {
        InterceptResult invokeL;
        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (list != null && list.size() > 0) {
                for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                    if (itemsDTO != null && (opts = itemsDTO.getOpts()) != null && opts.size() > 0) {
                        hashMap.put(itemsDTO.getValue(), itemsDTO.getOpts().get(0).getName());
                    }
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    @Nullable
    public static AtUserInfo c(@NonNull BotsDTO.BotListDTO.UserDTO userDTO, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, userDTO, skillDTO)) == null) {
            String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(userDTO.getUk());
            if (TextUtils.isEmpty(bdUidFromBdUK)) {
                return null;
            }
            try {
                return AtUserInfo.create(AtUserInfo.AtType.USER, Long.parseLong(bdUidFromBdUK), String.format(c, userDTO.getNameShow(), skillDTO.getName()), userDTO.getPortrait(), 0);
            } catch (Exception e) {
                if (!TbadkCoreApplication.getInst().isDebugMode()) {
                    e.printStackTrace();
                    return null;
                }
                throw e;
            }
        }
        return (AtUserInfo) invokeLL.objValue;
    }

    public static TextMsg d(@NonNull String str, @Nullable BaseMsg baseMsg, @NonNull hu7 hu7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, baseMsg, hu7Var)) == null) {
            BotsDTO.BotListDTO.UserDTO userDTO = hu7Var.a;
            BotsDTO.BotListDTO.SkillDTO skillDTO = hu7Var.b;
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list = hu7Var.c;
            if (userDTO != null && skillDTO != null) {
                StringBuilder sb = new StringBuilder();
                if (!ListUtils.isEmpty(list)) {
                    for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                        if (itemsDTO != null && itemsDTO.getItemType() == 0 && !ListUtils.isEmpty(itemsDTO.getOpts())) {
                            sb.append(a(itemsDTO.getName(), itemsDTO.getOpts().get(0).getName()));
                            sb.append("\n");
                        }
                    }
                }
                if (!TextUtils.isEmpty(skillDTO.getAlias()) && !TextUtils.isEmpty(str)) {
                    sb.append(a(skillDTO.getAlias(), str));
                }
                String sb2 = sb.toString();
                if (sb2.endsWith("\n")) {
                    sb2 = sb2.substring(0, sb2.length() - 1);
                }
                AtUserInfo c2 = c(userDTO, skillDTO);
                if (c2 == null) {
                    return TextMsg.create(str);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(skillDTO.getType()));
                hashMap.put("promot", str);
                hashMap.put("scene", "tieba_group_chat");
                hashMap.put("opts", b(list));
                if (baseMsg == null) {
                    TextMsg create = TextMsg.create(String.format(a, userDTO.getNameShow(), skillDTO.getName(), sb2));
                    create.addAtUserInfo(c2);
                    create.setRobotParams(hashMap);
                    return create;
                }
                TextMsg create2 = TextMsg.create(String.format(a, userDTO.getNameShow(), skillDTO.getName(), sb2));
                create2.addAtUserInfo(c2);
                if (hu7Var.b()) {
                    create2.setReMsgInfo(ReMsgInfo.create(baseMsg, baseMsg.getThumbnailText().toString()));
                }
                if (baseMsg.getReMsgInfo() != null) {
                    if (baseMsg instanceof TextGenImageMsg) {
                        hashMap.put("last_promot", ((TextGenImageMsg) baseMsg).getLastPrompt());
                    }
                    hashMap.put("user_msg_id", Long.valueOf(baseMsg.getReMsgInfo().getMsgId()));
                    hashMap.put("user_msg_key", baseMsg.getReMsgInfo().getMsgKey());
                }
                if (baseMsg.getTaskInfo() != null) {
                    hashMap.put("robot_msg_id", Long.valueOf(baseMsg.getTaskInfo().getOriginMsgId()));
                    hashMap.put("robot_msg_key", baseMsg.getTaskInfo().getOriginMsgKey());
                }
                create2.setRobotParams(hashMap);
                return create2;
            }
            return TextMsg.create(str);
        }
        return (TextMsg) invokeLLL.objValue;
    }

    public static TextMsg e(@NonNull String str, @Nullable BaseMsg baseMsg, @Nullable hu7 hu7Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, baseMsg, hu7Var)) == null) {
            if (hu7Var == null) {
                return TextMsg.create(str);
            }
            return d(str, baseMsg, hu7Var);
        }
        return (TextMsg) invokeLLL.objValue;
    }
}
