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
public class e implements View.OnClickListener {
    final /* synthetic */ d efY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.efY = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.c cVar;
        String str;
        Context context2;
        com.baidu.tieba.person.data.c cVar2;
        com.baidu.tieba.person.data.c cVar3;
        context = this.efY.mContext;
        if (bn.ab(context)) {
            cVar = this.efY.efX;
            if (cVar.isSelf) {
                TiebaStatic.log("person_self_attentionper_click");
            } else {
                TiebaStatic.log("person_guid_attentionper_click");
                ay ayVar = new ay("c10616");
                str = this.efY.userId;
                TiebaStatic.log(ayVar.ab("obj_id", str));
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.efY.mContext;
            cVar2 = this.efY.efX;
            String str2 = cVar2.userId;
            cVar3 = this.efY.efX;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, true, str2, cVar3.sex)));
        }
    }
}
