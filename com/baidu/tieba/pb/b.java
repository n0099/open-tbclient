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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.CustomDialogData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a {
        public static String eED = "c12585";
        public static String eEE = "c12586";
    }

    public static void a(final com.baidu.adp.base.e eVar, CustomDialogData customDialogData) {
        int i;
        if (eVar != null && eVar.getPageActivity() != null && customDialogData != null && customDialogData.head != null) {
            CustomDialogData.Button button = customDialogData.leftButton;
            final CustomDialogData.Button button2 = customDialogData.rightButton;
            if (button != null && button2 != null) {
                Activity pageActivity = eVar.getPageActivity();
                View inflate = LayoutInflater.from(pageActivity).inflate(d.h.custom_act_dialog, (ViewGroup) null);
                TbImageView tbImageView = (TbImageView) inflate.findViewById(d.g.dialog_image);
                TextView textView = (TextView) inflate.findViewById(d.g.dialog_title);
                TextView textView2 = (TextView) inflate.findViewById(d.g.dialog_body);
                CustomDialogData.Head head = customDialogData.head;
                if (!TextUtils.isEmpty(head.imageUrl)) {
                    tbImageView.startLoad(head.imageUrl, 10, false);
                }
                if (!TextUtils.isEmpty(head.text)) {
                    textView.setText(head.text);
                }
                if (!TextUtils.isEmpty(customDialogData.body)) {
                    textView2.setText(customDialogData.body);
                }
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(pageActivity);
                aVar.v(inflate);
                String string = TextUtils.isEmpty(button.text) ? eVar.getString(d.j.cancel) : button.text;
                aVar.a(TextUtils.isEmpty(button2.text) ? eVar.getString(d.j.confirm) : button2.text, new a.b() { // from class: com.baidu.tieba.pb.b.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (!TextUtils.isEmpty(CustomDialogData.Button.this.action)) {
                            if (eVar instanceof TbPageContext) {
                                av.vI().c((TbPageContext) eVar, new String[]{CustomDialogData.Button.this.action});
                            } else {
                                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(eVar.getPageActivity(), null, CustomDialogData.Button.this.action, true)));
                            }
                        }
                        aVar2.dismiss();
                        ak akVar = new ak(a.eEE);
                        akVar.r("obj_locate", 2);
                        TiebaStatic.log(akVar);
                    }
                });
                aVar.b(string, new a.b() { // from class: com.baidu.tieba.pb.b.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        ak akVar = new ak(a.eEE);
                        akVar.r("obj_locate", 1);
                        TiebaStatic.log(akVar);
                    }
                });
                aVar.b(eVar).th();
                aj.i(textView, d.C0080d.cp_cont_b);
                aj.i(textView2, d.C0080d.common_color_10122);
                ak akVar = new ak(a.eED);
                switch (customDialogData.type) {
                    case 0:
                        i = 2;
                        break;
                    case 1:
                        i = 3;
                        break;
                    case 2:
                        i = 4;
                        break;
                    default:
                        i = 0;
                        break;
                }
                akVar.r("obj_type", i);
                TiebaStatic.log(akVar);
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

    public static CustomDialogData I(JSONObject jSONObject) {
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
