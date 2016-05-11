package com.baidu.tieba.person.a;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e dxC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.dxC = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.c cVar;
        String str;
        Context context2;
        com.baidu.tieba.person.data.c cVar2;
        com.baidu.tieba.person.data.c cVar3;
        context = this.dxC.mContext;
        if (bl.ac(context)) {
            cVar = this.dxC.dxB;
            if (cVar.isSelf) {
                TiebaStatic.log("person_self_attentionper_click");
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
                aw awVar = new aw("c10616");
                str = this.dxC.userId;
                TiebaStatic.log(awVar.ac("obj_id", str));
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dxC.mContext;
            cVar2 = this.dxC.dxB;
            String str2 = cVar2.userId;
            cVar3 = this.dxC.dxB;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, true, str2, cVar3.sex)));
        }
    }
}
