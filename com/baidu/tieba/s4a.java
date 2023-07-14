package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            if (!str.endsWith(str2)) {
                return str + str2;
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(@NonNull Context context, @NonNull ShareItem shareItem, @NonNull GroupInfoData groupInfoData, int i) {
        String format;
        String d;
        Uri parse;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLI(65537, null, context, shareItem, groupInfoData, i) != null) || !GroupInfoData.isValidGroup(groupInfoData)) {
            return;
        }
        String c = c(groupInfoData);
        String e = e(groupInfoData.getName());
        if (i == 3) {
            format = String.format(context.getString(R.string.group_share_wx_timeline_slogan), c, e);
        } else {
            if (i == 7) {
                d = String.format(context.getString(R.string.group_share_weibo_slogan), e);
            } else if (i == 5) {
                c = String.format(context.getString(R.string.group_share_invite_slogan), e);
                d = d(groupInfoData, i);
                shareItem.q0 = false;
            } else {
                format = String.format(context.getString(R.string.group_share_invite_slogan), e);
            }
            shareItem.v = c;
            shareItem.w = d;
            shareItem.x = groupInfoData.link;
            shareItem.I0 = c;
            shareItem.J0 = d(groupInfoData, i);
            shareItem.A = groupInfoData.getPortrait();
            if (groupInfoData.getPortrait() != null) {
                parse = null;
            } else {
                parse = Uri.parse(groupInfoData.getPortrait());
            }
            shareItem.z = parse;
        }
        c = format;
        d = c;
        shareItem.v = c;
        shareItem.w = d;
        shareItem.x = groupInfoData.link;
        shareItem.I0 = c;
        shareItem.J0 = d(groupInfoData, i);
        shareItem.A = groupInfoData.getPortrait();
        if (groupInfoData.getPortrait() != null) {
        }
        shareItem.z = parse;
    }

    public static String c(@NonNull GroupInfoData groupInfoData) {
        InterceptResult invokeL;
        String forumName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, groupInfoData)) == null) {
            if (!TextUtils.isEmpty(groupInfoData.getForumShowName())) {
                forumName = groupInfoData.getForumShowName();
            } else {
                forumName = groupInfoData.getForumName();
            }
            return a(forumName, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0773));
        }
        return (String) invokeL.objValue;
    }

    public static String d(GroupInfoData groupInfoData, int i) {
        InterceptResult invokeLI;
        String forumName;
        String string;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, groupInfoData, i)) == null) {
            if (groupInfoData == null) {
                return "";
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(groupInfoData.getForumShowName())) {
                forumName = groupInfoData.getForumShowName();
            } else {
                forumName = groupInfoData.getForumName();
            }
            String format = String.format(inst.getString(R.string.group_share_from_forum), forumName);
            if (!StringUtils.isNull(format)) {
                if (format.length() > 20) {
                    format = format.substring(0, 20) + "...";
                }
                sb.append(format);
                if (!format.endsWith(inst.getString(R.string.obfuscated_res_0x7f0f0773))) {
                    sb.append(inst.getString(R.string.obfuscated_res_0x7f0f0773));
                }
            }
            if (i != 9 && i != 5) {
                sb.append(StringUtils.lineSeparator);
            } else {
                sb.append("，");
            }
            if (groupInfoData.getMemberNum() > 0) {
                if (i == 4) {
                    i2 = R.string.group_member_share_wechat_slogan;
                } else {
                    i2 = R.string.group_member_share_slogan;
                }
                string = String.format(inst.getString(i2), StringHelper.numFormatOverWan(groupInfoData.getMemberNum()));
            } else {
                string = inst.getString(R.string.group_share_slogan_default);
            }
            sb.append(string);
            return sb.toString();
        }
        return (String) invokeLI.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return a(str, TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f091e));
        }
        return (String) invokeL.objValue;
    }
}
