package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.person.data.PersonListActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ g dah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dah = gVar;
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
        context = this.dah.mContext;
        if (bi.ah(context)) {
            eVar = this.dah.dag;
            if (eVar.isSelf) {
                TiebaStatic.log("person_self_attentionme_click");
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
                str = this.dah.userId;
                if (str != null) {
                    au auVar = new au("c10614");
                    str2 = this.dah.userId;
                    TiebaStatic.log(auVar.aa("obj_id", str2));
                }
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dah.mContext;
            Context applicationContext = context2.getApplicationContext();
            eVar2 = this.dah.dag;
            String str3 = eVar2.userId;
            eVar3 = this.dah.dag;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(applicationContext, false, str3, eVar3.sex)));
        }
    }
}
