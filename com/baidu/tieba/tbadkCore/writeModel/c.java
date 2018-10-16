package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class c {
    public static void d(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void e(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(e.h.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(e.g.experience_score);
        TextView textView = (TextView) inflate.findViewById(e.g.success_text);
        TextView textView2 = (TextView) inflate.findViewById(e.g.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(e.g.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(e.j.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        d(context, inflate);
    }

    public static void a(x xVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            xVar.x("is_location", "2");
            Address R = com.baidu.adp.lib.d.a.iX().R(false);
            if (R != null) {
                xVar.x("lat", String.valueOf(R.getLatitude()));
                xVar.x("lng", String.valueOf(R.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bCH().getLocationData();
            if (locationData != null) {
                xVar.x("name", locationData.bCD());
                xVar.x("sn", locationData.bCF());
            }
        }
    }
}
