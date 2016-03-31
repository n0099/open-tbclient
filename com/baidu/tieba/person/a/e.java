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
public class e implements View.OnClickListener {
    final /* synthetic */ d duG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.duG = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.b bVar;
        String str;
        Context context2;
        com.baidu.tieba.person.data.b bVar2;
        com.baidu.tieba.person.data.b bVar3;
        context = this.duG.mContext;
        if (bl.ad(context)) {
            bVar = this.duG.duF;
            if (bVar.isSelf) {
                TiebaStatic.log("person_self_attentionper_click");
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
                aw awVar = new aw("c10616");
                str = this.duG.userId;
                TiebaStatic.log(awVar.ac("obj_id", str));
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.duG.mContext;
            bVar2 = this.duG.duF;
            String str2 = bVar2.userId;
            bVar3 = this.duG.duF;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, true, str2, bVar3.sex)));
        }
    }
}
