package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.im.base.core.inputtool.InputDelegate;
import com.baidu.tieba.im.base.core.uilist.BaseItem;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityItem;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.im.lib.socket.msg.data.Reaction;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class wv8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int a;
    public static final int b;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948284144, "Lcom/baidu/tieba/wv8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948284144, "Lcom/baidu/tieba/wv8;");
                return;
            }
        }
        a = UtilHelper.getDimenPixelSize(R.dimen.tbds28_5);
        b = UtilHelper.getDimenPixelSize(R.dimen.tbds31);
        c = UtilHelper.getDimenPixelSize(R.dimen.tbds83);
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return (BdUtilHelper.getEquipmentWidth(TbadkApplication.getInst()) - (a * 2)) / ((b * 2) + c);
        }
        return invokeV.intValue;
    }

    @Nullable
    public static EmojiData b(@NonNull String str, @NonNull List<EmojiData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, list)) == null) {
            try {
                URL url = new URL(str);
                for (EmojiData emojiData : list) {
                    URL url2 = new URL(emojiData.getContent());
                    if (url.getHost().equals(url2.getHost()) && url.getPath().equals(url2.getPath())) {
                        return emojiData;
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return (EmojiData) invokeLL.objValue;
    }

    public static boolean c(@NonNull InputDelegate inputDelegate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputDelegate)) == null) {
            return !inputDelegate.G(Arrays.asList(Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE_ALL), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_FROZEN), Integer.valueOf((int) TbEnum.MsgContentType.MSG_CONTENT_TYPE_SYSTEM_MUZZLE)));
        }
        return invokeL.booleanValue;
    }

    public static boolean d(@NonNull Reaction reaction, @NonNull List<EmojiData> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, reaction, list)) == null) {
            EmojiData b2 = b(reaction.getContent(), list);
            if (b2 != null) {
                return b2.hasReplied();
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void e(@NonNull cn8 cn8Var, int i, @NonNull BaseItem<? extends TbBaseMsg> baseItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65541, null, cn8Var, i, baseItem) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("scene", Integer.valueOf(i));
            cn8Var.d(new AbilityItem("open_emoji_panel", hashMap, null), baseItem, null);
        }
    }

    public static void f(@NonNull cn8 cn8Var, @NonNull EmojiData emojiData, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65542, null, cn8Var, emojiData, baseItem, i) == null) {
            g(cn8Var, new Reaction("", emojiData.getContent()), baseItem, i);
        }
    }

    public static void g(@NonNull cn8 cn8Var, @NonNull Reaction reaction, @NonNull BaseItem<? extends TbBaseMsg> baseItem, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65543, null, cn8Var, reaction, baseItem, i) == null) {
            List<EmojiData> emojiList = baseItem.getTbMsg().getEmojiList();
            boolean z = true;
            if (emojiList != null) {
                boolean d = d(reaction, emojiList);
                if (i != 1) {
                    int i2 = 2;
                    if (i == 2) {
                        z = true ^ d;
                        if (!z) {
                            i2 = 3;
                        }
                        uv8.h(i2, baseItem);
                    }
                } else if (d) {
                    return;
                } else {
                    uv8.h(1, baseItem);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("content", reaction.getContent());
            hashMap.put(SpeedStatsUtils.UBC_KEY_OPTION, Boolean.valueOf(z));
            cn8Var.d(new AbilityItem("send_emoji_msg", hashMap, null), baseItem, null);
        }
    }
}
