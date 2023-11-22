package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.im.lib.socket.msg.TbAtUserInfo;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.TbReMsgInfo;
import com.baidu.tieba.im.lib.socket.msg.TbSingleTextImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextGenImageMsg;
import com.baidu.tieba.im.lib.socket.msg.TbTextMsg;
import com.baidu.tieba.im.lib.socket.msg.data.BotsDTO;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class s09 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948097741, "Lcom/baidu/tieba/s09;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948097741, "Lcom/baidu/tieba/s09;");
                return;
            }
        }
        a = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f094f);
        b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0950);
    }

    public static String a(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (TextUtils.isEmpty(str2)) {
                return String.format(b, str);
            }
            return String.format(a, str, str2);
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public static TbAtUserInfo j(@NonNull BotsDTO.BotListDTO.UserDTO userDTO, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, userDTO, str)) == null) {
            ut5.d(i(userDTO));
            return TbAtUserInfo.create(TbAtUserInfo.AtType.USER, Long.parseLong(BIMManager.getBdUidFromBdUK(userDTO.getUk())), str, userDTO.getPortrait(), 0);
        }
        return (TbAtUserInfo) invokeLL.objValue;
    }

    public static String b(@NonNull List<AtSelectData> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            StringBuilder sb = new StringBuilder();
            for (AtSelectData atSelectData : list) {
                sb.append("@");
                sb.append(atSelectData.getNameShow());
                sb.append(" ");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String c(@NonNull String str, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, @NonNull List<AtSelectData> list2) {
        InterceptResult invokeLLLL;
        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        List<AtSelectData> atUserInfos;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, skillDTO, list, list2)) == null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            if (list != null && !list.isEmpty()) {
                for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                    if (itemsDTO != null && (opts = itemsDTO.getOpts()) != null && !opts.isEmpty()) {
                        if (itemsDTO.isNormalType()) {
                            sb.append(a(itemsDTO.getName(), opts.get(0).getName()));
                            sb.append("\n");
                        } else if (itemsDTO.isFileType()) {
                            sb2.append(a(itemsDTO.getName(), null));
                            sb2.append("\n");
                        } else if (itemsDTO.isAtType() && (ext = opts.get(0).getExt()) != null && (atUserInfos = ext.getAtUserInfos()) != null && !atUserInfos.isEmpty()) {
                            list2.addAll(atUserInfos);
                            sb.append(a(itemsDTO.getName(), b(atUserInfos)));
                            sb.append("\n");
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(skillDTO.getAlias()) && !TextUtils.isEmpty(str)) {
                sb.append(a(skillDTO.getAlias(), str));
                sb.append("\n");
            }
            sb.append((CharSequence) sb2);
            return sb.toString();
        }
        return (String) invokeLLLL.objValue;
    }

    public static String d(@NonNull String str, @NonNull String str2, boolean z) {
        InterceptResult invokeLLZ;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("@");
            sb.append(str);
            if (z) {
                str3 = " ";
            } else {
                str3 = "\n";
            }
            sb.append(str3);
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    @NonNull
    public static String f(@NonNull BotsDTO.BotListDTO.UserDTO userDTO, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65542, null, userDTO, skillDTO, z)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(userDTO.getNameShow());
            if (!z) {
                sb.append("/");
                sb.append(skillDTO.getName());
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static HashMap<String, Object> g(@NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, @Nullable String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, skillDTO, list, str)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("type", Integer.valueOf(skillDTO.getType()));
            if (str == null) {
                str = "";
            }
            hashMap.put("promot", str);
            hashMap.put("scene", "tieba_group_chat");
            e(hashMap, list);
            return hashMap;
        }
        return (HashMap) invokeLLL.objValue;
    }

    public static void e(@NonNull Map<String, Object> map, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, map, list) == null) && list != null && list.size() > 0) {
            for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                if (itemsDTO != null) {
                    qs8.a(map, itemsDTO);
                }
            }
        }
    }

    @NonNull
    public static String h(@NonNull String str, @NonNull String str2, @NonNull BotsDTO.BotListDTO.SkillDTO skillDTO, @Nullable List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list, @NonNull List<AtSelectData> list2) {
        InterceptResult invokeLLLLL;
        String str3;
        List<AtSelectData> atUserInfos;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65544, null, str, str2, skillDTO, list, list2)) == null) {
            ut5.b(str);
            String replaceAll = str.replaceAll(skillDTO.getAliasHolder(), skillDTO.getAlias()).replaceAll(skillDTO.getKeyboardHolder(), str2);
            if (list != null && !list.isEmpty()) {
                for (BotsDTO.BotListDTO.SkillDTO.ItemsDTO itemsDTO : list) {
                    if (itemsDTO != null) {
                        String value = itemsDTO.getValue();
                        replaceAll = replaceAll.replaceAll(itemsDTO.getNameHolder(), itemsDTO.getName()).replaceAll(itemsDTO.getAliasHolder(), itemsDTO.getAlias());
                        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts = itemsDTO.getOpts();
                        if (opts != null && !opts.isEmpty() && !TextUtils.isEmpty(value)) {
                            BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO optsDTO = opts.get(0);
                            if (itemsDTO.isNormalType()) {
                                replaceAll = replaceAll.replaceAll(optsDTO.getNameHolder(value), optsDTO.getName()).replaceAll(optsDTO.getAliasHolder(value), optsDTO.getAlias());
                            } else if (itemsDTO.isAtType()) {
                                BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext = optsDTO.getExt();
                                if (ext != null && (atUserInfos = ext.getAtUserInfos()) != null && !atUserInfos.isEmpty()) {
                                    list2.addAll(atUserInfos);
                                    str3 = b(atUserInfos);
                                } else {
                                    str3 = "";
                                }
                                replaceAll = replaceAll.replaceAll(optsDTO.getNameHolder(value), str3).replaceAll(optsDTO.getAliasHolder(value), str3);
                            }
                        }
                    }
                }
            }
            return replaceAll;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static TbTextMsg l(@NonNull String str, @Nullable TbBaseMsg tbBaseMsg, @NonNull yk8 yk8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLLLL;
        boolean z;
        String c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, str, tbBaseMsg, yk8Var, list, map)) == null) {
            BotsDTO.BotListDTO.UserDTO userDTO = yk8Var.a;
            BotsDTO.BotListDTO.SkillDTO skillDTO = yk8Var.b;
            List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO> list2 = yk8Var.c;
            if (userDTO != null && skillDTO != null && i(userDTO)) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                String showTemplate = skillDTO.getShowTemplate(list2);
                if (showTemplate != null && !TextUtils.isEmpty(showTemplate)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c = h(showTemplate, str, skillDTO, list2, arrayList);
                } else {
                    c = c(str, skillDTO, list2, arrayList);
                }
                String f = f(userDTO, skillDTO, z);
                String p = p(d(f, c, z));
                TbTextMsg create = TbTextMsg.create(p);
                create.addAtUserInfo(j(userDTO, f));
                create.addAtUserInfo(n(p, arrayList));
                HashMap<String, Object> g = g(skillDTO, list2, str);
                if (tbBaseMsg == null) {
                    create.setRobotParams(g);
                    return create;
                }
                if (yk8Var.c()) {
                    create.setReMsgInfo(TbReMsgInfo.create(tbBaseMsg, tbBaseMsg.getThumbnailText().toString()));
                }
                if (tbBaseMsg.getReMsgInfo() != null) {
                    if (tbBaseMsg instanceof TbTextGenImageMsg) {
                        g.put("last_promot", ((TbTextGenImageMsg) tbBaseMsg).getLastPrompt());
                    }
                    g.put("user_msg_id", Long.valueOf(tbBaseMsg.getReMsgInfo().getMsgId()));
                    g.put("user_msg_key", tbBaseMsg.getReMsgInfo().getMsgKey());
                }
                if (tbBaseMsg.getTaskInfo() != null) {
                    g.put("robot_msg_id", Long.valueOf(tbBaseMsg.getTaskInfo().getOriginMsgId()));
                    g.put("robot_msg_key", tbBaseMsg.getTaskInfo().getOriginMsgKey());
                }
                create.setRobotParams(g);
                return create;
            }
            return k(str, list, map);
        }
        return (TbTextMsg) invokeLLLLL.objValue;
    }

    public static boolean i(@NonNull BotsDTO.BotListDTO.UserDTO userDTO) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, userDTO)) == null) {
            try {
                String bdUidFromBdUK = BIMManager.getBdUidFromBdUK(userDTO.getUk());
                if (TextUtils.isEmpty(bdUidFromBdUK)) {
                    return false;
                }
                Long.parseLong(bdUidFromBdUK);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static String p(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) {
            if (str.endsWith("\n")) {
                return str.substring(0, str.length() - 1);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    public static TbTextMsg k(@NonNull String str, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, str, list, map)) == null) {
            TbTextMsg create = TbTextMsg.create(str);
            create.addAtUserInfo(o(list, map));
            return create;
        }
        return (TbTextMsg) invokeLLL.objValue;
    }

    public static TbTextMsg m(@NonNull String str, @Nullable TbBaseMsg tbBaseMsg, @Nullable yk8 yk8Var, @Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65549, null, str, tbBaseMsg, yk8Var, list, map)) == null) {
            if (yk8Var == null) {
                return k(str, list, map);
            }
            return l(str, tbBaseMsg, yk8Var, list, map);
        }
        return (TbTextMsg) invokeLLLLL.objValue;
    }

    @NonNull
    public static List<TbAtUserInfo> n(@NonNull String str, @NonNull List<AtSelectData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, list)) == null) {
            HashMap hashMap = new HashMap();
            for (AtSelectData atSelectData : list) {
                int i = 0;
                String str2 = "@" + atSelectData.getNameShow();
                while (true) {
                    int indexOf = str.indexOf(str2, i);
                    if (indexOf == -1) {
                        break;
                    }
                    i = indexOf + 1;
                    if (hashMap.get(Integer.valueOf(indexOf)) == null) {
                        TbAtUserInfo.AtType atType = TbAtUserInfo.AtType.USER;
                        if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                            atType = TbAtUserInfo.AtType.ALL;
                        }
                        hashMap.put(Integer.valueOf(indexOf), TbAtUserInfo.create(atType, JavaTypesHelper.toLong(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), indexOf));
                    }
                }
            }
            return new ArrayList(hashMap.values());
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public static List<TbAtUserInfo> o(@Nullable List<AtSelectData> list, @Nullable Map<String, Integer> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, list, map)) == null) {
            if (list != null && !list.isEmpty() && map != null && !map.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (AtSelectData atSelectData : list) {
                    TbAtUserInfo.AtType atType = TbAtUserInfo.AtType.USER;
                    if (AtSelectData.AT_ALL_FAKE_UID.equals(atSelectData.getUid())) {
                        atType = TbAtUserInfo.AtType.ALL;
                    }
                    arrayList.add(TbAtUserInfo.create(atType, JavaTypesHelper.toLong(atSelectData.getUid(), 0L), atSelectData.getNameShow(), atSelectData.getPortrait(), map.get(atSelectData.getUid()).intValue()));
                }
                return arrayList;
            }
            return Collections.emptyList();
        }
        return (List) invokeLL.objValue;
    }

    @NonNull
    public static TbBaseMsg q(@NonNull TbTextMsg tbTextMsg, @Nullable yk8 yk8Var) {
        InterceptResult invokeLL;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO b2;
        List<BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO> opts;
        BotsDTO.BotListDTO.SkillDTO.ItemsDTO.OptsDTO.Ext ext;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, tbTextMsg, yk8Var)) == null) {
            if (yk8Var != null && (b2 = yk8Var.b()) != null && (opts = b2.getOpts()) != null && !opts.isEmpty() && (ext = opts.get(0).getExt()) != null) {
                TbSingleTextImageMsg create = TbSingleTextImageMsg.create(tbTextMsg.getText(), ext.getPicPath(), ext.getPicSize());
                create.fillMsg4Base(tbTextMsg);
                create.setRobotParams(tbTextMsg.getRobotParams());
                create.setFileItem(b2);
                return create;
            }
            return tbTextMsg;
        }
        return (TbBaseMsg) invokeLL.objValue;
    }
}
