package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e {
    public static void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void c(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(w.j.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(w.h.experience_score);
        TextView textView = (TextView) inflate.findViewById(w.h.success_text);
        TextView textView2 = (TextView) inflate.findViewById(w.h.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(w.h.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(w.l.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void a(ab abVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            abVar.n("is_location", "2");
            Address C = com.baidu.adp.lib.d.a.ff().C(false);
            if (C != null) {
                abVar.n("lat", String.valueOf(C.getLatitude()));
                abVar.n("lng", String.valueOf(C.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.d.bna().getLocationData();
            if (locationData != null) {
                abVar.n("name", locationData.bmW());
                abVar.n("sn", locationData.bmY());
            }
        }
    }
}
