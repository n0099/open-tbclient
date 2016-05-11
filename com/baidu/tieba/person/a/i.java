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
public class i implements View.OnClickListener {
    final /* synthetic */ h dxH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.dxH = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        com.baidu.tieba.person.data.f fVar;
        String str;
        String str2;
        Context context2;
        com.baidu.tieba.person.data.f fVar2;
        com.baidu.tieba.person.data.f fVar3;
        context = this.dxH.mContext;
        if (bl.ac(context)) {
            fVar = this.dxH.dxG;
            if (fVar.isSelf) {
                TiebaStatic.log("person_self_attentionme_click");
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
                str = this.dxH.userId;
                if (str != null) {
                    aw awVar = new aw("c10614");
                    str2 = this.dxH.userId;
                    TiebaStatic.log(awVar.ac("obj_id", str2));
                }
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.dxH.mContext;
            fVar2 = this.dxH.dxG;
            String str3 = fVar2.userId;
            fVar3 = this.dxH.dxG;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, false, str3, fVar3.sex)));
        }
    }
}
