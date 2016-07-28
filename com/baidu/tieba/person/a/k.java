package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ j eqe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.eqe = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.g gVar;
        String str;
        String str2;
        Context context2;
        com.baidu.tieba.person.data.g gVar2;
        com.baidu.tieba.person.data.g gVar3;
        context = this.eqe.mContext;
        if (bn.ab(context)) {
            gVar = this.eqe.eqd;
            if (gVar.isSelf) {
                TiebaStatic.log("person_self_attentionme_click");
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
                str = this.eqe.userId;
                if (str != null) {
                    ay ayVar = new ay("c10614");
                    str2 = this.eqe.userId;
                    TiebaStatic.log(ayVar.ab("obj_id", str2));
                }
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.eqe.mContext;
            gVar2 = this.eqe.eqd;
            String str3 = gVar2.userId;
            gVar3 = this.eqe.eqd;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, false, str3, gVar3.sex)));
        }
    }
}
