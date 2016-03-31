package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
import com.baidu.tieba.person.data.PersonListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g duL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.duL = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.e eVar;
        String str;
        String str2;
        Context context2;
        com.baidu.tieba.person.data.e eVar2;
        com.baidu.tieba.person.data.e eVar3;
        context = this.duL.mContext;
        if (bl.ad(context)) {
            eVar = this.duL.duK;
            if (eVar.isSelf) {
                TiebaStatic.log("person_self_attentionme_click");
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
                str = this.duL.userId;
                if (str != null) {
                    aw awVar = new aw("c10614");
                    str2 = this.duL.userId;
                    TiebaStatic.log(awVar.ac("obj_id", str2));
                }
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.duL.mContext;
            eVar2 = this.duL.duK;
            String str3 = eVar2.userId;
            eVar3 = this.duL.duK;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, false, str3, eVar3.sex)));
        }
    }
}
