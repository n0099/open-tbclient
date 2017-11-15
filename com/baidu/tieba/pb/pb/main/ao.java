package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes.dex */
public class ao {
    public static Intent ac(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        return intent;
    }

    public static boolean k(PostData postData) {
        if (postData == null || postData.buO() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h buO = postData.buO();
        if (buO.gpV) {
            int buo = buO.buo();
            return buo == 2 || buo == 1 || buo == 3;
        }
        return false;
    }

    public static String c(MetaData metaData) {
        if (metaData == null || metaData.getGodUserData() == null) {
            return "";
        }
        String forumName = metaData.getGodUserData().getForumName();
        if ((metaData.getGodUserData().getType() == 2 || metaData.getGodUserData().getType() == 1) && !TextUtils.isEmpty(forumName)) {
            return UtilHelper.getForumNameWithBar(UtilHelper.getFixedBarText(forumName, 5, true, true));
        }
        if (StringUtils.isNull(metaData.getGodIntro())) {
            return "";
        }
        return metaData.getGodIntro();
    }

    public static void w(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(d.h.user_like_success_dialog, (ViewGroup) null);
            com.baidu.tbadk.core.util.aj.i((TextView) inflate.findViewById(d.g.dialog_title), d.C0080d.cp_cont_b);
            com.baidu.tbadk.core.util.aj.i((TextView) inflate.findViewById(d.g.dialog_message), d.C0080d.cp_cont_j);
            aVar.a(d.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.ao.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
            ((ImageView) inflate.findViewById(d.g.dialog_close)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.ao.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.tbadk.core.dialog.a.this != null) {
                        com.baidu.tbadk.core.dialog.a.this.dismiss();
                    }
                }
            });
            aVar.v(inflate);
            aVar.ao(false);
            aVar.b(tbPageContext).th();
        }
    }
}
