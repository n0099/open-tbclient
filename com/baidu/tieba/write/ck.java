package com.baidu.tieba.write;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
public class ck {
    public static void J(Context context, String str) {
        if (!StringUtils.isNull(str)) {
            Toast makeText = Toast.makeText(context, str, 0);
            if (makeText.getView() != null) {
                View findViewById = makeText.getView().findViewById(16908299);
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setGravity(17);
                }
                makeText.show();
            }
        }
    }

    public static void m(Activity activity) {
        try {
            com.baidu.tbadk.motu_gallery.v.a(activity, 12002, null);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(com.baidu.tbadk.core.util.ac acVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            acVar.k("is_location", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
            Address address = com.baidu.adp.lib.d.a.dE().getAddress(false);
            if (address != null) {
                acVar.k("lat", String.valueOf(address.getLatitude()));
                acVar.k("lng", String.valueOf(address.getLongitude()));
            }
            com.baidu.tieba.location.a locationData = com.baidu.tieba.location.c.Sr().getLocationData();
            if (locationData != null) {
                acVar.k("name", locationData.So());
            }
        }
    }
}
