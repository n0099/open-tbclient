package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class h {
    public static void L(Context context, String str) {
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
        toast.setDuration(LocationClientOption.MIN_SCAN_SPAN_NETWORK);
        toast.show();
    }

    public static void d(Context context, String str, String str2, String str3) {
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(context, w.post_write_or_reply_lay, null);
        View findViewById = inflate.findViewById(v.experience_score);
        TextView textView = (TextView) inflate.findViewById(v.success_text);
        TextView textView2 = (TextView) inflate.findViewById(v.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(v.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(y.send_success);
        }
        textView.setText(str);
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void a(aa aaVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            aaVar.o("is_location", "2");
            Address z = com.baidu.adp.lib.d.a.gZ().z(false);
            if (z != null) {
                aaVar.o("lat", String.valueOf(z.getLatitude()));
                aaVar.o("lng", String.valueOf(z.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.anb().getLocationData();
            if (locationData != null) {
                aaVar.o("name", locationData.amX());
                aaVar.o("sn", locationData.amZ());
            }
        }
    }
}
