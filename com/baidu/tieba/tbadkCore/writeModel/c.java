package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {
    public static void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void e(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(d.i.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(d.g.experience_score);
        TextView textView = (TextView) inflate.findViewById(d.g.success_text);
        TextView textView2 = (TextView) inflate.findViewById(d.g.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(d.g.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(d.k.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void a(y yVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            yVar.o("is_location", "2");
            Address I = com.baidu.adp.lib.d.a.hB().I(false);
            if (I != null) {
                yVar.o("lat", String.valueOf(I.getLatitude()));
                yVar.o("lng", String.valueOf(I.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.byk().getLocationData();
            if (locationData != null) {
                yVar.o("name", locationData.byg());
                yVar.o("sn", locationData.byi());
            }
        }
    }
}
