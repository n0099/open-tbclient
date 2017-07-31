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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.n;
import com.baidu.tieba.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static String eBP;

    public static SpannableStringBuilder ao(Context context, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int length = spannableStringBuilder.length();
        Drawable drawable = context.getResources().getDrawable(d.g.icon_nichenghuodong);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.append((CharSequence) "tag");
        spannableStringBuilder.setSpan(new n(drawable), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    public static String aOK() {
        if (TextUtils.isEmpty(eBP)) {
            eBP = com.baidu.tbadk.core.sharedPref.b.getInstance().getString("nick_name_activity_link", "");
        }
        return eBP;
    }

    public static void a(com.baidu.adp.base.e eVar, String str) {
        final Activity pageActivity = eVar.getPageActivity();
        View inflate = LayoutInflater.from(pageActivity).inflate(d.j.nick_name_act_dialog, (ViewGroup) null);
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
        aVar.v(inflate);
        aVar.a(d.l.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.pb.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(pageActivity, 25020, 1, c.aOK())));
                aVar2.dismiss();
            }
        });
        aVar.b(d.l.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.pb.c.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(eVar).tr();
        TextView textView = (TextView) inflate.findViewById(d.h.nickname_dialog_title);
        textView.setText(String.format(eVar.getString(d.l.nick_name_act_title), str));
        ai.i(textView, d.e.cp_cont_b);
        ai.i(inflate.findViewById(d.h.nickname_dialog_tip), d.e.common_color_10122);
    }

    public static void Q(int i, final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.c.3
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_NICK_NAME_ACT, str));
            }
        }, i);
    }

    public static String H(JSONObject jSONObject) {
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
