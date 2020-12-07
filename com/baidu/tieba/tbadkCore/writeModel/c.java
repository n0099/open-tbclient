package com.baidu.tieba.tbadkCore.writeModel;

import android.content.Context;
import android.location.Address;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
/* loaded from: classes.dex */
public class c {
    public static void c(Context context, View view) {
        Toast toast = new Toast(context);
        toast.setView(view);
        toast.setGravity(17, 0, 0);
        toast.setDuration(3000);
        toast.show();
    }

    public static void h(Context context, String str, String str2, String str3) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.post_write_or_reply_lay, (ViewGroup) null);
        inflate.setBackgroundDrawable(ap.aR(l.getDimens(context, R.dimen.tbds32), ap.getColor(R.color.CAM_X0701)));
        View findViewById = inflate.findViewById(R.id.experience_score);
        TextView textView = (TextView) inflate.findViewById(R.id.success_text);
        ap.setViewTextColor(textView, R.color.CAM_X0101);
        TextView textView2 = (TextView) inflate.findViewById(R.id.pre_msg);
        ap.setViewTextColor(textView2, R.color.CAM_X0101);
        TextView textView3 = (TextView) inflate.findViewById(R.id.color_msg);
        ap.setViewTextColor(textView3, R.color.CAM_X0305);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.success_img);
        if (imageView != null) {
            imageView.setBackgroundDrawable(SvgManager.btW().a(R.drawable.icon_pure_toast_succeed40_svg, R.color.CAM_X0101, (SvgManager.SvgResourceStateType) null));
        }
        if (StringUtils.isNull(str)) {
            str = context.getString(R.string.send_success);
        }
        textView.setText(str);
        if (str2 != null || str3 != null) {
            findViewById.setVisibility(0);
            textView2.setText(str2);
            textView3.setText(str3);
        }
        c(context, inflate);
    }

    public static void a(aa aaVar, WriteData writeData) {
        if (writeData != null && writeData.isHasLocationData()) {
            aaVar.addPostData("is_location", "2");
            Address address = com.baidu.adp.lib.c.a.mk().getAddress(false);
            if (address != null) {
                aaVar.addPostData("lat", String.valueOf(address.getLatitude()));
                aaVar.addPostData("lng", String.valueOf(address.getLongitude()));
            }
            LocationData locationData = com.baidu.tieba.tbadkCore.location.b.dPT().getLocationData();
            if (locationData != null) {
                aaVar.addPostData("name", locationData.getFormatted_address());
                aaVar.addPostData(IXAdRequestInfo.SN, locationData.getSn());
            }
        }
    }
}
