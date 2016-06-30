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
import com.baidu.tieba.person.data.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ h egd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.egd = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        f fVar;
        String str;
        String str2;
        Context context2;
        f fVar2;
        f fVar3;
        context = this.egd.mContext;
        if (bn.ab(context)) {
            fVar = this.egd.egc;
            if (fVar.isSelf) {
                TiebaStatic.log("person_self_attentionme_click");
            } else {
                TiebaStatic.log("person_guid_attentionme_click");
                str = this.egd.userId;
                if (str != null) {
                    ay ayVar = new ay("c10614");
                    str2 = this.egd.userId;
                    TiebaStatic.log(ayVar.ab("obj_id", str2));
                }
            }
            MessageManager messageManager = MessageManager.getInstance();
            context2 = this.egd.mContext;
            fVar2 = this.egd.egc;
            String str3 = fVar2.userId;
            fVar3 = this.egd.egc;
            messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonListActivityConfig(context2, false, str3, fVar3.sex)));
        }
    }
}
