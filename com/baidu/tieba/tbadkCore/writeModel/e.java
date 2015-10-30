package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e {
    public static void Q(Context context, String str) {
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
        View inflate = LayoutInflater.from(context).inflate(i.g.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(i.f.experience_score);
        TextView textView = (TextView) inflate.findViewById(i.f.success_text);
        TextView textView2 = (TextView) inflate.findViewById(i.f.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(i.f.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(i.h.send_success);
        }
        textView.setText(str);
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void a(w wVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            wVar.o("is_location", "2");
            Address y = com.baidu.adp.lib.d.a.gC().y(false);
            if (y != null) {
                wVar.o("lat", String.valueOf(y.getLatitude()));
                wVar.o("lng", String.valueOf(y.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.axi().getLocationData();
            if (locationData != null) {
                wVar.o("name", locationData.axe());
                wVar.o("sn", locationData.axg());
            }
        }
    }
}
