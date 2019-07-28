package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c {
    public static void e(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void f(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.experience_score);
        TextView textView = (TextView) inflate.findViewById(R.id.success_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(R.id.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(R.string.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        e(context, inflate);
    }

    public static void a(x xVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            xVar.o("is_location", "2");
            Address X = com.baidu.adp.lib.d.a.hY().X(false);
            if (X != null) {
                xVar.o("lat", String.valueOf(X.getLatitude()));
                xVar.o("lng", String.valueOf(X.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.cpV().getLocationData();
            if (locationData != null) {
                xVar.o("name", locationData.cpT());
                xVar.o(IXAdRequestInfo.SN, locationData.getSn());
            }
        }
    }
}
