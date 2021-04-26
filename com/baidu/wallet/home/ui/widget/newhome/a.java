package com.baidu.wallet.home.ui.widget.newhome;

import com.baidu.wallet.home.datamodel.HomeCfgResponse;
/* loaded from: classes5.dex */
public class a {
    public static HomeCfgResponse.ConfigData[] a(HomeCfgResponse homeCfgResponse) {
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

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        char c2 = 65535;
        if (str.hashCode() == 49588 && str.equals(HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE202)) {
            c2 = 0;
        }
        return c2 != 0 ? NHSeperator.SP_NONE : NHSeperator.SP_SINGLE_LINE;
    }

    public static HomeCfgResponse.ConfigData a(String str) {
        HomeCfgResponse.ConfigData configData = new HomeCfgResponse.ConfigData();
        configData.group_layout = "100";
        configData.group_name = str;
        return configData;
    }
}
