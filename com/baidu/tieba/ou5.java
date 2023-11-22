package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.NewGodInfo;
/* loaded from: classes7.dex */
public class ou5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(NewGodData newGodData) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newGodData)) == null) {
            if (newGodData != null && newGodData.getType() == 2) {
                z = true;
            } else {
                z = false;
            }
            return c(z);
        }
        return (String) invokeL.objValue;
    }

    public static String b(NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, newGodInfo)) == null) {
            if (newGodInfo != null && newGodInfo.type.intValue() == 2) {
                z = true;
            } else {
                z = false;
            }
            return c(z);
        }
        return (String) invokeL.objValue;
    }

    public static String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            if (z) {
                return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_video_god);
            }
            return TbadkCoreApplication.getInst().getApp().getString(R.string.field_new_god);
        }
        return (String) invokeZ.objValue;
    }

    public static void d(String str, String str2, String str3, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, str, str2, str3, context) == null) {
            BrowserHelper.startWebActivity(context, null, kmb.a(kmb.a(kmb.a(TbConfig.URL_FORUM_LEVEL_H5_PAGE, "portrait", str2), "forum_id", str), "obj_locate", str3), true, true, true);
        }
    }
}
