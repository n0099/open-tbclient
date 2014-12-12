package com.baidu.tieba.tbadkCore.f;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.motu_gallery.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class g {
    public static void N(Context context, String str) {
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

    public static void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void d(Context context, String str, String str2, String str3) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(context, x.post_write_or_reply_lay, null);
        View findViewById = inflate.findViewById(w.experience_score);
        TextView textView = (TextView) inflate.findViewById(w.success_text);
        TextView textView2 = (TextView) inflate.findViewById(w.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(w.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(z.send_success);
        }
        textView.setText(str);
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void q(Activity activity) {
        try {
            v.c(activity, 12002, null);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(ad adVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            adVar.o("is_location", "2");
            Address z = com.baidu.adp.lib.d.a.dD().z(false);
            if (z != null) {
                adVar.o("lat", String.valueOf(z.getLatitude()));
                adVar.o("lng", String.valueOf(z.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.ahy().getLocationData();
            if (locationData != null) {
                adVar.o("name", locationData.ahu());
                adVar.o("sn", locationData.ahw());
            }
        }
    }
}
