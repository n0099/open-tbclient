package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
/* loaded from: classes2.dex */
public class aq {
    public static Intent at(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        Intent intent = new Intent(context, DealIntentService.class);
        intent.putExtra("class", 1);
        intent.putExtra("id", str);
        intent.putExtra("from", "nas");
        intent.putExtra("key_start_from", 5);
        return intent;
    }

    public static boolean k(PostData postData) {
        if (postData == null || postData.byV() == null) {
            return false;
        }
        com.baidu.tieba.tbadkCore.data.h byV = postData.byV();
        if (byV.gVh) {
            int byt = byV.byt();
            return byt == 2 || byt == 1 || byt == 3;
        }
        return false;
    }

    public static void v(TbPageContext tbPageContext) {
        if (tbPageContext != null && tbPageContext.getPageActivity() != null) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(e.h.user_like_success_dialog, (ViewGroup) null);
            com.baidu.tbadk.core.util.al.h((TextView) inflate.findViewById(e.g.dialog_title), e.d.cp_cont_b);
            com.baidu.tbadk.core.util.al.h((TextView) inflate.findViewById(e.g.dialog_message), e.d.cp_cont_j);
            aVar.a(e.j.know, new a.b() { // from class: com.baidu.tieba.pb.pb.main.aq.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
            ((ImageView) inflate.findViewById(e.g.dialog_close)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.main.aq.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (com.baidu.tbadk.core.dialog.a.this != null) {
                        com.baidu.tbadk.core.dialog.a.this.dismiss();
                    }
                }
            });
            aVar.G(inflate);
            aVar.aE(false);
            aVar.b(tbPageContext).yl();
        }
    }
}
