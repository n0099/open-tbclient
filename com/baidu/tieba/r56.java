package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumUserLiveActiivtyConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(s36 s36Var, String str, String str2) {
        SdkLiveInfoData sdkLiveInfoData;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65536, null, s36Var, str, str2) == null) && s36Var != null && (sdkLiveInfoData = s36Var.a) != null) {
            SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
            String str7 = "";
            if (alaLiveInfo == null || (yYExt = alaLiveInfo.yyExt) == null) {
                str3 = "";
                str4 = str3;
                str5 = str4;
                str6 = str5;
            } else {
                str4 = yYExt.sid;
                str5 = yYExt.ssid;
                str6 = yYExt.yyUid;
                str3 = yYExt.templateId;
            }
            StatisticItem param = new StatisticItem(str).param("fid", s36Var.c).param("liveid", s36Var.a.liveId).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, str4).param(TiebaStatic.YYParams.YYSSID, str5).param(TiebaStatic.YYParams.YYUID, str6).param("template_id", str3);
            if (!TextUtils.isEmpty(str4)) {
                str7 = "1";
            }
            StatisticItem param2 = param.param(TiebaStatic.YYParams.YYLIVEID, str7).param(TiebaStatic.Params.VID, s36Var.a.nid);
            if (TextUtils.equals(ForumUserLiveActiivtyConfig.KEY_FROM_FRS_CARD, str2)) {
                i = 1;
            } else {
                i = 2;
            }
            TiebaStatic.log(param2.param("obj_source", i));
        }
    }

    public static void b(s36 s36Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, s36Var, str) == null) {
            a(s36Var, "c14705", str);
        }
    }

    public static void c(s36 s36Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, s36Var, str) == null) {
            a(s36Var, "c14704", str);
        }
    }
}
