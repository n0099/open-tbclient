package com.baidu.wallet.home.ui.widget.newhome;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes11.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static HomeCfgResponse.ConfigData[] a(HomeCfgResponse homeCfgResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, homeCfgResponse)) == null) {
            HomeCfgResponse.ConfigData[] configDataArr = homeCfgResponse.layout_content.data;
            int length = configDataArr.length;
            if (length < 1) {
                return configDataArr;
            }
            int i2 = length * 2;
            HomeCfgResponse.ConfigData[] configDataArr2 = new HomeCfgResponse.ConfigData[i2 + 1];
            for (int i3 = 0; i3 < length; i3++) {
                if (configDataArr[i3].isLayoutHasGap()) {
                    configDataArr2[i3 * 2] = a(NHSeperator.SP_SINGLE_SEP);
                } else {
                    configDataArr2[i3 * 2] = a(b(configDataArr[i3].getGroup_layout()));
                }
                configDataArr2[(i3 * 2) + 1] = configDataArr[i3];
            }
            configDataArr2[i2] = a(NHSeperator.SP_NONE);
            return configDataArr2;
        }
        return (HomeCfgResponse.ConfigData[]) invokeL.objValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null) {
                str = "";
            }
            char c2 = 65535;
            if (str.hashCode() == 49588 && str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE202)) {
                c2 = 0;
            }
            return c2 != 0 ? NHSeperator.SP_NONE : NHSeperator.SP_SINGLE_LINE;
        }
        return (String) invokeL.objValue;
    }

    public static HomeCfgResponse.ConfigData a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            HomeCfgResponse.ConfigData configData = new HomeCfgResponse.ConfigData();
            configData.group_layout = HomeCfgResponse.ConfigData.GROUP_LAYOUR_GAP;
            configData.group_name = str;
            return configData;
        }
        return (HomeCfgResponse.ConfigData) invokeL.objValue;
    }
}
