package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.be;
import com.baidu.tieba.w;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private static String ept;

    public static SpannableStringBuilder ao(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(w.g.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new be(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String aLW() {
        if (TextUtils.isEmpty(ept)) {
            ept = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nick_name_activity_link", "");
        }
        return ept;
    }

    public static void a(com.baidu.adp.base.g gVar, String str) {
        Activity pageActivity = gVar.getPageActivity();
        View inflate = LayoutInflater.from(pageActivity).inflate(w.j.nick_name_act_dialog, (ViewGroup) null);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
        aVar.v(inflate);
        aVar.a(w.l.nick_name_confirm, new e(pageActivity));
        aVar.b(w.l.nick_name_cancel, new f());
        aVar.b(gVar).ta();
        TextView textView = (TextView) inflate.findViewById(w.h.nickname_dialog_title);
        textView.setText(String.format(gVar.getString(w.l.nick_name_act_title), str));
        as.i(textView, w.e.cp_cont_b);
        as.i(inflate.findViewById(w.h.nickname_dialog_tip), w.e.common_color_10122);
    }

    public static void O(int i, String str) {
        new Handler().postDelayed(new g(str), i);
    }

    public static String G(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("tb_hudong");
        if (optJSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(optJSONObject.optString("content").replaceAll("\\\\", ""));
                if (jSONObject2 != null) {
                    return jSONObject2.optString("body");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}
