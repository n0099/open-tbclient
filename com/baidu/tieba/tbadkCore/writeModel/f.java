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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f {
    public static void S(Context context, String str) {
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

    public static void g(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void c(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(r.h.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(r.g.experience_score);
        TextView textView = (TextView) inflate.findViewById(r.g.success_text);
        TextView textView2 = (TextView) inflate.findViewById(r.g.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(r.g.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(r.j.send_success);
        }
        textView.setText(str);
        if (!StringUtils.isNull(str2) && !StringUtils.isNull(str3)) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        g(context, inflate);
    }

    public static void a(ab abVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            abVar.n("is_location", "2");
            Address B = com.baidu.adp.lib.e.a.dU().B(false);
            if (B != null) {
                abVar.n("lat", String.valueOf(B.getLatitude()));
                abVar.n("lng", String.valueOf(B.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bkv().getLocationData();
            if (locationData != null) {
                abVar.n("name", locationData.getFormatted_address());
                abVar.n("sn", locationData.getSn());
            }
        }
    }
}
