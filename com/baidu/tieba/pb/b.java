package com.baidu.tieba.pb;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(final com.baidu.adp.base.e eVar, CustomDialogData customDialogData) {
        if (eVar != null && eVar.getPageActivity() != null && customDialogData != null && customDialogData.head != null) {
            CustomDialogData.Button button = customDialogData.leftButton;
            final CustomDialogData.Button button2 = customDialogData.rightButton;
            if (button != null && button2 != null) {
                Activity pageActivity = eVar.getPageActivity();
                View inflate = LayoutInflater.from(pageActivity).inflate(d.j.custom_act_dialog, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(d.h.dialog_image);
                TextView textView = (TextView) inflate.findViewById(d.h.dialog_title);
                TextView textView2 = (TextView) inflate.findViewById(d.h.dialog_body);
                CustomDialogData.Head head = customDialogData.head;
                if (!TextUtils.isEmpty(head.imageUrl)) {
                    tbImageView.c(head.imageUrl, 10, false);
                }
                if (!TextUtils.isEmpty(head.text)) {
                    textView.setText(head.text);
                }
                if (!TextUtils.isEmpty(customDialogData.body)) {
                    textView2.setText(customDialogData.body);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
                aVar.v(inflate);
                String string = TextUtils.isEmpty(button.text) ? eVar.getString(d.l.cancel) : button.text;
                aVar.a(TextUtils.isEmpty(button2.text) ? eVar.getString(d.l.confirm) : button2.text, new a.b() { // from class: com.baidu.tieba.pb.b.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (!TextUtils.isEmpty(CustomDialogData.Button.this.action)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(eVar.getPageActivity(), null, CustomDialogData.Button.this.action, true)));
                        }
                        aVar2.dismiss();
                    }
                });
                aVar.b(string, new a.b() { // from class: com.baidu.tieba.pb.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.b(eVar).ti();
                aj.i(textView, d.e.cp_cont_b);
                aj.i(textView2, d.e.common_color_10122);
            }
        }
    }

    public static void a(int i, final CustomDialogData customDialogData) {
        if (customDialogData != null) {
            new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.b.3
                @Override // java.lang.Runnable
                public void run() {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHOW_ACT_DIALOG, CustomDialogData.this));
                }
            }, i);
        }
    }

    public static CustomDialogData F(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("tb_hudong")) == null || TextUtils.isEmpty(optJSONObject.optString("content"))) {
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(Uri.decode(optJSONObject.optString("content")));
            if (jSONObject2 != null) {
                return CustomDialogData.praseJSON(jSONObject2);
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
