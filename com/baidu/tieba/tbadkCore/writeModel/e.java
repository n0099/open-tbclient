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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e {
    public static void f(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void c(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(r.j.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(r.h.experience_score);
        TextView textView = (TextView) inflate.findViewById(r.h.success_text);
        TextView textView2 = (TextView) inflate.findViewById(r.h.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(r.h.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(r.l.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        f(context, inflate);
    }

    public static void a(y yVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            yVar.n("is_location", "2");
            Address B = com.baidu.adp.lib.d.a.dS().B(false);
            if (B != null) {
                yVar.n("lat", String.valueOf(B.getLatitude()));
                yVar.n("lng", String.valueOf(B.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bit().getLocationData();
            if (locationData != null) {
                yVar.n("name", locationData.bip());
                yVar.n("sn", locationData.bir());
            }
        }
    }
}
