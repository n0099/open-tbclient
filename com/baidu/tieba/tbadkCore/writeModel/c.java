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
import com.baidu.tieba.d;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes.dex */
public class c {
    public static void d(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(PushConstants.WORK_RECEIVER_EVENTCORE_ERROR);
        toast.show();
    }

    public static void e(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(d.h.post_write_or_reply_lay, (ViewGroup) null);
        View findViewById = inflate.findViewById(d.g.experience_score);
        TextView textView = (TextView) inflate.findViewById(d.g.success_text);
        TextView textView2 = (TextView) inflate.findViewById(d.g.pre_msg);
        TextView textView3 = (TextView) inflate.findViewById(d.g.color_msg);
        if (StringUtils.isNull(str)) {
            str = context.getString(d.j.send_success);
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
            xVar.n("is_location", "2");
            Address ak = com.baidu.adp.lib.d.a.mG().ak(false);
            if (ak != null) {
                xVar.n("lat", String.valueOf(ak.getLatitude()));
                xVar.n("lng", String.valueOf(ak.getLongitude()));
            }
            com.baidu.tieba.tbadkCore.location.a locationData = com.baidu.tieba.tbadkCore.location.c.bwr().getLocationData();
            if (locationData != null) {
                xVar.n("name", locationData.bwn());
                xVar.n("sn", locationData.bwp());
            }
        }
    }
}
