package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.person.data.PersonListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ d cMi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cMi = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.b bVar;
        String str;
        Context context2;
        com.baidu.tieba.person.data.b bVar2;
        com.baidu.tieba.person.data.b bVar3;
        context = this.cMi.mContext;
        if (bj.ah(context)) {
            bVar = this.cMi.cMh;
            if (bVar.isSelf) {
                TiebaStatic.log("person_self_attentionper_click");
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
                av avVar = new av("c10616");
                str = this.cMi.userId;
                TiebaStatic.log(avVar.ab("obj_id", str));
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.cMi.mContext;
            Context applicationContext = context2.getApplicationContext();
            bVar2 = this.cMi.cMh;
            String str2 = bVar2.userId;
            bVar3 = this.cMi.cMh;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(applicationContext, true, str2, bVar3.sex)));
        }
    }
}
