package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.w;
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

    public static void c(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(d.j.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(d.h.experience_score);
        TextView textView = (TextView) inflate.findViewById(d.h.success_text);
        TextView textView2 = (TextView) inflate.findViewById(d.h.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(d.h.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(d.l.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void a(w wVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            wVar.n("is_location", "2");
            Address C = com.baidu.adp.lib.d.a.fd().C(false);
            if (C != null) {
                wVar.n("lat", String.valueOf(C.getLatitude()));
                wVar.n("lng", String.valueOf(C.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bsX().getLocationData();
            if (locationData != null) {
                wVar.n("name", locationData.bsT());
                wVar.n("sn", locationData.bsV());
            }
        }
    }
}
